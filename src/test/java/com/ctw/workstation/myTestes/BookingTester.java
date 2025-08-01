package com.ctw.workstation.myTestes;

import com.ctw.workstation.resource.BookingResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
@TestHTTPEndpoint(BookingResource.class)
public class BookingTester {

    @Test
    public void testCreateBookings() {
        /*
        //given
        given().contentType(ContentType.JSON).body("""
                                {
                        "requesterId": 1,
                        "rackId": 1,
                        "book_from": "2022-03-10T12:15:50",
                        "book_to": "2022-03-10T12:15:50",
                        "serial_number": 123
                        }
                        """
                )
                .when().post()
                .then()
                .log().all()
                .statusCode(201)
                .body("rackId", equalTo(1))
                .body("requesterId", equalTo(1))
                .body("serial_number", equalTo("123"));
    */
    }
}
