package entities;

import exceptions.InvalidDimensionsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {
    @Test
    void plateauConstructorWithConfigLoadsFirstItemAsWidth() throws InvalidDimensionsException {
        Plateau plateau = new Plateau("1 2");
        assertEquals(1, plateau.getWidth());
    }

    @Test
    void plateauConstructorWithConfigLoadsSecondItemAsLength() throws InvalidDimensionsException {
        Plateau plateau = new Plateau("1 2");
        assertEquals(2, plateau.getLength());
    }

    @Test
    void plateauConstructorWithConfigThrowsErrorIfWidthIsNonInteger() {
       assertThrows(InvalidDimensionsException.class, () -> {new Plateau("L 1");});
    }
}