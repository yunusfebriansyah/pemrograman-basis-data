package com.config;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

// atau bisa langsung tarik semua classnya
// import java.sql.*;

public class cConfig {

  // ini untuk mendefinisikan koneksi database kita
  private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_URL = "jdbc:mysql://localhost:3306/dbbarang";
  private static final String USER = "root";
  private static final String PASS = "";

  // ini untuk instansiasi object dari class yang sudah diimport
  private static Connection connect;
  private static Statement statement;
  private static ResultSet resultData;

  // ini adalah method static connection
  private static void connection()
  {
    // method untuk melakukan koneksi ke database
    try {
      // registrasi driver yang akan dipakai
      Class.forName(JDBC_DRIVER);

      // buat koneksi ke database
      connect = DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (Exception e) {
      // kalo ada error saat koneksi
      // maka tampilkan errornya
      e.printStackTrace();
    }

  }

  public static String getAllData()
  {
    cConfig.connection();

    // isi nilai default dari variabel data
    String data = "Maaf data tidak ada";

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select all data from database
      String query = "SELECT idBarang, namaBarang FROM tblbarang";

      // eksekusi query-nya
      resultData = statement.executeQuery(query);

      // set variabel data jadi null
      data = "";

      // looping pengisian variabel data
      while( resultData.next() ){
        data += "ID Barang : " + resultData.getInt("idBarang") + ", Nama Barang : " + resultData.getString("namaBarang") + "\n";
      }
      
      
      // close statement dan connection
      statement.close();
      connect.close();


    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;

  }



}
