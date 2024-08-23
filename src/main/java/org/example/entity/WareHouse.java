package org.example.entity;

import java.sql.Timestamp;
import java.util.Scanner;

public class WareHouse implements ActiveEntity<WareHouse> {
    private int id;
    private String name;
    private boolean isActive;
    private String description;
    private String createBy;
    private Timestamp created;

    public WareHouse() {
    }

    public WareHouse(String name, boolean isActive, String description, String createBy, Timestamp created) {
        this.name = name;
        this.isActive = isActive;
        this.description = description;
        this.createBy = createBy;
        this.created = created;
    }
    public WareHouse(int id, String name, boolean isActive, String description, String createBy, Timestamp created) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.description = description;
        this.createBy = createBy;
        this.created = created;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Override
    public String toString() {
        return "WareHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + (isActive?"Đang hoạt động":"Ngừng hoạt động") +
                ", description='" + description + '\'' +
                ", createBy='" + createBy + '\'' +
                ", created=" + created +
                '}';
    }

    @Override
    public void setEntityId(WareHouse wareHouse, Scanner scanner) {
       wareHouse.setId(scanner.nextInt());
        wareHouse.setName(scanner.nextLine());
        wareHouse.setActive(scanner.nextBoolean());
        wareHouse.setDescription(scanner.nextLine());
        wareHouse.setCreateBy(scanner.nextLine());
    }

    @Override
    public WareHouse getEntityId() {
        return null;
    }
}

