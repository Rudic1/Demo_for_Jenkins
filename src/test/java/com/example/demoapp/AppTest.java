package com.example.demoapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
	

    @Test
    public void testGreet() {
        String result = App.greet("Jenkins");
        assertEquals("Hello, Jenkins!", result, "Die Begrüßung sollte korrekt sein.");
    }

    @Test
    public void testGreetEmptyName() {
        String result = App.greet("");
        assertEquals("Hello, !", result, "Die Begrüßung sollte auch für einen leeren Namen korrekt sein.");
    }
    
    @Test
    public void testAddition() {
        assertEquals(2, App.add(1, 1));
    }
    
    
}