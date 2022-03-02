package tn.esprit.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Response {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
