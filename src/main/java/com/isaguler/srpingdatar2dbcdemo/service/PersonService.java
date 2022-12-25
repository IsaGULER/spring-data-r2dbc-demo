package com.isaguler.srpingdatar2dbcdemo.service;

import com.isaguler.srpingdatar2dbcdemo.dto.PersonDTO;
import com.isaguler.srpingdatar2dbcdemo.model.Person;
import com.isaguler.srpingdatar2dbcdemo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Mono<Person> save(PersonDTO personDTO) {
        Person person = new Person();
        person.setFirstname(personDTO.getFirstname());
        person.setLastname(personDTO.getLastname());
        person.setAge(personDTO.getAge());

        return personRepository.save(person);

    }

    public void delete(Long personId) {
        personRepository.deleteById(personId).block();
    }
}
