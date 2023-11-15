package steps;


import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StepDefination {

		@Given("A list of users are registered")
		public void a_list_of_users_are_registered() {
			
			//http://localhost:9010/get-users
			Response response = RestAssured
					.given()
					.baseUri("http://localhost:9010")
					.basePath("/get-users")
					.when()
					.get()
					.then()
					.statusCode(200)
					.extract()
					.response();
		
			System.out.println(response.getBody().asPrettyString());
			System.out.println("Status Code " + response.getStatusCode());
			System.out.println("Response Time: "+response.getTime());
			System.out.println("Content Type: "+response.getHeader("Content-Type"));
		
		}

			@Given("A list of products are available")
			public void a_list_of_products_are_available() {
				//http://localhost:9010/get-products
						Response response = RestAssured
								.given()
								.baseUri("http://localhost:9010")
								.basePath("/get-products")
								.when()
								.get()
								.then()
								.statusCode(200)
								.extract()
								.response();
					
						System.out.println(response.getBody().asPrettyString());
						System.out.println("Status Code " + response.getStatusCode());
						System.out.println("Response Time: "+response.getTime());
						System.out.println("Content Type: "+response.getHeader("Content-Type"));
						
			}

			@When("I add a product")
			public void i_add_a_product() {
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
					
					RestAssured
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
					}
			
			@Then("The product is added")
			public void the_product_is_added() {
				Response response = RestAssured
						.given()
						.baseUri("http://localhost:9010")
						.basePath("/get-products")
						.when()
						.get()
						.then()
						.statusCode(200)
						.extract()
						.response();
			
				System.out.println(response.getBody().asPrettyString());   
			}
			
			@When("I update the product details")
			public void i_update_the_product_details() {
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
			}
			
			@Then("The product details is updated")
			public void the_product_details_is_updated() {
				Response response = RestAssured
						.given()
						.baseUri("http://localhost:9010")
						.basePath("/get-products")
						.when()
						.get()
						.then()
						.statusCode(200)
						.extract()
						.response();
			
				System.out.println(response.getBody().asPrettyString());   
			}
			
			@When("I update the product Status")
			public void i_update_the_product_status() {
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
			}
			
			@Then("The product Status is updated")
			public void the_product_status_is_updated() {
				Response response = RestAssured
						.given()
						.baseUri("http://localhost:9010")
						.basePath("/get-products")
						.when()
						.get()
						.then()
						.statusCode(200)
						.extract()
						.response();
			
				System.out.println(response.getBody().asPrettyString());   
			    }
			
			@When("I delete the product")
			public void i_delete_the_product() {

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
			}
			
			@Then("The product is deleted")
			public void the_product_is_deleted() {
				Response response = RestAssured
						.given()
						.baseUri("http://localhost:9010")
						.basePath("/get-products")
						.when()
						.get()
						.then()
						.statusCode(200)
						.extract()
						.response();
			
				System.out.println(response.getBody().asPrettyString()); 
			}
			
			}
