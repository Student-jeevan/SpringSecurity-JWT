package com.SpringSecurity.jeevansingh.controller;

import com.SpringSecurity.jeevansingh.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class StudentController {
    private List<Student> list = new ArrayList<>(List.of(
            new Student(1, "jeevan", 23),
            new Student(3, "jai", 34),
            new Student(2, "ram", 54)
    ));
    @GetMapping("/student")
    public List<Student> GetStudents() {
        return list;
    }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student obj) {
        list.add(obj);
        return obj;
    }
}
