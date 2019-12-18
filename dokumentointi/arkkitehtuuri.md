# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria. Koodin pakkausrakenne on seuraava: 

![Alustava pakkausrakenne](pakkauskaavio.jpg)

Pakkaus *ui* sisältää JavaFX:llä toteutetun käyttöliittymän *domain* sovelluslogiikan ja *dao* tietokantatalletuksesta vastaavan koodin. 

## Käyttöliittymä

Käyttöliittymä sisältää 

1. Tervetulonäkymä, johon kirjoitetaan joko nimi tai admin
2. Adminin salasanakyselynäkymä
3. Admin tunnuksilla toimiva kysymysten syöttäminen tietokantaan 
4. Näkymä jossa mahdollisuus päättää lisääkö lisää kysymyksiä vai lopettaako ohjelman
5. Näkymä, jossa toivotetaan uusi pelaaja tervetulleeksi ja aloitetaan peli
6. Näkymä, jossa toivotetaan vanha pelaaja tervetulleeksi ja aloitetaan peli
7. Näkymä, jossa on kysymys ja vaihtoehdot
8. Näkymä, jossa annetaan palautetta tehtävän oikeasta ratkaisusta ja tarjotaan mahdollisuutta jatkaa seuraavaan kysymykseen tai lopettaa peli
9. Näkymä, jossa annetaan palautetta tehtävän väärästä ratkaisusta ja tarjotaan mahdollisuutta jatkaa seuraavaan kysymykseen tai lopettaa peli

Jokainen näkymä on toteutettu omana Scene-oliona. Jokainen näkymä on yksi kerrallaan näkyvää eli sijoitettuna sovelluksen stageen. Käyttöliittymä on rakennettu ohjelmallisesti luokassa ui.UserInterface.

Käyttöliittymä pääasiassa vain rakentaa näkymiä ja käyttää Controller luokan ominaisuuksia.

## Sovelluslogiikka

Sovelluksen loogiikan muodostavat luokat Player ja Question, jotka kuvaavat pääkäyttäjää, pelaajaa ja pelaajalle esitettäviä kysymyksiä:

![Alustava luokkakaavio](luokkakaavio_loppu.JPG)

Käyttöliittymän toiminnallisuuksista vastaa luokka Controller, joka pääsee käsiksi tietokannan tietoihin QuestionDao rajapinnan avulla.

## Tietojen pysyväistallennus

Pakkauksen *dao* luokat DatabaseQuestionDao ja QuestionDao huolehtivat tietojen tallettamisesta tietokantaan.

Sovelluslogiikan testausta varten on pystytetty valetietokanta luokkaan MockDatabaseDao.

### Tietokanta

Sovellus tallettaa ja lukee tietoja tietokannasta, johon on tallennettu taulut kysymyksiä (questions) ja pelaajia(player) varten. Jos tauluja ei ole, ne luodaan.
Questions taulu sisältää sarakkeet kysymykselle, sekä siihen liittyviin oikeaan ja väärään vastaukseen. Player taulu sisältää sarakkeet pelaajan nimelle ja viimeisimmän pelikierroksen pisteille.

## Päätoiminnallisuudet

### Pelaaminen




