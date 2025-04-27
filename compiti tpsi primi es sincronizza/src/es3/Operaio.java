package es3;

import java.util.concurrent.Semaphore;

class Operaio extends Thread {
    private Semaphore assemblySem;
    private Semaphore collaudoSem;

    public Operaio(String name, Semaphore assemblySem, Semaphore collaudoSem) {
        super(name);
        this.assemblySem = assemblySem;
        this.collaudoSem = collaudoSem;
    }

    public void run() {
        try {
            System.out.println("[" + getName() + "] attende assemblaggio");
            assemblySem.acquire();
            System.out.println("[" + getName() + "] inizia assemblaggio");
            // Simula tempo di assemblaggio (1000 - 2000 ms)
            Thread.sleep(1000 + (int)(Math.random() * 1000));
            System.out.println("[" + getName() + "] finisce assemblaggio");
            assemblySem.release();

            System.out.println("[" + getName() + "] attende collaudo");
            collaudoSem.acquire();
            System.out.println("[" + getName() + "] inizia collaudo");
            // Simula tempo di collaudo (1000 - 2000 ms)
            Thread.sleep(1000 + (int)(Math.random() * 1000));
            System.out.println("[" + getName() + "] finisce collaudo");
            collaudoSem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

