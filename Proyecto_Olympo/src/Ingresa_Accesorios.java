
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author thebe
 */
public class Ingresa_Accesorios extends javax.swing.JFrame {
    public Ingresa_Accesorios() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Nombre_Label = new javax.swing.JLabel();
        Descripcion_Label = new javax.swing.JLabel();
        Cantidad_Label = new javax.swing.JLabel();
        Precio_Label = new javax.swing.JLabel();
        Nombre_Field = new javax.swing.JTextField();
        Descripcion_Field = new javax.swing.JTextField();
        Cantidad_Field = new javax.swing.JTextField();
        Precio_Field = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombre_Label.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        Nombre_Label.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_Label.setText("Nombre:");
        jPanel2.add(Nombre_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 90, 30));

        Descripcion_Label.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        Descripcion_Label.setForeground(new java.awt.Color(255, 255, 255));
        Descripcion_Label.setText("Descripcion:");
        jPanel2.add(Descripcion_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 90, 20));

        Cantidad_Label.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        Cantidad_Label.setForeground(new java.awt.Color(255, 255, 255));
        Cantidad_Label.setText("Cantidad:");
        jPanel2.add(Cantidad_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 70, 30));

        Precio_Label.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        Precio_Label.setForeground(new java.awt.Color(255, 255, 255));
        Precio_Label.setText("Precio:");
        jPanel2.add(Precio_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 110, 30));

        Nombre_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Nombre_FieldKeyTyped(evt);
            }
        });
        jPanel2.add(Nombre_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 200, 20));

        Descripcion_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Descripcion_FieldKeyTyped(evt);
            }
        });
        jPanel2.add(Descripcion_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 200, 20));

        Cantidad_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Cantidad_FieldKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Cantidad_FieldKeyReleased(evt);
            }
        });
        jPanel2.add(Cantidad_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 200, 20));

        Precio_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Precio_FieldKeyTyped(evt);
            }
        });
        jPanel2.add(Precio_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 200, 20));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 150, -1));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 140, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/3.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ACCESORIOS");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes2/12 sin título_20240516213455.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, -1));

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(Nombre_Field.getText().equals("") || Descripcion_Field.getText().equals("") || Precio_Field.getText().equals("") || Cantidad_Field.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Ingresa Datos");
        }
        else
        {
            datos x= new datos();
            try {
                x.conectar();
                String sql= "Insert into Accesorios values(null,'"+Nombre_Field.getText()+"','"+Descripcion_Field.getText()+"','"+Precio_Field.getText()+"','"+Cantidad_Field+"');";
                x.actualizar(sql);
                JOptionPane.showMessageDialog(null,"Accesorio Ingresado");
            } catch (SQLException ex) {
                Logger.getLogger(Ingresa_Accesorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Precio_FieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Precio_FieldKeyTyped
        int key = evt.getKeyChar();
        boolean numero= key>=48 && key<=57;
        if(!numero)
        {
            evt.consume();
        }
        if(Precio_Field.getText().length() >=3)
        {
            evt.consume();
        }
    }//GEN-LAST:event_Precio_FieldKeyTyped

    private void Cantidad_FieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cantidad_FieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Cantidad_FieldKeyReleased

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

    private void Descripcion_FieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Descripcion_FieldKeyTyped
        int key = evt.getKeyChar();
        if(!Character.isLetter(key) && key !=' ')    {
            evt.consume();
        }
        if(Descripcion_Field.getText().length() >=25)
        {
            evt.consume();
        }
    }//GEN-LAST:event_Descripcion_FieldKeyTyped

    private void Nombre_FieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nombre_FieldKeyTyped
        int key = evt.getKeyChar();
        if(!Character.isLetter(key) && key !=' ')    {
            evt.consume();
        }
        if(Nombre_Field.getText().length() >=30)
        {
            evt.consume();
        }
    }//GEN-LAST:event_Nombre_FieldKeyTyped

    
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
            java.util.logging.Logger.getLogger(Ingresa_Accesorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresa_Accesorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresa_Accesorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresa_Accesorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Ingresa_Accesorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cantidad_Field;
    private javax.swing.JLabel Cantidad_Label;
    private javax.swing.JTextField Descripcion_Field;
    private javax.swing.JLabel Descripcion_Label;
    private javax.swing.JTextField Nombre_Field;
    private javax.swing.JLabel Nombre_Label;
    private javax.swing.JTextField Precio_Field;
    private javax.swing.JLabel Precio_Label;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
