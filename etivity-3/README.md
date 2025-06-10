# Etivity 3 - Implementazione Sistema Java
## Gestione Cittadella Sportiva Universitaria

### 👨‍🎓 Informazioni Studente
- **Nome**: Luigi Rosato
- **Matricola**: IN32000141
- **Corso**: Ingegneria del Software
- **Etivity**: 3 - Implementazione di un sistema completo in linguaggio Java

---

## 📋 Descrizione del Progetto

Implementazione completa in linguaggio Java del sistema di gestione per una cittadella sportiva universitaria, basato sulla progettazione sviluppata nell'Etivity 2.

### 🎯 Obiettivi Raggiunti

- ✅ **Implementazione Object-Oriented**: Classi progettate secondo i principi OOP
- ✅ **Pattern di Design**: Utilizzo del pattern Facade nel `SistemaCittadella`
- ✅ **Gestione Eccezioni**: Eccezioni personalizzate per situazioni specifiche
- ✅ **Unit Testing**: Test JUnit 5 per le classi del dominio
- ✅ **Documentazione**: Commenti Javadoc completi
- ✅ **Compatibilità Eclipse**: Progetto configurato per Eclipse IDE

---

## 🏗️ Architettura del Sistema

### 📦 Struttura dei Package

```
src/
├── model/                          # Classi del dominio
│   ├── AttivitaSportiva.java      # Attività sportive disponibili  
│   └── Iscritto.java              # Iscritti alla cittadella
├── business/                       # Logica di business
│   ├── GestioneIscritti.java      # Gestione collezione iscritti
│   └── SistemaCittadella.java     # Facade principale del sistema
├── exception/                      # Eccezioni personalizzate
│   ├── MatricolaEsistenteException.java
│   ├── MatricolaNonTrovataException.java
│   └── DatiNonValidiException.java
└── MainConsole.java               # Applicazione console per test

test/
└── model/                         # Test JUnit
    ├── AttivitaSportivaTest.java  # Test per AttivitaSportiva
    └── IscrittoTest.java          # Test per Iscritto
```

### 🎨 Pattern di Progettazione Utilizzati

1. **Facade Pattern**: `SistemaCittadella` espone un'interfaccia semplificata
2. **Value Object**: `AttivitaSportiva` è immutabile (eccetto il costo)
3. **Collection Wrapper**: Restituzione di copie delle collezioni per incapsulamento

---

## ⚙️ Funzionalità Implementate

### 🔧 Operazioni Principali

1. **Registrazione Iscritti**
   - Validazione dati anagrafici
   - Controllo univocità matricola
   - Associazione attività sportive

2. **Ricerca e Gestione**
   - Ricerca per matricola (O(1) con HashMap)
   - Calcolo retta mensile automatico
   - Filtraggio iscritti per attività

3. **Reporting e Statistiche**
   - Lista iscritti per attività
   - Statistiche di utilizzo
   - Calcolo fatturato mensile

### 💰 Attività Sportive (come da requisiti)

| Attività | Costo Mensile |
|----------|---------------|
| Nuoto | €25,00 |
| Atletica leggera | €40,00 |
| Body building | €50,00 |

---

## 🧪 Testing

### ✅ Test Coverage

- **AttivitaSportivaTest**: 15+ test case
  - Validazione costruttore
  - Test getter/setter
  - Verifica equals/hashCode
  - Gestione errori

- **IscrittoTest**: 20+ test case  
  - Costruzione oggetti
  - Gestione attività sportive
  - Calcolo retta mensile
  - Metodi di utilità

### 🚀 Esecuzione Test

```bash
# In Eclipse:
# Tasto destro su progetto → Run As → JUnit Test

# Da command line (se configurato Maven/Gradle):
mvn test
```

---

## 💻 Utilizzo del Sistema

### 🖥️ Applicazione Console

Il sistema include un'applicazione console (`MainConsole.java`) con menu interattivo:

```
================== MENU PRINCIPALE ==================
1. Nuova iscrizione
2. Ricerca iscritto per matricola  
3. Calcola retta mensile
4. Lista iscritti per attività
5. Mostra statistiche
6. Mostra tutti gli iscritti
7. Mostra attività disponibili
0. Esci
```

### 📊 Dati di Esempio

Il sistema si avvia con 3 iscritti pre-caricati per facilitare i test:
- Luigi Rosato (IN32000141) - Nuoto + Atletica leggera
- Mario Rossi (IN12345) - Body building  
- Anna Verdi (IN54321) - Nuoto + Body building

---

## 🔧 Configurazione Eclipse

### 📥 Importazione Progetto

1. **File** → **Import** → **Existing Projects into Workspace**
2. Seleziona la cartella `etivity-3`
3. Il progetto è configurato con:
   - Java 11+
   - JUnit 5
   - Source folder: `src` e `test`

### ⚙️ Configurazione JVM

Il progetto richiede:
- **Java 11 o superiore**
- **JUnit 5** (incluso nel classpath)

---

## 📈 Caratteristiche Tecniche

### 🏆 Best Practices Implementate

- **Immutabilità**: Le collezioni sono sempre copiate prima della restituzione
- **Validazione**: Controlli rigorosi sui parametri di input
- **Fail-Fast**: Eccezioni immediate in caso di errori
- **Separation of Concerns**: Separazione netta tra livelli
- **Single Responsibility**: Ogni classe ha una responsabilità specifica

### 📝 Convenzioni di Codice

- **Javadoc** completo per tutte le classi e metodi pubblici
- **Nomi descrittivi** per variabili e metodi
- **Gestione eccezioni** robusta e informativa
- **Costanti** per valori magici
- **Logging** tramite System.out per semplicità

---

## 🚀 Esecuzione

### ▶️ Avvio Applicazione Console

```bash
# Compilazione
javac -cp ".:lib/*" src/*.java src/**/*.java

# Esecuzione  
java -cp ".:src:lib/*" MainConsole
```

### 🧪 Esecuzione Test

```bash
# Compilation dei test
javac -cp ".:src:test:lib/*" test/**/*.java

# Esecuzione test JUnit
java -cp ".:src:test:lib/*" org.junit.platform.console.ConsoleLauncher --scan-classpath
```

---

## 📚 Requisiti di Sistema

- **Java**: 11 o superiore
- **IDE**: Eclipse (configurazione inclusa) o qualsiasi IDE Java
- **Testing**: JUnit 5
- **OS**: Windows, macOS, Linux (cross-platform)

---

## 🎓 Note Didattiche

Questo progetto dimostra:

1. **Applicazione pratica** dei concetti OOP
2. **Implementazione** di design pattern appropriati  
3. **Testing sistematico** con JUnit
4. **Gestione errori** professionale
5. **Documentazione** completa del codice

Il codice è pronto per essere valutato e può essere esteso facilmente per funzionalità aggiuntive.

---

**Autore**: Luigi Rosato - IN32000141  
**Data**: 2024  
**Corso**: Ingegneria del Software - Etivity 3 