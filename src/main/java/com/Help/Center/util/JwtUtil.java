package com.Help.Center.util;

import com.Help.Center.Models.Users;
import com.auth0.jwt.interfaces.Claim;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtUtil  {
    public String genarateJwt(Users user){
        Date IsuedAt= new Date();

        Claims claims= Jwts.claims()
                .setIssuer(user.getUserName())
                .setIssuedAt(IsuedAt);

       return Jwts.builder().setClaims(claims).compact();



    }
}
