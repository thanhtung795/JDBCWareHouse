package org.example.DAO.DaoImpl;

import org.example.DAO.WareHouseRepository;
import org.example.entity.locators;
import org.example.utils.JpaHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class locatorsDAO implements WareHouseRepository <locators {
    private static final String select_all_locators = "select\n" +
            " id,\n" +
            " name,\n" +
            " is_active\n" +
            " ,x,y,z,\n" +
            " created,\n" +
            " create_by,\n" +
            " warehouse_id\n" +
            " from locators;";


    @Override
    public void insert(locators locators) throws SQLException {

    }

    @Override
    public void update(locators locators) {

    }

    @Override
    public void deletebyid(int id) {

    }

    @Override
    public List<locators> getAll() throws SQLException {
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
                list.add(locators);
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
