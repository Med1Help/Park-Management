package com.ParkManagement.ParkManagement.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    final private static String SECRET_KEY = "oM0t4ZIqDZhn9fwW9veFK+36ojBj7xtqx3jwwPEVdidqFjowUeWwxKsaR6eVUnE2g9b+qoJcfT7jL8m/x87AQY1V5j711g05TS/VUfZyyzhr2SKss+PKLXG6aXv6f3SgxIzr6S95nFgM9DDZ9jhfrP6LsjumnCsu/grFiKyZHFImX0f5nRXJ47VGo1Whvig5hiV9LBfKCG++UOXbK/N1DiY2XcWSf+R76GsjkxTFag6bL8rmXzQ+MX/U9bANKFy0N0a4VSXFHUNZMVIe38OXezbaeDG8fOCQugcsB4+Ax5BH02UrgA0nXRFBFyICJBN1PA0Vcr8O3br5lZKMeogogOOfFNYZXnRdj1ne74NuFW8=";
    public String extUseremail(String token){
       return extClaim(token,Claims::getSubject);
    }
    public <T> T extClaim(String token, Function<Claims,T> claimResol){
        final Claims claims = extAllClaims(token);
        return claimResol.apply(claims);
    }
    private Claims extAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public String genToken(Map<String,Object> extraClaims , UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*24))
                .signWith(getSignInKey())
                .compact();
    }
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public boolean isTokenValid(String token , UserDetails userDetails){
        final String email = extUseremail(token);
        return (email.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        final Date expiration = extClaim(token,Claims::getExpiration);
        return expiration.before(new Date());
    }
}
