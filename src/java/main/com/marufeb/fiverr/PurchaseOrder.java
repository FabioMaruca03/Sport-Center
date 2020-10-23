package com.marufeb.fiverr;

import com.marufeb.fiverr.exceptions.CustomerNotFoundException;
import com.marufeb.fiverr.exceptions.IllegalDateFormatException;

public class PurchaseOrder {
    private OrderDate date;
    private String customerID;
    private int discount;
    private Product product;
    private int quantity;

    public PurchaseOrder(OrderDate date, String customerID, int discount, Product product, int quantity) {
        this.date = date;
        this.customerID = customerID;
        this.discount = discount;
        this.product = product;
        this.quantity = quantity;
    }

    public static PurchaseOrder parse(String order) throws IllegalDateFormatException {
        // 10/01/18#CGL-5577#LR/499#12
        String[] details = order.split("#");
        OrderDate date = OrderDate.parse(details[0]);
        String id = details[1];
        String code = details[2];
        int discount = 0;
        int quantity = Integer.parseInt(details[3]);

        return new PurchaseOrder(date, id, discount, Product.get(code), quantity);
    }

    public float getFullPrice() {
        return product.getPrice();
    }

    public float getInvoice() throws CustomerNotFoundException {
        return product.getPrice()-product.getPrice()*
                (CustomerDetailsList.findCustomer(customerID).getDiscount()<=15?
                        CustomerDetailsList.findCustomer(customerID).getDiscount() :
                        Math.round(CustomerDetailsList.findCustomer(customerID).getTotalPrice()/500));
    }

}
