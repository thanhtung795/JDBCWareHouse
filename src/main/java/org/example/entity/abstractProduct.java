package org.example.entity;

import org.example.utils.productType;

import java.sql.Timestamp;
import java.util.Scanner;

public abstract class abstractProduct{
    private int id;
    private String name;
    private boolean isActive;
    private String createBy;
    private Timestamp created;

    private productType type;

    public abstractProduct() {
    }

    public abstractProduct(int id, String name, boolean isActive, String createBy, Timestamp created, productType type) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.createBy = createBy;
        this.created = created;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public productType getType() {
        return type;
    }

    public void setType(productType type) {
        this.type = type;
    }
    public void input( Scanner sc){

    }
}
