package com.womenempowerment;
 
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.womenempowerment.model.User;
 
//create a class that implements the UserDetails interface as required by Spring Security. 
/*
 *  This class wraps an instance of User class, which is injected via constructor.
 *   And we override methods defined by the UserDetails interface, to be used by Spring Security in authentication process.
 */
public class MyUserDetails implements UserDetails {
 
    private User user; 
     
    public MyUserDetails(User user) {
        this.user = user;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getUsername();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new  SimpleGrantedAuthority("USER"));
	}
 
}