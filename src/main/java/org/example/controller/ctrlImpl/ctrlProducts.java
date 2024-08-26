package org.example.controller.ctrlImpl;

import org.example.DAO.DaoImpl.productDAO;
import org.example.entity.abstractProduct;
import org.example.entity.productItem;

import java.util.List;

public class ctrlProducts {
    productDAO dao = new productDAO();
    public void listSortAsc() {
        List<abstractProduct> list = dao.selectAllProductsAsc();
        if (list.size()>0) {
            for (abstractProduct abstractProduct : list) {
                System.out.println(abstractProduct);
            }
        } else {
            System.out.println("no item found");
        }
    }
    public void listSortDesc() {
        List<abstractProduct> list = dao.selectAllProductsDesc();
        if (list.size()>0) {
            for (abstractProduct abstractProduct : list) {
                System.out.println(abstractProduct);
            }
        } else {
            System.out.println("no item found");
        }
    }
}
