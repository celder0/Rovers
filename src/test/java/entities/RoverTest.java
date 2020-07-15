package entities;

import enums.Directions;
import exceptions.InvalidPositionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    @Test
    void roverConstructorWithRoverConfigSetsTheXPositionBasedOnFirstElement() throws Exception {
        Rover rover = new Rover("1 2 E", new Plateau(1, 2));
        assertEquals(1, rover.getX());
    }

    @Test
    void roverConstructorWithRoverConfigThrowsErrorWhenXPositionIsNonInteger() {
        assertThrows(InvalidPositionException.class, () -> {new Rover("L 1 E", new Plateau(1, 2));});
    }

    @Test
    void roverConstructorWithRoverConfigThrowsErrorWhenXPositionIsOutsideOfPlateau() {
        assertThrows(InvalidPositionException.class, () -> {new Rover("2 1 E", new Plateau(1,2));});
    }

    @Test
    void roverConstructorWithRoverConfigSetsTheYPositionBasedOnSecondElement() throws Exception {
        Rover rover = new Rover("1 2 E", new Plateau(1, 2));
        assertEquals(2, rover.getY());
    }

    @Test
    void roverConstructorWithRoverConfigThrowsErrorWhenYPositionIsNonInteger() {
        assertThrows(InvalidPositionException.class, () -> {new Rover("1 Y E", new Plateau(1, 2));});
    }

    @Test
    void roverConstructorWithRoverConfigThrowsErrorWhenYPositionIsOutsideOfPlateau() {
        assertThrows(InvalidPositionException.class, () -> {new Rover("1 3 E", new Plateau(1,2));});
    }

    @Test
    void roverConstructorWithRoverConfigSetsHeadingBasedOnThirdElement() throws Exception {
        Rover rover = new Rover("1 2 E", new Plateau(1, 2));
        assertEquals(Directions.E, rover.getHeading());
    }
}