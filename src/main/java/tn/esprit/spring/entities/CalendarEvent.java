package tn.spring.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 
@Entity
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalendarEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String title;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime eventDateTime;
	private String location;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<User> attendees;
	private LocalDateTime reminderDateTime;
	private boolean reminderSent;
	
	 
}
