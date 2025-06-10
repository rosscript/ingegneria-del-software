package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe che rappresenta un iscritto alla cittadella sportiva.
 * Ogni iscritto ha dati anagrafici e può praticare più attività sportive.
 * 
 * @author Luigi Rosato
 * @version 1.0
 */
public class Iscritto {
    
    // Attributi privati per incapsulamento
    private String nome;
    private String cognome;
    private String matricola;
    private List<AttivitaSportiva> attivitaSportive;
    
    /**
     * Costruttore per creare un nuovo iscritto.
     * 
     * @param nome Nome dell'iscritto
     * @param cognome Cognome dell'iscritto
     * @param matricola Matricola univoca dell'iscritto
     * @throws IllegalArgumentException se uno dei parametri è null o vuoto
     */
    public Iscritto(String nome, String cognome, String matricola) {
        // Validazione dei parametri di input
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome non può essere vuoto");
        }
        if (cognome == null || cognome.trim().isEmpty()) {
            throw new IllegalArgumentException("Il cognome non può essere vuoto");
        }
        if (matricola == null || matricola.trim().isEmpty()) {
            throw new IllegalArgumentException("La matricola non può essere vuota");
        }
        
        this.nome = nome.trim();
        this.cognome = cognome.trim();
        this.matricola = matricola.trim().toUpperCase(); // Matricola in maiuscolo per uniformità
        this.attivitaSportive = new ArrayList<>();
    }
    
    /**
     * Restituisce il nome dell'iscritto.
     * 
     * @return Nome dell'iscritto
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Restituisce il cognome dell'iscritto.
     * 
     * @return Cognome dell'iscritto
     */
    public String getCognome() {
        return cognome;
    }
    
    /**
     * Restituisce la matricola dell'iscritto.
     * 
     * @return Matricola dell'iscritto
     */
    public String getMatricola() {
        return matricola;
    }
    
    /**
     * Restituisce il nome completo dell'iscritto.
     * 
     * @return Nome e cognome concatenati
     */
    public String getNomeCompleto() {
        return nome + " " + cognome;
    }
    
    /**
     * Restituisce la lista delle attività sportive praticate.
     * 
     * @return Lista di attività sportive (copia per evitare modifiche esterne)
     */
    public List<AttivitaSportiva> getAttivitaSportive() {
        return new ArrayList<>(attivitaSportive);
    }
    
    /**
     * Aggiunge un'attività sportiva all'iscritto.
     * 
     * @param attivita Attività sportiva da aggiungere
     * @throws IllegalArgumentException se l'attività è null
     * @throws IllegalStateException se l'attività è già presente
     */
    public void addAttivitaSportiva(AttivitaSportiva attivita) {
        if (attivita == null) {
            throw new IllegalArgumentException("L'attività sportiva non può essere null");
        }
        
        if (attivitaSportive.contains(attivita)) {
            throw new IllegalStateException("L'iscritto è già registrato per questa attività");
        }
        
        attivitaSportive.add(attivita);
    }
    
    /**
     * Rimuove un'attività sportiva dall'iscritto.
     * 
     * @param attivita Attività sportiva da rimuovere
     * @return true se l'attività è stata rimossa, false se non era presente
     * @throws IllegalArgumentException se l'attività è null
     */
    public boolean removeAttivitaSportiva(AttivitaSportiva attivita) {
        if (attivita == null) {
            throw new IllegalArgumentException("L'attività sportiva non può essere null");
        }
        
        return attivitaSportive.remove(attivita);
    }
    
    /**
     * Verifica se l'iscritto pratica una specifica attività.
     * 
     * @param attivita Attività da verificare
     * @return true se l'iscritto pratica l'attività, false altrimenti
     */
    public boolean praticaAttivita(AttivitaSportiva attivita) {
        return attivita != null && attivitaSportive.contains(attivita);
    }
    
    /**
     * Verifica se l'iscritto pratica un'attività con il nome specificato.
     * 
     * @param nomeAttivita Nome dell'attività da verificare
     * @return true se l'iscritto pratica l'attività, false altrimenti
     */
    public boolean praticaAttivita(String nomeAttivita) {
        if (nomeAttivita == null || nomeAttivita.trim().isEmpty()) {
            return false;
        }
        
        return attivitaSportive.stream()
                .anyMatch(attivita -> attivita.getNome().equalsIgnoreCase(nomeAttivita.trim()));
    }
    
    /**
     * Calcola la retta mensile totale per tutte le attività praticate.
     * 
     * @return Somma dei costi mensili di tutte le attività
     */
    public double calcolaRettaMensile() {
        return attivitaSportive.stream()
                .mapToDouble(AttivitaSportiva::getCostoMensile)
                .sum();
    }
    
    /**
     * Restituisce il numero di attività sportive praticate.
     * 
     * @return Numero di attività sportive
     */
    public int getNumeroAttivita() {
        return attivitaSportive.size();
    }
    
    /**
     * Restituisce una rappresentazione testuale dell'iscritto.
     * 
     * @return String con informazioni complete dell'iscritto
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Iscritto: %s %s (Matricola: %s)", nome, cognome, matricola));
        sb.append(String.format("\nAttività praticate: %d", attivitaSportive.size()));
        
        if (!attivitaSportive.isEmpty()) {
            sb.append("\n- ");
            sb.append(String.join("\n- ", 
                attivitaSportive.stream()
                    .map(AttivitaSportiva::toString)
                    .toArray(String[]::new)));
        }
        
        sb.append(String.format("\nRetta mensile totale: €%.2f", calcolaRettaMensile()));
        
        return sb.toString();
    }
    
    /**
     * Verifica l'uguaglianza con un altro oggetto.
     * Due iscritti sono uguali se hanno la stessa matricola.
     * 
     * @param obj Oggetto da confrontare
     * @return true se sono uguali, false altrimenti
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Iscritto iscritto = (Iscritto) obj;
        return matricola.equals(iscritto.matricola);
    }
    
    /**
     * Calcola l'hash code basato sulla matricola.
     * 
     * @return Hash code dell'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(matricola);
    }
} 