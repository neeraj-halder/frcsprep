package com.frcsprep.services;

import com.frcsprep.entity.FrcsMem;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "782F4125442A472D4B6150645367566B59703373367639792442264528482B4D";

    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }

    public<T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(FrcsMem frcsMem){
            return generateToken(new HashMap<>(), frcsMem);
    }

    public String generateToken(Map<String,Object> extraClaims,FrcsMem frscMem){
        return Jwts.builder().setClaims(extraClaims).setSubject(frscMem.getUserName())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }
    private Claims getAllClaimsFromToken(String token) {
       return Jwts.
                parserBuilder().setSigningKey(getSigningKey())
                .build().parseClaimsJws(token).getBody();
    }

    public Key getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isTokenValid(String token, UserDetails frcsMem){
        final String userName = extractUsername(token);
        return  (userName.equals(frcsMem.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
}
