public interface Pembayaran {
    void bayar(int ongkos) throws SaldoTidakCukupException;
}
