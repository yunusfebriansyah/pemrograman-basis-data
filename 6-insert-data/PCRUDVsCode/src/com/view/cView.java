package com.view;

import java.util.Scanner;

import com.config.cConfig;

public class cView {

  public static Scanner input = new Scanner(System.in);
  
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

    System.out.println("\nHasil Data");
    System.out.println(cConfig.cariData(keyword));
  }

  public static void tambahData()
  {

    System.out.println("\n::: TAMBAH DATA BARANG :::");
    System.out.print("Masukkan Nama Barang : ");
    String namaBarang = input.nextLine();
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

}
