package org.example.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class WareHouse  extends abstractStorage {
    private String description;

    public WareHouse() {
    }

    public WareHouse(int id, String name, boolean isActive, String createBy, Timestamp created, String description) {
        super(id, name, isActive, createBy, created);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Định dạng ngày-tháng-năm
        String createdFormatted = (getCreated() != null) ? sdf.format(getCreated()) : "N/A";

        return "WareHouse{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", isActive=" + isActive() +
                ", createBy='" + getCreateBy() + '\'' +
                ", created=" + createdFormatted +
                ", description='" + description + '\'' +
                '}';
    }
}

