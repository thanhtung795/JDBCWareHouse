package org.example.controller.ctrlImpl;

import org.example.DAO.DaoImpl.locatorsDAO;
import org.example.controller.ctrlActive;
import org.example.entity.WareHouse;
import org.example.entity.locators;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ctrlLocators implements ctrlActive {
    locatorsDAO dao = new locatorsDAO();
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
        try {
            Scanner sc = new Scanner(System.in);
            locators locators = new locators();
            locators.input(sc);
            dao.insert(locators);
        }catch (Exception e) {
            System.out.println("Invalid input. Please enter again.");
        }
    }

    @Override
    public void update() {
       try {
           Scanner sc = new Scanner(System.in);
           System.out.println("Enter Locators ID");
           Optional<locators> locators = dao.getById(sc.nextInt());
           if (locators.isPresent()) {
               locators.get().input(sc);
               dao.update(locators.get());
           }else {
               System.out.println("Locators does not exist");
           }
       }catch (Exception e) {
           System.out.println("Invalid input. Please enter again.");
       }
    }

    @Override
    public void delete() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Locators ID");
            Optional<locators> locators = dao.getById(sc.nextInt());
            if (locators.isPresent()) {
                dao.deletebyid(locators.get().getId());
            }else {
                System.out.println("Locators does not exist");
            }
        }catch (Exception e) {
            System.out.println("Invalid input. Please enter again.");
        }
    }
}
