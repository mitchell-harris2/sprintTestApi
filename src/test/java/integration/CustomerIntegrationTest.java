package integration;

import io.restassured.response.ValidatableResponse;
import objects.Customer;
import org.junit.Test;

import java.net.URL;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class CustomerIntegrationTest {


    @Test
    public void testPostStuff_noParam() {
        Customer customer = new Customer("bob", "saget");

        given().contentType("application/json").body(customer)
            .when().post("/stuff")
            .then().body("id", greaterThan(0))
            .body("firstName",is("bob"))
            .body("lastName", is("saget"));
    }

    @Test
    public void testPostStuff_checkingQeueryParam() {
        Customer customer = new Customer("sam", "Iam");

        given().contentType("application/json").body(customer)
                .when().post("/stuff")
                .then().body("id", notNullValue());

        ValidatableResponse response = given().queryParam("firstName", "sam")
                .when().get("/stuff")
                .then().body("size()", greaterThan(0));

    }
}
