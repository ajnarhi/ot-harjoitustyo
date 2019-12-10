/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author ajnarhi
 */
public class Player {

    Integer points;
    String name;

    public Player(String name, Integer points) {
        this.points = points;
        this.name=name;
    }

    public int getPoints() {
        return points;
    }

    public void increasePoints() {
        points++;
    }

    public void decreasePoints() {
        if (points > 0) {
            points--;

        }
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
        
    }

    public void setPoints(Integer points){
        this.points=points;
    }
}
