package org.example.System;

import org.example.controller.ctrlImpl.ctrlLocators;
import org.example.controller.ctrlImpl.ctrlProductCombo;
import org.example.controller.ctrlImpl.ctrlProductItem;
import org.example.controller.ctrlImpl.ctrlWareHouse;

import java.util.Scanner;

public class menuManage {
    static Scanner sc = new Scanner(System.in);
    static ctrlWareHouse ctrlWarehouse = new ctrlWareHouse();
    static ctrlLocators ctrlLocators = new ctrlLocators();

    // Main Menu
    public void menuMain() {
        System.out.println("|======= System Menu =======|");
        System.out.println("|1. Manage ware house       |");
        System.out.println("|2. Manage locators         |");
        System.out.println("|3. Manage product          |");
        System.out.println("|5. Exit                    |");
        System.out.println("|===========================|");
        System.out.print("Select a function: ");
    }

    // Menu Ware House
    public void menuWareHouse() {
        System.out.println("|======= Menu Ware House =======|");
        System.out.println("|1. View all Ware House records |");
        System.out.println("|2. Add a Ware House            |");
        System.out.println("|3. Update ware house           |");
        System.out.println("|4. Delete ware house           |");
        System.out.println("|5. Exit                        |");
        System.out.println("|===============================|");
        System.out.print("Select a function: ");
    }

    public void runWareHouse() {
        boolean running = true;
        while (running) {
            menuWareHouse();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    ctrlWarehouse.read();
                    break;
                case 2:
                    ctrlWarehouse.create();
                    break;
                case 3:
                    ctrlWarehouse.update();
                    break;
                case 4:
                    ctrlWarehouse.delete();
                    break;
                case 5:
                    running = false;
                    System.out.println("You have returned to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    // Menu Locators
    public void menuLocators() {
        System.out.println("|======= Menu Locators =======|");
        System.out.println("|1. View all locators         |");
        System.out.println("|2. Add a locator             |");
        System.out.println("|3. Update locator            |");
        System.out.println("|4. Delete locator            |");
        System.out.println("|5. Exit                      |");
        System.out.println("|=============================|");
        System.out.print("Select a function: ");
    }

    public void runLocators() {
        boolean running = true;
        while (running) {
            menuLocators();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    ctrlLocators.read();
                    break;
                case 2:
                    ctrlLocators.create();
                    break;
                case 3:
                    ctrlLocators.update();
                    break;
                case 4:
                    ctrlLocators.delete();
                    break;
                case 5:
                    running = false;
                    System.out.println("You have returned to the main menu.");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    // Menu Product
    public void menuProduct() {
        System.out.println("|======= Menu Product =======|");
        System.out.println("|1. Manage product combo     |");
        System.out.println("|2. Manage product item      |");
        System.out.println("|3. Exit                     |");
        System.out.println("|============================|");
        System.out.print("Select a function: ");
    }

    public void runProduct() {
        boolean running = true;
        while (running) {
            menuProduct();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    runProductCombo();
                    break;
                case 2:
                    runProductItem();
                    break;
                case 3:
                    running = false;
                    System.out.println("You have returned to the main menu.");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    // Menu Product Combo
    public void menuProductCombo() {
        System.out.println("|======= Menu Product Combo =======|");
        System.out.println("|1. View all product combo         |");
        System.out.println("|2. Add a product combo            |");
        System.out.println("|3. Update product combo           |");
        System.out.println("|4. Delete product combo           |");
        System.out.println("|5. Exit                           |");
        System.out.println("|==================================|");
        System.out.print("Select a function: ");
    }

    public void runProductCombo() {
        boolean running = true;
        while (running) {
            menuProductCombo();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    ctrlProductCombo productCombo = new ctrlProductCombo();
                    productCombo.read();
                    break;
                case 5:
                    running = false;
                    System.out.println("You have returned to the menu product.");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    // Menu Product Item
    public void menuProductItem() {
        System.out.println("|======= Menu Product Item =======|");
        System.out.println("|1. View all product Item         |");
        System.out.println("|2. Add a product Item            |");
        System.out.println("|3. Update product Item           |");
        System.out.println("|4. Delete product Item           |");
        System.out.println("|5. Exit                          |");
        System.out.println("|=================================|");
        System.out.print("Select a function: ");
    }

    public void runProductItem() {
        boolean running = true;
        while (running) {
            menuProductItem();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    ctrlProductItem productItem = new ctrlProductItem();
                    productItem.read();
                    break;
                case 5:
                    running = false;
                    System.out.println("You have returned to the menu product.");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    // Run the whole system
    public void run() {
        boolean running = true;
        while (running) {
            menuMain();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    runWareHouse();
                    break;
                case 2:
                    runLocators();
                    break;
                case 3:
                    runProduct();
                    break;
                case 5:
                    running = false;
                    System.out.println("You have exited the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}
