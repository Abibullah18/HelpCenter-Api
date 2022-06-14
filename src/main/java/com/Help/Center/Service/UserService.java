package com.Help.Center.Service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Help.Center.Models.Users;
import com.Help.Center.Repository.UsersRepo;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UserService implements UserDetailsService {
	@Autowired
	private UsersRepo usersRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Running LoadByUserName");

		// TODO Auto-generated method stub
		Users users=usersRepo.findByUserName(username);
		log.info("USER VALUE IN LOADBYUSERNAME {}:",users);

		Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
		String id= String.valueOf(users.getReferenceNo());
		authorities.add(new SimpleGrantedAuthority(id));
		users.getRoles().getScope().forEach(scope->{
			authorities.add(new SimpleGrantedAuthority(scope.getScopeName()));
		});
		
		return new org.springframework.security.core.userdetails.User(users.getUserName(), users.getPassword(), authorities);
	}

}
