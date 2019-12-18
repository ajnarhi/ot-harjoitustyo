/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.DatabaseQuestionDao;
import domain.Player;
import domain.Question;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ajnarhi
 */
public class DatabaseTest {

    DatabaseQuestionDao test;

    @Before
    public void setUp() {
        test = new DatabaseQuestionDao("test.db");
    }

    //tämä testi on sama kuin alempana
    @Test
    public void getPlayersWorks() {
        Player player = new Player("Annu", 2);
        test.insertNewPlayer(player);
        List<Player> playerList = test.getPlayers();
        Player firstPlayer = playerList.get(0);

        assertEquals("annu", firstPlayer.getName());

    }

    @Test
    public void insertNewQuestionWorks() {
        Question question = new Question("Tämä on testikysymys", "vastaus", "vastaus2");
        test.insertNewQuestion(question);
        List<Question> questionList = test.getQuestions();
        Question firstQuestion = questionList.get(0);

        assertEquals("Tämä on testikysymys", firstQuestion.ask());
    }

    @Test
    public void insertNewPlayerWorks() {
        Player player = new Player("Annu", 2);
        test.insertNewPlayer(player);
        List<Player> playerList = test.getPlayers();
        Player firstPlayer = playerList.get(0);

        assertEquals("annu", firstPlayer.getName());
    }

}
