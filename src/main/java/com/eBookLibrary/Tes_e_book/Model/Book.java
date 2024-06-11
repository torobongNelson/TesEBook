package com.eBookLibrary.Tes_e_book.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
@ToString
public class  Book{
    @Id
    private Long id;
    private String title;
    private String description;
    private List<Author> authors;
    private List<String> subjects;
    private List<String> languages;


}
