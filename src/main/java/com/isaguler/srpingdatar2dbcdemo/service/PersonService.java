package com.isaguler.srpingdatar2dbcdemo.service;

import com.isaguler.srpingdatar2dbcdemo.dto.PersonDTO;
import com.isaguler.srpingdatar2dbcdemo.model.Person;
import com.isaguler.srpingdatar2dbcdemo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Calendar;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Mono<Person> save(PersonDTO personDTO) {
        return personRepository.save(
                Person.builder()
                        .id(Calendar.getInstance().getTimeInMillis())
                        .firstname(personDTO.getFirstname())
                        .lastname(personDTO.getLastname())
                        .age(personDTO.getAge())
                        .build());

    }

    public void delete(Long personId) {
        personRepository.deleteById(personId).block();
    }
}
