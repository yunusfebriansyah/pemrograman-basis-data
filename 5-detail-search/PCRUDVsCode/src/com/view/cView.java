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


}
