import java.util.Scanner;

public abstract class Player{
    private String name; // variable privada que almacena el nombre de la jugadora
    int[] guesses; // Array que almacena el historial de suposiciones de la jugadora

    public abstract int makeGuess(); // Devuelve la suposición de la jugadora. Es un método abstracto.
    public  String getName(){ // Devuelve el nombre de la jugadora.
        return this.name;
    }
    public  int[] getGuesses(){ // Devuelve el historial de suposiciones de la jugadora.
        return this.guesses;
    }

    public void setName(String name){
        this.name = name;
    }

    public Player(){
        // Crea un nuevo array con un tamaño aumentado en uno
        this.guesses = new int[0];
        this.name = "Player 1";
    }
}
