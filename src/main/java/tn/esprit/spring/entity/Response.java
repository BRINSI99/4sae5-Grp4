package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Response {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	private boolean status;
    private String details;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Response() {
		super();
		this.status = true;
	}

	public Response(boolean status, String details) {
		super();
		this.status = status;
		this.details = details;
	}

	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", details=" + details + "]";
	}
	
	
	
    
    
}
