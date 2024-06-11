package com.eBookLibrary.Tes_e_book.Dtos.Requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthRequest {
    private String userName;
    private String password;
}
