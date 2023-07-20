package com.librarymanagement.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private  String country;
    private int age;
    @Column(unique = true,nullable = false)
    private String email;
    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    private List<Book> bookList;

    private Date addedOn;
}
