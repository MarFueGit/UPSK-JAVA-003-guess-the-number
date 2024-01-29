import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;  //es una clase de Mockito que se utiliza para crear objetos simulados (mocks) y configurar su comportamiento.
import static org.mockito.Mockito.when;  //se utiliza para configurar el comportamiento de los mocks.


// Declaramos la clase prueba a testear ComputerPlayerTest.
public class ComputerPlayerTest {

    //Declaramos nuestro objeto a usar en el test
    private Player player;

    // Aquí va nuestro método de configuración antes de cada prueba
    @Before
    public void setUpTest(){
        this.player = new ComputerPlayer();
    }

    // Método de prueba "testMakeGuess"
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