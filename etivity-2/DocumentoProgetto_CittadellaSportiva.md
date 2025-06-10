# Documento di Progetto
## Sistema Gestione Cittadella Sportiva Universitaria

### Informazioni Studente
- **Nome**: Luigi
- **Cognome**: Rosato  
- **Matricola**: IN32000141
- **Data Appello**: 16.06.2025

---

## 1. Introduzione

Questo documento descrive la progettazione dettagliata del sistema di gestione per una cittadella sportiva universitaria. Il sistema è stato progettato per gestire le iscrizioni degli utenti alle diverse attività sportive offerte, il calcolo delle rette mensili e la visualizzazione degli iscritti per attività.

Il progetto segue un approccio object-oriented utilizzando i principi della progettazione software e la modellazione UML per definire l'architettura del sistema.

---

## 2. Descrizione Generale

### 2.1 Scopo del Sistema
Il sistema gestisce una cittadella sportiva universitaria che offre tre attività sportive principali:
- **Nuoto**: €25,00 mensili
- **Atletica leggera**: €40,00 mensili  
- **Body building**: €50,00 mensili

### 2.2 Funzionalità Principali
1. **Registrazione iscritti**: Permette di registrare nuovi utenti con i loro dati anagrafici e le attività sportive scelte
2. **Calcolo retta mensile**: Calcola il costo totale mensile per un iscritto in base alle attività praticate
3. **Ricerca utenti**: Permette di cercare un utente registrato tramite matricola
4. **Stampa lista iscritti**: Visualizza tutti gli iscritti per una specifica attività sportiva

### 2.3 Utenti del Sistema
Il sistema è progettato per essere utilizzato da **Operatori** della cittadella sportiva che gestiscono le iscrizioni e le informazioni degli utenti.

---

## 3. Schede CRC

### 3.1 Classe: Iscritto
**Responsabilità:**
- Mantenere i dati anagrafici (nome, cognome, matricola)
- Mantenere l'elenco delle attività sportive praticate
- Calcolare la propria retta mensile

**Collaboratori:**
- AttivitaSportiva (per il calcolo della retta)

### 3.2 Classe: AttivitaSportiva  
**Responsabilità:**
- Mantenere il nome dell'attività
- Mantenere il costo mensile
- Fornire informazioni sul costo

**Collaboratori:**
- Iscritto (viene utilizzata per il calcolo della retta)

### 3.3 Classe: GestioneIscritti
**Responsabilità:**
- Mantenere la lista di tutti gli iscritti
- Registrare nuovi iscritti
- Cercare iscritti per matricola
- Filtrare iscritti per attività sportiva
- Validare l'unicità delle matricole

**Collaboratori:**
- Iscritto (gestisce una collezione di iscritti)
- AttivitaSportiva (per filtraggi e operazioni)

### 3.4 Classe: SistemaCittadella
**Responsabilità:**
- Coordinare le operazioni di alto livello
- Interfacciarsi con l'utente operatore
- Gestire i flussi dei casi d'uso principali
- Gestire le eccezioni e gli errori

**Collaboratori:**
- GestioneIscritti (per tutte le operazioni sui dati)

### 3.5 Classe: InterfacciaUtente
**Responsabilità:**
- Gestire l'interfaccia grafica
- Raccogliere input dall'operatore
- Mostrare risultati e messaggi
- Gestire la navigazione tra le schermate

**Collaboratori:**
- SistemaCittadella (per l'esecuzione delle operazioni)

---

## 4. Diagramma delle Classi di Progetto

### 4.1 Package: model
Contiene le classi del dominio:
- `Iscritto`
- `AttivitaSportiva`

### 4.2 Package: business
Contiene la logica di business:
- `GestioneIscritti`
- `SistemaCittadella`

### 4.3 Package: ui
Contiene l'interfaccia utente:
- `InterfacciaUtente`
- `FormRegistrazione`
- `FormRicerca`
- `FormStampa`

### 4.4 Package: exception
Contiene le eccezioni personalizzate:
- `MatricolaEsistenteException`
- `MatricolaNonTrovataException`

**Nota**: Il diagramma dettagliato delle classi è incluso nel file .uml allegato.

---

## 5. Diagrammi di Sequenza

### 5.1 Sequence Diagram: Iscrizione Utente nel Sistema
Questo diagramma mostra il flusso di iscrizione di un nuovo utente nel sistema, includendo la validazione della matricola e la gestione degli errori.

**Attori**: Operatore
**Oggetti**: InterfacciaUtente, SistemaCittadella, GestioneIscritti, Iscritto, AttivitaSportiva

**Flusso principale**:
1. L'operatore inserisce i dati del nuovo iscritto
2. Il sistema valida l'unicità della matricola
3. Viene creato il nuovo oggetto Iscritto
4. Vengono associate le attività sportive
5. L'iscritto viene salvato nel sistema

### 5.2 Sequence Diagram: Ricerca Utente Registrato
Questo diagramma illustra il processo di ricerca di un utente già registrato nel sistema tramite matricola.

**Attori**: Operatore  
**Oggetti**: InterfacciaUtente, SistemaCittadella, GestioneIscritti

**Flusso principale**:
1. L'operatore inserisce la matricola da cercare
2. Il sistema cerca l'iscritto nella collezione
3. Vengono restituiti i dati dell'iscritto trovato
4. I dati vengono visualizzati nell'interfaccia

### 5.3 Sequence Diagram: Stampa Iscritti nel Sistema
Questo diagramma mostra il processo di generazione e visualizzazione della lista degli iscritti per una specifica attività sportiva.

**Attori**: Operatore
**Oggetti**: InterfacciaUtente, SistemaCittadella, GestioneIscritti, AttivitaSportiva

**Flusso principale**:
1. L'operatore seleziona l'attività sportiva
2. Il sistema filtra gli iscritti per l'attività scelta
3. Viene generata la lista degli iscritti
4. La lista viene formattata e visualizzata

**Nota**: I diagrammi dettagliati sono inclusi nel file .uml allegato.

---

## 6. Diagramma di Deployment

### 6.1 Architettura di Deployment
Il sistema ha un'architettura semplice mono-tier appropriata per un sistema desktop monoutente:

**Nodo**: Workstation Desktop
- **Sistema Operativo**: Windows/macOS/Linux
- **Componenti Software**:
  - Applicazione Desktop Java
  - Database locale (file system o SQLite)
  - JVM (Java Virtual Machine)

### 6.2 Caratteristiche del Deployment
- **Tipo**: Applicazione desktop standalone
- **Distribuzione**: Installazione locale su singola workstation
- **Persistenza**: Database locale o file system
- **Accesso**: Monoutente, singola sede

---

## 7. Vincoli di Progetto

### 7.1 Vincoli Tecnologici
- **Piattaforma**: Sistema desktop (Windows/macOS/Linux)
- **Linguaggio**: Java (compatibilità cross-platform)
- **Interfaccia**: GUI desktop (Swing/JavaFX)
- **Database**: Locale (SQLite o file serializzati)

### 7.2 Vincoli Operativi
- **Utenti**: Sistema monoutente
- **Ubicazione**: Unica sede di utilizzo
- **Connettività**: Nessun requisito di rete
- **Performance**: Risposta immediata alle query (< 1 secondo)

### 7.3 Vincoli di Manutenibilità
- **Backup**: Backup dati giornaliero automatico
- **Logging**: Log delle operazioni critiche
- **Documentazione**: Manuale utente e documentazione tecnica

---

## 8. Altri Requisiti

### 8.1 Requisiti di Usabilità
- **Interfaccia**: Intuitiva e user-friendly
- **Navigazione**: Facile e logica tra le funzionalità
- **Messaggi**: Chiari e informativi per errori e conferme
- **Help**: Sistema di aiuto integrato

### 8.2 Requisiti di Affidabilità
- **Gestione Errori**: Gestione robusta delle eccezioni
- **Validazione Dati**: Controllo integrità dei dati in input
- **Recupero**: Capacità di recupero da errori non fatali

### 8.3 Requisiti di Sicurezza
- **Accesso**: Controllo accesso all'applicazione
- **Dati**: Protezione dei dati personali degli iscritti
- **Backup**: Backup sicuro e cifrato dei dati

### 8.4 Requisiti di Performance
- **Tempo Risposta**: < 1 secondo per tutte le operazioni
- **Capacità**: Supporto per almeno 1000 iscritti
- **Memoria**: Utilizzo efficiente della memoria RAM

---

## Conclusioni

Il presente documento descrive la progettazione completa del sistema di gestione della cittadella sportiva universitaria. La soluzione proposta soddisfa tutti i requisiti funzionali e non funzionali identificati nell'analisi, fornendo un'architettura robusta, scalabile e facilmente manutenibile.

L'utilizzo dei pattern di progettazione e dei principi object-oriented garantisce un sistema ben strutturato e facilmente estendibile per future evoluzioni funzionali. 