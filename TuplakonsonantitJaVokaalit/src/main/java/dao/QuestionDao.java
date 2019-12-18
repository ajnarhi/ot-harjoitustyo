/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Player;
import java.util.List;
import domain.Question;

/**
 *
 * @author ajnarhi
 */
/**
 * Rajapinta, jossa määrätään tietokantaominaisuuksia.
 */
public interface QuestionDao {

    List<Question> getQuestions();

    List<Player> getPlayers();

    void insertNewQuestion(Question question);

    void insertNewPlayer(Player player);

    void updatePlayersPoints(Player player);

}
