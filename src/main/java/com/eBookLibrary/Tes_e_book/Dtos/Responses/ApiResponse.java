package com.eBookLibrary.Tes_e_book.Dtos.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse <T>{
    private T data;


}


