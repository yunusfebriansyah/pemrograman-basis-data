package com.views;
import com.templates.cDashboardFrame;
import com.partials.*;
import com.program.Model;

import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;

class Filter{
  static String filter = "semua";
  static String keyword = "";

  static DefaultTableModel search()
  {
    DefaultTableModel tm = new DefaultTableModel();

    if( filter.equalsIgnoreCase("semua") ){
      // memanggil dan menggantikan tm dengan return dari getSearchAllPaket
      tm = Model.getSearchAllPaket(keyword);
    }else if( filter.equalsIgnoreCase("aktif") ){
      tm = Model.getSearchPaketAktif(keyword);
    }else if ( filter.equalsIgnoreCase("tidak aktif") ){
      tm = Model.getSearchPaketNonAktif(keyword);
    }

    return tm;
  }

}

public class dashboardAdminView extends cDashboardFrame{

  private boolean statusLogin = false;
  private Integer idSelected = null;

  // sidebar menu
  private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
  private cSidebarMenu menuDataMitra = new cSidebarMenu("Data Mitra", 70+50);
  private cSidebarMenu menuDataCustomer = new cSidebarMenu("Data Customer", 70+50+50);
  private cSidebarMenu menuDataPaket = new cSidebarMenu("Data Paket", 70+50+50+50);
  private cSidebarMenu menuRequestSaldo = new cSidebarMenu("Request Saldo", 70+50+50+50+50);
  private cSidebarMenu menuCalonMitra = new cSidebarMenu("Calon Mitra", 70+50+50+50+50+50);
  private cSidebarMenu menuTransaksiPulsa = new cSidebarMenu("Transaksi Pulsa", 70+50+50+50+50+50+50);
  private cSidebarMenu menuTransaksiPaket = new cSidebarMenu("Transaksi Paket", 70+50+50+50+50+50+50+50);
  private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70+50+50+50+50+50+50+50+50);

// beranda components
private cLabelInfo labelJmlDataMitraBeranda = new cLabelInfo("Jumlah Data Mitra Terverifikasi", 25, 20);
private cBigFont valueJmlDataMitraBeranda = new cBigFont("0", 25, 60);
private cLabelInfo labelJmlDataCustomerBeranda = new cLabelInfo("Jumlah Data Customer Aktif", 25, 150);
private cBigFont valueJmlDataCustomerBeranda = new cBigFont("0", 25, 190);
private cLabelInfo labelJmlTransaksiPulsaBeranda = new cLabelInfo("Jumlah Transaksi Pulsa Berhasil", 25, 280);
private cBigFont valueJmlTransaksiPulsaBeranda = new cBigFont("0", 25, 320);
private cLabelInfo labelJmlTransaksiPaketBeranda = new cLabelInfo("Jumlah Transaksi Paket Berhasil", 495, 20);
private cBigFont valueJmlTransaksiPaketBeranda = new cBigFont("0", 495, 60);
private cLabelInfo labelJmlCalonMitraBeranda = new cLabelInfo("Jumlah Data Calon Mitra", 495, 150);
private cBigFont valueJmlCalonMitraBeranda = new cBigFont("0", 495, 190);
private cLabelInfo labelJmlRequestSaldoBeranda = new cLabelInfo("Jumlah Request Saldo Pending", 495, 280);
private cBigFont valueJmlRequestSaldoBeranda = new cBigFont("0", 495, 320);

  // DataMitra components
  private cLabelInfo labelDataMitra = new cLabelInfo("Data Mitra Terverifikasi", 25, 20);
  private cFormLabel labelCariDataMitra = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariDataMitra = new cTextField(83, 70, 350, false);
  private cTable tblDataDataMitra;
  private cScrollPane spDataDataMitra;
  private cRedButton btnHapusDataMitra = new cRedButton("Hapus", 25, 446, 110);
  
  // DataCustomer components
  private cLabelInfo labelDataCustomer = new cLabelInfo("Data Customer Aktif", 25, 20);
  private cFormLabel labelCariDataCustomer = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariDataCustomer = new cTextField(83, 70, 350, false);
  private cTable tblDataDataCustomer;
  private cScrollPane spDataDataCustomer;
  private cRedButton btnHapusDataCustomer = new cRedButton("Hapus", 25, 446, 110);

  // Data Paket components
  private cLabelInfo labelDataPaket = new cLabelInfo("Data Request Request Saldo Pending", 25, 20);
  private cFormLabel labelCariDataPaket = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariDataPaket = new cTextField(83, 70, 317, false);
  private cBlueButton btnTambahDataPaket = new cBlueButton("Tambah Paket", 418, 70, 162);
  private cRadioButton rdSemuaDataPaket = new cRadioButton("Semua", "all", 25, 115, 97);
  private cRadioButton rdAktifDataPaket = new cRadioButton("Aktif", "active", 132, 115, 72);
  private cRadioButton rdTidakAktifDataPaket = new cRadioButton("Tidak Aktif", "nonactive", 214, 115, 112);
  private cTable tblDataDataPaket;
  private cScrollPane spDataDataPaket;
  private cGreenButton btnUbahDataPaket = new cGreenButton("Ubah", 25, 410, 92);
  private cLabelInfo labelDeskripsiPaketDataPaket = new cLabelInfo("Deskripsi Paket", 600, 145);
  private cTextarea valueDeskripsiPaketDataPaket = new cTextarea("", 600, 186, false);
  
  // TambahDataPaket components
  private cLabelInfo labelTambahDataPaket = new cLabelInfo("Isi form data paket dengan lengkap", 25, 20);
  private cFormLabel labelNamaPaketTambahDataPaket = new cFormLabel("Nama Paket", 25, 65, 550, false);
  private cTextField txtNamaPaketTambahDataPaket = new cTextField(25, 90, 550, false);
  private cErrorLabel errorNamaPaketTambahDataPaket = new cErrorLabel("nama paket tidak boleh kosong!", 25, 125, 550, false);
  private cFormLabel labelKuotaPaketTambahDataPaket = new cFormLabel("Kuota Paket", 25, 150, 550, false);
  private cTextField txtKuotaPaketTambahDataPaket = new cTextField(25, 175, 550, false);
  private cErrorLabel errorKuotaPaketTambahDataPaket = new cErrorLabel("kuota paket tidak boleh kosong!", 25, 210, 550, false);
  private cFormLabel labelHargaPaketTambahDataPaket = new cFormLabel("Harga Paket", 25, 235, 550, false);
  private cTextField txtHargaPaketTambahDataPaket = new cTextField(25, 260, 550, false);
  private cErrorLabel errorHargaPaketTambahDataPaket = new cErrorLabel("harga paket tidak boleh kosong!", 25, 295, 550, false);
  private cCheckbox chAktifTambahDataPaket = new cCheckbox("Aktifkan", "1", 25, 316, 100);
  private cBlueButton btnTambahPaketTambahDataPaket = new cBlueButton("Tambah", 25, 348, 110);
  private cRedButton btnBatalTambahDataPaket = new cRedButton("Batal", 155, 348, 110);
  private cFormLabel labelDeskripsiPaketTambahDataPaket = new cFormLabel("Deskripsi Paket", 595, 65, 370, false);
  private cTextarea txtDeskripsiPaketTambahDataPaket = new cTextarea(true);
  private cScrollPane spTxtDeskripsiPaketTambahDataPaket = new cScrollPane(txtDeskripsiPaketTambahDataPaket, 595, 90, 370, 205);
  private cErrorLabel errorDeskripsiPaketTambahDataPaket = new cErrorLabel("deskripsi paket tidak boleh kosong!", 595, 295, 370, false);

  // UbahDataPaket components
  private cLabelInfo labelUbahDataPaket = new cLabelInfo("Isi form data paket dengan lengkap", 25, 20);
  private cFormLabel labelNamaPaketUbahDataPaket = new cFormLabel("Nama Paket", 25, 65, 550, false);
  private cTextField txtNamaPaketUbahDataPaket = new cTextField(25, 90, 550, false);
  private cErrorLabel errorNamaPaketUbahDataPaket = new cErrorLabel("nama paket tidak boleh kosong!", 25, 125, 550, false);
  private cFormLabel labelKuotaPaketUbahDataPaket = new cFormLabel("Kuota Paket", 25, 150, 550, false);
  private cTextField txtKuotaPaketUbahDataPaket = new cTextField(25, 175, 550, false);
  private cErrorLabel errorKuotaPaketUbahDataPaket = new cErrorLabel("kuota paket tidak boleh kosong!", 25, 210, 550, false);
  private cFormLabel labelHargaPaketUbahDataPaket = new cFormLabel("Harga Paket", 25, 235, 550, false);
  private cTextField txtHargaPaketUbahDataPaket = new cTextField(25, 260, 550, false);
  private cErrorLabel errorHargaPaketUbahDataPaket = new cErrorLabel("harga paket tidak boleh kosong!", 25, 295, 550, false);
  private cCheckbox chAktifUbahDataPaket = new cCheckbox("Aktifkan", "1", 25, 316, 100);
  private cBlueButton btnUbahPaketUbahDataPaket = new cBlueButton("Ubah", 25, 348, 110);
  private cRedButton btnBatalUbahDataPaket = new cRedButton("Batal", 155, 348, 110);
  private cFormLabel labelDeskripsiPaketUbahDataPaket = new cFormLabel("Deskripsi Paket", 595, 65, 370, false);
  private cTextarea txtDeskripsiPaketUbahDataPaket = new cTextarea(true);
  private cScrollPane spTxtDeskripsiPaketUbahDataPaket = new cScrollPane(txtDeskripsiPaketUbahDataPaket, 595, 90, 370, 205);
  private cErrorLabel errorDeskripsiPaketUbahDataPaket = new cErrorLabel("deskripsi paket tidak boleh kosong!", 595, 295, 370, false);
  
  // RequestSaldo components
  private cLabelInfo labelRequestSaldo = new cLabelInfo("Data Request Request Saldo Pending", 25, 20);
  private cFormLabel labelCariRequestSaldo = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariRequestSaldo = new cTextField(83, 70, 317, false);
  private cBlueButton btnLihatBerhasilRequestSaldo = new cBlueButton("Lihat Berhasil", 418, 70, 162);
  private cTable tblDataRequestSaldo;
  private cScrollPane spDataRequestSaldo;
  private cGreenButton btnApproveRequestSaldo = new cGreenButton("Setujui", 25, 446, 110);
  
  // RequestSaldoDone components
  private cLabelInfo labelRequestSaldoDone = new cLabelInfo("Data Request Request Saldo Berhasil", 25, 20);
  private cFormLabel labelCariRequestSaldoDone = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariRequestSaldoDone = new cTextField(83, 70, 317, false);
  private cBlueButton btnLihatPendingRequestSaldoDone = new cBlueButton("Lihat Pending", 418, 70, 162);
  private cTable tblDataRequestSaldoDone;
  private cScrollPane spDataRequestSaldoDone;
  
  // CalonMitra components
  private cLabelInfo labelCalonMitra = new cLabelInfo("Data Request Calon Mitra", 25, 20);
  private cFormLabel labelCariCalonMitra = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariCalonMitra = new cTextField(83, 70, 350, false);
  private cTable tblDataCalonMitra;
  private cScrollPane spDataCalonMitra;
  private cGreenButton btnApproveCalonMitra = new cGreenButton("Setujui", 25, 446, 110);
  
  // TransaksiPulsa components
  private cLabelInfo labelTransaksiPulsa = new cLabelInfo("Semua Data Transaksi Pulsa", 25, 20);
  private cFormLabel labelCariTransaksiPulsa = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariTransaksiPulsa = new cTextField(83, 70, 350, false);
  private cTable tblDataTransaksiPulsa;
  private cScrollPane spDataTransaksiPulsa;
  
  // TransaksiPaket components
  private cLabelInfo labelTransaksiPaket = new cLabelInfo("Semua Data Transaksi Paket", 25, 20);
  private cFormLabel labelCariTransaksiPaket = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariTransaksiPaket = new cTextField(83, 70, 350, false);
  private cTable tblDataTransaksiPaket;
  private cScrollPane spDataTransaksiPaket;



  // method resetSidebar
  private void resetSidebar()
  {
    try {
      setVisible(false);
      
      menuBeranda.setForeground(cColor.GRAY);
      menuBeranda.setBackground(cColor.WHITE);
      menuBeranda.setSidebarNonAktif();

      menuDataMitra.setForeground(cColor.GRAY);
      menuDataMitra.setBackground(cColor.WHITE);
      menuDataMitra.setSidebarNonAktif();

      menuDataCustomer.setForeground(cColor.GRAY);
      menuDataCustomer.setBackground(cColor.WHITE);
      menuDataCustomer.setSidebarNonAktif();

      menuDataPaket.setForeground(cColor.GRAY);
      menuDataPaket.setBackground(cColor.WHITE);
      menuDataPaket.setSidebarNonAktif();

      menuRequestSaldo.setForeground(cColor.GRAY);
      menuRequestSaldo.setBackground(cColor.WHITE);
      menuRequestSaldo.setSidebarNonAktif();

      menuCalonMitra.setForeground(cColor.GRAY);
      menuCalonMitra.setBackground(cColor.WHITE);
      menuCalonMitra.setSidebarNonAktif();

      menuTransaksiPulsa.setForeground(cColor.GRAY);
      menuTransaksiPulsa.setBackground(cColor.WHITE);
      menuTransaksiPulsa.setSidebarNonAktif();

      menuTransaksiPaket.setForeground(cColor.GRAY);
      menuTransaksiPaket.setBackground(cColor.WHITE);
      menuTransaksiPaket.setSidebarNonAktif();

      
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

  public dashboardAdminView( boolean statusLogin )
  {
    super("Dashboard Admin");
    this.statusLogin = statusLogin;
    this.idSelected = null;
    roleText.setText("Admin");
    menuBeranda.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsBeranda();
      }
    });
    menuDataMitra.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsDataMitra();
      }
    });
    menuDataCustomer.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsDataCustomer();
      }
    });
    menuDataPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsDataPaket();
      }
    });
    menuRequestSaldo.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsRequestSaldo();
      }
    });
    menuCalonMitra.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsCalonMitra();
      }
    });
    menuTransaksiPulsa.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsTransaksiPulsa();
      }
    });
    menuTransaksiPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsTransaksiPaket();
      }
    });


    menuLogout.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsLogout();
      }
    });


    // add component default
    sidebar.add(menuBeranda);
    sidebar.add(menuDataMitra);
    sidebar.add(menuDataCustomer);
    sidebar.add(menuDataPaket);
    sidebar.add(menuRequestSaldo);
    sidebar.add(menuCalonMitra);
    sidebar.add(menuTransaksiPulsa);
    sidebar.add(menuTransaksiPaket);
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

    valueJmlDataMitraBeranda.setText( String.valueOf( Model.getCountMitraTerverifikasi() ) );
    valueJmlDataCustomerBeranda.setText( Integer.toString( Model.getCountCustomer() ) );
    valueJmlTransaksiPulsaBeranda.setText(String.valueOf( Model.getCountDoneTransaksiPulsa() ));
    valueJmlTransaksiPaketBeranda.setText(String.valueOf( Model.getCountDoneTransaksiPaket() ));
    valueJmlCalonMitraBeranda.setText(String.valueOf( Model.getCountMitraNonVerifikasi() ));
    valueJmlRequestSaldoBeranda.setText( String.valueOf( Model.getCountPendingTransaksiSaldo() ) );

    content.add(labelJmlDataMitraBeranda);
    content.add(valueJmlDataMitraBeranda);
    content.add(labelJmlDataCustomerBeranda);
    content.add(valueJmlDataCustomerBeranda);
    content.add(labelJmlTransaksiPulsaBeranda);
    content.add(valueJmlTransaksiPulsaBeranda);
    content.add(labelJmlTransaksiPaketBeranda);
    content.add(valueJmlTransaksiPaketBeranda);
    content.add(labelJmlCalonMitraBeranda);
    content.add(valueJmlCalonMitraBeranda);
    content.add(labelJmlRequestSaldoBeranda);
    content.add(valueJmlRequestSaldoBeranda);
    setVisible(true);
  }

  private void initsDataMitra()
  {
    idSelected = null;
    resetSidebar();
    menuDataMitra.setBackground(cColor.BLUE);
    menuDataMitra.setForeground(cColor.WHITE);
    refreshContent();
    menuDataMitra.setSidebarAktif();
    menuTitle.setText("Data Mitra");
    tblDataDataMitra = new cTable(Model.getAllSaldoMitra());

    tblDataDataMitra.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(0).setWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(1).setWidth(0);

    spDataDataMitra = new cScrollPane(tblDataDataMitra, 25, 120, 555, 310);

    txtCariDataMitra.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed ( java.awt.event.ActionEvent ae )
      {
        String keyword = txtCariDataMitra.getText();
        tblDataDataMitra.setModel( Model.getSearchSaldoMitra(keyword) );
        tblDataDataMitra.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(0).setWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(1).setWidth(0);
      }
    } );

    content.add(labelDataMitra);
    content.add(labelCariDataMitra);
    content.add(txtCariDataMitra);
    content.add(spDataDataMitra);
    content.add(btnHapusDataMitra);
    setVisible(true);
  }

  private void initsDataCustomer()
  {
    idSelected = null;
    resetSidebar();
    menuDataCustomer.setBackground(cColor.BLUE);
    menuDataCustomer.setForeground(cColor.WHITE);
    refreshContent();
    menuDataCustomer.setSidebarAktif();
    menuTitle.setText("Data Customer");
    
    tblDataDataCustomer = new cTable(Model.getPulsaKuotaCustomer());

    tblDataDataCustomer.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataDataCustomer.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataDataCustomer.getColumnModel().getColumn(0).setWidth(0);
    tblDataDataCustomer.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataDataCustomer.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataDataCustomer.getColumnModel().getColumn(1).setWidth(0);

    spDataDataCustomer = new cScrollPane(tblDataDataCustomer, 25, 120, 925, 310);

    txtCariDataCustomer.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed( java.awt.event.ActionEvent ae )
      {
        String keyword = txtCariDataCustomer.getText();
        tblDataDataCustomer.setModel(Model.getSearchPulsaKuotaCustomer(keyword));
        tblDataDataCustomer.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(0).setWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(1).setWidth(0);
      }
    } );

    content.add(labelDataCustomer);
    content.add(labelCariDataCustomer);
    content.add(txtCariDataCustomer);
    content.add(spDataDataCustomer);
    content.add(btnHapusDataCustomer);
    setVisible(true);
  }

  private void initsDataPaket()
  {
    idSelected = null;
    resetSidebar();
    menuDataPaket.setBackground(cColor.BLUE);
    menuDataPaket.setForeground(cColor.WHITE);
    refreshContent();
    menuDataPaket.setSidebarAktif();
    menuTitle.setText("Data Paket");

    tblDataDataPaket = new cTable( Model.getAllPaket() );
    tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);

    tblDataDataPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mousePressed( java.awt.event.MouseEvent me )
      {
        int selectedIndex = tblDataDataPaket.getSelectedRow();
        // int idPaket = Integer.parseInt(tblDataDataPaket.getValueAt(selectedIndex, 0).toString());
        int idPaket = Integer.valueOf(tblDataDataPaket.getValueAt(selectedIndex, 0).toString());

        String deskripsiPaket = Model.getDetailPaket(idPaket)[2].toString();
        valueDeskripsiPaketDataPaket.setText(deskripsiPaket);
      }
    } );

    spDataDataPaket = new cScrollPane(tblDataDataPaket, 25, 145, 555, 250);

    txtCariDataPaket.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed( java.awt.event.ActionEvent ae )
      {
        Filter.keyword = txtCariDataPaket.getText();

        tblDataDataPaket.setModel( Filter.search() );
        tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
      }
    } );

    ButtonGroup groupButtonRadio = new ButtonGroup();
    groupButtonRadio.add(rdSemuaDataPaket);
    groupButtonRadio.add(rdAktifDataPaket);
    groupButtonRadio.add(rdTidakAktifDataPaket);

    rdSemuaDataPaket.setSelected(true);

    rdSemuaDataPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked( java.awt.event.MouseEvent me )
      {
        Filter.filter = "semua";
        tblDataDataPaket.setModel( Filter.search() );
        tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
        valueDeskripsiPaketDataPaket.setText(null);
      }
    } );

    rdAktifDataPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked( java.awt.event.MouseEvent me )
      {
        Filter.filter = "aktif";
        tblDataDataPaket.setModel( Filter.search() );
        tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
        valueDeskripsiPaketDataPaket.setText(null);
      }
    } );

    rdTidakAktifDataPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked( java.awt.event.MouseEvent me )
      {
        Filter.filter = "tidak aktif";
        tblDataDataPaket.setModel( Filter.search() );
        tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
        valueDeskripsiPaketDataPaket.setText(null);
      }
    } );

    btnTambahDataPaket.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsTambahPaket();
      }
    });

    btnUbahDataPaket.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsUbahPaket();
      }
    });

    content.add(labelDataPaket);
    content.add(labelCariDataPaket);
    content.add(txtCariDataPaket);
    content.add(btnTambahDataPaket);
    content.add(rdSemuaDataPaket);
    content.add(rdAktifDataPaket);
    content.add(rdTidakAktifDataPaket);
    content.add(spDataDataPaket);
    content.add(btnUbahDataPaket);
    content.add(labelDeskripsiPaketDataPaket);
    content.add(valueDeskripsiPaketDataPaket);
    setVisible(true);
  }

  private void initsTambahPaket()
  {
    // setVisible(false);
    idSelected = null;
    resetSidebar();
    menuDataPaket.setBackground(cColor.BLUE);
    menuDataPaket.setForeground(cColor.WHITE);
    refreshContent();
    menuDataPaket.setSidebarAktif();
    menuTitle.setText("Tambah Data Paket");
    btnBatalTambahDataPaket.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsDataPaket();
      }
    });
    content.add(labelTambahDataPaket);
    content.add(labelNamaPaketTambahDataPaket);
    content.add(txtNamaPaketTambahDataPaket);
    content.add(errorNamaPaketTambahDataPaket);
    content.add(labelKuotaPaketTambahDataPaket);
    content.add(txtKuotaPaketTambahDataPaket);
    content.add(errorKuotaPaketTambahDataPaket);
    content.add(labelHargaPaketTambahDataPaket);
    content.add(txtHargaPaketTambahDataPaket);
    content.add(errorHargaPaketTambahDataPaket);
    content.add(chAktifTambahDataPaket);
    content.add(btnTambahPaketTambahDataPaket);
    content.add(btnBatalTambahDataPaket);
    content.add(labelDeskripsiPaketTambahDataPaket);
    content.add(spTxtDeskripsiPaketTambahDataPaket);
    content.add(errorDeskripsiPaketTambahDataPaket);
    setVisible(true);
  }
  private void initsUbahPaket()
  {
    // setVisible(false);
    idSelected = null;
    resetSidebar();
    menuDataPaket.setBackground(cColor.BLUE);
    menuDataPaket.setForeground(cColor.WHITE);
    refreshContent();
    menuDataPaket.setSidebarAktif();
    menuTitle.setText("Ubah Data Paket");
    btnBatalUbahDataPaket.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsDataPaket();
      }
    });
    content.add(labelUbahDataPaket);
    content.add(labelNamaPaketUbahDataPaket);
    content.add(txtNamaPaketUbahDataPaket);
    content.add(errorNamaPaketUbahDataPaket);
    content.add(labelKuotaPaketUbahDataPaket);
    content.add(txtKuotaPaketUbahDataPaket);
    content.add(errorKuotaPaketUbahDataPaket);
    content.add(labelHargaPaketUbahDataPaket);
    content.add(txtHargaPaketUbahDataPaket);
    content.add(errorHargaPaketUbahDataPaket);
    content.add(chAktifUbahDataPaket);
    content.add(btnUbahPaketUbahDataPaket);
    content.add(btnBatalUbahDataPaket);
    content.add(labelDeskripsiPaketUbahDataPaket);
    content.add(spTxtDeskripsiPaketUbahDataPaket);
    content.add(errorDeskripsiPaketUbahDataPaket);
    setVisible(true);
  }

  private void initsRequestSaldo()
  {
    idSelected = null;
    resetSidebar();
    menuRequestSaldo.setBackground(cColor.BLUE);
    menuRequestSaldo.setForeground(cColor.WHITE);
    refreshContent();
    menuRequestSaldo.setSidebarAktif();
    menuTitle.setText("Request Saldo Pending");
    
    tblDataRequestSaldo = new cTable(Model.getPendingTransaksiSaldo());
    tblDataRequestSaldo.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataRequestSaldo.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataRequestSaldo.getColumnModel().getColumn(0).setWidth(0);

    spDataRequestSaldo = new cScrollPane(tblDataRequestSaldo, 25, 120, 555, 310);

    txtCariRequestSaldo.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed( java.awt.event.ActionEvent ae )
      {
        String keyword = txtCariRequestSaldo.getText();

        tblDataRequestSaldo.setModel(Model.getSearchPendingTransaksiSaldo(keyword));

        tblDataRequestSaldo.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataRequestSaldo.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataRequestSaldo.getColumnModel().getColumn(0).setWidth(0);
      }
    } );

    btnLihatBerhasilRequestSaldo.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsRequestSaldoDone();
      }
    });

    content.add(labelRequestSaldo);
    content.add(labelCariRequestSaldo);
    content.add(txtCariRequestSaldo);
    content.add(btnLihatBerhasilRequestSaldo);
    content.add(spDataRequestSaldo);
    content.add(btnApproveRequestSaldo);
    setVisible(true);
  }

  private void initsRequestSaldoDone()
  {
    // setVisible(false);
    idSelected = null;
    resetSidebar();
    menuRequestSaldo.setBackground(cColor.BLUE);
    menuRequestSaldo.setForeground(cColor.WHITE);
    refreshContent();
    menuRequestSaldo.setSidebarAktif();
    menuTitle.setText("Permintaan Saldo Berhasil");
    
    tblDataRequestSaldoDone = new cTable(Model.getDoneTransaksiSaldo());
    tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataRequestSaldoDone.getColumnModel().getColumn(0).setWidth(0);

    spDataRequestSaldoDone = new cScrollPane(tblDataRequestSaldoDone, 25, 120, 555, 310);

    txtCariRequestSaldoDone.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed( java.awt.event.ActionEvent ae )
      {
        String keyword = txtCariRequestSaldoDone.getText();
        tblDataRequestSaldoDone.setModel(Model.getSearchDoneTransaksiSaldo(keyword));
        tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataRequestSaldoDone.getColumnModel().getColumn(0).setWidth(0);
      }
    } );

    btnLihatPendingRequestSaldoDone.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsRequestSaldo();
      }
    });

    content.add(labelRequestSaldoDone);
    content.add(labelCariRequestSaldoDone);
    content.add(txtCariRequestSaldoDone);
    content.add(btnLihatPendingRequestSaldoDone);
    content.add(spDataRequestSaldoDone);
    setVisible(true);
  }

  private void initsCalonMitra()
  {
    idSelected = null;
    resetSidebar();
    menuCalonMitra.setBackground(cColor.BLUE);
    menuCalonMitra.setForeground(cColor.WHITE);
    refreshContent();
    menuCalonMitra.setSidebarAktif();
    menuTitle.setText("Calon Mitra");
    
    tblDataCalonMitra = new cTable(Model.getMitraNonVerifikasi());
    tblDataCalonMitra.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataCalonMitra.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataCalonMitra.getColumnModel().getColumn(0).setWidth(0);

    spDataCalonMitra = new cScrollPane(tblDataCalonMitra, 25, 120, 555, 310);

    txtCariCalonMitra.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed( java.awt.event.ActionEvent ae )
      {
        String keyword = txtCariCalonMitra.getText();

        tblDataCalonMitra.setModel(Model.getSearchMitraNonVerifikasi(keyword));
        tblDataCalonMitra.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataCalonMitra.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataCalonMitra.getColumnModel().getColumn(0).setWidth(0);
      }
    } );

    content.add(labelCalonMitra);
    content.add(labelCariCalonMitra);
    content.add(txtCariCalonMitra);
    content.add(spDataCalonMitra);
    content.add(btnApproveCalonMitra);
    setVisible(true);
  }

  private void initsTransaksiPulsa()
  {
    idSelected = null;
    resetSidebar();
    menuTransaksiPulsa.setBackground(cColor.BLUE);
    menuTransaksiPulsa.setForeground(cColor.WHITE);
    refreshContent();
    menuTransaksiPulsa.setSidebarAktif();
    menuTitle.setText("Transaksi Pulsa");
    
    tblDataTransaksiPulsa = new cTable(Model.getAllTransaksiPulsa());
    tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataTransaksiPulsa.getColumnModel().getColumn(0).setWidth(0);

    spDataTransaksiPulsa = new cScrollPane(tblDataTransaksiPulsa, 25, 120, 930, 310);

    txtCariTransaksiPulsa.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed( java.awt.event.ActionEvent ae )
      {
        String keyword = txtCariTransaksiPulsa.getText();
        tblDataTransaksiPulsa.setModel(Model.getSearchTransaksiPulsa(keyword));
        tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataTransaksiPulsa.getColumnModel().getColumn(0).setWidth(0);
      }
    } );

    content.add(labelTransaksiPulsa);
    content.add(labelCariTransaksiPulsa);
    content.add(txtCariTransaksiPulsa);
    content.add(spDataTransaksiPulsa);
    setVisible(true);
  }

  private void initsTransaksiPaket()
  {
    idSelected = null;
    resetSidebar();
    menuTransaksiPaket.setBackground(cColor.BLUE);
    menuTransaksiPaket.setForeground(cColor.WHITE);
    refreshContent();
    menuTransaksiPaket.setSidebarAktif();
    menuTitle.setText("Transaksi Paket");
    
    tblDataTransaksiPaket = new cTable(Model.getAllTransaksiPaket());
    tblDataTransaksiPaket.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataTransaksiPaket.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataTransaksiPaket.getColumnModel().getColumn(0).setWidth(0);

    spDataTransaksiPaket = new cScrollPane(tblDataTransaksiPaket, 25, 120, 930, 310);

    txtCariTransaksiPaket.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed( java.awt.event.ActionEvent ae )
      {
        String keyword = txtCariTransaksiPaket.getText();
        tblDataTransaksiPaket.setModel(Model.getSearchTransaksiPaket(keyword));
        tblDataTransaksiPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataTransaksiPaket.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataTransaksiPaket.getColumnModel().getColumn(0).setWidth(0);
      }
    } );

    content.add(labelTransaksiPaket);
    content.add(labelCariTransaksiPaket);
    content.add(txtCariTransaksiPaket);
    content.add(spDataTransaksiPaket);
    setVisible(true);
  }

  private void initsLogout()
  {
    Object[] options = { "YA", "BATAL" };
    int confirm = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout",
    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
    null, options, options[0]);
    if(confirm == 0 ){
      this.statusLogin = false;
      this.idSelected = null;
      com.program.Controller.showLoginAdmin();
    }
  }


  
}
