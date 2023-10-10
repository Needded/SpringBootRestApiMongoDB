package com.example.demo.controller;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The `StudentRepository` interface serves as a repository for accessing and managing student entities in a MongoDB database.
 */
@Repository
public interface StudentRepository extends MongoRepository <Students,String>{

}
