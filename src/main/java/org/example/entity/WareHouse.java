package org.example.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class WareHouse extends abstractStorage {
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

        return String.format(
                "WareHouse {\n" +
                        "    id         : %d\n" +
                        "    name       : '%s'\n" +
                        "    isActive   : %b\n" +
                        "    createBy   : '%s'\n" +
                        "    created    : %s\n" +
                        "    description: '%s'\n" +
                        "}",
                getId(),
                getName(),
                isActive(),
                getCreateBy(),
                createdFormatted,
                description
        );
    }
    public void input(Scanner sc) {
        super.input(sc);
        System.out.print("Enter description: ");
        this.description = sc.nextLine();
    }
}

