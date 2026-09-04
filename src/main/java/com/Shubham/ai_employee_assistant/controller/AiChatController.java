package com.Shubham.ai_employee_assistant.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shubham.ai_employee_assistant.dto.ChatRequestDTO;
import com.Shubham.ai_employee_assistant.dto.ChatResponseDTO;
import com.Shubham.ai_employee_assistant.service.AiChatService;

@RestController
@RequestMapping("/api/ai")
public class AiChatController {
	
	private final AiChatService aiChatService;
	
	public AiChatController(AiChatService aiChatService) {
		this.aiChatService=aiChatService;
	}
	
	@PostMapping("/chat")
	public ChatResponseDTO chat(@RequestBody ChatRequestDTO request) {
		return aiChatService.chat(request);
		
	}
}
