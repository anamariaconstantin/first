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
public class NrFix extends NrTel {
    /*
     private boolean verificareTel(long param){
     int cifra= (int)param / 100000000;
     int prefix=(int) ((param/1000000)%100);
     if( cifra != 2|| cifra != 3  ) 
     return false;
     
     if(prefix/10 == 1 || (prefix>=30 && prefix<=69)) {
         
         
     if(cifra==2 ) operator = "Telekom Romania";
     else
     operator = " RCS&RDS Romania";
         
         
         
     return true;
     }
     
     return false;
      
         
      
     }

     /*public NrTel () {
     }
     */

    /*public NrTel (String parametru){
		
     }
     */
    /*	public String toString(){
	
     }
     Nu este cazul. Este mostentina de la NrTel.
     */
    public NrFix(String param) {

        this.numar = param;

    }

    /*
     protected NrFix clone() throws CloneNotSupportedException {
     NrFix clona;

     clona = new NrFix(this);
        
     return clona;

     }*/
    
    public String toString(){
    return numar;
    }
}
