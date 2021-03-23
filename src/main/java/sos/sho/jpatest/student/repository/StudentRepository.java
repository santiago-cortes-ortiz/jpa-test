package sos.sho.jpatest.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sos.sho.jpatest.student.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {


    Optional<Student> findByFirstName(String studentFirstName);
}
