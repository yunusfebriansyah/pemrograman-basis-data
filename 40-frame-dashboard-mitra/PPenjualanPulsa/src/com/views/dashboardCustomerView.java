package com.views;
import com.templates.cDashboardFrame;
import com.partials.*;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dashboardCustomerView extends cDashboardFrame{

  Integer idCustomer = null;
  Integer idSelected = null;

  // sidebar menu
  private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
  private cSidebarMenu menuBeliPulsa = new cSidebarMenu("Beli Pulsa", 70+50);
  private cSidebarMenu menuBeliPaket = new cSidebarMenu("Beli Paket", 70+50+50);
  private cSidebarMenu menuHistoryBeliPulsa = new cSidebarMenu("History Beli Pulsa", 70+50+50+50);
  private cSidebarMenu menuHistoryBeliPaket = new cSidebarMenu("History Beli Paket", 70+50+50+50+50);
  private cSidebarMenu menuAkun = new cSidebarMenu("Akun", 70+50+50+50+50+50);
  private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70+50+50+50+50+50+50);

  // components of beranda
  private cLabelInfo labelSisaPulsaBeranda = new cLabelInfo("Sisa Pulsa Anda", 25, 20);
  private cBigFont valueSisaPulsaBeranda = new cBigFont("55.000", 25, 60);
  private cLabelInfo labelSisaKuotaBeranda = new cLabelInfo("Sisa Kuota Anda", 25, 150);
  private cBigFont valueSisaKuotaBeranda = new cBigFont("11GB", 25, 190);

  // Beli Pulsa components
  private cLabelInfo labelSisaPulsaBeliPulsa = new cLabelInfo("Sisa Pulsa Anda", 25, 20);
  private cBigFont valueSisaPulsaBeliPulsa = new cBigFont("55.000", 25, 60);
  private cLabelInfo labelPilihanBeliPulsa = new cLabelInfo("Pilihan Beli Pulsa", 25, 150);
  private cRadioButton rd5k = new cRadioButton("5K", "5000", 25, 190, 72);
  private cRadioButton rd10k = new cRadioButton("10K", "10000", 102, 190, 72);
  private cRadioButton rd25k = new cRadioButton("25K", "25000", 179, 190, 72);
  private cRadioButton rd50k = new cRadioButton("50K", "50000", 256, 190, 72);
  private cRadioButton rd100k = new cRadioButton("100K", "10000", 333, 190, 72);
  private cBlueButton btnBeliPulsa = new cBlueButton("Beli Pulsa", 25, 220, 155);
  private ButtonGroup rdPilihaPulsa = new ButtonGroup();

  // beli paket components
  private cLabelInfo labelSisaKuotaBeliPaket = new cLabelInfo("Sisa Kuota Anda", 25, 20);
  private cBigFont valueSisaKuotaBeliPaket = new cBigFont("11GB", 25, 60);
  private cLabelInfo labelPilihanBeliPaket = new cLabelInfo("Pilihan Beli Paket Kuota", 25, 150);
  private DefaultTableModel dmPaket;
  private cTable dataPaket;
  private cScrollPane spDataPaket;
  private cBlueButton btnBeliPaket = new cBlueButton("Beli Paket", 25, 390, 155);
  private cLabelInfo labelDeskripsiPaket = new cLabelInfo("DeskripsiPaket", 473, 190);
  private cTextarea valueDeskripsiPaket = new cTextarea("", 473, 231, false);

  // history beli pulsa components
  private cLabelInfo labelHistoryPulsa = new cLabelInfo("Semua Pembelian Pulsa Saya", 25, 20);
  private DefaultTableModel dmHistoryPulsa;
  private cTable tblDataHistoryPulsa;
  private cScrollPane spDataHistoryPulsa;

  // history beli Paket components
  private cLabelInfo labelHistoryPaket = new cLabelInfo("Semua Pembelian Paket Saya", 25, 20);
  private DefaultTableModel dmHistoryPaket;
  private cTable tblDataHistoryPaket;
  private cScrollPane spDataHistoryPaket;
  
  // akun customer components
  private cLabelInfo labelAkun = new cLabelInfo("Data Akun Saya", 25, 20);
  private cFormLabel labelNama = new cFormLabel("Nama", 25, 65, 360, false);
  private cTextField txtNama = new cTextField(25, 90, 360, false);
  private cErrorLabel errorNama = new cErrorLabel("nama tidak boleh kosong!", 25, 125, 360, false);
  private cFormLabel labelNoHp = new cFormLabel("No Hp", 25, 150, 360, false);
  private cFormLabel valueNoHp;
  private cFormLabel labelEmail = new cFormLabel("Email", 25, 202, 360, false);
  private cTextField txtEmail = new cTextField(25, 227, 360, false);
  private cErrorLabel errorEmail = new cErrorLabel("email tidak boleh kosong!", 25, 262, 360, false);
  private cBlueButton btnUbahAkun = new cBlueButton("Ubah Data Akun", 25, 292, 155);

  // method resetSidebar
  private void resetSidebar()
  {
    try {
      setVisible(false);

      menuBeranda.setForeground(cColor.GRAY);
      menuBeranda.setBackground(cColor.WHITE);
      menuBeranda.setSidebarNonAktif();

      menuBeliPulsa.setSidebarNonAktif();
      menuBeliPulsa.setForeground(cColor.GRAY);
      menuBeliPulsa.setBackground(cColor.WHITE);

      menuBeliPaket.setSidebarNonAktif();
      menuBeliPaket.setForeground(cColor.GRAY);
      menuBeliPaket.setBackground(cColor.WHITE);

      menuHistoryBeliPulsa.setSidebarNonAktif();
      menuHistoryBeliPulsa.setForeground(cColor.GRAY);
      menuHistoryBeliPulsa.setBackground(cColor.WHITE);

      menuHistoryBeliPaket.setSidebarNonAktif();
      menuHistoryBeliPaket.setForeground(cColor.GRAY);
      menuHistoryBeliPaket.setBackground(cColor.WHITE);

      menuAkun.setSidebarNonAktif();
      menuAkun.setForeground(cColor.GRAY);
      menuAkun.setBackground(cColor.WHITE);
      
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

  public dashboardCustomerView( Integer id )
  {
    super("Dashboard Customer");
    idCustomer = id;
    roleText.setText("Customer | Nama Customer");
    menuBeranda.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsBeranda();
      }
    });
    menuBeliPulsa.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsBeliPulsa();
      }
    });
    menuBeliPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsBeliPaket();
      }
    });
    menuHistoryBeliPulsa.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsHistoryBeliPulsa();
      }
    });
    menuHistoryBeliPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsHistoryBeliPaket();
      }
    });
    menuAkun.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsAkun();
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
          idCustomer = null;
          idSelected = null;
          com.program.Controller.showLoginCustomer();
        }
      }
    });
    // add component default
    sidebar.add(menuBeranda);
    sidebar.add(menuBeliPulsa);
    sidebar.add(menuBeliPaket);
    sidebar.add(menuHistoryBeliPulsa);
    sidebar.add(menuHistoryBeliPaket);
    sidebar.add(menuAkun);
    sidebar.add(menuLogout);

    rdPilihaPulsa.add(rd5k);
    rdPilihaPulsa.add(rd10k);
    rdPilihaPulsa.add(rd25k);
    rdPilihaPulsa.add(rd50k);
    rdPilihaPulsa.add(rd100k);

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
    content.add(labelSisaPulsaBeranda);
    content.add(valueSisaPulsaBeranda);
    content.add(labelSisaKuotaBeranda);
    content.add(valueSisaKuotaBeranda);
    setVisible(true);
  }

  private void initsBeliPulsa()
  {
    idSelected = null;
    resetSidebar();
    menuBeliPulsa.setBackground(cColor.BLUE);
    menuBeliPulsa.setForeground(cColor.WHITE);
    refreshContent();
    menuBeliPulsa.setSidebarAktif();
    menuTitle.setText("Beli Pulsa");
    content.add(labelSisaPulsaBeliPulsa);
    content.add(valueSisaPulsaBeliPulsa);
    content.add(labelPilihanBeliPulsa);
    content.add(rd5k);
    content.add(rd10k);
    content.add(rd25k);
    content.add(rd50k);
    content.add(rd100k);
    content.add(btnBeliPulsa);
    setVisible(true);
  }
  private void initsBeliPaket()
  {
    idSelected = null;
    resetSidebar();
    menuBeliPaket.setBackground(cColor.BLUE);
    menuBeliPaket.setForeground(cColor.WHITE);
    refreshContent();
    menuBeliPaket.setSidebarAktif();
    menuTitle.setText("Beli Paket");
    String[] dataUserHeader = {"Nama", "Kuota", "Harga"};
    String[][] dataUser = {
      {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
      {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
      {"Hemat Mantap", "11GB", "76.000"},
      {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
      {"Row5 Col1", "Row5 Col2", "Row5 Col3"},
      {"Row6 Col1", "Row6 Col2", "Row6 Col3"}
    };
    dmPaket = new DefaultTableModel(dataUser, dataUserHeader);
    dataPaket = new cTable(dmPaket);
    spDataPaket = new cScrollPane(dataPaket, 25, 190, 428, 190);
    String textDeskripsiPaket = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam totam doloribus velit ipsa! Beatae tempore quod laborum porro optio aliquam voluptate commodi assumenda explicabo debitis accusamus obcaecati, quo nostrum esse!";
    valueDeskripsiPaket.setText(textDeskripsiPaket);
    content.add(labelSisaKuotaBeliPaket);
    content.add(valueSisaKuotaBeliPaket);
    content.add(labelPilihanBeliPaket);
    content.add(spDataPaket);
    content.add(btnBeliPaket);
    content.add(labelDeskripsiPaket);
    content.add(valueDeskripsiPaket);
    setVisible(true);
  }
  
  private void initsHistoryBeliPulsa()
  {
    idSelected = null;
    resetSidebar();
    menuHistoryBeliPulsa.setBackground(cColor.BLUE);
    menuHistoryBeliPulsa.setForeground(cColor.WHITE);
    refreshContent();
    menuHistoryBeliPulsa.setSidebarAktif();
    menuTitle.setText("Transaksi Pulsa Saya");
    String[] dataHistoryPulsaHeader = {"Pulsa", "Mitra", "Waktu", "Status"};
    String[][] dataHistoryPulsa = {
      {"Row1 Col1", "Row1 Col2", "Row1 Col3", "Row1 Col4"},
      {"5.000", "-", "2021-08-19 15:30:21", "diproses"},
      {"25.000", "Yudi Cell", "2021-08-19 15:21:20", "selesai"},
      {"Row4 Col1", "Row4 Col2", "Row4 Col3", "Row4 Col4"},
      {"Row5 Col1", "Row5 Col2", "Row5 Col3", "Row5 Col4"},
      {"Row6 Col1", "Row6 Col2", "Row6 Col3", "Row6 Col4"},
      {"Row7 Col1", "Row7 Col2", "Row7 Col3", "Row7 Col4"},
      {"Row8 Col1", "Row8 Col2", "Row8 Col3", "Row8 Col4"},
      {"Row9 Col1", "Row9 Col2", "Row9 Col3", "Row9 Col4"},
      {"Row10 Col1", "Row10 Col2", "Row10 Col3", "Row10 Col4"}
    };
    dmHistoryPulsa = new DefaultTableModel(dataHistoryPulsa, dataHistoryPulsaHeader);
    tblDataHistoryPulsa = new cTable(dmHistoryPulsa);
    spDataHistoryPulsa = new cScrollPane(tblDataHistoryPulsa, 25, 65, 740, 310);
    content.add(labelHistoryPulsa);
    content.add(spDataHistoryPulsa);
    setVisible(true);
  }

  private void initsHistoryBeliPaket()
  {
    idSelected = null;
    resetSidebar();
    menuHistoryBeliPaket.setBackground(cColor.BLUE);
    menuHistoryBeliPaket.setForeground(cColor.WHITE);
    refreshContent();
    menuHistoryBeliPaket.setSidebarAktif();
    menuTitle.setText("Transaksi Paket Saya");
    String[] dataHistoryPaketHeader = {"Paket", "Kuota", "Harga", "Waktu", "Status"};
    String[][] dataHistoryPaket = {
      {"Row1 Col1", "Row1 Col2", "Row1 Col3", "Row1 Col4", "Row1 Col5"},
      {"Hemat Mantap", "11GB", "76.000", "2021-08-19 15:21:20", "selesai"},
      {"Row3 Col1", "Row3 Col2", "Row3 Col3", "Row3 Col4", "Row3 Col5"},
      {"Row4 Col1", "Row4 Col2", "Row4 Col3", "Row4 Col4", "Row4 Col5"},
      {"Row5 Col1", "Row5 Col2", "Row5 Col3", "Row5 Col4", "Row5 Col5"},
      {"Row6 Col1", "Row6 Col2", "Row6 Col3", "Row6 Col4", "Row6 Col5"},
      {"Row7 Col1", "Row7 Col2", "Row7 Col3", "Row7 Col4", "Row7 Col5"},
      {"Row8 Col1", "Row8 Col2", "Row8 Col3", "Row8 Col4", "Row8 Col5"},
      {"Row9 Col1", "Row9 Col2", "Row9 Col3", "Row9 Col4", "Row9 Col5"},
      {"Row10 Col1", "Row10 Col2", "Row10 Col3", "Row10 Col4", "Row10 Col5"}
    };
    dmHistoryPaket = new DefaultTableModel(dataHistoryPaket, dataHistoryPaketHeader);
    tblDataHistoryPaket = new cTable(dmHistoryPaket);
    spDataHistoryPaket = new cScrollPane(tblDataHistoryPaket, 25, 65, 924, 310);
    content.add(labelHistoryPaket);
    content.add(spDataHistoryPaket);
    setVisible(true);
  }

  private void initsAkun()
  {
    idSelected = null;
    resetSidebar();
    menuAkun.setBackground(cColor.BLUE);
    menuAkun.setForeground(cColor.WHITE);
    refreshContent();
    menuAkun.setSidebarAktif();
    menuTitle.setText("Akun Saya");
    valueNoHp = new cFormLabel("08123xxx", 25, 174, 360, false);
    valueNoHp.setFont(com.partials.cFonts.RADIO_BUTTON_FONT);
    valueNoHp.setForeground(com.partials.cColor.RED);
    content.add(labelAkun);
    content.add(labelNama);
    content.add(txtNama);
    content.add(errorNama);
    content.add(labelNoHp);
    content.add(valueNoHp);
    content.add(labelEmail);
    content.add(txtEmail);
    content.add(errorEmail);
    content.add(btnUbahAkun);
    setVisible(true);
  }
  
}
