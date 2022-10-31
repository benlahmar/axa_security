package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Userd extends User implements UserDetails{

	public Userd(User u) {
		this.username=u.username;
		this.password=u.password;
		this.roles=u.roles;
	}
	@Override
	public Collection<? extends GrantedAuthority> 
	   getAuthorities() {
	List<GrantedAuthority> gts
	     =new ArrayList<GrantedAuthority>();
		
		List<Role> rs = getRoles();
		for (Role role : rs) {
			GrantedAuthority g = 
			new SimpleGrantedAuthority(role.libelle);
			gts.add(g);
		}	
		return gts;
	}
	public Userd() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
