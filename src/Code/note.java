/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author aleja
 */
public class note {
    
   public String Nom;
   double  Frequence;
   int Touche;
    public   note(String nom, double Frequence,int Touche)
    {
        
        
        this.Frequence=Frequence;
        this.Nom=nom;
        this.Touche=Touche;
    }
    public double getFreq() {return Frequence;}
    public int getTouche (){return Touche;}
    
}
