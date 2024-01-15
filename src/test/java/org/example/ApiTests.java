package org.example;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.data.StatusDataProvider;
import org.example.model.Data;
import org.example.model.Root;
import org.example.model.Support;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class ApiTests extends BaseTest{
    @Test//(dataProvider = "statusDataProvider", dataProviderClass = StatusDataProvider.class)

    public void getPetsByStatus(String statusValue) {

        RequestSpecification spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io")
               .build();

        given()
                .spec(getRequestSpecification("https://petstore.swagger.io"))
                .queryParam("status", statusValue)
                .when()
                .get("/v2/pet/findByStatus")
                .then()
                .statusCode(200)
                .log().
                all();
    }
    @Test
    public void verifyBodyOfPetsStatusEndpoint() {
        Root rootObject = given()
                .spec(getRequestSpecification("https://reqres.in"))
                .when()
                .get("api/users/2")
                .then()
                .extract()
                .as(Root.class);

        Root expectedData =
                Root.builder()
                        .data(Data.builder()
                                .id(2)
                                .email("janet.weaver@reqres.in")
                                .first_name("Janet")
                                .last_name("Weaver")
                                .avatar("https://reqres.in/img/faces/2-image.jpg")
                                .build())
                        .support(Support.builder()
                                .url("https://reqres.in/#support-heading")
                                .text("To keep ReqRes free, contributions towards server costs are appreciated!")
                                .build())
                        .build();

        Assert.assertEquals(rootObject, expectedData);
    }
    @Test
    public void postPet(){
        byte[] body = new byte[0];
        try{
         body = Files.readAllBytes(Path.of("Users/omali/IdeaProjects/ApiTesting/src/test/resourses/body.json"));
        } catch (IOException e){
          throw new RuntimeException(e);
        }

        given()
                .body(body)
                .when()
                .post("/pet")
                .then().statusCode(200);

    }

}
