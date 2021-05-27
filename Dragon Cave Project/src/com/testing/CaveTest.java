import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaveTest {
    Cave temp=new Cave();

    @Test
    void one() {

        temp.one();
    }

    @Test
    void two() {
        assertEquals( true,temp.two(),"line 15");
    }
}