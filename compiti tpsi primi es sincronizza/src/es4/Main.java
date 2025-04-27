package es4;

public class Main {
    public static void main(String[] args) {
        int numThread = 4;
        CatenaThread[] threads = new CatenaThread[numThread];
        int X = 1, Y = 5; // Intervallo di numeri da stampare per ogni thread

        // Il primo thread parte subito, gli altri attendono il completamento del precedente
        threads[0] = new CatenaThread("Thread_1", X, Y, null);
        for (int i = 1; i < numThread; i++) {
            threads[i] = new CatenaThread("Thread_" + (i + 1), X, Y, threads[i - 1]);
        }
        for (int i = 0; i < numThread; i++) {
            threads[i].start();
        }

        // Opzionale: attendiamo la fine di tutti i thread
        for (int i = 0; i < numThread; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) { }
        }
        System.out.println("Catena di Thread terminata.");
    }
}