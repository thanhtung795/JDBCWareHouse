package org.example.DAO.DaoImpl;

import org.example.DAO.WareHouseRepository;
import org.example.entity.productComBo;
import org.example.utils.JpaHelper;
import org.example.utils.productType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class productComBoDAO implements WareHouseRepository<productComBo> {
    private static final String select_all_productComBo = "select " +
            "* " +
            " from product" +
            " where product_type = ?";
    private static final String insert_product_combo = "INSERT INTO product " +
            " (name, " +
            " is_active, " +
            " locator_id, " +
            " create_by, " +
            " qty_stock, " +
            " product_type, " +
            " product_parent_id)\n" +
            " VALUES \n" +
            " (?,?,?,?,?,?,?) ";
    private static final String update_product_combo = " update product \n" +
            " set " +
            " name = ?,\n" +
            " is_active = ?,\n" +
            " locator_id = ?,\n" +
            " created = ?,\n" +
            " create_by = ?,\n" +
            " qty_stock = ?,\n" +
            " product_parent_id = ?\n" +
            " where id = ? and product_type = ?";
    private static final String delete_product_combo = " delete from product" +
            " where id = ?";

    @Override
    public void insert(productComBo productComBo) {
        try {
            JpaHelper.executeUpdate(insert_product_combo,
                    productComBo.getName(),
                    productComBo.isActive(),
                    productComBo.getIdlocator(),
                    productComBo.getCreateBy(),
                    productComBo.getQtyStock(),
                    productComBo.getType().name(),
                    productComBo.getIdProductParent()
            );
            System.out.println("Product com bo inserted successfully");
        } catch (Exception e) {
            System.out.println("Product com bo insertion failed");
            e.printStackTrace();
        }
    }

    @Override
    public void update(productComBo productComBo) {
        try {
            JpaHelper.executeUpdate(update_product_combo,
                    productComBo.getName(),
                    productComBo.isActive(),
                    productComBo.getIdlocator(),
                    productComBo.getCreated(),
                    productComBo.getCreateBy(),
                    productComBo.getQtyStock(),
                    productComBo.getIdProductParent(),
                    productComBo.getId(),
                    productComBo.getType().name()
            );
            System.out.println("Product com bo updated successfully");
        } catch (Exception e) {
            System.out.println("Product com bo update failed");
            e.printStackTrace();
        }
    }

    @Override
    public void deletebyid(int id) {
        try {
            JpaHelper.executeUpdate(delete_product_combo,
                    id
            );
            System.out.println("Product com bo deleted by id: " + id);
        } catch (Exception e) {
            System.out.println("Product com bo delete failed");
            e.printStackTrace();
        }
    }

    @Override
    public List<productComBo> getAll() {
        List<productComBo> list = new ArrayList<>();
        try {
            ResultSet rs = JpaHelper.executeQuery(select_all_productComBo,
                    productType.combo.toString());
            while (rs.next()) {
                productComBo productComBo = new productComBo();
                productComBo.setId(rs.getInt("id"));
                productComBo.setName(rs.getString("name"));
                productComBo.setActive(rs.getBoolean("is_active"));
                productComBo.setIdlocator(rs.getInt("locator_id"));
                productComBo.setCreated(rs.getTimestamp("created"));
                productComBo.setQtyStock(rs.getInt("qty_stock"));
                productComBo.setType(productType.valueOf(rs.getString("product_type")));
                productComBo.setIdProductParent(rs.getInt("product_parent_id"));
                list.add(productComBo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Optional<productComBo> getById(int id) {
        return Optional.empty();
    }
}
