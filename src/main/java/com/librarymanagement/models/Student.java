package com.librarymanagement.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true,nullable = false)
    private String contact;
    private String address;
    @Column(unique = true,nullable = false)
    private String email;
    @Enumerated(value = EnumType.STRING)
    private AccountStatus accountStatus;

    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;
    @OneToMany(mappedBy = "student")
    private List<Book> bookList;
    @OneToMany(mappedBy = "student")
    private List<Transaction> transactionList;

}
