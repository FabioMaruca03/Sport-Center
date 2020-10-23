package com.marufeb.fiverr;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PurchaseOrderList {
    private List<PurchaseOrder> orders = new ArrayList<>();
    public void add(PurchaseOrder p) {
        orders.add(p);
    }
    public void remove(PurchaseOrder p) {
        orders.remove(p);
    }

    /**
     * @return an array containing all the purchase orders in this list,
     * if this list is not empty, otherwise null.
     */
    public PurchaseOrder [] getPurchaseOrders() {
        return orders.toArray(PurchaseOrder[]::new);
    }
}
