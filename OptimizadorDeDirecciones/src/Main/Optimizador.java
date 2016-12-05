/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Modelo.*;
import Vista.*;
import Controlador.*;
/**
 *
 * @author Pavilion
 */
public class Optimizador {
    
    public static void main(String[] args){
        JFramePrincipal vistaPrincipal = new JFramePrincipal();
        JInternalFrameUsuarios vistaUsuarios = new JInternalFrameUsuarios();
        UsuarioDAO modeloUsuario = new UsuarioDAO();
        ControladorUsuario controladorUsuarios = new ControladorUsuario(vistaPrincipal, vistaUsuarios, modeloUsuario);
    }
}
