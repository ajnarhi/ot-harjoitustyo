# TestausDokumentti

Ohjelmaan on rakennettu JUnit testiosia, jotka tarkistavat ohjelman toimivuutta. Lisäksi ohjelmaa on rakennettaessa testattu siten, että ohjelmaan ei voi esimerkiksi syöttää vääränlaisia syötteitä.


## Yksikkö- ja integraatiotestaus

###Sovelluslogiikka

Sovelluslogiikkaa eli pakkausta domain testaavat testiluokat PlayerTest, QuestionTest ja  ControllerTest. 

Tietokantatoiminto pakkauksen dao sisällä olevaa luokkaa DataBaseQuestionDao testaa testiluokka DatabaseTest.

MockQuestionDao luokka on rakennettu, jotta voidaan testata osia tietokantatoiminnoista ilman, että tarvitsee huolehtia tietokannan toimivuudesta. Näitä toiminnallisuuksia testataan testiluokassa ControllerTest. 

Käyttöliittymätoimintoja ei testata.


## Testauskattavuus

Testauksen rivikattavuus on % ja haarautumakattavuus %.


