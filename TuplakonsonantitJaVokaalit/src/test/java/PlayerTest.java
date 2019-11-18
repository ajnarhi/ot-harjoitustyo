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
import tuplakonsonantitjavokaalit.Player;

/**
 *
 * @author ajnarhi
 */
public class PlayerTest {
    
    Player player;
    
    @Before
    public void setUp() {
        player=new Player(0);
    }
    
    @Test
    public void IncreaseIncreasesPointsByOne(){
        player.increasePoints();
        assertEquals(1,player.getPoints());
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
   
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
