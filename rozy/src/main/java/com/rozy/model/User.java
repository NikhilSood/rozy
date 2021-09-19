package com.rozy.model;

import java.util.HashMap;
import java.util.Map;

public class User {
	
	public String _id;
	public String name;
	public String username;
	public String password;
	
	
	public User() {
	}


	public User(String _id, String name, String username, String password) {
		this._id = _id;
		this.name = name;
		this.username = username;
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [_id=" + _id + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}


	public Map toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("username", username);
		map.put("password", password);
		return map;
	}


	
	
	

}
