package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_master database table.
 * 
 */
@Entity
@Table(name="role_master")
@NamedQuery(name="RoleMaster.findAll", query="SELECT r FROM RoleMaster r")
public class RoleMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int roleId;

	private String roleName;

	public RoleMaster() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}