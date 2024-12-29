package com.song.taxSystem.model;

import java.util.List;

public class CheckoutRequest {
    private int userId; 
    private double total; 
    private List<PItem> items;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTotal(double total){
        this.total = total; 
    }

    public double getTotal(){
        return total; 
    }

    public List<PItem> getItems() {
        return items;
    }

    public void setItems(List<PItem> items) {
        this.items = items;
    } 
}
