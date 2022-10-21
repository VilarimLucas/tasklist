package br.edu.fateccotia.tasklist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fateccotia.tasklist.model.Task;
import br.edu.fateccotia.tasklist.repository.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public Task save(Task task) {
		return this.taskRepository.save(task);
	}
	
	public List<Task> findAll(){
		return this.taskRepository.findAll();	
		}

	public Optional<Task> findById(Integer id) {
		return this.taskRepository.findById(id);
	}
	
	public void delete(Integer id) {
		taskRepository.deleteById(id);
	}
}
