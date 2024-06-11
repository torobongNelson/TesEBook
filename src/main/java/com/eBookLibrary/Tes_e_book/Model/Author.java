package com.eBookLibrary.Tes_e_book.Model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
@ToString
public class Author {
//    these fields are based on the values you wish to take from the api you are calling
//    write the fields they way they are on the documentation.
    @Id
    private String id;
    private String name;
    private Long birth_year;
    private Long death_year; //Nullable

}
