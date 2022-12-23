package com.isaguler.srpingdatar2dbcdemo.controller;

import com.isaguler.srpingdatar2dbcdemo.dto.PersonDTO;
import com.isaguler.srpingdatar2dbcdemo.model.Person;
import com.isaguler.srpingdatar2dbcdemo.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
@Slf4j
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PutMapping("/save")
    public Mono<Person> save(@RequestBody PersonDTO personDTO) {
        try {
            return personService.save(personDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    @PutMapping("/delete")
    public void delete(@RequestParam Long id) {
        try {
            personService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
