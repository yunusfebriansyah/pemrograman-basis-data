package com.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


import javax.swing.table.DefaultTableModel;

public class Model {

  private static final String DB_URL = "jdbc:mysql://localhost:3306/dbpenjualanpulsa";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "";

  private static Connection connect;
  private static Statement statement;

  private static void connection()
  {
    try {
      connect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // mitra static function
  public static DefaultTableModel getAllMitra()
  {
    connection();
    
    String[] dataHeader = {"ID Mitra", "Nama Mitra", "Email Mitra"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwallmitra";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = { resultData.getInt("idMitra"), resultData.getString("namaMitra"), resultData.getString("emailMitra") };
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountAllMitra()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwallmitra";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getMitraNonVerifikasi()
  {
    connection();
    String[] dataHeader = {"ID Mitra", "Nama", "Email"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwmitranonverifikasi";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = { resultData.getInt("idMitra"), resultData.getString("namaMitra"), resultData.getString("emailMitra") };
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static int getCountMitraNonVerifikasi()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwmitranonverifikasi";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getMitraTerverifikasi()
  {
    connection();
    
    String[] dataHeader = {"ID Mitra", "Nama Mitra", "Email Mitra"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwmitraterverifikasi";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = { resultData.getInt("idMitra"), resultData.getString("namaMitra"), resultData.getString("emailMitra") };
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static int getCountMitraTerverifikasi()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwmitraterverifikasi";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getAllSaldoMitra()
  {
    connection();

    String[] dataHeader = {"ID Saldo Mitra", "ID Mitra", "Nama", "Email", "Saldo"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwsaldomitra";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = { resultData.getInt("idSaldoMitra"), resultData.getInt("idMitra"), resultData.getString("namaMitra"), resultData.getString("emailMitra"), resultData.getInt("saldoMitra") };
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static boolean verifyEmailMitra( String email )
  {
    connection();
    boolean available = false;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwallmitra WHERE emailMitra = '" + email + "'";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      if ( resultData.getInt(1) == 0){
        available = true;
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return available;
  }
  
  public static boolean verifyAkunMitra( String email, String password )
  {
    connection();
    boolean available = false;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwallmitra WHERE emailMitra = '" + email + "' AND passwordMitra = '" + password + "'";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      if ( resultData.getInt(1) == 1){
        available = true;
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return available;
  }

  public static int getDetailSaldoMitra( int idMitra )
  {
    connection();

    int saldo = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT saldoMitra FROM vwsaldomitra WHERE idMitra = " + idMitra;

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      saldo = resultData.getInt("saldoMitra");
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return saldo;

  }
  

  // Customer static function
  public static DefaultTableModel getCustomer()
  {
    connection();
    
    String[] dataHeader = {"ID Customer", "Nama Customer", "No HP", "Email"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwcustomer";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idCustomer"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getString("emailCustomer")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static DefaultTableModel getPulsaKuotaCustomer()
  {
    connection();
    String[] dataHeader = {"ID Pulsa Kuota", "ID Customer", "Nama Customer", "No. Hp", "Pulsa", "Kuota"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwpulsakuotacustomer";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idPulsaKuotaCustomer"), resultData.getInt("idCustomer"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getInt("pulsaCustomer"), resultData.getInt("kuotaCustomer") + "GB"};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static boolean verifyNoHpCustomer( String noHp )
  {
    connection();
    boolean available = false;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwcustomer WHERE nomorHpCustomer = '" + noHp + "'";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      if ( resultData.getInt(1) == 0){
        available = true;
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return available;
  }

  public static boolean verifyAkunCustomer( String noHp, String password )
  {
    connection();
    boolean available = false;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwcustomer WHERE nomorHpCustomer = '" + noHp + "' AND passwordCustomer = '" + password + "'";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      if ( resultData.getInt(1) == 1){
        available = true;
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return available;
  }

  public static int getCountCustomer()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwcustomer";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }


  // Paket static function
  public static DefaultTableModel getAllPaket()
  {
    connection();
    
    String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwallpaket ORDER BY idPaket DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idPaket"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), (resultData.getString("statusAktif").toString().equalsIgnoreCase("1")) ? "Aktif" : "Tidak Aktif"};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountAllPaket()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwallpaket";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getPaketAktif()
  {
    connection();
    
    String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwpaketaktif ORDER BY idPaket DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idPaket"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), "Aktif"};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static DefaultTableModel getPaketAktifByCustomer()
  {
    connection();
    
    String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwpaketaktif ORDER BY idPaket DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idPaket"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountPaketAktif()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwpaketaktif";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getPaketNonAktif()
  {
    connection();
    
    String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwpaketnonaktif ORDER BY idPaket DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idPaket"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), "Tidak Aktif"};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountPaketNonAktif()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwpaketnonaktif";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }


  // Transaksi Paket function static
  public static DefaultTableModel getAllTransaksiPaket()
  {
    connection();
    String[] dataUHeader = {"ID Transaksi Paket", "Customer", "No HP", "Paket", "Kuota", "Harga", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataUHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksipaket ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiPaket"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static DefaultTableModel getAllTransaksiPaketByCustomer( int idCustomer)
  {
    connection();
    
    String[] dataHeader = {"Nama Paket", "Kuota", "Harga", "Waktu Transaksi", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksipaket WHERE idCustomer = " + idCustomer + " ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountAllTransaksiPaket()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwalltransaksipaket";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getDoneTransaksiPaket()
  {
    connection();
    
    String[] dataHeader = {"ID Transaksi Paket", "Nama Customer", "No HP", "Nama Paket", "Kuota", "Harga", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwdonetransaksipaket ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiPaket"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountDoneTransaksiPaket()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwdonetransaksipaket";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getPendingTransaksiPaket()
  {
    connection();
    
    String[] dataHeader = {"ID Transaksi Paket", "Nama Customer", "No HP", "Nama Paket", "Kuota", "Harga", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwpendingtransaksipaket ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiPaket"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountPendingTransaksiPaket()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwpendingtransaksipaket";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }


  // Transaksi Pulsa function static
  public static DefaultTableModel getAllTransaksiPulsa()
  {
    connection();

    String[] dataHeader = {"ID Transaksi Pulsa", "Customer", "No HP", "Pulsa", "Mitra", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksipulsa ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiPulsa"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getInt("jumlahPulsa"), resultData.getString("namaMitra"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static DefaultTableModel getAllTransaksiPulsaByCustomer( int idCustomer )
  {
    connection();
    
    String[] dataHeader = {"Jumlah Pulsa", "Mitra", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksipulsa WHERE idCustomer = " + idCustomer + " ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("jumlahPulsa"), resultData.getString("namaMitra"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return tm;
  }

  public static int getCountAllTransaksiPulsa()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwalltransaksipulsa";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getDoneTransaksiPulsa()
  {
    connection();
    
    String[] dataHeader = {"ID Transaksi Pulsa", "Nama Customer", "No HP", "Jumlah Pulsa", "Mitra", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwdonetransaksipulsa ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiPulsa"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getInt("jumlahPulsa"), resultData.getString("namaMitra"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return tm;

  }

  public static int getCountDoneTransaksiPulsa()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwdonetransaksipulsa";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getDoneTransaksiPulsaByMitra( int idMitra )
  {
    connection();
    
    String[] dataHeader = {"Nama Customer", "No HP", "Jumlah Pulsa", "Waktu"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwdonetransaksipulsa WHERE idMitra = " + idMitra + " ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getInt("jumlahPulsa"),resultData.getString("waktuTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountDoneTransaksiPulsaMitra(int idMitra)
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwdonetransaksipulsa WHERE idMitra = " + idMitra;

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getPendingTransaksiPulsa()
  {
    connection();
    
    String[] dataHeader = {"ID Transaksi Pulsa", "ID Customer", "Nama Customer", "No HP", "Jumlah Pulsa", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwpendingtransaksipulsa ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiPulsa"), resultData.getInt("idCustomer"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getInt("jumlahPulsa"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountPendingTransaksiPulsa()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwpendingtransaksipulsa";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }


  // Transaksi Saldo function static
  public static DefaultTableModel getAllTransaksiSaldo()
  {
    connection();
    
    String[] dataHeader = {"ID Transaksi Saldo", "Nama Mitra", "Jumlah Saldo", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksisaldo ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiSaldo"), resultData.getString("namaMitra"), resultData.getInt("jumlahSaldo"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return tm;

  }

  public static DefaultTableModel getAllTransaksiSaldoByMitra( int idMitra )
  {
    connection();
    
    String[] dataHeader = {"Jumlah Saldo", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksisaldo WHERE idMitra = " + idMitra + " ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("jumlahSaldo"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountAllTransaksiSaldo()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwalltransaksisaldo";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getDoneTransaksiSaldo()
  {
    connection();
    String[] dataHeader = {"ID Transaksi Saldo", "Nama Mitra", "Jumlah Saldo", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwdonetransaksisaldo ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiSaldo"), resultData.getString("namaMitra"), resultData.getInt("jumlahSaldo"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountDoneTransaksiSaldo()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwdonetransaksisaldo";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getPendingTransaksiSaldo()
  {
    connection();
    String[] dataHeader = {"ID Transaksi Saldo", "Nama Mitra", "Jumlah Saldo", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwpendingtransaksisaldo ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiSaldo"), resultData.getString("namaMitra"), resultData.getInt("jumlahSaldo"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountPendingTransaksiSaldo()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwpendingtransaksisaldo";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }


  // Detail get Data
  public static Object[] getDetailMitra( int idMitra )
  {
    connection();

    Object rowData[] = new Object[3];

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwallmitra WHERE idMitra = " + idMitra;

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      rowData[0] = resultData.getInt("idMitra");
      rowData[1] = resultData.getString("namaMitra");
      rowData[2] = resultData.getString("emailMitra");
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return rowData;

  }
  
  public static Object[] getDetailCustomer( int idCustomer )
  {
    connection();

    Object rowData[] = new Object[4];

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwcustomer WHERE idCustomer = " + idCustomer;

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      rowData[0] = resultData.getInt("idCustomer");
      rowData[1] = resultData.getString("namaCustomer");
      rowData[2] = resultData.getString("nomorHpCustomer");
      rowData[3] = resultData.getString("emailCustomer");
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return rowData;

  }
  
  public static Object[] getDetailPulsaKuotaCustomer( int idCustomer )
  {
    connection();

    Object[] pulsaKuota = new Object[2];

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT pulsaCustomer, kuotaCustomer FROM vwpulsakuotacustomer WHERE idCustomer = " + idCustomer;

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      pulsaKuota[0] = resultData.getInt("pulsaCustomer");
      pulsaKuota[1] = resultData.getInt("kuotaCustomer");
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return pulsaKuota;
  }

  public static Object[] getDetailPaket( int idPaket )
  {
    connection();

    Object[] rowData = new Object[6];

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwallpaket WHERE idPaket = " + idPaket;

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      rowData[0] = resultData.getInt("idPaket");
      rowData[1] = resultData.getString("namaPaket");
      rowData[2] = resultData.getString("deskripsiPaket");
      rowData[3] = resultData.getInt("kuota");
      rowData[4] = resultData.getInt("hargaPaket");
      rowData[5] = resultData.getString("statusAktif");
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return rowData;

  }

  // All Method for search data
  
  public static DefaultTableModel getSearchSaldoMitra( String keyword )
  {
    connection();

    String[] dataHeader = {"ID Saldo Mitra", "ID Mitra", "Nama", "Email", "Saldo"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwsaldomitra WHERE namaMitra LIKE '%" + keyword + "%' OR emailMitra LIKE '%" + keyword + "%' OR saldoMitra LIKE '%" + keyword + "%'";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = { resultData.getInt("idSaldoMitra"), resultData.getInt("idMitra"), resultData.getString("namaMitra"), resultData.getString("emailMitra"), resultData.getInt("saldoMitra") };
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static DefaultTableModel getSearchPulsaKuotaCustomer( String keyword )
  {
    connection();
    String[] dataHeader = {"ID Pulsa Kuota", "ID Customer", "Nama Customer", "No. Hp", "Pulsa", "Kuota"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwpulsakuotacustomer WHERE namaCustomer LIKE '%" + keyword + "%' OR nomorHpCustomer LIKE '%" + keyword + "%' OR pulsaCustomer LIKE '%" + keyword + "%' OR kuotaCustomer LIKE '%" + keyword + "%'";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idPulsaKuotaCustomer"), resultData.getInt("idCustomer"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getInt("pulsaCustomer"), resultData.getInt("kuotaCustomer") + "GB"};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static DefaultTableModel getSearchPendingTransaksiSaldo( String keyword )
  {
    connection();
    String[] dataHeader = {"ID Transaksi Saldo", "Nama Mitra", "Jumlah Saldo", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwpendingtransaksisaldo WHERE namaMitra LIKE '%" + keyword + "%' OR jumlahSaldo LIKE '%" + keyword + "%' OR waktuTransaksi LIKE '%" + keyword + "%' ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiSaldo"), resultData.getString("namaMitra"), resultData.getInt("jumlahSaldo"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static DefaultTableModel getSearchDoneTransaksiSaldo( String keyword )
  {
    connection();
    String[] dataHeader = {"ID Transaksi Saldo", "Nama Mitra", "Jumlah Saldo", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwdonetransaksisaldo WHERE namaMitra LIKE '%" + keyword + "%' OR jumlahSaldo LIKE '%" + keyword + "%' OR waktuTransaksi LIKE '%" + keyword + "%' ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiSaldo"), resultData.getString("namaMitra"), resultData.getInt("jumlahSaldo"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static DefaultTableModel getSearchMitraNonVerifikasi( String keyword )
  {
    connection();
    String[] dataHeader = {"ID Mitra", "Nama", "Email"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwmitranonverifikasi WHERE namaMitra LIKE '%" + keyword + "%' OR emailMitra LIKE '%" + keyword + "%'";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = { resultData.getInt("idMitra"), resultData.getString("namaMitra"), resultData.getString("emailMitra") };
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static DefaultTableModel getSearchTransaksiPulsa( String keyword )
  {
    connection();

    String[] dataHeader = {"ID Transaksi Pulsa", "Customer", "No HP", "Pulsa", "Mitra", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksipulsa WHERE namaCustomer LIKE '%" + keyword + "%' OR nomorHpCustomer LIKE '%" + keyword + "%' OR jumlahPulsa LIKE '%" + keyword + "%' OR namaMitra LIKE '%" + keyword + "%' OR waktuTransaksi LIKE '%" + keyword + "%' OR statusTransaksi LIKE '%" + keyword + "%' ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiPulsa"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getInt("jumlahPulsa"), resultData.getString("namaMitra"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static DefaultTableModel getSearchTransaksiPaket( String keyword )
  {
    connection();
    String[] dataUHeader = {"ID Transaksi Paket", "Customer", "No HP", "Paket", "Kuota", "Harga", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataUHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksipaket WHERE namaCustomer LIKE '%" + keyword + "%' OR nomorHpCustomer LIKE '%" + keyword + "%' OR namaPaket LIKE '%" + keyword + "%' OR kuota LIKE '%" + keyword + "%' OR hargaPaket LIKE '%" + keyword + "%' OR waktuTransaksi LIKE '%" + keyword + "%' OR statusTransaksi LIKE '%" + keyword + "%' ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idTransaksiPaket"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static DefaultTableModel getSearchAllPaket( String keyword )
  {
    connection();
    
    String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwallpaket WHERE namaPaket LIKE '%" + keyword + "%' OR kuota LIKE '%" + keyword + "%' OR hargaPaket LIKE '%" + keyword + "%' ORDER BY idPaket DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idPaket"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), (resultData.getString("statusAktif").toString().equalsIgnoreCase("1")) ? "Aktif" : "Tidak Aktif"};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static DefaultTableModel getSearchPaketAktif( String keyword )
  {
    connection();
    
    String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwpaketaktif WHERE namaPaket LIKE '%" + keyword + "%' OR kuota LIKE '%" + keyword + "%' OR hargaPaket LIKE '%" + keyword + "%' ORDER BY idPaket DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idPaket"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), "Aktif"};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static DefaultTableModel getSearchPaketNonAktif( String keyword )
  {
    connection();
    
    String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwpaketnonaktif WHERE namaPaket LIKE '%" + keyword + "%' OR kuota LIKE '%" + keyword + "%' OR hargaPaket LIKE '%" + keyword + "%' ORDER BY idPaket DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("idPaket"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), "Tidak Aktif"};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }


  // Method for insert data
  public static boolean tambahDataPaket( String namaPaket, String deskripsiPaket, int kuota, int hargaPaket, String statusAktif )
  {
    boolean data = false;

    connection();

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "INSERT tblpaket VALUES (" + null + ", '" + namaPaket + "', '" + deskripsiPaket + "', " + kuota + ", " + hargaPaket + ", '" + statusAktif + "')";

      if( statement.executeUpdate(query) > 0 ){
        data = true;
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static boolean ubahDataPaket(int idPaket, String namaPaket, String deskripsiPaket, int kuota, int hargaPaket, String statusAktif )
  {
    boolean data = false;

    connection();

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "UPDATE tblpaket SET namaPaket = '" + namaPaket + "', deskripsiPaket = '" + deskripsiPaket + "', kuota = " + kuota + ", hargaPaket = " + hargaPaket + ", statusAktif = '" + statusAktif + "' WHERE idPaket = " + idPaket;

      if( statement.executeUpdate(query) > 0 ){
        data = true;
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
