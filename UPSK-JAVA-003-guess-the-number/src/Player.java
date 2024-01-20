import java.util.Scanner;

public abstract class Player{
    private String name; // El nombre de la jugadora
    int[] guesses; // El historial de suposiciones de la jugadora

    public abstract int makeGuess(); // Devuelve la suposición de la jugadora. Es un método abstracto.
    public  String getName(){ // Devuelve el nombre de la jugadora.
        return this.name;
    }
    public  int[] getGuesses(){ // Devuelve el historial de suposiciones de la jugadora.
        return this.guesses;
    }

    public void setName(){
        // Creamos un objeto llamado teclado de tipo scanner para ingresar datos desde el teclado
        Scanner teclado = new Scanner(System.in);
        // Le preguntamos al player1 su nombre
        System.out.print("Hola, escribe tu nombre: ");
        // Creamos otra variable para guardar lo que el jugador ingresa desde el teclado
        this.name = teclado.nextLine();
    }

    
}
