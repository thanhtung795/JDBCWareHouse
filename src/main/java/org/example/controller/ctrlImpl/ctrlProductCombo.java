package org.example.controller.ctrlImpl;

import org.example.DAO.DaoImpl.productComBoDAO;
import org.example.controller.ctrlActive;
import org.example.entity.productComBo;

import java.util.List;
import java.util.Scanner;

public class ctrlProductCombo implements ctrlActive {
    static productComBoDAO dao = new productComBoDAO();

    @Override
    public void read() {
        List<productComBo> list = dao.getAll();
        for (productComBo productComBo : list) {
            System.out.println(productComBo);
        }
    }

    @Override
    public void create() {
        try {
            Scanner sc = new Scanner(System.in);
            productComBo productComBo = new productComBo();
            productComBo.input(sc);
            dao.insert(productComBo);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter again.");
        }
    }

    @Override
    public void update() {
        try {
            Scanner sc = new Scanner(System.in);
            productComBo productComBo = new productComBo();
            productComBo.input(sc);
            dao.update(productComBo);
        }catch (Exception e) {
            System.out.println("Invalid input. Please enter again.");
        }
    }

    @Override
    public void delete() {
        try {
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
}
