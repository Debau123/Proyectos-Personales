import java.util.Random;
import java.util.Scanner;

public class personalizado2 {

    public static void main(String[] args) { /*en la main agrupamos en el funcionamiento del programa al principio leemos la dificultad mediante "menuModoJuego" luego iniciamos variables
        que vamos a necesitar luego tenemos condicionales dependiendo de la dificultad  determinamos los paramateros de cada dificultad luego llamamos al metodo "colocarBarcos"
         y por ultimo al tener ya todo montado llamaos al metodo " jugarPartida"*/
        int dificultad = menuModoJuego();//aqui empezamos el programa  con el menu teniendo la dificultat
        int intentos = 0; //apartir de aqui estan las diferentes vriables que vamos a usar  durante todo el programa
        int numeroLanchas;
        int numeroBarcos;
        int numeroAcorazados = 0;
        int numeroPortaaviones = 0;
        char guion = '-'; // aqui  creamos el char
        char[][] tablero;
        char[][] tableroOculto;

        if (dificultad == 1 || dificultad == 2 || dificultad == 3) { //el primer iff para detectar las dificultades 1,2,3 que son las  que tienen el tablero predeterminado y los barcos
            // dependiendo de la dificultad pues tenemos  diferentes  numero de barcos pero el tablero siempre es el mismo por eso esta fuera de los iff
            int filas = 10;
            int columnas = 10;
            char[][][] tableros = crearTablero(filas, columnas);
            tablero = tableros[0];
            tableroOculto = tableros[1];
            if (dificultad == 1) { // como cada programa tiene  diferentes if  dentro del if
                intentos = 50;
                numeroLanchas = 5;
                numeroBarcos = 3;
                numeroAcorazados = 1;
                numeroPortaaviones = 1;
                colocarBarcos(tableroOculto, guion, numeroLanchas, numeroBarcos, numeroAcorazados, numeroPortaaviones);

            }
            if (dificultad == 2) {
                intentos = 30;
                numeroLanchas = 2;
                numeroBarcos = 1;
                numeroAcorazados = 1;
                numeroPortaaviones = 1;
                colocarBarcos(tableroOculto, guion, numeroLanchas, numeroBarcos, numeroAcorazados, numeroPortaaviones);
                muestraTableroInvisible(tableroOculto);
            }
            if (dificultad == 3) {
                intentos = 10;
                numeroLanchas = 1;
                numeroBarcos = 1;
                colocarBarcos(tableroOculto, guion, numeroLanchas, numeroBarcos, numeroAcorazados, numeroPortaaviones);

            }
        } else {
            //Aqui preguntamos por todos los parametros  del personalizado.
            System.out.println("Modo personalizado activo");
            Scanner entrada = new Scanner(System.in);
            System.out.println("Cuantas filas quieres que tenga el tablero?");
            int filas = entrada.nextInt();
            System.out.println("Cuantas columnas quieres que tenga el tablero?");
            int columnas = entrada.nextInt();
            System.out.println("Cuantos intentos quieres tener?");
            intentos = entrada.nextInt();
            char[][][] tableros = crearTablero(filas, columnas);
            tablero = tableros[0];
            tableroOculto = tableros[1];
            System.out.println("Cuantas lanchas quieres poner?");
            numeroLanchas = entrada.nextInt();
            System.out.println("Cuantos Barcos quieres poner?");
            numeroBarcos = entrada.nextInt();
            System.out.println("Cuantos Acorazado quieres poner?");
            numeroAcorazados = entrada.nextInt();
            System.out.println("Cuantos PortaAviones quieres poner?");
            numeroPortaaviones = entrada.nextInt();
            colocarBarcos(tableroOculto, guion, numeroLanchas, numeroBarcos, numeroAcorazados, numeroPortaaviones);

        }
        jugarPartida(tablero, tableroOculto, intentos);
    }

    public static void colocarBarcos(char[][] tableroOculto, char guion, int numeroLanchas, int numeroBarcos, int numeroAcorazados, int numeroPortaaviones) {
        //Este metodo lo hemos creado para agrupar la colacacion de todos los tipos de barcos
        ponerLancha(tableroOculto, guion, numeroLanchas);
        ponerBarcos(tableroOculto, guion, numeroBarcos);
        ponerAcorazado(tableroOculto, guion, numeroAcorazados);
        ponerPortaaviones(tableroOculto, guion, numeroPortaaviones);
    }

    public static void ponerBarcos(char[][] tableroOculto, char guion, int numeroBarcos) {
        //Este metodo sirve para poner los Barcos mediante un bucle while de forma aleatoria teniendo en cuenta que lo que ocupa.
        Random random = new Random();
        char Barco = 'B'; //aqui creamos para poner una b en teclado
        int Barcos = 0;

        while (Barcos < numeroBarcos) { //aqui es el bucle que mientras barcos sean mayor que los barcos que han creado siga poniendo barcos
            int posicionX = random.nextInt(tableroOculto.length); //aqui es para poner el barco en la posicion x
            int posicionY = random.nextInt(tableroOculto[0].length - 2);//y aqui es para poner el barco en una posicion menos -2 que es lo que ocupa sino se saldria
            //lo hacemos con .lenght para que el numero aleatorio esea como el larguero
            if (tableroOculto[posicionX][posicionY] == guion &&
                    tableroOculto[posicionX][posicionY + 1] == guion &&
                    tableroOculto[posicionX][posicionY + 2] == guion) {

                tableroOculto[posicionX][posicionY] = Barco;
                tableroOculto[posicionX][posicionY + 1] = Barco;
                tableroOculto[posicionX][posicionY + 2] = Barco;

                Barcos++; //aqui suma a la variable 1
            }
        }
    }

    public static void ponerAcorazado(char[][] tableroOculto, char guion, int numeroAcorazados) {
        //Este metodo sirve para poner los Acorazado mediante un bucle while de forma aleatoria teniendo en cuenta que lo que ocupa.
        //La explicacion es igual que la de barcos. para el resto la mecanica es la misma
        Random random = new Random();
        char acorazado = 'A';
        int acorazados = 0;

        while (acorazados < numeroAcorazados) {
            int posicionX = random.nextInt(tableroOculto.length);
            int posicionY = random.nextInt(tableroOculto[0].length - 3);

            if (tableroOculto[posicionX][posicionY] == guion &&
                    tableroOculto[posicionX][posicionY + 1] == guion &&
                    tableroOculto[posicionX][posicionY + 2] == guion &&
                    tableroOculto[posicionX][posicionY + 3] == guion) {

                tableroOculto[posicionX][posicionY] = acorazado;
                tableroOculto[posicionX][posicionY + 1] = acorazado;
                tableroOculto[posicionX][posicionY + 2] = acorazado;
                tableroOculto[posicionX][posicionY + 3] = acorazado;

                acorazados++;
            }
        }
    }

    public static void ponerPortaaviones(char[][] tableroOculto, char guion, int numeroPortaaviones) {
        //Este metodo sirve para poner los Portaviones mediante un bucle while de forma aleatoria teniendo en cuenta que lo que ocupa.
        Random random = new Random();
        char portaavion = 'P';
        int portaaviones = 0;

        while (portaaviones < numeroPortaaviones) {
            int posicionX = random.nextInt(tableroOculto.length - 3);
            int posicionY = random.nextInt(tableroOculto[0].length);

            if (tableroOculto[posicionX][posicionY] == guion &&
                    tableroOculto[posicionX + 1][posicionY] == guion &&
                    tableroOculto[posicionX + 2][posicionY] == guion &&
                    tableroOculto[posicionX + 3][posicionY] == guion) {

                tableroOculto[posicionX][posicionY] = portaavion;
                tableroOculto[posicionX + 1][posicionY] = portaavion;
                tableroOculto[posicionX + 2][posicionY] = portaavion;
                tableroOculto[posicionX + 3][posicionY] = portaavion;

                portaaviones++;
            }
        }
    }

    public static void ponerLancha(char[][] tableroOculto, char guion, int numeroLanchas) {
        //Este metodo sirve para poner los Lancha mediante un bucle while de forma aleatoria teniendo en cuenta que lo que ocupa.
        Random random = new Random();
        int lanchas = 0;
        char lancha = 'L';

        while (lanchas < numeroLanchas) {
            int posicionX = random.nextInt(tableroOculto.length);
            int posicionY = random.nextInt(tableroOculto[0].length);

            if (tableroOculto[posicionX][posicionY] == guion) {
                tableroOculto[posicionX][posicionY] = lancha;
                lanchas++;
            }
        }
    }


    public static int menuModoJuego() {
        //Este menu muestra los modos de juego y lee la entrada del usuario y valida que sea valida
        int dificultad;

        do {
            System.out.println("Hola, ¿qué modo de juego quieres?\n" +
                    "1- Modo Fácil\n" +
                    "2- Modo Normal\n" +
                    "3- Modo Difícil\n" +
                    "4- Modo Personalizado");

            Scanner entrada = new Scanner(System.in);
            dificultad = entrada.nextInt();
            //aqui hacmeos que sea una dificultad validad
            if (dificultad == 1) {
                System.out.println("Modo Fácil seleccionado");
            } else if (dificultad == 2) {
                System.out.println("Modo Normal seleccionado");
            } else if (dificultad == 3) {
                System.out.println("Modo Difícil seleccionado");
                System.out.println("¡Mucha suerte!");
            } else if (dificultad == 4) {
                System.out.println("Modo Personalizado seleccionado");
            } else {
                System.out.println("Opción no válida, por favor ingresa 1, 2, 3 o 4");
            }
        } while (dificultad < 1 || dificultad > 4);

        return dificultad; // devuelve la dificultad
    }

    public static char[][][] crearTablero(int filas, int columnas) {
        //Inicializa dos tableros , uno para mostrar al jugador y otro para ocultar la posicion de los barcos
        //dependiendo de las filas y columanas que le enviemos crea el tablero y lo llena de -
        char guion = '-';
        char[][] tablero = new char[filas][columnas];
        char[][] tableroOculto = new char[filas][columnas];
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
        return new char[][][]{tablero, tableroOculto}; //lo emos echo asi para devolver  los dos tableros
    }

    public static void muestraTableroVisible(char[][] tablero) {
        //Imprime el tablero
        //siemplemente imprime el tablero
        System.out.print("  ");
        for (int i = 0; i < tablero[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < tablero.length; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void muestraTableroInvisible(char[][] tableroOculto) {
        //Imprime el tablero oculto del pc
        System.out.print("  ");
        for (int i = 0; i < tableroOculto[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < tableroOculto.length; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < tableroOculto[i].length; j++) {
                System.out.print(tableroOculto[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void jugarPartida(char[][] tablero, char[][] tableroOculto, int intentos) {
    /*Inicia el bucle de juego donde el jugador tiene un número limitado de intentos para adivinar y hundir todos los barcos en el tablero.
     Muestra el tablero antes de cada tirada para que el jugador vea que tirada hacer
     Verifica si se ha acertado o no, y muestra si has acertado o no.*/

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < intentos; i++) {
            System.out.println("Intento #" + (i + 1));
            muestraTableroVisible(tablero);

            int[] coordenadas = pideCoordenadasDisparo(tablero);
            int fila = coordenadas[0];
            int columna = coordenadas[1];

            if (disparar(tableroOculto, tablero, fila, columna)) {
                System.out.println("¡Tocado!");
            } else {
                System.out.println("¡Agua!");
            }

            if (!quedanBarcos(tableroOculto)) {
                System.out.println("¡Win! Has hundido todos los barcos.");
                break;//salimos del bucle
            }
        }

        System.out.println("¡Juego terminado! No te quedan intentos tio.");
        muestraTableroInvisible(tableroOculto);
    }

    public static int[] pideCoordenadasDisparo(char[][] tablero) {
        //Pide las cordenadas para el disparo y las verifica si son cottectas

        Scanner scanner = new Scanner(System.in);

        int[] coordenadas = new int[2];
        System.out.print("Ingresa la fila (letra): ");
        String filaInput = scanner.next().toUpperCase();
        char filaChar = filaInput.charAt(0);
        coordenadas[0] = filaChar - 'A';

        System.out.print("Ingresa la columna (número): ");
        coordenadas[1] = scanner.nextInt();

        while (coordenadas[0] < 0 || coordenadas[0] >= tablero.length || coordenadas[1] < 0 || coordenadas[1] >= tablero[0].length) { //aqui comprueba si la corrdenada es valida
            System.out.println("Coordenadas inválidas. Vuelve a ingresarlas.");
            System.out.print("Ingresa la fila (letra): ");
            filaInput = scanner.next().toUpperCase();
            filaChar = filaInput.charAt(0);
            coordenadas[0] = filaChar - 'A';

            System.out.print("Ingresa la columna (número): ");
            coordenadas[1] = scanner.nextInt();
        }

        return coordenadas;
    }

    public static boolean disparar(char[][] tableroOculto, char[][] tablero, int fila, int columna) {
        // Este metodo  comprueba si el disparo del jugador ha alcanzado a un barco o no y actualiza con una X si has acertado y con A si has fallado en el trableor del jugador
        if (tableroOculto[fila][columna] != '-') { //aqui comprueba  si es qguion o no
            tablero[fila][columna] = 'X';
            tableroOculto[fila][columna] = 'X';
            return true;
        } else {
            tablero[fila][columna] = 'A';
            return false;
        }
    }

    public static boolean quedanBarcos(char[][] tableroOculto) {
        //Este metodo verifica si quedan barcos en el tablero oculto para saber si han ganado
        for (int i = 0; i < tableroOculto.length; i++) {
            for (int j = 0; j < tableroOculto[i].length; j++) {
                if (tableroOculto[i][j] != '-' && tableroOculto[i][j] != 'X') {
                    return true;
                }
            }
        }
        return false;
    }

}

