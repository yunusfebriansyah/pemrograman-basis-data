package com.views;
import com.templates.cDashboardFrame;
import com.partials.*;

import javax.swing.JOptionPane;

import com.program.Model;

public class dashboardMitraView extends cDashboardFrame{

  private Integer idMitra = null;

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
  private cLabelInfo labelDoRequestSaldoInfoSaldo = new cLabelInfo("Request Saldo", 490, 20);
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
          com.program.Controller.showLoginMitra();
        }
      }
    });

    if( Model.getDetailMitra(idMitra)[3].toString().equalsIgnoreCase("1") ){
      // add component default
      sidebar.add(menuBeranda);
      sidebar.add(menuInfoSaldo);
      sidebar.add(menuRequestPulsa);
      sidebar.add(menuTransaksiSaya);
      sidebar.add(menuLogout);
    }else{
      sidebar.add(menuBeranda);

      menuLogout.setLocation(menuLogout.getLocation().x, menuBeranda.getLocation().y + 50);
      sidebar.add(menuLogout);
    }

    initsBeranda();
  }

  private void initsBeranda()
  {
    resetSidebar();
    menuBeranda.setBackground(cColor.BLUE);
    menuBeranda.setForeground(cColor.WHITE);
    refreshContent();
    menuBeranda.setSidebarAktif();
    menuTitle.setText("Beranda");

    if( Model.getDetailMitra(idMitra)[3].toString().equalsIgnoreCase("1")) {

      valueSisaSaldoBeranda.setText(String.valueOf(Model.getDetailSaldoMitra(idMitra)));
      valuePelayananBeranda.setText(String.valueOf(Model.getCountDoneTransaksiPulsaMitra(idMitra)));
      valueRequestPulsaBeranda.setText(String.valueOf(Model.getCountPendingTransaksiPulsa()));

      content.add(valueSisaSaldoBeranda);
      content.add(labelPelayananBeranda);
      content.add(valuePelayananBeranda);
      content.add(labelRequestPulsaBeranda);
      content.add(valueRequestPulsaBeranda);

    }else{
      labelSisaSaldoBeranda.setText("Anda belum terverifikasi! Silahkan tunggu respon dari admin.");
      labelSisaSaldoBeranda.setSize(labelSisaSaldoBeranda.getWidth() + 300, labelSisaSaldoBeranda.getHeight());
    }

    content.add(labelSisaSaldoBeranda);
    setVisible(true);
  }

  private void initsInfoSaldo()
  {
    resetSidebar();
    menuInfoSaldo.setBackground(cColor.BLUE);
    menuInfoSaldo.setForeground(cColor.WHITE);
    refreshContent();
    menuInfoSaldo.setSidebarAktif();
    menuTitle.setText("Informasi Saldo");

    valueSisaSaldoInfoSaldo.setText(String.valueOf(Model.getDetailSaldoMitra(idMitra)));

    tblDataRequestSaldo = new cTable(Model.getAllTransaksiSaldoByMitra(idMitra));

    spDataRequestSaldo = new cScrollPane(tblDataRequestSaldo, 25, 190, 400, 220);

    if( Model.getDetailSaldoMitra(idMitra) <= 100000 ) content.add(btnRequestSaldo); else content.remove(btnRequestSaldo);

    btnRequestSaldo.addActionListener(new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        
        // cek apakah request saldo berhasil atau tidak
        if( Model.requestSaldoMitra( idMitra ) ){
          // kalo berhasil
          JOptionPane.showMessageDialog(dashboardMitraView.this, "Request saldo berhasil", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
          initsInfoSaldo();
        }else{
          // kalo gagal
          JOptionPane.showMessageDialog(dashboardMitraView.this, "Request saldo gagal!", "Gagal", JOptionPane.ERROR_MESSAGE);
        }

      }
    });

    content.add(labelSisaSaldoInfoSaldo);
    content.add(valueSisaSaldoInfoSaldo);
    content.add(labelRequestSaldoInfoSaldo);
    content.add(spDataRequestSaldo);
    content.add(labelDoRequestSaldoInfoSaldo);
    content.add(errorDoRequestSaldoInfoSaldo);
    
    setVisible(true);
  }

  private void initsRequestPulsa()
  {
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

    btnIsiPulsa.addActionListener(new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {

        int selectedIndex = tblDataRequestPulsa.getSelectedRow();
        
        // cek table diseleksi atau tidak
        if( selectedIndex == -1 ){
          // kalau tidak diseleksi
          JOptionPane.showMessageDialog(dashboardMitraView.this, "Pilih data terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }else{
          // kalo diseleksi
          int jumlahPulsa = Integer.parseInt( tblDataRequestPulsa.getValueAt(selectedIndex, 4).toString() );
          
          // cek saldo mitra mencukupi atau tidak
          if( Model.getDetailSaldoMitra(idMitra) <= jumlahPulsa + 1000 ){
            // kalo saldonya kurang
            JOptionPane.showMessageDialog(dashboardMitraView.this, "Saldo anda tidak mencukupi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
          }else{
            // kalo saldonya cukup

            // tangkap idTransaksiPulsa
            int idTransaksiPulsa = Integer.valueOf( tblDataRequestPulsa.getValueAt(selectedIndex, 0).toString() );
            
            // validasi pengisian pulsa
            if( Model.isiPulsaCustomer( idTransaksiPulsa, idMitra ) ){
              // kalo berhasil
              JOptionPane.showMessageDialog(dashboardMitraView.this, "Isi pulsa berhasil.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
              initsTransaksiSaya();
            }else{
              // kalo gagal
              JOptionPane.showMessageDialog(dashboardMitraView.this, "Isi pulsa gagal!", "Gagal", JOptionPane.ERROR_MESSAGE);
            }
            

          }

        }
        
      }
    });

    content.add(labelDataRequestPulsa);
    content.add(spDataRequestPulsa);
    content.add(btnIsiPulsa);
    setVisible(true);
  }

  private void initsTransaksiSaya()
  {
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
