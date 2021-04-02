/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.*;

/**
 *
 * @author sio
 */
public class Departement implements Comparable<Departement> {
    private String num;
    private Collection <Medecin> lesMedecins= new HashSet<Medecin>();

    public Departement(String num, Collection<Medecin> lesMedecins) {
        this.num = num;
        this.lesMedecins = lesMedecins;
    }

    public String getNum() {
        return num;
    }
    

    public Collection<Medecin> getLesMeds() {
        return lesMedecins;
    }
    

    @Override
    public int compareTo(Departement o) {
       return num.compareTo(o.num); 
    }
}
