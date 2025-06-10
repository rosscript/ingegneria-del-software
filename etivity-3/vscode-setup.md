# Configurazione VSCode per Etivity 3

## 📦 Estensioni Richieste

Installa l'**Extension Pack for Java** che include:
- Language Support for Java by Red Hat
- Debugger for Java
- Test Runner for Java
- Maven for Java
- Project Manager for Java

Per installarle:
1. Apri VSCode
2. Vai su Extensions (Ctrl+Shift+X)
3. Cerca "Extension Pack for Java"
4. Clicca Install

## 🚀 Apertura del Progetto

1. **File** → **Open Folder**
2. Seleziona la cartella `etivity-3`
3. VSCode riconoscerà automaticamente la struttura Java

## ⚙️ Configurazione Automatica

VSCode creerà automaticamente una cartella `.vscode/` con:
- `settings.json` - Configurazioni del progetto
- `launch.json` - Configurazioni di debug

## 🏃‍♂️ Esecuzione

### ▶️ Avvio MainConsole

1. Apri `src/MainConsole.java`
2. Clicca sul triangolo "Run" sopra il metodo `main`
3. Oppure: Ctrl+F5 per eseguire senza debug

### 🧪 Esecuzione Test

1. Vai nel pannello "Test" (icona beaker)
2. Clicca "Run All Tests"
3. Oppure: tasto destro su un test → "Run Test"

## 🔧 Risoluzione Problemi

### Java Path
Se VSCode non trova Java:
1. Cmd+Shift+P → "Java: Configure Java Runtime"
2. Imposta il path di Java 11+

### Dependencies
Se mancano le dipendenze JUnit:
1. Cmd+Shift+P → "Java: Reload Projects"
2. Le dipendenze saranno scaricate automaticamente

## 🎯 Vantaggi VSCode

- **IntelliSense** avanzato
- **Debug integrato** con breakpoint
- **Test explorer** visuale
- **Refactoring** automatico
- **Git integration** nativa 