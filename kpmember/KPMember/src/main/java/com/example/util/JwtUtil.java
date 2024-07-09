package com.example.util;


import java.util.Date;
import java.util.function.Function;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.model.Member;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

 
@Component
public class JwtUtil {
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour
     
    @Value("${app.jwt.secret}")
    private String SECRET_KEY;
     
    public String generateAccessToken(Member member) {
        return Jwts.builder()
                .setSubject(String.format("%s,%s", member.getId(), member.getEmailid()))
                .setIssuer("Member")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
       
        
        public boolean validateAccessToken(String token) {
            try {
                Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
                return true;
            } catch (ExpiredJwtException ex) {
                System.out.print(ex);
            }
             
            return false;
        }
         
        public String getSubject(String token) {
            return parseClaims(token).getSubject();
        }
         
        private Claims parseClaims(String token) {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        }
       
                 
    }

