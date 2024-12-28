package com.song.taxSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("PItem")
public class PItem {
    @Id
    @Column("ItemID")
    private int itemId;

    @Column("PID")
    private int purchaseId;

    @Column("Price")
    private int price;

    @Column("ItemName")
    private String itemName;

    public PItem() {
    }

    public PItem(int itemId, int purchaseId, int price, String itemName) {
        this.itemId = itemId;
        this.purchaseId = purchaseId;
        this.price = price;
        this.itemName = itemName;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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
