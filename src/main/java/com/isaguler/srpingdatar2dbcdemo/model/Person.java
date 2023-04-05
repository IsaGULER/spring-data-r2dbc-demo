package com.isaguler.srpingdatar2dbcdemo.model;

import com.isaguler.srpingdatar2dbcdemo.dto.PersonDTO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private Long age;

    public static Person converter(PersonDTO personDTO) {
        Person person = new Person();
        person.setFirstname(personDTO.getFirstname());
        person.setLastname(personDTO.getLastname());
        person.setAge(personDTO.getAge());

        return person;
    }

}
