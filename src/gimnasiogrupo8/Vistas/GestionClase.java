
package gimnasiogrupo8.Vistas;

import gimnasiogrupo8.accesoAData.ClaseData;
import gimnasiogrupo8.accesoAData.EntrenadoresData;
import gimnasiogrupo8.entidad.Clase;
import gimnasiogrupo8.entidad.Entrenador;
import java.time.LocalTime;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ryzen 5 5600G
 */
public class GestionClase extends javax.swing.JInternalFrame {
    
        Clase clase = null;
        ClaseData claseData = new ClaseData();
        EntrenadoresData entre = new EntrenadoresData();
    
    public GestionClase() {
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
        jtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtEntrenador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtHorario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtCapacidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        jbBuscarN = new javax.swing.JButton();
        jbBuscarE = new javax.swing.JButton();
        jbBuscarH = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jrEstado = new javax.swing.JRadioButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Gestión de Clase");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("ID Entrenador:");

        jtEntrenador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Horario:");

        jtHorario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtHorarioActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Capacidad:");

        jtCapacidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Estado:");

        jbGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbBuscarN.setText("Buscar");
        jbBuscarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarNActionPerformed(evt);
            }
        });

        jbBuscarE.setText("Buscar");

        jbBuscarH.setText("Buscar");

        jbNuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbEliminar.setText("Eliminar");

        jbSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jrEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtEntrenador)
                            .addComponent(jtNombre)
                            .addComponent(jtHorario)
                            .addComponent(jtCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jrEstado))))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jbBuscarN)
                        .addComponent(jbBuscarE))
                    .addComponent(jbBuscarH))
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jbGuardar)
                .addGap(36, 36, 36)
                .addComponent(jbNuevo)
                .addGap(39, 39, 39)
                .addComponent(jbEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarN))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarE))
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarH))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jrEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbNuevo)
                    .addComponent(jbEliminar)
                    .addComponent(jbSalir))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jtHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtHorarioActionPerformed

    private void jrEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrEstadoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        
        
        String nombre = jtNombre.getText();
        
        String horario = jtHorario.getText();
        Integer capacidad;
        
        try{
        
        int id = Integer.parseInt(jtEntrenador.getText());  
        Entrenador entrenador = entre.buscarPorID(id);
        capacidad = Integer.parseInt(jtCapacidad.getText());
        if(nombre.isEmpty() || id==0 || horario.isEmpty() || capacidad==0){
        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        return;
        }
        if(clase == null){
            clase = new Clase(nombre,entrenador,LocalTime.parse(horario),capacidad,true);
            clase.setNombre(nombre);
            clase.setEntrenador(entrenador);
            clase.setHorario(LocalTime.parse(horario));
            clase.setCapacidad(capacidad);
            
            
        
        }
        } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Debe ingresar un numero");
                return;
                }
        
        
        
        
        
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbBuscarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarNActionPerformed
            
        String nombre;
        
        nombre = jtNombre.getText();
        clase = claseData.buscarClasePorNombre(nombre);
        if(clase != null){
        
            jtEntrenador.setText(clase.getEntrenador());
            jtHorario.setText(LocalTime.parse(clase.getHorario()));
            jtCapacidad.setText(String.valueOf(clase.getCapacidad()));
            
        
        
        }else{
            JOptionPane.showMessageDialog(null,"clase no encontrada");
        
        }
    }//GEN-LAST:event_jbBuscarNActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        limpiarCampos();
        clase = null;
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed
public void limpiarCampos(){
        jtNombre.setText("");
        jtEntrenador.setText("");
        jtHorario.setText("");
        jtCapacidad.setText("");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbBuscarE;
    private javax.swing.JButton jbBuscarH;
    private javax.swing.JButton jbBuscarN;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrEstado;
    private javax.swing.JTextField jtCapacidad;
    private javax.swing.JTextField jtEntrenador;
    private javax.swing.JTextField jtHorario;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
