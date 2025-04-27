
package es1;

class UtenteStampante extends Thread {
    private Printer printer;
    private int documents;

    public UtenteStampante(String name, Printer printer, int documents) {
        super(name);
        this.printer = printer;
        this.documents = documents;
    }

    public void run() {
        for (int i = 1; i <= documents; i++) {
            String doc = "Documento-" + i;
            printer.print(doc, this.getName());
        }
    }
}

