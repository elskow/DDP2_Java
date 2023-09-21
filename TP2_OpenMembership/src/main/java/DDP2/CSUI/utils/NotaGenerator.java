package DDP2.CSUI.utils;

import java.util.HashMap;
import java.util.Map;
import java.time.format.DateTimeFormatter;

public class NotaGenerator {
    protected static String name, phoneNumber, date, laundryPackage, id;
    protected static int weight, idx;

    static Map<String, Integer> laundryPackagePrice = new HashMap<String, Integer>();


    public NotaGenerator(String name, String phoneNumber, String date, String laundryPackage, int weight) {
        NotaGenerator.name = name;
        NotaGenerator.phoneNumber = phoneNumber;
        NotaGenerator.date = date;

        NotaGenerator.laundryPackage = laundryPackage;
        NotaGenerator.weight = weight;

        new IDGenerator(name, phoneNumber);
        id = IDGenerator.generateID();

        laundryPackagePrice.put("Express", 12000);
        laundryPackagePrice.put("Fast", 10000);
        laundryPackagePrice.put("Reguler", 7000);

        NotaGenerator.idx = switch (NotaGenerator.laundryPackage) {
            case "Express" -> 1;
            case "Fast" -> 2;
            case "Reguler" -> 3;
            default -> 0;
        };
    }

    protected static String dateFormatter(int day, int month, int year){
        try {
            java.time.LocalDate.of(year, month, day);
        }
        catch (Exception e) {
            if (month == 2) {
                if (day > 28) {
                    day -= 28;
                    month++;
                }
            }
            else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day > 30) {
                    day -= 30;
                    month++;
                }
            }
            else {
                if (day > 31) {
                    day -= 31;
                    month++;
                }
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(java.time.LocalDate.of(year, month, day));
    }

    public static String generateNota() {
        String nota = "";

        nota = "Nota Laundry\n";
        nota += "ID\t\t: " + id + "\n";
        nota += "Paket\t: " + NotaGenerator.laundryPackage + "\n";
        nota += "Harga\t: " + "\n";
        nota += NotaGenerator.weight + "kg x " + laundryPackagePrice.get(NotaGenerator.laundryPackage) + " : " + NotaGenerator.weight * laundryPackagePrice.get(NotaGenerator.laundryPackage) + "\n";

        nota += "Tanggal Terima\t: " + NotaGenerator.date + "\n";

        int day = Integer.parseInt(NotaGenerator.date.substring(0, 2));
        int month = Integer.parseInt(NotaGenerator.date.substring(3, 5));
        int year = Integer.parseInt(NotaGenerator.date.substring(6, 10));

        nota += "Tanggal Selesai\t: " + dateFormatter(day + idx, month, year) + "\n";

        return nota;
    }
}
