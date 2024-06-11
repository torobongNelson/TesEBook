package com.eBookLibrary.Tes_e_book.Service;

import com.eBookLibrary.Tes_e_book.Interface.AuthorServiceInterface;
import com.eBookLibrary.Tes_e_book.Model.Author;
import com.eBookLibrary.Tes_e_book.Repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements AuthorServiceInterface {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
}
