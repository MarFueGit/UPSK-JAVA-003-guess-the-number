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

    public void setName(String name){
        this.name = name;
    }

    
}
