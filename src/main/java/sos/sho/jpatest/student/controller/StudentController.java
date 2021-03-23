package sos.sho.jpatest.student.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sos.sho.jpatest.student.model.Student;
import sos.sho.jpatest.student.service.StudentService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<HttpHeaders> addStudent(@RequestBody Student student){
        Long id = studentService.save(student);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/student/"+id);
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> findById(@PathVariable("studentId") Long id){
        Optional<Student> student = studentService.findStudentById(id);
        if (student.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/student/"+id);
            return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(student.get(),HttpStatus.OK);
        }
    }
    @GetMapping("/firstName/{studentByName}")
    public ResponseEntity<Student> findStudentByFirstName(@PathVariable("studentByName") String firstName){
        Optional<Student> student = studentService.findByFirstName(firstName);
        if (student.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/student/"+firstName);
            return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(student.get(),HttpStatus.OK);
        }
    }

}
