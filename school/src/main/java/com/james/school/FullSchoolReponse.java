package com.james.school;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolReponse {
    private String name;
    private String email;
    List<Student> students;
}
