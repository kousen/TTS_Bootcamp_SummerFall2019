package com.tts;

import com.tts.after.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    private Person p = new Person();

    @Test
    public void testName() {
        p.setName("James Kirk");
        assertEquals("James Kirk", p.getName());
    }

    @Test
    public void testSingleName() {
        p.setName("Spock");
        assertEquals("Spock", p.getName());
    }
}