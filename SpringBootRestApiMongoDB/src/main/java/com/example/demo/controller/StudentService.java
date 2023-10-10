package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.StudentController.Entity;

/**
 * The `StudentService` class is a service responsible for handling operations related to student entities.
 */
@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	 /**
     * Retrieves a list of all student entities from the repository.
     *
     * @return A list of student entities.
     */
	public List<Students> getStudents() {
		return repository.findAll();
	}

	/**
     * Creates a new student entity based on the provided data.
     *
     * @param entity The data for the student entity to be created.
     */
	public void createStudents(Entity entity) {
		
		if(entity==null) {
			System.out.println("No student found");
			throw new IllegalStateException("No student found");
		}
		Students students=new Students();
		students.setName(entity.name());
		students.setAge(entity.age());
		
		repository.save(students);
	}

	/**
     * Updates an existing student entity with the provided data.
     *
     * @param entity The updated data for the student entity.
     * @param id     The unique identifier of the student to be updated.
     */
	public void updateStudent(Entity entity, String id) {
		
		if(entity==null) {
			System.out.println("No student found");
			throw new IllegalStateException("No student found");
		}
		
		Optional<Students> find =Optional.of(repository.findById(id).orElseThrow(()-> new NoSuchElementException()));
		
		Students students=new Students();
		students=find.get();
		students.setName(entity.name());
		students.setAge(entity.age());
		
		repository.save(students);
		
	}

	 /**
     * Deletes a student entity by its unique identifier.
     *
     * @param id The unique identifier of the student to be deleted.
     */
	public void deleteStudents(String id) {
		
		verify(id);
		repository.deleteById(id);
		
	}
	
	/**
     * Verifies if a student entity with the given ID exists in the repository.
     *
     * @param id The unique identifier of the student to be verified.
     */
    public void verify (String id) {
		
		boolean exist = repository.existsById(id);
		
		if(exist) {
			return;
		}else {
			System.out.println("Student with id"+ id +"does not exists.");
			throw new NoSuchElementException("Student with id"+ id +"does not exists.");
		      }
	}
	
}
