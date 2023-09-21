package modelo;

import Controlador.CtrlInstrumentos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import vista.FormInstrumentos;

public class MLogin {

    public void validaUsuario(JTextField usuario, JPasswordField password) {
        try {
            ResultSet rs = null;
            PreparedStatement ps = null;
            modelo.MConexion objetoConexion = new modelo.MConexion();
            String consulta = "select * from Usuarios where ingresoUsuario = (?) and ingresoPassword = (?);";
            ps = objetoConexion.estableceConexion().prepareStatement(consulta);

            ps.setString(1, usuario.getText());
            ps.setString(2, String.valueOf(password.getPassword()));
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El usuario es Correcto");
                //FormInstrumentos menuInstrumentos = new FormInstrumentos();

                MInstrumentos mod = new MInstrumentos();
                MConsultarInstrumentos modC = new MConsultarInstrumentos();
                FormInstrumentos frm = new FormInstrumentos();

                CtrlInstrumentos ctrl = new CtrlInstrumentos(mod, modC, frm);

                ctrl.iniciar();

                frm.setVisible(true);

            
            } else {
                JOptionPane.showMessageDialog(null, "El usuario es Incorrecto, Vuelva a Intentar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }
}
