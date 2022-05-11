package com.jonareas.techhub.security;

import com.jonareas.techhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.jonareas.techhub.model.User userData = repo.findOneByUsername(username);
		
		if(userData == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		String role = userData.getRole().getName();
		//System.out.println("Role: " + role);
		roles.add(new SimpleGrantedAuthority(role));
		
		return new User(userData.getUsername(), userData.getPassword(), userData.isEnabled(), true, true, true, roles);
	}

}
