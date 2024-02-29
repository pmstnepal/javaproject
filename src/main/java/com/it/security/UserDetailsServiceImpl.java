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
	
	private SingupRepository callsignrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Mysqlentity> checkdata=callsignrepo.findById(username);
		if (checkdata.isPresent()) {	
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(checkdata.get().getRole()));
			return new User(username, checkdata.get().getPassword(), authorities);
			
		} else {
			throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
		
	}

}
