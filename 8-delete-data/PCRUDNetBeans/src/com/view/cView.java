package com.view;

import java.util.Scanner;

import com.config.cConfig;

public class cView {

  public static Scanner input = new Scanner(System.in);

  public static void index()
  {

    while(true){

      System.out.print("\n=== MENU ===\n"
      + "1. Lihat Semua Data Barang\n"
      + "2. Detail Data Barang\n"
      + "3. Cari Data Barang\n"
      + "4. Tambah Data Barang\n"
      + "5. Update Data Barang\n"
      + "0. Exit\n"
      + "Pilih[1/2/3/4/5/0] : ");

      String pilihan = input.next();

      if( pilihan.equalsIgnoreCase("0") ){
        System.out.println("Terimakasih!!");
        break;
      }

      switch (pilihan) {
        case "1" :
          cView.getAllData();
          break;
        case "2" :
          cView.detailData();
          break;
        case "3" :
          cView.cariData();
          break;
        case "4" :
          cView.tambahData();
          break;
        case "5" :
          cView.updateData();
          break;
        default:
          System.out.println("Pilihan salah!!");
          break;
      }
    }

  }
  
  public static void getAllData()
  {
    //  pesan header
    System.out.println("\n::: DATA BARANG :::");
    // data semua barangnya
    System.out.println(cConfig.getAllData()); 

  }


  public static void detailData()
  {
    System.out.println("\n::: DETAIL DATA BARANG:::");

    System.out.print("Masukkan ID Barang : ");
    int id = input.nextInt();
    
    System.out.println("Hasil Data");
    System.out.println(cConfig.detailData(id));
  }

  public static void cariData()
  {
    System.out.println("\n::: CARI DATA :::");
    System.out.print("Masukkan Keyword : ");
    String keyword = input.nextLine();
    keyword = input.nextLine();

    System.out.println("\nHasil Data");
    System.out.println(cConfig.cariData(keyword));
  }

  public static void tambahData()
  {

    System.out.println("\n::: TAMBAH DATA BARANG :::");
    System.out.print("Masukkan Nama Barang : ");
    String namaBarang = input.nextLine();
    namaBarang = input.nextLine();
    System.out.print("Masukkan Stok Barang : ");
    int stokBarang = input.nextInt();
    System.out.print("Masukkan Harga Barang : ");
    int hargaBarang = input.nextInt();

    if ( cConfig.tambahData(namaBarang, stokBarang, hargaBarang) ){
      System.out.println("Data Barang berhasil ditambahkan!!");
      cView.getAllData();
    }else{
      System.out.println("Data Barang gagal ditambahkan!!");
    }

  }

  public static void updateData()
  {
    System.out.println("\n::: UPDATE DATA BARANG :::");
    System.out.print("Masukkan ID Barang : ");
    int idBarang = input.nextInt();
    System.out.println("\nGanti Data Barang\n");
    System.out.print("Nama Barang (Kosongkan jika tidak ingin mengganti datanya) : ");
    String namaBarang = input.nextLine();
    namaBarang = input.nextLine();

    System.out.print("Stok Barang (isi 0 jika tidak ingin merubah data) : ");
    int stokBarang = input.nextInt();
    
    System.out.print("Harga Barang (isi 0 jika tidak ingin merubah data) : ");
    int hargaBarang = input.nextInt();

    if( cConfig.updateData(idBarang, namaBarang, stokBarang, hargaBarang) ){
      System.out.println("Data barang berhasil dirubah!!");
      cView.getAllData();
    }else{
      System.out.println("Data barang gagal dirubah!!");
    }

  }

}
