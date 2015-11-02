package com.org.dabbaa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(catalog="dabbaawala" , name = "Role_Master")
public class Role extends ConfigMaster{

	public Role() {
	}
	
	@Id
	@GeneratedValue
	@Column(name = "roleId", unique = true, nullable = false)
	private int roleId;
	
	@Column(name = "roleName", unique = true, nullable = false, length = 50)
	private String roleName;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
