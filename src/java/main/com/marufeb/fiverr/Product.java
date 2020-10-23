package com.marufeb.fiverr;

import com.marufeb.fiverr.exceptions.InvalidProductCodeException;
import com.sun.source.tree.IfTree;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String code;
    private float price;

    public Product(String code, float price) {
        this.code = code;
        this.price = price;
    }

    public static List<Product> parse(String codes, String ppu) throws InvalidProductCodeException {
        String[] code = codes.split("#");
        String[] SPPUs = ppu.split("#");
        if (code.length != SPPUs.length)
            throw new IllegalArgumentException("Wrong codes given");
        for (String s : code) {
            String[] sides = s.split("/");
            if (sides.length != 2 || sides[0].length() != 2 ||
                    !Character.isAlphabetic(sides[0].charAt(0)) || !Character.isAlphabetic(sides[0].charAt(1)) ||
                    !Character.isDigit(sides[1].charAt(0)) || !Character.isDigit(sides[1].charAt(1)) ||
                    Character.isDigit(sides[1].charAt(2)))
                throw new InvalidProductCodeException("Code : " + s + " is not valid!");
        }
        float[] PPUs = new float[SPPUs.length];
        try {
            for (int i = 0; i < SPPUs.length; i++) {
                PPUs[i] = Float.parseFloat(SPPUs[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Cannot parse prices for products!");
        }

        List<Product> result = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            result.add(new Product(code[i], PPUs[i]));
        }

        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
