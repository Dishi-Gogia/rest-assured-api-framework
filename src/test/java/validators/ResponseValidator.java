package validators;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.apache.logging.log4j.Logger;


import org.testng.Assert;
import utilities.LoggerUtils;
import io.restassured.response.Response;
import models.Booking;
import models.BookingResponse;
import utilities.ConfigReader;

public class ResponseValidator {
	
	private static final Logger logger = LoggerUtils.getLogger(ResponseValidator.class);

    public static void validateStatusCode(Response response, int statusCode) {
        response.then().statusCode(statusCode);
        logger.info("Status Code Validation Passed : {}", statusCode);
    }
    
    public static void validateContentType(Response response) {
        response.then().header("Content-Type","application/json; charset=utf-8");
        logger.info("Content Type Validation Passed");
    }
    
    public static void validateResponseTime(Response response) {
    	long responseTime = Long.parseLong(ConfigReader.getProperty("responseTime"));
        response.then().time(lessThan(responseTime));
        logger.info("Response Time Validation Passed");
    }
    
    public static void validateNotNullField(Response response, String field) {
        response.then().body(field,notNullValue());
        logger.info("The {} is not of null value and Validation Passed",field);
    }
    
    public static void validateSchema(Response response, String schemaName) {
    	 response.then().assertThat().body(matchesJsonSchemaInClasspath(schemaName));
    	 logger.info("Schema Validation Passed");
    }
    
    public static void validateFieldValue(Response response,String field,Object expectedValue) {
    	response.then().body(field, equalTo(expectedValue));
    	 logger.info("The {} value is matching and validation passed",field);
    }
    
    public static void validateFieldContains(Response response,String field,String expectedValue) {
    	response.then().body(field, containsString(expectedValue));
    	 logger.info("The {} value is matching and validation passedd",field);
    }
    
    public static void validateBookingResponse(Booking request,BookingResponse response) {

		assertEquals(response.getBooking().getFirstname(),request.getFirstname());
		assertEquals(response.getBooking().getLastname(),request.getLastname());
		assertEquals(response.getBooking().getTotalprice(),request.getTotalprice());
		assertEquals(response.getBooking().isDepositpaid(),request.isDepositpaid());
		assertEquals(response.getBooking().getAdditionalneeds(),request.getAdditionalneeds());
		assertEquals(response.getBooking().getBookingdates().getCheckin(),request.getBookingdates().getCheckin());
		assertEquals(response.getBooking().getBookingdates().getCheckout(),request.getBookingdates().getCheckout());
	}
    
    public static void validateBooking(Booking expected,
            Booking actual) {

assertEquals(actual.getFirstname(),
expected.getFirstname());

assertEquals(actual.getLastname(),
expected.getLastname());

assertEquals(actual.getTotalprice(),
expected.getTotalprice());

assertEquals(actual.isDepositpaid(),
expected.isDepositpaid());

assertEquals(actual.getAdditionalneeds(),
expected.getAdditionalneeds());

assertEquals(actual.getBookingdates().getCheckin(),
expected.getBookingdates().getCheckin());

assertEquals(actual.getBookingdates().getCheckout(),
expected.getBookingdates().getCheckout());
}
    
    /**
     * Validates that the booking ID is generated successfully.
     *
     * @param response API response returned after creating a booking
     */
    public static void validateBookingId(Response response) {

        int bookingId = response.jsonPath().getInt("bookingid");

        Assert.assertTrue(bookingId > 0,
                "Booking ID should be greater than zero, but found: " + bookingId);

        logger.info("Booking ID validated successfully. Booking ID: {}", bookingId);
    }
    
    
}
