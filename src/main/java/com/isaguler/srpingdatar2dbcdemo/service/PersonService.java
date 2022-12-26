package com.isaguler.srpingdatar2dbcdemo.service;

import com.isaguler.srpingdatar2dbcdemo.dto.PersonDTO;
import com.isaguler.srpingdatar2dbcdemo.model.Person;
import com.isaguler.srpingdatar2dbcdemo.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    @PostConstruct
    void init() {
        this.createTableInDatabase();
    }

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

    public void createTableInDatabase() {
        log.info("creating a table");

        DatabaseClient.GenericExecuteSpec genericExecuteSpec = r2dbcEntityTemplate
                .getDatabaseClient()
                .sql("CREATE TABLE IF NOT EXISTS person2test (id SERIAL PRIMARY KEY, firstname TEXT NOT NULL, lastname TEXT NOT NULL, age INTEGER NOT NULL)");

        log.info("sql: " + genericExecuteSpec.fetch().rowsUpdated().block());

        log.info("c.p.1");

        Person person = new Person();
        person.setFirstname("test1firstname");
        person.setLastname("test1lastname");
        person.setAge(1L);

        Mono<Person> personMono = r2dbcEntityTemplate.insert(Person.class).using(person);

        log.info("personMono: " + personMono.block());
    }
}
