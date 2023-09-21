package DDP2.CSUI.menu;

import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import DDP2.CSUI.utils.NotaGenerator;

public class NotaMenu {
    protected static Scanner scanner = new Scanner(System.in);

    protected static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    protected static boolean isDateValid(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            formatter.parse(date);
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    protected static List<String> LaundryPackage = List.of("Express", "Fast", "Reguler");

    protected static String getName() {
        String name;
        do {
            System.out.println("Masukkan nama Anda: ");
            name = scanner.nextLine();
        } while (name.isEmpty());

        return name;
    }

    protected static String getPhoneNumber() {
        String phoneNumber;
        do {
            System.out.println("Masukkan nomor telepon Anda: ");
            phoneNumber = scanner.nextLine();

            if (phoneNumber.isEmpty()) {
                System.out.println("Nomor telepon tidak boleh kosong!");
                continue;
            } else if (!isNumeric(phoneNumber)) {
                System.out.println("Nomor telepon harus berupa angka!");
                continue;
            }
        } while (phoneNumber.isEmpty() || !isNumeric(phoneNumber));

        return phoneNumber;
    }

    protected String getDate() {
        String date;
        do{
            System.out.println("Masukkan tanggal terima: ");
            date = scanner.nextLine();

            if (date.isEmpty()) {
                System.out.println("Tanggal tidak boleh kosong!");
                continue;
            } else if (!isDateValid(date)) {
                System.out.println("Tanggal tidak valid!");
                continue;
            }
        } while (date.isEmpty() || !isDateValid(date));

        return date;
    }

    protected static String getLaundryPackage() {
        String laundryPackage;
        do {
            System.out.println("Masukkan paket laundry: ");
            laundryPackage = scanner.nextLine();

            if (laundryPackage.isEmpty()) {
                System.out.println("Paket laundry tidak boleh kosong!");
                continue;
            } else if (laundryPackage.equals("?")) {
                System.out.println("+--------------Paket--------------+");
                System.out.println("| Express | 1 hari | Rp. 12.000 / kg |");
                System.out.println("| Fast    | 2 hari | Rp. 10.000 / kg |");
                System.out.println("| Reguler | 3 hari | Rp.  7.000 / kg |");
                System.out.println("+----------------------------------+");
                continue;
            } else if (!LaundryPackage.contains(laundryPackage)) {
                System.out.printf("Paket %s tidak diketahui!\n", laundryPackage);
                System.out.println("[ketik ? untuk melihat daftar paket]");
                continue;
            }
        } while (!LaundryPackage.contains(laundryPackage) || laundryPackage.isEmpty());

        return laundryPackage;
    }

    protected static int getWeight() {
        System.out.println("Masukkan berat cucian [kg]: ");

        return scanner.nextInt();
    }

    public NotaMenu() {
        String name = getName();
        String phoneNumber = getPhoneNumber();
        String date = getDate();
        String laundryPackage = getLaundryPackage();

        int weight = getWeight();

        NotaGenerator notaGenerator = new NotaGenerator(name, phoneNumber, date, laundryPackage, weight);
        System.out.println("Nota anda: " + NotaGenerator.generateNota());
    }
}
