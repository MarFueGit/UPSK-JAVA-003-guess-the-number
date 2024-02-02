import java.util.Random; // Random: clase que Genera números aleatorios
import java.util.Arrays;  // Manipula arreglos
import java.util.Scanner;  // Entrada de datos desde el teclado


// clase principal que contiene toda la lógica del juego.
public class GuessTheNumberGame {
    // Atributos de la clase.
    Random random; // genera los números aleatorios
    int targetNumber; // almacena el número generado por el programa a intentar a adivinar.

    // Método main inicia el juego
    public static void main(String [ ] args) {
        // 1. Creamos un objeto llamado game de tipo GuessTheNumberGame
        GuessTheNumberGame game = new GuessTheNumberGame();
        // Creamos un objeto de tipo Random y lo asignamos al atributo random que tiene game
        game.random = new Random();
        //Usamos el objeto random que acabamos de crear para generar un número entero aleatorio
        //Este número aleatorio será el que se adivinara él en juego y lo guardamos en una variable
        //Entre 1 y 100 con el método nextIn()
        int targetNumber  = game.random.nextInt(100 - 1 + 1) + 1;
        // 2. Creamos el objeto player1 de tipo HumanPlayer
        HumanPlayer player1 = new HumanPlayer();
        // 3. Creamos un objeto llamado teclado de tipo scanner para ingresar datos desde el teclado
        Scanner teclado = new Scanner(System.in);
        // Ponemos un en consola un texto para preguntar el nombre del jugador
        System.out.print("Hola, escribe tu nombre: ");
        // Creamos otra variable llamada name para guardar lo que el jugador ingresa desde el teclado
        // Como ingresara un String, usamos nextLine(), si fuera un entero usariamos nexInt()
        String name = teclado.nextLine();
        // Con el valor que guardamos del teclado en la variable name, invoco al metodo setName
        // Y le paso la variable, este metodo seteara el nombre de la jugadora
        player1.setName(name);
        // 4. Creamos el objeto llamado player2 de tipo ComputerPlayer que será la computadora
        ComputerPlayer player2 = new ComputerPlayer();
        //5. Invocamos al juego o iniciamos el juego, con el metodo startGame
        //Le pasamos el jugador1, el jugador2 y el número a adivinar, el cual generamos
        //de forma aleatoria con Random
        game.startGame(player1, player2, targetNumber);
    }

    //Métodos del juego checkGuess verifica si el jugador ha adivinado el número objetivo
    public boolean checkGuess(Player player){
        // Obtenemos las suposiciones del jugador
        int[] guessesPlayer1 = player.getGuesses();
        //convierte el array en un flujo (stream) de enteros, y anyMatch(x -> x == numero)
        // verifica si algún elemento del stream es igual al número buscado.
        return Arrays.stream(guessesPlayer1).anyMatch(x -> x == this.targetNumber);
    }


    //Métodos del juego checkNearOrFar compara un número con el número objetivo y devuelve un mensaje indicando si está cerca o lejos del objetivo.
    public String checkNearOrFar(int base, int number){
        double diferencia = Math.abs(base - number);

        // Compara la diferencia con el umbral de cercanía
        if(diferencia <= 5){
            return "El número " + number + ", cerca ...";
        }else{
            return "El número " + number + ", lejos ...";
        }
    }

// En este método está toda la lógica del juego StartGame
    // permitiendo que los jugadores hagan sus suposiciones y verificando si han adivinado el número objetivo.
    public void startGame(HumanPlayer player1, ComputerPlayer player2, int targetNumber){
        this.targetNumber = targetNumber;
        // 4. Definimos la cantidad de intentos: 10 y bucle del juego
        boolean someoneWin = false;
        int intentos = 1;
        // 5. Iniciamos el juego
        while (!someoneWin) {
            // Le preguntamos el número al player1
            int guessNumberPlayer1 = player1.makeGuess();
            //  Vemos si el número que ingreso el player 1 adivino el que generamos
            boolean adivino = this.checkGuess(player1);
            if(adivino){
                System.out.println(player1.getName() + "¡ganaste! el número fue: " + this.targetNumber + " . En el turno: " + (intentos) + " . Historial de suposiciones: " + Arrays.toString(player1.getGuesses()));
                break;
            }else{
                System.out.println(this.checkNearOrFar(this.targetNumber, guessNumberPlayer1));
            }

            //antes de que la computadora genere el número, haremos que sea capaz de leer lo que el jugador1 eligio
            // Asi sabremos si está lejos o cerca y sobre eso la computadora generará el nuevo número
            String cercaOLejos = this.checkNearOrFar(this.targetNumber, guessNumberPlayer1);
            if(cercaOLejos.contains("cerca")){
                System.out.println("CERCA ENTRE EN EL IF");
                player2.min = guessNumberPlayer1 - 5;
                player2.max = guessNumberPlayer1 + 5;

            }else{
                player2.min = guessNumberPlayer1 + 10;
                player2.max = 100;
            }

            // Le avisamos a la computadora las ultimas supociisiones del player
            player2.guessesOtherPlayer = player1.getGuesses();
            //Le preguntamos el número a la computadora
            int guessNumberComputer = player2.makeGuess();
            System.out.println("La computadora eligio: " + guessNumberComputer);// Imprime en consola un mensaje y realiza un salto de línea
            //  Vemos si el número que ingreso el player 1 adivino el que generamos
            boolean adivinoComputer = this.checkGuess(player2);
            if(adivinoComputer){
                System.out.println("La computadora ha ganado, el número fue: : " + this.targetNumber + " . En el turno: " + (intentos) +" . Historial de suposiciones: " + Arrays.toString(player1.getGuesses()));
                break;
            }else{
                System.out.println(this.checkNearOrFar(this.targetNumber, guessNumberComputer));
            }
            intentos++;
        }
        // Terminamos el programa
    }
}
