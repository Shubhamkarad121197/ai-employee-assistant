package com.Shubham.ai_employee_assistant.service.impl;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.Shubham.ai_employee_assistant.dto.ChatRequestDTO;
import com.Shubham.ai_employee_assistant.dto.ChatResponseDTO;
import com.Shubham.ai_employee_assistant.service.AiChatService;
import com.Shubham.ai_employee_assistant.service.EmployeeTools;


@Service
public class AiChatServiceImpl implements AiChatService{
	

	private final ChatClient chatClient;
	private final EmployeeTools employeeTools;
	
	public AiChatServiceImpl(ChatClient.Builder chatClientBuilder , EmployeeTools employeeTools) {
		this.chatClient=chatClientBuilder.build();
		this.employeeTools=employeeTools;
	}
	
	@Override
	public ChatResponseDTO chat(ChatRequestDTO request) {
		String response=chatClient
				.prompt()
				.user(request.getMessage())
				.tools(employeeTools)
				.call()
				.content();
		
		return new ChatResponseDTO(response);
	}
}
