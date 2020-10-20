package com.marufeb.fiverr;

public class SportClubDetails extends CustomerDetails{
    private String name;
    private int clubDiscount;

    private SportClubDetails(String id, Address address, String regionalCode, Float totalPrice) throws IllegalCustomerIDExceptions, IllegalAccessException {
        super(id, address, regionalCode, totalPrice);
    }

    @Override
    int getDiscount() {
        return 0;
    }
}
