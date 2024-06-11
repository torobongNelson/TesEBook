package com.eBookLibrary.Tes_e_book.Interface;

import com.eBookLibrary.Tes_e_book.Dtos.Responses.BookResponse;
import com.eBookLibrary.Tes_e_book.Model.Book;

public interface BookServiceInterface {
    Book viewABook(String id);
    BookResponse viewBooks(String url);
    Book addBook(Book book);
    void addToReadingList(Book book, String  userId);


    void deleteBook(String id);


}
