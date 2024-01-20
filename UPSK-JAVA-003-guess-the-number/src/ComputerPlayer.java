import java.util.Random;

public class ComputerPlayer extends Player{
    Random random;

    @Override
    public int makeGuess() {
        // Generamos el número a adivinar de forma aleatoria
        this.random = new Random();
        int player2Number = random.nextInt(100);
        // Crea un nuevo array con un tamaño aumentado en uno
        this.guesses = new int[0];
        int[] newGuesses = new int[this.guesses.length + 1];
        // Copia los elementos existentes al nuevo array
        System.arraycopy(this.guesses, 0, newGuesses, 0, guesses.length);
        // Coloca el nuevo número al final del nuevo array
        newGuesses[this.guesses.length] = player2Number;
        // Actualiza la referencia del array de suposiciones
        guesses = newGuesses;
        return player2Number;
    }
}
