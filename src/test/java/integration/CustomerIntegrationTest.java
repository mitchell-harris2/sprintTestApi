package integration;

import io.restassured.response.ValidatableResponse;
import objects.Customer;
import org.junit.Test;

import java.net.URL;
import java.util.Arrays;
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

        ValidatableResponse response = given().queryParam("firstName", "sam")
                .when().get("/stuff")
                .then().body("[0].firstName", is("sam"))
                .body("[0].lastName", is("Iam"));

    }

    @Test
    public void testGetFullNames() {
        String fullName = "sam Iam";

        ValidatableResponse response = given()
                .when().get("/fullNames")
                .then().body("[0].fullName", is(fullName));

    }

    @Test
    public void testGetSortedCustomers() {

        ValidatableResponse response = given()
                .when().get("/sortedCustomers").then()
                .body("[0].lastName", is("baggins"))
                .body("[1].lastName", is("Iam"))
                .body("[2].lastName", is("marx"))
                .body("[3].lastName", is("saget"))
                .body("[4].lastName", is("shore"))
                .body("[5].lastName", is("vandelay"));

    }

    @Test
    public void testGetSortedCustomers_pageZero() {
        ValidatableResponse response = given().queryParam("page", "0")
                .when().get("/sortedCustomers").then()
                .body("[0].lastName", is("baggins"))
                .body("[1].lastName", is("Iam"))
                .body("[2].lastName", is("marx"))
                .body("[3].lastName", is("saget"))
                .body("[4].lastName", is("shore"));
    }

    @Test
    public void testGetSortedCustomers_pageOne() {
        ValidatableResponse response = given().queryParam("page", "1")
                .when().get("/sortedCustomers").then()
                .body("[0].lastName", is("vandelay"));
    }
}
