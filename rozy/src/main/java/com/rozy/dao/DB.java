package com.rozy.dao;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.rozy.model.Rent;
import com.rozy.model.User;

public class DB {
	
	MongoClient mongoClient;
	
	public DB() {
		// TODO Auto-generated constructor stub
		try {
			String connectionURL = "mongodb+srv://nikhil:nikhil@cluster0.pectg.mongodb.net/rozy?retryWrites=true&w=majority";
    	mongoClient = MongoClients.create(connectionURL);
    	System.out.println("connection created");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something went wrong in making connection");
		}
		

	}
	
	public boolean loginUser(User user) {
		BasicDBObject query=new BasicDBObject();
		query.put("username", user.username);
		query.put("password", user.password);
		
		// Fetching the Data
		MongoCursor<Document> cursor = mongoClient.getDatabase("rozy").getCollection("users").find(query).iterator();
		
		boolean flag = cursor.hasNext();
    	if(flag) {
    		//System.out.println(cursor.next().toJson());
    		Document document = cursor.next();
    		System.out.println(document.getObjectId("_id"));
    		System.out.println(document.getString("name"));
    		
    		user._id = document.getObjectId("_id").toString();
    		user.name = document.getString("name");
    		
    		System.out.println("[DB] User Data After Successful Login:"+user);
    		
    	}
		
		return flag;
	
	}
	
public boolean registerUser(User user) {
		
		Document document = new Document(user.toMap());
    	
    	//Insert into DataBase
    	mongoClient.getDatabase("rozy").getCollection("users").insertOne(document);
    	System.out.println(user.name+" Regsitere in MongoDB :)");
		
		return true;
	}

public boolean logRent(Rent rent) {
	
	Document document = new Document(rent.toMap());
	
	//Insert into DataBase
	mongoClient.getDatabase("rozy").getCollection("rent").insertOne(document);
	System.out.println(rent.id+" "+rent.rent+" rent Saved in MongoDB");
	
	return true;
	
}

public ArrayList<Rent> fetchrent(String id) {

	ArrayList<Rent> rentRecords = new ArrayList<Rent>();
	
	try {
		
		BasicDBObject query = new BasicDBObject();
		query.put("id", id);
		
    	MongoCursor<Document> cursor = mongoClient.getDatabase("rozy").getCollection("rent").find(query).iterator();
    	while(cursor.hasNext()) {
    		
    		Document document = cursor.next();
    		Rent rent = new Rent();
    		rent._id = document.getObjectId("_id").toString();
    		rent.id = document.getString("userId");
    		rent.datetime = document.getDate("datetime").toString();
    		rent.rent = document.getDouble("rent");
    		
    		rentRecords.add(rent);
    		
    	}
	}catch(Exception e) {
		System.out.println("Something Went Wrong: "+e);
	}
	
	return rentRecords;	
	
}

public void deleteRent(String rent_id) {

	System.out.println("[DB] Deleting Fever:"+rent_id);
	
	BasicDBObject query = new BasicDBObject();
	
	query.put("_id", new ObjectId(rent_id));
	
	// Fetching the Data
	mongoClient.getDatabase("rozy").getCollection("rent").deleteOne(query);
	
}

public void updateRent(double rent,String rent_id) {
	
    ObjectId oId = new ObjectId(rent_id);
	
	mongoClient.getDatabase("rozy").getCollection("rent").updateOne(Filters.eq("_id", oId), Updates.set("rent", rent));
	System.out.println("Rent Updated");	
}


public void updateUser(String userName, String userEmail, String userNewPassword, String userId) {
	// MongoDB Document which converts HashMap to Document | BOXING
	
	System.out.println("[DB] Updating User  " + userId);
	
	
	BasicDBObject query = new BasicDBObject();
	query.put("_id", new ObjectId(userId) );
	
	MongoCursor<Document> cursor = mongoClient.getDatabase("rozy").getCollection("users").find(query).iterator();
	
	Document document = cursor.next();
	
//	DBObject update = new BasicDBObject();
	
	document.put("name", userName);
	document.put("username", userEmail);
	document.put("password", userNewPassword);
	
//	update.put("$set", document);
	ObjectId oId = new ObjectId(userId);
	
	System.out.println("[DB] "+document.toJson());
	
//	mongoClient.getDatabase("medilogdb").getCollection("medicines").updateOne(query, document);
	// Insert into DataBase
	mongoClient.getDatabase("rozy").getCollection("users").updateOne(Filters.eq("_id", oId),
                                                                 Updates.combine(Updates.set("name", userName), Updates.set("username", userEmail), Updates.set("password", userNewPassword))  );
	System.out.println("User Updated");

}



}
