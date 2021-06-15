package com.memorystack.security;


import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.memorystack.model.Student;

public class UserPrincipal implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	private Long id;

    private String name;

    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private com.memorystack.model.RoleName RoleName;
    
    
    
    public com.memorystack.model.RoleName getRoleName() {
		return RoleName;
	}

	public void setRoleName(com.memorystack.model.RoleName roleName) {
		RoleName = roleName;
	}

	public UserPrincipal(Long id, String name, String username, String email, String password,
			com.memorystack.model.RoleName roleName) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		RoleName = roleName;
	}

	private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String name, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(Student user) {
        //List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
             //   new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

        return new UserPrincipal(
                user.getUserId(),
                user.getName(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getRoleName()
               // authorities
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
