package com.librarymanagement.repositories;

import com.librarymanagement.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    //*--Native Query
    //*--JPQL-Java persistence query language
    // JPQL IS BETTER BECAUSE APPLICATION WILL NOT START IF THE QUERY IS WRONG
    // You don't have to even write a query.....

    public void findByEmail(String email);

    @Query(value="select * from author  where email= ?1",nativeQuery = true)
    public Author findAuthorByEmailNativeQuery(String email);

    @Query("SELECT a FROM Author a WHERE a.email=?1")
    public Author findAuthorByEmailJPQLQuery(String email);



    //you need to find all the authors in give country
    @Query(value = "select a from author a where a.country=?1",nativeQuery = true)
    public List<Author> getAuthorByCountryNativeQuery(String country);

    @Query("SELECT a FROM Author a WHERE a.country = ?1")
    public List<Author> getAuthorByCountryJPQLQuery(String country);

}
