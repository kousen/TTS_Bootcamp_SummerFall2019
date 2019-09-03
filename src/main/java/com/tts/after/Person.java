package com.tts.after;

public class Person {
    private String firstName = "";
    private String lastName = "";

    public Person() {

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return firstName.equals("") ?
                lastName :
                firstName + " " + lastName;
    }

    public void setName(String name) {
        String[] names = name.split(" ");
        if (names.length == 2) {
            firstName = names[0];
            lastName = names[1];
        } else if (names.length == 1) {
            firstName = "";
            lastName = name;
        } else {
            firstName = names[0];
            lastName = names[names.length - 1];
        }
    }
}
