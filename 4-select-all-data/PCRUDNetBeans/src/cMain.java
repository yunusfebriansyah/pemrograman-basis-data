import java.util.Scanner;
import com.view.cView;

public class cMain {
    public static void main(String[] args) throws Exception {
        
        while(true){

            System.out.print("\n=== MENU ===\n"
            + "1. Lihat Semua Data Barang\n"
            + "2. Detail Data Barang\n"
            + "3. Cari Data Barang\n"
            + "4. Tambah Data Barang\n"
            + "5. Update Data Barang\n"
            + "0. Exit\n"
            + "Pilih[1/2/3/4/5/0] : ");

            Scanner input = new Scanner(System.in);
            String pilihan = input.next();

            if( pilihan.equalsIgnoreCase("0") ){
                System.out.println("Terimakasih!!");
                break;
            }

            switch (pilihan) {
                case "1" :
                    cView.getAllData();
                    break;
                case "2" :
                    System.out.println("Detail Data Barang");
                    break;
                case "3" :
                    System.out.println("Cari Data Barang");
                    break;
                case "4" :
                    System.out.println("Tambah Data Barang");
                    break;
                case "5" :
                    System.out.println("Update Data Barang");
                    break;
                default:
                    System.out.println("Pilihan salah!!");
                    break;
            }


        }

    }
}
