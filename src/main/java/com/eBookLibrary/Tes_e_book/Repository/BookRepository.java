package com.eBookLibrary.Tes_e_book.Repository;


import com.eBookLibrary.Tes_e_book.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String>{

    @Query("{ 'title' : ?0 }")
    Book findByTitle(String title);
}
