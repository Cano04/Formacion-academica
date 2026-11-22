
import javax.swing.JOptionPane;


/**
 * @joseAngelCastilloCenobio thebe
 */
public class Contraseña extends javax.swing.JFrame {

private final String Tipo;
    public Contraseña(String T) {
        Tipo= T;        
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Contraseña_Field = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        Aceptar_Button = new javax.swing.JButton();
        Cancelar_Button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Contraseña_Field.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(Contraseña_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 150, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingresa contraseña");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, 30));

        Aceptar_Button.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        Aceptar_Button.setText("Aceptar");
        Aceptar_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Aceptar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Aceptar_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 70, -1));

        Cancelar_Button.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        Cancelar_Button.setText("Cancelar");
        Cancelar_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Cancelar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Cancelar_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 70, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/16 sin título_20240516222900.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes2/12 sin título_20240516213455.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Aceptar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar_ButtonActionPerformed
        if(Contraseña_Field.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Ingresa Contraseña");
        }
        else if(!Contraseña_Field.getText().equals("22070540"))
        {
            JOptionPane.showMessageDialog(null,"Contraseña Incorrecta");
        }
        else
        {
            if(Tipo.equals("Accesorio"))
            {
                Ingresa_Accesorios abrir= new Ingresa_Accesorios();
            abrir.setVisible(true);
            setVisible(false);
            }
            else if(Tipo.equals("Refacciones"))
            {
                Ingresa_Refacciones abrir= new Ingresa_Refacciones();
            abrir.setVisible(true);
            setVisible(false);
            }
        }
        
        
            
    }//GEN-LAST:event_Aceptar_ButtonActionPerformed

    private void Cancelar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelar_ButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_Cancelar_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contraseña("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar_Button;
    private javax.swing.JButton Cancelar_Button;
    private javax.swing.JPasswordField Contraseña_Field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
