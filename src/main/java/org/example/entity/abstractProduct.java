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
    private int qtyStock;
    private int idlocator;
    private int idProductParent;


    public abstractProduct() {
    }

    public abstractProduct(int id, String name, boolean isActive, String createBy, Timestamp created, int qtyStock, int idlocator, int idProductParent) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.createBy = createBy;
        this.created = created;
        this.qtyStock = qtyStock;
        this.idlocator = idlocator;
        this.idProductParent = idProductParent;
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

    public int getQtyStock() {
        return qtyStock;
    }

    public void setQtyStock(int qtyStock) {
        this.qtyStock = qtyStock;
    }

    public int getIdlocator() {
        return idlocator;
    }

    public void setIdlocator(int idlocator) {
        this.idlocator = idlocator;
    }

    public int getIdProductParent() {
        return idProductParent;
    }

    public void setIdProductParent(int idProductParent) {
        this.idProductParent = idProductParent;
    }

    public void input(Scanner sc) {
        System.out.print("Enter Name: ");
        this.name = sc.nextLine();

        System.out.print("Enter Created By: ");
        this.createBy = sc.nextLine();

        System.out.println("1. Đang hoạt động - 2. Ngừng hoạt động");
        this.isActive = sc.nextInt() == 1;
        sc.nextLine(); // Clear buffer

        System.out.print("Enter Quantity in Stock: ");
        this.qtyStock = sc.nextInt();

        System.out.print("Enter Locator ID: ");
        this.idlocator = sc.nextInt();

        System.out.print("Enter Parent Product ID: ");
        this.idProductParent = sc.nextInt();
        sc.nextLine(); // Clear buffer

        this.created = new Timestamp(System.currentTimeMillis());
    }
}
