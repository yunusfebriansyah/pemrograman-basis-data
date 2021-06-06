package com.config;
import java.sql.DriverManager;
import java.sql.Connection;

// atau bisa langsung tarik semua classnya
// import java.sql.*;

public class cConfig {

  // ini untuk mendefinisikan koneksi database kita
  private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_URL = "jdbc:mysql://localhost:3306/dbbarang";
  private static final String USER = "root";
  private static final String PASS = "";

  // ini untuk instansiasi object dari class DriverManager dan Connection
  private static Connection connect;

  // ini adalah method static connection
  public static void connection()
  {
    // method untuk melakukan koneksi ke database
    try {
      // registrasi driver yang akan dipakai
      Class.forName(JDBC_DRIVER);

      // buat koneksi ke database
      connect = DriverManager.getConnection(DB_URL, USER, PASS);

      System.out.println("Koneksi berhasil");

    } catch (Exception e) {
      // kalo ada error saat koneksi
      // maka tampilkan errornya
      e.printStackTrace();
    }

  }

  
}
