package org.example.controller.ctrlImpl;

import org.example.DAO.DaoImpl.WareHouseDAO;
import org.example.controller.ctrlActive;
import org.example.entity.WareHouse;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ctrlWareHouse implements ctrlActive {
    WareHouseDAO dao = new WareHouseDAO();
    @Override
    public void read() {

        List<WareHouse> list = dao.getAll();
        for (WareHouse w : list) {
            System.out.println(w);
        }
    }

    public void create() {
      try {
          Scanner sc = new Scanner(System.in);
          WareHouse wareHouse = new WareHouse();
          wareHouse.input(sc);
          dao.insert(wareHouse);
      }catch (Exception e) {
          System.out.println("Invalid input. Please enter again.");
      }
    }

    @Override
    public void update() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter WareHouse ID");
            Optional<WareHouse> wareHouse = dao.getById(sc.nextInt());
            if (wareHouse.isPresent()) {
                wareHouse.get().input(sc);
                dao.update(wareHouse.get());
            }else {
                System.out.println("WareHouse does not exist");
            }
        }catch (Exception e) {
            System.out.println("Invalid input. Please enter again.");
        }
    }

    @Override
    public void delete() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter WareHouse ID");
            Optional<WareHouse> wareHouse = dao.getById(sc.nextInt());
            if (wareHouse.isPresent()) {
                dao.deletebyid(wareHouse.get().getId());
            }else {
                System.out.println("WareHouse does not exist");
            }
        }catch (Exception e) {
            System.out.println("Invalid input. Please enter again.");
        }
    }
}
