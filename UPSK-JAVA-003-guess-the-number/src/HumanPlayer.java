import java.util.Arrays;
import java.util.Scanner; // lee datos introducidos por el usuario desde la entrada standard como el teclado
public class HumanPlayer extends Player{ // extends establece la herencia entre clases, esto quiere decir que puede heredar atributos y métodos de otra clase
    @Override
    public int makeGuess() { // Método que cada clase que hereda de Player debe implementar.
        Scanner teclado = new Scanner(System.in);
        System.out.print(this.getName() + ", escribe el número que crees: ");
        int player1Number = teclado.nextInt();
        int[] newGuesses = new int[this.guesses.length + 1];
        // Copia los elementos existentes al nuevo array
        System.arraycopy(this.guesses, 0, newGuesses, 0, guesses.length);
        // Coloca el nuevo número al final del nuevo array
        newGuesses[this.guesses.length] = player1Number;
        // Actualiza la referencia del array de suposiciones
        guesses = newGuesses;
        return player1Number;
    }
}
