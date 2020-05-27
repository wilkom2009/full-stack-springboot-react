package com.wilkom.udemycourses.restfultodowebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsJpaService implements UserDetailsService {

	@Autowired
	private JwtUserDetailsJpaRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	public UserDetails save(String username, String password, List<Role> roles) {
		String encordedPwd = new BCryptPasswordEncoder().encode(password);
		return userRepository.save(new JwtUserDetailsJpa(username, encordedPwd, roles));
	}
}
