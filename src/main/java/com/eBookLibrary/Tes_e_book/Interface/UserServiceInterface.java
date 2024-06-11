package com.eBookLibrary.Tes_e_book.Interface;

import com.eBookLibrary.Tes_e_book.Dtos.Requests.LoginRequest;
import com.eBookLibrary.Tes_e_book.Dtos.Requests.UpdateUserRequest;
import com.eBookLibrary.Tes_e_book.Dtos.Requests.UserRequest;
import com.eBookLibrary.Tes_e_book.Dtos.Responses.LoginAUserResponse;
import com.eBookLibrary.Tes_e_book.Dtos.Responses.UpdateUserResponse;
import com.eBookLibrary.Tes_e_book.Dtos.Responses.UserResponse;
import com.eBookLibrary.Tes_e_book.Model.User;

public interface UserServiceInterface {

  UserResponse createUser(UserRequest request);
  UserResponse loginUser(LoginRequest request);

  UpdateUserResponse updateUser(UpdateUserRequest request);

  void logOutUser(User user);

}


