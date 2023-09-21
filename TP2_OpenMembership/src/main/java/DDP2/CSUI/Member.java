package DDP2.CSUI;

import DDP2.CSUI.utils.IDGenerator;

public class Member {
    protected static String nama, noHp, id;
    protected static int bonusCounter;

    public Member(String nama, String noHp) {
        Member.nama = nama;
        Member.noHp = noHp;
        Member.id = IDGenerator.generateID();
        Member.bonusCounter = 0;
    }

    public static String getNama() {
        return nama;
    }

    public static String getNoHp() {
        return noHp;
    }

    public static String getId() {
        return id;
    }

    public static int getBonusCounter() {
        return bonusCounter;
    }

    public static void addBonusCounter() {
        bonusCounter++;
    }

    public static void resetBonusCounter() {
        bonusCounter = 0;
    }

    public static void setNama(String nama) {
        Member.nama = nama;
    }

    public static void setNoHp(String noHp) {
        Member.noHp = noHp;
    }
}
