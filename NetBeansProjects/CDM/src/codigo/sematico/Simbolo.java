package codigo.sematico;

public class Simbolo {
    private String nombre;
    private String tipo;
    private Object valor;

    public Simbolo(String nombre, String tipo, Object valor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public Object getValor() { return valor; }

    public void setValor(Object valor) { this.valor = valor; }

    @Override
    public String toString() {
        return "Simbolo{nombre=" + nombre + ", tipo=" + tipo + ", valor=" + valor + "}";
    }
}
