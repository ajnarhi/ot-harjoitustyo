/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuplakonsonantitjavokaalit;

/**
 *
 * @author ajnarhi
 */
public class Player {
    
    Integer points;
    
    public Player(Integer points){
        this.points=points;
    }
    
    public int getPoints(){
        return points;
    
}
    
    public void increasePoints(){
        points++;
    }
    
    public void decreasePoints(){
        if (points>0){
            points--;
        
        }
    }
    
}

