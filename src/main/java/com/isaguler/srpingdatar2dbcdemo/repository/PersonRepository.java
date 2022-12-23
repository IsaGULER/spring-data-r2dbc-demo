package com.isaguler.srpingdatar2dbcdemo.repository;

import com.isaguler.srpingdatar2dbcdemo.model.Person;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends R2dbcRepository<Person, Long>{
}
