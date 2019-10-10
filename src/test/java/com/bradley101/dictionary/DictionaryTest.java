package com.bradley101.dictionary;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DictionaryTest {
	
	@Test
	public void of() {
		Dictionary dict = new Dictionary();
		dict.of("test");
		assert true;
	}
	
	@Test
	public void val() {
		Dictionary dict = new Dictionary();
		of();
		setTo();
		assertEquals("okay working", dict.of("test").val());
	}
	
	@Test
	public void setTo() {
		Dictionary dict = new Dictionary();
		of();
		dict.of("test").setTo("okay working");
		assert true;
	}
}