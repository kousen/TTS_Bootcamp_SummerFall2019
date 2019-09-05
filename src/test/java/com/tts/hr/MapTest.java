package com.tts.hr;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapTest {
    private Map<String, Integer> map = new HashMap<>();

    @Test
    public void loopOverKeySet() {
        map.put("Buffy", 25);
        map.put("Willow", 24);
        map.put("Xander", 28);

        Set<String> names = map.keySet();

        for (String name : map.keySet()) {
            assertTrue(names.contains(name));
        }
    }

    @Test
    public void loopOverEntrySet() {
        map.put("Buffy", 25);
        map.put("Willow", 24);
        map.put("Xander", 28);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("There are " + entries.size() + " entries");
        map.forEach((k,v) -> assertEquals(map.get(k), v));
    }
}



