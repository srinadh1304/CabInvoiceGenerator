package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;

import com.bridgelabz.cabinvoicegenerator.Ride.Ridetype;

public class InvoiceGenerator {
	private static final double MIN_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1; 
	private static final int MINIMUM_COST = 5;
	
	private static final double PREMIUM_MIN_COST_PER_KILOMETER = 15;
	private static final int PREMIUM_COST_PER_TIME = 2; 
	private static final int PREMIUM_MINIMUM_COST = 20;
	
	private static InvoiceService invoiceServiceObject = new InvoiceService();
	
	public double calculateFare(double distance, int time, Ridetype type) {
		if(type.equals(Ridetype.NORMAL_RIDE)) {
			double totalFare = distance * MIN_COST_PER_KILOMETER + time * COST_PER_TIME;
			return Math.max(totalFare, MINIMUM_COST);
		}
		else {
			double totalFare = distance * PREMIUM_MIN_COST_PER_KILOMETER + time * PREMIUM_COST_PER_TIME;
			return Math.max(totalFare, PREMIUM_MINIMUM_COST);
		}
	}
	
	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += this.calculateFare(ride.getDistance(),ride.getTime(), ride.getType());
		}
		return totalFare;
	}
	public InvoiceSummary getSummary(Ride[] rides) {
		double totalFare = this.calculateFare(rides);
		int numberOfRides = rides.length;
		InvoiceSummary summary = new InvoiceSummary(numberOfRides,totalFare);
		return summary;
	}
	public void addUserRide(String userId, Ride rides) {
		invoiceServiceObject.addUserRide(userId, rides);
	}
	
	public InvoiceSummary getSummaryByUserId(String userId) {
		ArrayList<Ride> rides =  invoiceServiceObject.getUserRideList(userId);
		Ride[] ridesArray = new Ride[rides.size()];
		ridesArray = rides.toArray(ridesArray);
		return this.getSummary(ridesArray);
	}

}