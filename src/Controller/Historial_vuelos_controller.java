/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import View.Buscar_vuelos_view;
import View.Historial_vuelos_view;
import View.Inicio_usuario_view;
import View.Pagina_principal_administrador_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david
 */
public class Historial_vuelos_controller implements ActionListener{
     
    private Historial_vuelos_view vista;
    private Pagina_principal_administrador_view vista_admin;
    private Inicio_usuario_view vista_usuario;
    private Ticket_dao dao = new Ticket_dao();
    public DefaultTableModel modelo;
    private Usuario usu;
    private Buscar_vuelos_view buscar_vista;
    private Buscar_vuelos_controller buscar_cont;
    
    public Historial_vuelos_controller(Historial_vuelos_view vista,Pagina_principal_administrador_view vista_admin,Inicio_usuario_view vista_usuario,Usuario usuario,Buscar_vuelos_view buscar_vista,Buscar_vuelos_controller buscar_cont){
    
        this.buscar_cont = buscar_cont;
        this.vista = vista;
        this.vista_admin = vista_admin;
        this.vista_usuario = vista_usuario;
        this.modelo = this.vista.modelo;
        this.usu = usuario;
        this.buscar_vista = buscar_vista;
        
        
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        
        usu.setIdUsuario(7);
        
        this.vista.continuar.addActionListener(this);
        this.vista.volver.addActionListener(this);
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.continuar){
            
            int column = vista.tabla.getSelectedRow();
            
            if(column == -1){
                JOptionPane.showMessageDialog(vista,"Por favor seleccione uno de los vuelos");
            }else{
                vista.setVisible(false);

                buscar_cont.limpiarTabla();
                buscar_cont.getListarHistorial(buscar_vista.tabla);

                buscar_vista.setPagina_anterior(4);
                buscar_vista.setVisible(true);
                buscar_vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
            
                
            }
        
        }
        
        if(e.getSource() == vista.volver){
            if(vista.getVista_anterior() == 1){
                vista.setVisible(false);
                
                vista_usuario.setVisible(true);
                vista_usuario.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else if(vista.getVista_anterior() == 2){
                vista.setVisible(false);
                
                vista_admin.setVisible(true);
                vista_admin.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
            
        }
        
    }
    
    
    public void SetRow(){
    
     Object[] objeto = new Object[5];
        
        
        List<Ticket> lista = dao.getTotalVuelosList(usu);

        
        for(int i = 0; i<lista.size(); i++){
        
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getOrigen();
            objeto[2] = lista.get(i).getDestino();
            objeto[3] = lista.get(i).getTipo_vuelo();
            objeto[4] = lista.get(i).getFecha();

            
            modelo.addRow(objeto);
        }
    }
    
    public void ResetRow(){
        
        
        for(int i = 0; i<vista.tabla.getRowCount(); i++){
        modelo.removeRow(i);
        i = i-1;
        }
    }


}
