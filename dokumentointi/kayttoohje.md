# Käyttöohje

Lataa sovellus [täältä](https://github.com/ajnarhi/ot-harjoitustyo/releases/tag/loppupalautus).

## Konfigurointi

Ohjelma käyttää SQLite tietokantaa questions.db

## Ohjelman käynnistäminen

Voit käynnistää ohjelman komennolla

	java -jar TuplakonsonantitJaVokaalit-1.0-SNAPSHOT.jar

## Pelaaminen

### Adminina

Sovellus käynnistyy näkymään, jossa voita antaa nimeksi "Admin" tai " admin".

Kun olet kirjoittanut nimen, paina nappia "Nimi kirjoitettu".

Tämän jälkeen sovellus kysyy salasanaa, joka on 1234.

Paina nappia "Salasana annettu".

Sovellus käynnistää näkymän, jossa voit lisätä tietokantaan harjoituskysymyksiä ja niille oikeita ja vääriä vastauksia.

Paina nappia "Tallenna uusi kysymys ja vastaukset".

Sovellus käynnistää näkymän, josta saat valittua napeista "Lisää uusi kysymys" tai "Lopeta". Ensimmäisestä pääset lisäämään lisää kysymyksiä tietokantaan, jälkimmäisestä sovellus lopetetaan.


### Pelaajana

Sovellus käynnistyy näkymään, jossa voit antaa nimesi.

Kun olet kirjoittanut nimesi paina nappia "Nimi kirjoitettu". 

Jos olet aiemmin pelannut, näet edellisen kierroksen pisteesi.

Jos olet uusi pelaaja, kertoo peli sinulle alkupistetilanteesi, joka on 0.

Aloita uusi peli painamalla nappia "Aloita uusi peli".

Lue kysymys ja paina nappivaihtoehdoista sitä, jonka teksti mielestäsi sopii lauseeseen

Kun et enää halua pelata, paina nappia "Lopeta" tai ruksia näkymän oikeassa ylälaidassa.
