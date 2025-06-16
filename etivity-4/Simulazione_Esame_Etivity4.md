# Etivity 4 - Simulazione d'Esame
## Ingegneria del Software

### 👨‍🎓 Informazioni Studente
- **Nome**: Luigi Rosato
- **Matricola**: IN32000141
- **Data Appello**: 16.06.2025
- **Corso**: Ingegneria del Software

---

## 📋 PROVA 1: Modello di Sviluppo a Cascata

### 🏗️ Struttura del Modello a Cascata

Il **modello a cascata** (Waterfall Model) è un modello di processo software sequenziale e lineare, proposto da Winston Royce nel 1970. È caratterizzato da una progressione unidirezionale attraverso fasi distinte e ben definite.

#### 📊 Fasi del Modello a Cascata:

1. **Analisi e Specifica dei Requisiti**
2. **Progettazione del Sistema** 
3. **Progettazione Dettagliata**
4. **Implementazione e Codifica**
5. **Testing e Integrazione**
6. **Distribuzione e Manutenzione**

### ⚙️ Attività Associate alle Fasi

#### 1️⃣ **Analisi e Specifica dei Requisiti**
- **Input**: Richieste del cliente, documenti di business
- **Attività**: 
  - Raccolta requisiti funzionali e non funzionali
  - Analisi di fattibilità
  - Definizione dell'ambito del sistema
- **Output**: Documento SRS (Software Requirements Specification)

#### 2️⃣ **Progettazione del Sistema**
- **Input**: SRS
- **Attività**:
  - Definizione architettura di alto livello
  - Identificazione componenti principali
  - Definizione interfacce tra moduli
- **Output**: Documento di architettura del sistema

#### 3️⃣ **Progettazione Dettagliata**
- **Input**: Architettura del sistema
- **Attività**:
  - Progettazione dettagliata dei moduli
  - Definizione algoritmi e strutture dati
  - Specifica interfacce dettagliate
- **Output**: Specifiche tecniche dettagliate

#### 4️⃣ **Implementazione e Codifica**
- **Input**: Specifiche tecniche
- **Attività**:
  - Scrittura del codice
  - Compilazione e linking
  - Unit testing di base
- **Output**: Codice sorgente e eseguibili

#### 5️⃣ **Testing e Integrazione**
- **Input**: Moduli software
- **Attività**:
  - Integration testing
  - System testing
  - Acceptance testing
- **Output**: Sistema testato e validato

#### 6️⃣ **Distribuzione e Manutenzione**
- **Input**: Sistema testato
- **Attività**:
  - Deploy in produzione
  - Manutenzione correttiva
  - Manutenzione evolutiva
- **Output**: Sistema in produzione

### 🚫 Limite Principale del Modello a Cascata

Il **limite principale** del modello a cascata è la **rigidità e mancanza di flessibilità**:

- **Non gestisce i cambiamenti**: Una volta completata una fase, è molto costoso tornare indietro
- **Feedback tardivo**: Il cliente vede il prodotto solo alla fine
- **Rischio elevato**: Gli errori nelle prime fasi si propagano e costano molto
- **Inadatto per progetti complessi**: Non adatto quando i requisiti non sono chiari all'inizio
- **Mancanza di iterazioni**: Non permette raffinamenti incrementali

---

## 📋 PROVA 2: Analisi e Specifica dei Requisiti

### 🎯 Cosa Consiste la Fase

La fase di **Analisi e Specifica dei Requisiti** è il processo sistematico di:
- **Identificazione** delle necessità degli stakeholder
- **Analisi** e **comprensione** del problema da risolvere
- **Documentazione** formale di ciò che il sistema deve fare
- **Validazione** con gli stakeholder

### 📤 Output Prodotti

#### 1️⃣ **Documento SRS (Software Requirements Specification)**
- Requisiti funzionali dettagliati
- Requisiti non funzionali (performance, sicurezza, usabilità)
- Vincoli di sistema
- Assunzioni e dipendenze

#### 2️⃣ **Modelli di Analisi**
- Diagrammi dei casi d'uso
- Modelli del dominio
- Diagrammi di contesto
- Prototipi a bassa fedeltà

#### 3️⃣ **Glossario e Dizionario Dati**
- Definizioni della terminologia di dominio
- Descrizione delle entità principali
- Regole di business

#### 4️⃣ **Criteri di Accettazione**
- Scenari di test di accettazione
- Definizione di "done"
- Metriche di qualità

### 🛠️ Strumenti Utilizzati

#### **Tecniche di Elicitazione:**
- **Interviste strutturate** e semi-strutturate
- **Questionari** e survey
- **Workshop** con stakeholder
- **Osservazione** sul campo
- **Analisi documenti** esistenti
- **Brainstorming** sessions

#### **Strumenti di Modellazione:**
- **UML** (Unified Modeling Language)
- **BPMN** (Business Process Model Notation)
- **User Stories** e Epic
- **Wireframes** e mockup
- **Prototipazione** rapida

#### **Strumenti Software:**
- **Requirements management tools** (Jira, Rational DOORS)
- **Diagramming tools** (Visio, Lucidchart, StarUML)
- **Collaboration platforms** (Confluence, SharePoint)
- **Version control** per documenti (Git, SVN)

---

## 📋 PROVA 3: Information Hiding nella Progettazione OO

### 🔐 Concetto di Information Hiding

L'**Information Hiding** è un principio fondamentale della progettazione Object-Oriented che consiste nel:

**Nascondere i dettagli implementativi interni di un modulo/classe e esporre solo un'interfaccia pubblica ben definita.**

### 🎯 Obiettivi Principali

#### 1️⃣ **Riduzione della Complessità**
- Ogni modulo espone solo ciò che è necessario
- Semplifica l'utilizzo delle classi
- Riduce il carico cognitivo dello sviluppatore

#### 2️⃣ **Manutenibilità**
- Modifiche interne non impattano il codice client
- Riduce l'accoppiamento tra moduli
- Facilita refactoring e ottimizzazioni

#### 3️⃣ **Robustezza**
- Previene accessi non autorizzati ai dati
- Mantiene l'invariante degli oggetti
- Riduce gli errori di programmazione

### 🔧 Implementazione in OOP

#### **Incapsulamento:**
```java
public class ContoCorrente {
    private double saldo;           // Nascosto
    private String numeroConto;     // Nascosto
    
    // Interfaccia pubblica
    public void deposita(double importo) { ... }
    public boolean preleva(double importo) { ... }
    public double getSaldo() { ... }
}
```

#### **Livelli di Visibilità:**
- **Private**: Visibile solo nella classe
- **Protected**: Visibile nelle sottoclassi
- **Package**: Visibile nel package
- **Public**: Visibile ovunque

#### **Interfacce e Classi Astratte:**
```java
public interface DispositivoPagamento {
    boolean effettuaPagamento(double importo);
}

// Implementazioni nascoste
class CartaCredito implements DispositivoPagamento { ... }
class PayPal implements DispositivoPagamento { ... }
```

### ✅ Vantaggi dell'Information Hiding

- **Modularità**: Codice più organizzato e modulare
- **Riusabilità**: Componenti riutilizzabili in contesti diversi
- **Testabilità**: Facilita unit testing e mock objects
- **Evoluzione**: Permette evoluzione indipendente dei moduli
- **Sicurezza**: Previene manipolazioni indesiderate

---

## 📋 PROVA 4: Test White Box

### 🔍 Cosa Sono i Test White Box

I **test White Box** (o **Structural Testing**) sono una metodologia di testing in cui:

**Il tester ha completa visibilità del codice sorgente e progetta i test basandosi sulla struttura interna del software.**

### 🎯 Caratteristiche Principali

#### **Conoscenza Completa:**
- Accesso al codice sorgente
- Comprensione della logica interna
- Visibilità delle strutture dati

#### **Focus sulla Copertura:**
- Copertura delle istruzioni (Statement Coverage)
- Copertura delle decisioni (Branch Coverage)  
- Copertura dei cammini (Path Coverage)
- Copertura delle condizioni (Condition Coverage)

### 🔄 Come Si Svolgono

#### 1️⃣ **Analisi del Codice**
```java
public int calcolaSconto(int eta, boolean isStudente) {
    int sconto = 0;
    if (eta < 18) {              // Branch 1
        sconto = 20;
    } else if (eta > 65) {       // Branch 2
        sconto = 15;
    }
    if (isStudente) {            // Branch 3
        sconto += 10;
    }
    return sconto;
}
```

#### 2️⃣ **Identificazione Cammini**
- **Cammino 1**: eta < 18, isStudente = true → sconto = 30
- **Cammino 2**: eta < 18, isStudente = false → sconto = 20
- **Cammino 3**: eta > 65, isStudente = true → sconto = 25
- **Cammino 4**: eta > 65, isStudente = false → sconto = 15
- **Cammino 5**: 18 ≤ eta ≤ 65, isStudente = true → sconto = 10
- **Cammino 6**: 18 ≤ eta ≤ 65, isStudente = false → sconto = 0

#### 3️⃣ **Progettazione Test Case**
```java
@Test
public void testMinorenne_Studente() {
    assertEquals(30, calcolaSconto(16, true));
}

@Test  
public void testAnziano_NonStudente() {
    assertEquals(15, calcolaSconto(70, false));
}
```

#### 4️⃣ **Misurazione Copertura**
- **Statement Coverage**: % istruzioni eseguite
- **Branch Coverage**: % decisioni testate
- **Path Coverage**: % cammini coperti

### 🛠️ Tecniche Specifiche

#### **Control Flow Testing:**
- Analisi grafo di controllo
- Copertura di nodi e archi
- Identificazione cammini indipendenti

#### **Data Flow Testing:**
- Def-Use chains
- All-defs criterion
- All-uses criterion

#### **Loop Testing:**
- Simple loops
- Nested loops  
- Concatenated loops

### ✅ Vantaggi e ❌ Svantaggi

**✅ Vantaggi:**
- Copertura sistematica del codice
- Identificazione codice non utilizzato
- Validazione logica complessa
- Ottimizzazione test suite

**❌ Svantaggi:**  
- Non rileva funzionalità mancanti
- Bias verso implementazione corrente
- Costoso da mantenere
- Richiede competenze tecniche elevate

---

## 📋 PROVA 5: Esercizio UML - Sistema POS

### 🏪 Analisi del Sistema

**Contesto:** Catena di negozi con registratori di cassa (POS) intelligenti collegati a calcolatori locali e centrali.

### 🎭 Identificazione Attori

#### **Attori Primari:**
- **👤 Cassiere**: Opera il POS per transazioni
- **👨‍💼 Manager Negozio**: Monitora totali e statistiche
- **🔧 Amministratore Sistema**: Gestisce configurazioni

#### **Attori Secondari:**
- **🖥️ Calcolatore Negozio**: Sistema locale
- **🌐 Calcolatore Centrale**: Sistema centrale
- **🖨️ Stampante**: Dispositivo stampa scontrini
- **📱 Lettore Codici**: Scanner barcode
- **⌨️ Tastiera POS**: Interfaccia input

### 🏢 Confini del Sistema

Il **confine del sistema** comprende:
- **POS (Point of Sale)** - Sistema principale
- **Interfacce hardware** (stampante, scanner, tastiera)
- **Connettività** al calcolatore del negozio

**Fuori dal confine:**
- Calcolatore del negozio (sistema esterno)
- Calcolatore centrale (sistema esterno)
- Processi di business del negozio

### 📊 Casi d'Uso Identificati

#### **UC1: Gestione Autenticazione**
- **Attore**: Cassiere
- **Descrizione**: Login, logout, spegnimento POS

#### **UC2: Elaborazione Vendita**  
- **Attore**: Cassiere, Lettore Codici
- **Descrizione**: Scansione prodotti, calcolo totale

#### **UC3: Chiusura Scontrino**
- **Attore**: Cassiere, Stampante, Calcolatore Negozio
- **Descrizione**: Finalizzazione vendita e stampa

#### **UC4: Stampa Totale POS**
- **Attore**: Cassiere, Stampante  
- **Descrizione**: Stampa totale cumulativo del singolo POS

#### **UC5: Stampa Totale Negozio**
- **Attore**: Manager, Calcolatore Negozio, Stampante
- **Descrizione**: Stampa totale di tutti i POS del negozio

#### **UC6: Lettura Codice a Barre**
- **Attore**: Lettore Codici
- **Descrizione**: Scansione e invio codice al POS

#### **UC7: Invio Dati al Sistema**
- **Attore**: Calcolatore Negozio
- **Descrizione**: Trasmissione totali al sistema centrale

---

## 🎯 Conclusioni

Questa simulazione d'esame ha coperto tutti gli aspetti fondamentali dell'Ingegneria del Software:

1. **✅ Modelli di Processo**: Comprensione del waterfall e sue limitazioni
2. **✅ Requirements Engineering**: Tecniche e strumenti per l'analisi requisiti  
3. **✅ Design Principles**: Information hiding e principi OO
4. **✅ Testing**: Metodologie white box e copertura del codice
5. **✅ UML Modeling**: Analisi e modellazione di sistemi reali

---

**Autore**: Luigi Rosato - Matricola: IN32000141  
**Data**: 2024  
**Corso**: Ingegneria del Software - Etivity 4 
