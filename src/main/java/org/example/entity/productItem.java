package org.example.entity;

import org.example.utils.productType;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class productItem extends abstractProduct{
    private productType productType;

    public productItem() {

    }

    public productItem(int id, String name, boolean isActive, String createBy, Timestamp created, int qtyStock, int idlocator, int idProductParent, org.example.utils.productType productType) {
        super(id, name, isActive, createBy, created, qtyStock, idlocator, idProductParent);
        this.productType = productType;
    }

    public org.example.utils.productType getProductType() {
        return productType;
    }

    public void setProductType(org.example.utils.productType productType) {
        this.productType = productType;
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
                getQtyStock(),
                getIdlocator(),
                productType.item.toString(), // Giả sử `productType` là một enum hoặc một đối tượng có phương thức `toString()`
                getIdProductParent()
        );
    }
    public void input(Scanner sc) {
        super.input(sc);
        this.productType = productType.item;
    }
}
