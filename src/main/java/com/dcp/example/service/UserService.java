package com.dcp.example.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.dcp.example.domain.User;

public interface UserService extends UserDetailsService {
	   //유저읽기
	   public User readUser(String username);
	      
	   //유저생성
	   public void createUser(User user);

	   // 권한 생성
	   public void createAuthorities(User user);
	   
	   // 시큐리티 권한 얻기
	   Collection<GrantedAuthority> getAuthorities(String username);
	   
	   public List<User> readUserlist();
	   
	   public List<User> readUserAndAuthList();
	   
	   public void deleteAdmin(User user);
	   
	   public void addAdmin(User user);
}
