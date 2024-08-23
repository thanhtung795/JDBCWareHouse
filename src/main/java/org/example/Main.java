package org.example;

import org.example.DAO.DaoImpl.WareHouseDAO;
import org.example.DAO.DaoImpl.locatorsDAO;
import org.example.DAO.DaoImpl.productComBoDAO;
import org.example.entity.WareHouse;
import org.example.entity.locators;
import org.example.entity.productComBo;
import org.example.utils.productType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  {
        productComBoDAO dao = new productComBoDAO();
//        List<productComBo> list = dao.getAll();
//
//        for (productComBo productComBo : list) {
//            System.out.println(productComBo);
//        }
       productComBo productComBo = new productComBo(
               0,
               "Bộ máy tính văn phòng",
               true,
               "Tung",
               null,
               productType.combo,
               80,
               3,
               1
       );
       dao.insert(productComBo);
    }
}