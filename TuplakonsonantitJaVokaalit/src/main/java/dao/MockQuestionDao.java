/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Player;
import domain.Question;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ajnarhi
 */
/**
 * Luokka on testausta varten tehty tietokantamalli.
 */
public class MockQuestionDao implements QuestionDao {

    List<Player> allPlayers;
    List<Question> allQuestions;

    public MockQuestionDao() {
        allPlayers = new ArrayList();
        Player testPlayer = new Player("aarni", 5);
        allPlayers.add(testPlayer);
        allQuestions = new ArrayList();
    }

    /**
     * Metodi ssa lisätään listalle yksi kysymys vastausvaihtoehtoineen.
     *
     *
     *
     * @return Palauttaa yhden kysymyksen vastausvaihtoehtoineen listana
     */
    @Override
    public List<Question> getQuestions() {

        Question testQuestion = new Question("Tien poikki kulki <mikä?>", "kissa", "kisa");
        allQuestions.add(testQuestion);
        return allQuestions;

    }

    /**
     * Metodi palauttaa yhden pelaajan, jolle on annettu pisteitä listassa.
     *
     *
     * @return Palauttaa yhden pelaajan ja hänen pisteensä listana
     */
    @Override
    public List<Player> getPlayers() {

        return allPlayers;
    }

    /**
     * Metodi lisää listaan pelaajan.
     *
     *
     * @param player on parametrina annettu pelaaja
     */
    @Override
    public void insertNewPlayer(Player player) {
        allPlayers.add(player);
    }

    /**
     * Metodi pelaajan pisteiden päivittämiseksi.
     *
     *
     * @param player on parametrina annettu pelaaja
     */
    @Override
    public void updatePlayersPoints(Player player) {
        player.setPoints(7);
    }

    /**
     * Metodilla lisätään kysymys tyhjään listaan
     *
     *
     * @param question on parametrina annettu kysymys
     */
    @Override
    public void insertNewQuestion(Question question) {
        allQuestions.clear();
        allQuestions.add(question);

    }

}
