package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test JUnit per la classe Iscritto.
 * Verifica il corretto funzionamento di tutti i metodi della classe.
 * 
 * @author Luigi Rosato
 * @version 1.0
 */
@DisplayName("Test per Iscritto")
class IscrittoTest {
    
    private Iscritto iscritto;
    private AttivitaSportiva nuoto;
    private AttivitaSportiva atletica;
    private AttivitaSportiva bodyBuilding;
    
    @BeforeEach
    void setUp() {
        iscritto = new Iscritto("Mario", "Rossi", "IN12345");
        nuoto = new AttivitaSportiva("Nuoto", 25.0);
        atletica = new AttivitaSportiva("Atletica leggera", 40.0);
        bodyBuilding = new AttivitaSportiva("Body building", 50.0);
    }
    
    @Test
    @DisplayName("Costruttore valido")
    void testCostruttoreValido() {
        assertNotNull(iscritto);
        assertEquals("Mario", iscritto.getNome());
        assertEquals("Rossi", iscritto.getCognome());
        assertEquals("IN12345", iscritto.getMatricola());
        assertTrue(iscritto.getAttivitaSportive().isEmpty());
    }
    
    @Test
    @DisplayName("Costruttore con nome null")
    void testCostruttoreNomeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Iscritto(null, "Rossi", "IN12345");
        });
    }
    
    @Test
    @DisplayName("Costruttore con cognome vuoto")
    void testCostruttoreCognomeVuoto() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Iscritto("Mario", "   ", "IN12345");
        });
    }
    
    @Test
    @DisplayName("Costruttore con matricola null")
    void testCostruttoreMatricolaNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Iscritto("Mario", "Rossi", null);
        });
    }
    
    @Test
    @DisplayName("Matricola normalizzata in maiuscolo")
    void testMatricolaMaiuscolo() {
        Iscritto iscritto = new Iscritto("Mario", "Rossi", "in12345");
        assertEquals("IN12345", iscritto.getMatricola());
    }
    
    @Test
    @DisplayName("Trim dei parametri nel costruttore")
    void testTrimParametri() {
        Iscritto iscritto = new Iscritto("  Mario  ", "  Rossi  ", "  IN12345  ");
        assertEquals("Mario", iscritto.getNome());
        assertEquals("Rossi", iscritto.getCognome());
        assertEquals("IN12345", iscritto.getMatricola());
    }
    
    @Test
    @DisplayName("Nome completo")
    void testNomeCompleto() {
        assertEquals("Mario Rossi", iscritto.getNomeCompleto());
    }
    
    @Test
    @DisplayName("Aggiunta attività sportiva")
    void testAggiuntaAttivitaSportiva() {
        iscritto.addAttivitaSportiva(nuoto);
        assertEquals(1, iscritto.getNumeroAttivita());
        assertTrue(iscritto.praticaAttivita(nuoto));
    }
    
    @Test
    @DisplayName("Aggiunta attività null")
    void testAggiuntaAttivitaNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            iscritto.addAttivitaSportiva(null);
        });
    }
    
    @Test
    @DisplayName("Aggiunta attività duplicata")
    void testAggiuntaAttivitaDuplicata() {
        iscritto.addAttivitaSportiva(nuoto);
        assertThrows(IllegalStateException.class, () -> {
            iscritto.addAttivitaSportiva(nuoto);
        });
    }
    
    @Test
    @DisplayName("Rimozione attività sportiva")
    void testRimozioneAttivitaSportiva() {
        iscritto.addAttivitaSportiva(nuoto);
        assertTrue(iscritto.removeAttivitaSportiva(nuoto));
        assertEquals(0, iscritto.getNumeroAttivita());
        assertFalse(iscritto.praticaAttivita(nuoto));
    }
    
    @Test
    @DisplayName("Rimozione attività non presente")
    void testRimozioneAttivitaNonPresente() {
        assertFalse(iscritto.removeAttivitaSportiva(nuoto));
    }
    
    @Test
    @DisplayName("Rimozione attività null")
    void testRimozioneAttivitaNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            iscritto.removeAttivitaSportiva(null);
        });
    }
    
    @Test
    @DisplayName("Pratica attività per nome")
    void testPraticaAttivitaPerNome() {
        iscritto.addAttivitaSportiva(nuoto);
        assertTrue(iscritto.praticaAttivita("Nuoto"));
        assertTrue(iscritto.praticaAttivita("NUOTO")); // Case insensitive
        assertFalse(iscritto.praticaAttivita("Atletica"));
    }
    
    @Test
    @DisplayName("Pratica attività con nome null")
    void testPraticaAttivitaNomeNull() {
        assertFalse(iscritto.praticaAttivita((String) null));
    }
    
    @Test
    @DisplayName("Pratica attività con nome vuoto")
    void testPraticaAttivitaNomeVuoto() {
        assertFalse(iscritto.praticaAttivita("   "));
    }
    
    @Test
    @DisplayName("Calcolo retta mensile singola attività")
    void testCalcoloRettaMensileSingola() {
        iscritto.addAttivitaSportiva(nuoto);
        assertEquals(25.0, iscritto.calcolaRettaMensile());
    }
    
    @Test
    @DisplayName("Calcolo retta mensile più attività")
    void testCalcoloRettaMensileMultipla() {
        iscritto.addAttivitaSportiva(nuoto);
        iscritto.addAttivitaSportiva(atletica);
        iscritto.addAttivitaSportiva(bodyBuilding);
        assertEquals(115.0, iscritto.calcolaRettaMensile()); // 25 + 40 + 50
    }
    
    @Test
    @DisplayName("Calcolo retta mensile senza attività")
    void testCalcoloRettaMensileSenzaAttivita() {
        assertEquals(0.0, iscritto.calcolaRettaMensile());
    }
    
    @Test
    @DisplayName("Numero attività")
    void testNumeroAttivita() {
        assertEquals(0, iscritto.getNumeroAttivita());
        
        iscritto.addAttivitaSportiva(nuoto);
        assertEquals(1, iscritto.getNumeroAttivita());
        
        iscritto.addAttivitaSportiva(atletica);
        assertEquals(2, iscritto.getNumeroAttivita());
    }
    
    @Test
    @DisplayName("Lista attività è copia")
    void testListaAttivitaCopia() {
        iscritto.addAttivitaSportiva(nuoto);
        var lista = iscritto.getAttivitaSportive();
        
        // Modifica della lista restituita non deve influenzare l'iscritto
        lista.clear();
        assertEquals(1, iscritto.getNumeroAttivita());
    }
    
    @Test
    @DisplayName("ToString con attività")
    void testToStringConAttivita() {
        iscritto.addAttivitaSportiva(nuoto);
        iscritto.addAttivitaSportiva(atletica);
        
        String result = iscritto.toString();
        assertTrue(result.contains("Mario Rossi"));
        assertTrue(result.contains("IN12345"));
        assertTrue(result.contains("2"));
        assertTrue(result.contains("€65,00")); // 25 + 40
    }
    
    @Test
    @DisplayName("ToString senza attività")
    void testToStringSenzaAttivita() {
        String result = iscritto.toString();
        assertTrue(result.contains("Mario Rossi"));
        assertTrue(result.contains("IN12345"));
        assertTrue(result.contains("0"));
        assertTrue(result.contains("€0,00"));
    }
    
    @Test
    @DisplayName("Equals con stessa matricola")
    void testEqualsStessaMatricola() {
        Iscritto altro = new Iscritto("Luigi", "Verdi", "IN12345");
        assertTrue(iscritto.equals(altro));
    }
    
    @Test
    @DisplayName("Equals con matricola diversa")
    void testEqualsMatricolaDiversa() {
        Iscritto altro = new Iscritto("Mario", "Rossi", "IN54321");
        assertFalse(iscritto.equals(altro));
    }
    
    @Test
    @DisplayName("Equals con null")
    void testEqualsNull() {
        assertFalse(iscritto.equals(null));
    }
    
    @Test
    @DisplayName("Equals stesso oggetto")
    void testEqualsStessoOggetto() {
        assertTrue(iscritto.equals(iscritto));
    }
    
    @Test
    @DisplayName("HashCode consistenza")
    void testHashCodeConsistenza() {
        Iscritto altro = new Iscritto("Luigi", "Verdi", "IN12345");
        assertEquals(iscritto.hashCode(), altro.hashCode());
    }
} 