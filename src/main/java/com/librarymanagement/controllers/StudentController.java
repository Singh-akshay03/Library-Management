package com.librarymanagement.controllers;

import com.librarymanagement.models.Book;
import com.librarymanagement.request.StudentCreateRequest;
import com.librarymanagement.services.BookFilterType;
import com.librarymanagement.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest){
        studentService.create(studentCreateRequest);
    }


}
