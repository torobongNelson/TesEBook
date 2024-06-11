package com.eBookLibrary.Tes_e_book.Service;

import com.eBookLibrary.Tes_e_book.Dtos.Responses.BookResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void fetchBook(){
        String url = "https://gutendex.com/books/?search=oliver";
        BookResponse bookResponse = bookService.viewBooks(url);
        //getResults() is a method in ResponseEntity<> to get the data of the api yu had called
        //getFirst() is a method in the list to get the first book on the list
        System.out.println(bookResponse.getResults().getFirst());
        assertNotNull(bookResponse);
    }

}