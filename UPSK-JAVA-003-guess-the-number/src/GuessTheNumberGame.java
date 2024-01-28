import java.util.Random; // Random: clase que Genera números aleatorios
import java.util.Arrays;
import java.util.Scanner;

public class GuessTheNumberGame {   // clase principal que contiene toda la lógica del juego.
    // Atributos de la clase.
    Random random;
    int targetNumber; //Numero generado por el programa a intentar a adivinar.
    public static void main(String [ ] args) {
        // Iniciamos el juego creando un objeto de tipo GuessTheNumberGame
        GuessTheNumberGame game = new GuessTheNumberGame();
        game.random = new Random();
        int targetNumber  = game.random.nextInt(100);
        // 1. Creamos el objeto de tipo HumanPlayer que será el jugador 1
        HumanPlayer player1 = new HumanPlayer();
        // 3. El usuario ingresa el nombre del jugador desde el teclado
        // Creamos un objeto llamado teclado de tipo scanner para ingresar datos desde el teclado
        Scanner teclado = new Scanner(System.in);
        // Le preguntamos al player1 su nombre
        System.out.print("Hola, escribe tu nombre: ");
        // Creamos otra variable para guardar lo que el jugador ingresa desde el teclado
        String name = teclado.nextLine();
        player1.setName(name);
        // 2. Creamos el jugador 2, que será la computadora
        ComputerPlayer player2 = new ComputerPlayer();
        game.startGame(player1, player2, targetNumber);
    }

    public boolean checkGuess(Player player){
        // Obtenemos las suposiciones del jugador
        int[] guessesPlayer1 = player.getGuesses();
        //convierte el array en un flujo (stream) de enteros, y anyMatch(x -> x == numero)
        // verifica si algún elemento del stream es igual al número buscado.
        return Arrays.stream(guessesPlayer1).anyMatch(x -> x == this.targetNumber);
    }

    public String checkNearOrFar(int base, int number){
        double diferencia = Math.abs(base - number);

        // Compara la diferencia con el umbral de cercanía
        if(diferencia <= 5){
            return "El número " + number + ", cerca ...";
        }else{
            return "El número " + number + ", lejos ...";
        }
    }

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
                System.out.println(player1.getName() + "¡ganaste! el número fue: " + this.targetNumber + " . En el turno: " + (intentos + 1) + " . Historial de suposiciones: " + Arrays.toString(player1.getGuesses()));
                someoneWin = true;
            }else{
                System.out.println(this.checkNearOrFar(this.targetNumber, guessNumberPlayer1));
            }
            //Le preguntamos el número a la computadora
            int guessNumberComputer = player2.makeGuess();
            System.out.println("La computadora eligio: " + guessNumberComputer);// Imprime en consola un mensaje y realiza un salto de línea
            //  Vemos si el número que ingreso el player 1 adivino el que generamos
            boolean adivinoComputer = this.checkGuess(player2);
            if(adivinoComputer){
                System.out.println("La computadora ha ganado, el número fue: : " + this.targetNumber + " . En el turno: " + (intentos + 1) +" . Historial de suposiciones: " + Arrays.toString(player1.getGuesses()));
                someoneWin = true;
            }else{
                System.out.println(this.checkNearOrFar(this.targetNumber, guessNumberComputer));
            }
            intentos++;
        }
        // Terminamos el programa
    }
}
