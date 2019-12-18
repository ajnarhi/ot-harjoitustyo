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
 * Luokka kertoo Adminin ominaisuuksista
 */
public class Admin {

    String password;

    
    public Admin() {
        this.password = "1234";
    }

     /**
     * Metodi palauttaa adminin salasanan Stringinä.
     *
     *
     *@return Palauttaa salasanan
     */
    public String getPassword() {
        return password;
    }

}
