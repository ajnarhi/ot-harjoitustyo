package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein(){
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void lataaminenKasvattaaSaldoaOikein(){
        kortti.lataaRahaa(2);
        assertEquals(12, kortti.saldo());
    }
    
    @Test
    public void saldoVaheneeOikeinJosRahaaTarpeeksi(){
        kortti.otaRahaa(2);
        assertEquals(8, kortti.saldo());
}
    @Test
    public void saldoEiMuutuJosRahaaEiOleTarpeeksi(){
        kortti.otaRahaa(12);
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void saldoPalauttaaTrueJosSaldoRiittaa(){
        assertTrue(kortti.otaRahaa(8)==true);
    }
    
    @Test
    public void saldoPalauttaaFalseJosSaldoEiRiita(){
        assertTrue(kortti.otaRahaa(12)==false);
    }
    
    @Test
    public void toStringPalauttaaMitaPitaakin(){
        assertEquals("saldo: 0.10", kortti.toString());
    }
}
