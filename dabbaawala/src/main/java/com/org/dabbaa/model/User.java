package com.org.dabbaa.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "users", catalog = "test")
public class User {


	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", unique = true, nullable = false)
	private int userId;
	
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String username;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;	

	
	private String[] roles;
	
	@OneToMany(targetEntity = UserRole.class, fetch = FetchType.EAGER, mappedBy = "user", cascade=CascadeType.ALL ,orphanRemoval=true)
	private Set<UserRole> userRole;

	public User() {
	}

	public User(int id,String username, String password, boolean enabled) {
		this.userId=id;;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		this.userId = id;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		System.out.println("Setting the roles" + roles);
		this.roles = roles;				
	}

	
	public void populateRoles(){
		
		System.out.println("Inside populate roles..Length of roles is" + roles.length);
		
		if(null != roles && roles.length>0){
			HashSet<UserRole> userRoleTemp = new HashSet<UserRole>(roles.length);
						
			for (String role: roles){
				System.out.println("roleName "+role);
				userRoleTemp.add(new UserRole(this,role));
			}
			
			setUserRole(userRoleTemp);
		}	
	}
	
	public void populateTestRoles(){
		
		System.out.println("Inside test populate roles..Length of roles is" + roles.length);
		
		if(null != roles && roles.length>0){
			HashSet<UserRole> userRoleTemp = new HashSet<UserRole>(roles.length);			
				
				UserRole ur = new UserRole(this,"abcd");
				ur.setUserRoleId(1);
				
				userRoleTemp.add(ur);
			
			
			setUserRole(userRoleTemp);
		}	
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", enabled=" + enabled
				+ ", userRole=" + userRole + "]";
	}

}
