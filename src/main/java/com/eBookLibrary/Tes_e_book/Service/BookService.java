package com.eBookLibrary.Tes_e_book.Service;

import com.eBookLibrary.Tes_e_book.Dtos.Responses.BookResponse;
import com.eBookLibrary.Tes_e_book.Interface.BookServiceInterface;
import com.eBookLibrary.Tes_e_book.Model.Book;
import com.eBookLibrary.Tes_e_book.Repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService implements BookServiceInterface {
    private final BookRepository bookRepository;
    private  final Map<String ,List<Book> > readingList;

  public BookService(BookRepository bookRepository){
      this.bookRepository = bookRepository;
      readingList = new HashMap<>();
  }

    @Override
    public Book viewABook(String id) {
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
    }

    @Override
    public BookResponse viewBooks(String url) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BookResponse> bookResponse = restTemplate.getForEntity(url, BookResponse.class);
        return bookResponse.getBody();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void addToReadingList(Book book, String userId) {
        List<Book> userReadingList = readingList.computeIfAbsent(userId, k -> new ArrayList<>());
        userReadingList.add(book);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
}
