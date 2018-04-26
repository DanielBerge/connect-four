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
* [x] hele semesteroppgaven er ferdig og klar til retting!
* Code review:
   * [x] jeg har fått tilbakemelding underveis fra @pda008
   * [x] jeg har gitt tilbakemelding underveis til @pda008
* Sjekkliste:
   * [x] Kjørbart Fire på Rad-spill
   * [x] Forklart designvalg, hvordan koden er organisert, abstraksjon, og andre ting 
   * [x] Tester
   * [x] Dokumentasjon (JavaDoc, kommentarer, diagrammer, README, etc.)
   * [x] Fornuftige navn på klasser, interfaces, metoder og variabler
   * [x] Fornuftige abstraksjoner og innkapsling (bruk av klasser, interface, metoder, etc.)

## Oversikt
*(oversikt over koden din og det du har gjort)*
### Bruk
* For å starte programmet kjør: `GUI` [GUI] (src/gui/GUI.java)

## Designvalg
*(hvordan du har valgt å løse oppgaven)*

Har brukt JavaFx til å lage GUI, der man kan velge om man vil spille mot en annen person eller spille mot en AI.
Har brukt CSS for å lage pene knapper for startmenyen. Og for å skjule knappene i selve spillet.
Har laget spillet ganske modulært, det er mange klasser, som er navngitt så det er lett å forstå hva de gjør. Kunne hatt mindre klasser, men da hadde det ikke vært like modulært.


### Bruk av abstraksjon
*(hvordan du har valgt objekter/klasser for å representere ting i spillet)*

Har brukt innkapsling så de metodene som ikke skal kalles fra alle steder er enten private eller protected.

De fleste av klassene er generiske så gjenbruk av klassene er lett. 
TurnHandler klassen er ikke generisk, fordi den bruker mange metoder fra Token, kunne kanskje gjort det på en annen måte, men frister ikke, for det er ikke så viktig at den er generisk, for den er ganske spesifik for dette spillet.

Har brukt en abstract class til players. Der både Human og Ai extends Abstractplayer, fordi disse skal ha mange av de samme metodene og de samme feltvariablene.

Har interfaces for de fleste klassene, der det er relevant. Disse er godt kommentert, så det er lett å forstå hva de gjør.


### Erfaring – hvilke valg viste seg å være gode / dårlige?
*(designerfaringer – er det noe du ville gjort annerledes?)*

Var usikker på om jeg skulle prøve å lære JavaFx for å lage GUI eller ikke, men valgte å gjøre det. Og er glad jeg gjorde det for jeg synes det gikk overraskende bra.

## Testing
*(hvordan du har testet ting)*

Forklart med kommentering i test-klassene.

Har ikke testet TurnHandler så mye, pga det var ikke så lett å få til når det var metoder som kalte GUI, som ga mange feilmeldinger, men laget noen få simple tester som virker.

Lager ikke tester for GameScene, StartScene og GUI, fordi dette er 
for det meste grafikk, som er bedre å teste visuelt.

## Funksjonalitet, bugs
*(hva virker / virker ikke)*

#### Bugs

"It's not a bug, it's a feature"


## Evt. erfaring fra code review
*(lærte du noe av å gå gjennom din eller andres kode?)*

Ja, så det var mange andre måter å gjøre ting på. Vi hadde veldig forskjellig kode, så var gøy å se hvordan oppgaven kunne løses på en annen måte.

## Annet
*(er det noe du ville gjort annerledes?)*

Brukte mye tid på å lære hvordan man brukte JavaFx, så hadde vært en fordel å kunne det fra før av, men nå som jeg kan det
bruker jeg det gjerne igjen.

Skulle gjerne laget en bedre AI, men fikk det ikke helt til.
