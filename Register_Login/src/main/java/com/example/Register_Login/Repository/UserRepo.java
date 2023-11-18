package com.example.Register_Login.Repository;

import com.example.Register_Login.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Long> {
    @Query("select user from UserModel as user where user.email = ?1 and user.password=?2")
    Optional<UserModel> login(String email, String password);
}
