package com.dkb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.SneakyThrows;

public class BankAccountControllerIT {

	static String IBAN = null;;
	static UUID customerId = null;
	static ObjectMapper mapper = new ObjectMapper();
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.registerModule(new JavaTimeModule());
		mapper.setDateFormat(dateFormat);
		IBAN = String.valueOf(new Date().getTime());
		RestAssured.baseURI = "http://localhost:8860";
	}

	@Test
	@Ignore
	@SneakyThrows
	public void user_journey() {

		Response response = RestAssured.given().param("firstName", "Ali").param("lastName", "Awan")
				.post("/customers/reg").andReturn();

		response.then().statusCode(200);
		
		response.then().statusCode(204);
	}

}
