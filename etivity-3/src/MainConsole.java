import business.SistemaCittadella;
import model.AttivitaSportiva;
import model.Iscritto;
import exception.MatricolaEsistenteException;
import exception.MatricolaNonTrovataException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principale per testare il sistema di gestione 
 * della cittadella sportiva tramite interfaccia console.
 * 
 * @author Luigi Rosato
 * @version 1.0
 */
public class MainConsole {
    
    private static SistemaCittadella sistema;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        sistema = new SistemaCittadella();
        scanner = new Scanner(System.in);
        
        System.out.println("=".repeat(60));
        System.out.println("    SISTEMA GESTIONE CITTADELLA SPORTIVA UNIVERSITARIA");
        System.out.println("=".repeat(60));
        System.out.println("Autore: Luigi Rosato - Matricola: IN32000141");
        System.out.println("Etivity 3 - Implementazione sistema Java");
        System.out.println("=".repeat(60));
        
        // Popola il sistema con alcuni dati di esempio
        popolaSistemaDiEsempio();
        
        // Menu principale
        boolean continua = true;
        while (continua) {
            mostraMenu();
            int scelta = leggiScelta();
            
            switch (scelta) {
                case 1 -> nuovaIscrizione();
                case 2 -> ricercaIscritto();
                case 3 -> calcolaRetta();
                case 4 -> stampaIscrittiPerAttivita();
                case 5 -> mostraStatistiche();
                case 6 -> mostraTuttiIscritti();
                case 7 -> mostraAttivitaDisponibili();
                case 0 -> {
                    System.out.println("\nGrazie per aver utilizzato il sistema!");
                    continua = false;
                }
                default -> System.out.println("Scelta non valida. Riprovare.");
            }
            
            if (continua) {
                System.out.println("\nPremere INVIO per continuare...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Mostra il menu principale delle opzioni.
     */
    private static void mostraMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                  MENU PRINCIPALE");
        System.out.println("=".repeat(50));
        System.out.println("1. Nuova iscrizione");
        System.out.println("2. Ricerca iscritto per matricola");
        System.out.println("3. Calcola retta mensile");
        System.out.println("4. Lista iscritti per attività");
        System.out.println("5. Mostra statistiche");
        System.out.println("6. Mostra tutti gli iscritti");
        System.out.println("7. Mostra attività disponibili");
        System.out.println("0. Esci");
        System.out.println("-".repeat(50));
        System.out.print("Scelta: ");
    }
    
    /**
     * Legge la scelta dell'utente dal menu.
     */
    private static int leggiScelta() {
        try {
            String input = scanner.nextLine().trim();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * Gestisce la creazione di una nuova iscrizione.
     */
    private static void nuovaIscrizione() {
        System.out.println("\n--- NUOVA ISCRIZIONE ---");
        
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();
            
            System.out.print("Cognome: ");
            String cognome = scanner.nextLine().trim();
            
            System.out.print("Matricola: ");
            String matricola = scanner.nextLine().trim();
            
            // Verifica se la matricola esiste già
            if (sistema.esisteMatricola(matricola)) {
                System.out.println("❌ ERRORE: Matricola già esistente nel sistema!");
                return;
            }
            
            // Mostra attività disponibili
            System.out.println("\nAttività sportive disponibili:");
            List<AttivitaSportiva> attivita = sistema.getAttivitaDisponibili();
            for (int i = 0; i < attivita.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, attivita.get(i));
            }
            
            System.out.print("\nInserisci i numeri delle attività (es: 1,3): ");
            String inputAttivita = scanner.nextLine().trim();
            
            List<String> nomiAttivita = Arrays.stream(inputAttivita.split(","))
                    .map(String::trim)
                    .map(s -> {
                        try {
                            int index = Integer.parseInt(s) - 1;
                            if (index >= 0 && index < attivita.size()) {
                                return attivita.get(index).getNome();
                            }
                        } catch (NumberFormatException e) {
                            // Ignora input non validi
                        }
                        return null;
                    })
                    .filter(s -> s != null)
                    .toList();
            
            if (nomiAttivita.isEmpty()) {
                System.out.println("❌ Nessuna attività valida selezionata!");
                return;
            }
            
            // Effettua l'iscrizione
            sistema.iscriviNuovoUtente(nome, cognome, matricola, nomiAttivita);
            
            System.out.println("✅ Iscrizione completata con successo!");
            System.out.printf("Retta mensile: €%.2f\n", sistema.calcolaRettaMensile(matricola));
            
        } catch (MatricolaEsistenteException e) {
            System.out.println("❌ ERRORE: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ ERRORE: " + e.getMessage());
        }
    }
    
    /**
     * Gestisce la ricerca di un iscritto per matricola.
     */
    private static void ricercaIscritto() {
        System.out.println("\n--- RICERCA ISCRITTO ---");
        
        System.out.print("Inserisci matricola: ");
        String matricola = scanner.nextLine().trim();
        
        try {
            Iscritto iscritto = sistema.ricercaUtente(matricola);
            System.out.println("\n📋 RISULTATO RICERCA:");
            System.out.println(iscritto);
        } catch (MatricolaNonTrovataException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ ERRORE: " + e.getMessage());
        }
    }
    
    /**
     * Calcola e mostra la retta mensile per una matricola.
     */
    private static void calcolaRetta() {
        System.out.println("\n--- CALCOLO RETTA MENSILE ---");
        
        System.out.print("Inserisci matricola: ");
        String matricola = scanner.nextLine().trim();
        
        try {
            double retta = sistema.calcolaRettaMensile(matricola);
            Iscritto iscritto = sistema.ricercaUtente(matricola);
            
            System.out.printf("\n💰 RETTA MENSILE per %s:\n", iscritto.getNomeCompleto());
            System.out.printf("Importo totale: €%.2f\n", retta);
            
            System.out.println("\nDettaglio attività:");
            for (AttivitaSportiva attivita : iscritto.getAttivitaSportive()) {
                System.out.printf("- %s: €%.2f\n", attivita.getNome(), attivita.getCostoMensile());
            }
            
        } catch (MatricolaNonTrovataException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ ERRORE: " + e.getMessage());
        }
    }
    
    /**
     * Mostra la lista degli iscritti per una specifica attività.
     */
    private static void stampaIscrittiPerAttivita() {
        System.out.println("\n--- LISTA ISCRITTI PER ATTIVITÀ ---");
        
        // Mostra attività disponibili
        List<AttivitaSportiva> attivita = sistema.getAttivitaDisponibili();
        System.out.println("Attività disponibili:");
        for (int i = 0; i < attivita.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, attivita.get(i).getNome());
        }
        
        System.out.print("\nSeleziona attività (numero): ");
        try {
            int scelta = Integer.parseInt(scanner.nextLine().trim());
            if (scelta < 1 || scelta > attivita.size()) {
                System.out.println("❌ Scelta non valida!");
                return;
            }
            
            String nomeAttivita = attivita.get(scelta - 1).getNome();
            List<Iscritto> iscritti = sistema.stampaIscrittiPerAttivita(nomeAttivita);
            
            System.out.printf("\n📋 ISCRITTI per %s (%d totali):\n", nomeAttivita, iscritti.size());
            System.out.println("-".repeat(60));
            
            if (iscritti.isEmpty()) {
                System.out.println("Nessun iscritto per questa attività.");
            } else {
                for (int i = 0; i < iscritti.size(); i++) {
                    Iscritto iscritto = iscritti.get(i);
                    System.out.printf("%d. %s (Matricola: %s) - Retta: €%.2f\n", 
                        i + 1, iscritto.getNomeCompleto(), iscritto.getMatricola(), 
                        iscritto.calcolaRettaMensile());
                }
            }
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Input non valido!");
        } catch (Exception e) {
            System.out.println("❌ ERRORE: " + e.getMessage());
        }
    }
    
    /**
     * Mostra statistiche generali del sistema.
     */
    private static void mostraStatistiche() {
        System.out.println("\n--- STATISTICHE SISTEMA ---");
        
        System.out.printf("👥 Totale iscritti: %d\n", sistema.getNumeroIscritti());
        System.out.printf("💰 Fatturato mensile: €%.2f\n", sistema.calcolaFatturatoMensile());
        
        System.out.println("\n📊 Distribuzione per attività:");
        var statistiche = sistema.getStatisticheAttivita();
        for (var entry : statistiche.entrySet()) {
            System.out.printf("- %s: %d iscritti\n", entry.getKey(), entry.getValue());
        }
    }
    
    /**
     * Mostra tutti gli iscritti del sistema.
     */
    private static void mostraTuttiIscritti() {
        System.out.println("\n--- TUTTI GLI ISCRITTI ---");
        
        List<Iscritto> iscritti = sistema.getTuttiIscritti();
        
        if (iscritti.isEmpty()) {
            System.out.println("Nessun iscritto nel sistema.");
            return;
        }
        
        System.out.printf("Totale iscritti: %d\n", iscritti.size());
        System.out.println("-".repeat(80));
        
        for (int i = 0; i < iscritti.size(); i++) {
            Iscritto iscritto = iscritti.get(i);
            System.out.printf("%d. %s (Matricola: %s)\n", 
                i + 1, iscritto.getNomeCompleto(), iscritto.getMatricola());
            System.out.printf("   Attività: %d - Retta mensile: €%.2f\n", 
                iscritto.getNumeroAttivita(), iscritto.calcolaRettaMensile());
        }
    }
    
    /**
     * Mostra le attività sportive disponibili.
     */
    private static void mostraAttivitaDisponibili() {
        System.out.println("\n--- ATTIVITÀ SPORTIVE DISPONIBILI ---");
        
        List<AttivitaSportiva> attivita = sistema.getAttivitaDisponibili();
        for (int i = 0; i < attivita.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, attivita.get(i));
        }
    }
    
    /**
     * Popola il sistema con alcuni dati di esempio per i test.
     */
    private static void popolaSistemaDiEsempio() {
        try {
            // Iscrizione di esempio 1
            sistema.iscriviNuovoUtente("Luigi", "Rosato", "IN32000141", 
                Arrays.asList("Nuoto", "Atletica leggera"));
            
            // Iscrizione di esempio 2
            sistema.iscriviNuovoUtente("Mario", "Rossi", "IN12345", 
                Arrays.asList("Body building"));
            
            // Iscrizione di esempio 3
            sistema.iscriviNuovoUtente("Anna", "Verdi", "IN54321", 
                Arrays.asList("Nuoto", "Body building"));
            
            System.out.println("📋 Sistema inizializzato con 3 iscritti di esempio.");
            
        } catch (Exception e) {
            System.out.println("⚠️  Errore nell'inizializzazione dei dati di esempio: " + e.getMessage());
        }
    }
} 