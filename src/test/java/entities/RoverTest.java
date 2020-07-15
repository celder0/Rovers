package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    @Test
    void roverConstructorWithRoverConfigSetsTheXPositionBasedOnFirstElement() {
        Rover rover = new Rover("1 2 E");
        assertEquals(1, rover.getX());
    }
}