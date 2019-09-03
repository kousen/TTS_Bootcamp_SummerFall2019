package com.tts;

import com.tts.hr.Employee;
import com.tts.hr.Hourly;
import com.tts.hr.Salaried;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionsTests {
    @Test
    public void toStringOnArrayList() {
        List<String> strings = new ArrayList<>();
        strings.add("this");
        strings.add("is");
        strings.add("a");
        strings.add("list");

        System.out.println(strings);
    }

    @Test
    public void ArrayListOfEmployee() {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Salaried("Fred"));
        emps.add(new Salaried("Barney"));
        emps.add(new Hourly("Wilma"));
        emps.add(new Hourly("Betty"));

        System.out.println(emps);
    }
}
