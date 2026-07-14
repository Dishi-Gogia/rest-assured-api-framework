package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.AuthenticationAPI;
import api.BookingAPI;
import builders.BookingBuilder;
import builders.PatchBuilder;
import io.restassured.response.Response;
import models.Booking;
import models.BookingResponse;
import validators.ResponseValidator;

public class BookingWorkflowTest {

    private final String firstName = "Dishi";
    private final String lastName = "Gogia";
    private final int totalPrice = 3500;
    private final String checkIn = "2026-07-01";
    private final String checkOut = "2026-07-10";
    private final boolean depositPaid = true;
    private final String additionalNeeds = "Breakfast";

    @Test(groups = "workflow")
    public void verifyBookingWorkflow() {

        // ==============================
        // CREATE BOOKING
        // ==============================

        Booking booking = BookingBuilder.createBooking(
                firstName,
                lastName,
                totalPrice,
                checkIn,
                checkOut,
                depositPaid,
                additionalNeeds);

        Response createResponse = BookingAPI.createBooking(booking);

        ResponseValidator.validateStatusCode(createResponse, 200);
        ResponseValidator.validateContentType(createResponse);
        ResponseValidator.validateResponseTime(createResponse);
        ResponseValidator.validateSchema(createResponse, "schema/create-booking-response-schema.json");

        BookingResponse bookingResponse =
                createResponse.as(BookingResponse.class);

        ResponseValidator.validateBookingResponse(
                booking,
                bookingResponse);

        int bookingId = bookingResponse.getBookingid();

        // ==============================
        // GENERATE TOKEN
        // ==============================

        String token = AuthenticationAPI.generateToken();

        // ==============================
        // GET BOOKING
        // ==============================

        Response getResponse =
                BookingAPI.getBooking(bookingId);

        ResponseValidator.validateStatusCode(getResponse, 200);
        ResponseValidator.validateContentType(getResponse);
        ResponseValidator.validateResponseTime(getResponse);
        ResponseValidator.validateSchema(
                getResponse,
                "schema/booking-schema.json");

        Booking actualBooking =
                getResponse.as(Booking.class);

        ResponseValidator.validateBooking(
                booking,
                actualBooking);

        // ==============================
        // UPDATE BOOKING
        // ==============================

        Booking updatedBooking =
                BookingBuilder.createBooking(
                        firstName + " Updated",
                        lastName,
                        totalPrice + 1000,
                        checkIn,
                        checkOut,
                        depositPaid,
                        "Dinner");

        Response updateResponse =
                BookingAPI.updateBooking(
                        bookingId,
                        token,
                        updatedBooking);

        ResponseValidator.validateStatusCode(updateResponse, 200);
        ResponseValidator.validateContentType(updateResponse);
        ResponseValidator.validateResponseTime(updateResponse);
        ResponseValidator.validateSchema(
                updateResponse,
                "schema/booking-schema.json");
        

        Booking updatedResponse =
                updateResponse.as(Booking.class);

        ResponseValidator.validateBooking(
                updatedBooking,
                updatedResponse);

     // ==============================
     // PATCH BOOKING
     // ==============================

     Map<String, Object> patchRequest =
             new PatchBuilder()
                     .addField("firstname", "Patched Name")
                     .build();

     Response patchResponse =
             BookingAPI.patchBooking(
                     bookingId,
                     token,
                     patchRequest);

     ResponseValidator.validateStatusCode(patchResponse, 200);
     ResponseValidator.validateContentType(patchResponse);
     ResponseValidator.validateResponseTime(patchResponse);
     ResponseValidator.validateSchema(
             patchResponse,
             "schema/booking-schema.json");

     Booking patchedBooking =
             patchResponse.as(Booking.class);

     Assert.assertEquals(
             patchedBooking.getFirstname(),
             "Patched Name");

     Assert.assertEquals(
             patchedBooking.getLastname(),
             updatedBooking.getLastname());

     Assert.assertEquals(
             patchedBooking.getTotalprice(),
             updatedBooking.getTotalprice());

     Assert.assertEquals(
             patchedBooking.getAdditionalneeds(),
             updatedBooking.getAdditionalneeds());

        // ==============================
        // DELETE BOOKING
        // ==============================

        Response deleteResponse =
                BookingAPI.deleteBooking(
                        bookingId,
                        token);

        ResponseValidator.validateStatusCode(deleteResponse, 201);

        // ==============================
        // VERIFY DELETION
        // ==============================

        Response deletedResponse =
                BookingAPI.getBooking(bookingId);

        ResponseValidator.validateStatusCode(
                deletedResponse,
                404);
    }
}