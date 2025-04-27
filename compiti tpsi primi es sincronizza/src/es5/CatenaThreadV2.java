package es5;

class CatenaThreadV2 extends Thread {
    private Thread precedente;
    private Counter counter;

    public CatenaThreadV2(String name, Thread precedente, Counter counter) {
        super(name);
        this.precedente = precedente;
        this.counter = counter;
    }

    public void run() {
        try {
            if (precedente != null) {
                precedente.join();
            }
        } catch (InterruptedException e) {
        }

        int start = counter.getNextStart();
        int end = start + 9;
        System.out.print(getName() + ": ");
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}