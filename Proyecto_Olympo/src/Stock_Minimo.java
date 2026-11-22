
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thebe
 */
public class Stock_Minimo extends javax.swing.JInternalFrame {

   
    public Stock_Minimo() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StockTabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        ç = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StockTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descrpcion", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(StockTabla);
        if (StockTabla.getColumnModel().getColumnCount() > 0) {
            StockTabla.getColumnModel().getColumn(0).setResizable(false);
            StockTabla.getColumnModel().getColumn(1).setResizable(false);
            StockTabla.getColumnModel().getColumn(2).setResizable(false);
            StockTabla.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 550, 270));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        jButton1.setText("Mostrar Stock Minimos");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 200, -1));

        ç.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        ç.setForeground(new java.awt.Color(255, 255, 255));
        ç.setText("Stock Mínimo");
        jPanel1.add(ç, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes2/12 sin título_20240516213455.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) StockTabla.getModel();
    while (modelo.getRowCount() > 0) {
        modelo.removeRow(0);
    }
    int cantidadMinima = 5; // Definir la cantidad mínima permitida para mostrar
    try {
        DefaultTableModel tabla = (DefaultTableModel) StockTabla.getModel();
        datos objetoDatos = new datos();
        objetoDatos.conectar();        
        String sqlAccesorios = "SELECT * FROM accesorios WHERE cantidad <= " + cantidadMinima + ";";
        ResultSet rsAccesorios = objetoDatos.obtenerDatos(sqlAccesorios);
        while (rsAccesorios.next()) {
            String[] fila = {rsAccesorios.getString(1), rsAccesorios.getString(2), rsAccesorios.getString(5), rsAccesorios.getString(3)};
            tabla.addRow(fila);
        }
        String sqlRefacciones = "SELECT * FROM refacciones WHERE cantidad <= " + cantidadMinima + ";";
        ResultSet rsRefacciones = objetoDatos.obtenerDatos(sqlRefacciones);
        while (rsRefacciones.next()) {
            String[] fila = {rsRefacciones.getString(1), rsRefacciones.getString(2), rsRefacciones.getString(3)};
            tabla.addRow(fila);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Accesorios.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StockTabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ç;
    // End of variables declaration//GEN-END:variables
}
