package com.it.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.it.repository.signup.Mysqlentity;
import com.it.repository.signup.SingupRepository;
import com.it.service.Validation;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	/**
	 * Who will call this methid ???? spring security
	 * 
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private Validation callvalidation;
	
	@Autowired
	private SingupRepository callsignrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if ("alex".equals(username)) { 
//			List<GrantedAuthority> authorities =
//				   new ArrayList<>(); authorities.add(new SimpleGrantedAuthority("ADMIN"));
//				   //username ,password ,role return new
//				   return new User(username,passwordEncoder.encode("alex123"),authorities); 
//		}
//		
		
		
//		if (callvalidation.userid(username)) 
		Optional<Mysqlentity> checkdata=callsignrepo.findById(username);
		if (checkdata.isPresent())
		{
			List<GrantedAuthority> authorities = new ArrayList<>();
			if ("Admin" == checkdata.get().getRole()) {
			authorities.add(new SimpleGrantedAuthority("Admin"));
			//username ,password ,role
			
			}
			return new User(username,checkdata.get().getPassword(),authorities);
		} else {
			throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
		
	}

}
