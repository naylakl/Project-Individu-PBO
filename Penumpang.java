public abstract class Penumpang implements Pembayaran {
    protected int id;
    protected int umur;
    protected boolean hamil;
    protected int saldo;
    protected Kategori kategori;

    public Penumpang(int id, int umur, boolean hamil) {
        this.id = id;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = 10000;
        tentukanKategori();
    }

    private void tentukanKategori() {
        if (hamil) kategori = Kategori.IBU_HAMIL;
        else if (umur < 10) kategori = Kategori.ANAK;
        else if (umur > 60) kategori = Kategori.LANSIA;
        else kategori = Kategori.BIASA;
    }

    @Override
    public void bayar(int ongkos) throws SaldoTidakCukupException {
        if (saldo < ongkos) {
            throw new SaldoTidakCukupException();
        }
        saldo -= ongkos;
    }

    public int getID() { return id; }
    public Kategori getKategori() { return kategori; }
    public int getSaldo() { return saldo; }

    @Override
    public String toString() {
        return "ID:" + id + " (" + kategori + ", saldo=" + saldo + ")";
    }
}
