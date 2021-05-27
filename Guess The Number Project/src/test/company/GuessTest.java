package company;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GuessTest {
    Guess game;
    @BeforeEach
    void setup()
    {
        game= new Guess("Rocky",10);
    }

    @Test
    void play() {
        assertEquals(true, game.play(2 ), "line15");
        assertEquals(true, game.play(8 ), "line16");
        assertEquals(true, game.play(9 ), "line17");
        assertEquals(true, game.play(1 ), "line18");
        assertEquals(true, game.play(20 ), "line19");
        assertEquals(true, game.play(13 ), "line20");
        assertEquals(false, game.play(15 ), "line21");
    }

    @Test
    void endGame() {
        assertEquals(false, game.play(10 ), "line26");
        game.endGame(12);
        assertEquals(true, game.play(6 ), "line28");
        assertEquals(false, game.play(12 ), "line29");
        game.endGame(2);
    }
}