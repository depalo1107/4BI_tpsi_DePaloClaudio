package es4;

class CatenaThread extends Thread {
    private int start, end;
    private Thread precedente;

    public CatenaThread(String name, int start, int end, Thread precedente) {
        super(name);
        this.start = start;
        this.end = end;
        this.precedente = precedente;
    }

    public void run() {
        try {
            // Se esiste un thread precedente, aspetta che termini.
            if (precedente != null) {
                precedente.join();
            }
        } catch (InterruptedException e) { }

        for (int i = start; i <= end; i++) {
            System.out.println(getName() + ": " + i);
        }
    }
}