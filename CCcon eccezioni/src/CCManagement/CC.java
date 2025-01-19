package CCManagement;

public class CC {
    private String nomeCorrentista;
    private double saldo;

    public CC(String nomeCorrentista, double saldoIniziale) {
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = saldoIniziale;
    }

    public void deposita(double amount) throws CifraNegativaException {
        if (amount < 0) {
            throw new CifraNegativaException("Non è possibile depositare una cifra negativa.");
        }
        saldo += amount;
    }

    public void preleva(double amount) throws CifraNegativaException, SaldoInsufficienteException {
        if (amount < 0) {
            throw new CifraNegativaException("Non è possibile prelevare una cifra negativa.");
        }
        if (amount > saldo) {
            throw new SaldoInsufficienteException("Saldo insufficiente per effettuare il prelievo.");
        }
        saldo -= amount;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public double getSaldo() {
        return saldo;
    }
}