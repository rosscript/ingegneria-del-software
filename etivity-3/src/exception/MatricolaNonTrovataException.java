package exception;

/**
 * Eccezione lanciata quando si cerca un iscritto 
 * con una matricola non presente nel sistema.
 * 
 * @author Luigi Rosato
 * @version 1.0
 */
public class MatricolaNonTrovataException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Costruttore con messaggio personalizzato.
     * 
     * @param messaggio Messaggio descrittivo dell'errore
     */
    public MatricolaNonTrovataException(String messaggio) {
        super(messaggio);
    }
    
    /**
     * Costruttore con messaggio e causa.
     * 
     * @param messaggio Messaggio descrittivo dell'errore
     * @param causa Causa dell'eccezione
     */
    public MatricolaNonTrovataException(String messaggio, Throwable causa) {
        super(messaggio, causa);
    }
} 