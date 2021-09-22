package com.bridgelabz.cabinvoicegenerator;
import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.cabinvoicegenerator.Ride.Ridetype;

public class InvoiceGeneratorTest {
	
	public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
	
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		
		double distance  = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time, Ridetype.NORMAL_RIDE);
		Assert.assertEquals(25, fare, 0.0);
		
	}
	
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumfare() {
		
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance =0.1;
		int time = 1;
		double fare  = invoiceGenerator.calculateFare(distance, time, Ridetype.NORMAL_RIDE);
		Assert.assertEquals(5,fare,0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnTotalfare() {
		
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(10, 3, Ridetype.NORMAL_RIDE),
						 new Ride(20, 6, Ridetype.NORMAL_RIDE)
					   	};
		double fare  = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(309,fare,0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {

		Ride[] rides = {new Ride(2.0, 5, Ridetype.NORMAL_RIDE), 
						new Ride(0.1, 1, Ridetype.NORMAL_RIDE)};
		InvoiceSummary summary = invoiceGenerator.getSummary(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
		Assert.assertEquals(expectedSummary.getAverageFare(), summary.getAverageFare(),0.0);
	}
	
	@Test
	public void givenUserID_ShouldReturnInvoiceSummary() {
		
		String userId = "U001";
		invoiceGenerator.addUserRide(userId,new Ride(10, 3, Ridetype.NORMAL_RIDE));
		invoiceGenerator.addUserRide(userId,new Ride(20, 6, Ridetype.NORMAL_RIDE));
		InvoiceSummary invoiceSummary = invoiceGenerator.getSummaryByUserId(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,309);
		Assert.assertEquals(expectedInvoiceSummary.getAverageFare(), invoiceSummary.getAverageFare(),0.0);
	}
	
	@Test
	public void givenUserID_WhenPreminumRide_ShouldReturnInvoiceSummary() {
		
		String userId = "U002";
		invoiceGenerator.addUserRide(userId,new Ride(10, 3, Ridetype.PREMIUM_RIDE));
		invoiceGenerator.addUserRide(userId,new Ride(20, 2, Ridetype.PREMIUM_RIDE));
		InvoiceSummary invoiceSummary = invoiceGenerator.getSummaryByUserId(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,460);
		Assert.assertEquals(expectedInvoiceSummary.getAverageFare(), invoiceSummary.getAverageFare(),0.0);
	}
	
	@Test
	public void givenMultipleRides_WhenPreminumRide_ShouldReturnInvoiceSummary() {
		
		Ride[] rides = { new Ride(10, 3, Ridetype.PREMIUM_RIDE),
						 new Ride(20, 4, Ridetype.PREMIUM_RIDE)
					   	};
		InvoiceSummary invoiceSummary  = invoiceGenerator.getSummary(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,464);
		Assert.assertEquals(expectedInvoiceSummary.getAverageFare(), invoiceSummary.getAverageFare(),0.0);
	}
	
	@Test
	public void givenDistanceAndTime_WhenPreminumRide_ShouldReturnTotalfare() {
		
		double distance =2.0;
		int time = 5;
		double fare  = invoiceGenerator.calculateFare(distance, time, Ridetype.PREMIUM_RIDE);
		Assert.assertEquals(40,fare,0.0);
	}
	
	@Test
	public void givenLessDistanceAndTime_WhenPreminumRide_ShouldReturnMinimumfare() {
		
		double distance =0.1;
		int time = 1;
		double fare  = invoiceGenerator.calculateFare(distance, time, Ridetype.PREMIUM_RIDE);
		Assert.assertEquals(20,fare,0.0);
	}
	
	@Test
	public void givenMultipleRides_WhenPreminumRide_ShouldReturnTotalfare() {
		
		Ride[] rides = { new Ride(10, 3, Ridetype.PREMIUM_RIDE),
						 new Ride(20, 3, Ridetype.PREMIUM_RIDE)
					   	};
		double fare  = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(462,fare,0.0);
	}

}
