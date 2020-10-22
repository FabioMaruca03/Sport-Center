package com.marufeb.fiverr;

import com.marufeb.fiverr.exceptions.CustomerNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDetailsList {
    private static final List<CustomerDetails> list = new ArrayList<>();

    /**
     * @param givenID the ID of a customer
     * @return the customer’s details if found, exception thrown
     * otherwise.
     */
    public static CustomerDetails findCustomer(String givenID) throws CustomerNotFoundException {
        Optional<CustomerDetails> result = list.stream().filter(it->it.getId().equals(givenID)).findFirst();
        if (result.isEmpty())
            throw new CustomerNotFoundException("Cannot find customer: "+givenID);
        return result.get();
    }

    public static boolean addCustomer(CustomerDetails details) {
        try {
            findCustomer(details.getId());
            return false;
        } catch (CustomerNotFoundException e) {
            list.add(details);
            return true;
        }
    }

    public static boolean remCustomer(CustomerDetails details) {
        return list.remove(details);
    }

}
