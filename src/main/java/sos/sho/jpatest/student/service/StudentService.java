package sos.sho.jpatest.student.service;

import sos.sho.jpatest.student.model.Student;

import java.util.Optional;

public interface StudentService {
    Long save(Student student);
    Optional<Student> findStudentById(Long studentId);
    Optional<Student> findByFirstName(String studentFirstName);

}
