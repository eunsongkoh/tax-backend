package com.song.taxSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Objects;

@Table("Purchases")
public class Purchase {
    @Id
    @Column("PID")
    private int purchaseId;

    @Column("UserID")
    private int userId;

    @Column("Total")
    private int total;

    private List<PItem> items;
    
    public Purchase() {
    }

    public Purchase(int purchaseId, int userId, int total) {
        this.purchaseId = purchaseId;
        this.userId = userId;
        this.total = total;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setItems(List<PItem> items) {
        this.items = items;
    }

    public List<PItem> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return purchaseId == purchase.purchaseId && userId == purchase.userId && total == purchase.total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, userId, total);
    }
}
