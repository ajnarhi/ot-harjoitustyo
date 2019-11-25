/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tuplakonsonantitjavokaalit.Question;

/**
 *
 * @author ajnarhi
 */
public class QuestionTest {
    
    
    Question question;
    
    @Before
    public void setUp() {
        question=new Question("Tien yli kulki...", "kissa", "kisa");
    }
    
    @Test
    public void askingQuestionReturnsQuestion(){
        
        
        assertEquals("Tien yli kulki...", question.ask());
    }
            
          @Test
    public void OptionalAnswerIsReturned(){
        
        assertEquals("kisa", question.getOptionalAnswer());   
    }
    
        
    
            
            @Test
    public void RightAnsweIsReturned(){
        
            assertEquals("kissa", question.getRightAnswer());  
            
}
}
    

