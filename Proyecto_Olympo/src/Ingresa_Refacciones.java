
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author thebe
 */
public class Ingresa_Refacciones extends javax.swing.JFrame {


    public Ingresa_Refacciones() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Ingresa_Button = new javax.swing.JButton();
        Regresa_Button = new javax.swing.JButton();
        Nombre_Field = new javax.swing.JTextField();
        Cantidad_Field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ingresa_Button.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        Ingresa_Button.setText("Ingresar");
        Ingresa_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Ingresa_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ingresa_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Ingresa_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 110, -1));

        Regresa_Button.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        Regresa_Button.setText("Regresar");
        Regresa_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Regresa_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Regresa_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Regresa_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 110, -1));

        Nombre_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Nombre_FieldKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Nombre_FieldKeyReleased(evt);
            }
        });
        jPanel1.add(Nombre_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 170, -1));

        Cantidad_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Cantidad_FieldKeyTyped(evt);
            }
        });
        jPanel1.add(Cantidad_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 170, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 70, 30));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("REFACCIONES");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 130, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/4.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 70, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes2/12 sin título_20240516213455.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cantidad_FieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cantidad_FieldKeyTyped
    int key = evt.getKeyChar();
    boolean numero= key>=48 && key<=57;
    if(!numero)
    {
        evt.consume();
    }
    if(Cantidad_Field.getText().length() >=2)
    {
        evt.consume();
    }
    }//GEN-LAST:event_Cantidad_FieldKeyTyped

    private void Nombre_FieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nombre_FieldKeyTyped
    int key = evt.getKeyChar();
    if(!Character.isLetter(key) && key !=' ')    {
        evt.consume();
    }
    if(Nombre_Field.getText().length() >=25)
    {
        evt.consume();
    }
    }//GEN-LAST:event_Nombre_FieldKeyTyped

    private void Nombre_FieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nombre_FieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_FieldKeyReleased

    private void Ingresa_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ingresa_ButtonActionPerformed
        if(Nombre_Field.getText().equals("") || Cantidad_Field.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Ingresa Datos");
        }
        else
        {
            datos x= new datos();
            try {
                x.conectar();
                String sql= "Insert into refacciones values(null,'"+Nombre_Field.getText()+"','"+Cantidad_Field.getText()+"');";
            x.actualizar(sql);
            JOptionPane.showMessageDialog(null,"Refaccion Ingresada");
            } catch (SQLException ex) {
                Logger.getLogger(Ingresa_Refacciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Ingresa_ButtonActionPerformed

    private void Regresa_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresa_ButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_Regresa_ButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ingresa_Refacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresa_Refacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresa_Refacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresa_Refacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresa_Refacciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cantidad_Field;
    private javax.swing.JButton Ingresa_Button;
    private javax.swing.JTextField Nombre_Field;
    private javax.swing.JButton Regresa_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
