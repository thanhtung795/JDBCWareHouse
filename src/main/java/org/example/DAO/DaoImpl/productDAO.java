package org.example.DAO.DaoImpl;

import org.example.entity.abstractProduct;
import org.example.entity.productComBo;
import org.example.entity.productItem;
import org.example.utils.JpaHelper;
import org.example.utils.productType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productDAO {
    private static final String SELECT_PRODUCTS_ASC = "SELECT * FROM product order by id asc;";
    private static final String SELECT_PRODUCTS_DESC = "SELECT * FROM product order by id desc;";
    public List<abstractProduct> selectAllProductsAsc() {
        List<abstractProduct> list = new ArrayList<>();
        try {
            ResultSet rs = JpaHelper.executeQuery(SELECT_PRODUCTS_ASC);
            while (rs.next()) {
                abstractProduct product = createProduct(rs);
                if (product != null) {
                    list.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<abstractProduct> selectAllProductsDesc() {
        List<abstractProduct> list = new ArrayList<>();
        try {
            ResultSet rs = JpaHelper.executeQuery(SELECT_PRODUCTS_DESC);
            while (rs.next()) {
                abstractProduct product = createProduct(rs);
                if (product != null) {
                    list.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private abstractProduct createProduct(ResultSet rs) throws SQLException {
        String productType = rs.getString("product_type");

        if ("combo".equals(productType)) {
            return new productComBo(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBoolean("is_active"),
                    rs.getString("create_by"),
                    rs.getTimestamp("created"),
                    rs.getInt("qty_stock"),
                    rs.getInt("locator_id"),
                    rs.getInt("product_parent_id"),
                    org.example.utils.productType.combo
            );
        } else if ("item".equals(productType)) {
            return new productItem(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBoolean("is_active"),
                    rs.getString("create_by"),
                    rs.getTimestamp("created"),
                    rs.getInt("qty_stock"),
                    rs.getInt("locator_id"),
                    rs.getInt("product_parent_id"),
                    org.example.utils.productType.item
            );
        } else {
            return null;

        }
    }
}
