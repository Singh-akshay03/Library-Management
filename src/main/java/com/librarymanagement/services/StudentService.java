package com.librarymanagement.services;

import com.librarymanagement.models.Book;
import com.librarymanagement.models.Student;
import com.librarymanagement.repositories.StudentRepository;
import com.librarymanagement.request.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public void create(StudentCreateRequest studentCreateRequest) {
        Student student = studentCreateRequest.to();
        studentRepository.save(student);
    }

    // GET -- filter functionality / search


}
