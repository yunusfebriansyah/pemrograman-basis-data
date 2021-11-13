package com.program;
import com.views.*;

public class Controller {

  private static startView frameLoginAndRegister = new startView();

  public static void showLoginCustomer()
  {
    frameLoginAndRegister.setVisible(false);
    frameLoginAndRegister.initsLoginCustomer();
    frameLoginAndRegister.setVisible(true);
  }

  public static void showDaftarCustomer()
  {
    frameLoginAndRegister.setVisible(false);
    frameLoginAndRegister.initsDaftarCustomer();
    frameLoginAndRegister.setVisible(true);
  }

  public static void showLoginMitra()
  {
    frameLoginAndRegister.setVisible(false);
    frameLoginAndRegister.initsLoginMitra();
    frameLoginAndRegister.setVisible(true);
  }

  public static void showDaftarMitra()
  {
    frameLoginAndRegister.setVisible(false);
    frameLoginAndRegister.initsDaftarMitra();
    frameLoginAndRegister.setVisible(true);
  }

  public static void showLoginAdmin()
  {
    frameLoginAndRegister.setVisible(false);
    frameLoginAndRegister.initsLoginAdmin();
    frameLoginAndRegister.setVisible(true);
  }

  public static void showDashboardCustomer(Integer id)
  {
    dashboardCustomerView dashboardCustomer = new dashboardCustomerView(id);
    dashboardCustomer.setVisible(true);
  }

  public static void showDashboardMitra(Integer id)
  {
    dashboardMitraView dashboardMitra = new dashboardMitraView(id);
    dashboardMitra.setVisible(true);
  }

  public static void showDashboardAdmin(boolean statusLogin)
  {
    dashboardAdminView dashboardAdmin = new dashboardAdminView(statusLogin);
    dashboardAdmin.setVisible(true);
  }
  
}
