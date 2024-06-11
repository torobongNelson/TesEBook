package com.eBookLibrary.Tes_e_book.Controller;

import com.eBookLibrary.Tes_e_book.Dtos.Responses.BookResponse;
import com.eBookLibrary.Tes_e_book.Model.Book;
import com.eBookLibrary.Tes_e_book.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/api/fetchApi")
        public ResponseEntity<BookResponse> fetchData(){
        String apiUrl = "https://gutendex.com/books/?search=oliver";
        return new ResponseEntity<>(bookService.viewBooks(apiUrl), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBooks(@RequestBody Book book){
        Book createdBook = bookService.addBook(book);
        return  new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }
}
