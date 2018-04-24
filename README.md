# [Semesteroppgave 2: “Fire på rad”](https://retting.ii.uib.no/inf101.v18.sem2/blob/master/SEM-2.md)


* **README**
* [Oppgavetekst](SEM-2.md)

Dette prosjektet inneholder [Semesteroppgave 2](SEM-2.md). Du kan også [lese oppgaven online](https://retting.ii.uib.no/inf101.v18.oppgaver/inf101.v18.sem2/blob/master/SEM-2.md)

**Innleveringsfrist:**
* Hele oppgaven skal være ferdig til **fredag 27. april kl. 2359** ([AoE](https://www.timeanddate.com/worldclock/fixedtime.html?msg=4&iso=20180427T2359&p1=3399))
* [Ekstra tips til innlevering](https://retting.ii.uib.no/inf101/inf101.v18/wikis/innlevering)

**Utsettelse:** Hvis du trenger forlenget frist er det mulig å be om det (spør gruppeleder – evt. foreleser/assistenter hvis det er en spesiell situasjon). Hvis du ber om utsettelse bør du være i gang (ha gjort litt ting, og pushet) før fristen
   * En dag eller to går greit uten begrunnelse.
   * Eksamen er relativt tidlig i år, så vi vil helst unngå lange utsettelser.
   * Om det er spesielle grunner til at du vil trenge lengre tid, så er det bare å ta kontakt, så kan vi avtale noe. Ta også kontakt om du [trenger annen tilrettelegging](http://www.uib.no/student/49241/trenger-du-tilrettelegging-av-ditt-studiel%C3%B8p). 
   
# Fyll inn egne svar/beskrivelse/kommentarer til prosjektet under
* Levert av: Daniel Berge (dbe015)
* [ ] hele semesteroppgaven er ferdig og klar til retting!
* Code review:
   * [ ] jeg har fått tilbakemelding underveis fra @brukernavn, ...
   * [ ] jeg har gitt tilbakemelding underveis til @brukernavn, ...
* Sjekkliste:
   * [x] Kjørbart Fire på Rad-spill
   * [ ] Forklart designvalg, hvordan koden er organisert, abstraksjon, og andre ting 
   * [ ] Tester
   * [ ] Dokumentasjon (JavaDoc, kommentarer, diagrammer, README, etc.)
   * [ ] Fornuftige navn på klasser, interfaces, metoder og variabler
   * [ ] Fornuftige abstraksjoner og innkapsling (bruk av klasser, interface, metoder, etc.)

## Oversikt
*(oversikt over koden din og det du har gjort)*
### Bruk
* For å starte programmet kjør: `fyll.inn.her`

## Designvalg
*(hvordan du har valgt å løse oppgaven)*

### Bruk av abstraksjon
*(hvordan du har valgt objekter/klasser for å representere ting i spillet)*

De fleste av klassene er generiske så gjenbruk av klassene er lett. 
Rules klassen er ikke generisk, fordi den inneholder static metoder.
TurnHandler klassen er heller ikke generisk, fordi den bruker metoder fra Token, kunne gjort det på en annen måte, men frister ikke.

Selv om det er litt teit at AI har en T som extends Token, så gjør jeg dette så AbstractPlayer fortsatt kan være generisk.

### Erfaring – hvilke valg viste seg å være gode / dårlige?
*(designerfaringer – er det noe du ville gjort annerledes?)*

## Testing
*(hvordan du har testet ting)*

## Funksjonalitet, bugs
*(hva virker / virker ikke)*

#### Bugs
* "It's not a bug, it's a feature"


## Evt. erfaring fra code review
*(lærte du noe av å gå gjennom din eller andres kode?)*

## Annet
*(er det noe du ville gjort annerledes?)*
