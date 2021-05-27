package company;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game=new Game('x','o');

    @Test
    void user()
    {   assertEquals(true,  game.userMove(1));
        assertEquals(false, game.userMove(1));
        assertEquals(false, game.userWins());
        assertEquals(true,  game.userMove(2));
        assertEquals(true,  game.userMove(3));
        assertEquals(true,  game.userWins());
    }

    @Test
    void ai()
    {   assertEquals(false, game.AIWins());
        assertEquals(true,  game.aiMove());
        assertEquals(true,  game.aiMove());
        assertEquals(true,  game.aiMove());
        assertEquals(true,  game.aiMove());
        assertEquals(true,  game.aiMove());
        assertEquals(false, game.aiMove());
    }

    @Test
    void drawing() {
        game.Drawing();
    }
}