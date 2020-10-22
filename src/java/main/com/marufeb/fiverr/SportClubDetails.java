package com.marufeb.fiverr;

import com.marufeb.fiverr.exceptions.IllegalCustomerIDExceptions;

public class SportClubDetails extends CustomerDetails{
    private String name;
    private int clubDiscount;

    public SportClubDetails(String id, Address address, String regionalCode, Float totalPrice) throws IllegalCustomerIDExceptions, IllegalAccessException {
        super(id, address, regionalCode, totalPrice);
    }

    public static SportClubDetails parse(String club) throws IllegalCustomerIDExceptions, IllegalAccessException {
        String[] c = club.split("/");
        if (c.length!=6)
            throw new IllegalArgumentException("Cannot parse club customer: " + club);
        String[] split = c[2].split(" ");
        String details = c[0] + "/" + c[1] + "/ " + split[0];
        String address = split[1] + "/" + c[3] + "/" + c[4];
        SportClubDetails cd = new SportClubDetails(
                details, new Address(address), c[0].substring(1,3), 0f
        );
        cd.clubDiscount = Integer.parseInt(c[5]);
        return cd;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getClubDiscount() {
        return clubDiscount;
    }

    public void setClubDiscount(int clubDiscount) {
        this.clubDiscount = clubDiscount;
    }

    @Override
    int getDiscount() {
        return 0;
    }
}
