import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;

public class HumanPlayerTest {
    // Creamos un objeto de tipo Player para testear
    private Player player;

    @Before
    public void setUpTest(){
        this.player = new HumanPlayer();
    }

    @Test
    public void testSetName(){
        //Mockeamos la entrada del teclado - Prepare
        System.setIn(new ByteArrayInputStream("Mary\n".getBytes()));

        //Invocamos setName - Act
        this.player.setName("Mary");

        //Verificamos que si haya seteado el name - Assert
        Assert.assertEquals("Mary", this.player.getName());
    }

    @Test
    public void testMakeGuess(){
        // Mockear la entrada del teclado - Prepare
        System.setIn(new ByteArrayInputStream("20\n".getBytes()));
        //Invocamos a makeGuess - Prepare and Act
        int guess = this.player.makeGuess();
        //Confirmar o validar que el número que genero la clase es entero
        Assert.assertEquals(Integer.class, Integer.valueOf(guess).getClass());
        //Confirmamos o validamos que el número aleatorio que genero el objeto está entre 1 y 100
        Assert.assertTrue(guess >= 1 && guess <= 100);

        //Testeamos getGuesses
        int[] guesses = this.player.getGuesses(); //guesses es lo que tiene el objeto
        int[] guessesExpected = {20}; //Lo que espero que tenga el objeto
        Assert.assertArrayEquals(guesses, guessesExpected);
    }
}