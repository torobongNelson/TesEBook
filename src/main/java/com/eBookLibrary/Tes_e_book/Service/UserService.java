package com.eBookLibrary.Tes_e_book.Service;

import com.eBookLibrary.Tes_e_book.Dtos.Requests.LoginRequest;
import com.eBookLibrary.Tes_e_book.Dtos.Requests.UpdateUserRequest;
import com.eBookLibrary.Tes_e_book.Dtos.Requests.UserRequest;
import com.eBookLibrary.Tes_e_book.Dtos.Responses.UpdateUserResponse;
import com.eBookLibrary.Tes_e_book.Dtos.Responses.UserResponse;
import com.eBookLibrary.Tes_e_book.Exceptions.InvalidCredentialsException;
import com.eBookLibrary.Tes_e_book.Exceptions.UnregcognisedUserException;
import com.eBookLibrary.Tes_e_book.Interface.UserServiceInterface;
import com.eBookLibrary.Tes_e_book.Model.User;
import com.eBookLibrary.Tes_e_book.Repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

//    public  User getUserById(String id){
//        return this.userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Unknown user"));
//
//    }

    public User getUserByEmail(String email){

        return userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        User newUser = new User();
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(encoder.encode(request.getPassword()));

        userRepository.save(newUser);

        UserResponse response = new UserResponse();
        response.setFirstName(request.getFirstName());
        response.setLastName(request.getLastName());
        response.setEmail(request.getEmail());

        return response;
    }


    @Override
    public UserResponse loginUser(LoginRequest request) {
        User myUser = getUserByEmail(request.getEmail());

        if(myUser!=null){
            if(encoder.matches(request.getPassword(), myUser.getPassword())){

                UserResponse loggedInUser = new UserResponse();
                loggedInUser.setFirstName(myUser.getFirstName());
                loggedInUser.setLastName(myUser.getLastName());
                loggedInUser.setEmail(myUser.getEmail());
                loggedInUser.setMessage("Welcome Buddy!");

                myUser.setOnline(true);
                System.out.println("Leo is Online");

                return loggedInUser;
            }else {
                throw new InvalidCredentialsException("Incomplete credentials");
            }

        } else{
            throw new UnregcognisedUserException("Unrecognized user!");
        }
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest request) {
        User updateUser = new User();
            if(request.getEmail() != null){
                updateUser.setFirstName(request.getFirstName());
                updateUser.setLastName(request.getLastName());
                updateUser.setPassword(encoder.encode(request.getPassword()));

            }else{
                System.out.println("welcome");
            }

       return new UpdateUserResponse();

    }


    @Override
    public void logOutUser(User user) {
        if(user.isOnline()){
                user.setOnline(false);
                System.out.println("Good-bye" + user.getFirstName() );
        }else {
                System.out.println(user.getFirstName() + "is Online");
            }

        }
    }




