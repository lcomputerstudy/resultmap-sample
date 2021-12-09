package com.dcp.example.domain;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String uName;
	private String uDateTime;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	private Collection<String> strAuthList;
	
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuDateTime() {
		return uDateTime;
	}
	public void setuDateTime(String uDateTime) {
		this.uDateTime = uDateTime;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}
	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}
	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return isAccountNonLocked;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}
	
	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
/*	public Collection<String> getStrAuthList() {
		return strAuthList;
	}
	public void setStrAuthList(Collection<String> strAuthList) {
		this.strAuthList = strAuthList;
		
		Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		for (String strAuth : strAuthList) {
			GrantedAuthority auth = new SimpleGrantedAuthority(strAuth);
			authList.add(auth);
		}
		
		// 와일드카드 제너릭스가 설정된 인스턴스는 주소 대입만 가능 (와일드 카드는 컴파일 단계에서 입력되는 데이터의 정확한 타입을 알지 못함)
		this.authorities = authList;
	} */
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", uName=" + uName + ", uDateTime=" + uDateTime
				+ ", authorities=" + authorities + ", strAuthList=" + strAuthList + ", isAccountNonExpired="
				+ isAccountNonExpired + ", isAccountNonLocked=" + isAccountNonLocked + ", isCredentialsNonExpired="
				+ isCredentialsNonExpired + ", isEnabled=" + isEnabled + "]";
	}
	
	
	
}
