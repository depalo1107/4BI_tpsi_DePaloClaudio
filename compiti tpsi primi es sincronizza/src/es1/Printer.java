package es1;

import java.util.concurrent.Semaphore;

class Printer {
    // Semaforo con un solo permesso per garantire accesso esclusivo.
    Semaphore semaphore = new Semaphore(1);
    int docCount = 0;

    // Metodo di stampa: simula il lavoro con un sleep randomico fra 500 e 1500 ms.
    public void print(String doc, String threadName) {
        System.out.println("[" + threadName + "] attende risorsa");
        try {
            semaphore.acquire();
            System.out.println("[" + threadName + "] inizia la stampa " + doc);
            // Simula il tempo di stampa randomico
            int sleepTime = 500 + (int)(Math.random() * 1000); // 500 - 1500 ms
            Thread.sleep(sleepTime);
            System.out.println("[" + threadName + "] finisce la stampa di " + doc);
            docCount++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

