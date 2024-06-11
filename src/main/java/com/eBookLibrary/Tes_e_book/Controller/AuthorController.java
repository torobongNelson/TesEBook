package com.eBookLibrary.Tes_e_book.Controller;

import com.eBookLibrary.Tes_e_book.Model.Author;
import com.eBookLibrary.Tes_e_book.Service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/create")



public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService)    {
        this.authorService = authorService;
    }

   @PostMapping("/createAuthor")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author createdAuthor = authorService.createAuthor(author);
        return  new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
   }

}
