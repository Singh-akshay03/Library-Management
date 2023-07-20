package com.librarymanagement.repositories;

import com.librarymanagement.models.Book;
import com.librarymanagement.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByName(String  name);

    List<Book> findByAuthor_Name(String authorName);

    List<Book> findByGenre(Genre genre);
}
