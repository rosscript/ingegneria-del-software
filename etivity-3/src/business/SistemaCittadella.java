package business;

import model.AttivitaSportiva;
import model.Iscritto;
import exception.MatricolaEsistenteException;
import exception.MatricolaNonTrovataException;

import java.util.List;
import java.util.Map;

/**
 * Classe principale del sistema che coordina tutte le operazioni
 * di gestione della cittadella sportiva universitaria.
 * Implementa il pattern Facade per semplificare l'accesso alle funzionalità.
 * 
 * @author Luigi Rosato
 * @version 1.0
 */
public class SistemaCittadella {
    
    // Gestore degli iscritti - componente principale del sistema
    private GestioneIscritti gestioneIscritti;
    
    /**
     * Costruttore che inizializza il sistema.
     */
    public SistemaCittadella() {
        this.gestioneIscritti = new GestioneIscritti();
    }
    
    /**
     * Iscrive un nuovo utente nel sistema.
     * Crea un oggetto Iscritto e lo associa alle attività sportive specificate.
     * 
     * @param nome Nome dell'iscritto
     * @param cognome Cognome dell'iscritto
     * @param matricola Matricola univoca
     * @param nomiAttivita Lista dei nomi delle attività sportive
     * @throws MatricolaEsistenteException se la matricola è già presente
     * @throws IllegalArgumentException se i parametri non sono validi
     */
    public void iscriviNuovoUtente(String nome, String cognome, String matricola, 
                                   List<String> nomiAttivita) throws MatricolaEsistenteException {
        
        // Validazione parametri
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome non può essere vuoto");
        }
        if (cognome == null || cognome.trim().isEmpty()) {
            throw new IllegalArgumentException("Il cognome non può essere vuoto");
        }
        if (matricola == null || matricola.trim().isEmpty()) {
            throw new IllegalArgumentException("La matricola non può essere vuota");
        }
        if (nomiAttivita == null || nomiAttivita.isEmpty()) {
            throw new IllegalArgumentException("Deve essere selezionata almeno un'attività");
        }
        
        // Creazione del nuovo iscritto
        Iscritto nuovoIscritto = new Iscritto(nome, cognome, matricola);
        
        // Associazione delle attività sportive
        for (String nomeAttivita : nomiAttivita) {
            AttivitaSportiva attivita = gestioneIscritti.trovaAttivitaSportiva(nomeAttivita);
            if (attivita == null) {
                throw new IllegalArgumentException("Attività '" + nomeAttivita + "' non disponibile");
            }
            nuovoIscritto.addAttivitaSportiva(attivita);
        }
        
        // Registrazione nel sistema
        gestioneIscritti.registraIscritto(nuovoIscritto);
    }
    
    /**
     * Calcola la retta mensile per un iscritto specificato dalla matricola.
     * 
     * @param matricola Matricola dell'iscritto
     * @return Importo della retta mensile
     * @throws MatricolaNonTrovataException se la matricola non esiste
     * @throws IllegalArgumentException se la matricola non è valida
     */
    public double calcolaRettaMensile(String matricola) throws MatricolaNonTrovataException {
        if (matricola == null || matricola.trim().isEmpty()) {
            throw new IllegalArgumentException("La matricola non può essere vuota");
        }
        
        Iscritto iscritto = gestioneIscritti.trovaIscritto(matricola);
        return iscritto.calcolaRettaMensile();
    }
    
    /**
     * Ricerca un utente nel sistema per matricola.
     * 
     * @param matricola Matricola da cercare
     * @return L'iscritto trovato
     * @throws MatricolaNonTrovataException se la matricola non esiste
     * @throws IllegalArgumentException se la matricola non è valida
     */
    public Iscritto ricercaUtente(String matricola) throws MatricolaNonTrovataException {
        if (matricola == null || matricola.trim().isEmpty()) {
            throw new IllegalArgumentException("La matricola non può essere vuota");
        }
        
        return gestioneIscritti.trovaIscritto(matricola);
    }
    
    /**
     * Restituisce la lista degli iscritti per una specifica attività sportiva.
     * 
     * @param nomeAttivita Nome dell'attività sportiva
     * @return Lista degli iscritti per l'attività
     * @throws IllegalArgumentException se il nome attività non è valido
     */
    public List<Iscritto> stampaIscrittiPerAttivita(String nomeAttivita) {
        if (nomeAttivita == null || nomeAttivita.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome dell'attività non può essere vuoto");
        }
        
        return gestioneIscritti.getIscrittiPerAttivita(nomeAttivita);
    }
    
    /**
     * Restituisce la lista di tutte le attività sportive disponibili.
     * 
     * @return Lista delle attività disponibili
     */
    public List<AttivitaSportiva> getAttivitaDisponibili() {
        return gestioneIscritti.getAttivitaDisponibili();
    }
    
    /**
     * Restituisce tutti gli iscritti registrati nel sistema.
     * 
     * @return Lista di tutti gli iscritti
     */
    public List<Iscritto> getTuttiIscritti() {
        return gestioneIscritti.getTuttiIscritti();
    }
    
    /**
     * Rimuove un iscritto dal sistema.
     * 
     * @param matricola Matricola dell'iscritto da rimuovere
     * @return true se l'iscritto è stato rimosso, false se non esisteva
     * @throws IllegalArgumentException se la matricola non è valida
     */
    public boolean rimuoviIscritto(String matricola) {
        if (matricola == null || matricola.trim().isEmpty()) {
            throw new IllegalArgumentException("La matricola non può essere vuota");
        }
        
        return gestioneIscritti.rimuoviIscritto(matricola);
    }
    
    /**
     * Verifica se una matricola esiste nel sistema.
     * 
     * @param matricola Matricola da verificare
     * @return true se esiste, false altrimenti
     */
    public boolean esisteMatricola(String matricola) {
        return gestioneIscritti.esisteMatricola(matricola);
    }
    
    /**
     * Restituisce il numero totale di iscritti.
     * 
     * @return Numero di iscritti registrati
     */
    public int getNumeroIscritti() {
        return gestioneIscritti.getNumeroIscritti();
    }
    
    /**
     * Calcola il fatturato mensile totale della cittadella.
     * 
     * @return Fatturato mensile totale
     */
    public double calcolaFatturatoMensile() {
        return gestioneIscritti.calcolaFatturatoMensile();
    }
    
    /**
     * Restituisce statistiche di utilizzo delle attività.
     * 
     * @return Mappa con nome attività e numero di iscritti
     */
    public Map<String, Integer> getStatisticheAttivita() {
        return gestioneIscritti.getStatisticheAttivita();
    }
    
    /**
     * Modifica le attività sportive di un iscritto esistente.
     * 
     * @param matricola Matricola dell'iscritto
     * @param nuoveAttivita Lista delle nuove attività
     * @throws MatricolaNonTrovataException se la matricola non esiste
     * @throws IllegalArgumentException se i parametri non sono validi
     */
    public void modificaAttivitaIscritto(String matricola, List<String> nuoveAttivita) 
            throws MatricolaNonTrovataException {
        
        if (matricola == null || matricola.trim().isEmpty()) {
            throw new IllegalArgumentException("La matricola non può essere vuota");
        }
        if (nuoveAttivita == null) {
            throw new IllegalArgumentException("La lista delle attività non può essere null");
        }
        
        Iscritto iscritto = gestioneIscritti.trovaIscritto(matricola);
        
        // Rimuovi tutte le attività attuali
        List<AttivitaSportiva> attivitaAttuali = iscritto.getAttivitaSportive();
        for (AttivitaSportiva attivita : attivitaAttuali) {
            iscritto.removeAttivitaSportiva(attivita);
        }
        
        // Aggiungi le nuove attività
        for (String nomeAttivita : nuoveAttivita) {
            if (nomeAttivita != null && !nomeAttivita.trim().isEmpty()) {
                AttivitaSportiva attivita = gestioneIscritti.trovaAttivitaSportiva(nomeAttivita);
                if (attivita != null) {
                    iscritto.addAttivitaSportiva(attivita);
                }
            }
        }
    }
} 