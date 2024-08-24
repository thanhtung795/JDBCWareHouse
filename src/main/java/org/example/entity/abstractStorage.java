package org.example.entity;

import org.example.utils.productType;

import java.sql.Timestamp;
import java.util.Scanner;

public abstract class abstractStorage {
    private int id;
    private String name;
    private boolean isActive;
    private String createBy;
    private Timestamp created;


    public abstractStorage() {
    }

    public abstractStorage(int id, String name, boolean isActive, String createBy, Timestamp created) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
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
    public void input(Scanner sc) {
        System.out.print("Enter Name: ");
        this.name = sc.nextLine();
        System.out.print("Enter Created By: ");
        this.createBy = sc.nextLine();
        System.out.println("1. Đang hoạt động - 2. Ngừng hoạt động ");
        System.out.print("You have chosen: ");
        int statusChoice = sc.nextInt();
        sc.nextLine();

        switch (statusChoice) {
            case 1:
                this.isActive = true;
                break;
            case 2:
                this.isActive = false;
                break;
            default:
                System.out.println("Invalid choice. Setting status to inactive.");
                this.isActive = false;
                break;
        }
    }
}
