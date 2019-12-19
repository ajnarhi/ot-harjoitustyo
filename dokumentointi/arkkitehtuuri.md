# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne on kolmikerroksinen kerrosarkkitehtuuri. Koodin pakkausrakenne on seuraava: 

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

Sovelluksen loogiikan muodostavat luokat Admin, Player ja Question, jotka kuvaavat pääkäyttäjää, pelaajaa ja pelaajalle esitettäviä kysymyksiä. 

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

Seuraavassa esittelen sekvenssikaaviokuvin kaksi ohjelman päätoimintoa.


### Aikaisemmin pelannut pelaaja alkaa pelata

Aikaisemmin pelannut pelaaja palaa pelin pariin ja hänen tietonsa tarkistetaan tietokannasta. Pelaaja kirjaa nimensä, jonka jälkeen tietokannasta tarkistetaan onko pelaaja pelannut aikaisemmin. Jos on, pelaajalle asetetaan nimi ja pisteet sekä siirrytään näkymään, jossa pelaaja toivotetaan tervetulleeksi takaisin ja kerrotaan hänen edellisen kierroksen pisteensä.

![VanhaPelaajaPelaa](vanhapelaaja_sekvenssi.jpg)


### Pääkäyttäjä kirjautuu ja tallettaa uuden kysymyksen

Toisena näemme miten Admin toiminto toimii. Kun pelaajan nimeksi on kirjoitettu Admin/admin ja painettu nappia, tarkistetaan nimi. Jos nimi vastaa adminia, siirrytään näkymään, jossa pyydetään salasanaa. Salasana tarkistetaan Admin luokasta, että se vastaa Adminin salasanaa, joka on 1234. Jos näin on avataan näkymä, jossa voidaan lisätä kysymyksiä tietokantaan kirjoittamalla kysymys ja vastausvaihtoehdot sekä painamalla nappia. Lopulta avautuu näkymä, jossa voi valita lopettaako pelin vai lisääkö lisää kysymyksiä.

![Admin](admin_sekvenssi.jpg)


## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä

Käyttöliittymän koodi on varsin pitkä ja sen logiikan seuraaminen voi olla haastavaa. Erilaiset näkymät olisi voinut tallentaa omiksi metodeikseen, jolloin tilanne olisi selkiytynyt. Käyttöliittymän selkeyttä on yritetty parantaa lisäämällä kommentteja, mutta tämä olisi voitu tehdä ohjelmallisestikin.

### Controller

Nyt Controller luokka pitää huolta moninaisista tehtävistä. Olisi ollut ehkä ollut järkevää pilkkoa vielä Controller luokka pienemmäksi.
