package es1;


public class Main {
    public static void main(String[] args) {
        int N = 10;  // Numero di thread (almeno 10)
        int D = 3;   // Numero di documenti per thread (almeno 2)
        Printer printer = new Printer();
        UtenteStampante[] utenti = new UtenteStampante[N];

        long start = System.currentTimeMillis();

        // Avvio dei thread
        for (int i = 0; i < N; i++) {
            utenti[i] = new UtenteStampante("UtenteStampante_" + (i + 1), printer, D);
            utenti[i].start();
        }

        // Attendiamo la fine di tutti i thread
        for (int i = 0; i < N; i++) {
            try {
                utenti[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long finish = System.currentTimeMillis();
        System.out.println("Totale documenti stampati: " + printer.docCount);
        System.out.println("Tempo totale di esecuzione (ms): " + (finish - start));
    }
}
