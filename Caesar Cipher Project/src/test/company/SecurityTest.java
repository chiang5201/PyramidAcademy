package company;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SecurityTest {

    Security test=new Security();
    @Test
    void encrypt() {
        assertEquals(true,test.encrypt("AbC XyZ",1));
    }

    @Test
    void decrypt() throws IOException {
        assertEquals(true,test.decrypt() );
    }
}