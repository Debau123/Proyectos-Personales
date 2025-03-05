import java.util.Random;
import java.util.Scanner;

public class hundir_la_flota_basico {


    public static void main(String[] args) {

        char[][] tablero = new char[10][10];
        char guion = '-';
        char[][] tableroOculto = new char[10][10];

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = guion;
            }
        }

        for (int i = 0; i < tableroOculto.length; i++) {
            for (int j = 0; j < tableroOculto[i].length; j++) {
                tableroOculto[i][j] = guion;
            }
        }

        System.out.println("Aqui tienes el tablero para empezar la partida");
        mostrarTablero(tablero);

        ponerBarcos(tableroOculto, guion);

        int intentos = 0;
        System.out.println("Toca jugar");

        while (intentos < 50 && quedanBarcos(tableroOculto)) {
            int[] coordenadas = pideCoordenadasDisparo(tablero);
            int fila = coordenadas[0];
            int columna = coordenadas[1];

            if (disparar(tableroOculto, tablero, fila, columna)) {
                System.out.println("¡Tocado!");
            } else {
                System.out.println("¡Agua!");
            }

            mostrarTablero(tablero);
            intentos++;
        }

        if (quedanBarcos(tableroOculto)) {
            System.out.println("¡Has perdido! Quedaron barcos en el agua.");
        } else {
            System.out.println("¡Felicidades! Has hundido todos los barcos.");
        }
    }

    public static void mostrarTablero(char[][] tablero) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void ponerBarcos(char[][] tableroOculto, char guion) {
        Random random = new Random();
        int numeroBarcos = 0;
        char lancha = 'L';

        while (numeroBarcos < 10) {
            int posicionX = random.nextInt(10);
            int posicionY = random.nextInt(10);

            if (tableroOculto[posicionX][posicionY] == guion) {
                tableroOculto[posicionX][posicionY] = lancha;
                numeroBarcos++;
            }
        }
    }

    public static int[] pideCoordenadasDisparo(char[][] tablero) {
        Scanner entrada = new Scanner(System.in);
        int[] coordenadas = new int[2];

        while (true) {
            System.out.println("Cual es tu tirada");
            System.out.println("Dime la fila (A-J): ");
            coordenadas[0] = coordenadaAFila(entrada.next());

            System.out.println("Dime la columna (0-9): ");
            coordenadas[1] = entrada.nextInt();

            if (coordenadasValidas(coordenadas, tablero)) {
                break;
            } else {
                System.out.println("Coordenadas no válidas. Inténtalo de nuevo.");
            }
        }

        return coordenadas;
    }

    public static boolean coordenadasValidas(int[] coordenadas, char[][] tablero) {
        int fila = coordenadas[0];
        int columna = coordenadas[1];

        return fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero[0].length;
    }

    public static boolean disparar(char[][] tableroOculto, char[][] tableroVisible, int fila, int columna) {
        if (tableroOculto[fila][columna] == 'L') {
            tableroVisible[fila][columna] = 'T'; // Tocado
            return true;
        } else {
            tableroVisible[fila][columna] = 'A'; // Agua
            return false;
        }
    }

    public static boolean quedanBarcos(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 'L') {
                    return true;
                }
            }
        }
        return false;
    }

    public static int coordenadaAFila(String coordenada) {
        return coordenada.charAt(0) - 'A';
    }
}
