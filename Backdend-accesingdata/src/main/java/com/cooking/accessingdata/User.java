package com.cooking.accessingdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_APP")
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", sequenceName="cooking_users_seq", allocationSize=1)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;	
	private final String user_name;
	private final String user_password;
	private final String email;
	private final String user_type;
	
	public User() {
        this.user_id = 0;
        this.user_name = "";
        this.user_password = "";
        this.email = "";
        this.user_type = "";
    }
    
    public User(int user_id, String user_name, String user_password, String email, String user_type) {
    	this.user_id = user_id;
    	this.user_name = user_name;
        this.user_password = user_password;
        this.email = email;
        this.user_type = user_type;
    }
    
	public int getUserId() {
		return user_id;
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public String getUser_password() {
		return user_password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUser_type() {
		return user_type;
	}	
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", email=" + email + "]";
	}
	
	
}
