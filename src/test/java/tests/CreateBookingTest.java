package tests;

import org.testng.annotations.Test;
import api.BookingAPI;
import builders.BookingBuilder;
import dataprovider.BookingDataProvider;
import io.restassured.response.Response;
import models.Booking;
import models.BookingResponse;
import validators.ResponseValidator;


public class CreateBookingTest {

	@Test(dataProvider="bookingData",dataProviderClass=BookingDataProvider.class)
	public void createBooking( String firstName,String lastName,int price,String checkIn,String checkOut,boolean depositPaid,
	        String additionalNeeds) {
			
	
	Booking booking= BookingBuilder.createBooking(firstName,lastName,price,checkIn,checkOut,depositPaid,additionalNeeds);
	Response response =BookingAPI.createBooking(booking);
	BookingResponse bookingResponse =response.as(BookingResponse.class);
	ResponseValidator.validateBookingResponse(booking,bookingResponse);
	ResponseValidator.validateStatusCode(response,200);
	ResponseValidator.validateContentType(response);
	ResponseValidator.validateNotNullField(response, "bookingid");
	ResponseValidator.validateResponseTime(response);
	ResponseValidator.validateBookingId(response);
	ResponseValidator.validateSchema(response,"schema/create-booking-response-schema.json");
	
	}
}
