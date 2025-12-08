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
        
        // Bayar ongkos
        p.bayar(ONGKOS);
        pendapatan += ONGKOS;

        // Atur kursi sesuai prioritas
        if (isPrioritas(p) && prioritas.size() < 4) {
            prioritas.add(p);
        } else if (biasa.size() < 16) {
            biasa.add(p);
        } else if (berdiri.size() < 20) {
            berdiri.add(p);
        } else {
            throw new BusPenuhException();
        }
    }

    public boolean turun(int id) {
        // removeIf hanya menghapus SATU penumpang pertama yang cocok
        if (prioritas.removeIf(p -> p.getID() == id)) return true;
        if (biasa.removeIf(p -> p.getID() == id)) return true;
        if (berdiri.removeIf(p -> p.getID() == id)) return true;

        return false;
    }

    @Override
    public String toString() {
        return "\n=== STATUS BUS ===" +
               "\nPrioritas: " + prioritas +
               "\nBiasa:     " + biasa +
               "\nBerdiri:   " + berdiri +
               "\nTotal Penumpang: " + total() +
               "\nPendapatan: Rp " + pendapatan +
               "\n==================\n";
    }
}
