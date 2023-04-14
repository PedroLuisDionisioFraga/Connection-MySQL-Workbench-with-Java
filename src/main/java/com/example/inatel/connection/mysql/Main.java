package com.example.inatel.connection.mysql;

import com.example.inatel.DAO.CRUD;
import com.example.inatel.Models.User;

public class Main {
  public static void main(String[] args) {
    CRUD userDAO = new CRUD();

    User u1 = new User("Pedro", "123456789");
    User u2 = new User("Mario", "987654321");

    userDAO.insertUser(u1);
    userDAO.insertUser(u2);

    userDAO.selectUser();

    userDAO.deleteUser(2);

    userDAO.updateUser(1, u2);
  }
}
