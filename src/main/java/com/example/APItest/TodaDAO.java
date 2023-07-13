package com.example.APItest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodaDAO extends CrudRepository<Todo, Integer> {

}
