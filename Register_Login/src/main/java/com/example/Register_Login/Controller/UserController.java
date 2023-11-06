package com.example.Register_Login.Controller;

import com.example.Register_Login.Model.UserModel;
import com.example.Register_Login.Request.UserRequest;
import com.example.Register_Login.Response.UserResponse;
import com.example.Register_Login.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("list")
    public ResponseEntity<List<UserModel>> getUserList(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){
        userService.createUser(userRequest);
        UserResponse userResponse = new UserResponse();
        userResponse.setMessage("User is created..");
        return ResponseEntity.ok(userResponse);
    }
    @PostMapping("update")
    public ResponseEntity<?> updateUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        try{
            userService.userUpdate(userRequest);
            userResponse.setMessage("User is updated..");
            return ResponseEntity.ok(userResponse);
        }catch(Exception e){
            userResponse.setMessage("Error "+ e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }

    @PostMapping("delete")
    public ResponseEntity<?> deleteUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        try{
            userService.userDelete(userRequest);
            userResponse.setMessage("Admin approved! User is deleted..");
            return ResponseEntity.ok(userResponse);
        }catch(Exception e){
            userResponse.setMessage("Error "+ e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }


}
