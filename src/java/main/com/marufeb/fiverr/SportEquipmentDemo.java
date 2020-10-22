package com.marufeb.fiverr;

import com.marufeb.fiverr.exceptions.IllegalCustomerIDExceptions;

import java.io.*;
import java.net.URISyntaxException;

public class SportEquipmentDemo {
    public static void main(String[] args) throws URISyntaxException, IllegalCustomerIDExceptions, IllegalAccessException, IOException {
        File input = new File(SportClubDetails.class.getResource("/CustomerData.txt").toURI());
        if (input.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            String customer = reader.readLine();
            while (customer != null) {
                if (customer.startsWith("P")) {
                    System.out.println("Parsing (P) "+customer);
                    PrivateCustomerDetails.parse(customer);
                } else if (customer.startsWith("C")) {
                    System.out.println("Parsing (C) "+customer);
                    SportClubDetails.parse(customer);
                }
                customer = reader.readLine();
            }
        } else System.exit(1);
    }
}
