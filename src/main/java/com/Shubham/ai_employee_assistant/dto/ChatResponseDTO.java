package com.Shubham.ai_employee_assistant.dto;

public class ChatResponseDTO {
	private String response;

	 public ChatResponseDTO() {
	    }
	
	public ChatResponseDTO(String response) {

		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
