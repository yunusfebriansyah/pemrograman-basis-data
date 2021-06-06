package com.view;

import com.config.cConfig;

public class cView {
  
  public static void getAllData()
  {
    //  pesan header
    System.out.println("\n::: DATA BARANG :::");
    // data semua barangnya
    System.out.println(cConfig.getAllData());

  }

}
