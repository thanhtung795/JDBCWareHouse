package org.example.entity;

import java.util.Scanner;

public interface ActiveEntity <T>{
    void setEntityId(T t, Scanner scanner);
    T getEntityId();
}
