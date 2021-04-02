package modele;

import java.util.*;
import java.sql.*;

/**
 *
 * @author sio
 */
public class DAO {

    public static Collection<Departement> getLesDepartements() {
        try {
            Connection con = Connect.get();
            Statement reqDepartement;
            reqDepartement = con.createStatement();
            ResultSet rsDepartement = reqDepartement.executeQuery("select distinct departement from medecin");

            Collection<Departement> lesDepartements = new TreeSet<Departement>();
            
            
            while (rsDepartement.next()) {
                Collection <Medecin> lesMedecins = getLesMedecins(rsDepartement.getString("departement"));
                Departement dep = new Departement(rsDepartement.getString("departement"), lesMedecins);
                lesDepartements.add(dep);
                
            }
            rsDepartement.close();
            return lesDepartements;
            

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e);
            System.exit(-1);

        }

        return null;
    }
    public static Collection<Medecin> getLesMedecins(String numDep) {
        try {
            Collection<Medecin> resultat = new TreeSet<Medecin>();
            Connection con = Connect.get();
            Statement reqLesMedecins;
            reqLesMedecins= con.createStatement();
            String req = "select * from medecin where departement = "+numDep;
            ResultSet rsLesMedecins = reqLesMedecins.executeQuery(req);
            
            while(rsLesMedecins.next()) {
                Medecin m = new Medecin(rsLesMedecins.getString("nom"),rsLesMedecins.getString("prenom"),rsLesMedecins.getString("adresse"),rsLesMedecins.getString("tel"),rsLesMedecins.getString("specialitecomplementaire"),rsLesMedecins.getString("departement"));
                resultat.add(m);
            }
            return resultat;
            
        }
        catch (SQLException e) {
            System.out.println("Erreur SQL : " + e );
            
        }
        return null;
    }
}
