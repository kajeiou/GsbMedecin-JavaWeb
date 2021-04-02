/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Collection;
import java.util.Map;

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pays France = new Pays();
        France.getLesMedsParSpe("URGENTISTE");
        System.out.println("Fin du programme.");

    }

}
