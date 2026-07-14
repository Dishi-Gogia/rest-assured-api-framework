package tests;

import org.testng.annotations.Test;

import api.BookingAPI;
import builders.BookingBuilder;
import dataprovider.BookingDataProvider;
import io.restassured.response.Response;
import models.Booking;
import validators.ResponseValidator;

public class GetBookingTest{

	@Test(dataProvider="bookingData",
			dataProviderClass=BookingDataProvider.class)
	public void verifyGetBooking(String firstName,String lastName,int price,String checkIn,String checkOut,boolean depositPaid,
	        String additionalNeeds) {
	
		Booking booking = BookingBuilder.createBooking(firstName,lastName,price,checkIn,checkOut,depositPaid,additionalNeeds);

		int bookingId = BookingAPI.createBookingAndReturnId(booking);
		Response response = BookingAPI.getBooking(bookingId);

		ResponseValidator.validateStatusCode(response,200);
		ResponseValidator.validateContentType(response);
		ResponseValidator.validateResponseTime(response);
		
		ResponseValidator.validateSchema(
		        response,
		        "schema/booking-schema.json");

		Booking actualBooking =	response.as(Booking.class);

		ResponseValidator.validateBooking(booking,actualBooking);
		
		
}}
