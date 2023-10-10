package com.example.demo.controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The `Students` class represents a student entity and is annotated as a MongoDB document.
 */
@Document
public class Students {
	
	@Id
	private String id;
	private String name;
	private Integer age;
	
	public Students(){}
	
	/**
     * Constructor to initialize a `Students` object with a name and age.
     *
     * @param name The name of the student.
     * @param age  The age of the student.
     */
	public Students(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
