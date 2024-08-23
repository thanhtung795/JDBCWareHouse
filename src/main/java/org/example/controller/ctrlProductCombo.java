package org.example.controller;

import org.example.DAO.DaoImpl.productComBoDAO;
import org.example.entity.productComBo;

import java.util.List;

public class ctrlProductCombo implements ctrlActive{
    @Override
    public void read() {
        productComBoDAO dao = new productComBoDAO();
        List<productComBo> list = dao.getAll();
        for (productComBo productComBo : list) {
            System.out.println(productComBo);
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
