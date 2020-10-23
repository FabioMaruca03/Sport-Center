package com.marufeb.fiverr;

import com.marufeb.fiverr.exceptions.CustomerNotFoundException;
import com.marufeb.fiverr.exceptions.IllegalDateFormatException;
import com.marufeb.fiverr.exceptions.IncorrectPurchaseOrderException;
import com.marufeb.fiverr.exceptions.InvalidProductCodeException;

import java.time.LocalDate;

public class SportsEquipmentSupplier {
    private int y = LocalDate.now().getYear(), m = LocalDate.now().getMonthValue();
    private PurchaseOrderList list = new PurchaseOrderList();
    /**
     * Generates a new purchase order record for the current month
     * and updates record of purchasing customer
     * @param date a String with format "dd/mm/yy"
     * @param customerID must be the ID of a customer in the the company’s
     * customer records
     * @param p must be in the company’s current product range
     * @param qty the number of items required of the product
     * @throws IncorrectPurchaseOrderException exception!
     */
    public void addNewPurchaseOrder(String date, String customerID, String p, int qty)
            throws IncorrectPurchaseOrderException, IllegalDateFormatException, InvalidProductCodeException, CustomerNotFoundException {
        OrderDate d = OrderDate.parse(date);
        list.add(
                new PurchaseOrder(
                        d,
                        customerID,
                        CustomerDetailsList.findCustomer(customerID)
                                .getDiscount(),
                        Product.parse(p, String.valueOf(qty))
                                .get(0),
                        qty
                )
        );
    }
    /**
     * increments the index of the current month. 12 (December) is followed
     * by 1 (January). Updates this supplier’s records as appropriate.
     */
    public void updateMonth() {
        if (m+1 >12){
            m = 1;
            y++;
        } else m++;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public PurchaseOrderList getList() {
        return list;
    }

    public void setList(PurchaseOrderList list) {
        this.list = list;
    }
}
