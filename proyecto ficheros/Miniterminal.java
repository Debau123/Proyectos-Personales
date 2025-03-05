import java.util.Scanner;

public class Miniterminal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String entrada;
        MiniFileManager archivo = new MiniFileManager();

        do {
            System.out.println("Menú:");
            System.out.println("1. pwd: Mostrar la carpeta actual.");
            System.out.println("2. cd: <DIR>: Cambiar a la carpeta especificada.");
            System.out.println("3. ls: Mostrar lista de archivos y directorios.");
            System.out.println("4. ll: Mostrar lista detallada de archivos y directorios.");
            System.out.println("5. mkdir <DIR>: Crear un directorio.");
            System.out.println("6. rm <FILE>: Borrar un archivo o directorio.");
            System.out.println("7. mv <FILE1> <FILE2>: Mover o renombrar un archivo.");
            System.out.println("8. exit: Salir del programa.");
            System.out.print("Selecciona una opción: ");
            System.out.print("Selecciona una opción: ");
            entrada = scanner.nextLine();
            switch (entrada) {
                case "pwd":
                    System.out.println(archivo.getDirectorio());
                    break;
                case "cd":
                    System.out.println("Que carpeta quieres cambiar? " +".."+"para ir al padre");
                    String DIR;
                    DIR = scanner.nextLine();
                    if (archivo.cambiarDirectorio(DIR)) {
                        System.out.println("Se cambió al directorio padre correctamente.");
                    } else {
                        System.out.println("No se pudo cambiar al directorio padre.");
                    }
                    break;
                case "ls":
                    archivo.listarDirectoriosArchivos();
                    break;
                case "ll":
                    archivo.listarDirectoriosArchivosCompleta();
                    break;
                case "mkdir":
                    System.out.println("Dime el nombre del nuevo directorio: ");
                    String directorio;
                    directorio = scanner.nextLine();
                    archivo.crearDirectorio(directorio);
                    break;

                case "rm":
                    System.out.println("Dime el nombre del archivo o carpeta a borrar ");
                    String borrar;
                    borrar = scanner.nextLine();
                    archivo.rm(borrar);
                    break;
                case "mv":
                    System.out.println("Dime el nombre del archivo o carpeta de origen: ");
                    String archivoorigen = scanner.nextLine();
                    System.out.println("Dime el nuevo nombre del archivo o carpeta de destino: ");
                    String archivodestino = scanner.nextLine();
                    archivo.mv(archivoorigen, archivodestino);
                    break;
                case "exit":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    
            }
            System.out.println();
            System.out.println();
        } while (!entrada.equals("exit"));
    }
}

