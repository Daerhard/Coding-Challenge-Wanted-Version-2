
# Der Code bezieht sich auf folgende Coding Challenge:
[wanted exercise.pdf](https://github.com/Daerhard/Challenge/files/8239763/wanted.exercise.pdf)

Outline 
In this small exercise, we want to build a small command line (CLI) or browser-based 
application that generates a “Wild West” style DEAD OR ALIVE poster from the 
public FBI Wanted API.

Resources 
- API: https://www.fbi.gov/wanted/api
- Font: “Amasis MT Pro Black“ (installed on Windows by default)

Expected Result 
(For the CLI version) Upon running a command like
java -jar wanted.jar or ts-node index.ts ...

(For a browser-based app) When opening the app …
the program should select a random criminal from the FBI API and generate an (at 
least somewhat) visually appealing poster, including the mugshot. It could be saved
as a viewable file (e.g. HTML, PDF) or presented in the browser

# Entwicklungsumgebung
Der Code wurde in der Entwicklungsumgebung Eclipse (JavaSE-17) entwickelt.

# Tools
Spring Boot Framework
Maven
Thymeleaf

# Aufbau und Funktion
1. Klasse APIaccess - öffnet eine Verbindung zur API der FBI Website und übermittelt die Daten.
2. Klasse CompleteImage - generiert das komplette Bild
3. Klasse ImageController - Verarbeitet die Daten und ermöglicht die Ausgabe im Browser über ein template

# Unit Tests
1. Klasse APIAccessTest - prüft die Funktionalität der Klasse APIaccess
2. Klasse CompleteImageTest - prüft die Funktionalität der Klasse CompleteImage

# Start der Anwendung
Nach dem Start kann die Anwendnung über Localhost:8080/WebWanted im Browser aufgerufen werden.
