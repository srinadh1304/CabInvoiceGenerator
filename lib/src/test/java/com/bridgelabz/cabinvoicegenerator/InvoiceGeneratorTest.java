package com.bridgelabz.cabinvoicegenerator;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
	
	public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
	
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		
		double distance  = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
		
	}
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumfare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance =0.1;
		int time = 1;
		double fare  = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5,fare,0.0);
	}
	@Test
	public void givenMultipleRides_ShouldReturnTotalfare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(10, 3),
						 new Ride(20, 6)
					   	};
		double fare  = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(309,fare,0.0);
	}
}
