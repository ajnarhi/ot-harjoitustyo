/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.QuestionDao;
import dao.DatabaseQuestionDao;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ajnarhi
 */
/**
 * Luokka on käyttöliittymän logiikkaa pyörittävä luokka
 */
public class Controller {

    QuestionDao database;
    Random random = new Random();
    List<Question> databaseQuestions;
    List<Player> databasePlayers;
    Question question;
    int randomNumberForAnswers;

    public Controller(QuestionDao database) {
        this.database = database;
        databaseQuestions = database.getQuestions();
        databasePlayers = database.getPlayers();

    }

    /**
     * Metodi valitsee yhden satunnaisen kysymyksen.
     *
     *
     * @return Palauttaa yhden kysymyksen vastausvaihtoehtoineen listana
     */
    public Question getRandomQuestionFromTheList() {
        return databaseQuestions.get(random.nextInt(databaseQuestions.size()));

    }

    /**
     * Metodi käynnistää pelaajalle uuden pelikierroksen käyttämällä kysymyksen
     * valintaan metodia getRandomQuestionFromTheList(). Sekä arpomalla joko 0
     * tai 1 ja tallettamalla sen muuttujaan
     *
     *
     *
     */
    public void newRound() {
        question = getRandomQuestionFromTheList();
        randomNumberForAnswers = random.nextInt(2);

    }

    /**
     * Metodi kysyy kysymyksen
     *
     * @return palauttaa kysymyksen
     */
    public String getQuestion() {
        return question.ask();
    }

    /**
     * Metodi palauttaa toisen kysymykseen liitetyistä vastausksista riippuen
     * aiemmin arvotun muuttujan randomNumberForAnswers arvosta
     *
     * @return palauttaa toisen vastausvaihtoehdoita
     */
    public String getFirstAnswer() {

        if (randomNumberForAnswers == 0) {
            return question.getRightAnswer();

        } else {
            return question.getOptionalAnswer();
        }

    }

    /**
     * Metodi palauttaa toisen kysymykseen liitetyistä vastausksista riippuen
     * aiemmin arvotun muuttujan randomNumberForAnswers arvosta
     *
     * @return palauttaa toisen vastausvaihtoehdoita
     */
    public String getSecondAnswer() {
        if (randomNumberForAnswers == 0) {
            return question.getOptionalAnswer();

        } else {
            return question.getRightAnswer();
        }
    }

    /**
     * Metodi palauttaa numeron 0 tai 1 aiemmin arvotun mukaisesti
     *
     * @return palauttaa luvun 0 tai 1
     */
    public int getRandomNumber() {
        return randomNumberForAnswers;
    }

    /**
     * Metodi muuntaa parametrinaan saamansa nimen lowercase muotoon ja
     * tarkistaa onko nimi tietokannasta haetulla pelaajalistalla. Jos on, se
     * palautta true, muuten false
     *
     * @return palauttaa true tai false
     */
    public boolean checkIfNameIsOnThePlayerList(String name) {
        String nameLower = name.toLowerCase();
        for (Player player : databasePlayers) {
            String playerName = player.getName();
            playerName = playerName.toLowerCase();
            if (playerName.equals(nameLower)) {
                return true;
            }

        }
        return false;

    }

    /**
     * Metodi muuntaa parametrinaan saamansa nimen lowercase muotoon ja
     * tarkistaa onko nimi tietokannasta haetulla pelaajalistalla. Jos on, se
     * asettaa pelaajalle sen pisteet ja palauttaa tiedon pisteistä.
     *
     * @return palauttaa pelaajan pisteet
     */
    public int ifNameIsOnTheDatabaseReturnPoints(String name) {
        int playerPoints = 0;
        String nameLower = name.toLowerCase();

        for (Player player : databasePlayers) {
            String playerName = player.getName();
            if (playerName.toLowerCase().equals(nameLower)) {
                playerPoints = player.getPoints();

            }

        }
        return playerPoints;
    }

    /**
     * Metodi siirtää uuden pelaajan tiedot tietokantaan.
     *
     * Syötteenä pelaaja, jolla nimi ja pisteet
     */
    public void insertNewPlayerIntoDatabase(Player player) {
        database.insertNewPlayer(player);
    }
    
    public void updatePlayersPointsOnDatabase(Player player){
        database.updatePlayersPoints(player);
    }
    
    public void insertNewQuestionIntoDatabase(Question question){
        database.insertNewQuestion(question);
    }
}
