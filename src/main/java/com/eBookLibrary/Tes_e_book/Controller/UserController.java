package com.eBookLibrary.Tes_e_book.Controller;


import com.eBookLibrary.Tes_e_book.Dtos.Requests.LoginRequest;
import com.eBookLibrary.Tes_e_book.Dtos.Requests.UserRequest;
import com.eBookLibrary.Tes_e_book.Dtos.Responses.UserResponse;
import com.eBookLibrary.Tes_e_book.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<UserResponse>createUser(@RequestBody UserRequest request){
        UserRequest newUser = new UserRequest();
        UserResponse createdUser = userService.createUser(newUser);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
}

//    Public ResponseEntity<UserResponse>loginUser(@RequestBody LoginRequest request){





