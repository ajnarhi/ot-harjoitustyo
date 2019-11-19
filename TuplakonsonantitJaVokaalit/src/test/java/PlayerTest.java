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
    
    @Test
    public void getPointsGetsRightAmountOfPoints(){
        assertEquals(0, player.getPoints());
    }
    
    @Test
    public void decreasePointsDoesntDecreasePointsIfThereIsZeroPoints(){
        player.decreasePoints();
        assertEquals(0,player.getPoints());
        
    }
    
    @Test
    public void decreasePointsDoesntDecreasePointsIfThereIsLessThanZeroPoints(){
        Player player1=new Player(-2);
        player1.decreasePoints();
       
        assertEquals(-2,player1.getPoints()); 
        
    }
    
    

    
}
