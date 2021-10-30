package com.program;

import java.sql.Connection;
import java.sql.DriverManager;

public class Model {

  private static final String DB_URL = "jdbc:mysql://localhost:3306/dbpenjualanpulsa";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "";

  private static Connection koneksi;

  public static void connection()
  {

    try {
      koneksi = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
  
}
