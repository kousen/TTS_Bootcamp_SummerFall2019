package com.tts.hr;

import org.junit.Test;

import java.io.Console;
import java.util.*;

public class MapTest {
    private Map<String, Integer> map = new HashMap<>();

    private void assertTrue() {
    }

    @Test
    public void loopOverEntries() {
        map.put("Buffy", 25);
        map.put("Willow", 24);
        map.put("Xander", 28);

        Set<String> names = map.keySet();

        for (String name : map.keySet()) {
            System.out.println(map.get(name));
            assertTrue(names.contains(name));


        }

        @Test(expected = NullPointerException);
        public void loopOverEntrySet(names) {
            map.put("Buffy", 25);
            map.put("Willow", 24);
            map.put("Xander", 28);

            Set<String> names = map.keySet();

            Set<Map.Entry<String, Integer>> entries = map.entrySet();

            for (String name : map.keySet()) {
                System.out.println(map.get(name));
                assertEquals(values.contains(name));

            }
        }

        @Test
        public void getDataFromConsole() {
            Map<String, String> data = new HashMap<>(());
            Console console = System.console();
            System.out.println("What is your name?");
            data.put("Name", console.readLine());
            System.out.println("What is your age?");
            data.put("Age", console.readLine());
            System.out.println("What is your location?");
            data.put("Location", console.readLine());

            System.out.println("This is" + data.get("Name"));
            System.out.println("They are " + data.get("Age") + " years old");
            System.out.println("from" + data.get("Location"));
        }
        }


    }


