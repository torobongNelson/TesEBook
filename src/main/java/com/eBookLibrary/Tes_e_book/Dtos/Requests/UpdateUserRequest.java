package com.eBookLibrary.Tes_e_book.Dtos.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
