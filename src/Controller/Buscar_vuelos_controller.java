/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Vuelos;
import Model.VuelosDao;
import View.Buscar_vuelos_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import Model.Datos;
import View.And_puestos;
import View.Cambio_de_clase_de_vuelo_viiew;
import Model.Usuario;
import View.Elegir_clase_view;
import View.Elegir_puestos_view;
import View.Historial_vuelos_view;
import View.Inicio_usuario_view;
import View.Pagina_principal_administrador_view;
import View.Seleccion_de_Modificacion_de_vuelo_view;
import View.Seleccion_forma_de_pago_view;
import View.ViewPrincipal;
import javax.swing.JFrame;

public class Buscar_vuelos_controller implements ActionListener{
    
    ViewPrincipal principal;
    Pagina_principal_administrador_view pagina_admin;
    Inicio_usuario_view pagina_usuario;
    Vuelos vuelo = new Vuelos();
    VuelosDao vuelodao = new VuelosDao();
    Buscar_vuelos_view vista = new Buscar_vuelos_view();
    DefaultTableModel modelo = new DefaultTableModel();
    Datos datos = new Datos();
    Elegir_clase_view vistaElegirClase = new Elegir_clase_view();
    private Historial_vuelos_view historial_vista;
    public String origen, destino, hora1, hora2;
    public Date fechaIda, fechaRegreso;
    private And_puestos pva;
    private Seleccion_forma_de_pago_view forma_pago_vista;
    private Cambio_de_clase_de_vuelo_viiew cambio_vuelo;
    private Usuario usuario;
    private ViewPrincipal vistaPrincipal;
    private Pagina_principal_administrador_view viewAdmin;
    private Inicio_usuario_view viewUsuario;
    
    public Buscar_vuelos_controller(Buscar_vuelos_view vista, Datos datos,ViewPrincipal principal,Pagina_principal_administrador_view pagina_admin,Inicio_usuario_view pagina_usuario,Historial_vuelos_view historial_vista,And_puestos pva,Seleccion_forma_de_pago_view forma_pago_vista,Cambio_de_clase_de_vuelo_viiew cambio_vuelo, Usuario usuario, ViewPrincipal vistaPrincipal, Pagina_principal_administrador_view viewAdmin, Inicio_usuario_view viewUsuario){
        
        this.forma_pago_vista = forma_pago_vista;
        this.principal = principal;
        this.pagina_admin = pagina_admin;
        this.pagina_usuario = pagina_usuario;
        this.historial_vista = historial_vista;
        this.pva = pva;
        this.cambio_vuelo = cambio_vuelo;
        this.usuario = usuario;
        this.vistaPrincipal = vistaPrincipal;
        this.viewAdmin = viewAdmin;
        this.viewUsuario = viewUsuario;
        
        this.vista = vista;
        this.datos = datos;
        
        this.vista.buscar_vuelos.addActionListener(this);
        this.vista.siguiente.addActionListener(this);
        this.vista.volver.addActionListener(this);
        
        this.vistaElegirClase.volver.addActionListener(this);
        
        ButtonGroup grupoViaje = new ButtonGroup();
        grupoViaje.add(vista.vuelo_ida);
        grupoViaje.add(vista.vuelo_regreso);
        
        this.vista.vuelo_ida.addActionListener(this);
        this.vista.vuelo_regreso.addActionListener(this);
        
        this.vista.vuelo_ida.setSelected(true);
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 2);
        Date dosDiasDespues = cal.getTime();
        
        this.vista.elegir_fecha_ida.setMinSelectableDate(dosDiasDespues);
        this.vista.elegir_fecha_regreso.setMinSelectableDate(dosDiasDespues);
        
        this.vista.elegir_fecha_regreso.setEnabled(false);
        
        this.vista.tabla.getTableHeader().setReorderingAllowed(false);
        this.vista.tabla.getTableHeader().setResizingAllowed(false);
        this.vista.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.modelo = (DefaultTableModel) this.vista.tabla.getModel();
        
        var modeloColumnas = this.vista.tabla.getColumnModel();
        modeloColumnas.getColumn(0).setMinWidth(0);
        modeloColumnas.getColumn(0).setPreferredWidth(0);
        modeloColumnas.getColumn(0).setMaxWidth(0);
        modeloColumnas.getColumn(0).setResizable(false);
        
        JTextField editorFecha1 = (JTextField) vista.elegir_fecha_ida.getDateEditor().getUiComponent();
        editorFecha1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                e.consume();
            }
        });
        
        JTextField editorFecha2 = (JTextField) vista.elegir_fecha_regreso.getDateEditor().getUiComponent();
        editorFecha2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                e.consume();
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource() == vista.volver){
            
            if(vista.getPagina_anterior() == 1){
            vista.setVisible(false);
            
            principal.setVisible(true);
            principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else if(vista.getPagina_anterior() == 2){
            vista.setVisible(false);
            
            pagina_usuario.setVisible(true);
            pagina_usuario.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else if(vista.getPagina_anterior() == 3){
            vista.setVisible(false);
            
            pagina_admin.setVisible(true);
            pagina_admin.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else if(vista.getPagina_anterior() == 4){
            vista.setVisible(false);
            
            limpiarTabla();
            historial_vista.setVisible(true);
            historial_vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }
        
        if(e.getSource() == vista.siguiente){
            
            pva.setNumero(1);
            int filaVuelo = vista.tabla.getSelectedRow();
            
            if (filaVuelo == -1) {
                JOptionPane.showMessageDialog(
                        vista,
                        "Por favor, seleccione un vuelo de la tabla para continuar.",
                        "Vuelo no seleccionado",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            
            int id = Integer.parseInt(vista.tabla.getValueAt(filaVuelo, 0).toString());
            double precio = Double.parseDouble(vista.tabla.getValueAt(filaVuelo, 6).toString());
            datos.setCodigoVuelo(id);
            datos.setTotalPagar(precio);
            
            if(vista.vuelo_ida.isSelected()){
                datos.setTipoVuelo("Vuelo de ida");
            }else{
                
                validarRegreso();
                datos.setTipoVuelo("Vuelo de ida y vuelta");
                
                SimpleDateFormat formateadorRegreso = new SimpleDateFormat("yyyy-MM-dd");
                //aplicando el metodo que deja la fecha tal cual en el campo de fecha regreso
                String fechaRegreso = formateadorRegreso.format(vista.elegir_fecha_regreso.getDate());
                datos.setFechaRegreso(fechaRegreso);
            }
            
            vista.setVisible(false);
            this.vistaElegirClase.setVisible(true);
            
            Elegir_clase_controller controllerElegirClase = new Elegir_clase_controller(vistaElegirClase,datos,cambio_vuelo,pva,forma_pago_vista, usuario, vistaPrincipal, viewAdmin, viewUsuario);            
        }
        
        if(e.getSource() == vista.buscar_vuelos){
           
            if(vista.listar_origen.getSelectedIndex() > 0 &&
               vista.listar_destino.getSelectedIndex() > 0 &&
               vista.elegir_fecha_ida.getDate() != null){

                validarRegreso();
                getListar(vista.tabla);
            
            }else {
                JOptionPane.showMessageDialog(vista, 
                        "Asegurate de llenar lugar de origen, \n"
                        + "lugar de destino y la fecha de ida","Ten cuidado", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        
        if (vista.vuelo_ida.isSelected()) { 
            
            vista.elegir_fecha_regreso.setEnabled(false);
            
            vista.elegir_fecha_regreso.setDate(null);
            
        } else if (vista.vuelo_regreso.isSelected()) {
            
            vista.elegir_fecha_regreso.setEnabled(true);
        }
        
        if(e.getSource() == vistaElegirClase.volver){
            vista.setVisible(true);
            this.vistaElegirClase.setVisible(false);
        }
        
    }
    
    
    
    public void getListar(JTable tabla){
        origen = vista.listar_origen.getSelectedItem().toString();
        destino = vista.listar_destino.getSelectedItem().toString();
        fechaIda = vista.elegir_fecha_ida.getDate();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fechaExacta = formateador.format(fechaIda);
        
        modelo=(DefaultTableModel) tabla.getModel();
        List<Vuelos> lista = vuelodao.listarIda(origen, destino, fechaExacta);
        Object[] objeto = new Object[7];
        
        modelo.setRowCount(0);
        
        for(int i=0; i<lista.size(); i++){
            objeto[0]=lista.get(i).getCodigo_vuelo();
            objeto[1]=lista.get(i).getOrigen();
            objeto[2]=lista.get(i).getDestino();
            objeto[3]=lista.get(i).getFecha();
            objeto[4]=lista.get(i).getHora_salida();
            objeto[5]=lista.get(i).getHora_llegada();
            objeto[6]=lista.get(i).getPrecio();
            modelo.addRow(objeto);
        }
        vista.tabla.setModel(modelo);
        
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(vista, "No encontramos resultados");
        }
      
    }
    
    public void getListarHistorial(JTable tabla){
        origen = vista.listar_origen.getSelectedItem().toString();
        destino = vista.listar_destino.getSelectedItem().toString();
        
        modelo=(DefaultTableModel) tabla.getModel();
        int v = historial_vista.tabla.getSelectedRow();
        List<Vuelos> lista = vuelodao.listarIda_historial((String)historial_vista.tabla.getValueAt(v, 1),(String)historial_vista.tabla.getValueAt(v, 2));
        Object[] objeto = new Object[7];
        
        modelo.setRowCount(0);
        
        for(int i=0; i<lista.size(); i++){
            objeto[0]=lista.get(i).getCodigo_vuelo();
            objeto[1]=lista.get(i).getOrigen();
            objeto[2]=lista.get(i).getDestino();
            objeto[3]=lista.get(i).getFecha();
            objeto[4]=lista.get(i).getHora_salida();
            objeto[5]=lista.get(i).getHora_llegada();
            objeto[6]=lista.get(i).getPrecio();
            modelo.addRow(objeto);
        }
        vista.tabla.setModel(modelo);
        
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(vista, "No encontramos resultados");
        }
        
      
    }
    
    
    
    public void getListarHorario(JTable tabla){
        origen = vista.listar_origen.getSelectedItem().toString();
        destino = vista.listar_destino.getSelectedItem().toString();
        fechaIda = vista.elegir_fecha_ida.getDate();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fechaExacta = formateador.format(fechaIda);
        
        String hora = vista.listar_horario.getSelectedItem().toString();
        
        String[] horario = hora.split("-");

        hora1 = horario[0];
        hora2 = horario[1];
        
        modelo=(DefaultTableModel) tabla.getModel();
        List<Vuelos> lista = vuelodao.listarIdaHorario(origen, destino, fechaExacta, hora1, hora2);
        Object[] objeto = new Object[7];
        
        modelo.setRowCount(0);
        
        for(int i=0; i<lista.size(); i++){
            objeto[0]=lista.get(i).getCodigo_vuelo();
            objeto[1]=lista.get(i).getOrigen();
            objeto[2]=lista.get(i).getDestino();
            objeto[3]=lista.get(i).getFecha();
            objeto[4]=lista.get(i).getHora_salida();
            objeto[5]=lista.get(i).getHora_llegada();
            objeto[6]=lista.get(i).getPrecio();
            modelo.addRow(objeto);
        }
        vista.tabla.setModel(modelo);
        
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(vista, "No encontramos resultados");
        }
    }
    
    public void limpiarTabla(){
        for(int i=0;i<vista.tabla.getRowCount(); i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }
    

    private void validarRegreso(){
        
        int puntos = 2;
        if(vista.vuelo_regreso.isSelected()){
            if(vista.elegir_fecha_regreso.getDate() != null){

                fechaIda = vista.elegir_fecha_ida.getDate();


                fechaRegreso = vista.elegir_fecha_regreso.getDate();
                //para que la fecha quede bien 
                SimpleDateFormat formateadorRegreso = new SimpleDateFormat("yyyy-MM-dd");
                //aplicando el metodo que deja la fecha tal cual en el campo de fecha regreso
                String fechaExacta2 = formateadorRegreso.format(fechaRegreso);


                if(fechaRegreso.after(fechaIda)){
                    datos.setFechaRegreso(fechaExacta2);
                }else{
                    JOptionPane.showMessageDialog(vista,
                        "La fecha de regreso no puede ser antes que la fecha de ida", "Fecha incoherente", JOptionPane.WARNING_MESSAGE);
                    puntos--;
                    limpiarTabla();
                    
                }
            }else {
                JOptionPane.showMessageDialog(vista,
                        "Debes elegir una fecha de regreso", "Fecha obligatoria", JOptionPane.WARNING_MESSAGE);
                puntos--;
                limpiarTabla();
                
            }
            
                limpiarTabla();
                if (vista.listar_horario.getSelectedIndex() == 0) {
                    getListar(vista.tabla);
                } else {
                    getListarHorario(vista.tabla);
                
            }
            
        }
    }
    
}
