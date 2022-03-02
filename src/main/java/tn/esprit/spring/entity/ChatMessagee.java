package tn.esprit.spring.entity;

import lombok.Builder;

@Builder
public class ChatMessagee {

	private MessageType type;
	private String content;
	private String sender;
	private String time;
	
	
	public MessageType getType() {
		return type;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getSender() {
		return sender;
	}
	
	public String getTime() {
		return time;
	}
	
	
	

}
