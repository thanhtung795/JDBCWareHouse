package org.example.controller;

import org.example.DAO.DaoImpl.WareHouseDAO;
import org.example.entity.WareHouse;

import java.util.List;

public class ctrlWareHouse implements ctrlActive{

    @Override
    public void read() {
        WareHouseDAO dao = new WareHouseDAO();
        List<WareHouse> list = dao.getAll();
        for (WareHouse w : list) {
            System.out.println(w);
        }
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
