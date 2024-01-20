import java.util.Random;
import java.util.Arrays;
public class GuessTheNumberGame {
    Random random;
    int targetNumber;
    public static void main(String[] args) {
        // Iniciamos el juego creando un objeto de tipo GuessTheNumberGame
        GuessTheNumberGame game = new GuessTheNumberGame();
        // Generamos el número a adivinar de forma aleatoria
        game.random = new Random();
        game.targetNumber = game.random.nextInt(100);
        // 1. Creamos el objeto de tipo HumanPlayer que será el jugador 1
        HumanPlayer player1 = new HumanPlayer();
        // 2. Creamos el jugador 2, que será la computadora
        ComputerPlayer player2 = new ComputerPlayer();
        // 3. El usuario ingresa el nombre del jugador desde el teclado
        player1.setName();
        // 4. Definimos la cantidad de intentos: 10
        int intentos = 10;
        // 5. Iniciamos el juego
        for (int i = 0; i < 10; i++) {
            // Le preguntamos el número al player1
            int guessNumberPlayer1 = player1.makeGuess();
            //  Vemos si el número que ingreso el player 1 adivino el que generamos
            boolean adivino = game.checkGuess(player1);
            if(adivino){
                System.out.println(player1.getName() + " adivinaste el número: " + game.targetNumber + " . En el turno: " + i + " . Intentos anteriores: " + Arrays.toString(player1.getGuesses()));
                System.exit(1);
            }else{
                game.checkNearOrFar(game.targetNumber, guessNumberPlayer1);
            }
            //Le preguntamos el número a la computadora
            int guessNumberComputer = player2.makeGuess();
            System.out.println("La computadora eligio: " + guessNumberComputer);
            //  Vemos si el número que ingreso el player 1 adivino el que generamos
            boolean adivinoComputer = game.checkGuess(player2);
            if(adivinoComputer){
                System.out.println("La computadora ha adivinado el número: : " + game.targetNumber + " . En el turno: " + i +" . Intentos anteriores: " + Arrays.toString(player1.getGuesses()));
                System.exit(1);
            }else{
                game.checkNearOrFar(game.targetNumber, guessNumberComputer);
            }
        }
        System.out.println("Nadie gano en " + intentos + " intentos. El numero era: " + game.targetNumber);
        // Terminamos el programa
        System.exit(0);
    }

    public boolean checkGuess(Player player){
        // Obtenemos las suposiciones del jugador
        int[] guessesPlayer1 = player.getGuesses();
        //convierte el array en un flujo (stream) de enteros, y anyMatch(x -> x == numero)
        // verifica si algún elemento del stream es igual al número buscado.
        return Arrays.stream(guessesPlayer1).anyMatch(x -> x == this.targetNumber);
    }

    public void checkNearOrFar(int base, int number){
        double diferencia = Math.abs(base - number);

        // Compara la diferencia con el umbral de cercanía
        if(diferencia < 5){
            System.out.println("El número " + number + " está cerca");
        }else{
            System.out.println("El número " + number + " está lejos");
        }
    }
}
