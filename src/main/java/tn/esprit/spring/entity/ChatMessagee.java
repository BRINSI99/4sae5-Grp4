package tn.esprit.spring.entity;

import lombok.Builder;


public class ChatMessagee {

	private String from;
	private String message;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Message [from=" + from + ", message=" + message + "]";
	}
	
	
	

}
