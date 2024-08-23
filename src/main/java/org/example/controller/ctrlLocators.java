package org.example.controller;

import org.example.DAO.DaoImpl.locatorsDAO;
import org.example.entity.locators;

import java.util.List;

public class ctrlLocators implements ctrlActive{
    @Override
    public void read() {
        locatorsDAO dao = new locatorsDAO();
        List<locators> list = dao.getAll();
        for (locators locators : list) {
            System.out.println(locators);
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
