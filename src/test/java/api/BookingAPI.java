package api;

import static io.restassured.RestAssured.given;

import java.util.Map;

import endpoints.Routes;
import io.restassured.response.Response;
import listeners.TestListener;
import models.Booking;
import models.BookingResponse;
import specifications.RequestSpecificationFactory;
import utilities.ExtentLogger;
import utilities.JsonUtils;

public class BookingAPI {

    // ==========================
    // CREATE BOOKING
    // ==========================
    public static Response createBooking(Booking booking) {

        Response response = given()
                .spec(RequestSpecificationFactory.requestSpec())
                .body(booking)
        .when()
                .post(Routes.CREATE_BOOKING);

        ExtentLogger.logRequestResponse(
                TestListener.getTest(),
                "POST",
                Routes.CREATE_BOOKING,
                JsonUtils.toPrettyJson(booking),
                response);

        return response;
    }

    // ==========================
    // GET BOOKING
    // ==========================
    public static Response getBooking(int bookingId) {

        Response response = given()
                .spec(RequestSpecificationFactory.requestSpec())
                .pathParam("id", bookingId)
        .when()
                .get(Routes.GET_BOOKING);

        ExtentLogger.logRequestResponse(
                TestListener.getTest(),
                "GET",
                Routes.GET_BOOKING.replace("{id}", String.valueOf(bookingId)),
                "N/A",
                response);

        return response;
    }

    // ==========================
    // UPDATE BOOKING
    // ==========================
    public static Response updateBooking(int bookingId,
                                         String token,
                                         Booking booking) {

        Response response = given()
                .spec(RequestSpecificationFactory.requestSpec())
                .cookie("token", token)
                .pathParam("id", bookingId)
                .body(booking)
        .when()
                .put(Routes.UPDATE_BOOKING);

        ExtentLogger.logRequestResponse(
                TestListener.getTest(),
                "PUT",
                Routes.UPDATE_BOOKING.replace("{id}", String.valueOf(bookingId)),
                JsonUtils.toPrettyJson(booking),
                response);

        return response;
    }

    // ==========================
    // PATCH BOOKING
    // ==========================
    public static Response patchBooking(int bookingId,
                                        String token,
                                        Map<String, Object> patchRequest) {

        Response response = given()
                .spec(RequestSpecificationFactory.requestSpec())
                .cookie("token", token)
                .pathParam("id", bookingId)
                .body(patchRequest)
        .when()
                .patch(Routes.PATCH_BOOKING);

        ExtentLogger.logRequestResponse(
                TestListener.getTest(),
                "PATCH",
                Routes.PATCH_BOOKING.replace("{id}", String.valueOf(bookingId)),
                JsonUtils.toPrettyJson(patchRequest),
                response);

        return response;
    }

    // ==========================
    // DELETE BOOKING
    // ==========================
    public static Response deleteBooking(int bookingId,
                                         String token) {

        Response response = given()
                .spec(RequestSpecificationFactory.requestSpec())
                .cookie("token", token)
                .pathParam("id", bookingId)
        .when()
                .delete(Routes.DELETE_BOOKING);

        ExtentLogger.logRequestResponse(
                TestListener.getTest(),
                "DELETE",
                Routes.DELETE_BOOKING.replace("{id}", String.valueOf(bookingId)),
                "N/A",
                response);

        return response;
    }

    // ==========================
    // CREATE BOOKING & RETURN ID
    // ==========================
    public static int createBookingAndReturnId(Booking booking) {

        Response response = createBooking(booking);

        BookingResponse bookingResponse =
                response.as(BookingResponse.class);

        return bookingResponse.getBookingid();
    }
}