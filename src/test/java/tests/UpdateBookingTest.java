package tests;

import org.testng.annotations.Test;

import api.AuthenticationAPI;
import api.BookingAPI;
import builders.BookingBuilder;
import dataprovider.BookingDataProvider;
import io.restassured.response.Response;
import models.Booking;
import validators.ResponseValidator;

public class UpdateBookingTest{

    @Test(dataProvider = "updateBookingData",
          dataProviderClass = BookingDataProvider.class)

    public void verifyUpdateBookingRequest(

            String originalFirstName,
            String originalLastName,
            int originalPrice,
            String checkIn,
            String checkOut,
            boolean depositPaid,
            String additionalNeeds,

            String updatedFirstName,
            String updatedLastName,
            int updatedPrice,
            String updatedAdditionalNeeds) {

        // Original Booking
        Booking originalBooking =
                BookingBuilder.createBooking(
                        originalFirstName,
                        originalLastName,
                        originalPrice,
                        checkIn,
                        checkOut,
                        depositPaid,
                        additionalNeeds);

        int bookingId =
                BookingAPI.createBookingAndReturnId(originalBooking);

        // Updated Booking
        Booking updatedBooking =
                BookingBuilder.createBooking(
                        updatedFirstName,
                        updatedLastName,
                        updatedPrice,
                        checkIn,
                        checkOut,
                        depositPaid,
                        updatedAdditionalNeeds);

        // Generate Token
        String token = AuthenticationAPI.generateToken();

        // Update Booking
        Response response =
                BookingAPI.updateBooking(
                        bookingId,
                        token,
                        updatedBooking);

        // Validations
        ResponseValidator.validateStatusCode(response, 200);
        ResponseValidator.validateContentType(response);
        ResponseValidator.validateResponseTime(response);
        
        ResponseValidator.validateSchema(
                response,
                "schema/booking-schema.json");

        // Deserialize
        Booking actualBooking =
                response.as(Booking.class);

        // Business Validation
        ResponseValidator.validateBooking(
                updatedBooking,
                actualBooking);
        

    }
}