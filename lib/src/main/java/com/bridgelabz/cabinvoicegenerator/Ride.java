package com.bridgelabz.cabinvoicegenerator;

public class Ride {
	private double distance;
	private int time;
	private Ridetype type;
	public static enum Ridetype {
		NORMAL_RIDE, PREMIUM_RIDE
	}
	
	public Ride(double distance, int time, Ridetype type){
		this.setDistance(distance);
		this.setTime(time);
		this.setType(type);
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Ridetype getType() {
		return type;
	}

	public void setType(Ridetype type) {
		this.type = type;
	}
}
