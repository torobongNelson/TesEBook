package com.eBookLibrary.Tes_e_book.Repository;

import com.eBookLibrary.Tes_e_book.Model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {

}
