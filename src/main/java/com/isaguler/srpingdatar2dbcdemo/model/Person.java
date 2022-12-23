package com.isaguler.srpingdatar2dbcdemo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "person")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private Long age;
}
