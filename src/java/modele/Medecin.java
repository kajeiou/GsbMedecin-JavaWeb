/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author sio
 */
public class Medecin implements Comparable<Medecin>{
    private String nom,prenom,adresse,tel,spe,id;

    public Medecin(String nom, String prenom, String adresse, String tel, String spe, String id) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.spe = spe;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public String getSpe() {
        return spe;
    }

    @Override
    public int compareTo(Medecin o) {
        if(nom.compareTo(o.nom)==0) {
            return id.compareTo(o.id);
        }
        else {
            return nom.compareTo(o.nom);
        }
                
    }
    
    
}
