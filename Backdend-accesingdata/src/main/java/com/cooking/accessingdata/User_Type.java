package com.cooking.accessingdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TYPE")
public class User_Type {
	@Id
	@Column(name = "user_type")
	
	private int user_type;	
	private final String user_type_desc;
	private final String created_on;
	private final String created_by;
	private final String updated_on;
	private final String updated_by;
	
	public User_Type() {
        this.user_type = 3;
        this.user_type_desc = "";
        this.created_on = "";
        this.created_by = "";
        this.updated_on = "";
        this.updated_by = "";
    }
    
    public User_Type(int user_type, String user_type_desc, String created_on, String created_by, String updated_on, String updated_by) {
    	this.user_type = user_type;
    	this.user_type_desc = user_type_desc;
        this.created_on = created_on;
        this.created_by = created_by;
        this.updated_on = updated_on;
        this.updated_by = updated_by;
    }

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public String getUser_type_desc() {
		return user_type_desc;
	}

	public String getCreated_on() {
		return created_on;
	}

	public String getCreated_by() {
		return created_by;
	}

	public String getUpdated_on() {
		return updated_on;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	@Override
	public String toString() {
		return "User_Type [user_type=" + user_type + ", user_type_desc=" + user_type_desc + "]";
	}	

}