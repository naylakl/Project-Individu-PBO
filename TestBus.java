import java.util.Scanner;

public class TestBus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bus bus = new Bus();

        while (true) {
            System.out.println("\n=== MENU BUS KOETARADJA ===");
            System.out.println("1. Naikkan Penumpang");
            System.out.println("2. Turunkan Penumpang");
            System.out.println("3. Lihat Penumpang");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");

            int menu = sc.nextInt();
 
            if (menu == 1) {

                System.out.print("ID: ");
                int id = sc.nextInt();
                
                // ==============================
                //  CEK ID DUPLIKAT SEBELUM MASUK
                // ==============================
                if (bus.idSudahAda(id)) {
                    System.out.println("✗ ID sudah dipakai penumpang lain. Harap gunakan ID berbeda.\n");
                    continue;
                }

                System.out.print("Umur: ");
                int umur = sc.nextInt();

                System.out.print("Hamil? (y/n): ");
                boolean hamil = sc.next().equalsIgnoreCase("y");

                Penumpang p;

                // Tentukan jenis penumpang
                if (hamil || umur < 10 || umur > 60) {
                    p = new PenumpangPrioritas(id, umur, hamil);
                } else {
                    p = new PenumpangBiasa(id, umur, hamil);
                }

                try {
                    bus.naik(p);
                    System.out.println("✓ Penumpang berhasil naik!");
                } catch (Exception e) {
                    System.out.println("✗ " + e.getMessage());
                }
            }

            else if (menu == 2) {
                System.out.print("ID penumpang yang turun: ");
                int turunID = sc.nextInt();

                if (bus.turun(turunID))
                    System.out.println("✓ Penumpang berhasil turun.");
                else
                    System.out.println("✗ Penumpang dengan ID tersebut tidak ditemukan.");
            }

            else if (menu == 3) {
                System.out.println(bus);
            }

            else if (menu == 4) {
                System.out.println("Program selesai.");
                break;
            }

            else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        sc.close();
    }
}
