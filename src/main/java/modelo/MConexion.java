package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MConexion {

        private final String db = "pruebaKinal";
        private final String user = "root";
        private final String password = "12345";
        private final String ip = "localhost:3316";
        private final String url = "jdbc:mysql://" + ip + "/" + db;
        private Connection con = null;

        public Connection estableceConexion() {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(this.url, this.user, this.password);
                //JOptionPane.showMessageDialog(null, "Se Conecto Correctamente a la DB: ");

            } catch (SQLException e) {
                System.err.println(e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MConexion.class.getName()).log(Level.SEVERE, null, ex);
            }

            return con;
        }

}