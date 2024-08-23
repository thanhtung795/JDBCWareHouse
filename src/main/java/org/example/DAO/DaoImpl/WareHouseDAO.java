package org.example.DAO.DaoImpl;

import org.example.DAO.WareHouseRepository;
import org.example.entity.WareHouse;
import org.example.utils.JpaHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WareHouseDAO implements WareHouseRepository<WareHouse> {
    private static final String Select_all_WareHouseDAO = "select id,\n" +
            " name,\n" +
            " is_active,\n" +
            " description,\n" +
            " create_by,\n" +
            " created\n" +
            " from warehouse\n";
    private static final String insert_WareHouse =
            " INSERT INTO warehouse (name," +
                    " is_active," +
                    " description," +
                    " create_by) " +
                    " VALUES (?,?,?,?) ";
    private static final String update_WareHouse = "update warehouse \n" +
            " set name = ?,\n" +
            " is_active = ?,\n" +
            " description = ?, \n" +
            " create_by = ?,\n" +
            " created = ?\n" +
            " where id = ?";
    private static final String delete_WareHouse = "delete from warehouse where id = ?";

    private static final String select_by_id = "select * from " +
            " warehouse" +
            " where id = ?";

    @Override
    public void insert(WareHouse wareHouse) {
        try {
            JpaHelper.executeUpdate(insert_WareHouse,
                    wareHouse.getName(),
                    wareHouse.isActive(),
                    wareHouse.getDescription(),
                    wareHouse.getCreateBy()
            );
            System.out.println("Warehouse inserted");
        } catch (Exception e) {
            System.out.println("Warehouse insertion failed");
            e.printStackTrace();
        }
    }

    @Override
    public void update(WareHouse wareHouse) {
        try {
            JpaHelper.executeUpdate(update_WareHouse,
                    wareHouse.getName(),
                    wareHouse.isActive(),
                    wareHouse.getDescription(),
                    wareHouse.getCreateBy(),
                    wareHouse.getCreated(),
                    wareHouse.getId()
            );
            System.out.println("Warehouse updated");
        } catch (Exception e) {
            System.out.println("Warehouse update failed");
            e.printStackTrace();
        }
    }

    @Override
    public void deletebyid(int id) {
        try {
            JpaHelper.executeUpdate(delete_WareHouse,
                    id
            );
            System.out.println("warehouse deleted");
        } catch (Exception e) {
            System.out.println("Warehouse deletion failed");
            e.printStackTrace();
        }
    }

    @Override
    public List<WareHouse> getAll() {
        List<WareHouse> list = new ArrayList<>();
        try (ResultSet rs = JpaHelper.executeQuery(Select_all_WareHouseDAO)) {
            while (rs.next()) {
                WareHouse wareHouse = new WareHouse();
                wareHouse.setId(rs.getInt("id"));
                wareHouse.setName(rs.getString("name"));
                wareHouse.setActive(rs.getBoolean("is_active"));
                wareHouse.setDescription(rs.getString("description"));
                wareHouse.setCreateBy(rs.getString("create_by"));
                wareHouse.setCreated(rs.getTimestamp("created"));
                list.add(wareHouse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public Optional<WareHouse> getById(int id) {
        try {
            ResultSet rs = JpaHelper.executeQuery(select_by_id, id);
            while (rs.next()) {
                WareHouse wareHouse = new WareHouse();
                wareHouse.setId(rs.getInt("id"));
                wareHouse.setName(rs.getString("name"));
                wareHouse.setActive(rs.getBoolean("is_active"));
                wareHouse.setDescription(rs.getString("description"));
                wareHouse.setCreateBy(rs.getString("create_by"));
                wareHouse.setCreated(rs.getTimestamp("created"));
                return Optional.of(wareHouse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
