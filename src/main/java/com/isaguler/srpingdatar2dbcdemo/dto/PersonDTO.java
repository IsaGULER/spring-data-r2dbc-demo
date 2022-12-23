package com.isaguler.srpingdatar2dbcdemo.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class PersonDTO {

    private String firstname;
    private String lastname;
    private Long age;
}
