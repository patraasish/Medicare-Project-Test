package com.medicare.test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Script006DeleteProduct {
	@Test
	public static void delete_product() {

	
	//http://localhost:9010/delete-product?id=101
	Response response = RestAssured
			.given()
			.baseUri("http://localhost:9010")
			.basePath("/delete-product")
			.queryParam("id", 101)
			.when()
			.delete()
			.then()
			.statusCode(200)
			.body("message",equalTo("Product with ID 101 Deleted Successfully."))
			.extract()
			.response();

	System.out.println(response.getBody().asPrettyString());
	System.out.println("Status Code " + response.getStatusCode());
	System.out.println("Response Time: "+response.getTime());
	System.out.println("Content Type: "+response.getHeader("Content-Type"));
	int expectStatusCode = 200;
	int ActualStatusCode = response.getStatusCode();
	Assert.assertEquals(expectStatusCode, ActualStatusCode);
}
}
