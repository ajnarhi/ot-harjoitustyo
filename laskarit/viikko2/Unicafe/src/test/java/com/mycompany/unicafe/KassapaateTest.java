/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ajnarhi
 */
public class KassapaateTest {
    
    Kassapaate kassapaate;
   
    
    @Before
    public void setUp() {
        kassapaate=new Kassapaate();
    }

    @Test
    public void kassapaatteenRahamaaraOikea(){
        int odotettuMaara = 100000;
        assertEquals(odotettuMaara, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void lounaitaMyytyNolla(){
        int odotettuMaara=0;
        int lounaitaMyytyYhteensa=kassapaate.edullisiaLounaitaMyyty()+kassapaate.maukkaitaLounaitaMyyty();
        assertEquals(odotettuMaara, lounaitaMyytyYhteensa);
    }
    
    @Test
    public void edullisenOstoKassaKasvaaLounaanHinnalla(){
        int odotettuMaara=100240;
        kassapaate.syoEdullisesti(240);
        assertEquals(odotettuMaara, kassapaate.kassassaRahaa());
    }
    
   @Test
    public void maukkaanOstoKassaKasvaaLounaanHinnalla(){
        int odotettuMaara=100400;
        kassapaate.syoMaukkaasti(400);
        assertEquals(odotettuMaara, kassapaate.kassassaRahaa());
    }
    
    
    
    @Test
    public void edullisenOstoVaihtorahanSuuruusOikea(){
    int maksu=kassapaate.syoEdullisesti(500);
    int odotettuMaara=260;
    
    assertEquals(odotettuMaara, maksu);
    
    
    
}
    
 @Test
    public void maukkaanOstoVaihtorahanSuuruusOikea(){
    int maksu=kassapaate.syoMaukkaasti(500);
    int odotettuMaara=100;
    
    assertEquals(odotettuMaara, maksu);   
}
    
    @Test
    public void edullinenOstosLounaidenMaaraKasvaaYhdella(){
        int odotettuMaara=1;
        kassapaate.syoEdullisesti(240);
        assertEquals(odotettuMaara, kassapaate.edullisiaLounaitaMyyty());
        
    }

    @Test
    public void maukkaanOstosLounaidenMaaraKasvaaYhdella(){
        int odotettuMaara=1;
        kassapaate.syoMaukkaasti(400);
        assertEquals(odotettuMaara, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenRahaEiRiitaRahamaaraKassassaEiMuutu(){
       
        int odotettuMaara=100000;
        kassapaate.syoEdullisesti(100);
        assertEquals(odotettuMaara, kassapaate.kassassaRahaa());
    }
    @Test
    public void maukasRahaEiRiitaRahamaaraKassassaEiMuutu(){
       
        int odotettuMaara=100000;
        kassapaate.syoMaukkaasti(100);
        assertEquals(odotettuMaara, kassapaate.kassassaRahaa());
    }
    
     @Test
    public void edullisenOstoVaihtorahanSuuruusSamaMikaAnnettuRaha(){
    int maksu=kassapaate.syoEdullisesti(100);
    int odotettuMaara=100;
    
    assertEquals(odotettuMaara, maksu);
    
    
    
}
    
 @Test
    public void maukkaanOstoVaihtorahanSuuruusSamaMikaAnnettuRaha(){
    int maksu=kassapaate.syoMaukkaasti(100);
    int odotettuMaara=100;
    
    assertEquals(odotettuMaara, maksu);   
}
    
    @Test
    public void edullisestiRahaaEiTarpeeksiLounaidenMaaraEiKasva(){
        int odotettuMaara=0;
        kassapaate.syoEdullisesti(100);
        assertEquals(odotettuMaara, kassapaate.edullisiaLounaitaMyyty());
        
    }
      
   @Test
    public void maukkaastiRahaaEiTarpeeksiLounaidenMaaraEiKasva(){
        int odotettuMaara=0;
    kassapaate.syoMaukkaasti(100);
        assertEquals(odotettuMaara, kassapaate.maukkaitaLounaitaMyyty());
        
    }
    
    @Test
    public void edullinenLounasKortillaTarpeeksiRahaaPalautetaanTrue(){
        Maksukortti kortti=new Maksukortti(1000);
        assertTrue(kassapaate.syoEdullisesti(kortti)==true);
    }
    @Test
    public void maukasLounasKortillaTarpeeksiRahaaPalautetaanTrue(){
        Maksukortti kortti=new Maksukortti(1000);
        assertTrue(kassapaate.syoMaukkaasti(kortti)==true);
    }
   
     @Test
    public void edullinenLounasKortillaTarpeeksiRahaaVeloitetaanOikeaSumma(){
        int odotettuMaara=760;
        Maksukortti kortti=new Maksukortti(1000);
        kassapaate.syoEdullisesti(kortti);
        
       
        assertEquals(odotettuMaara,kortti.saldo());
    }
    @Test
    public void maukasLounasKortillaTarpeeksiRahaaVeloitetaanOikeaSumma(){
        int odotettuMaara=600;
        Maksukortti kortti=new Maksukortti(1000);
        kassapaate.syoMaukkaasti(kortti);
        
       
        assertEquals(odotettuMaara,kortti.saldo());
    }
    
    @Test
    public void edullinenLounasOstettujenLounaidenMaaraKasvaa(){
        Maksukortti kortti=new Maksukortti(1000);
         kassapaate.syoEdullisesti(kortti);
         
         assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasLounasOstettujenLounaidenMaaraKasvaa(){
        Maksukortti kortti=new Maksukortti(1000);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
      @Test
    public void edullinenLounasKortillaEITarpeeksiRahaaPalautetaanFalse(){
        Maksukortti kortti=new Maksukortti(100);
        assertTrue(kassapaate.syoEdullisesti(kortti)==false);
    }
    @Test
    public void maukasLounasKortillaEITarpeeksiRahaaPalautetaanFalse(){
        Maksukortti kortti=new Maksukortti(100);
        assertTrue(kassapaate.syoMaukkaasti(kortti)==false);
    }
    
    
    @Test
    public void edullinenLounasKortillaEiTarpeeksiRahaaKortinRahamaaraEiMuutu(){
        int odotettuMaara=100;
        Maksukortti kortti=new Maksukortti(100);
        kassapaate.syoEdullisesti(kortti);
        
       
        assertEquals(odotettuMaara,kortti.saldo());
    }
    @Test
    public void maukasLounasKortillaEiTarpeeksiRahaaKortinRahamaaraEiMuutu(){
        int odotettuMaara=100;
        Maksukortti kortti=new Maksukortti(100);
        kassapaate.syoMaukkaasti(kortti);
        
       
        assertEquals(odotettuMaara,kortti.saldo());
    }
    
     @Test
    public void edullinenLounasKortillaEiRahaaOstettujenLounaidenMaaraEiKasva(){
        Maksukortti kortti=new Maksukortti(100);
         kassapaate.syoEdullisesti(kortti);
         
         assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasLounasKortillaEiRahaaOstettujenLounaidenMaaraEIKasva(){
        Maksukortti kortti=new Maksukortti(100);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenLounasKassassaOlevaRahamaaraEiMuutuKunOstetaanKortilla(){
        Maksukortti kortti=new Maksukortti(1000);
        kassapaate.syoEdullisesti(kortti);
        
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void maukasLounasKassassaOlevaRahamaaraEiMuutuKunOstetaanKortilla(){
        Maksukortti kortti=new Maksukortti(1000);
        kassapaate.syoMaukkaasti(kortti);
        
        assertEquals(100000, kassapaate.kassassaRahaa());
        
    }
    
    @Test
    public void lataaRahaaKortilleKortinSaldoKasvaa(){
        Maksukortti kortti=new Maksukortti(0);
        kassapaate.lataaRahaaKortille(kortti, 500);
        
        assertEquals(500, kortti.saldo());
        
    }
    
    @Test
    public void lataaRahaaKortilleKassanSaldoKasvaa(){
        Maksukortti kortti=new Maksukortti(0);
        kassapaate.lataaRahaaKortille(kortti, 500);
        
        assertEquals(100500, kassapaate.kassassaRahaa());
        
    }
    
    @Test
    public void ladataanNegatiivinenMaaraRahaaKortille(){
        Maksukortti kortti=new Maksukortti(0);
        kassapaate.lataaRahaaKortille(kortti, -500);
        
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
}
