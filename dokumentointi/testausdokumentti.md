# Testausdokumentti

Ohjelmaan on rakennettu JUnit testiosia, jotka tarkistavat ohjelman toimivuutta. Lisäksi ohjelmaa on rakennettaessa testattu siten, että ohjelmaan ei voi esimerkiksi syöttää vääränlaisia syötteitä.


## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Sovelluslogiikkaa eli pakkausta [domain]() testaavat testiluokat[AdminTest](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/TuplakonsonantitJaVokaalit/src/test/java/AdminTest.java), [PlayerTest](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/TuplakonsonantitJaVokaalit/src/test/java/PlayerTest.java), [QuestionTest](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/TuplakonsonantitJaVokaalit/src/test/java/QuestionTest.java) ja  [ControllerTest](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/TuplakonsonantitJaVokaalit/src/test/java/ControllerTest.java). 

Tietokantatoiminto pakkauksen [dao](https://github.com/ajnarhi/ot-harjoitustyo/tree/master/TuplakonsonantitJaVokaalit/src/main/java/dao) sisällä olevaa luokkaa [DataBaseQuestionDao](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/TuplakonsonantitJaVokaalit/src/main/java/dao/DatabaseQuestionDao.java) testaa testiluokka [DatabaseTest](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/TuplakonsonantitJaVokaalit/src/test/java/DatabaseTest.java).

[MockQuestionDao](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/TuplakonsonantitJaVokaalit/src/main/java/dao/MockQuestionDao.java) luokka on rakennettu, jotta voidaan testata osia tietokantatoiminnoista ilman, että tarvitsee huolehtia tietokannan toimivuudesta. Näitä toiminnallisuuksia testataan testiluokassa [ControllerTest](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/TuplakonsonantitJaVokaalit/src/main/java/dao/MockQuestionDao.java). 

Käyttöliittymätoimintoja ei testata.


## Testauskattavuus

Testauksen rivikattavuus on 80 % ja haarautumakattavuus 88 %.

Testaamatta jäivät tilanteet luokassa Controller, joissa tarvittiin randomisointia. ControllerTest luokka arpoo alussa luvuista 0 ja 1 toisen, jonka perusteella testit tehdään. Näin ollen molemmat luvut tulevat todennäköisesti useammalla testikierroksella testattua, mutta tämä ei näy testikattavuusraportissa luokan täytenä testausprosenttina.

Tietokantatestauksista jäivät tekemättä poikkeustapausten testit eli tilanteet, joissa havaitaan jokin vääryys. Nämä jäivät testaamatta, koska ohjelmoijalta loppuivat taito ja aika.

## Järjestelmätestaus

Sovelluksen toimintaa on tarkasteltu käynnistämällä se etäkoneella. 

Sovellusta on testattu tyhjentämällä tietokanta pelaajista sekä sellaisella tietokannalla, jossa on jo pelaajia.

## Toiminnallisuudet

Ohjelmassa on estetty muutamia asioita. Esimerkiksi ohjelma ei hyväksy tyhjiä käyttäjiä, eikä tyhjiä kysymyksiä tai vastauksia. Näiden estojen toiminnallisuus on testattu manuaalisesti ohjelmaa rakennettaessa.

## Sovellukseen jääneitä mahdollisia ongelmia

Sovellusta ei testattu koskaan tyhjällä kysymystietokannalla. Näin olisi pitänyt tehdä. Tästä todennäköisesti koituu ongelmia, jotka oltaisiin voitu välttää sijoittamalla ohjelmaan koodinpätkä, joka ilmoittaa tietokannan olevan ilman kysymyksiä ja joka avaisi Admin tilan kysymysten lisäämiselle.

