# Ohjelmistotekniikan kurssi 2019
## Harjoitustyö "Tuplakonsonanttien ja - vokaalien harjoitteleminen"


[Vaatimusmäärittely](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/ajnarhi/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

## Komentorivitoiminnot
### Testaus

Testit suoritetaan komennolla

	mvn test


Testikattavuusraportti luodaan komennolla

	mvn jacoco:report


Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html


### Checkstyle

Tiedoston checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla
 
	mvn jxr:jxr checkstyle:checkstyle

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html

### Javadoc

JavaDoc generoidaan  komennolla
	
	 mvn javadoc:javadoc

JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html

