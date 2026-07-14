package tests;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import api.AuthenticationAPI;
import api.BookingAPI;
import builders.BookingBuilder;
import builders.PatchBuilder;
import dataprovider.BookingDataProvider;
import io.restassured.response.Response;
import models.Booking;
import validators.ResponseValidator;

public class PartialUpdateBookingTest {

    @Test(dataProvider = "partialUpdateBookingData",
          dataProviderClass = BookingDataProvider.class)

    public void verifyPartialUpdateBookingRequest(

            String firstName,
            String lastName,
            int price,
            String checkIn,
            String checkOut,
            boolean depositPaid,
            String additionalNeeds,
            String updatedFirstName) {

        // Create Original Booking
        Booking originalBooking =
                BookingBuilder.createBooking(
                        firstName,
                        lastName,
                        price,
                        checkIn,
                        checkOut,
                        depositPaid,
                        additionalNeeds);

        int bookingId =
                BookingAPI.createBookingAndReturnId(originalBooking);

        
        // Generate Token
        String token =
                AuthenticationAPI.generateToken();

        // PATCH Booking
        Map<String, Object> patchRequest =
                new PatchBuilder()
                        .addField("firstname", updatedFirstName)
                        .build();
        
        Response response =
                BookingAPI.patchBooking(
                        bookingId,
                        token,
                        patchRequest);

        // Common Validations
        ResponseValidator.validateStatusCode(response, 200);
        ResponseValidator.validateContentType(response);
        ResponseValidator.validateResponseTime(response);

        Booking actualBooking =
                response.as(Booking.class);

        assertEquals(actualBooking.getFirstname(), updatedFirstName);
        assertEquals(actualBooking.getLastname(), originalBooking.getLastname());
        assertEquals(actualBooking.getTotalprice(), originalBooking.getTotalprice());
        assertEquals(actualBooking.isDepositpaid(), originalBooking.isDepositpaid());
        assertEquals(actualBooking.getAdditionalneeds(), originalBooking.getAdditionalneeds());
        assertEquals(actualBooking.getBookingdates().getCheckin(),
                     originalBooking.getBookingdates().getCheckin());
        assertEquals(actualBooking.getBookingdates().getCheckout(),
                     originalBooking.getBookingdates().getCheckout());
        
        ResponseValidator.validateSchema(
                response,
                "schema/booking-schema.json");

        
    }
}