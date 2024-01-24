import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class ComputerPlayerTest {

    //Declaramos nuestro objeto a usar en el test
    private Player player;

    @Before
    public void setUpTest(){
        this.player = new ComputerPlayer();
    }

    @Test
    public void testMakeGuess(){

        // Mockeamos con mockito el objeto player- Prepare
        this.player = Mockito.spy(this.player);
        int[] guessesExpected = {60}; //Lo que espero que tenga el objeto
        when(this.player.makeGuess()).thenReturn(60);

        //Invocamos al metodo makeGuess - Act
        int guess = this.player.makeGuess();
        Assert.assertEquals(guess, 60);

        //Verificamos que el número 60 si se haya guardado en el array de guesses
        when(this.player.getGuesses()).thenReturn(guessesExpected);
        //Testeamos getGuesses
        int[] guesses = this.player.getGuesses(); //guesses es lo que tiene el objeto
        Assert.assertArrayEquals(guesses, guessesExpected);
    }
}