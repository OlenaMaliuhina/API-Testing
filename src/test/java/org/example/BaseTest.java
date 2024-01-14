package org.example;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
   @BeforeMethod
    protected void initTest(){
        RestAssured.baseURI = "https://petstore.swagger.io/";

        RequestSpecification specification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/")
                .build();
    }
      protected RequestSpecification getRequestSpecification(String host){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(host)
                .build();
      }

    protected ResponseSpecification getResponseSpecification(String host){
        return new ResponseSpecBuilder().setDefaultParser(Parser.JSON)
                   .build();
    }
}
