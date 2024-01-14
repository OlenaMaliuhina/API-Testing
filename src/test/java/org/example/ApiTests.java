package org.example;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.model.Root;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class ApiTests extends BaseTest{
    @Test

    public void getPetsByStatus() {

        RequestSpecification spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io")
                .build();

        given()
                .spec(getRequestSpecification("https://petstore.swagger.io"))
                .when()
                .get("/v2/pet/findByStatus?status=available")
                .then()
                .statusCode(200)
                .log().
                all();
    }
    public void verifyBodyOfPetsStatusEndpoint() {
        Root rootObject = given()
                .when()
                .get("/v2/pet/findByStatus?status=available")
                .then()
                .extract()
                .as(Root.class);


        Root expectedData = new Root();
        Root.
               // Root expectedData = Root.
    }
}
