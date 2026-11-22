package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {

    public static void main(String[] args) throws Exception {
        // ✅ Rutas corregidas (sin el ':' inicial)
        // 🔹 Se recomienda mover el proyecto a una carpeta sin acentos ni espacios
        // por ejemplo: C:\Proyectos\CDM\
        String basePath = "C:/Users/Juan Luis Cano/OneDrive - Instituto Tecnologico Superior de San Luis Potosi, Capital/Documentos/CDM/";

        String ruta1 = basePath + "src/codigo/Lexer.flex";
        String ruta2 = basePath + "src/codigo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", basePath + "src/codigo/Sintax.cup"};

        generar(ruta1, ruta2, rutaS);
    }

    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception {
        // ✅ Generar analizadores con JFlex
        File archivo;

        archivo = new File(ruta1);
        if (archivo.exists()) {
            JFlex.Main.generate(archivo);
        } else {
            System.err.println("⚠️ No se encontró el archivo: " + ruta1);
            return;
        }

        archivo = new File(ruta2);
        if (archivo.exists()) {
            JFlex.Main.generate(archivo);
        } else {
            System.err.println("⚠️ No se encontró el archivo: " + ruta2);
            return;
        }

        // ✅ Generar parser con CUP
        java_cup.Main.main(rutaS);

        // ✅ Mover archivos generados (sym.java y Sintax.java)
        Path rutaSym = Paths.get(rutaBase("src/codigo/sym.java"));
        Path rutaSymGen = Paths.get(rutaBase("CDM/sym.java"));
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        if (Files.exists(rutaSymGen)) {
            Files.move(rutaSymGen, rutaSym);
        } else {
            System.err.println("⚠️ No se encontró el archivo generado sym.java");
        }

        Path rutaSin = Paths.get(rutaBase("src/codigo/Sintax.java"));
        Path rutaSinGen = Paths.get(rutaBase("CDM/Sintax.java"));
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        if (Files.exists(rutaSinGen)) {
            Files.move(rutaSinGen, rutaSin);
        } else {
            System.err.println("⚠️ No se encontró el archivo generado Sintax.java");
        }

        System.out.println("✅ Generación completada correctamente.");
    }

    // Método auxiliar para evitar repetir la ruta base
    private static String rutaBase(String relativePath) {
        return "C:/Users/Juan Luis Cano/OneDrive - Instituto Tecnologico Superior de San Luis Potosi, Capital/Documentos/CDM/" + relativePath;
    }
}

