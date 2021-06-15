package com.memorystack.dto;

public class ResponseDto {
	
	private boolean status=true;
	private String errorCode;
	private String message;

	public ResponseDto(String errorCode, String message) {
		this.errorCode = errorCode; 
		this.message = message; 
	}
	
	public ResponseDto() {
	}

	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
