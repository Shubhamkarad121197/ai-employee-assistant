package com.Shubham.ai_employee_assistant.service.impl;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.Shubham.ai_employee_assistant.dto.ChatRequestDTO;
import com.Shubham.ai_employee_assistant.dto.ChatResponseDTO;
import com.Shubham.ai_employee_assistant.service.AiChatService;


@Service
public class AiChatServiceImpl implements AiChatService{
	

	private final ChatClient chatClient;
	
	public AiChatServiceImpl(ChatClient.Builder chatClientBuilder) {
		this.chatClient=chatClientBuilder.build();
	}
	
	@Override
	public ChatResponseDTO chat(ChatRequestDTO request) {
		String response=chatClient
				.prompt()
				.user(request.getMessage())
				.call()
				.content();
		
		return new ChatResponseDTO(response);
	}
}
