package org.example.entity;

import org.example.utils.productType;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class productItem extends abstractProduct{
    private int qtyStock;
    private int idlocator;
    private int idProductParent;

    public productItem() {
    }

    public productItem(int qtyStock, int idlocator, int idProductParent) {
        this.qtyStock = qtyStock;
        this.idlocator = idlocator;
        this.idProductParent = idProductParent;
    }

    public productItem(int id, String name, boolean isActive, String createBy, Timestamp created, productType type, int qtyStock, int idlocator, int idProductParent) {
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

        return String.format(
                "ProductItem {\n" +
                        "    id               : %d\n" +
                        "    name             : '%s'\n" +
                        "    isActive         : %s\n" +
                        "    createBy         : '%s'\n" +
                        "    created          : %s\n" +
                        "    qtyStock         : %d\n" +
                        "    idLocator        : %d\n" +
                        "    type             : %s\n" +
                        "    idProductParent  : %d\n" +
                        "}",
                getId(),
                getName(),
                isActive() ? "Đang hoạt động" : "Ngừng hoạt động",
                getCreateBy(),
                createdFormatted,
                qtyStock,
                idlocator,
                productType.item.toString(), // Giả sử `productType` là một enum hoặc một đối tượng có phương thức `toString()`
                idProductParent
        );
    }

}
