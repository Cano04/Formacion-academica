package codigo.sematico;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorSemantico {
     private TablaSimbolos tabla;
     private List<String> errores;

     public AnalizadorSemantico(TablaSimbolos tabla) {
         this.tabla = tabla;
         this.errores = new ArrayList<>();
     }

     public void declararVariable(String nombre, String tipo) {
         if (tabla.existe(nombre)) {
             String error = "Error semántico: la variable '" + nombre + "' ya fue declarada.";
             errores.add(error);
             System.err.println("⚠️ " + error);
         } else {
             tabla.insertar(nombre, tipo, null);
             System.out.println("✅ Variable declarada: " + nombre + " de tipo " + tipo);
         }
     }

     // ... similar para validarAsignacion y verificarTipo

     public List<String> getErrores() {
         return errores;
     }
}