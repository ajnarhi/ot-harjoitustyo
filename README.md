# Ohjelmistotekniikan kurssi 2019
## Harjoitustyö "Tuplakonsonanttien ja - vokaalien harjoitteleminen"

Sovelluksen käyttäjä eli pelaaja  voi harjoitella erilaisia lauseita, joista puuttuu sana. 
Pelaajan tehtävänä on valita lauseisiin sopiva sana kahdesta annetusta vaihtoehdosta. Tarkoituksena on harjoitella tarkkuutta nk. tuplakonsonanttien ja tuplavokaalien käytössä.

[Vaatimusmäärittely](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Käyttöhje](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)

[Testausdokumentti](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/dokumentointi/testausdokumentti.md)

## Releaset

[Viikko 6](https://github.com/ajnarhi/ot-harjoitustyo/releases/tag/viikko6)
[Loppupalautus](https://github.com/ajnarhi/ot-harjoitustyo/releases/tag/loppupalautus)

## Komentorivitoiminnot
### Testaus

Testit suoritetaan komennolla

	mvn test


Testikattavuusraportti luodaan komennolla

	mvn jacoco:report

### Suoritettavan jarin generointi

Jar saadaan komennolla 

	mvn package

Tämän jälkeen hakemistosta *target* saadaan suoritettava jar-tiedosto TuplakonsonantitJaVokaalit-1.0-SNAPSHOT.jar

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html


### Checkstyle

Tiedoston checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla
 
	mvn jxr:jxr checkstyle:checkstyle

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html

### Javadoc

JavaDoc generoidaan  komennolla
	
	 mvn javadoc:javadoc

JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html

