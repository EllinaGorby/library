# library-application
### Java-Educational-Projekt mit Swing-Implementierung. Simulation einer Bibliotheksanwendung unter Verwendung der Fake-Bibliothek zur Generierung von Daten.

---

## In dieser Anwendung wurden folgende Technologien und Bibliotheken verwendet:

- __Java Swing__
- __Event Handling__
- __Tabellen- und Listenmodelle__: Spezielle Datenmodelle wie BookTableModel und ListModelUsersBooks (Interfaces - AbstractTableModel und AbstractListModel) werden verwendet, um Daten in Tabellen (JTable) und Listen (JList) anzuzeigen. Diese Modelle sind so konfiguriert, dass sie mit den Swing-GUI-Komponenten arbeiten.
- __Fake Librery__ 


Die gemeinsamen Merkmale der Anwendung sind die Verwendung von Java Swing zur Erstellung der grafischen Benutzeroberfläche und zur Ereignisverarbeitung sowie die Arbeit mit Daten, die von Java-Kollektionen und anderen Datenstrukturen bereitgestellt werden.

---

## Anwendungsfunktionen und -komponenten

1. **Initialisierung**: Die Anwendung initialisiert ein Bibliotheksobjekt (Library l) und generiert einige Testdaten dafür mithilfe der Methode generatorList. Sie initialisiert auch Tabellenmodelle und andere UI-Komponenten.

2. **UI-Komponenten**: Die Anwendung erstellt eine grafische Benutzeroberfläche (GUI) mit verschiedenen Komponenten, darunter Beschriftungen, Schaltflächen, Optionsfelder, Listen und Tabellen. Diese Komponenten werden verwendet, um mit den Daten der Bibliothek zu interagieren.

3. **Listener**: Mehrere Action-Listener werden den UI-Komponenten hinzugefügt, um Benutzerinteraktionen zu behandeln. 

4. **Tabellenmodelle**: Zwei Tabellenmodelle (BookTableModel und ListModelUsersBooks) werden verwendet, um Daten in den Tabellen anzuzeigen. Die Daten enthalten Informationen über Bücher und die von der aktuellen Benutzerin oder dem aktuellen Benutzer ausgeliehenen Bücher.

5. **Sortierung**: Die Anwendung unterstützt das Sortieren von Büchern nach Autor, Genre oder gar keinem Sortieren. Der Benutzer kann die Sortieroption mithilfe von Optionsfeldern auswählen.

---

   ## Kurze Userseinleitung.

Nach dem Start der Anwendung erscheint das "Loginformular" (Loginform).

![___Loginformular___](https://github.com/EllinaGorby/library/blob/main/Screenshot/Screenshot_Login0.jpg)

Um das Testen zu erleichtern, generiert das Programm mithilfe der __"Faker-Library"__ Testdaten, nämlich 10 Leser und 20 Bücher. Im ersten Loginformular fordert das System bestimmte Benutzer an.

![Hilfstaste](https://github.com/EllinaGorby/library/blob/main/Screenshot/Screenshot_Login1.jpg)

Bei Betätigung der Hilfstaste wird die generierte Information in der Konsole angezeigt. 

![___in der Konsole___](https://github.com/EllinaGorby/library/blob/main/Screenshot/Screenshot_generated_daten.jpg)

Nach der Auswahl des erforderlichen Benutzers wird das Hauptfenster der Anwendung angezeigt, auf dem man ausgeliehene Bücher und Bücher in der Bibliothek sehen kann:

![___Hauptfenster___](https://github.com/EllinaGorby/library/blob/main/Screenshot/Screenshot_Hauptfenster.png)

Außerdem ist die Sortierung implementiert:

![___Sortierung___](https://github.com/EllinaGorby/library/blob/main/Screenshot/Screenshot_Sortirung.jpg)

Hier besteht die Möglichkeit, ein Buch auszuwählen und auszuleihen.

![___Buch wählen und mitnehmen___](https://github.com/EllinaGorby/library/blob/main/Screenshot/Screenshot_Hauptfenster3k.jpg)

![___Buch wählen und mitnehmen___](https://github.com/EllinaGorby/library/blob/main/Screenshot/Screenshot_Hauptfenster4.jpg)

Und auch das Zurückgeben:

![___Buch zurück geben___](https://github.com/EllinaGorby/library/blob/main/Screenshot/Screenshot_Hauptfenster5.jpg)

Es gibt die Möglichkeit, den Benutzer zu wechseln:

![___Benutzer wechseln___](https://github.com/EllinaGorby/library/blob/main/Screenshot/Screenshot_Hauptfenster7.jpg)




