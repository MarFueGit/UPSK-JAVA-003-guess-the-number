import java.util.Arrays;
import java.util.Random;

public class ComputerPlayer extends Player{
    Random random;
    public int min = 1; // Valor mínimo del intervalo
    public int max = 100; // Valor máximo del intervalo
    private int intervalo = 0;
    int[] guessesOtherPlayer; //En esta propiedad guardaremos las supociones del humano para no repetirlas
    @Override
    public int makeGuess() {
        // Generamos el número a adivinar de forma aleatoria
        this.random = new Random();
        this.intervalo= this.max - this.min + 1;
        if(this.intervalo < 0){
            this.intervalo = 1;
        }
        int player2Number = random.nextInt(this.intervalo) + this.min;
        //Hay que validar que el numero que acaba de generar no exista ya en las supocisiones pasadas
        // Mientras genere numeros que ya existan, no saldra del ciclo hasta generar uno diferente
        while (Arrays.asList(this.getGuesses()).contains(player2Number) || Arrays.asList(this.guessesOtherPlayer).contains(player2Number)) {
            player2Number = random.nextInt(this.intervalo) + this.min;
        }
        // Crea un nuevo array con un tamaño aumentado en uno
        this.guesses = new int[0];
        int[] newGuesses = new int[this.guesses.length + 1];
        // Copia los elementos existentes al nuevo array
        System.arraycopy(this.guesses, 0, newGuesses, 0, guesses.length);
        // Coloca el nuevo número al final del nuevo array
        newGuesses[this.guesses.length] = player2Number;
        // Actualiza la referencia del array de suposiciones
        this.guesses = newGuesses;
        return player2Number;
    }
}
