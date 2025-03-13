package com.example.sample.project.service;

import com.example.sample.project.domain.UserLogin;
import com.example.sample.project.repository.UserLoginRepository;
import com.example.sample.project.requests.PatchRequest;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserLoginService {

    @Autowired
    UserLoginRepository userLoginRepository;

//    Saving the user login info (POST/SAVE)
    @Transactional
    public UserLogin saveUserLogin(UserLogin userLogin) {
        return userLoginRepository.save(userLogin);
    }

//    Getting the user login info (GET/READ)
    public Optional<UserLogin> getUserLogin(String UserID){
        return userLoginRepository.findById(UserID);
    }

//    Updating the user login info (PATCH/UPDATE)
    @Transactional
    public Object updateUserLogin(String id, List<PatchRequest> update){
        UserLogin userLogin = Optional.ofNullable(userLoginRepository.findByUserId(id))
                .orElseThrow(() -> new ObjectNotFoundException(Optional.of("User not found with ID: "),id));
        for (PatchRequest patchRequest : update) {
           if(patchRequest.getName().equals("password")){
               userLogin.setPassword(patchRequest.getValue());
           } else if (patchRequest.getName().equals("userName")) {
               userLogin.setUserName(patchRequest.getValue());
           }else{
               return new IllegalArgumentException("");
           }
        }
        return userLoginRepository.save(userLogin);
    }

//    Delete the user login info (DELETE/REMOVE)
    @Transactional
    public void deleteUserLoginInfo(String userLogin){
        userLoginRepository.deleteById(userLogin);
    }
}
