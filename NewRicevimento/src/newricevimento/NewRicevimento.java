/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newricevimento;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author di_lella_andrea
 */
public class NewRicevimento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        List<Docente> lista = null;
        Parser dom = new Parser();
        System.out.println("1)quali prof ricevono 2)quando riceve un prof 3)orario della classe");
        int testo = tastiera.nextInt();
        try{
            System.out.println("inserisci il giorno");
            String giorno = tastiera.next();
            lista = dom.parseDocument("ricevimento_docenti.xml",giorno);
            switch(testo){
                case 1:
                    for(Docente d : lista)
                        System.out.println(d.getNome());
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                default:
                    System.out.println("errore di digitazione");
                    break;
            }
        }
        catch(Exception e){}
    }
    
}
