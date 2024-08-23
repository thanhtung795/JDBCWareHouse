package org.example.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class locators extends abstractStorage {
    private Double x;
    private Double y;
    private Double z;
    private int idWareHouse;

    public locators() {
    }

    public locators(int id, String name, boolean isActive, String createBy, Timestamp created, Double x, Double y, Double z, int idWareHouse) {
        super(id, name, isActive, createBy, created);
        this.x = x;
        this.y = y;
        this.z = z;
        this.idWareHouse = idWareHouse;
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

    public int getIdWareHouse() {
        return idWareHouse;
    }

    public void setIdWareHouse(int idWareHouse) {
        this.idWareHouse = idWareHouse;
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Định dạng ngày-tháng-năm
        String createdFormatted = (getCreated() != null) ? sdf.format(getCreated()) : "N/A";

        return String.format(
                "Locators {\n" +
                        "    id          : %d\n" +
                        "    name        : '%s'\n" +
                        "    isActive    : %b\n" +
                        "    createBy    : '%s'\n" +
                        "    created     : %s\n" +
                        "    x           : %.2f\n" +
                        "    y           : %.2f\n" +
                        "    z           : %.2f\n" +
                        "    idWareHouse : %d\n" +
                        "}",
                getId(),
                getName(),
                isActive(),
                getCreateBy(),
                createdFormatted,
                x,
                y,
                z,
                idWareHouse
        );
    }

}
