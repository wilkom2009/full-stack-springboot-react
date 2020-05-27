package com.wilkom.udemycourses.restfultodowebservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wilkom.udemycourses.restfultodowebservices.jwt.JwtUserDetailsJpa;
import com.wilkom.udemycourses.restfultodowebservices.jwt.JwtUserDetailsJpaService;
import com.wilkom.udemycourses.restfultodowebservices.jwt.Role;
import com.wilkom.udemycourses.restfultodowebservices.jwt.RoleRepository;

@Component
public class DefaultDataLoader implements ApplicationListener<ContextRefreshedEvent> {
	private boolean alreadySetup = false;

	static String ADMIN_ROLE_NAME, USER_ROLE_NAME;

	static {
		ADMIN_ROLE_NAME = "ADMIN_ROLE";
		USER_ROLE_NAME = "USER_ROLE";
	}

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private JwtUserDetailsJpaService userService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (alreadySetup) {
			return;
		}

		Role adminRole = createRoleIfNotFound(ADMIN_ROLE_NAME);
		Role userRole = createRoleIfNotFound(USER_ROLE_NAME);
		
		createUserIfNotFound("koffi","koffiko",Arrays.asList(adminRole));
		createUserIfNotFound("user","user",Arrays.asList(userRole));
		
		
		alreadySetup = true;
	}

	@Transactional
	private final Role createRoleIfNotFound(final String name) {
		Role role = roleRepository.findByName(name);
		if (role == null) {
			role = roleRepository.save(new Role(name));
		}
		return role;
	}

	@Transactional
	private final JwtUserDetailsJpa createUserIfNotFound(final String email, final String password,
			final List<Role> roles) {
		JwtUserDetailsJpa user = (JwtUserDetailsJpa) userService.loadUserByUsername(email);
		if (user == null) {
			return (JwtUserDetailsJpa) userService.save(email, password, roles);
		}
		return user;
	}

}
