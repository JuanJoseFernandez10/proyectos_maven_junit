package com.ende;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestTermometro {
	Termometro t1;
	@BeforeEach
	void setUp() throws Exception {
		t1 = new Termometro(20);
	}
	
	/*
	 *   #############################
	 *   #   Test GetterTemperatura  #
	 *   #############################
	 */
	
	@Test
	@DisplayName("Obtenemos temeperatura esperada")
	void testGetTemperatura() {
		double valor = t1.getTemperaturaCelsius();
		double valorEsperado = 20.0;
		assertEquals(valorEsperado, valor, "No corresponden las temperaturas");
	}
	
	/*
	 *   #############################
	 *   #   Test SetterTemperatura  #
	 *   #############################
	 */
	
	@Test
	@DisplayName("Pondremos una temepratura para ver si es la esparada")
	void tesSetTemperatura() {
		t1.setTemperaturaCelsius(68); 
		double valor = t1.getTemperaturaCelsius();
		assertEquals(68.0, valor, "La temperatura no se ha puesto correctamente");
	}
	
	@Test
	@DisplayName("Pondremos una temepratura negativa para ver si es la esparada")
	void testSetTemperaturaNegativa() {
		t1.setTemperaturaCelsius(-24);
		double valor = t1.getTemperaturaCelsius();
		assertEquals(-24.0, valor, "La temperatura no se ha puesto corrrectamente");
	}
	
	/*
	 *   ###############################
	 *   #  Test ConvertirAFahrenheit  #
	 *   ###############################
	 */

	@Test
	@DisplayName("La temperatura en Fahrenheit debe corresponder con la esperada")
	void testConvertirAFahrenheit() {
		double valor = t1.convertirAFahrenheit();
		double valorEsperado = 68.0;
		assertEquals(valorEsperado, valor, "Esta convirtiendo mal");
	}

	@Test
	@DisplayName("Mismo caso pero con temperatura negativa")
	void testConvertirAFahrenheitNegativo() {
		t1.setTemperaturaCelsius(-20);
		double valor = t1.convertirAFahrenheit();
		double valorEsperado = -4.0;
		assertEquals(valorEsperado, valor, "Esta convitiendo mal");
	}

	/*
	 *   ###############################
	 *   #    Test ConvertirAKelvin    #
	 *   ###############################
	 */
	
	@Test
	@DisplayName("La conversion en Kelvin debe corresponder con la esperada")
	void testConvertirAKelvin() {
		double valorEsperado = t1.getTemperaturaCelsius() + 273.15;
		double valor = t1.convertirAKelvin();
		assertEquals(valorEsperado, valor, "Error las dos temperatura no son iguales");
	}
	
	@Test
	@DisplayName("La conversion en Kelvin en cero absoluto no debe efectuarse")
	void testConvertirAKelvinNegativo() {
		t1.setTemperaturaCelsius(-300.50);
		String ExcepcionEsperada = "La temperatura no puede estar por debajo del cero absoluto.";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> t1.convertirAKelvin());
		assertEquals(ExcepcionEsperada, exception.getMessage(), "Error la excepciones no coinciden o no ha sido lanzada");
	}
	
	/*
	 *   ###############################
	 *   #    Test ajustarTemperatura  #
	 *   ###############################
	 */
	
	@Test
	@DisplayName("Ajuste de la temperatura debe ser la esperada")
	void testAjustarTemperatura() {
		double valorEsperado = t1.getTemperaturaCelsius() + 20;
		t1.ajustarTemperatura(20);
		double valor = t1.getTemperaturaCelsius();
		assertEquals(valorEsperado, valor, "El valor de el ajuste no ha sido el esperado");
	}
	
	@Test
	@DisplayName("Ajuste de la temperatura pero en negativo debe ser la esperada")
	void testAjustarTemperaturaNegativo() {
		double valorEsperado = t1.getTemperaturaCelsius() - 20;
		t1.ajustarTemperatura(-20);
		double valor = t1.getTemperaturaCelsius();
		assertEquals(valorEsperado, valor, "El valor de el ajuste no ha sido el esperado");
	}
	
	/*
	 *   ###############################
	 *   #       Test estaEnRango      #
	 *   ###############################
	 */
	
	@Test
	@DisplayName("Esta en rango la temperatura debe coincider con true or false")
	void testEstaEnRangoMin() {
		double minimo = 40;
		double maximo = 50;
		assertFalse(t1.estaEnRango(minimo, maximo), "El rango ha sido reconocido como valido siendo invalido");
	}
	@Test
	@DisplayName("Esta en rango la temperatura debe coincider con true or false")
	void testEstaEnRangoMax() {
		double minimo = 10;
		double maximo = 15;
		assertFalse(t1.estaEnRango(minimo, maximo), "El rango ha sido reconocido como valido siendo invalido");
	}
	@Test
	@DisplayName("Esta en rango la temperatura debe coincider con true or false")
	void testEstaEnRangoMinMax() {
		double minimo = 30;
		double maximo = 10;
		assertFalse(t1.estaEnRango(minimo, maximo), "El rango ha sido reconocido como valido siendo invalido");
	}
	@Test
	@DisplayName("Esta en rango la temperatura debe coincider con true")
	void testEstaEnRangoTrue() {
		double minimo = 10;
		double maximo = 30;
		assertTrue(t1.estaEnRango(minimo, maximo), "El rango ha sido reconocido como valido siendo invalido");
	}
	
	/*
	 *   ###############################
	 *   #      Test esCongelacion     #
	 *   ###############################
	 */
	
	@Test
	@DisplayName("Es congelacion la temperatura debera coincidir con true o false")
	void testEsCongelacion() {		
		assertFalse(t1.esCongelacion(), "El resultado es valido cuando deberia ser invalido");
	}
	@Test
	@DisplayName("Es congelacion la temperatura debera coincidir con true o false")
	void testEsCongelacionTrue() {	
		t1.setTemperaturaCelsius(-2);
		assertTrue(t1.esCongelacion(), "El resultado es valido cuando deberia ser invalido");
	}
	
	/*
	 *   ###############################
	 *   #      Test esEbullicion     #
	 *   ###############################
	 */
	
	@Test
	@DisplayName("Es ebullicion la temperatura debera coincidir con true ")
	void testEsEbullicion() {		
		assertFalse(t1.esEbullicion(), "El resultado es valido cuando deberia ser invalido");
	}
	@Test
	@DisplayName("Es ebullicion la temperatura debera coincidir con false")
	void testEsEbullicionTrue() {	
		t1.setTemperaturaCelsius(102);
		assertTrue(t1.esEbullicion(), "El resultado es valido cuando deberia ser invalido");
	}
	
	
	
	
	
	
	
	
}
