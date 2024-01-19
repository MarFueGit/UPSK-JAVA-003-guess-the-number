

public class GuessTheNumberGame {
    java.util.Random random;
    int targetNumber;
    public static void main(String[] args) {
        HumanPlayer player1 = new HumanPlayer();
        player1.setName("maricela");
        System.out.println("nombre: " + player1.getName());
    }

    public boolean checkGuess(Player player){
        return true;
    }
}
