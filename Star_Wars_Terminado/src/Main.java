import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "                         === STAR WARS CÓDIGOS SECRETOS ===                       \n" +
                "Hace mucho tiempo, en una galaxia muy, muy lejana… La Princesa Leia, Luke\n" +
                "Skywalker, Han Solo, Chewbacca, C3PO y R2D2 viajan en una nave imperial robada\n" +
                "en una misión secreta para infiltrarse en otra estrella de la muerte que el imperio\n");

        int S1 = (int) (Math.random() * 10) + 1; //Aqui cremamos la variable S1 entre 1 y 10 incluido los 2.
        int S2 = (int) (Math.random() * 11) + 20; //Aqui cremaos la varible S2 entre los numeros 20 y 30 incluido ambos.
        int sumatorio = 0;//Aqui declaro he inicio la variable sumatorio para tener en  el sumatorio la respuesta guardada.
        for (int i = S1; i <= S2; i++) {// Aqui ejecuto un bucle para obtener la respuesta, del sumatorio de S1 Y S2 ambos incluidos
            sumatorio = i + sumatorio;
        }
        String input = JOptionPane.showInputDialog("Los problemas empiezan cuando deben realizar un salto hiperespacial hasta al\n" +
                "sistema " + S1 + " en el sector " + S2 + " , pero el sistema de navegación está estropeado y el\n" +
                "computador tiene problemas para calcular parte de las coordenadas de salto.\n" +
                "Chewbacca, piloto experto, se da cuenta que falta el cuarto número de la serie.\n" +
                "Recuerda de sus tiempos en la academia de pilotos que para calcularlo hay que\n" +
                "calcular el sumatorio entre el nº del sistema y el nº del sector (ambos inclusive).\n" +
                "¿Qué debe introducir?");

        int resultado = Integer.parseInt(input); //Aqui hago que lo que tecleen el JOption sea la variable resultado
        if (resultado == sumatorio) { //aqui el primer if para saber si el resultado es igual que el sumatorio y pase al nivel 2
            int P1 = (int) (1 + Math.random() * (7 - 1 + 1)); //Aqui cremamos la variable P1 entre 1 y 7 incluido los 2
            int P2 = (int) (8 + Math.random() * (12 - 8 + 1)); //Aqui cremaos la variable p2 entre los numeros 12 y 8 incluido ambos.
            int multiplicador = 1;//Aqui declaro he inicio la variable sumatorio1 para tener el sumatorio la respuesta guardada
            for (int i = P1; i <= P2; i++) {//  aqui ejecuto un bucle para obtener la respuesta del multiplicador de P1 hasta P2 ambos incluidos
                multiplicador = i * multiplicador;
            }
            String input2 = JOptionPane.showInputDialog("Gracias a Chewbacca consiguen llegar al sistema correcto y ven a lo lejos la estrella \n" +
                    "de la muerte. Como van en una nave imperial robada se aproximan lentamente con \n" +
                    "la intención de pasar desapercibidos. De repente suena el comunicador. “Aquí \n" +
                    "agente de espaciopuerto " + P1 + " contactando con nave imperial " + P2 + " No están destinados \n" +
                    "en este sector. ¿Qué hacen aquí?”. Han Solo coge el comunicador e improvisa. “Eh… \n" +
                    "tenemos un fallo en el… eh… condensador de fluzo... Solicitamos permiso para \n" +
                    "atracar y reparar la nave”. El agente, que no se anda con tonterías, responde \n" +
                    "Proporcione código de acceso o abriremos fuego”. Han Solo ojea rápidamente el \n" +
                    "manual del piloto que estaba en la guantera y da con la página correcta. El código \n" +
                    "es el productorio entre el nº del agente y el nº de la nave (ambos inclusive). \n" +
                    "¿Cuál es el código?");

            int resultado1 = Integer.parseInt(input2);//Aqui hago que lo que tecleen el JOption sea la variable resultado
            if (resultado1 == multiplicador) { //aqui el primer if para saber si el resultado es igual que el sumatorio y pase al nivel 2
                int N = (int) (50 + Math.random() * (100 - 50 + 1)); //aqui declaro la variable N
                int N2 = (N / 10); // aqui declaro la variable  N2 que es N divido de 10 y al ser un int siempre redondea a la baja como pone el ejercicio
                int factorial = 1;//inicio la varible del resultado
                for (int i = N2; i > 0; i--) { //aqui hago un bucle for para obtener  el factorial de N2
                    factorial = factorial * i;
                }
                String input3 = JOptionPane.showInputDialog(" Han Solo proporciona el código correcto. Atracan en la estrella de la muerte, se \n" +
                        " equipan con trajes de soldados imperiales que encuentran en la nave para pasar \n" +
                        " desapercibidos y bajan. Ahora deben averiguar en qué nivel de los " + N + " existentes se \n" +
                        " encuentra el reactor principal. Se dirigen al primer panel computerizado que \n" +
                        " encuentran y la Princesa Leia intenta acceder a los planos de la nave pero necesita \n" +
                        " introducir una clave de acceso. Entonces recuerda la información que le proporcionó \n" +
                        " Lando Calrissian “La clave de acceso a los planos de la nave es el factorial de " + N + "/10 \n" +
                        " (redondeando N hacia abajo), donde N es el nº de niveles.\n" +
                        " ¿Cual es el nivel correcto?");

                int resultado2 = Integer.parseInt(input3); //aqui como siempre la respuesta de JOption la pongo en una variable
                if (resultado2 == factorial) { //aqui comparo la variable que escrito con la reespuesta
                    int P = (int) (10 + Math.random() * (100 - 10 + 1)); //aqui dechaclaro la variable P que sera un numero de 10 a 100 ambos incluidos
                    int i = 1, c = 0; //Aqui declaro la variable i que es para iniciar el bucle while y la c que es un contador
                    while (i <= P) { //aqui es el bucle mientras i sea menor que nuestro numero se inicie
                        if (P % i == 0) { //esto es el if para sumarle al contador del si nuestro numero cuantos restos igual a 0 tiene
                            c++;          //aqui le sumamos uno si P tiene un resto igual a 0
                        }
                        i++;               //aqui sumamos a i 1 para que pueda ir por todos los numeros
                    }
                    int primo;             //aqui declaro la variante primo una vez a terminado el bucle pero no la inicio
                    if (c == 2) {          //aqui digo que si nuestro contador C es igual a 2  que significa que nuestro numero solo a tenido 2 veces el resto 0 por lo tanto es primo nuestra variable primo es 1.
                        primo = 1;
                    } else {               //aqui digo que sino nuestro numero C a tenido un resultado que nosea 2 es decir no a tenido mas restos o menos a 0 quiero decir que no es primo nuestra variable primo sea 0.
                        primo = 0;
                    }
                    String input4 = JOptionPane.showInputDialog("Gracias a la inteligencia de Leia llegan al nivel correcto y encuentran la puerta \n" +
                            "acorazada que da al reactor principal. R2D2 se conecta al panel de acceso para \n" +
                            "intentar hackear el sistema y abrir la puerta. Para desencriptar la clave necesita \n" +
                            "verificar si el  " + P + " es primo o no. Si es primo introduce un 1, si no lo es\n" +
                            "introduce un 0");

                    int resultado3 = Integer.parseInt(input4); //aqui como siempre la respuesta de JOption la pongo en una variable
                    if (resultado3 == primo) {  // aqui compara si el usuario a respondido con un 0 o 1 y acertado si el numero es primo o no con la variable p
                        int M = (int) (5 + Math.random() * (10 - 5 + 1)); // Aqui declaro he inicio la variable M que es un numero entre 5 y 10 ambos incluidos
                        int S = (int) (5 + Math.random() * (10 - 5 + 1)); // Aqui declaro he inicio la variable S que es un numero entre 5 y 10 ambos incluidos
                        int Factorial_1 = 1;  //Aqui declaro la variable donde se guardara el primer factorial el de M
                        int Factorial_2 = 1;   //Aqui declaro la variable donde se guardara el segundo factorial factorial el de s
                        int Factorial_F;  //Aqui declaro la variable que me servira para la suma de los dos factoriales
                        for (i = M; i > 0; i--) {      //Bucle para calcular el primer factorial
                            Factorial_1 = Factorial_1 * i;
                        }
                        for (i = S; i > 0; i--) {         //Bucle para calcular el segundo factorial
                            Factorial_2 = Factorial_2 * i;
                        }
                        Factorial_F = Factorial_1 + Factorial_2; //inicio la variable de la suma de los dos factoriales
                        String input5 = JOptionPane.showInputDialog("Consiguen entrar al reactor. Ya solo queda que Luke Skywalker coloque la bomba,\n" +
                                "programe el temporizador y salir de allí corriendo. Necesita programarlo para que \n" +
                                "explote en exactamente " + M + " minutos y " + S + " segundos, el tiempo suficiente para escapar \n" +
                                "antes de que explote pero sin que el sistema de seguridad anti-explosivos detecte y \n" +
                                "desactive la bomba. Pero el temporizador utiliza un reloj Zordgiano un tanto \n" +
                                "peculiar. Para convertir los minutos y segundos al sistema Zordgiano hay que sumar \n" +
                                "el factorial de " + M + "  el factorial de " + S + " . ¿Qué valor debe introducir?");
                        int resultado4 = Integer.parseInt(input5); //aqui como siempre la respuesta de JOption la pongo en una variable
                        if (resultado4 == Factorial_F) {
                            JOptionPane.showMessageDialog(null, "Luke Skywalker introduce el tiempo correcto, activa el temporizador y empiezan a\n" +
                                    "sonar las alarmas. Salen de allí corriendo, no hay tiempo que perder. La nave se\n" +
                                    "convierte en un hervidero de soldados de arriba a abajo y entre el caos que les rodea\n" +
                                    "consiguen llegar a la nave y salir de allí a toda prisa. A medida que se alejan\n" +
                                    "observan por la ventana la imagen de la colosal estrella de la muerte explotando en\n" +
                                    "el silencio del espacio, desapareciendo para siempre junto a los restos del malvado\n" +
                                    "imperio.\n" + "\n" + "\n" +
                                    "¡Has salvado la galaxia gracias a la Fuerza Jedi de las matemáticas! Enhorabuena ;D");
                        } else {
                            JOptionPane.showMessageDialog(null, "Game Over");

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Game Over");
                    }


                } else {
                    JOptionPane.showMessageDialog(null, "Game Over");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Game Over");
            }


        }
    }
}
