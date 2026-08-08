/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juans
 */
public class Asignar_rol_view extends Interfaz_vista_abtractas{
    
    private Container contenedor;
    private JPanel panel1,panel2,paneltitulo,panelInferior,panelTituloUsu,panelUsuarios,panelasignar,
            panelModal,panelCombo,panelBotonAsignar;
    private JLabel titulo,tituloUsu,tituloModal;
    public JLabel nombre;
    public JButton volver,reasignar,btnAsignar;
    private JScrollPane scroll;
    public JComboBox roles;
    private String listaRoles[] = {"Administrador","Tecnico","Usuario"};
    
    public JScrollPane scrollReportes;
    public DefaultTableModel modelo;
    public JTable tabla;
    public JDialog modal;

    public Asignar_rol_view() {
        super("Asignar Rol");
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();
        
        titulo = new JLabel("ASIGNAR ROL");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setForeground(Color.white);
        
        paneltitulo = new JPanel();
        paneltitulo.setBorder(new EmptyBorder(25,0,0,210));
        paneltitulo.setBackground(null);
        paneltitulo.add(titulo);

        panel1.add(paneltitulo);
        
        tituloUsu = new JLabel("Lista Usuarios");
        tituloUsu.setFont(new Font("Arial", Font.BOLD, 35));
        tituloUsu.setForeground(Color.black);
        
        panelTituloUsu = new JPanel();
        panelTituloUsu.setBackground(null);
        panelTituloUsu.setBorder(new EmptyBorder(65, 0, 20, 0));
        panelTituloUsu.add(tituloUsu);

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("NOMBRE ");
        modelo.addColumn("APELLIDO ");
        modelo.addColumn("CORREO ");
        modelo.addColumn("ROL ");

        tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 18));
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        tabla.setRowHeight(30);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setBackground(Color.decode("#D9D9D9"));
        tabla.setRowSelectionAllowed(true);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.getTableHeader().setResizingAllowed(false);

        // Crear un renderer para centrar contenido
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar el renderer a todas las columnas
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        
        
        reasignar = new JButton("Reasignar Rol");
        reasignar.setPreferredSize(new Dimension(200, 40));
        reasignar.setBackground(Color.decode("#037FB9"));
        reasignar.setForeground(Color.WHITE);
        
        panelasignar = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 10));
        panelasignar.setPreferredSize(new Dimension(1000,300));
        panelasignar.add(reasignar);
        
        scroll = new JScrollPane(tabla);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(1100, 350)); 
        panelUsuarios = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelUsuarios.add(scroll);
        panelUsuarios.add(panelasignar);

        panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 60, 10));
        panelInferior.setBorder(new EmptyBorder(0, 0, 20, 0));
        volver = super.getVolver();
        panelInferior.add(volver);

        panel2.setLayout(new BorderLayout());
        panel2.add(panelTituloUsu, BorderLayout.NORTH);
        panel2.add(panelUsuarios, BorderLayout.CENTER);
        panel2.add(panelInferior, BorderLayout.SOUTH);

        modal = new JDialog(this, "Rasignación Rol", true);
        modal.setLayout(new FlowLayout(FlowLayout.CENTER));

        panelModal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelModal.setPreferredSize(new Dimension(150, 150));

        panelCombo = new JPanel();
        panelCombo.setLayout(new BoxLayout(panelCombo, BoxLayout.Y_AXIS));

        tituloModal = new JLabel("¿Deseas reasignar un rol a la cuenta de");
        tituloModal.setBorder(new EmptyBorder(10, 0, 0, 0));
        nombre = new JLabel("");
        nombre.setFont(new Font("Arial", Font.BOLD, 15));
        nombre.setBorder(new EmptyBorder(10, 0, 10, 0));
        roles = new JComboBox(listaRoles);
        roles.setMaximumSize(new Dimension(200, 30));

        tituloModal.setAlignmentX(Component.CENTER_ALIGNMENT);
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        roles.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCombo.add(tituloModal);
        panelCombo.add(nombre);
        panelCombo.add(roles);

        panelBotonAsignar = new JPanel();
        panelBotonAsignar.setLayout(new BoxLayout(panelBotonAsignar, BoxLayout.Y_AXIS));
        btnAsignar = new JButton("Reasignar rol");
        btnAsignar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelBotonAsignar.add(btnAsignar);

        panelModal = new JPanel();
        panelModal.setLayout(new BoxLayout(panelModal, BoxLayout.Y_AXIS));
        panelModal.add(panelCombo);
        panelModal.add(Box.createVerticalStrut(15));
        panelModal.add(panelBotonAsignar);

        modal.add(panelModal);
    }

    public void mostrarModalRoles() {
//        modal.setSize(250, 200);
        panelModal.setPreferredSize(new Dimension(250, 200));
        modal.pack();
        modal.setLocationRelativeTo(this);
        modal.setVisible(true);
    }
    
    
    
}
