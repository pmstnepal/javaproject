package com.it.repository.signup;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
	
public interface SingupRepository extends JpaRepository<Mysqlentity, String>{

	public Optional<Mysqlentity> findByUsernameAndPassword(String username, String password);
	
	List<Mysqlentity> findByUsername(String username);

	public Optional<Mysqlentity> findByPassword(PasswordEncoder password);
	

	public Optional<Mysqlentity> findByUsernameAndPasswordAndRole(String username, String password, String role);
	
	public Optional<Mysqlentity> findByEmail(String email);
	public Optional<Mysqlentity> findByRole(String role);
	


	
//	@Query("Select c from Signup c where c.username LIKE  %?1% or c.email LIKE  %?2%")
	
	
		
	
}
