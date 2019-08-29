package com.tts.hr;

import org.junit.Test;

import static org.junit.Assert.*;

public class HRTest {

    @Test
    public void payEverybody() {
        HR hr = new HR();
        hr.hire(new Salaried("Buffy"));
        hr.hire(new Hourly("Willow"));

        System.out.println(hr.payEverybody());
    }
}

