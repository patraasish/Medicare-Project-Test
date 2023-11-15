package com.medicare.test;

import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Script004UpdateProduct {
	@Test
	public void Upadate_Product() {

		// URL: http://localhost:9010/update-product
		/*
		 * {
			 "id": 999,
			 "image": "2.png",
			 "name": "Disprin+",
			 "category": "medicine",
			 "brand": "BZ Medico",
			 "status": 1,
			 "price": 120
			}
		 */

		
		JSONObject body = new JSONObject();
		body.put("id",999);
		body.put("image", "2.png");
		body.put("name", "Disprin+");
		body.put( "category", "medicine");
		body.put( "brand","BZ Medico");
		body.put("status", 1);
		body.put( "price", 120);
		
		
		Response response = RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/update-product")
				.contentType(ContentType.JSON)
				.body(body.toString())
				.when()
				.put()
				.then()
				.statusCode(200)
				.body("message",equalTo("Disprin+ Updated Successfully."))
				.body("product.id",equalTo(999))
				.body("product.image",equalTo("2.png"))
				.body("product.name",equalTo("Disprin+"))
				.body("product.category",equalTo("medicine"))
				.body("product.brand",equalTo("BZ Medico"))
				.body("product.status",equalTo(1))
				.body("product.price",equalTo(120))
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