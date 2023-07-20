package com.librarymanagement.services;

import com.librarymanagement.models.Author;
import com.librarymanagement.models.Book;
import com.librarymanagement.models.Genre;
import com.librarymanagement.repositories.AuthorRepository;
import com.librarymanagement.repositories.BookRepository;
import com.librarymanagement.request.BookCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;
    public void  create(BookCreateRequest bookCreateRequest){
        Book book= bookCreateRequest.to();
        Author author=book.getAuthor();

        //find if the author with this mail already exist in the db?
        // If exist then don't save otherwise save in the db
        // select * from author where email=?;

        Author authorFromDb=authorRepository.findAuthorByEmailJPQLQuery(author.getEmail());

        if(authorFromDb==null){
            authorFromDb=authorRepository.save(author);
        }else{

        }
        book.setAuthor(authorFromDb);
        bookRepository.save(book);
    }

    public List<Book> find(BookFilterType bookFilterType,String value){
        switch (bookFilterType){
            case NAME:
                return bookRepository.findByName(value);
            case AUTHOR_NAME:
                return bookRepository.findByAuthor_Name(value);
            case GENRE:
                return bookRepository.findByGenre(Genre.valueOf(value));
            default:
                return  new ArrayList<>();
        }
    }


}
