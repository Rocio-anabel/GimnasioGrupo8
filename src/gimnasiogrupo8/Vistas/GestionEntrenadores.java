/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasiogrupo8.Vistas;

import gimnasiogrupo8.accesoAData.EntrenadoresData;
import gimnasiogrupo8.entidad.Entrenador;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Rocio
 */
public class GestionEntrenadores extends javax.swing.JInternalFrame {
    private EntrenadoresData ed = new EntrenadoresData();
    private Entrenador entrenadorActual = null;
    /**
     * Creates new form GestionEntrenadores
     */
    public GestionEntrenadores() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtDni = new javax.swing.JTextField();
        jtEspecialidad = new javax.swing.JTextField();
        jrEstado = new javax.swing.JRadioButton();
        jbSalir = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jBuscarPorDni = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Gestión de Entrenadores");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("DNI:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Especialidad:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Estado:");

        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });

        jrEstado.setSelected(true);
        jrEstado.setEnabled(false);
        jrEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEstadoActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.setEnabled(false);
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jBuscarPorDni.setText("Buscar");
        jBuscarPorDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarPorDniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbNuevo)
                                        .addGap(26, 26, 26)
                                        .addComponent(jbEliminar))
                                    .addComponent(jLabel2))
                                .addGap(113, 113, 113)
                                .addComponent(jbSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jrEstado)
                                            .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jbGuardar, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbBuscar)
                                    .addComponent(jBuscarPorDni)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel1)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBuscarPorDni))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrEstado)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar)
                    .addComponent(jbNuevo))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrEstadoActionPerformed

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        limpiarCampos();
        entrenadorActual = null;
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        
        String nombre = jtNombre.getText();
        String apellido = jtApellido.getText();
        String especialidad = jtEspecialidad.getText();
        try {  
            Integer dni = Integer.parseInt(jtDni.getText());
        
            if (nombre.isEmpty() || apellido.isEmpty() || especialidad.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
                return;
            }
            
            if (!nombre.matches("^[a-zA-Z ]+$")) {
                JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras.");
                jtNombre.setText("");
                jtNombre.requestFocus();
                return;
            }
            
            if (!apellido.matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null, "El apellido solo debe contener letras.");
                jtApellido.setText("");
                jtApellido.requestFocus();
                return;
            }
                      
            if (entrenadorActual == null) {
                entrenadorActual = new Entrenador(Integer.toString(dni), nombre, apellido, especialidad, true);
                ed.guardarEntrenador(entrenadorActual);
                jbEliminar.setEnabled(true);
                     
            } else {
                entrenadorActual.setNombre(nombre);
                entrenadorActual.setApellido(apellido);
                entrenadorActual.setDni(Integer.toString(dni));
                entrenadorActual.setEspecialidad(especialidad);
                ed.modificarEntrenador(entrenadorActual);
            }
            
        } catch (Exception e) {
            jtDni.requestFocus();
            JOptionPane.showMessageDialog(this, "Debe de ingresar un número válido");
        }
        
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String nombre = jtNombre.getText();
        String apellido = jtApellido.getText();
        if (!nombre.isEmpty() && !apellido.isEmpty()) {
            entrenadorActual = ed.buscarEntrenadorPorNombreApellido(nombre, apellido);
            if (entrenadorActual != null) {
                jtDni.setText(entrenadorActual.getDni());
                jtEspecialidad.setText(entrenadorActual.getEspecialidad());
                jrEstado.setSelected(entrenadorActual.isEstado());
                jbEliminar.setEnabled(true);
            } 
        } else if (!nombre.isEmpty() && apellido.isEmpty()){
            entrenadorActual = ed.buscarEntrenadorPorNombre(nombre);
            if (entrenadorActual != null) {
                jtApellido.setText(entrenadorActual.getApellido());
                jtDni.setText(entrenadorActual.getDni());
                jtEspecialidad.setText(entrenadorActual.getEspecialidad());
                jrEstado.setSelected(entrenadorActual.isEstado());
                jbEliminar.setEnabled(true);
            } 
        } else if (nombre.isEmpty() && !apellido.isEmpty()){
            entrenadorActual = ed.buscarEntrenadorPorApellido(apellido);
            if (entrenadorActual != null){
                jtNombre.setText(entrenadorActual.getNombre());
                jtDni.setText(entrenadorActual.getDni());
                jtEspecialidad.setText(entrenadorActual.getEspecialidad());
                jrEstado.setSelected(entrenadorActual.isEstado());
                jbEliminar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        if (entrenadorActual != null) {
            ed.eliminarEntrenador(entrenadorActual.getId_Entrenador());
            entrenadorActual = null;
            limpiarCampos();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jBuscarPorDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarPorDniActionPerformed
        // TODO add your handling code here:
        String dni;
        try{
            dni = jtDni.getText().trim();
            entrenadorActual = ed.buscarEntrenadorDNI(dni);
            if(entrenadorActual != null){
               jtNombre.setText(entrenadorActual.getNombre());
               jtApellido.setText(entrenadorActual.getApellido());
               jtEspecialidad.setText(entrenadorActual.getEspecialidad());
               jrEstado.setSelected(entrenadorActual.isEstado());
               jbEliminar.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null,"Entrenador no encontrado");
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Debe ingresar un valor valido");
        }    
    }//GEN-LAST:event_jBuscarPorDniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBuscarPorDni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrEstado;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtEspecialidad;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        jtNombre.setText("");
        jtApellido.setText("");
        jtDni.setText("");
        jtEspecialidad.setText("");
        jrEstado.setSelected(true);
        jbEliminar.setEnabled(false);
    }
}
