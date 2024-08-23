package org.example.DAO.DaoImpl;

import org.example.DAO.WareHouseRepository;
import org.example.entity.productItem;
import org.example.utils.JpaHelper;
import org.example.utils.productType;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class productItemDAO implements WareHouseRepository {
    private static final String slect_prductItem = "select * " +
            " from product " +
            " where product_type= ?";
    @Override
    public void insert(Object object) {

    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void deletebyid(int id) {

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
                item.setType(productType.valueOf(rs.getString("product_type")));
                item.setIdProductParent(rs.getInt("product_parent_id"));
                list.add(item);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Optional getById(int id) {
        return Optional.empty();
    }
}
