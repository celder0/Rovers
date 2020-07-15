package entities;

import exceptions.InvalidDimensionsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {
    @Test
    void plateauConstructorWithConfigLoadsFirstItemAsWidth() {
        Plateau plateau = new Plateau("1 2");
        assertEquals(1, plateau.getWidth());
    }

    @Test
    void plateauConstructorWithConfigLoadsSecondItemAsLength() {
        Plateau plateau = new Plateau("1 2");
        assertEquals(2, plateau.getLength());
    }
}