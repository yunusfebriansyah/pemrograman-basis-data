package com.config;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;


import java.sql.ResultSet;

// atau bisa langsung tarik semua classnya
// import java.sql.*;

public class cConfig {

  // ini untuk mendefinisikan koneksi database kita
  // private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
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
      // Class.forName(JDBC_DRIVER);
      // DriverManager.registerDriver( new com.mysql.jdbc.Driver() );

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
    String data = "Data tidak ditemukan";

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

  public static String detailData( int id )
  {
    // panggil method static connection
    cConfig.connection();
    // ini adalah nilai default yang dikembalikan
    String data = "Data tidak ditemukan";

    try {

      // siapin object untuk statement
      statement = connect.createStatement();

      // buat query nya
      String query = "SELECT * FROM tblbarang WHERE idBarang = " + id;

      // eksekusi querynya dan simpan ke result set
      resultData = statement.executeQuery(query);

      // set variabel data jadi null dulu
      data = "";

      // looping untuk pengisian variabel data
      while( resultData.next() ){
        data += "- ID Barang : " + resultData.getInt("idBarang")
          + "\n- Nama Barang : " + resultData.getString("namaBarang")
          + "\n- Stok Barang : " + resultData.getString("stokBarang")
          + " buah\n- Harga Barang : Rp." + resultData.getString("hargaBarang");
      }

      // close statement dan koneksinya
      statement.close();
      connect.close();
      
    } catch (Exception e) {
      // tampilkan errornya kalau ada error
      e.printStackTrace();
    }

    // pengembalian string dari method ini
    return data;

  }

  public static String cariData( String keyword )
  {
    cConfig.connection();

    String data = "Data tidak ditemukan";

    try {

      statement = connect.createStatement();

      String query = "SELECT * FROM tblbarang WHERE idBarang LIKE '%" + keyword + "%' OR namaBarang LIKE '%" + keyword + "%' OR hargaBarang LIKE '%" + keyword + "%' OR stokBarang LIKE '%" + keyword + "%'";

      resultData = statement.executeQuery(query);

      data = "";

      int count = 0;
      while( resultData.next() ){
        data += "- ID Barang : " + resultData.getInt("idBarang")
          + "\n- Nama Barang : " + resultData.getString("namaBarang")
          + "\n- Stok Barang : " + resultData.getString("stokBarang")
          + " buah\n- Harga Barang : Rp." + resultData.getString("hargaBarang");
        data += "\n---------------------\n";
        count++;
      }

      if( count == 0 ){
        data = "Data tidak ditemukan";
      }
      
      // close statement dan koneksinya
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;

  }

  public static boolean tambahData( String namaBarang, int stokBarang, int hargaBarang )
  {
    cConfig.connection();
    boolean data = false;

    try {

      statement = connect.createStatement();

      String query = "INSERT INTO tblbarang VALUES (" + null + ", '" + namaBarang + "', " + stokBarang + ", " + hargaBarang + ")";

      if( !statement.execute(query) ){
        data = true;
      }


      // close statement dan koneksi
      statement.close();
      connect.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }


}
