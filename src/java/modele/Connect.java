package modele;

import java.sql.*;

public class Connect { //singleton

    private static Connection con = null;

    private static Connection open() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Pilote mal installé ..." + e);
        }
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost/medecin", "sio", "linux");
        } catch (SQLException e) {
            System.out.println("Erreur SQL :" + e);
        }
        return con;
    }

    public static Connection get() {
        if (con == null) { //attention de ne jamais fermer la connection, sinon ajou
// || con.isClosed()
            con = Connect.open();
        }
        return con;
    }

    public static void close() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Erreur SQL :" + e);
        }
    }
}
