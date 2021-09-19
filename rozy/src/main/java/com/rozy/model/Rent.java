package com.rozy.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Rent {
	
	public String _id;
	public String id;
	public double rent;
	public String datetime;
	
	
	public Rent() {
	}


	public Rent(String _id, String id, double rent, String datetime) {
		this._id = _id;
		this.id = id;
		this.rent = rent;
		this.datetime = datetime;
	}


	@Override
	public String toString() {
		return "Rent [_id=" + _id + ", id=" + id + ", rent=" + rent + ", datetime=" + datetime + "]";
	}


	public Map toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("rent", rent);
		map.put("datetime", new Date());
		return map;
	}
	
	

}
