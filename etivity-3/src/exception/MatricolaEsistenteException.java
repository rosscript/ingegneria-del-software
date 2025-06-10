package exception;

/**
 * Eccezione lanciata quando si tenta di registrare un iscritto 
 * con una matricola già presente nel sistema.
 * 
 * @author Luigi Rosato
 * @version 1.0
 */
public class MatricolaEsistenteException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Costruttore con messaggio personalizzato.
     * 
     * @param messaggio Messaggio descrittivo dell'errore
     */
    public MatricolaEsistenteException(String messaggio) {
        super(messaggio);
    }
    
    /**
     * Costruttore con messaggio e causa.
     * 
     * @param messaggio Messaggio descrittivo dell'errore
     * @param causa Causa dell'eccezione
     */
    public MatricolaEsistenteException(String messaggio, Throwable causa) {
        super(messaggio, causa);
    }
} 