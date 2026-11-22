package codigo.sematico;

import java.util.HashMap;
import java.util.Map;

public class TablaSimbolos {
    // Map que guarda <nombre -> Simbolo>
    private Map<String, Simbolo> tabla = new HashMap<>();

    public boolean existe(String nombre) {
        return tabla.containsKey(nombre);
    }

    // Inserta un Simbolo
    public void insertar(String nombre, String tipo, Object valor) {
        tabla.put(nombre, new Simbolo(nombre, tipo, valor));
    }

    // OBTENER debe devolver Simbolo, no String
    public Simbolo obtener(String nombre) {
        return tabla.get(nombre);
    }

    public void actualizar(String nombre, Object valor) {
        Simbolo s = tabla.get(nombre);
        if (s != null) {
            s.setValor(valor);
        }
    }

    @Override
    public String toString() {
        return tabla.values().toString();
    }
}
