package org.example.DAO.DaoImpl;

import org.example.DAO.WareHouseRepository;
import org.example.entity.productComBo;
import org.example.entity.productItem;
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
            " where id = ?";
    private static final String delete_product_combo = " delete from product" +
            " where id = ? and product_type = ?";
    private static final String selectById = "SELECT * FROM product WHERE id = ?";
    @Override
    public void insert(productComBo productComBo) {
        try {
            JpaHelper.executeUpdate(insert_product_combo,
                    productComBo.getName(),
                    productComBo.isActive(),
                    productComBo.getIdlocator(),
                    productComBo.getCreateBy(),
                    productComBo.getQtyStock(),
                    productComBo.getProductType().name(),
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
                    productComBo.getProductType().name()
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
            Optional<productComBo> optionalCombo = getById(id);
            if (optionalCombo.isPresent()) {
                productComBo item = optionalCombo.get();

                // Kiểm tra nếu loại sản phẩm là combo thì không xóa
                if (item.getProductType() == productType.item) {
                    System.out.println("Product item cannot be deleted by id: " + id);
                    return; // Thoát khỏi phương thức nếu là combo
                }
                // Xóa sản phẩm nếu không phải là combo
                JpaHelper.executeUpdate(delete_product_combo, id);
                System.out.println("Product item deleted by id: " + id);
            } else {
                System.out.println("Product not found by id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Product deletion failed");
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
                productComBo.setProductType(productType.valueOf(rs.getString("product_type")));
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
        productComBo item = null;
        try {
            ResultSet rs = JpaHelper.executeQuery(selectById, id);
            if (rs.next()) {
                item = new productComBo();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setActive(rs.getBoolean("is_active"));
                item.setIdlocator(rs.getInt("locator_id"));
                item.setCreated(rs.getTimestamp("created"));
                item.setQtyStock(rs.getInt("qty_stock"));
                item.setProductType(productType.valueOf(rs.getString("product_type")));
                item.setIdProductParent(rs.getInt("product_parent_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(item);
    }
}
