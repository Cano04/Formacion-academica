
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @JoseAngelCastilloCenobio thebe
 */
public class Registro_De_Venta extends javax.swing.JInternalFrame {
    String Clave,Nom,Producto;
    double Subtotal,Total_a_pagar=0;
    int cantidad,compra,NCantidad;
    public Registro_De_Venta() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Total_Label = new javax.swing.JLabel();
        Precio_Total_Field = new javax.swing.JTextField();
        Registrar_Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descripcion_Table = new javax.swing.JTable();
        Descripcion_Field = new javax.swing.JTextField();
        Precio_Field = new javax.swing.JTextField();
        Cantidad_Comprar_Field = new javax.swing.JTextField();
        Accesorio_Buscar_Field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Dia_Label = new javax.swing.JLabel();
        Mes_Label = new javax.swing.JLabel();
        Año_Label = new javax.swing.JLabel();
        Dia_Box = new javax.swing.JComboBox<>();
        Mes_Box = new javax.swing.JComboBox<>();
        Año_Box = new javax.swing.JComboBox<>();
        Buscar_Button = new javax.swing.JButton();
        Comprar_Button = new javax.swing.JButton();
        Error_Label = new javax.swing.JLabel();
        Limpiar_Button = new javax.swing.JButton();
        Eliminar_Button = new javax.swing.JButton();
        Error1_Label = new javax.swing.JLabel();
        Cantidad_Label = new javax.swing.JLabel();
        Disponibilidad_Field = new javax.swing.JTextField();
        Pago_Efectivo_Field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Editar_Button = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registros de ventas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 218, -1, -1));

        Total_Label.setForeground(new java.awt.Color(255, 255, 255));
        Total_Label.setText("Cantidad total a pagar");
        jPanel1.add(Total_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, 30));

        Precio_Total_Field.setEditable(false);
        jPanel1.add(Precio_Total_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 110, -1));

        Registrar_Button.setBackground(new java.awt.Color(0, 0, 0));
        Registrar_Button.setForeground(new java.awt.Color(255, 255, 255));
        Registrar_Button.setText("Registrar Venta");
        Registrar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Registrar_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, -1, -1));

        Descripcion_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Cantidad", "Precio", "Subtotal", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Descripcion_Table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Descripcion_TableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(Descripcion_Table);
        if (Descripcion_Table.getColumnModel().getColumnCount() > 0) {
            Descripcion_Table.getColumnModel().getColumn(0).setResizable(false);
            Descripcion_Table.getColumnModel().getColumn(1).setResizable(false);
            Descripcion_Table.getColumnModel().getColumn(2).setResizable(false);
            Descripcion_Table.getColumnModel().getColumn(3).setResizable(false);
            Descripcion_Table.getColumnModel().getColumn(4).setResizable(false);
            Descripcion_Table.getColumnModel().getColumn(5).setResizable(false);
            Descripcion_Table.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 580, 140));

        Descripcion_Field.setEnabled(false);
        Descripcion_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Descripcion_FieldActionPerformed(evt);
            }
        });
        jPanel1.add(Descripcion_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, -1));

        Precio_Field.setEnabled(false);
        jPanel1.add(Precio_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 160, -1));

        Cantidad_Comprar_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Cantidad_Comprar_FieldKeyTyped(evt);
            }
        });
        jPanel1.add(Cantidad_Comprar_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 160, -1));

        Accesorio_Buscar_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Accesorio_Buscar_FieldKeyTyped(evt);
            }
        });
        jPanel1.add(Accesorio_Buscar_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 160, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("Accesorio a buscar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 30));

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setText("Descripcion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 90, 30));

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel7.setText("Precio");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 50, 30));

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel8.setText("Cantidad a comprar");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 130, 30));

        Dia_Label.setText("Dia");
        jPanel1.add(Dia_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        Mes_Label.setText("Mes");
        jPanel1.add(Mes_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        Año_Label.setText("Año");
        jPanel1.add(Año_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, -1, -1));

        Dia_Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01" }));
        jPanel1.add(Dia_Box, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 60, -1));

        Mes_Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        Mes_Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mes_BoxActionPerformed(evt);
            }
        });
        jPanel1.add(Mes_Box, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 60, -1));

        Año_Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026" }));
        jPanel1.add(Año_Box, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 70, -1));

        Buscar_Button.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        Buscar_Button.setText("buscar");
        Buscar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Buscar_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        Comprar_Button.setText("Comprar Producto");
        Comprar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Comprar_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Comprar_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        Error_Label.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        Error_Label.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(Error_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 180, 20));

        Limpiar_Button.setText("Limpiar");
        Limpiar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Limpiar_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Limpiar_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        Eliminar_Button.setText("Eliminar");
        Eliminar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Eliminar_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, -1, -1));
        jPanel1.add(Error1_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 180, 20));

        Cantidad_Label.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        Cantidad_Label.setText("Accesorios disponibles");
        jPanel1.add(Cantidad_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 150, 30));

        Disponibilidad_Field.setEnabled(false);
        jPanel1.add(Disponibilidad_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 160, -1));

        Pago_Efectivo_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pago_Efectivo_FieldActionPerformed(evt);
            }
        });
        Pago_Efectivo_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Pago_Efectivo_FieldKeyTyped(evt);
            }
        });
        jPanel1.add(Pago_Efectivo_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, 110, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pago efectivo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, 80, 30));

        Editar_Button.setText("Editar");
        Editar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Editar_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, -1, -1));

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

    private void Registrar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar_ButtonActionPerformed
    double Total_A_Pagar=Double.parseDouble(Precio_Total_Field.getText());
    if(Pago_Efectivo_Field.getText().equals(""))
    {
        JOptionPane.showMessageDialog(null, "Pago no registrado\nCantidad insuficiente");
    }
    else
    {
    int dineroEfectivo = Integer.parseInt(Pago_Efectivo_Field.getText());
    if(dineroEfectivo < Total_A_Pagar) 
    {
        JOptionPane.showMessageDialog(null, "Pago no registrado\nCantidad insuficiente");
    } else {
        Precio_Field.setText("");
        Descripcion_Field.setText("");
        Cantidad_Comprar_Field.setText("");
        Disponibilidad_Field.setText("");
            datos x = new datos();
            DefaultTableModel modelo = (DefaultTableModel) Descripcion_Table.getModel();

            try {
                x.conectar();

                for (int i = 0; i < modelo.getRowCount(); i++) {
                    String nombre = (String) modelo.getValueAt(i, 1);
                    String cantidad1 = (String) modelo.getValueAt(i, 3);
                    String subtotal1 = (String) modelo.getValueAt(i, 5);
                    String Fecha = (String) modelo.getValueAt(i,6);
                    String sql="insert into olimpo values (null,'"+nombre+"','"+cantidad1+"','"+subtotal1+"','"+Fecha+"');";
                    x.actualizar(sql);
                    JOptionPane.showMessageDialog(null, "Pago registrado con exito");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Registro_De_Venta.class.getName()).log(Level.SEVERE, null, ex);
            }
    }    
    }
    }//GEN-LAST:event_Registrar_ButtonActionPerformed

    private void Mes_BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mes_BoxActionPerformed
    String Mes= (String) Mes_Box.getSelectedItem();
    Dia_Box.removeAllItems();
    switch (Mes) {
        case "01":
        case "03":
        case "05":
        case "07":
        case "08":
        case "10":
        case "12":
            for (int i = 1; i <= 31; i++) {
            Dia_Box.addItem(String.valueOf(i));
        }
        break;
        case "02":
        for (int i = 1; i <= 28; i++) {
            Dia_Box.addItem(String.valueOf(i));
        }
        break;
        case "04":
        case "06":
        case "09":
        case "11":
        for (int i = 1; i <= 30; i++) {
            Dia_Box.addItem(String.valueOf(i));
        }
        break;
    }
    }//GEN-LAST:event_Mes_BoxActionPerformed

    private void Descripcion_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Descripcion_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Descripcion_FieldActionPerformed

    private void Buscar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_ButtonActionPerformed
        if(Accesorio_Buscar_Field.getText().equals(""))
        {
            Error_Label.setText("Ingresa el Producto que deseas buscar");
        }
        else
        {
            Error_Label.setText("");
            try {
        Producto= Accesorio_Buscar_Field.getText();
        DefaultTableModel Tabla=(DefaultTableModel) Descripcion_Table.getModel();
        
        
        datos Obj_Datos= new datos();
        Obj_Datos.conectar();
        String sql="select * from accesorios where Nom='"+Producto+"';";
        ResultSet conjreg=Obj_Datos.obtenerDatos(sql);
        while(conjreg.next())
        {
            Clave=conjreg.getString(1);
            Nom=conjreg.getString(2);
            Descripcion_Field.setText(conjreg.getString(3));
            Precio_Field.setText(String.valueOf(conjreg.getString(4)));
            Disponibilidad_Field.setText(String.valueOf(conjreg.getString(5)));
        }
        } catch (SQLException ex) {
            Logger.getLogger(Registro_De_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_Buscar_ButtonActionPerformed

    private void Comprar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Comprar_ButtonActionPerformed
    String mes = (String) Mes_Box.getSelectedItem();
    String dia = (String) Dia_Box.getSelectedItem();
    String año = (String) Año_Box.getSelectedItem();
    String Fecha = dia + "-" + mes + "-" + año;
    if (Accesorio_Buscar_Field.getText().equals("") ||
        Precio_Field.getText().equals("") ||
        Descripcion_Field.getText().equals("") ||
        Cantidad_Comprar_Field.getText().equals("")) {
        Error_Label.setText("Ingresa el Accesorio que deseas buscar");
    } else if (Cantidad_Comprar_Field.getText().equals("0") || Cantidad_Comprar_Field.getText().equals("")) {
        Error_Label.setText("Ingresa Cantidad A Comprar");
    } else {
        cantidad = Integer.parseInt(Disponibilidad_Field.getText());
        compra = Integer.parseInt(Cantidad_Comprar_Field.getText());
        if (cantidad < compra) 
        {
            JOptionPane.showMessageDialog(null, "Lo siento, sobrepasaste la cantidad de producto (" + cantidad + ")");
        }
        else 
        {
            Error_Label.setText("");
            DefaultTableModel tabla = (DefaultTableModel) Descripcion_Table.getModel();
            boolean AccesorioExistente = false;
            int filaExistente = -1;
            for (int i = 0; i < tabla.getRowCount(); i++) {
                if (tabla.getValueAt(i, 0).toString().equals(Clave)) {
                    AccesorioExistente = true;
                    filaExistente = i;
                    break;
                }
            }
            if (AccesorioExistente) 
            {
                int cantidadExistente = Integer.parseInt(tabla.getValueAt(filaExistente, 3).toString());
                int nuevaCantidad = cantidadExistente + compra;
                if (nuevaCantidad <= cantidad) {
                    tabla.setValueAt(nuevaCantidad, filaExistente, 3);
                    double nuevoSubtotal = nuevaCantidad * Double.parseDouble(Precio_Field.getText());
                    tabla.setValueAt(nuevoSubtotal, filaExistente, 5);
                } else {
                    JOptionPane.showMessageDialog(null, "Lo siento, sobrepasaste la cantidad de producto disponible (" + cantidad + ")");
                }
            } else 
            {
                Subtotal = Integer.parseInt(Cantidad_Comprar_Field.getText()) * Double.parseDouble(Precio_Field.getText());
                String[] Fila = {Clave, Nom, Descripcion_Field.getText(), Cantidad_Comprar_Field.getText(), Precio_Field.getText(), String.valueOf(Subtotal), Fecha};
                tabla.addRow(Fila);
            }
            Total_a_pagar = 0;
            for (int i = 0; i < tabla.getRowCount(); i++) 
            {
                Total_a_pagar += Double.parseDouble(tabla.getValueAt(i, 5).toString());
            }
            Precio_Total_Field.setText(String.valueOf(Total_a_pagar)); 
        }
    }
    }//GEN-LAST:event_Comprar_ButtonActionPerformed

    private void Limpiar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Limpiar_ButtonActionPerformed
        Accesorio_Buscar_Field.setText("");
        Precio_Field.setText("");
        Descripcion_Field.setText("");
        Cantidad_Comprar_Field.setText("");
        Disponibilidad_Field.setText("");
    }//GEN-LAST:event_Limpiar_ButtonActionPerformed

    private void Eliminar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_ButtonActionPerformed
        DefaultTableModel E=(DefaultTableModel) Descripcion_Table.getModel();
        int selectedRow = Descripcion_Table.getSelectedRow();
        int rw= Descripcion_Table.getSelectedRow();
        if (selectedRow >= 0) 
        {
        String r= E.getValueAt(Descripcion_Table.getSelectedRow(),0).toString();
        double subtotalEliminado = Double.parseDouble(E.getValueAt(selectedRow, 5).toString());
        Total_a_pagar -= subtotalEliminado;
        Precio_Total_Field.setText(String.valueOf(Total_a_pagar));
        E.removeRow(selectedRow);
        Error1_Label.setText("");
        } 
        else 
        {
        Error1_Label.setText("Selecciona una fila para eliminar");
        }
    }//GEN-LAST:event_Eliminar_ButtonActionPerformed

    private void Cantidad_Comprar_FieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cantidad_Comprar_FieldKeyTyped
        int key = evt.getKeyChar();
    boolean numero= key>=48 && key<=57;
    if(!numero)
    {
        evt.consume();
    }
    if(Cantidad_Comprar_Field.getText().length() >=2)
    {
        evt.consume();
    }
    }//GEN-LAST:event_Cantidad_Comprar_FieldKeyTyped

    private void Pago_Efectivo_FieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Pago_Efectivo_FieldKeyTyped
    int key = evt.getKeyChar();
    boolean numero= key>=48 && key<=57;
    if(!numero)
    {
        evt.consume();
    }
    if(Pago_Efectivo_Field.getText().length() >=4)
    {
        evt.consume();
    }
    }//GEN-LAST:event_Pago_Efectivo_FieldKeyTyped

    private void Accesorio_Buscar_FieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Accesorio_Buscar_FieldKeyTyped
        int key = evt.getKeyChar();
    if(!Character.isLetter(key) && key !=' ')    {
        evt.consume();
    }
    if(Accesorio_Buscar_Field.getText().length() >=30)
    {
        evt.consume();
    }
    }//GEN-LAST:event_Accesorio_Buscar_FieldKeyTyped

    private void Descripcion_TableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Descripcion_TableKeyTyped
     int key = evt.getKeyChar();
    boolean numero= key>=48 && key<=57;
    if(!numero)
    {
        evt.consume();
    }
    }//GEN-LAST:event_Descripcion_TableKeyTyped

    private void Pago_Efectivo_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pago_Efectivo_FieldActionPerformed
        
    }//GEN-LAST:event_Pago_Efectivo_FieldActionPerformed

    private void Editar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_ButtonActionPerformed
    DefaultTableModel tableModel = (DefaultTableModel) Descripcion_Table.getModel();
    int selectedRow = Descripcion_Table.getSelectedRow();
    if (selectedRow >= 0) 
    {
        String clave = tableModel.getValueAt(selectedRow, 0).toString();
        String nombre = tableModel.getValueAt(selectedRow, 1).toString();
        String descripcion = tableModel.getValueAt(selectedRow, 2).toString();
        int cantidadActual = Integer.parseInt(tableModel.getValueAt(selectedRow, 3).toString());
        double precio = Double.parseDouble(tableModel.getValueAt(selectedRow, 4).toString());
        double subtotalEliminado = Double.parseDouble(tableModel.getValueAt(selectedRow, 5).toString());
        
        Total_a_pagar -= subtotalEliminado;
        Precio_Total_Field.setText(String.valueOf(Total_a_pagar));
        int nuevaCantidad = 0;
        boolean cantidadValida = false;
        while (!cantidadValida) {
        String input = JOptionPane.showInputDialog(null, "Ingresa cantidad a modificar");
        {
        try 
        {
            nuevaCantidad = Integer.parseInt(input);
            if (nuevaCantidad > cantidad) 
            {
                JOptionPane.showMessageDialog(null, "Lo siento, sobrepasaste la cantidad de producto ("+cantidad+")");
            } else 
            {
                cantidadValida = true;
            }
        } catch (NumberFormatException ex) 
        {
            JOptionPane.showMessageDialog(null, "El dato no es válido. No se puede introducir texto o números con decimales\n Inténtalo de nuevo");
        }    
        }
        tableModel.setValueAt(nuevaCantidad, selectedRow, 3);
            double nuevoSubtotal = nuevaCantidad * precio;
            tableModel.setValueAt(nuevoSubtotal, selectedRow, 5);
            Total_a_pagar += nuevoSubtotal;
            Precio_Total_Field.setText(String.valueOf(Total_a_pagar));
            Error1_Label.setText("");
        }      
        } else {
            Error1_Label.setText("Selecciona una fila para modificar");
        }
    }//GEN-LAST:event_Editar_ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Accesorio_Buscar_Field;
    private javax.swing.JComboBox<String> Año_Box;
    private javax.swing.JLabel Año_Label;
    private javax.swing.JButton Buscar_Button;
    private javax.swing.JTextField Cantidad_Comprar_Field;
    private javax.swing.JLabel Cantidad_Label;
    private javax.swing.JButton Comprar_Button;
    private javax.swing.JTextField Descripcion_Field;
    private javax.swing.JTable Descripcion_Table;
    private javax.swing.JComboBox<String> Dia_Box;
    private javax.swing.JLabel Dia_Label;
    private javax.swing.JTextField Disponibilidad_Field;
    private javax.swing.JButton Editar_Button;
    private javax.swing.JButton Eliminar_Button;
    private javax.swing.JLabel Error1_Label;
    private javax.swing.JLabel Error_Label;
    private javax.swing.JButton Limpiar_Button;
    private javax.swing.JComboBox<String> Mes_Box;
    private javax.swing.JLabel Mes_Label;
    private javax.swing.JTextField Pago_Efectivo_Field;
    private javax.swing.JTextField Precio_Field;
    private javax.swing.JTextField Precio_Total_Field;
    private javax.swing.JButton Registrar_Button;
    private javax.swing.JLabel Total_Label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
