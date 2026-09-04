package com.Shubham.ai_employee_assistant.service;

import com.Shubham.ai_employee_assistant.dto.ChatRequestDTO;
import com.Shubham.ai_employee_assistant.dto.ChatResponseDTO;

public interface  AiChatService {
	ChatResponseDTO  chat(ChatRequestDTO request); 
}
