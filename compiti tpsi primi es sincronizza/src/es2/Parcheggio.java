package es2;
import java.util.concurrent.Semaphore;

class Parcheggio {
    private Semaphore posti;

    public Parcheggio(int postiDisponibili) {
        posti = new Semaphore(postiDisponibili);
    }

    public void entra(String auto) {
        System.out.println("[" + auto + "] attende un posto libero.");
        try {
            posti.acquire();
            System.out.println("[" + auto + "] si è parcheggiata. Posti liberi: " + posti.availablePermits());
        } catch (InterruptedException e) {
            // In caso di interruzione, il thread termina.
        }
    }

    public void esci(String auto) {
        posti.release();
        System.out.println("[" + auto + "] esce dal parcheggio. Posti liberi: " + posti.availablePermits());
    }
}