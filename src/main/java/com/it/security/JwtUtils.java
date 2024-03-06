package com.it.security;




import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;



@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	  private String jwtSecret="ABUE87%&$&##@)@(&@*^@^@@@";

	  private int jwtExpirationMs=1800000;
	  
// authentication, user,grante authority by dependency spring-boot-start-security
	  public String generateJwtToken(Authentication authentication) {

		User userPrincipal = (User) authentication.getPrincipal();
	   Collection<GrantedAuthority> list =userPrincipal.getAuthorities();
	   String role="";
	   for(GrantedAuthority ga : list) {
		   role = ga.getAuthority();
		   break;
	   }
	    //JAVA 8 //userPrincipal.getAuthorities().stream().
		 //map(s->s.getAuthority()).findFirst().get()
	     Map<String,Object> claims=new HashMap<>();
		 claims.put("auth", role);
		 claims.put("email", "pmstnepal@gmail.com");
		 claims.put("company", "PMST NEPAL Pvt. Ltd.");
	    return Jwts.builder()
	        .setSubject((userPrincipal.getUsername()))
	        .addClaims(claims)
	        .setIssuedAt(new Date())
	        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
	        .signWith(SignatureAlgorithm.HS512, jwtSecret)
	        .compact();
	  }

	  public String getUserNameFromJwtToken(String token) {
	    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	  }

	  public String getRoleFromJwtToken(String token) {
		    return (String)Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().get("auth");
	 }

	  public boolean validateJwtToken(String authToken) {
	    try {
	      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
	      return true;
	    } catch (SignatureException e) {
	      logger.error("Invalid JWT signature: {}", e.getMessage());
	    } catch (MalformedJwtException e) {
	      logger.error("Invalid JWT token: {}", e.getMessage());
	    } catch (ExpiredJwtException e) {
	      logger.error("JWT token is expired: {}", e.getMessage());
	    } catch (UnsupportedJwtException e) {
	      logger.error("JWT token is unsupported: {}", e.getMessage());
	    } catch (IllegalArgumentException e) {
	      logger.error("JWT claims string is empty: {}", e.getMessage());
	    }

	    return false;
	  }

}
