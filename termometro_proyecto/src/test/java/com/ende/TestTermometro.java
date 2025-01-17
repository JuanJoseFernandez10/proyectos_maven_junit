package com.ende;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	 *   ###############################
	 *   #  Test ConvertirAFahrenheit  #
	 *   ###############################
	 */

	@Test
	@DisplayName("La temperatura en Fahrenheit debe corresponder con la esperada")
	void testConvertirAFahrenheit() {
		double valor = t1.convertirAFahrenheit();
		double valorEsperado = 68.0;
		assertEquals(valorEsperado, valor);
	}

	@Test
	@DisplayName("Mismo caso pero con temperatura negativa")
	void testConvertirAFahrenheitNegativo() {
		t1.setTemperaturaCelsius(-20);
		double valor = t1.convertirAFahrenheit();
		double valorEsperado = -4.0;
		assertEquals(valorEsperado, valor);
	}
	
	@Test
	@DisplayName("")
	void test
	
}
