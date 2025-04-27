package es5;

public class Main {
    public static void main(String[] args) {
        int numThread = 4;
        CatenaThreadV2[] threads = new CatenaThreadV2[numThread];
        Counter counter = new Counter();

        // Il primo thread non ha predecessore
        threads[0] = new CatenaThreadV2("Thread_1", null, counter);
        for (int i = 1; i < numThread; i++) {
            threads[i] = new CatenaThreadV2("Thread_" + (i + 1), threads[i - 1], counter);
        }

        for (int i = 0; i < numThread; i++) {
            threads[i].start();
        }

        // Attendiamo la conclusione di tutti i thread
        for (int i = 0; i < numThread; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) { }
        }
        System.out.println("Catena di Thread V2 terminata.");
    }
}
