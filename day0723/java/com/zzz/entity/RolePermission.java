package com.zzz.entity;

public class RolePermission {
	private Integer roleid;
	private Integer permissionid;
	public RolePermission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RolePermission(Integer roleid, Integer permissionid) {
		super();
		this.roleid = roleid;
		this.permissionid = permissionid;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public Integer getPermissionid() {
		return permissionid;
	}
	public void setPermissionid(Integer permissionid) {
		this.permissionid = permissionid;
	}
	@Override
	public String toString() {
		return "RolePermission [roleid=" + roleid + ", permissionid=" + permissionid + "]";
	}
	
}
