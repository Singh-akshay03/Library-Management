package com.librarymanagement.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;
    private double payment;

    @ManyToOne
    @JoinColumn
    private Book book;
    @ManyToOne
    @JoinColumn
    private Student student;
    @CreationTimestamp
    private Date transictionDate;


}
