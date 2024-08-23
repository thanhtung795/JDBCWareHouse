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

    }

    @Override
    public void deletebyid(int id) {

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
