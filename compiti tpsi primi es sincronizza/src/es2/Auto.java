package es2;

class Auto extends Thread {
    private Parcheggio parcheggio;

    public Auto(String name, Parcheggio parcheggio) {
        super(name);
        this.parcheggio = parcheggio;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            parcheggio.entra(this.getName());
            try {
                // Simula il tempo di parcheggio (1000 - 3000 ms)
                Thread.sleep(1000 + (int)(Math.random() * 2000));
            } catch (InterruptedException e) {
                break;
            }
            parcheggio.esci(this.getName());
            try {
                // Tempo in cui l'auto è fuori parcheggio prima di riprovare
                Thread.sleep(500 + (int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("[" + this.getName() + "] termina la corsa.");
    }
}