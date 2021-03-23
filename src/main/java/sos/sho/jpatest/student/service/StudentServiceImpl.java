package sos.sho.jpatest.student.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sos.sho.jpatest.student.model.Student;
import sos.sho.jpatest.student.repository.StudentRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Long save(Student student) {
        Student studentSave = studentRepository.save(student);
        return student.getId();
    }

    @Override
    public Optional<Student> findStudentById(Long studentId) {
        return studentRepository.findById(studentId);

    }

    @Override
    public Optional<Student> findByFirstName(String studentFirstName) {
        return studentRepository.findByFirstName(studentFirstName);
    }
}
