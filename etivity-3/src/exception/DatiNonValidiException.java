package exception;

/**
 * Eccezione lanciata quando vengono inseriti dati non validi
 * nei form dell'interfaccia utente.
 * 
 * @author Luigi Rosato
 * @version 1.0
 */
public class DatiNonValidiException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Costruttore con messaggio personalizzato.
     * 
     * @param messaggio Messaggio descrittivo dell'errore
     */
    public DatiNonValidiException(String messaggio) {
        super(messaggio);
    }
    
    /**
     * Costruttore con messaggio e causa.
     * 
     * @param messaggio Messaggio descrittivo dell'errore
     * @param causa Causa dell'eccezione
     */
    public DatiNonValidiException(String messaggio, Throwable causa) {
        super(messaggio, causa);
    }
} 