package DDP2.CSUI.menu;

import DDP2.CSUI.utils.TimeMechanic;

import java.util.Scanner;

public class MainMenu {
    public static Scanner scanner = new Scanner(System.in);
    public static int MAX_INT = 2147483647;
    public MainMenu() {
        int choose = MAX_INT;
        while (choose != 0) {
            System.out.println("Selamat datang di CuciCuci!");
            System.out.printf("Sekarang tanggal %s\n", TimeMechanic.getThisDate());
            System.out.println("==============MENU==============");
            System.out.println("[1]\tGenerate Member");
            System.out.println("[2]\tGenerate Nota");
            System.out.println("[3]\tList Nota");
            System.out.println("[4]\tList Member");
            System.out.println("[5]\tAmbil Cucian");
            System.out.println("[6]\tNext Day");
            System.out.println("[0]\tExit");
            System.out.print("Pilihan anda: ");

            try {
                choose = scanner.nextInt();
                scanner.nextLine();
            }
            catch (Exception e) {
                System.out.println("Harap masukkan angka!");
                System.exit(0);
            }

            System.out.println("================================");

            switch (choose) {
                case 1:
                    new IDMenu();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan NotaGenerator!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Perintah tidak diketahui, silahkan coba lagi!");
                    break;
            }
        }
    }
}
