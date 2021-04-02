package modele;

import java.util.*;
import modele.DAO;

/**
 *
 * @author sio
 */
public class Pays {

    private Collection<Departement> lesDepartements;

    public Pays() {
        lesDepartements = DAO.getLesDepartements();
    }

    public Collection<Departement> getLesDepartements() {
        return lesDepartements;
    }

    public Departement getLeDep(String numDep) {
        for (Departement unDepartement : lesDepartements) {
            if (unDepartement.getNum().equals(numDep)) {
                return unDepartement;
            }
        }
        return null;
    }

    public Collection<Medecin> getLesMedsParSpe(String specialite) {
        Collection<Medecin> Meds = new ArrayList<Medecin>();

        for (Departement unDepartement : getLesDepartements()) {
            for (Medecin unMedecin : unDepartement.getLesMeds()) {
                if (unMedecin.getSpe() != null) {

                    if (unMedecin.getSpe().equals(specialite)) {
                        Meds.add(unMedecin);
                    }
                }
            }
        }
        return Meds;
    }
    public Collection<Medecin> getLesMedsParNom(String nom) {
        Collection<Medecin> Meds = new TreeSet<Medecin>();

        for (Departement unDepartement : getLesDepartements()) {
            for (Medecin unMedecin : unDepartement.getLesMeds()) {
                if (unMedecin.getNom() != null) {

                    if (unMedecin.getNom().startsWith(nom)) {
                        Meds.add(unMedecin);
                    }
                }
            }
        }
        return Meds;
    }
    

}
