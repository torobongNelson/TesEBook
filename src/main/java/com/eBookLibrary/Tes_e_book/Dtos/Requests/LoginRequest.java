package com.eBookLibrary.Tes_e_book.Dtos.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String email;
    private String password;
}
