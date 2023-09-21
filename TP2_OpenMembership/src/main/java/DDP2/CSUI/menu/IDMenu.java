package DDP2.CSUI.menu;

import java.util.Scanner;
import DDP2.CSUI.utils.IDGenerator;

public class IDMenu {
    public static Scanner scanner = new Scanner(System.in);

    private static String phoneNumber = "";

    private static boolean isPhoneNumValid(String phoneNumber){
        if (phoneNumber.isEmpty()) return false;
        for (int i = 0; i < phoneNumber.length(); i++){
            if (phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9') return false;
        }
        return true;
    }

    public IDMenu() {
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        while (!isPhoneNumValid(phoneNumber)) {
            System.out.print("Nomor telepon: ");
            IDMenu.phoneNumber = scanner.nextLine();

            if (!isPhoneNumValid(phoneNumber)) System.out.println("Nomor telepon tidak valid!");
        }

        IDGenerator idGenerator = new IDGenerator(name, phoneNumber);
        System.out.println("ID anda: " + IDGenerator.generateID());
    }
}
