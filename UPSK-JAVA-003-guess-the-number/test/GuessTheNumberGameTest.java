import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class GuessTheNumberGameTest {

    private GuessTheNumberGame game;
    private HumanPlayer player1;
    private  ComputerPlayer player2;

    @Before
    public void setUpTest(){
        this.game = new GuessTheNumberGame();
    }

    // Test donde el número que elige la jugadora es mayor
    @Test
    public void testNumberGreater() {
        this.game.targetNumber = 40;
        // Creamos un objeto de tipo HumanPlayer para nuestro test
        HumanPlayer player1 = new HumanPlayer();
        // Mockeo setName
        System.setIn(new ByteArrayInputStream("Mary\n".getBytes()));
        player1.setName("Mary");

        // Mockeamos el número que el usuario elige
        System.setIn(new ByteArrayInputStream("60\n".getBytes()));
        //Invocamos a makeGuess
        player1.makeGuess();
        // Assert. Confirmamos que el juego muestra: El número 60, lejos ...
        assertEquals("El número 60, lejos ...", this.game.checkNearOrFar(this.game.targetNumber, 60));
    }
    // Test donde el número que elige la jugadora es menor
    @Test
    public void testNumberLower() {
        this.game.targetNumber = 20;
        // Creamos un objeto de tipo HumanPlayer para nuestro test
        HumanPlayer player1 = new HumanPlayer();
        // Mockeo setName
        System.setIn(new ByteArrayInputStream("Mary\n".getBytes()));
        player1.setName("Mary");

        // Mockeamos el número que el usuario elige
        System.setIn(new ByteArrayInputStream("15\n".getBytes()));
        //Invocamos a makeGuess
        player1.makeGuess();
        // Assert. Confirmamos que el juego muestra: El número 15, cerca ...
        assertEquals("El número 15, cerca ...", this.game.checkNearOrFar(this.game.targetNumber, 15));
    }
    // Test simulando que el número que eligio la jugadora player1 gano.
    @Test
    public void testPlayer1Win(){
        ComputerPlayer computerPlayer = Mockito.spy(new ComputerPlayer());
        HumanPlayer humanPlayer = Mockito.spy(new HumanPlayer());
        System.setIn(new ByteArrayInputStream("50\n".getBytes()));
        when(humanPlayer.makeGuess()).thenReturn(50);
        int[] guessesHuman= {50};
        when(humanPlayer.getGuesses()).thenReturn(guessesHuman);
        this.game.startGame(humanPlayer, computerPlayer, 50);
        assertTrue(this.game.checkGuess(humanPlayer));
    }

    @Test
    public void testPlayer2Win(){
        GuessTheNumberGame game = Mockito.spy(new GuessTheNumberGame());
        ComputerPlayer computerPlayer = Mockito.spy(new ComputerPlayer());
        HumanPlayer humanPlayer = Mockito.spy(new HumanPlayer());
        System.setIn(new ByteArrayInputStream("63\n".getBytes()));
        when(humanPlayer.makeGuess()).thenReturn(63);
        int[] guessesHuman= {63};
        when(humanPlayer.getGuesses()).thenReturn(guessesHuman);
        int[] guessesComputer= {10};when(computerPlayer.makeGuess()).thenReturn(10);
        when(computerPlayer.getGuesses()).thenReturn(guessesComputer);
        this.game.startGame(humanPlayer, computerPlayer, 10);
        assertTrue(this.game.checkGuess(computerPlayer));
    }
}