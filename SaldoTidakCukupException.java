public class SaldoTidakCukupException extends Exception {
    public SaldoTidakCukupException() {
        super("Saldo tidak mencukupi untuk membayar ongkos bus.");
    }
}
