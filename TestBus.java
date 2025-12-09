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
