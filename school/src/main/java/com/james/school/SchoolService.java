package com.james.school;

import com.james.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;
    private final StudentClient client;
    public void saveSchool(School school){
        repository.save(school);
    }

    public List<School> findAllSchools(){
        return repository.findAll();
    }

    public FullSchoolReponse findAllSchoolsWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId)
                                .orElse(
                                        School.builder()
                                        .name("NOT_FOUND")
                                        .email("NOT_FOUND")
                                        .build()
                                );
        var students = client.findAllStudentsBySchool(schoolId);

        return FullSchoolReponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
