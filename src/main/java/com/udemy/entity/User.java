package com.udemy.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String usernaame;
	
	@Column(name = "password", nullable = false, length = 60)
	private String password;
	
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<>();

	public User(String usernaame, String password, boolean enabled) {
		super();
		this.usernaame = usernaame;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String usernaame, String password, boolean enabled, Set<UserRole> userRole) {
		super();
		this.usernaame = usernaame;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public User() {
	}

	public String getUsernaame() {
		return usernaame;
	}

	public void setUsernaame(String usernaame) {
		this.usernaame = usernaame;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
}
