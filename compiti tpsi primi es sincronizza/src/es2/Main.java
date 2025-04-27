package es2;

public class Main {
    public static void main(String[] args) {
        int postiDisponibili = 3;
        int numAuto = 10;
        int durataSimulazione = 10000; // 10 secondi

        Parcheggio parcheggio = new Parcheggio(postiDisponibili);
        Auto[] autos = new Auto[numAuto];

        // Avvio dei thread Auto
        for (int i = 0; i < numAuto; i++) {
            autos[i] = new Auto("Auto_" + (i + 1), parcheggio);
            autos[i].start();
        }

        // Il parcheggio rimane aperto per un tempo massimo
        try {
            Thread.sleep(durataSimulazione);
        } catch (InterruptedException e) { }

        // Interrompiamo i thread (lancio del "cancello")
        for (int i = 0; i < numAuto; i++) {
            autos[i].interrupt();
        }

        // Attendiamo la chiusura di tutti i thread
        for (int i = 0; i < numAuto; i++) {
            try {
                autos[i].join();
            } catch (InterruptedException e) { }
        }
        System.out.println("Parcheggio chiuso.");
    }
}