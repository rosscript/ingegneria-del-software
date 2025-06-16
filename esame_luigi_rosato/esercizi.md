# Esame di Ingegneria del Software

## Esercizio 1: Sistema Museo

### Testo dell'esercizio
Si consideri il seguente sistema Museo:
- Gli utenti possono visitare il museo, comprando un biglietto venduto da un addetto alla biglietteria o usando biglietti acquistati precedentemente;
- La visite avvengono da soli oppure con una guida;
- Alcune categorie di visitatori hanno diritto ad un biglietto ridotto, previa dimostrazione dell'applicabilità della riduzione.

### Codice PlantUML
```plantuml
@startuml Museo

skinparam actorStyle awesome
skinparam packageStyle rectangle

' Definizione degli attori
actor "Visitatore" as V
actor "Addetto alla Biglietteria" as AB
actor "Guida" as G

' Definizione dei casi d'uso
rectangle "Sistema Museo" {
    usecase "Acquistare biglietto" as UC1
    usecase "Utilizzare biglietto esistente" as UC2
    usecase "Richiedere biglietto ridotto" as UC3
    usecase "Verificare diritto alla riduzione" as UC4
    usecase "Effettuare visita autonoma" as UC5
    usecase "Prenotare visita guidata" as UC6
    usecase "Condurre visita guidata" as UC7
}

' Relazioni tra attori e casi d'uso
V --> UC1
V --> UC2
V --> UC3
V --> UC5
V --> UC6

AB --> UC1
AB --> UC4

G --> UC7

' Relazioni tra casi d'uso
UC3 ..> UC4 : <<include>>
UC6 ..> UC7 : <<include>>

@enduml
```

### Diagramma dei Casi d'Uso
![Diagramma dei Casi d'Uso del Museo](museo_casi_duso.png)

## Esercizio 2: Sistema Ristorante

### Testo dell'esercizio
Rappresentare il seguente testo tramite un diagramma UML delle classi di progettazione, prevedendo eventuali attributi e metodi con la relativa visibilità:
- In un ristorante sono entità di interesse i clienti, i tavoli (con il relativo numero di posti), le prenotazioni (effettuate dai clienti per un certo giorno ed ora, ed un certo numero di persone) alle quali viene assegnato uno o più tavoli, i camerieri (che servono i clienti al tavolo) ed i conti relativi ai vari tavoli (contenenti i prezzi delle singole portate ordinate, e le loro quantità). Dei clienti interessa il nome e numero di telefono, mentre dei camerieri interessa nome e anni di servizio. Infine delle portate interessa il nome ed il prezzo unitario.

### Codice PlantUML
```plantuml
@startuml Ristorante

' Definizione delle classi
class Cliente {
    -nome: String
    -numeroTelefono: String
    +prenota(data: Date, ora: Time, numPersone: int): Prenotazione
    +ordina(portata: Portata, quantita: int): void
}

class Tavolo {
    -numero: int
    -numPosti: int
    -occupato: boolean
    +assegnaPrenotazione(prenotazione: Prenotazione): void
    +libera(): void
}

class Prenotazione {
    -data: Date
    -ora: Time
    -numPersone: int
    -stato: String
    +assegnaTavoli(tavoli: List<Tavolo>): void
    +conferma(): void
    +annulla(): void
}

class Cameriere {
    -nome: String
    -anniServizio: int
    +serviTavolo(tavolo: Tavolo): void
    +prendeOrdine(tavolo: Tavolo, ordine: Ordine): void
}

class Conto {
    -data: Date
    -stato: String
    -totale: double
    +aggiungiPortata(portata: Portata, quantita: int): void
    +calcolaTotale(): double
    +paga(): void
}

class Portata {
    -nome: String
    -prezzoUnitario: double
    +getPrezzo(): double
}

class Ordine {
    -data: Date
    -stato: String
    +aggiungiPortata(portata: Portata, quantita: int): void
    +conferma(): void
}

' Relazioni tra le classi
Cliente "1" -- "0..*" Prenotazione : effettua >
Cliente "1" -- "0..*" Conto : ha >
Cameriere "1" -- "0..*" Tavolo : serve >
Tavolo "1..*" -- "0..*" Prenotazione : assegnato a >
Tavolo "1" -- "0..*" Conto : ha >
Conto "1" -- "0..*" Portata : contiene >
Ordine "1" -- "0..*" Portata : contiene >
Cameriere "1" -- "0..*" Ordine : gestisce >
Tavolo "1" -- "0..*" Ordine : ha >

@enduml
```

### Diagramma delle Classi
![Diagramma delle Classi del Ristorante](ristorante_classi.png)
