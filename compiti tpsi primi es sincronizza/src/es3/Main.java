package es3;
import java.util.concurrent.Semaphore;
public class Main {
    public static void main(String[] args) {
        int numOperai = 5; // Test con più di 2 operai
        Semaphore assemblySem = new Semaphore(2);  // max 2 operai in assemblaggio
        Semaphore collaudoSem = new Semaphore(1);    // max 1 operaio in collaudo

        Operaio[] operai = new Operaio[numOperai];
        for (int i = 0; i < numOperai; i++) {
            operai[i] = new Operaio("Operaio_" + (i + 1), assemblySem, collaudoSem);
            operai[i].start();
        }

        // Attendiamo la conclusione di tutti gli operai
        for (int i = 0; i < numOperai; i++) {
            try {
                operai[i].join();
            } catch (InterruptedException e) { }
        }
        System.out.println("Catena di montaggio terminata.");
    }
}