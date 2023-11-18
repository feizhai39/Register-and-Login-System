package com.example.Register_Login.Service;

import com.example.Register_Login.Model.UserModel;
import com.example.Register_Login.Repository.UserRepo;
import com.example.Register_Login.Request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public List<UserModel> getAllUsers() {
        return userRepo.findAll();
    }

    public void createUser(UserRequest userRequest) {
        UserModel userModel = new UserModel();
        userModel.setEmail(userRequest.getEmail());
        userModel.setName(userRequest.getName());
        userModel.setPassword(userRequest.getPassword());
        userModel.setAvatar(userRequest.getAvatar());
        userRepo.save(userModel);//will insert the data in the table
    }

    public Boolean login(String email,String password) throws Exception{
        UserModel userModel = userRepo.login(email,password).orElseThrow(()->new Exception("No User Found"));
        return true;
    }

    public void userUpdate(UserRequest userRequest) throws Exception{
        UserModel userModel = userRepo.findById(userRequest.getId()).orElseThrow(()->new Exception("No user found"));
        if(Objects.nonNull(userRequest.getName())){
            userModel.setName(userRequest.getName());
        }
        if(Objects.nonNull(userRequest.getEmail())){
            userModel.setName(userRequest.getEmail());
        }
        userRepo.save(userModel);//will update the data in the table
    }

    public void userDelete(UserRequest userRequest) throws Exception{
        UserModel userModel = userRepo.findById(userRequest.getId()).orElseThrow(()->new Exception("No user found"));
        if(Objects.nonNull(userRequest.getName())){
            userModel.setName(userRequest.getName());
        } else if(Objects.nonNull(userRequest.getEmail())){
            userModel.setName(userRequest.getEmail());
        }
        userRepo.delete(userModel);//will delete the userRow in the table
    }

    public void deleteUser(Long userId)throws Exception{
        try{
            UserModel userModel = userRepo.findById(userId).orElseThrow(()->new Exception("No User Found"));
            userRepo.delete(userModel);
        }catch (Exception e){
            throw e;
        }
    }
}

