package com.suraj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class User{
@Id

@Column(name="user_id",length=50)
int userid;

@Column(name="name",length=50)
String name;

@Column(name="phone",length=50)
String phone;

public User(int userid, String name, String phone) {
	super();
	this.userid = userid;
	this.name = name;
	this.phone = phone;
}

public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

public String getName() {
	return name;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public void setName(String name) {
	this.name = name;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}



}
