package tests;

import org.testng.annotations.Test;

import api.AuthenticationAPI;
import api.BookingAPI;
import builders.BookingBuilder;
import dataprovider.BookingDataProvider;
import io.restassured.response.Response;
import models.Booking;
import validators.ResponseValidator;

public class DeleteBookingTest {

    @Test(dataProvider = "bookingData",
          dataProviderClass = BookingDataProvider.class)

    public void verifyDeleteBookingRequest(

            String firstName,
            String lastName,
            int price,
            String checkIn,
            String checkOut,
            boolean depositPaid,
            String additionalNeeds) {

        // Create Booking
        Booking booking =
                BookingBuilder.createBooking(
                        firstName,
                        lastName,
                        price,
                        checkIn,
                        checkOut,
                        depositPaid,
                        additionalNeeds);

        int bookingId =
                BookingAPI.createBookingAndReturnId(booking);

        // Generate Token
        String token =
                AuthenticationAPI.generateToken();

        // DELETE
        Response deleteResponse =
                BookingAPI.deleteBooking(
                        bookingId,
                        token);

        ResponseValidator.validateStatusCode(
                deleteResponse,
                201);

        // Verify Booking Deleted
        Response getResponse =
                BookingAPI.getBooking(bookingId);

        ResponseValidator.validateStatusCode(
                getResponse,
                404);
    }
}