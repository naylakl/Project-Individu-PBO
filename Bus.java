import java.util.ArrayList;

public class Bus {
    private ArrayList<Penumpang> prioritas;
    private ArrayList<Penumpang> biasa;
    private ArrayList<Penumpang> berdiri;

    public static final int ONGKOS = 2000;
    private int pendapatan = 0;

    public Bus() {
        prioritas = new ArrayList<>();
        biasa = new ArrayList<>();
        berdiri = new ArrayList<>();
    }

    // ===========================
    //   CEK ID SUDAH TERDAFTAR
    // ===========================
