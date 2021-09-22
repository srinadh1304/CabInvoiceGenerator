package com.bridgelabz.cabinvoicegenerator;

public class InvoiceGenerator {
	private static final double MIN_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1; 
	private static final int MINIMUM_COST = 5;
	
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MIN_COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_COST);
	}
	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += this.calculateFare(ride.getDistance(),ride.getTime());
		}
		return totalFare;
	}
}