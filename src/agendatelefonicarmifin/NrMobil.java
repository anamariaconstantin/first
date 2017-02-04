/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;

/**
 *
 * @author ana-maria.constantin
 */
public class NrMobil extends NrTel {

    /*
     private boolean verificareTel(long param) {
     int cifra = (int) param / 100000000;
     int prefix = (int) ((param / 1000000) % 100);
     if (cifra != 7) {
     return false;
     }

     if (prefix >= 20 && prefix <= 39) {
     operator = "Vodafone Romania ";

     return true;
     }
     if (prefix >= 40 && prefix <= 59) {
     operator = "Orange Romania ";

     return true;
     }

     if ((prefix >= 60 && prefix <= 69) || (prefix == 84) || (prefix == 85) || (prefix == 86)) {
     operator = "Telekom Romania ";

     return true;
     }

     if ((prefix == 80) || (prefix == 80)) {
     operator = "Zapp Romania ";

     return true;
     }

     if ((prefix == 70) || (prefix == 71) || (prefix == 72)) {
     operator = "DigiMobil Romania ";

     return true;
     }
     return false;
     }

     */
    public NrMobil(String param) {

        this.numar = param;

    }
    /*protected NrMobil clone() throws CloneNotSupportedException {
     NrMobil clona;

     clona = new NrMobil(this);
        
     return clona;

     }*/
}

/*	public String toString(){
		
 }
 Nu este cazul. Este mostentina de la NrTel
 */
