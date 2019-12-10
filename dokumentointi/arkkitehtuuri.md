# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria. Koodin pakkausrakenne on seuraava: 

![Alustava pakkausrakenne](pakkauskaavio.jpg)

Pakkaus *ui* sisältää JavaFX:llä toteutetun käyttöliittymän,*domain* sovelluslogiikan ja *dao* tietokantatalletuksesta vastaavan koodin. 

## Käyttöliittymä

Käyttöliittymä sisältää todella monta erilaista näkymää, joita kuvailne enemmän, kun käyttöliittymä on valmis.

Jokainen näkymä on toteutettu omana Scene-oliona. Jokainen näkymä on yksi kerrallaa näkyvää eli sijoitettuna sovelluksen stageen. Käyttöliittymä on rakennettu ohjelmallisesti luokassa ui.UserInterface.

## Sovelluslogiikka

Sovelluksen loogisen datamallin muodostavat luokat Player ja Question, jotka kuvaavat pelaajaa ja pelaajalle esitettäviä kysymyksiä:

![Alustava luokkakaavio](luokkakaavio.jpg)

## Tietojen pysyväistallennus

Pakkauksen *dao* luokat DatabaseQuestionDao ja QuestionDao huolehtivat tietojen tallettamisesta tietokantaan.

Sovelluslogiikan testausta varten on pystytetty valetietokanta luokkaan MockDatabaseDao.


