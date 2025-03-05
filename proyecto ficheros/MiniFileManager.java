import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MiniFileManager {

    private File directorio;


    public MiniFileManager() {

        this.directorio = new File(System.getProperty("user.dir"));
    }

    public File getDirectorio() {
        return directorio;
    }

    public boolean cambiarDirectorio(String nombreDirectorio) {
        if (nombreDirectorio.equals("..")) {
            File directorioPadre = directorio.getParentFile();
            if (directorioPadre != null) {
                directorio = directorioPadre;
                return true;
            } else {
                return false; // El directorio padre no existe (ya estás en el directorio raíz)
            }
        } else {
            File nuevoDirectorio = new File(directorio, nombreDirectorio);
            if (nuevoDirectorio.exists() && nuevoDirectorio.isDirectory()) {
                directorio = nuevoDirectorio;
                return true;
            }
        }
        return false; // No se pudo cambiar de directorio
    }
    public void listarDirectoriosArchivos() {
        File[] archivos = directorio.listFiles();
        Arrays.sort(archivos, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.getName().compareToIgnoreCase(f2.getName());
            }
        });
        for (File archivo : archivos) {
            System.out.println(archivo.getName());
        }
    }

    public void listarDirectoriosArchivosCompleta() {
        File[] archivos = directorio.listFiles();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Arrays.sort(archivos, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.getName().compareToIgnoreCase(f2.getName());
            }
        });
        for (File archivo : archivos) {
            String tipo = (archivo.isDirectory()) ? "Directorio" : "Archivo";
            long tamano = archivo.length();
            String fechaModificacion = dateFormat.format(new Date(archivo.lastModified()));

            System.out.printf(archivo.getName() + " Es archivo o directorio: " + tipo + " Fecha: " + fechaModificacion + " Tamaño: " + tamano);
            System.out.println();

        }
    }

    public void crearDirectorio(String nombreDirectorio) {
        File directorio = new File(this.directorio, nombreDirectorio);

        if (!directorio.exists()) {
            if (directorio.mkdir()) {
                System.out.println("Directorio '" + nombreDirectorio + "' creado correctamente.");
            } else {
                System.err.println("Error al crear el directorio '" + nombreDirectorio + "'.");
            }
        } else {
            System.out.println("El directorio '" + nombreDirectorio + "' ya existe.");
        }
    }

    public void rm(String nombreArchivo) {
        File archivo = new File(this.directorio, nombreArchivo);

        if (archivo.exists()) {
            if (archivo.isFile()) {

                if (archivo.delete()) {
                    System.out.println("Archivo '" + nombreArchivo + "' eliminado correctamente.");
                } else {
                    System.err.println("No se pudo eliminar el archivo '" + nombreArchivo + "'.");
                }
            } else if (archivo.isDirectory()) {
                // Es una carpeta
                if (archivo.listFiles().length == 0) {

                    if (archivo.delete()) {
                        System.out.println("Carpeta '" + nombreArchivo + "' eliminada correctamente.");
                    } else {
                        System.err.println("No se pudo eliminar la carpeta '" + nombreArchivo + "'.");
                    }
                } else {
                    System.out.println("La carpeta '" + nombreArchivo + "' no está vacía.");
                    System.out.println("Para eliminarla, primero elimine todos los archivos y subcarpetas dentro de ella.");
                }
            }
        } else {
            System.out.println("El archivo o carpeta '" + nombreArchivo + "' no existe.");
        }
    }

    public void mv(String nombreArchivorigen, String nombreArchivodestino) {
        File archivoOrigen = new File(this.directorio, nombreArchivorigen);
        File archivoDestino = new File(this.directorio, nombreArchivodestino);


        if (archivoOrigen.exists()) {

            if (archivoDestino.exists()) {
                System.out.println("El archivo o carpeta destino '" + nombreArchivodestino + "' ya existe.");
                return;
            }

            if (archivoOrigen.renameTo(archivoDestino)) {
                System.out.println("El archivo o carpeta '" + nombreArchivorigen + "' se movió correctamente a '" + nombreArchivodestino + "'.");
            } else {
                System.err.println("No se pudo mover o renombrar el archivo o carpeta '" + nombreArchivorigen + "'.");
            }
        } else {
            System.out.println("El archivo o carpeta de origen '" + nombreArchivorigen + "' no existe.");
        }
    }
}

















