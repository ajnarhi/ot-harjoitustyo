/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author ajnarhi
 */
/**
 * Luokka kertoo kysymysten ominaisuuksista
 */
public class Question {

    String question;
    String rightAnswer;
    String optionalAnswer;

    public Question(String question, String rightAnswer, String optionalAnswer) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.optionalAnswer = optionalAnswer;
    }
 /**
     * Metodi palauttaa kysymykseen liittyvän oikean vastauksen.
     *
     *
     *@return Palauttaa oikean vastauksen
     */
    public String getRightAnswer() {

        return rightAnswer;
    }
/**
     * Metodi palauttaa kysymykseen liittyvän väärän vastauksen.
     *
     *
     *@return Palauttaa väärän vastauksen
     */
    public String getOptionalAnswer() {
        return optionalAnswer;
    }
/**
     * Metodi palauttaa kysymyksen.
     *
     *
     *@return Palauttaa kysymyksen.
     */
    public String ask() {
        return question;
    }

}
