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
import domain.Player;

/**
 *
 * @author ajnarhi
 */
public class PlayerTest {

    Player player;

    @Before
    public void setUp() {
        player = new Player("", 0);
    }

    @Test
    public void IncreaseIncreasesPointsByOne() {
        player.increasePoints();
        assertEquals(1, player.getPoints());
    }

    @Test
    public void getPointsGetsRightAmountOfPoints() {
        assertEquals(0, player.getPoints());
    }

    @Test
    public void decreasePointsDoesntDecreasePointsIfThereIsZeroPoints() {
        player.decreasePoints();
        assertEquals(0, player.getPoints());

    }

    @Test
    public void decreasePointsDoesntDecreasePointsIfThereIsLessThanZeroPoints() {
        Player player1 = new Player("", -2);
        player1.decreasePoints();

        assertEquals(-2, player1.getPoints());

    }

    @Test
    public void decreasePointsDecreasesPoints() {
        Player player1 = new Player("", 5);
        player1.decreasePoints();
        assertEquals(4, player1.getPoints());
    }
    
    @Test 
    public void getNameGetsName(){
        Player player=new Player("Hilla",0);
            
            assertEquals("Hilla", player.getName());

}
       @Test 
    public void setNameSetsName(){
        Player player=new Player("",0);
        player.setName("Hilla");
            
            assertEquals("Hilla", player.getName());

}
       @Test 
    public void setPointsSetsPoints(){
        Player player=new Player("",0);
        player.setPoints(9);
            
            assertEquals(9, player.getPoints());

}
}
