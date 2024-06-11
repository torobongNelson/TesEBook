package com.eBookLibrary.Tes_e_book.Dtos.Responses;

import com.eBookLibrary.Tes_e_book.Model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BookResponse {
    private String count;
    private String previous;
    private String next;
    private List<Book> results;
}
