package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.restassured.response.Response;

public class ExtentLogger {

    public static void logRequestResponse(
            ExtentTest test,
            String method,
            String endpoint,
            String requestBody,
            Response response) {

        if (test == null) {
            return;
        }

        test.log(Status.INFO,
                "<b>HTTP Method :</b> " + method);

        test.log(Status.INFO,
                "<b>Endpoint :</b> " + endpoint);

        test.log(Status.INFO,
                "<b>Request Body</b><pre>"
                        + requestBody
                        + "</pre>");

        test.log(Status.INFO,
                "<b>Status Code :</b> "
                        + response.getStatusCode());

        test.log(Status.INFO,
                "<b>Response Time :</b> "
                        + response.getTime()
                        + " ms");

        test.log(Status.INFO,
                "<b>Response Headers</b><pre>"
                        + response.getHeaders().toString()
                        + "</pre>");

        test.log(Status.INFO,
                "<b>Response Body</b><pre>"
                        + response.asPrettyString()
                        + "</pre>");
    }
}