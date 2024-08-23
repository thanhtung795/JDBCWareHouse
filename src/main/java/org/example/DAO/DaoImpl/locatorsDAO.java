package org.example.DAO.DaoImpl;

import org.example.DAO.WareHouseRepository;
import org.example.entity.locators;
import org.example.utils.JpaHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class locatorsDAO implements WareHouseRepository<locators> {
    private static final String select_all_locators = "select\n" +
            " id,\n" +
            " name,\n" +
            " is_active\n" +
            " ,x,y,z,\n" +
            " created,\n" +
            " create_by,\n" +
            " warehouse_id\n" +
            " from locators;";
    private static final String insert_locators = "INSERT INTO locators " +
            " (name, is_active, x, y, z, create_by, warehouse_id)" +
            " values (?,?,?,?,?,?,?)";
    private static final String update_locators = "update locators \n" +
            " set name = ?,\n" +
            " is_active = ?,\n" +
            " x = ?,\n" +
            " y = ?,\n" +
            " z = ?,\n" +
            " created = ?,\n" +
            " create_by = ?,\n" +
            " warehouse_id = ?\n" +
            " where id = ?";
    private static final String delete_locators = "delete from locators " +
            " where id = ?";

    @Override
    public void insert(locators locators) {
        try {
            JpaHelper.executeUpdate(insert_locators,
                    locators.getName(),
                    locators.isActive(),
                    locators.getX(),
                    locators.getY(),
                    locators.getZ(),
                    locators.getCreateBy(),
                    locators.getIdWareHouse()
            );
            System.out.println("locators inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(locators locators) {
        try {
            JpaHelper.executeUpdate(update_locators,
                    locators.getName(),
                    locators.isActive(),
                    locators.getX(),
                    locators.getY(),
                    locators.getZ(),
                    locators.getCreated(),
                    locators.getCreateBy(),
                    locators.getIdWareHouse(),
                    locators.getId()
            );
            System.out.println("locators updated");
        } catch (Exception e) {
            System.out.println("locators not updated");
            e.printStackTrace();
        }
    }

    @Override
    public void deletebyid(int id) {
        try {
            JpaHelper.executeUpdate(delete_locators,
                    id
            );
            System.out.println("locators deleted");
        } catch (Exception e) {
            System.out.println("locators not deleted");
            e.printStackTrace();
        }
    }

    @Override
    public List<locators> getAll() {
        List<locators> list = new ArrayList();
        try {
            ResultSet rs = JpaHelper.executeQuery(select_all_locators);
            while (rs.next()) {
                locators locators = new locators();
                locators.setId(rs.getInt("id"));
                locators.setName(rs.getString("name"));
                locators.setActive(rs.getBoolean("is_active"));
                locators.setX(rs.getDouble("x"));
                locators.setY(rs.getDouble("y"));
                locators.setZ(rs.getDouble("z"));
                locators.setCreated(rs.getTimestamp("created"));
                locators.setCreateBy(rs.getString("create_by"));
                locators.setIdWareHouse(rs.getInt("warehouse_id"));
                list.add(locators);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Optional getById(int id) {
        return Optional.empty();
    }
}
