import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;


public class App {
  public static void main(String[] args) throws Exception {

    // frame
    JFrame mainWindow = new JFrame();
    mainWindow.setSize(1280, 720);
    mainWindow.setTitle("Frame Utama");
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setLayout(null);
    mainWindow.setLocationRelativeTo(null);

    // panel
    JPanel sidebar = new JPanel();
    sidebar.setSize(200, 720);
    sidebar.setBackground( new Color(23, 35, 51) );
    sidebar.setLayout(null);
    
    JPanel header = new JPanel();
    header.setBounds(200, 0, 1080, 70);
    header.setBackground(new Color(71, 120, 197));
    header.setLayout(null);

    JPanel content = new JPanel();
    content.setBounds(200, 70, 1080, 650);
    content.setBackground(Color.WHITE);
    content.setLayout(null);

    // ini component
    JLabel title = new JLabel("Data User");
    title.setBounds(20, 20, 300, 30);
    title.setFont(new Font("Poppins Bold", Font.PLAIN, 30));

    String[] dataUserHeader = {"Nama", "Username", "Umur"};
    String[][] dataUser = {
      {"Yunus Febriansyah", "yunusf", "20"},
      {"Ridwan", "ridwan", "22"}
    };

    DefaultTableModel dmUser = new DefaultTableModel(dataUser, dataUserHeader);

    JTable tblUser = new JTable(dmUser){
      @Override
      public boolean isCellEditable(int row, int column){
        return false;
      }
    };
    tblUser.setFont( new Font("Poppins", Font.PLAIN, 16) );
    tblUser.getTableHeader().setFont( new Font("Poppins Medium", Font.PLAIN, 20) );
    tblUser.getTableHeader().setBackground( new Color(71, 120, 197) );
    tblUser.getTableHeader().setForeground( Color.WHITE );
    tblUser.setRowHeight(25);
    tblUser.getTableHeader().setReorderingAllowed(false);
    tblUser.setShowVerticalLines(false);

    dmUser.addRow( new String[]{"Siti Suliah", "siti", "20"} );

    JScrollPane scrollTblUser = new JScrollPane(tblUser);
    scrollTblUser.setBounds(20, (int)title.getLocation().getY()+45, 600, 300);
    scrollTblUser.getViewport().setBackground(Color.WHITE);


    
    // finally
    content.add(title);
    content.add(scrollTblUser);
    mainWindow.add(sidebar);
    mainWindow.add(header);
    mainWindow.add(content);
    mainWindow.setVisible(true);

  }
}
