package com.program;
import com.views.startView;

public class App {

  public static void main(String[] args) {

    // Controller.showDashboardAdmin(true);

    // Controller.showDashboardMitra(2);
    
    // Controller.showDashboardCustomer(3);

    startView auth = new startView();
    auth.initsLoginCustomer();
    auth.setVisible(true);

  }

}

