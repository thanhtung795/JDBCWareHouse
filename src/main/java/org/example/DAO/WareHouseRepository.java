package org.example.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface WareHouseRepository<T>{
    void insert(T t) throws SQLException;
    void update(T t);
    void deletebyid(int id);
    List<T> getAll() throws SQLException;
    Optional<T> getById(int id);

}
