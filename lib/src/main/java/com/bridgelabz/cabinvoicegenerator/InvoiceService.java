package com.bridgelabz.cabinvoicegenerator;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InvoiceService {
private Map<String, ArrayList<Ride>> rideMap = new HashMap<String, ArrayList<Ride>>();
	
	public void addUserRide(String userId, Ride ride) {
		if(!rideMap.containsKey(userId)) {
			rideMap.put(userId, new ArrayList<Ride>());
		}
		rideMap.get(userId).add(ride);
	}
	
	public ArrayList<Ride> getUserRideList(String userId){
		
		if(rideMap.containsKey(userId)) return rideMap.get(userId);
		else {
			System.err.println("User ID not found");
			return null;
		}
	}
}