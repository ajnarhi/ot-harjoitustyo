/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.DatabaseQuestionDao;
import dao.MockQuestionDao;
import dao.QuestionDao;
import domain.Controller;
import domain.Question;
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
    
    /*@Test
    public void getFirstAnswerGetsRightAnswerWhenRandomNumberIsZero(){
        controller.newRound();
        int randomNumberForAnswers=0;
        String answer=controller.getFirstAnswer();
        
        assertEquals("kissa", answer);
        
        
        
    }*/

  

}
