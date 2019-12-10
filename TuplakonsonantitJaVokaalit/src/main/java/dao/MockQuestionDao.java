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
 * Luokka on testausta varten tehty tietokantamalli
 */
public class MockQuestionDao implements QuestionDao {
    
    
/**
     * Metodi palauttaa yhden kysymyksen vastausvaihtoehtoineen listana.
     *
     *
     *@return Palauttaa yhden kysymyksen vastausvaihtoehtoineen listana
     */
    @Override
    public List<Question> getQuestions() {
        List<Question> allQuestions = new ArrayList();
        Question testQuestion = new Question("Tien poikki kulki <mikä?>", "kissa", "kisa");
        allQuestions.add(testQuestion);
        return allQuestions;

    }
    
    /**
     * Metodi palauttaa yhden pelaajan, jolle on annettu pisteitä listassa.
     *
     *
     *@return Palauttaa yhden pelaajan ja hänen pisteensä listana
     */ 

    @Override
    public List<Player> getPlayers() {
        List<Player> allPlayers = new ArrayList();
        Player testPlayer = new Player("Aarni", 5);
        allPlayers.add(testPlayer);
        return allPlayers;
    }

     /**
     * Metodia rakennetaan vielä.
     *
     *
     *
     */ 
    @Override
    public void insertNewPlayer(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
