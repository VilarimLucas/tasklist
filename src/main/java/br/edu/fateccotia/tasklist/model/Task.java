package br.edu.fateccotia.tasklist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private TaskStatus status;
	private String descrition;
	
	public Task() {
		
	}
	
	public Task(Integer id, TaskStatus status, String descrition) {
		super();
		this.id = id;
		this.status = status;
		this.descrition = descrition;
	}
	
	public Integer getId() {

		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}

}
