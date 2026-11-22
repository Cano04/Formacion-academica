/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;

/**
 *
 * @author rekej
 */
public class Principal {
    public static void main(String[] args) {
        String ruta = "C:/Users/Juan Luis Cano/OneDrive - Instituto Tecnológico Superior de San Luis Potosí, Capital/NetBeansProjects/Nueva carpeta/Proyecto Automatas 5 (1)/Proyecto Automatas 5/CDM/src/codigo/Lexer.flex";
        generarLexer(ruta);
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo); 
    }
}
