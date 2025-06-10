package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test JUnit per la classe AttivitaSportiva.
 * Verifica il corretto funzionamento di tutti i metodi della classe.
 * 
 * @author Luigi Rosato
 * @version 1.0
 */
@DisplayName("Test per AttivitaSportiva")
class AttivitaSportivaTest {
    
    private AttivitaSportiva nuoto;
    private AttivitaSportiva atletica;
    
    @BeforeEach
    void setUp() {
        nuoto = new AttivitaSportiva("Nuoto", 25.0);
        atletica = new AttivitaSportiva("Atletica leggera", 40.0);
    }
    
    @Test
    @DisplayName("Costruttore valido")
    void testCostruttoreValido() {
        assertNotNull(nuoto);
        assertEquals("Nuoto", nuoto.getNome());
        assertEquals(25.0, nuoto.getCostoMensile());
    }
    
    @Test
    @DisplayName("Costruttore con nome null")
    void testCostruttoreNomeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AttivitaSportiva(null, 25.0);
        });
    }
    
    @Test
    @DisplayName("Costruttore con nome vuoto")
    void testCostruttoreNomeVuoto() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AttivitaSportiva("   ", 25.0);
        });
    }
    
    @Test
    @DisplayName("Costruttore con costo negativo")
    void testCostruttoreCostoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AttivitaSportiva("Nuoto", -10.0);
        });
    }
    
    @Test
    @DisplayName("Costruttore con costo zero")
    void testCostruttoreCostoZero() {
        assertDoesNotThrow(() -> {
            new AttivitaSportiva("Attività Gratuita", 0.0);
        });
    }
    
    @Test
    @DisplayName("Getter nome")
    void testGetNome() {
        assertEquals("Nuoto", nuoto.getNome());
        assertEquals("Atletica leggera", atletica.getNome());
    }
    
    @Test
    @DisplayName("Getter costo mensile")
    void testGetCostoMensile() {
        assertEquals(25.0, nuoto.getCostoMensile());
        assertEquals(40.0, atletica.getCostoMensile());
    }
    
    @Test
    @DisplayName("Setter costo mensile valido")
    void testSetCostoMensileValido() {
        nuoto.setCostoMensile(30.0);
        assertEquals(30.0, nuoto.getCostoMensile());
    }
    
    @Test
    @DisplayName("Setter costo mensile negativo")
    void testSetCostoMensileNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            nuoto.setCostoMensile(-5.0);
        });
    }
    
    @Test
    @DisplayName("ToString")
    void testToString() {
        String expected = "Nuoto (€25,00/mese)";
        assertEquals(expected, nuoto.toString());
    }
    
    @Test
    @DisplayName("Equals - oggetti uguali")
    void testEqualsOggettiUguali() {
        AttivitaSportiva nuoto2 = new AttivitaSportiva("Nuoto", 30.0);
        assertTrue(nuoto.equals(nuoto2));
    }
    
    @Test
    @DisplayName("Equals - case insensitive")
    void testEqualsCaseInsensitive() {
        AttivitaSportiva nuoto2 = new AttivitaSportiva("NUOTO", 30.0);
        assertTrue(nuoto.equals(nuoto2));
    }
    
    @Test
    @DisplayName("Equals - oggetti diversi")
    void testEqualsOggettiDiversi() {
        assertFalse(nuoto.equals(atletica));
    }
    
    @Test
    @DisplayName("Equals - con null")
    void testEqualsConNull() {
        assertFalse(nuoto.equals(null));
    }
    
    @Test
    @DisplayName("Equals - con oggetto di classe diversa")
    void testEqualsClasseDiversa() {
        assertFalse(nuoto.equals("Nuoto"));
    }
    
    @Test
    @DisplayName("Equals - stesso oggetto")
    void testEqualsStessoOggetto() {
        assertTrue(nuoto.equals(nuoto));
    }
    
    @Test
    @DisplayName("HashCode - consistenza")
    void testHashCodeConsistenza() {
        AttivitaSportiva nuoto2 = new AttivitaSportiva("Nuoto", 30.0);
        assertEquals(nuoto.hashCode(), nuoto2.hashCode());
    }
    
    @Test
    @DisplayName("HashCode - case insensitive")
    void testHashCodeCaseInsensitive() {
        AttivitaSportiva nuoto2 = new AttivitaSportiva("NUOTO", 30.0);
        assertEquals(nuoto.hashCode(), nuoto2.hashCode());
    }
    
    @Test
    @DisplayName("Trim del nome nel costruttore")
    void testTrimNomeCostruttore() {
        AttivitaSportiva attivita = new AttivitaSportiva("  Calcio  ", 35.0);
        assertEquals("Calcio", attivita.getNome());
    }
} 