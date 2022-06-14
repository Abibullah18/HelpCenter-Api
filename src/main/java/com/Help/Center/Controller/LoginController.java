package com.Help.Center.Controller;

import com.Help.Center.Models.Users;
import com.Help.Center.Repository.UsersRepo;
import com.Help.Center.util.JwtUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    UsersRepo usersRepo;

    @Autowired
    private JwtUtil jwtUtil;

//    @PostMapping("/login")
//    ResponseEntity<String> login(@RequestBody Users users){
//        Users UserLogin=usersRepo.findByUserNameAndPassword(users.getUserName(),users.getPassword());
//        String result="";
//        if(UserLogin==null){
//            result="User Login Failed";
//        }
//        else {
//            result = jwtUtil.genarateJwt(UserLogin);
//        }
//       return ResponseEntity.ok().body(result);
//    }



}
