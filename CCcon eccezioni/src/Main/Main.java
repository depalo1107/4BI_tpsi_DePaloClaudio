package Main;

import CCManagement.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Inserisci il nome del correntista: ");
            String nome = scanner.nextLine();
            System.out.print("Inserisci il saldo iniziale: ");
            double saldo = scanner.nextDouble();

            CC conto = new CC(nome, saldo);

            System.out.print("Vuoi prelevare o depositare (P/D)? ");
            String operazione = scanner.next().toUpperCase();
            System.out.print("Inserisci l'importo: ");
            double importo = scanner.nextDouble();

            if (operazione.equals("D")) {
                conto.deposita(importo);
            } else if (operazione.equals("P")) {
                conto.preleva(importo);
            } else {
                System.out.println("Operazione non valida.");
            }

            System.out.println("Saldo attuale: " + conto.getSaldo());
        } catch (CifraNegativaException | SaldoInsufficienteException e) {
            System.out.println("Errore: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Errore imprevisto: " + e.getMessage());
        }
    }
}