package br.edu.fateccotia.tasklist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateccotia.tasklist.model.Task;
import br.edu.fateccotia.tasklist.service.TaskService;

@RestController
@RequestMapping("/tasks")

public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll(){
//		List<Task> list = new ArrayList<Task>();
//		list.add(new Task(1, TaskStatus.PENDING, "Atividade 1"));
//		list.add(new Task(2, TaskStatus.PENDING, "Atividade 2"));
//		list.add(new Task(3, TaskStatus.PENDING, "Atividade 3"));
//		list.add(new Task(4, TaskStatus.PENDING, "Atividade 4"));
		List<Task> list = taskService.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> find(@PathVariable(name="id")Integer id) {
		Optional<Task> task = this.taskService.findById(id);
		if(task.isPresent()) {
			return ResponseEntity.ok(task.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> edit(@PathVariable(name = "id") Integer id, @RequestBody Task task){
		Optional<Task> taskActual=this.taskService.findById(id);
		if(taskActual.isPresent()) {
			taskActual.get().setDescrition(task.getDescrition());
			taskActual.get().setStatus(task.getStatus());
			return ResponseEntity.ok(this.taskService.save(taskActual.get()));
		}else {
			return ResponseEntity.notFound().build();
		} 
	}
	
	@PostMapping
	public ResponseEntity<Task> create(@RequestBody Task task){
		Task created = taskService.save(task);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") Integer id){
		taskService.delete(id);
		return ResponseEntity.ok(null);
	}
	
}
