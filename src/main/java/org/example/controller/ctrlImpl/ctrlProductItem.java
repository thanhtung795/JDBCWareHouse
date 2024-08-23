package org.example.controller.ctrlImpl;

import org.example.DAO.DaoImpl.productItemDAO;
import org.example.controller.ctrlActive;
import org.example.entity.productItem;

import java.util.List;

public class ctrlProductItem implements ctrlActive {
    @Override
    public void read() {
        productItemDAO dao = new productItemDAO();
        List<productItem> list = dao.getAll();
        for (productItem productItem : list) {
            System.out.println(productItem);
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
