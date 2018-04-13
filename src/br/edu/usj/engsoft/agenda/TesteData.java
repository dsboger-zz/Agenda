package br.edu.usj.engsoft.agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteData {

	@Test
	void testaCoincideCom1() {
		Data d1 = new Data(1, 1, 2000);
		Data d2 = new Data(1, 1, 2000);
		
		assertTrue(d1.coincideCom(d2));
	}
	
	@Test
	void testaCoincideCom2() {
		Data d1 = new Data(1, 1, 2000);
		Data d2 = new Data(2, 3, 2005);
		
		assertFalse(d1.coincideCom(d2));
	}
	
	@Test
	void testaCoincideCom3() {
		Data d1 = new Data(1, 1, 2000);
		Data d2 = new Data(1, 1, 2005);
		
		assertFalse(d1.coincideCom(d2));
	}
	
	@Test
	void testaCoincideCom4() {
		Data d1 = new Data(1, 1, 2000);
		Data d2 = new Data(1, 2, 2000);
		
		assertFalse(d1.coincideCom(d2));
	}
	
	@Test
	void testaCoincideCom5() {
		Data d1 = new Data(1, 1, 2000);
		Data d2 = new Data(2, 1, 2000);
		
		assertFalse(d1.coincideCom(d2));
	}

}
