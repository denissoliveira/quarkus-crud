package br.com.qrksCrud.resources;

import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
class ProdutoResourceTest {

	@Test
	void test() {
		RestAssured.given()
      .when().get("/hello")
      .then()
         .statusCode(200)
         .body(is("Hello RESTEasy"));
	}

}
