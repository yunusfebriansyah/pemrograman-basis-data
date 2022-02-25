package com.views;
import com.templates.cDashboardFrame;
import com.partials.*;
import com.program.Model;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class dashboardCustomerView extends cDashboardFrame{

  private Integer idCustomer = null;

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
  private cBigFont valueSisaPulsaBeranda = new cBigFont("0", 25, 60);
  private cLabelInfo labelSisaKuotaBeranda = new cLabelInfo("Sisa Kuota Anda", 25, 150);
  private cBigFont valueSisaKuotaBeranda = new cBigFont("0GB", 25, 190);

  // Beli Pulsa components
  private cLabelInfo labelSisaPulsaBeliPulsa = new cLabelInfo("Sisa Pulsa Anda", 25, 20);
  private cBigFont valueSisaPulsaBeliPulsa = new cBigFont("0", 25, 60);
  private cLabelInfo labelPilihanBeliPulsa = new cLabelInfo("Pilihan Beli Pulsa", 25, 150);
  private cRadioButton rd5k = new cRadioButton("5K", "5000", 25, 190, 72);
  private cRadioButton rd10k = new cRadioButton("10K", "10000", 102, 190, 72);
  private cRadioButton rd25k = new cRadioButton("25K", "25000", 179, 190, 72);
  private cRadioButton rd50k = new cRadioButton("50K", "50000", 256, 190, 72);
  private cRadioButton rd100k = new cRadioButton("100K", "100000", 333, 190, 72);
  private cBlueButton btnBeliPulsa = new cBlueButton("Beli Pulsa", 25, 220, 155);
  private ButtonGroup rdPilihaPulsa = new ButtonGroup();

  // beli paket components
  private cLabelInfo labelSisaKuotaBeliPaket = new cLabelInfo("Sisa Kuota Anda", 25, 20);
  private cBigFont valueSisaKuotaBeliPaket = new cBigFont("0GB", 25, 60);
  private cLabelInfo labelPilihanBeliPaket = new cLabelInfo("Pilihan Beli Paket Kuota", 25, 150);
  private cTable dataPaket;
  private cScrollPane spDataPaket;
  private cBlueButton btnBeliPaket = new cBlueButton("Beli Paket", 25, 390, 155);
  private cLabelInfo labelDeskripsiPaket = new cLabelInfo("DeskripsiPaket", 473, 190);
  private cTextarea valueDeskripsiPaket = new cTextarea("", 473, 231, false);

  // history beli pulsa components
  private cLabelInfo labelHistoryPulsa = new cLabelInfo("Semua Pembelian Pulsa Saya", 25, 20);
  private cTable tblDataHistoryPulsa;
  private cScrollPane spDataHistoryPulsa;

  // history beli Paket components
  private cLabelInfo labelHistoryPaket = new cLabelInfo("Semua Pembelian Paket Saya", 25, 20);
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
  private cErrorLabel errorEmail = new cErrorLabel("email tidak valid!", 25, 262, 360, false);
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
      roleText.setText("Customer | " + Model.getDetailCustomer(idCustomer)[1].toString());
      content.removeAll();
    } catch(Exception e) {
    }
  }

  public dashboardCustomerView( Integer id )
  {
    super("Dashboard Customer");
    idCustomer = id;
    
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
    resetSidebar();
    menuBeranda.setBackground(cColor.BLUE);
    menuBeranda.setForeground(cColor.WHITE);
    refreshContent();
    menuBeranda.setSidebarAktif();
    menuTitle.setText("Beranda");

    valueSisaPulsaBeranda.setText(Model.getDetailPulsaKuotaCustomer(idCustomer)[0].toString());
    valueSisaKuotaBeranda.setText(Model.getDetailPulsaKuotaCustomer(idCustomer)[1].toString() + "GB");

    content.add(labelSisaPulsaBeranda);
    content.add(valueSisaPulsaBeranda);
    content.add(labelSisaKuotaBeranda);
    content.add(valueSisaKuotaBeranda);
    setVisible(true);
  }

  private void initsBeliPulsa()
  {
    resetSidebar();
    menuBeliPulsa.setBackground(cColor.BLUE);
    menuBeliPulsa.setForeground(cColor.WHITE);
    refreshContent();
    menuBeliPulsa.setSidebarAktif();
    menuTitle.setText("Beli Pulsa");

    valueSisaPulsaBeliPulsa.setText(Model.getDetailPulsaKuotaCustomer(idCustomer)[0].toString());

    rd5k.setSelected(true);

    btnBeliPulsa.addActionListener(new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        int jumlahPulsa = Integer.valueOf(rdPilihaPulsa.getSelection().getActionCommand());
        if( Model.tambahDataTransaksiPulsa( idCustomer, jumlahPulsa ) ){
          JOptionPane.showMessageDialog(dashboardCustomerView.this, "Pembelian Pulsa masih pending. Silahkan tunggu.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
          initsHistoryBeliPulsa();
        }else{
          JOptionPane.showMessageDialog(dashboardCustomerView.this, "Pembelian Pulsa gagal!", "Gagal", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

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
    resetSidebar();
    menuBeliPaket.setBackground(cColor.BLUE);
    menuBeliPaket.setForeground(cColor.WHITE);
    refreshContent();
    menuBeliPaket.setSidebarAktif();
    menuTitle.setText("Beli Paket");

    valueSisaKuotaBeliPaket.setText(Model.getDetailPulsaKuotaCustomer(idCustomer)[1].toString() + "GB");

    
    dataPaket = new cTable(Model.getPaketAktif());
    dataPaket.getColumnModel().getColumn(0).setMinWidth(0);
    dataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
    dataPaket.getColumnModel().getColumn(0).setWidth(0);

    dataPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mousePressed( java.awt.event.MouseEvent me )
      {
        int selectedIndex = dataPaket.getSelectedRow();
        // int idPaket = Integer.parseInt(tblDataDataPaket.getValueAt(selectedIndex, 0).toString());
        int idPaket = Integer.valueOf(dataPaket.getValueAt(selectedIndex, 0).toString());

        String deskripsiPaket = Model.getDetailPaket(idPaket)[2].toString();
        valueDeskripsiPaket.setText(deskripsiPaket);
      }
    } );


    spDataPaket = new cScrollPane(dataPaket, 25, 190, 428, 190);

    // memberikan event ke button beli paket
    btnBeliPaket.addActionListener( new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae )
      {
        
        int selectedIndex = dataPaket.getSelectedRow();

        // pengecekan apakah ada yang dipilih atau tidak
        if( selectedIndex == -1 ){
          // kalo gak ada yang dipilih
          JOptionPane.showMessageDialog(dashboardCustomerView.this, "Pilih paket terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }else{
          // kalo ada yang dipilih
          int idPaket = Integer.valueOf( dataPaket.getValueAt(selectedIndex, 0).toString() );
          
          if( Model.beliPaket( idCustomer, idPaket ) ){
            // berhasil
            JOptionPane.showMessageDialog(dashboardCustomerView.this, "Beli paket berhasil.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            initsHistoryBeliPaket();
          }else{
            // kalo gagalnya
            JOptionPane.showMessageDialog(dashboardCustomerView.this, "Beli paket gagal!", "Gagal", JOptionPane.ERROR_MESSAGE);
          }

        }

        
      }
    } );

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
    resetSidebar();
    menuHistoryBeliPulsa.setBackground(cColor.BLUE);
    menuHistoryBeliPulsa.setForeground(cColor.WHITE);
    refreshContent();
    menuHistoryBeliPulsa.setSidebarAktif();
    menuTitle.setText("Transaksi Pulsa Saya");
    
    tblDataHistoryPulsa = new cTable(Model.getAllTransaksiPulsaByCustomer(idCustomer));


    spDataHistoryPulsa = new cScrollPane(tblDataHistoryPulsa, 25, 65, 740, 310);
    content.add(labelHistoryPulsa);
    content.add(spDataHistoryPulsa);
    setVisible(true);
  }

  private void initsHistoryBeliPaket()
  {
    resetSidebar();
    menuHistoryBeliPaket.setBackground(cColor.BLUE);
    menuHistoryBeliPaket.setForeground(cColor.WHITE);
    refreshContent();
    menuHistoryBeliPaket.setSidebarAktif();
    menuTitle.setText("Transaksi Paket Saya");
    
    tblDataHistoryPaket = new cTable(Model.getAllTransaksiPaketByCustomer(idCustomer));

    spDataHistoryPaket = new cScrollPane(tblDataHistoryPaket, 25, 65, 924, 310);
    content.add(labelHistoryPaket);
    content.add(spDataHistoryPaket);
    setVisible(true);
  }

  private void initsAkun()
  {
    resetSidebar();
    menuAkun.setBackground(cColor.BLUE);
    menuAkun.setForeground(cColor.WHITE);
    refreshContent();
    menuAkun.setSidebarAktif();
    menuTitle.setText("Akun Saya");

    Object[] dataCustomer = Model.getDetailCustomer(idCustomer);

    txtNama.setText(dataCustomer[1].toString());
    txtEmail.setText(dataCustomer[3].toString());

    valueNoHp = new cFormLabel(dataCustomer[2].toString(), 25, 174, 360, false);


    valueNoHp.setFont(com.partials.cFonts.RADIO_BUTTON_FONT);
    valueNoHp.setForeground(com.partials.cColor.RED);


    btnUbahAkun.addActionListener(new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae){
        
        if( txtNama.getText().trim().isEmpty() || ( !txtEmail.getText().trim().isEmpty() && !dataCustomer[3].toString().equalsIgnoreCase(txtEmail.getText()) && Model.getCountCustomerByEmail(txtEmail.getText()) == 1 ) ){
          // kalo ada yang tidak memenuhi syarat

          dashboardCustomerView.this.setVisible(false);
          
          if( txtNama.getText().trim().isEmpty() ) content.add(errorNama); else content.remove(errorNama);
          
          if( !txtEmail.getText().trim().isEmpty() && !dataCustomer[3].toString().equalsIgnoreCase(txtEmail.getText()) && Model.getCountCustomerByEmail(txtEmail.getText()) == 1 ) content.add(errorEmail); else content.remove(errorEmail);
          
          dashboardCustomerView.this.setVisible(true);

        }else{
          // kalau validasinya lolos
          String namaCustomer = txtNama.getText();
          String emailCustomer = txtEmail.getText();
          if( Model.ubahProfilCustomer(idCustomer, namaCustomer, emailCustomer) ){
            // kalau berhasil diubah
            JOptionPane.showMessageDialog(dashboardCustomerView.this, "Ubah Profil berhasil", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            initsAkun();
          }else{
            // kalau gagal ubah profil
            JOptionPane.showMessageDialog(dashboardCustomerView.this, "Ubah profil gagal!", "Gagal", JOptionPane.WARNING_MESSAGE);
          }

        }

      }
    });


    content.add(labelAkun);
    content.add(labelNama);
    content.add(txtNama);
    content.add(labelNoHp);
    content.add(valueNoHp);
    content.add(labelEmail);
    content.add(txtEmail);
    content.add(btnUbahAkun);
    setVisible(true);
  }
  
}
