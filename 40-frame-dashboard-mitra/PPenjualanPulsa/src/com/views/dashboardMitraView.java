package com.views;
import com.templates.cDashboardFrame;
import com.partials.*;
import javax.swing.JOptionPane;

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
  private cLabelInfo labelBeranda = new cLabelInfo("Label Beranda", 25, 20);

  
  // components of InfoSaldo
  private cLabelInfo labelInfoSaldo = new cLabelInfo("Label Info Saldo", 25, 20);
  
  
  // components of RequestPulsa
  private cLabelInfo labelRequestPulsa = new cLabelInfo("Label Request Pulsa", 25, 20);
  

  // components of RequestPulsa
  private cLabelInfo labelTransaksiSaya = new cLabelInfo("Label Transaksi Saya", 25, 20);



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
    content.add(labelBeranda);
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
    content.add(labelInfoSaldo);
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
    content.add(labelRequestPulsa);
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
    content.add(labelTransaksiSaya);
    setVisible(true);
  }

  
}
