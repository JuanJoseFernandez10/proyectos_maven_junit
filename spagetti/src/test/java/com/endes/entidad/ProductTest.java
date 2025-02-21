package com.endes.entidad;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {

	public Product p1;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = new Product("Helado", 20.55); 
	}
	
	/*
		**Tests de Constructor**
	*/
	
	@DisplayName("Test del constructor correcto")
	@Test
	void testConstructor() {

			p1 = new Product("Turron", 20.55);
			Assertions.assertDoesNotThrow(IllegalArgumentException, "");
	}
	
	
	@DisplayName("Test constructor nombre en blanco")
	@Test
	void testConstructorEmpty() {
		try {
		p1 = new Product("", 20.55);
		}catch(IllegalArgumentException e) {
		String expectedMessage = "Error: Nombre inválido";
	    String actualMessage = e.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
		}
	}
	
	@DisplayName("Test constructor nombre es nulo")
	@Test
	void testConstructorNull() {
		try {
		p1 = new Product("4543", 20.55);
		}catch(IllegalArgumentException e) {
		String expectedMessage = "Error: Nombre inválido";
	    String actualMessage = e.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
		}
	}
	
	@DisplayName("Test constructor precio en negativo")
	@Test
	void testConstructorPrecioNegativo() {
		try {
		p1 = new Product("Helado", -20.55);
		}catch(IllegalArgumentException e) {
		String expectedMessage = "Error: Precio negativo";
	    String actualMessage = e.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
		}
	}
	
	/*
		**Tests de Getters**
	*/
	
	@DisplayName("Test del Getter del nombre")
	@Test
	void testGetterName() {
		String value = p1.getName();
		String valueExpected = "Helado";
		assertEquals(value, valueExpected);
	}
	
	@DisplayName("Test del Getter del precio")
	@Test
	void testGetterPrice() {
		double value = p1.getPrice();
		double valueExpected = 20.55;
		assertEquals(value, valueExpected);
	}
	
	/*
	 	**Tests de Setters**
	*/
	
	@DisplayName("Test del Setter del nombre con nombre Null")
	@Test
	void testSetterNameNull() {
		try {
			p1 = new Product("", 20.55);
			}catch(IllegalArgumentException e) {
			String expectedMessage = "Error: Nombre inválido";
		    String actualMessage = e.getMessage();
		    assertTrue(actualMessage.contains(expectedMessage));
		}
	}

}
