/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.UsuarioDAO;
import Vista.JFramePrincipal;
import Vista.JInternalFrameUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pavilion
 */
public class ControladorUsuario implements ActionListener{
    JFramePrincipal vistaPrincipal = new JFramePrincipal();
    JInternalFrameUsuarios vistaUsuario = new JInternalFrameUsuarios();
    UsuarioDAO modeloUsuario = new UsuarioDAO();

    public ControladorUsuario(JFramePrincipal vistaPrincipal, JInternalFrameUsuarios vistaUsuario, UsuarioDAO modeloUsuario) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.setVisible(true);
        this.vistaUsuario = vistaUsuario;
        this.modeloUsuario = modeloUsuario;
        this.vistaPrincipal.menuItemUsuarios.addActionListener(this);
        this.vistaUsuario.btnNuevo.addActionListener(this);
        this.vistaUsuario.btnGuardar.addActionListener(this);
        this.vistaUsuario.btnEditar.addActionListener(this);
        this.vistaUsuario.btnEliminar.addActionListener(this);
        this.vistaUsuario.btnCancelar.addActionListener(this);
        this.vistaUsuario.btnBuscar.addActionListener(this);
    }
    
    public void InicializarControladorUsuario(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaPrincipal.menuItemUsuarios){
            vistaPrincipal.jDesktopPane1.add(vistaUsuario);
            vistaUsuario.setVisible(true);
        }
        
        if(e.getSource() == vistaUsuario.btnGuardar){            
            String idUsuario = vistaUsuario.txtIdUsuario.getText();
            String username = vistaUsuario.txtUsername.getText();
            String clave = String.valueOf(vistaUsuario.pwdIngresarPassword.getPassword());
            String tipousuario = (String) vistaUsuario.cboxSeleccionarTipo.getSelectedItem();
            String nombres = vistaUsuario.txtNombres.getText();
            String apellidos = vistaUsuario.txtApellidos.getText();
            String cargo = vistaUsuario.txtCargo.getText();
            String area = vistaUsuario.txtArea.getText();
            String resultado = modeloUsuario.insertarUsuario(idUsuario, username, clave, tipousuario, nombres, apellidos, cargo, area);
            
            if(resultado != null){
                JOptionPane.showMessageDialog(null, resultado);
            }else{
                JOptionPane.showMessageDialog(null, "Error guardando el registro");
            }
        }
    }
    
}
