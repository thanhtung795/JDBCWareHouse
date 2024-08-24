package org.example.DAO.DaoImpl;

import org.example.DAO.WareHouseRepository;
import org.example.entity.locators;
import org.example.entity.productItem;
import org.example.utils.JpaHelper;
import org.example.utils.productType;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class productItemDAO implements WareHouseRepository<productItem> {
    private static final String slect_prductItem = "select * " +
            " from product " +
            " where product_type= ?";

    private static final String insert_product_item = "INSERT INTO product " +
            " (name, " +
            " is_active, " +
            " locator_id, " +
            " create_by, " +
            " qty_stock, " +
            " product_type, " +
            " product_parent_id)\n" +
            " VALUES \n" +
            " (?,?,?,?,?,?,?) ";
    private static final String update_product_item = " update product \n" +
            " set " +
            " name = ?,\n" +
            " is_active = ?,\n" +
            " locator_id = ?,\n" +
            " created = ?,\n" +
            " create_by = ?,\n" +
            " qty_stock = ?,\n" +
            " product_parent_id = ?\n" +
            " where id = ? and product_type = ?";
    private static final String delete_product_citem = " delete from product" +
            " where id = ?";
    private static final String selectById = "SELECT * FROM product WHERE id = ?";
    @Override
    public void insert(productItem productItem) {
        try {
            JpaHelper.executeUpdate(insert_product_item,
                    productItem.getName(),
                    productItem.isActive(),
                    productItem.getIdlocator(),
                    productItem.getCreateBy(),
                    productItem.getQtyStock(),
                    productItem.getProductType().name(),
                    productItem.getIdProductParent()
            );
            System.out.println("Product com bo inserted successfully");
        } catch (Exception e) {
            System.out.println("Product com bo insertion failed");
            e.printStackTrace();
        }
    }

    @Override
    public void update(productItem productItem) {
        try {
            JpaHelper.executeUpdate(update_product_item,
                    productItem.getName(),
                    productItem.isActive(),
                    productItem.getIdlocator(),
                    productItem.getCreated(),
                    productItem.getCreateBy(),
                    productItem.getQtyStock(),
                    productItem.getIdProductParent(),
                    productItem.getId(),
                    productItem.getProductType().name()
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
            Optional<productItem> optionalItem = getById(id);
            if (optionalItem.isPresent()) {
                productItem item = optionalItem.get();

                // Kiểm tra nếu loại sản phẩm là combo thì không xóa
                if (item.getProductType() == productType.combo) {
                    System.out.println("Product item cannot be deleted by id: " + id);
                    return; // Thoát khỏi phương thức nếu là combo
                }
                // Xóa sản phẩm nếu không phải là combo
                JpaHelper.executeUpdate(delete_product_citem, id);
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
    public List<productItem> getAll() {
        List<productItem> list = new ArrayList<>();
        try {
            ResultSet rs = JpaHelper.executeQuery(slect_prductItem,
                    productType.item.toString()
            );
            while (rs.next()) {
                productItem item = new productItem();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setActive(rs.getBoolean("is_active"));
                item.setIdlocator(rs.getInt("locator_id"));
                item.setCreated(rs.getTimestamp("created"));
                item.setQtyStock(rs.getInt("qty_stock"));
                item.setProductType(productType.valueOf(rs.getString("product_type")));
                item.setIdProductParent(rs.getInt("product_parent_id"));
                list.add(item);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Optional<productItem> getById(int id) {
        productItem item = null;
        try {
            ResultSet rs = JpaHelper.executeQuery(selectById, id);
            if (rs.next()) {
                item = new productItem();
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
