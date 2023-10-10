package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The `StudentController` class is a RESTful controller responsible for handling HTTP requests related to student entities.
 */
@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	 /**
     * Handles HTTP GET requests to retrieve a list of students.
     *
     * @return A list of student entities.
     */
	@GetMapping
	public List<Students> get(){
		return service.getStudents();
	}
	
	/**
     * Handles HTTP POST requests to create a new student entity.
     *
     * @param entity The student entity to be created.
     */
	@PostMapping
	public void create(@RequestBody Entity entity ) {
		service.createStudents(entity);
	}

	 /**
     * Handles HTTP PUT requests to update an existing student entity.
     *
     * @param entity The updated student entity.
     * @param id     The unique identifier of the student to be updated.
     */
	@PutMapping(path=("/{id}"))
	public void update(@RequestBody Entity entity, @PathVariable("id") String id ) {
		service.updateStudent(entity,id);
	}
	
	 /**
     * Handles HTTP DELETE requests to delete a student entity by its unique identifier.
     *
     * @param id The unique identifier of the student to be deleted.
     */
	@DeleteMapping(path=("/{id}"))
	public void delete(@PathVariable("id") String id) {
		service.deleteStudents(id);
	}
	
	/**
     * Represents a data structure for a student entity.
     */
	record Entity(String name,int age) {}
}
