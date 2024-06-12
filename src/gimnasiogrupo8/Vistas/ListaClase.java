/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gimnasiogrupo8.Vistas;

import gimnasiogrupo8.accesoAData.ClaseData;
import gimnasiogrupo8.accesoAData.SociosData;

import gimnasiogrupo8.entidad.Clase;
import gimnasiogrupo8.entidad.Entrenador;
import gimnasiogrupo8.entidad.Socio;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ListaClase extends javax.swing.JInternalFrame {

     private ArrayList<Clase>listaClase;
    private ClaseData claseData;
    private DefaultTableModel modelo;
    
    public ListaClase() {
        initComponents();
        claseData = new ClaseData();
        modelo = new DefaultTableModel();
        armarCabeceraTabla();
        cargarSocios();
    }
    
    private void borrarFilaTabla(){
        int indice = modelo.getRowCount() - 1;
        
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void armarCabeceraTabla(){
        ArrayList<Object> fila = new ArrayList<>();
        fila.add("ID Clase");
        fila.add("Nombre");
        fila.add("ID Entrenador");
        fila.add("Horario");
        fila.add("Dia");
        fila.add("Capacidad");
              
        for(Object it : fila){
            modelo.addColumn(it);
        }      
        jTable1.setModel(modelo);   
    }
    
     private void cargarSocios(){
        listaClase = (ArrayList<Clase>) claseData.listaClase();
        for(Clase s : listaClase){
            int id = s.getId_clase();
            String nombre = s.getNombre();
            int entrenador = s.getEntrenador().getId_Entrenador();    
            int capacidad = s.getCapacidad();
            LocalTime hora = s.getHorario();
            DayOfWeek dia = s.getDia();
            modelo.addRow(new Object[]{id,nombre,entrenador,capacidad,hora,dia});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Listar Clase");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
