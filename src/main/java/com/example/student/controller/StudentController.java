package com.example.student.controller;

import com.example.student.dto.StudentDto;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@RequestMapping("/api/student/")
public class StudentController {

    private StudentRepository studentRepository;
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.createStudent(student));
    }

    @GetMapping("studentId/{postId}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long studentId){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(studentId));
    }

    @GetMapping("students")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }
}