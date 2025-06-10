package business;

import model.AttivitaSportiva;
import model.Iscritto;
import exception.MatricolaEsistenteException;
import exception.MatricolaNonTrovataException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Classe che gestisce la collezione degli iscritti e delle attività sportive.
 * Fornisce operazioni CRUD per gli iscritti e gestisce l'integrità dei dati.
 * 
 * @author Luigi Rosato
 * @version 1.0
 */
public class GestioneIscritti {
    
    // Mappa degli iscritti indicizzata per matricola per accesso rapido O(1)
    private Map<String, Iscritto> iscritti;
    
    // Lista delle attività sportive disponibili
    private List<AttivitaSportiva> attivitaDisponibili;
    
    /**
     * Costruttore che inizializza le strutture dati e le attività predefinite.
     */
    public GestioneIscritti() {
        this.iscritti = new HashMap<>();
        this.attivitaDisponibili = new ArrayList<>();
        inizializzaAttivita();
    }
    
    /**
     * Inizializza le attività sportive predefinite della cittadella.
     * Come specificato nei requisiti: Nuoto €25, Atletica €40, Body Building €50
     */
    public void inizializzaAttivita() {
        attivitaDisponibili.clear();
        
        try {
            attivitaDisponibili.add(new AttivitaSportiva("Nuoto", 25.00));
            attivitaDisponibili.add(new AttivitaSportiva("Atletica leggera", 40.00));
            attivitaDisponibili.add(new AttivitaSportiva("Body building", 50.00));
        } catch (IllegalArgumentException e) {
            System.err.println("Errore nell'inizializzazione delle attività: " + e.getMessage());
        }
    }
    
    /**
     * Registra un nuovo iscritto nel sistema.
     * 
     * @param iscritto L'iscritto da registrare
     * @throws MatricolaEsistenteException se la matricola è già presente
     * @throws IllegalArgumentException se l'iscritto è null
     */
    public void registraIscritto(Iscritto iscritto) throws MatricolaEsistenteException {
        if (iscritto == null) {
            throw new IllegalArgumentException("L'iscritto non può essere null");
        }
        
        String matricola = iscritto.getMatricola();
        
        if (esisteMatricola(matricola)) {
            throw new MatricolaEsistenteException(
                "Matricola " + matricola + " già presente nel sistema");
        }
        
        iscritti.put(matricola, iscritto);
    }
    
    /**
     * Cerca un iscritto per matricola.
     * 
     * @param matricola La matricola da cercare
     * @return L'iscritto trovato
     * @throws MatricolaNonTrovataException se la matricola non esiste
     * @throws IllegalArgumentException se la matricola è null o vuota
     */
    public Iscritto trovaIscritto(String matricola) throws MatricolaNonTrovataException {
        if (matricola == null || matricola.trim().isEmpty()) {
            throw new IllegalArgumentException("La matricola non può essere vuota");
        }
        
        String matricolaNormalizzata = matricola.trim().toUpperCase();
        Iscritto iscritto = iscritti.get(matricolaNormalizzata);
        
        if (iscritto == null) {
            throw new MatricolaNonTrovataException(
                "Matricola " + matricolaNormalizzata + " non trovata nel sistema");
        }
        
        return iscritto;
    }
    
    /**
     * Verifica se una matricola esiste già nel sistema.
     * 
     * @param matricola La matricola da verificare
     * @return true se la matricola esiste, false altrimenti
     */
    public boolean esisteMatricola(String matricola) {
        if (matricola == null || matricola.trim().isEmpty()) {
            return false;
        }
        
        return iscritti.containsKey(matricola.trim().toUpperCase());
    }
    
    /**
     * Restituisce tutti gli iscritti che praticano una specifica attività.
     * 
     * @param nomeAttivita Nome dell'attività sportiva
     * @return Lista degli iscritti per l'attività (può essere vuota)
     * @throws IllegalArgumentException se il nome attività è null o vuoto
     */
    public List<Iscritto> getIscrittiPerAttivita(String nomeAttivita) {
        if (nomeAttivita == null || nomeAttivita.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome dell'attività non può essere vuoto");
        }
        
        return iscritti.values().stream()
                .filter(iscritto -> iscritto.praticaAttivita(nomeAttivita))
                .sorted(Comparator.comparing(Iscritto::getCognome)
                        .thenComparing(Iscritto::getNome))
                .collect(Collectors.toList());
    }
    
    /**
     * Restituisce tutti gli iscritti ordinati per cognome e nome.
     * 
     * @return Lista di tutti gli iscritti (copia per evitare modifiche esterne)
     */
    public List<Iscritto> getTuttiIscritti() {
        return iscritti.values().stream()
                .sorted(Comparator.comparing(Iscritto::getCognome)
                        .thenComparing(Iscritto::getNome))
                .collect(Collectors.toList());
    }
    
    /**
     * Restituisce la lista delle attività sportive disponibili.
     * 
     * @return Lista delle attività disponibili (copia per evitare modifiche esterne)
     */
    public List<AttivitaSportiva> getAttivitaDisponibili() {
        return new ArrayList<>(attivitaDisponibili);
    }
    
    /**
     * Trova un'attività sportiva per nome.
     * 
     * @param nomeAttivita Nome dell'attività da cercare
     * @return L'attività trovata o null se non esiste
     */
    public AttivitaSportiva trovaAttivitaSportiva(String nomeAttivita) {
        if (nomeAttivita == null || nomeAttivita.trim().isEmpty()) {
            return null;
        }
        
        return attivitaDisponibili.stream()
                .filter(attivita -> attivita.getNome().equalsIgnoreCase(nomeAttivita.trim()))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Rimuove un iscritto dal sistema.
     * 
     * @param matricola Matricola dell'iscritto da rimuovere
     * @return true se l'iscritto è stato rimosso, false se non esisteva
     * @throws IllegalArgumentException se la matricola è null o vuota
     */
    public boolean rimuoviIscritto(String matricola) {
        if (matricola == null || matricola.trim().isEmpty()) {
            throw new IllegalArgumentException("La matricola non può essere vuota");
        }
        
        String matricolaNormalizzata = matricola.trim().toUpperCase();
        return iscritti.remove(matricolaNormalizzata) != null;
    }
    
    /**
     * Restituisce il numero totale di iscritti.
     * 
     * @return Numero di iscritti registrati
     */
    public int getNumeroIscritti() {
        return iscritti.size();
    }
    
    /**
     * Restituisce il numero di iscritti per una specifica attività.
     * 
     * @param nomeAttivita Nome dell'attività
     * @return Numero di iscritti per l'attività
     */
    public int getNumeroIscrittiPerAttivita(String nomeAttivita) {
        return getIscrittiPerAttivita(nomeAttivita).size();
    }
    
    /**
     * Calcola il fatturato mensile totale della cittadella.
     * 
     * @return Somma di tutte le rette mensili degli iscritti
     */
    public double calcolaFatturatoMensile() {
        return iscritti.values().stream()
                .mapToDouble(Iscritto::calcolaRettaMensile)
                .sum();
    }
    
    /**
     * Restituisce statistiche di utilizzo delle attività.
     * 
     * @return Mappa con nome attività e numero di iscritti
     */
    public Map<String, Integer> getStatisticheAttivita() {
        Map<String, Integer> statistiche = new HashMap<>();
        
        for (AttivitaSportiva attivita : attivitaDisponibili) {
            int numeroIscritti = getNumeroIscrittiPerAttivita(attivita.getNome());
            statistiche.put(attivita.getNome(), numeroIscritti);
        }
        
        return statistiche;
    }
} 