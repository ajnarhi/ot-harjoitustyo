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
/**
 * Luokka kertoo pelaajan ominaisuuksista
 */
public class Player {

    Integer points;
    String name;

    public Player(String name, Integer points) {
        this.points = points;
        this.name = name;
    }
 /**
     * Metodi palauttaa pelaajan pisteet.
     *
     *
     *@return Palauttaa pisteet
     */
    public int getPoints() {
        return points;
    }
  /**
     * Metodi lisää pistemäärää yhdellä.
     *
     *
     *
     */
    public void increasePoints() {
        points++;
    }

     /**
     * Metodi tarkistaa pistemäärän ja vähentää pistemäärää jos pisteitä on enemmän kuin nolla.
     *
     *
     *
     */
    public void decreasePoints() {
        if (points > 0) {
            points--;

        }
    }

    /**
     * Metodi palauttaa pelaajan nimen.
     *
     *
     * @return name Palautetaan nimi
     *
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Metodi asettaa pelaajalle nimen.
     *
     *
     * @param name Pelaajalle annettu nimi
     *
     *
     */
    public void setName(String name) {
        this.name = name;

    }

    /**
     * Metodi asettaa pelaajalle pisteitä.
     *
     *
     * @param points Pelaajalle annettu pistemäärä
     *
     *
     */
    public void setPoints(Integer points) {
        this.points = points;
    }
}
