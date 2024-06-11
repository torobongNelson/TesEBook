package com.eBookLibrary.Tes_e_book.Exceptions;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String message){
        super(message);
    }
}
