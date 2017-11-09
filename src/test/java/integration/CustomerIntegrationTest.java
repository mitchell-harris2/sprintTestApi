package integration;

import objects.Customer;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CustomerIntegrationTest {


    @Test
    public void testPostStuff_noParam() {
        Customer customer = new Customer("bob", "saget");

        given().body(customer)
            .when().post("/springThing/stuff")
            .then().body("id", notNullValue());
    }
}
