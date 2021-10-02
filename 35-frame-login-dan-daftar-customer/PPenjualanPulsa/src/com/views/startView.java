package com.views;
import com.templates.cStartFrame;
import com.partials.*;

public class startView extends cStartFrame {

  // components of Login Customer
  private cFormLabel labelNoHpLoginCustomer         = new cFormLabel("Nomor Hp", 0, 84, 450, true);
  private cTextField txtNoHpLoginCustomer           = new cTextField(65, 114, 320, true);
  private cErrorLabel errorNoHpLoginCustomer        = new cErrorLabel("no. hp kosong/salah!!", 0, 149, 450, true);
  private cFormLabel labelPasswordLoginCustomer     = new cFormLabel("Password", 0, 183, 450, true);
  private cPasswordField txtPasswordLoginCustomer   = new cPasswordField(65, 213, 320, true);
  private cErrorLabel errorPasswordLoginCustomer    = new cErrorLabel("password kosong/salah!!", 0, 248, 450, true);
  private cBlueButton btnLoginLoginCustomer         = new cBlueButton("Login", 65, 282, 320);
  private cLinkStart toLoginMitraLoginCustomer      = new cLinkStart("sudah punya akun mitra?", 322);
  private cLinkStart toDaftarMitraLoginCustomer     = new cLinkStart("daftar sebagai mitra", 342);
  private cLinkStart toDaftarCustomerLoginCustomer  = new cLinkStart("belum punya akun customer?", 362);
  private cLinkStart toLoginAdminLoginCustomer      = new cLinkStart("login admin", 382);

  // components of Register Customer
  private cFormLabel labelNamaDaftarCustomer        = new cFormLabel("Nama", 0, 84, 450, true);
  private cTextField txtNamaDaftarCustomer          = new cTextField(65, 114, 320, true);
  private cErrorLabel errorNamaDaftarCustomer       = new cErrorLabel("nama kosong/salah!!", 0, 149, 450, true);
  private cFormLabel labelNoHpDaftarCustomer        = new cFormLabel("Nomor Hp", 0, 183, 450, true);
  private cTextField txtNoHpDaftarCustomer          = new cTextField(65, 213, 320, true);
  private cErrorLabel errorNoHpDaftarCustomer       = new cErrorLabel("no. hp kosong/salah!!", 0, 248, 450, true);
  private cFormLabel labelPasswordDaftarCustomer    = new cFormLabel("Password", 0, 282, 450, true);
  private cPasswordField txtPasswordDaftarCustomer  = new cPasswordField(65, 312, 320, true);
  private cErrorLabel errorPasswordDaftarCustomer   = new cErrorLabel("password kosong/salah!!", 0, 347, 450, true);
  private cBlueButton btnDaftarDaftarCustomer       = new cBlueButton("Daftar", 65, 381, 320);
  private cLinkStart toLoginMitraDaftarCustomer     = new cLinkStart("sudah punya akun mitra?", 421);
  private cLinkStart toDaftarMitraDaftarCustomer    = new cLinkStart("daftar sebagai mitra", 441);
  private cLinkStart toLoginCustomerDaftarCustomer  = new cLinkStart("sudah punya akun customer?", 461);
  private cLinkStart toLoginAdminDaftarCustomer     = new cLinkStart("login admin", 481);


  public startView()
  {
    super();
  }

  public void initsLoginCustomer()
  {
    this.setTitle("Login Customer");
    cardStart.removeAll();
    titleStart.setText("Login Customer");
    cardStart.add(titleStart);

    cardStart.add(labelNoHpLoginCustomer);
    cardStart.add(txtNoHpLoginCustomer);
    cardStart.add(labelPasswordLoginCustomer);
    cardStart.add(txtPasswordLoginCustomer);
    cardStart.add(btnLoginLoginCustomer);
    cardStart.add(toLoginMitraLoginCustomer);
    cardStart.add(toDaftarMitraLoginCustomer);
    cardStart.add(toDaftarCustomerLoginCustomer);
    cardStart.add(toLoginAdminLoginCustomer);

  }

  public void initsDaftarCustomer()
  {
    this.setTitle("Daftar Customer");
    cardStart.removeAll();
    titleStart.setText("Daftar Customer");
    cardStart.add(titleStart);

    cardStart.add(labelNamaDaftarCustomer);
    cardStart.add(txtNamaDaftarCustomer);
    cardStart.add(labelNoHpDaftarCustomer);
    cardStart.add(txtNoHpDaftarCustomer);
    cardStart.add(labelPasswordDaftarCustomer);
    cardStart.add(txtPasswordDaftarCustomer);
    cardStart.add(btnDaftarDaftarCustomer);
    cardStart.add(toLoginMitraDaftarCustomer);
    cardStart.add(toDaftarMitraDaftarCustomer);
    cardStart.add(toLoginCustomerDaftarCustomer);
    cardStart.add(toLoginAdminDaftarCustomer);


  }

  
}
