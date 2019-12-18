/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.DatabaseQuestionDao;
import dao.MockQuestionDao;
import dao.QuestionDao;
import domain.Controller;
import domain.Player;
import domain.Question;
import java.util.List;
import java.util.Random;
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
public class ControllerTest {

    Controller controller;

    @Before
    public void setUp() {
        controller = new Controller(new MockQuestionDao());

    }

    @Test
    public void getQuestionGetsQuestion() {
        controller.newRound();

        assertEquals(controller.getQuestion(), "Tien poikki kulki <mikä?>");

    }

    @Test
    public void getFirstAnswerAndGetSecondAnswerGiveDifferentAnswers() {
        controller.newRound();

        String answer1 = controller.getFirstAnswer();
        String answer2 = controller.getSecondAnswer();

        assertNotEquals(answer1, answer2);

    }

    @Test
    public void checkIfNameIsOnThePlayerListReturnsTrueIfPlayerExists() {

        assertTrue(controller.checkIfNameIsOnThePlayerList("aarni"));
    }

    @Test
    public void checkIfNameIsOnThePlayerListReturnsFalseIfPlayerNotExists() {

        assertFalse(controller.checkIfNameIsOnThePlayerList("hilla"));
    }

    @Test
    public void ifPlayerIsOnTheListReturnPlayersPoints() {

        assertEquals(5, controller.ifNameIsOnTheDatabaseReturnPoints("aarni"));

    }

    @Test
    public void insertNewPlayerIntoDatabaseInsertsPlayer() {
        controller.insertNewPlayerIntoDatabase(new Player("niko", 75));

        assertEquals(75, controller.ifNameIsOnTheDatabaseReturnPoints("niko"));
    }
    
    @Test
    public void insertNewQuestionIntoDatabaseInsertsNewQuestion(){
      
        controller.insertNewQuestionIntoDatabase(new Question("Testikysymys", "vastaus1", "vastaus2"));
        
        Question questionWithAnswers=controller.getRandomQuestionFromTheList();
        String onlyQuestion = questionWithAnswers.ask();
      
        
        assertEquals("Testikysymys", onlyQuestion);
    }

    
    @Test
    public void updatePointsWorks(){
        Player player=new Player("aarni",5);
        controller.updatePlayersPointsOnDatabase(player);
        
        assertEquals(7, player.getPoints());
    }
}
