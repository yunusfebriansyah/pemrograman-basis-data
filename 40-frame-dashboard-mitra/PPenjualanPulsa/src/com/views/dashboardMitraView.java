package com.views;
import com.templates.cDashboardFrame;
import com.partials.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dashboardMitraView extends cDashboardFrame{

  Integer idMitra = null;
  Integer idSelected = null;

  // sidebar menu
  private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
  private cSidebarMenu menuInfoSaldo = new cSidebarMenu("Info Saldo", 70+50);
  private cSidebarMenu menuRequestPulsa = new cSidebarMenu("Request Pulsa", 70+50+50);
  private cSidebarMenu menuTransaksiSaya = new cSidebarMenu("Transaksi Saya", 70+50+50+50);
  private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70+50+50+50+50);

  // components of beranda
  private cLabelInfo labelSisaSaldoBeranda = new cLabelInfo("Sisa Saldo Anda", 25, 20);
  private cBigFont valueSisaSaldoBeranda = new cBigFont("25.000", 25, 60);
  private cLabelInfo labelPelayananBeranda = new cLabelInfo("Pelayanan Pulsa Customer", 25, 150);
  private cBigFont valuePelayananBeranda = new cBigFont("10", 25, 190);
  private cLabelInfo labelRequestPulsaBeranda = new cLabelInfo("Request Pulsa Customer Saat Ini", 25, 280);
  private cBigFont valueRequestPulsaBeranda = new cBigFont("31", 25, 320);

  
  // components of InfoSaldo
  private cLabelInfo labelSisaSaldoInfoSaldo = new cLabelInfo("Sisa Saldo Anda", 25, 20);
  private cBigFont valueSisaSaldoInfoSaldo = new cBigFont("25.000", 25, 60);
  private cLabelInfo labelRequestSaldoInfoSaldo = new cLabelInfo("Data Request", 25, 150);
  private DefaultTableModel dmRequestSaldo;
  private cTable tblDataRequestSaldo;
  private cScrollPane spDataRequestSaldo;
  private cLabelInfo labelDoRequestSaldoInfoSaldo = new cLabelInfo("Sisa Saldo Anda", 490, 20);
  private cErrorLabel errorDoRequestSaldoInfoSaldo = new cErrorLabel("tidak bisa melakukan request jika saldo masih diatas 100K", 490, 60, 400, false);
  private cBlueButton btnRequestSaldo = new cBlueButton("Request", 490, 90, 155);
  
  
  // components of RequestPulsa
  private cLabelInfo labelDataRequestPulsa = new cLabelInfo("Sisa Saldo Anda", 25, 20);
  private DefaultTableModel dmRequestPulsa;
  private cTable tblDataRequestPulsa;
  private cScrollPane spDataRequestPulsa;
  private cBlueButton btnIsiPulsa = new cBlueButton("Isi Pulsa", 25, 280, 155);
  

  // components of Transaksi Saya
  private cLabelInfo labelDataTransaksiSaya = new cLabelInfo("Data Pelayanan Pulsa Berhasil Anda", 25, 20);
  private DefaultTableModel dmTransaksiSaya;
  private cTable tblDataTransaksiSaya;
  private cScrollPane spDataTransaksiSaya;



  // method resetSidebar
  private void resetSidebar()
  {
    try {
      setVisible(false);

      menuBeranda.setForeground(cColor.GRAY);
      menuBeranda.setBackground(cColor.WHITE);
      menuBeranda.setSidebarNonAktif();

      menuInfoSaldo.setForeground(cColor.GRAY);
      menuInfoSaldo.setBackground(cColor.WHITE);
      menuInfoSaldo.setSidebarNonAktif();

      menuRequestPulsa.setForeground(cColor.GRAY);
      menuRequestPulsa.setBackground(cColor.WHITE);
      menuRequestPulsa.setSidebarNonAktif();

      menuTransaksiSaya.setForeground(cColor.GRAY);
      menuTransaksiSaya.setBackground(cColor.WHITE);
      menuTransaksiSaya.setSidebarNonAktif();
      
      menuLogout.setSidebarNonAktif();
    } catch (Exception e) {
      //TODO: handle exception
    }
  }

  // method refresh content
  private void refreshContent()
  {
    try{
      content.removeAll();
    } catch(Exception e) {
    }
  }

  public dashboardMitraView( Integer id )
  {
    super("Dashboard Mitra");
    idMitra = id;
    roleText.setText("Mitra | Nama Mitra");
    menuBeranda.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsBeranda();
      }
    });
    menuInfoSaldo.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsInfoSaldo();
      }
    });
    menuRequestPulsa.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsRequestPulsa();
      }
    });
    menuTransaksiSaya.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsTransaksiSaya();
      }
    });
    menuLogout.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Object[] options = { "YA", "BATAL" };
        int confirm = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
        null, options, options[0]);
        if(confirm == 0 ){
          idMitra = null;
          idSelected = null;
          com.program.Controller.showLoginMitra();
        }
      }
    });
    // add component default
    sidebar.add(menuBeranda);
    sidebar.add(menuInfoSaldo);
    sidebar.add(menuRequestPulsa);
    sidebar.add(menuTransaksiSaya);
    sidebar.add(menuLogout);

    initsBeranda();
  }

  private void initsBeranda()
  {
    idSelected = null;
    resetSidebar();
    menuBeranda.setBackground(cColor.BLUE);
    menuBeranda.setForeground(cColor.WHITE);
    refreshContent();
    menuBeranda.setSidebarAktif();
    menuTitle.setText("Beranda");
    content.add(labelSisaSaldoBeranda);
    content.add(valueSisaSaldoBeranda);
    content.add(labelPelayananBeranda);
    content.add(valuePelayananBeranda);
    content.add(labelRequestPulsaBeranda);
    content.add(valueRequestPulsaBeranda);
    setVisible(true);
  }
  
  private void initsInfoSaldo()
  {
    idSelected = null;
    resetSidebar();
    menuInfoSaldo.setBackground(cColor.BLUE);
    menuInfoSaldo.setForeground(cColor.WHITE);
    refreshContent();
    menuInfoSaldo.setSidebarAktif();
    menuTitle.setText("Informasi Saldo");
    String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
    String[][] dataUser = {
      {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
      {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
      {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
      {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
      {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
    };
    dmRequestSaldo = new DefaultTableModel(dataUser, dataUserHeader);
    tblDataRequestSaldo = new cTable(dmRequestSaldo);
    spDataRequestSaldo = new cScrollPane(tblDataRequestSaldo, 25, 190, 400, 220);
    content.add(labelSisaSaldoInfoSaldo);
    content.add(valueSisaSaldoInfoSaldo);
    content.add(labelRequestSaldoInfoSaldo);
    content.add(spDataRequestSaldo);
    content.add(labelDoRequestSaldoInfoSaldo);
    content.add(errorDoRequestSaldoInfoSaldo);
    content.add(btnRequestSaldo);
    setVisible(true);
  }

  private void initsRequestPulsa()
  {
    idSelected = null;
    resetSidebar();
    menuRequestPulsa.setBackground(cColor.BLUE);
    menuRequestPulsa.setForeground(cColor.WHITE);
    refreshContent();
    menuRequestPulsa.setSidebarAktif();
    menuTitle.setText("Request Pulsa Customer");
    String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
    String[][] dataUser = {
      {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
      {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
      {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
      {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
      {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
    };
    dmRequestPulsa = new DefaultTableModel(dataUser, dataUserHeader);
    tblDataRequestPulsa = new cTable(dmRequestPulsa);
    spDataRequestPulsa = new cScrollPane(tblDataRequestPulsa, 25, 76, 740, 190);
    content.add(labelDataRequestPulsa);
    content.add(spDataRequestPulsa);
    content.add(btnIsiPulsa);
    setVisible(true);
  }

  private void initsTransaksiSaya()
  {
    idSelected = null;
    resetSidebar();
    menuTransaksiSaya.setBackground(cColor.BLUE);
    menuTransaksiSaya.setForeground(cColor.WHITE);
    refreshContent();
    menuTransaksiSaya.setSidebarAktif();
    menuTitle.setText("Transaksi Pulsa Anda");
    String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
    String[][] dataUser = {
      {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
      {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
      {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
      {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
      {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
    };
    dmTransaksiSaya = new DefaultTableModel(dataUser, dataUserHeader);
    tblDataTransaksiSaya = new cTable(dmTransaksiSaya);
    spDataTransaksiSaya = new cScrollPane(tblDataTransaksiSaya, 25, 76, 740, 310);
    content.add(labelDataTransaksiSaya);
    content.add(spDataTransaksiSaya);
    setVisible(true);
  }

  
}
