package DDP2.CSUI;

import DDP2.CSUI.utils.TimeMechanic;

public class Nota {
    protected static int idNota, berat, sisaHariPengerjaan;
    protected static Member member;
    protected static String paket, tanggalMasuk;
    protected static boolean isReady;

    public Nota(int idNota, Member member, String paket, int berat, String tanggalMasuk, int sisaHariPengerjaan, boolean isReady) {
        Nota.idNota = idNota;
        Nota.member = member;
        Nota.paket = paket;
        Nota.berat = berat;
        Nota.tanggalMasuk = TimeMechanic.getThisDate();
        Nota.sisaHariPengerjaan = sisaHariPengerjaan;
        Nota.isReady = isReady;
    }

    public static int getIdNota() {
        return idNota;
    }
    public static void setIdNota(int idNota) {
        Nota.idNota = idNota;
    }
    public static Member getMember() {
        return member;
    }
    public static void setMember(Member member) {
        Nota.member = member;
    }
    public static String getPaket() {
        return paket;
    }
    public static void setPaket(String paket) {
        Nota.paket = paket;
    }
    public static int getBerat() {
        return berat;
    }
    public static void setBerat(int berat) {
        Nota.berat = berat;
    }
    public static String getTanggalMasuk() {
        return tanggalMasuk;
    }
    public static void setTanggalMasuk(String tanggalMasuk) {
        Nota.tanggalMasuk = tanggalMasuk;
    }
    public static int getSisaHariPengerjaan() {
        return sisaHariPengerjaan;
    }
    public static void setSisaHariPengerjaan(int sisaHariPengerjaan) {
        Nota.sisaHariPengerjaan = sisaHariPengerjaan;
    }
    public static boolean isReady() {
        return isReady;
    }
    public static void setReady(boolean isReady) {
        Nota.isReady = isReady;
    }
}
