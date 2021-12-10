package com.views;
import com.templates.cDashboardFrame;
import com.partials.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.program.Model;

public class dashboardMitraView extends cDashboardFrame{

  private Integer idMitra = null;
  private Integer idSelected = null;

  // sidebar menu
  private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
  private cSidebarMenu menuInfoSaldo = new cSidebarMenu("Info Saldo", 70+50);
  private cSidebarMenu menuRequestPulsa = new cSidebarMenu("Request Pulsa", 70+50+50);
  private cSidebarMenu menuTransaksiSaya = new cSidebarMenu("Transaksi Saya", 70+50+50+50);
  private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70+50+50+50+50);

  // components of beranda
  private cLabelInfo labelSisaSaldoBeranda = new cLabelInfo("Sisa Saldo Anda", 25, 20);
  private cBigFont valueSisaSaldoBeranda = new cBigFont("0", 25, 60);
  private cLabelInfo labelPelayananBeranda = new cLabelInfo("Pelayanan Pulsa Customer", 25, 150);
  private cBigFont valuePelayananBeranda = new cBigFont("0", 25, 190);
  private cLabelInfo labelRequestPulsaBeranda = new cLabelInfo("Request Pulsa Customer Saat Ini", 25, 280);
  private cBigFont valueRequestPulsaBeranda = new cBigFont("0", 25, 320);

  
  // components of InfoSaldo
  private cLabelInfo labelSisaSaldoInfoSaldo = new cLabelInfo("Sisa Saldo Anda", 25, 20);
  private cBigFont valueSisaSaldoInfoSaldo = new cBigFont("0", 25, 60);
  private cLabelInfo labelRequestSaldoInfoSaldo = new cLabelInfo("Data Request", 25, 150);
  private cTable tblDataRequestSaldo;
  private cScrollPane spDataRequestSaldo;
  private cLabelInfo labelDoRequestSaldoInfoSaldo = new cLabelInfo("Sisa Saldo Anda", 490, 20);
  private cErrorLabel errorDoRequestSaldoInfoSaldo = new cErrorLabel("tidak bisa melakukan request jika saldo masih diatas 100K", 490, 60, 400, false);
  private cBlueButton btnRequestSaldo = new cBlueButton("Request", 490, 90, 155);
  
  
  // components of RequestPulsa
  private cLabelInfo labelDataRequestPulsa = new cLabelInfo("Sisa Saldo Anda", 25, 20);
  private cTable tblDataRequestPulsa;
  private cScrollPane spDataRequestPulsa;
  private cBlueButton btnIsiPulsa = new cBlueButton("Isi Pulsa", 25, 280, 155);
  

  // components of Transaksi Saya
  private cLabelInfo labelDataTransaksiSaya = new cLabelInfo("Data Pelayanan Pulsa Berhasil Anda", 25, 20);
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
    this.idMitra = id;
    roleText.setText("Mitra | " + Model.getDetailMitra(idMitra)[1].toString());
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

    valueSisaSaldoBeranda.setText(String.valueOf(Model.getDetailSaldoMitra(idMitra)));
    valuePelayananBeranda.setText(String.valueOf(Model.getCountDoneTransaksiPulsaMitra(idMitra)));
    valueRequestPulsaBeranda.setText(String.valueOf(Model.getCountPendingTransaksiPulsa()));

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

    valueSisaSaldoInfoSaldo.setText(String.valueOf(Model.getDetailSaldoMitra(idMitra)));

    tblDataRequestSaldo = new cTable(Model.getAllTransaksiSaldoByMitra(idMitra));

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

    tblDataRequestPulsa = new cTable(Model.getPendingTransaksiPulsa());

    // hidden column in table
    tblDataRequestPulsa.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataRequestPulsa.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataRequestPulsa.getColumnModel().getColumn(0).setWidth(0);
    tblDataRequestPulsa.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataRequestPulsa.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataRequestPulsa.getColumnModel().getColumn(1).setWidth(0);
   
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

    
    tblDataTransaksiSaya = new cTable(Model.getDoneTransaksiPulsaByMitra(idMitra));

    spDataTransaksiSaya = new cScrollPane(tblDataTransaksiSaya, 25, 76, 740, 310);
    content.add(labelDataTransaksiSaya);
    content.add(spDataTransaksiSaya);
    setVisible(true);
  }

  
}
