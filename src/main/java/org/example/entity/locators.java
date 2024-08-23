package org.example.entity;

import java.sql.Timestamp;

public class locators {
    private int id;
    private String name;
    private boolean isActive;
    private Double x;
    private Double y;
    private Double z;
    private Timestamp created;
    private String createBy;
    private int wareHouse;

    public locators() {
    }

    public locators(int id, String name, boolean isActive, Double x, Double y, Double z, Timestamp created, String createBy, int wareHouse) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.x = x;
        this.y = y;
        this.z = z;
        this.created = created;
        this.createBy = createBy;
        this.wareHouse = wareHouse;
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

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public int getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(int wareHouse) {
        this.wareHouse = wareHouse;
    }
}
