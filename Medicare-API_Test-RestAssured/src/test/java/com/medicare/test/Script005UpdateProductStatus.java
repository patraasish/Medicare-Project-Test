package com.medicare.test;

import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Script005UpdateProductStatus {
	@Test
	public void Upadate_Product_Status() {

		// URL: http://localhost:9010/update-product-status
		/*
		 *{
			 "id": 999,
			 "status": 0,
			}
		 */

		
		JSONObject body = new JSONObject();
		body.put("id",999);
		body.put("status", 0);
	
		
		Response response = RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/update-product-status")
				.contentType(ContentType.JSON)
				.body(body.toString())
				.when()
				.put()
				.then()
				.statusCode(200)
				.body("message",equalTo("Disprin+ Status Updated Successfully."))
				.body("product.id",equalTo(999))
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
