package com.zzz.entity;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.crypto.hash.SimpleHashRequest;

import com.zzz.util.MD5;
import com.zzz.util.UUIDUtils;

public class User {
	private Integer Id;
	private String email;
	private String name;
	private String password;
	private Integer cid;
	private Integer did;
	private String salt;
	private String createTime;
	private String lastTime;
	private int statc;
	private String userImg;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User( String email, String name, String password, String createTime, String lastTime) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.createTime = createTime;
		this.lastTime = lastTime;
		this.statc=0;
	}
	
	public User(String email, String name, String password, String salt, String createTime, String lastTime) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.salt = salt;
		this.createTime = createTime;
		this.lastTime = lastTime;
		this.statc=0;
	}

	public User(String email, String name, String password, Integer cid, Integer did, String createTime,
			String lastTime, String userImg) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.cid = cid;
		this.did = did;
		this.createTime = createTime;
		this.lastTime = lastTime;
		this.statc =0;
		this.userImg = userImg;
	}

	public User(Integer id, String email, String name, String password, Integer cid, Integer did, String createTime,
			String lastTime, String userImg) {
		super();
		Id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.cid = cid;
		this.did = did;
		this.createTime = createTime;
		this.lastTime = lastTime;
		this.statc = 0;
		this.userImg = userImg;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = new SimpleHash("MD5",password,this.salt,1024).toHex();
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public int getStatc() {
		return statc;
	}

	public void setStatc() {
		this.statc = 0;
	}

	
	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	
	public String getSalt() {
		return salt;
	}

	public void setSalt() {
		this.salt = UUIDUtils.getUUID();
	}
	public String getCredentialsSalt() {
//		return this.email+this.salt;
		return this.email;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", email=" + email + ", name=" + name + ", password=" + password + ", cid=" + cid
				+ ", did=" + did + ", salt=" + salt + ", createTime=" + createTime + ", lastTime=" + lastTime
				+ ", statc=" + statc + ", userImg=" + userImg + "]";
	}	
}
