package DDP2.CSUI.utils;

public class IDGenerator {
    private static String name;
    private static String phoneNumber;

    public IDGenerator(String name, String phoneNumber) {
        IDGenerator.name = name;
        IDGenerator.phoneNumber = phoneNumber;
    }

    private static String calculateChecksum(String csName, String phoneNumber) {
        csName = csName.toLowerCase();
        long sum = 0;
        for (int i = 0; i < csName.length(); i++) {
            if ((csName.charAt(i) == ' ') || (csName.charAt(i) < 1)) continue;
            else if (!(csName.charAt(i) >= 'a' && csName.charAt(i) <= 'z')) sum += 7;
            int c = (csName.charAt(i) - 'a') + 1;
            sum += c;
        }

        while (!phoneNumber.isEmpty()) {
            sum += Long.parseLong(phoneNumber.substring(0, 1));
            phoneNumber = phoneNumber.substring(1);
        }

        sum += 7;

        String strSum = Long.toString(sum);

        if (strSum.length() <= 1) return "0" + strSum;

        return strSum;
    }

    public static String generateID() {
        String fName = name.split(" ")[0].toUpperCase();
        String checksum = calculateChecksum(fName, phoneNumber);

        return fName + "-" + phoneNumber + "-" + checksum;
    }
}
