package codigo;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List; // Solo una vez
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import codigo.Tokens; // Solo una vez
import java_cup.runtime.*; // Reemplaza import java_cup.parser
import codigo.LexerCup;

import codigo.sematico.AnalizadorSemantico;
import codigo.sematico.TablaSimbolos;
import static codigo.sym.EOF; // Importa solo lo necesario si es problema
import static java_cup.emit.parser;
import java_cup.parser;
import java_cup.runtime.*;



/**
 *
 * @author hp
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
     
    public Inicio() {
        initComponents();
        // Inicializar el campo
        
    }
    private boolean esPalabraReservadaIncorrecta(String token, Map<String, String> palabrasReservadasCaseSensitive) {
    String lowerToken = token.toLowerCase();
    return palabrasReservadasCaseSensitive.containsKey(lowerToken) && 
           !token.equals(palabrasReservadasCaseSensitive.get(lowerToken));
}
private boolean esIdentificadorNuevo(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        return Character.isUpperCase(token.charAt(0)) && token.matches("[A-Z][A-Za-z0-9]*");
    }

    private boolean esNumeroNuevo(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        return token.matches("\\d+");
    }

    private boolean esOperadorNuevo(String token) {
        if (token == null) {
            return false;
        }
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean esLlamadaNueva(String linea) {
        if (linea == null) {
            return false;
        }
        return linea.trim().matches("^Eje\\s*\\(\\s*Capivara\\s*\\)$");
    }

    private boolean esDeclaracionNueva(String linea) {
        if (linea == null || linea.trim().isEmpty()) {
            return false;
        }
        String[] tokens = linea.trim().split("\\s+");
        if (tokens.length != 2) {
            return false;
        }
        String primerToken = tokens[0];
        String segundoToken = tokens[1];
        boolean esPalabraDeclaracion = primerToken.equals("Vill") || 
                                       primerToken.equals("Con") || 
                                       primerToken.equals("Nad") || 
                                       primerToken.equals("Gen");
        boolean esSegundoIdentificador = esIdentificadorNuevo(segundoToken);
        return esPalabraDeclaracion && esSegundoIdentificador;
    }

   private boolean esTerminoNuevo(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        return esNumeroNuevo(token) || 
               esIdentificadorNuevo(token) || 
               token.equals("Nad") || 
               token.equals("Gen");
    }

    private boolean esExpresionValidaNueva(String expr) {
        if (expr == null || expr.trim().isEmpty()) {
            return false;
        }
        String[] tokens = expr.trim().split("\\s+");
        if (tokens.length == 0) {
            return false;
        }
        if (tokens.length == 1) {
            return esTerminoNuevo(tokens[0]);
        }
        boolean esperandoTermino = true;
        for (String token : tokens) {
            if (esperandoTermino) {
                if (!esTerminoNuevo(token)) {
                    return false;
                }
                esperandoTermino = false;
            } else {
                if (!esOperadorNuevo(token)) {
                    return false;
                }
                esperandoTermino = true;
            }
        }
        return !esperandoTermino;
    }

    private boolean esAsignacionNueva(String linea) {
        if (linea == null || linea.trim().isEmpty()) {
            return false;
        }
        int igualIndex = linea.indexOf('=');
        if (igualIndex == -1) {
            return false;
        }
        String varParte = linea.substring(0, igualIndex).trim();
        String exprParte = linea.substring(igualIndex + 1).trim();
        return esIdentificadorNuevo(varParte) && esExpresionValidaNueva(exprParte);
    }


// PASO 3: REEMPLAZA completamente el método sintacticoActionPerformed con este:

 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTree3 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTree4 = new javax.swing.JTree();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabla_resultados = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tabla_resultados_error = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        analisis_sintactico = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree2 = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cortar = new javax.swing.JMenuItem();
        copiar = new javax.swing.JMenuItem();
        pegar = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        fuentes = new javax.swing.JMenuItem();
        tamano = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        analizar = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        jScrollPane1.setViewportView(jTree1);

        jScrollPane5.setViewportView(jTree3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(jTree4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setForeground(new java.awt.Color(255, 255, 255));

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane7.setViewportView(textArea);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/codigo/tijeras.png"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/codigo/copiar.jpg"))); // NOI18N
        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/codigo/pegar.png"))); // NOI18N
        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tabla_resultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Linea ", "Valor", "Tipo de lexema", "Contador"
            }
        ));
        jScrollPane9.setViewportView(tabla_resultados);

        tabla_resultados_error.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Linea ", "Valor", "Error", "Contador"
            }
        ));
        jScrollPane10.setViewportView(tabla_resultados_error);

        analisis_sintactico.setColumns(20);
        analisis_sintactico.setRows(5);
        jScrollPane8.setViewportView(analisis_sintactico);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Tabla de analizador sintactico");

        jLabel2.setText("Tabla de analizador Lexico ");

        jDesktopPane1.setLayer(jScrollPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(jLabel2)))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(209, 209, 209))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                        .addGap(162, 162, 162))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jScrollPane2.setViewportView(jTree2);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edicion");

        cortar.setText("Cortar");
        cortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cortarActionPerformed(evt);
            }
        });
        jMenu2.add(cortar);

        copiar.setText("Copiar");
        copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarActionPerformed(evt);
            }
        });
        jMenu2.add(copiar);

        pegar.setText("Pegar");
        pegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarActionPerformed(evt);
            }
        });
        jMenu2.add(pegar);

        jMenuBar1.add(jMenu2);

        jMenu9.setText("Opciones");

        fuentes.setText("Fuente");
        fuentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuentesActionPerformed(evt);
            }
        });
        jMenu9.add(fuentes);

        tamano.setText("Tamaño");
        tamano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamanoActionPerformed(evt);
            }
        });
        jMenu9.add(tamano);

        jMenuBar1.add(jMenu9);

        jMenu10.setText("Compilar");

        analizar.setText("Analizar");
        analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarActionPerformed(evt);
            }
        });
        jMenu10.add(analizar);

        jMenuBar1.add(jMenu10);

        jMenu11.setText("Ayuda");
        jMenuBar1.add(jMenu11);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         JFileChooser fileChooser = new JFileChooser();
  FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
  fileChooser.setFileFilter(filter);

  int result = fileChooser.showOpenDialog(this);

  if (result == JFileChooser.APPROVE_OPTION) {
  File selectedFile = fileChooser.getSelectedFile();

  try (Scanner scanner = new Scanner(selectedFile)) {
  textArea.setText("");
  while (scanner.hasNextLine()) {
  textArea.append(scanner.nextLine() + "\n");
  }
  } catch (FileNotFoundException e) {
  JOptionPane.showMessageDialog(this, "File not found!", "Error", JOptionPane.ERROR_MESSAGE);
  }
  };
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
  FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
  fileChooser.setFileFilter(filter);

  int result = fileChooser.showSaveDialog(this);

  if (result == JFileChooser.APPROVE_OPTION) {
  File selectedFile = fileChooser.getSelectedFile();
  String filePath = selectedFile.getAbsolutePath();
  if (!filePath.toLowerCase().endsWith(".txt")) {
  selectedFile = new File(filePath + ".txt");
  }

  try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
  writer.write(textArea.getText());
  } catch (IOException e) {
  JOptionPane.showMessageDialog(this, "Error saving file!", "Error", JOptionPane.ERROR_MESSAGE);
  }
  }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void cortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cortarActionPerformed
         String selectedText = textArea.getSelectedText();
  if (selectedText != null) {
  StringSelection stringSelection = new StringSelection(selectedText);
  Clipboard clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
  clipboard.setContents(stringSelection, null);
  textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
  }
    }//GEN-LAST:event_cortarActionPerformed

    private void copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiarActionPerformed
        String selectedText = textArea.getSelectedText();
  if (selectedText != null) {
  StringSelection stringSelection = new StringSelection(selectedText);
  Clipboard clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
  clipboard.setContents(stringSelection, null);
  }
    }//GEN-LAST:event_copiarActionPerformed

    private void pegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegarActionPerformed
        Clipboard clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
  Transferable contents = clipboard.getContents(null);
  if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
  try {
  String pastedText = (String) contents.getTransferData(DataFlavor.stringFlavor);
  textArea.replaceSelection(pastedText);
  } catch (UnsupportedFlavorException | IOException e) {
  e.printStackTrace();
  }
  }
    }//GEN-LAST:event_pegarActionPerformed

    private void fuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuentesActionPerformed
       // Obtener todas las familias de fuentes disponibles en el sistema
    String[] fontFamilyNames = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    
    // Crear lista para almacenar las fuentes que queremos ofrecer y están disponibles
    java.util.List<String> availableFonts = new java.util.ArrayList<>();
    
    // Verificar si "Courier New" está disponible
    boolean hascourier = false;
    boolean hasArial = false;
    
    for (String fontName : fontFamilyNames) {
        if (fontName.equals("Courier New")) {
            hascourier = true;
        } else if (fontName.equals("Arial")) {
            hasArial = true;
        }
    }
    
    // Agregar fuentes disponibles a la lista
    if (hasArial) availableFonts.add("Arial");
    if (hascourier) availableFonts.add("Courier New");
    availableFonts.add("Default");
    
    // Convertir la lista a array para el JOptionPane
    String[] options = availableFonts.toArray(new String[0]);
    
    String selectedFont = (String) JOptionPane.showInputDialog(
        this,
        "Select a font:",
        "Font Selection",
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[options.length - 1]);
    
    if (selectedFont != null) {
        switch (selectedFont) {
            case "Courier New":
                textArea.setFont(new java.awt.Font("Courier New", textArea.getFont().getStyle(), textArea.getFont().getSize()));
                break;
            case "Arial":
                textArea.setFont(new java.awt.Font("Arial", textArea.getFont().getStyle(), textArea.getFont().getSize()));
                break;
            case "Default":
                textArea.setFont(new java.awt.Font("Monospaced", textArea.getFont().getStyle(), textArea.getFont().getSize()));
                break;
        }
    }
    }//GEN-LAST:event_fuentesActionPerformed

    private void tamanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamanoActionPerformed
         String[] options = {"16", "24", "Default (12)"};
    String selectedSize = (String) JOptionPane.showInputDialog(
        this,
        "Select a font size:",
        "Font Size Selection",
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[2]);
    
    if (selectedSize != null) {
        int fontSize;
        switch (selectedSize) {
            case "16":
                fontSize = 16;
                break;
            case "24":
                fontSize = 24;
                break;
            case "Default (12)":
            default:
                fontSize = 12;
                break;
        }
        textArea.setFont(new java.awt.Font(textArea.getFont().getFamily(), textArea.getFont().getStyle(), fontSize));
    }
    }//GEN-LAST:event_tamanoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       System.exit(0);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String selectedText = textArea.getSelectedText();
  if (selectedText != null) {
  StringSelection stringSelection = new StringSelection(selectedText);
  Clipboard clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
  clipboard.setContents(stringSelection, null);
  textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
  }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String selectedText = textArea.getSelectedText();
  if (selectedText != null) {
  StringSelection stringSelection = new StringSelection(selectedText);
  Clipboard clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
  clipboard.setContents(stringSelection, null);
  }
 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  Clipboard clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
  Transferable contents = clipboard.getContents(null);
  if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
  try {
  String pastedText = (String) contents.getTransferData(DataFlavor.stringFlavor);
  textArea.replaceSelection(pastedText);
  } catch (UnsupportedFlavorException | IOException e) {
  e.printStackTrace();
  }
  }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void analizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarActionPerformed
   String text = textArea.getText();
    if (text == null || text.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "El área de texto está vacía.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Limpiar tablas
    DefaultTableModel model = (DefaultTableModel) tabla_resultados.getModel();
    model.setRowCount(0);
    DefaultTableModel errorModel = (DefaultTableModel) tabla_resultados_error.getModel();
    errorModel.setRowCount(0);
    analisis_sintactico.setText("");

    boolean lexicoExitoso = true;

    // ========== ANÁLISIS LÉXICO ==========
    try {
        java.io.StringReader reader = new java.io.StringReader(text);
        LexerCup lexer = new LexerCup(reader);
        
        Symbol token;
        int rowCount = 0;
        final int MAX_ROWS = 100;

        System.out.println("=== ANÁLISIS LÉXICO INICIADO ===");
        
        while (true) {
            token = lexer.next_token();
            if (token == null || token.sym == sym.EOF) {
                break;
            }

            int tokenType = token.sym;
            String tokenValue = (String) token.value;
            int line = token.left + 1;
            int column = token.right + 1;

            // Debug: mostrar todos los tokens en consola
            String tokenName = (tokenType < sym.terminalNames.length) ? 
                             sym.terminalNames[tokenType] : "UNKNOWN";
            System.out.println("Token: " + tokenName + " = '" + tokenValue + "' at " + line + ":" + column);

            Tokens tokenEnum = null;
            if (tokenType >= 0 && tokenType < sym.terminalNames.length) {
                String terminalName = sym.terminalNames[tokenType];
                for (Tokens t : Tokens.values()) {
                    if (terminalName.equals(t.name())) {
                        tokenEnum = t;
                        break;
                    }
                }
            }

            String description = (tokenEnum != null) ? tokenEnum.getDescription() : "Token no reconocido";

            if (tokenEnum != null && tokenEnum.isError()) {
                errorModel.addRow(new Object[]{line, column, description, tokenValue});
                lexicoExitoso = false;
            } else {
                if (rowCount < MAX_ROWS) {
                    model.addRow(new Object[]{line, tokenType, description, tokenValue});
                    rowCount++;
                }
            }
        }
        System.out.println("=== ANÁLISIS LÉXICO COMPLETADO ===");
        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error durante análisis léxico: " + ex.getMessage(), 
                                    "Error Léxico", JOptionPane.ERROR_MESSAGE);
        lexicoExitoso = false;
        Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
    }
// En analizarActionPerformed, después del análisis léxico exitoso:
debugParser(text);
    // ========== ANÁLISIS SINTÁCTICO Y SEMÁNTICO ==========
    if (lexicoExitoso && errorModel.getRowCount() == 0) {
        try {
            java.io.StringReader syntaxReader = new java.io.StringReader(text);
            LexerCup syntaxLexer = new LexerCup(syntaxReader);
            Sintax parser = new Sintax(syntaxLexer);

            System.out.println("=== INICIANDO ANÁLISIS SINTÁCTICO ===");
            
            parser.parse();
            
            if (parser.resultado.isEmpty()) {
                // ✅ Análisis sintáctico exitoso
                analisis_sintactico.setText("✅ Análisis sintáctico exitoso.\n");
                
                // Análisis semántico
                try {
                    TablaSimbolos tablaSimbolos = parser.tabla;
                    AnalizadorSemantico analizadorSemantico = parser.semantico;
                    
                    analisis_sintactico.append("✅ Análisis semántico exitoso.\n");
                    analisis_sintactico.append("Tabla de símbolos generada correctamente.\n");
                    
                    System.out.println("=== TABLA DE SÍMBOLOS ===");
                    System.out.println(tablaSimbolos.toString());
                    
                } catch (Exception e) {
                    analisis_sintactico.append("⚠️ Análisis semántico no disponible: " + e.getMessage());
                    System.err.println("Error en análisis semántico: " + e.getMessage());
                }
                
            } else {
                analisis_sintactico.setText("❌ Errores sintácticos:\n" + parser.resultado);
                System.err.println("Errores sintácticos: " + parser.resultado);
            }
            
        } catch (Exception e) {
            String errorMsg = "❌ Error en análisis sintáctico: " + e.getMessage();
            analisis_sintactico.setText(errorMsg);
            System.err.println(errorMsg);
            e.printStackTrace();
        }
    } else {
        analisis_sintactico.setText("❌ Análisis sintáctico no realizado debido a errores léxicos.");
        System.err.println("Errores léxicos detectados, análisis sintáctico omitido.");
    }

    }//GEN-LAST:event_analizarActionPerformed
private void debugParser(String text) {
    try {
        System.out.println("=== DEBUG PARSER ===");
        java.io.StringReader reader = new java.io.StringReader(text);
        LexerCup lexer = new LexerCup(reader);
        
        Symbol token;
        System.out.println("Tokens generados por el lexer:");
        while (true) {
            token = lexer.next_token();
            if (token == null || token.sym == sym.EOF) break;
            
            String tokenName = sym.terminalNames[token.sym];
            System.out.printf("Linea %d, Columna %d: %s = '%s'%n", 
                token.left + 1, token.right + 1, tokenName, token.value);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private String obtenerNombreToken(int tipoToken) {
    // Array manual basado en tu sym.java
    String[] nombres = {
        "EOF", "error", "TipoVariable", "TipoConstante", "TipoNulo", "TipoGenerico",
        "FuncionPrincipal", "Importar", "Clase", "Ejecutar", "InicioPrograma", "FinPrograma",
        "If", "Else", "While", "For", "DefFuncion", "Return", "Input", "Output",
        "BoolTrue", "BoolFalse", "Suma", "Resta", "Multiplicacion", "Division", "Modulo",
        "Incremento", "Decremento", "IgualComparacion", "Diferente", "MenorIgual", "MayorIgual",
        "Menor", "Mayor", "And", "Or", "Not", "Igual", "SumaAsignacion", "RestaAsignacion",
        "MultiplicacionAsignacion", "DivisionAsignacion", "ParentesisAbre", "ParentesisCierra",
        "LlaveAbre", "LlaveCierra", "CorcheteAbre", "CorcheteCierra", "PuntoyComa", "Coma",
        "DosPuntos", "Punto", "Identificador", "NumeroDecimal", "NumeroEntero", "Cadena"
    };
    
    if (tipoToken >= 0 && tipoToken < nombres.length) {
        return nombres[tipoToken];
    }
    return "Desconocido";
}

private String obtenerMensajeError(int tipoToken, String lexema) {
    if (tipoToken == 1) { // error
        if (lexema != null && !lexema.isEmpty()) {
            if (lexema.matches("[a-z][a-zA-Z0-9]*")) {
                return "Identificador debe empezar con mayúscula: " + 
                       lexema.substring(0, 1).toUpperCase() + lexema.substring(1);
            } else if (lexema.matches("(vill|con|nad|gen|eje|capivara|inicio:|final|importar|clase)")) {
                return "Palabra reservada debe empezar con mayúscula";
            } else if (lexema.matches("\\d+\\.")) {
                return "Número decimal incompleto. Falta parte decimal";
            } else if (lexema.matches("\\.\\d+")) {
                return "Número decimal incompleto. Falta parte entera";
            } else if (lexema.startsWith("\"") && !lexema.endsWith("\"")) {
                return "Cadena sin cerrar. Falta comilla de cierre (\")";
            }
        }
        return "Token no reconocido en el lenguaje Capivara";
    }
    return "Error léxico";
}

private String obtenerCategoriaToken(int tipoToken) {
    // Palabras reservadas (2-21)
    if (tipoToken == 2 || tipoToken == 3 || tipoToken == 4 || tipoToken == 5 ||
        tipoToken == 6 || tipoToken == 7 || tipoToken == 8 || tipoToken == 9 ||
        tipoToken == 10 || tipoToken == 11 || tipoToken == 12 || tipoToken == 13 ||
        tipoToken == 14 || tipoToken == 15 || tipoToken == 16 || tipoToken == 17 ||
        tipoToken == 18 || tipoToken == 19 || tipoToken == 20 || tipoToken == 21) {
        return "Palabra reservada";
    }
    
    // Operadores aritméticos (22-28)
    if (tipoToken >= 22 && tipoToken <= 28) {
        return "Operador aritmético";
    }
    
    // Operadores relacionales (29-34)
    if (tipoToken >= 29 && tipoToken <= 34) {
        return "Operador relacional";
    }
    
    // Operadores lógicos (35-37)
    if (tipoToken >= 35 && tipoToken <= 37) {
        return "Operador lógico";
    }
    
    // Operadores de asignación (38-42)
    if (tipoToken >= 38 && tipoToken <= 42) {
        return "Operador de asignación";
    }
    
    // Delimitadores (43-52)
    if (tipoToken >= 43 && tipoToken <= 52) {
        return "Delimitador";
    }
    
    // Identificadores y literales
    if (tipoToken == 53) return "Identificador";
    if (tipoToken == 54) return "Número decimal";
    if (tipoToken == 55) return "Número entero";
    if (tipoToken == 56) return "Cadena de texto";
    
    return obtenerNombreToken(tipoToken);
}


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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea analisis_sintactico;
    private javax.swing.JMenuItem analizar;
    private javax.swing.JMenuItem copiar;
    private javax.swing.JMenuItem cortar;
    private javax.swing.JMenuItem fuentes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTree jTree1;
    private javax.swing.JTree jTree2;
    private javax.swing.JTree jTree3;
    private javax.swing.JTree jTree4;
    private javax.swing.JMenuItem pegar;
    private javax.swing.JTable tabla_resultados;
    private javax.swing.JTable tabla_resultados_error;
    private javax.swing.JMenuItem tamano;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
