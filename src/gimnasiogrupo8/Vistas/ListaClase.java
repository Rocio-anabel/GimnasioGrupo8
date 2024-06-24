/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gimnasiogrupo8.Vistas;

import gimnasiogrupo8.accesoAData.ClaseData;
import gimnasiogrupo8.accesoAData.EntrenadoresData;
import gimnasiogrupo8.accesoAData.SociosData;

import gimnasiogrupo8.entidad.Clase;
import gimnasiogrupo8.entidad.Entrenador;
import gimnasiogrupo8.entidad.Socio;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListaClase extends javax.swing.JInternalFrame {

    private ArrayList<Clase>listaClase;
    private ClaseData claseData;
    private EntrenadoresData ed = new EntrenadoresData();
    private DefaultTableModel modelo;
    private ArrayList<Entrenador>listaEntrenador = (ArrayList<Entrenador>) ed.listarEntrenadores();
    private boolean iniciar = false;
    
    public ListaClase() {
        initComponents();
        cargarEntrenador();
        claseData = new ClaseData();
        modelo = new DefaultTableModel();
        armarCabeceraTabla();
        cargarClase();
    }
    
    private void borrarFilaTabla(){
        int indice = modelo.getRowCount() - 1;
        
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void armarCabeceraTabla(){
        ArrayList<Object> fila = new ArrayList<>();
        fila.add("Nº Clase");
        fila.add("Nombre");
        fila.add("Entrenador");
        fila.add("Horario");
        fila.add("Capacidad");
              
        for(Object it : fila){
            modelo.addColumn(it);
        }      
        jTable1.setModel(modelo);   
    }
    
     private void cargarClase(){
        listaClase = (ArrayList<Clase>) claseData.listaClase();
        for(Clase s : listaClase){
            int id = s.getId_clase();
            String nombre = s.getNombre();
            String entrenador = s.getEntrenador().getNombre() + " " +s.getEntrenador().getApellido();
            int capacidad = s.getCapacidad();
            LocalTime hora = s.getHorario();
            modelo.addRow(new Object[]{id,nombre,entrenador,hora,capacidad});
        }
    }
     
    private void cargarEntrenador() {
        for (Entrenador e : listaEntrenador) {
            jComboBoxEntrenadores.addItem(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBoxEntrenadores = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        jComboBoxEntrenadores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEntrenadoresItemStateChanged(evt);
            }
        });

        jLabel2.setText("Entrenador : ");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEntrenadores, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEntrenadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEntrenadoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEntrenadoresItemStateChanged
        cargarClasePorEntrenador();
    }//GEN-LAST:event_jComboBoxEntrenadoresItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cargarClasePorEntrenador(){   
        Entrenador e = (Entrenador) jComboBoxEntrenadores.getSelectedItem();
        if(iniciar){
            borrarFilaTabla();
            ArrayList<Clase> listaClasee = claseData.buscarClasePorEntrenador(e);
            if(listaClasee != null){
          for(Clase s : listaClasee){
            int id = s.getId_clase();
            String nombre = s.getNombre();
            String entrenador = s.getEntrenador().getNombre() + " " +s.getEntrenador().getApellido();
            int capacidad = s.getCapacidad();
            LocalTime hora = s.getHorario();
            modelo.addRow(new Object[]{id,nombre,entrenador,hora,capacidad});
            }
        }else{
            JOptionPane.showMessageDialog(null,"Error");
        }
        }
        iniciar = true;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Entrenador> jComboBoxEntrenadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
