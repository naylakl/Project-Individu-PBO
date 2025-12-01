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
