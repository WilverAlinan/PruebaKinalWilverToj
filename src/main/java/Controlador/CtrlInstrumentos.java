package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.MConsultarInstrumentos;
import modelo.MInstrumentos;
import vista.FormInstrumentos;

public class CtrlInstrumentos implements ActionListener {

    private final MInstrumentos modelo;
    private final MConsultarInstrumentos consultas;
    private final FormInstrumentos vista;

    public CtrlInstrumentos(MInstrumentos modelo, MConsultarInstrumentos consultas, FormInstrumentos vista) {

        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;

        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Prueba Kinal Wilver Toj Tienda: ");
        vista.setLocationRelativeTo(null);
        vista.txtId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnGuardar) {
            modelo.setCodigo(vista.txtCodigo.getText());
            modelo.setMarca(vista.txtMarca.getText());
            modelo.setModelo(Integer.parseInt(vista.txtModelo.getText()));
            modelo.setTipoInstrumento(vista.txtTipoInstrumento.getText());
            modelo.setPrecio(Double.valueOf(vista.txtPrecio.getText()));
            modelo.setMesesGarantia(Integer.parseInt(vista.txtMesesGarantia.getText()));
            modelo.setPaisProcedencia(vista.txtPaisProcedencia.getText());

            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnModificar) {

            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            modelo.setCodigo(vista.txtCodigo.getText());
            modelo.setMarca(vista.txtMarca.getText());
            modelo.setModelo(Integer.parseInt(vista.txtModelo.getText()));
            modelo.setTipoInstrumento(vista.txtTipoInstrumento.getText());
            modelo.setPrecio(Double.valueOf(vista.txtPrecio.getText()));
            modelo.setMesesGarantia(Integer.parseInt(vista.txtMesesGarantia.getText()));
            modelo.setPaisProcedencia(vista.txtPaisProcedencia.getText());

            if (consultas.modificar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnEliminar) {

            modelo.setId(Integer.parseInt(vista.txtId.getText()));

            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Elimiado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnBuscar) {
            modelo.setCodigo(vista.txtCodigo.getText());

            if (consultas.buscar(modelo)) {
                vista.txtId.setText(String.valueOf(modelo.getId()));
                vista.txtCodigo.setText(modelo.getCodigo());
                vista.txtMarca.setText(modelo.getMarca());
                vista.txtModelo.setText(String.valueOf(modelo.getModelo()));
                vista.txtTipoInstrumento.setText(modelo.getTipoInstrumento());
                vista.txtPrecio.setText(String.valueOf(modelo.getPrecio()));
                vista.txtMesesGarantia.setText(String.valueOf(modelo.getMesesGarantia()));
                vista.txtPaisProcedencia.setText(modelo.getPaisProcedencia());

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro Registro");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        vista.txtId.setText(null);
        vista.txtCodigo.setText(null);
        vista.txtMarca.setText(null);
        vista.txtModelo.setText(null);
        vista.txtTipoInstrumento.setText(null);
        vista.txtPrecio.setText(null);
        vista.txtMesesGarantia.setText(null);
        vista.txtPaisProcedencia.setText(null);
    }

}
