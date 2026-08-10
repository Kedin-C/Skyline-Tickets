/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.RolesDao;
import Model.Usuario;
import View.Asignar_rol_view;
import View.Pagina_principal_administrador_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author juans
 */
public class Asignar_rol_controller implements ActionListener{
    
    private Pagina_principal_administrador_view admin;
    private Asignar_rol_view view;
    private RolesDao roles;
    private Usuario usuario;
    private String Rol = "";

    public Asignar_rol_controller(Pagina_principal_administrador_view admin, Asignar_rol_view view,Usuario usuario) {
        this.admin = admin;
        this.view = view;
        this.usuario = usuario;
        this.roles = new RolesDao();
        this.view.volver.addActionListener(this);
        this.view.reasignar.addActionListener(this);
        this.view.btnAsignar.addActionListener(this);
//        cargarTabla();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == view.volver){
            view.setVisible(false);
            admin.setVisible(true);
            admin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }else if(e.getSource() == view.reasignar){
            int fila = view.tabla.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor, seleccione un usuario de la tabla para continuar.",
                        "Usuario no seleccionado",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            
            String rol = view.tabla.getValueAt(fila, 3).toString();
            if(rol == "Administrador"){
                Rol = "Administrador";
            }else if(rol == "Tecnico"){
                Rol = "Tecnico";
            }else if(rol == "Usuario"){
                Rol = "Usuario";
            }
            
            view.roles.setSelectedItem(rol);
            
            String nombre = view.tabla.getValueAt(fila, 0).toString() + " " + view.tabla.getValueAt(fila, 1).toString();
            view.nombre.setText(nombre + "?");
            
            view.mostrarModalRoles();
        }else if(e.getSource() == view.btnAsignar){
            if(Rol.equals(view.roles.getSelectedItem())){
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor, seleccione un rol diferente al que ya tiene el usuario para reasignar.",
                        "Roles iguales",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }else{
                int fila = view.tabla.getSelectedRow();
                String rol = view.roles.getSelectedItem().toString();
                String correo = view.tabla.getValueAt(fila, 2).toString();
                
                roles.AsignarRol(rol, correo);
                cargarTabla();
                view.modal.setVisible(false);
            }
        }
    }
    
    public void cargarTabla(){
        String correo = usuario.getCorreo();
        List datos = roles.listarUsuarios(correo);
        DefaultTableModel modelo = (DefaultTableModel) view.tabla.getModel();
        modelo.setRowCount(0);

        for (Object obj : datos) {
            Object[] fila = (Object[]) obj;
            modelo.addRow(fila);
        }
    }
    
}
