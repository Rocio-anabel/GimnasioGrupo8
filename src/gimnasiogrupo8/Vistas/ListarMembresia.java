/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gimnasiogrupo8.Vistas;

import gimnasiogrupo8.accesoAData.ClaseData;
import gimnasiogrupo8.accesoAData.MembresiaData;
import gimnasiogrupo8.accesoAData.SociosData;
import gimnasiogrupo8.entidad.Entrenador;
import gimnasiogrupo8.entidad.Membresia;
import gimnasiogrupo8.entidad.Socio;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Facundo
 */
public class ListarMembresia extends javax.swing.JInternalFrame {

    private MembresiaData md=new MembresiaData();
    private SociosData sd = new SociosData();
    private DefaultTableModel modelo = new DefaultTableModel();
    private ArrayList<Membresia> listaE = (ArrayList<Membresia>) md.listarMembresiasActivas() ;
    public ListarMembresia() {
        initComponents();
        md = new MembresiaData();
        modelo = new DefaultTableModel();
        armarCabeceraTabla();
        cargarMembresia();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtSocio = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista Membresia");

        jLabel2.setText("Buscar por DNI: ");

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTabla);

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar)
                    .addComponent(jbSalir)
                    .addComponent(jButtonNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        borrarFilaTabla();  
        String dni = jtSocio.getText();
        if(!dni.matches("^\\d+$")){
            JOptionPane.showMessageDialog(null,"El dni debe contener solo numeros");
            jtSocio.setText("");
            jtSocio.requestFocus();
            return;
        }
        Socio s = sd.buscarSocioPorDNI(dni);
        int id= s.getId_socio();
        Membresia membresia = md.buscarMembresiaPorSocio(id);
        ArrayList<Membresia> listaSocio = (ArrayList<Membresia>)md.listarMembresiasPorSocios(id);
        for (Membresia e : listaSocio) {
            modelo.addRow(new Object[]{
                e.getId_membresia(),
                e.getSocio().getApellido() + "  " + e.getSocio().getNombre(),
                e.getCosto(),
                e.getCantidadPases(),
                e.getFecha_inicio(),
                e.getFecha_fin()
            });
        }
                
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
        cargarMembresia();
        jtSocio.setText("");
    }//GEN-LAST:event_jButtonNuevoActionPerformed
private void armarCabeceraTabla() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
         filaCabecera.add("N° Membresia");
         filaCabecera.add("Socio");
         filaCabecera.add("Costo");
         filaCabecera.add("Cantidad Pases");
         filaCabecera.add("Fecha Inicio");
         filaCabecera.add("Fecha Fin");
         
         for (Object it : filaCabecera) {
            modelo.addColumn(it);
         }
         jTabla.setModel(modelo);
    }

private void borrarFilaTabla(){
        int indice = modelo.getRowCount() - 1;
        
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

private void cargarMembresia(){
        for (Membresia membresia : listaE) {
            int id = membresia.getId_membresia();
            String so = membresia.getSocio().getApellido() + "  " + membresia.getSocio().getNombre();
            int cost=(int) membresia.getCosto();
            int cantpases=membresia.getCantidadPases();
            LocalDate inicio=membresia.getFecha_inicio();
            LocalDate fin=membresia.getFecha_fin(); 
            modelo.addRow(new Object[]{id, so,cost,cantpases,inicio,fin});
        }
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTextField jtSocio;
    // End of variables declaration//GEN-END:variables
}
