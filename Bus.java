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
    public boolean idSudahAda(int id) {
        return prioritas.stream().anyMatch(p -> p.getID() == id) ||
               biasa.stream().anyMatch(p -> p.getID() == id) ||
               berdiri.stream().anyMatch(p -> p.getID() == id);
    }

    private boolean isPrioritas(Penumpang p) {
        return p.getKategori() != Kategori.BIASA;
    }

    private int total() {
        return prioritas.size() + biasa.size() + berdiri.size();
    }

    public void naik(Penumpang p) throws BusPenuhException, SaldoTidakCukupException {
        if (total() >= 40) {
            throw new BusPenuhException();
        }
