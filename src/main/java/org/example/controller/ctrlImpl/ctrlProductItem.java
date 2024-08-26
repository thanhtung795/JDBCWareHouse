package org.example.controller.ctrlImpl;

import org.example.DAO.DaoImpl.productComBoDAO;
import org.example.DAO.DaoImpl.productItemDAO;
import org.example.controller.ctrlActive;
import org.example.entity.productComBo;
import org.example.entity.productItem;

import java.util.List;
import java.util.Scanner;

public class ctrlProductItem implements ctrlActive {
    static productItemDAO dao = new productItemDAO();

    @Override
    public void read() {

        List<productItem> list = dao.getAll();
        for (productItem productItem : list) {
            System.out.println(productItem);
        }
    }

    @Override
    public void create() {
        try {
            Scanner sc = new Scanner(System.in);
            productItem item = new productItem();
            item.input(sc);
            dao.insert(item);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter again.");
        }
    }

    @Override
    public void update() {
        try {
            Scanner sc = new Scanner(System.in);
            productItem item = new productItem();
            item.input(sc);
            dao.update(item);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter again.");
        }
    }

    @Override
    public void delete() {
        try {
            productItemDAO dao = new productItemDAO();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter product ID");
            int id = sc.nextInt();
            dao.deletebyid(id);
            System.out.println("Deleted product with id " + id);
        } catch (Exception e) {
            System.out.println("delete failed");
            e.printStackTrace();
        }
    }

    public void listItemById() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter product ID");
            int id = sc.nextInt();
            List<productItem> list = dao.selectItemByid(id);
            if (list.size()>0) {
                for (productItem productItem : list) {
                    System.out.println(productItem);
                }
            } else {
                System.out.println("no item found");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter again.");
            e.printStackTrace();
        }
    }
    public void listSortAsc() {
        List<productItem> list = dao.getItemSortAsc();
        if (list.size()>0) {
            for (productItem productItem : list) {
                System.out.println(productItem);
            }
        } else {
            System.out.println("no item found");
        }
    }
    public void listSortDesc() {
        List<productItem> list = dao.getItemSortDesc();
        if (list.size()>0) {
            for (productItem productItem : list) {
                System.out.println(productItem);
            }
        } else {
            System.out.println("no item found");
        }
    }
}
