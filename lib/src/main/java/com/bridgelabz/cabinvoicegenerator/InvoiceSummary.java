package com.bridgelabz.cabinvoicegenerator;

public class InvoiceSummary {
	private final int numberOfRides;
	private final double totalFare;
	private final double averageFare;

	public InvoiceSummary(int numberOfRides, double totalFare) {
		
		this.numberOfRides = numberOfRides;
		this.totalFare = totalFare;
		this.averageFare = this.totalFare/this.numberOfRides;
	}

	public int getNumberOfRides() {
		return numberOfRides;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public double getAverageFare() {
		return averageFare;
	}
}