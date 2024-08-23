package org.example.entity;

import org.example.utils.productType;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class productComBo extends abstractProduct{
    private int qtyStock;
    private int idlocator;
    private int idProductParent;

    public productComBo() {
    }

    public productComBo(int id, String name, boolean isActive, String createBy, Timestamp created, productType type, int qtyStock, int idlocator, int idProductParent) {
        super(id, name, isActive, createBy, created, type);
        this.qtyStock = qtyStock;
        this.idlocator = idlocator;
        this.idProductParent = idProductParent;
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

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Định dạng ngày-tháng-năm
        String createdFormatted = (getCreated() != null) ? sdf.format(getCreated()) : "N/A";

        return "productComBo{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", isActive=" + (isActive()?"Đang hoạt động":"Ngừng hoạt động") +
                ", createBy='" + getCreateBy() + '\'' +
                ", created=" + createdFormatted +
                ", qtyStock=" + qtyStock +
                ", idlocator=" + idlocator +
                ", type=" + productType.combo.toString() +
                ", idProductParent=" + idProductParent +
                '}';
    }
}
