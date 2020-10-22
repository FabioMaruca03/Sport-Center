package com.marufeb.fiverr;

import com.marufeb.fiverr.exceptions.IllegalCustomerIDExceptions;

public abstract class CustomerDetails {
    private final String id;
    private Address address;
    private String regionalCode;
    protected Float totalPrice;

    public CustomerDetails(String id, Address address, String regionalCode, Float totalPrice) throws IllegalCustomerIDExceptions, IllegalAccessException {
        if (!validateID(id.substring(0, 8)) || !id.contains(regionalCode))
            throw new IllegalCustomerIDExceptions("Customer id: "+id+" is not well formed!");
        this.id = id;
        if (address.getAddress().isBlank())
            throw new IllegalAccessException("Address cannot be blank! [id: "+id+" ]");
        this.address = address;
        this.regionalCode = regionalCode;
        if (totalPrice < 0)
            throw new IllegalAccessException("Total price cannot be negative! [id: "+id+" ]");
        this.totalPrice = totalPrice;
    }

    private static boolean validateID(String id) {
        if (id.charAt(0) == 'P' || id.charAt(0) == 'C') {
            String r = id.substring(1, 3);
            if (!r.equals("SC") && !r.equals("WA") && !r.equals("NI") && !r.equals("NE") && !r.equals("NW")
                    && !r.equals("MI") && !r.equals("EA") && !r.equals("SE") && !r.equals("SW") && !r.equals("GL"))
                return false;
            if (id.charAt(3) != '-')
                return false;

            for (int i = 4; i < 8; i++) {
                if (!Character.isDigit(id.charAt(i)))
                    return false;
            }
            return true;
        }
        return false;
    }

    abstract int getDiscount();

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public String getRegionalCode() {
        return regionalCode;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRegionalCode(String regionalCode) {
        this.regionalCode = regionalCode;
    }
}
