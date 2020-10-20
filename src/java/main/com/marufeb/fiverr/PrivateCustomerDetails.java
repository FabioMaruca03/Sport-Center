package com.marufeb.fiverr;

public class PrivateCustomerDetails extends CustomerDetails{
    private String fullName;
    private String title;
    private String surname;

    private PrivateCustomerDetails(String id, Address address, String regionalCode, Float totalPrice) throws IllegalCustomerIDExceptions, IllegalAccessException {
        super(id, address, regionalCode, totalPrice);
    }

    @Override
    int getDiscount() {
        return 0;
    }

    public static PrivateCustomerDetails parse(String customer) throws IllegalCustomerIDExceptions, IllegalAccessException {
        String[] l = customer.split(",");
        if (l.length!=2)
            throw new IllegalArgumentException("Cannot parse private customer: "+customer);
        String pc = l[0];
        String[] details = pc.split("/");
        if (details.length != 5)
            throw new IllegalArgumentException("Cannot parse private customer: "+customer);
        String address = l[1];
        PrivateCustomerDetails cd = new PrivateCustomerDetails(
                details[0], new Address(address), details[0].substring(1,3), Float.parseFloat(details[4])
        );

        cd.title = details[1];
        cd.fullName = details[2];
        cd.surname = details[3];

        return cd;
    }


    public String getFullName() {
        return fullName;
    }

    private void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

}
