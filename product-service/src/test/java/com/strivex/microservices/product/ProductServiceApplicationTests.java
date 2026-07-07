package com.strivex.microservices.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;

import static io.restassured.RestAssured.port;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	static PostgreSQLContainer<?> postgres =
			new PostgreSQLContainer<>("postgres:18");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		postgres.start();
	}

	@Test
	void shouldCreateProduct() {
		String requestBody = """
				{
				  "name": "iPhone 16 Pro Msx",
				  "description": "Apple flagship smartphone with A18 Pro chip",
				  "price": 249999.99
				}
				""";
		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/product")
				.then()
				.statusCode(200)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("iPhone 16 Pro Msx"))
				.body("description", Matchers.equalTo("Apple flagship smartphone with A18 Pro chip"))
				.body("price", Matchers.equalTo(249999.99));

	}

}
