package ch.m1m.rpat;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ConfigResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/v1/config/info")
          .then()
             .statusCode(200)
             .body(containsString("running"));
    }

}