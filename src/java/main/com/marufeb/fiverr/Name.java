package com.marufeb.fiverr;

public class Name {

    private final String name;
    private final Address address;

    public Name(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
