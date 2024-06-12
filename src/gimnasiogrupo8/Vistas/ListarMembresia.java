/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gimnasiogrupo8.Vistas;

import gimnasiogrupo8.accesoAData.MembresiaData;
import gimnasiogrupo8.entidad.Membresia;
import gimnasiogrupo8.entidad.Socio;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Facundo
 */
public class ListarMembresia extends javax.swing.JInternalFrame {

    private MembresiaData md=new MembresiaData();
    private DefaultTableModel modelo = new DefaultTableModel();
    private ArrayList<Membresia> listaE = (ArrayList<Membresia>) md.listarMembresiasActivas() ;
    public ListarMembresia() {
        initComponents();
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

        jLabel1.setText("Lista Membresia");

        jLabel2.setText("Listar por Socio");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(jtSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jbBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
         borrarFilaTabla();  
         int idSocio = Integer.parseInt(jtSocio.getText());
        Membresia membresia = md.buscarMembresiaPorSocio(idSocio);
        ArrayList<Membresia> listaSocio = (ArrayList<Membresia>) 
    }//GEN-LAST:event_jbBuscarActionPerformed
private void armarCabeceraTabla() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
         filaCabecera.add("ID_Membresia");
         filaCabecera.add("ID_Socio");
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
            int socio=membresia.getSocio().getId_socio();
            int cost=(int) membresia.getCosto();
            int cantpases=membresia.getCantidadPases();
            LocalDate inicio=membresia.getFecha_inicio();
            LocalDate fin=membresia.getFecha_fin();
                    
            
            
            
            modelo.addRow(new Object[]{id, socio,cost,cantpases,inicio,fin});
        }
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JTextField jtSocio;
    // End of variables declaration//GEN-END:variables
}
