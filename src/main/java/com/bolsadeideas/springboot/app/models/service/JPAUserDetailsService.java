package com.bolsadeideas.springboot.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IUserDao;
import com.bolsadeideas.springboot.app.models.entity.Role;
import com.bolsadeideas.springboot.app.models.entity.User;

@Service("jpaUserDetailsService")
public class JPAUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserDao userDao;

	private Logger logger = LoggerFactory.getLogger(JPAUserDetailsService.class);

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userDao.findByUsername(username);
		logger.info("Running JPAUserDetailsService");

		if (user == null) {
			logger.error("Error login: There are no user: " + username);
			throw new UsernameNotFoundException("Username " + username + " do not exist in the system");
		}

		logger.info("Username: " + user.getUsername());
		logger.info("Roles: " + user.getRoles().size());

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role role : user.getRoles()) {
			// Regiter in Srping Security
			logger.info("Role: ".concat(role.getAuthority()));
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}

		if (authorities.isEmpty()) {
			logger.error("Error login: There are no ROLE user: " + username);
			throw new UsernameNotFoundException("Username " + username + " do not exist ROLES in the system");
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.getEnabled(), true, true, true, authorities);
		// return new User(user.getUsername(), user.getPassword(), user.getEnabled(),
		// true, true, true, authorities);
	}

}
