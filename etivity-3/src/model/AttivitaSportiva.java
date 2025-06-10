package model;

import java.util.Objects;

/**
 * Classe che rappresenta un'attività sportiva offerta dalla cittadella.
 * Ogni attività ha un nome identificativo e un costo mensile associato.
 * 
 * @author Luigi Rosato
 * @version 1.0
 */
public class AttivitaSportiva {
    
    // Attributi privati per incapsulamento
    private String nome;
    private double costoMensile;
    
    /**
     * Costruttore per creare un'attività sportiva.
     * 
     * @param nome Nome dell'attività sportiva
     * @param costoMensile Costo mensile in euro
     * @throws IllegalArgumentException se il nome è null/vuoto o il costo è negativo
     */
    public AttivitaSportiva(String nome, double costoMensile) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome dell'attività non può essere vuoto");
        }
        if (costoMensile < 0) {
            throw new IllegalArgumentException("Il costo mensile non può essere negativo");
        }
        
        this.nome = nome.trim();
        this.costoMensile = costoMensile;
    }
    
    /**
     * Restituisce il nome dell'attività sportiva.
     * 
     * @return Nome dell'attività
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Restituisce il costo mensile dell'attività.
     * 
     * @return Costo mensile in euro
     */
    public double getCostoMensile() {
        return costoMensile;
    }
    
    /**
     * Modifica il costo mensile dell'attività.
     * 
     * @param costoMensile Nuovo costo mensile
     * @throws IllegalArgumentException se il costo è negativo
     */
    public void setCostoMensile(double costoMensile) {
        if (costoMensile < 0) {
            throw new IllegalArgumentException("Il costo mensile non può essere negativo");
        }
        this.costoMensile = costoMensile;
    }
    
    /**
     * Restituisce una rappresentazione testuale dell'attività.
     * 
     * @return String nel formato "nome (€costo/mese)"
     */
    @Override
    public String toString() {
        return String.format("%s (€%.2f/mese)", nome, costoMensile);
    }
    
    /**
     * Verifica l'uguaglianza con un altro oggetto.
     * Due attività sono uguali se hanno lo stesso nome (case-insensitive).
     * 
     * @param obj Oggetto da confrontare
     * @return true se sono uguali, false altrimenti
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        AttivitaSportiva that = (AttivitaSportiva) obj;
        return nome.equalsIgnoreCase(that.nome);
    }
    
    /**
     * Calcola l'hash code basato sul nome dell'attività.
     * 
     * @return Hash code dell'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase());
    }
} 