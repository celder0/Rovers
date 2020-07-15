package entities;

import exceptions.InvalidPositionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    @Test
    void roverConstructorWithRoverConfigSetsTheXPositionBasedOnFirstElement() throws Exception {
        Rover rover = new Rover("1 2 E");
        assertEquals(1, rover.getX());
    }

    @Test
    void roverConstructorWithRoverConfigThrowsErrorWhenXPositionIsNonInteger() {
        assertThrows(InvalidPositionException.class, () -> {new Rover("L 1 E");});
    }
}