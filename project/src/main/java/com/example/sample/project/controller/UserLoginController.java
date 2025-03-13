package com.example.sample.project.controller;

import com.example.sample.project.domain.UserLogin;
import com.example.sample.project.requests.PatchRequest;
import com.example.sample.project.service.UserLoginService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;

    @PostMapping("UserLoginInfo")
    public UserLogin saveUserLoginInfo(@RequestBody UserLogin userLogin){
        return userLoginService.saveUserLogin(userLogin);
    }

    @GetMapping("UserLoginInfo")
    public Optional<UserLogin> getUserLoginInfo(@Schema(example = "abc123") @RequestParam String UserId){
        return userLoginService.getUserLogin(UserId);
    }

    @PatchMapping("UserLoginInfo/{userId}")
    public  Object updateUserLoginInfo(@PathVariable("userId") String userid, @RequestBody List<PatchRequest> update){
        return userLoginService.updateUserLogin(userid,update);
    }

    @DeleteMapping("UserLoginInfo/{userId}")
    public String removeUserLoginInfo(@PathVariable("userId") @Schema(example = "abc123") String userid){
        userLoginService.deleteUserLoginInfo(userid);
        return "Delete Sucessfully";
    }
}
