package com.song.taxSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("PItems")
public class PItem {
    @Id
    @Column("ItemID")
    private int itemId;

    @Column("Pid")
    private int purchaseId;

    @Column("Price")
    private double price;

    @Column("ItemName")
    private String itemName;

    @Column("Quantity")
    private int quantity; 

    public PItem() {
    }

    public PItem(int itemId, int purchaseId, double price, String itemName, int quantity) {
        this.itemId = itemId;
        this.purchaseId = purchaseId;
        this.price = price;
        this.itemName = itemName;
        this.quantity = quantity; 
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PItem pItem = (PItem) o;
        return itemId == pItem.itemId && purchaseId == pItem.purchaseId && price == pItem.price && Objects.equals(itemName, pItem.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, purchaseId, price, itemName);
    }
}
