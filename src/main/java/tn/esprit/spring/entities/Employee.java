package tn.spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int com) {
		this.age = com;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
