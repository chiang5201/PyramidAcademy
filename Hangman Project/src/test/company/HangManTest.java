package company;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class HangManTest {

    HangMan temp= new HangMan();

    @Test
    void drew(){
        temp.drawMan();
    }
    @Test
    void reset(){
        temp.reset();
    }
}