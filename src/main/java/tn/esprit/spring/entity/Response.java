package tn.esprit.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Response {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	private boolean status;
    private String details;
	private String Email;
	private float amount;
	private String token;

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

	@Override
	public String toString() {
		return "Response [status=" + status + ", details=" + details + "]";
	}




    
}
