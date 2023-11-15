package com.medicare.test;

import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Script003AddProduct {
	

	@Test
	public void AddProduct() {

		/*
					 *{
			 "id": 999,
			 "image": "1.png",
			 "name": "Disprin",
			 "category": "medicine",
			 "brand": "BZ Medico",
			 "status": 1,
			 "price": 100
			}

		 */
		//http://localhost:9010/add-product
		JSONObject body = new JSONObject();
		body.put("id",999);
		body.put("image", "1.png");
		body.put("name", "Disprin");
		body.put( "category", "medicine");
		body.put( "brand","BZ Medico");
		body.put("status", 1);
		body.put( "price", 100);
		
		Response response = RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/add-product")
				.contentType(ContentType.JSON)
				.body(body.toString())
				.when()
				.post()
				.then()
				.statusCode(200)
				.body("message",equalTo("Disprin Added Successfully."))
				.body("products.id",equalTo(999))
				.body("products.image",equalTo("1.png"))
				.body("products.name",equalTo("Disprin"))
				.body("products.category",equalTo("medicine"))
				.body("products.brand",equalTo("BZ Medico"))
				.body("products.status",equalTo(1))
				.body("products.price",equalTo(100))
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
