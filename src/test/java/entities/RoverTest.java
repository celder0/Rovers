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

    @Test
    void roverConstructorWithRoverConfigThrowsErrorWhenHeadingIsNotValid(){
        assertThrows(InvalidPositionException.class, () -> {new Rover("1 1 R", new Plateau(1,2));});
    }

    @Test
    void roverMoveOnePositiveXWhenFacingEast(){
        Rover rover = new Rover(0,0, Directions.E, new Plateau(1, 1));
        rover.followInstructions("M");
        assertEquals(1, rover.getX());
    }

    @Test
    void roverMoveDoesNotChangeYWhenFacingEast(){
        Rover rover = new Rover(0,0, Directions.E, new Plateau(1, 1));
        rover.followInstructions("M");
        assertEquals(0, rover.getY());
    }

    @Test
    void roverDoesNotMoveWhenFacingEastAndAtPlateausUpperXBorder(){
        Rover rover = new Rover(0,0, Directions.E, new Plateau(0,0));
        rover.followInstructions("M");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    void roverMoveOnePositiveYWhenFacingNorth(){
        Rover rover = new Rover(0,0, Directions.N, new Plateau(1, 1));
        rover.followInstructions("M");
        assertEquals(1, rover.getY());
    }

    @Test
    void roverMoveDoesNotChangeXWhenFacingNorth(){
        Rover rover = new Rover(0,0, Directions.N, new Plateau(1, 1));
        rover.followInstructions("M");
        assertEquals(0, rover.getX());
    }

    @Test
    void roverDoesNotMoveWhenFacingNorthAndAtPlateausUpperYBorder(){
        Rover rover = new Rover(0,0, Directions.N, new Plateau(0,0));
        rover.followInstructions("M");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    void roverMoveOneNegativeXWhenFacingWest(){
        Rover rover = new Rover(1,0, Directions.W, new Plateau(1, 1));
        rover.followInstructions("M");
        assertEquals(0, rover.getX());
    }

    @Test
    void roverMoveDoesNotChangeYWhenFacingWest(){
        Rover rover = new Rover(0,0, Directions.W, new Plateau(1, 1));
        rover.followInstructions("M");
        assertEquals(0, rover.getY());
    }

    @Test
    void roverDoesNotMoveWhenFacingWestAndAtPlateausLowerXBorder(){
        Rover rover = new Rover(0,0, Directions.W, new Plateau(0,0));
        rover.followInstructions("M");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    void roverMoveOneNegativeYWhenFacingSouth(){
        Rover rover = new Rover(1,1, Directions.S, new Plateau(1, 1));
        rover.followInstructions("M");
        assertEquals(0, rover.getY());
    }

    @Test
    void roverMoveDoesNotChangeXWhenFacingSouth(){
        Rover rover = new Rover(1,0, Directions.S, new Plateau(1, 1));
        rover.followInstructions("M");
        assertEquals(1, rover.getX());
    }

    @Test
    void roverDoesNotMoveWhenFacingSouthAndAtPlateausLowerYBorder(){
        Rover rover = new Rover(0,0, Directions.S, new Plateau(0,0));
        rover.followInstructions("M");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    void roverTurnRightFacesEastWhenStartingOffAsNorth(){
        Rover rover = new Rover();
        rover.setHeading(Directions.N);
        rover.followInstructions("R");
        assertEquals(Directions.E, rover.getHeading());
    }

    @Test
    void roverTurnRightFacesSouthWhenStartingOffAsEast(){
        Rover rover = new Rover();
        rover.setHeading(Directions.E);
        rover.followInstructions("R");
        assertEquals(Directions.S, rover.getHeading());
    }

    @Test
    void roverTurnRightFacesWestWhenStartingOffAsSouth(){
        Rover rover = new Rover();
        rover.setHeading(Directions.S);
        rover.followInstructions("R");
        assertEquals(Directions.W, rover.getHeading());
    }

    @Test
    void roverTurnRightFacesNorthWhenStartingOffAsWest(){
        Rover rover = new Rover();
        rover.setHeading(Directions.W);
        rover.followInstructions("R");
        assertEquals(Directions.N, rover.getHeading());
    }

    @Test
    void roverTurnLeftFacesWestWhenStartingOffAsNorth(){
        Rover rover = new Rover();
        rover.setHeading(Directions.N);
        rover.followInstructions("L");
        assertEquals(Directions.W, rover.getHeading());
    }

    @Test
    void roverTurnLeftFacesSouthWhenStartingOffAsWest(){
        Rover rover = new Rover();
        rover.setHeading(Directions.W);
        rover.followInstructions("L");
        assertEquals(Directions.S, rover.getHeading());
    }

    @Test
    void roverTurnLeftFacesEastWhenStartingOffAsSouth(){
        Rover rover = new Rover();
        rover.setHeading(Directions.S);
        rover.followInstructions("L");
        assertEquals(Directions.E, rover.getHeading());
    }

    @Test
    void roverTurnLeftFacesNorthWhenStartingOffAsEast(){
        Rover rover = new Rover();
        rover.setHeading(Directions.E);
        rover.followInstructions("L");
        assertEquals(Directions.N, rover.getHeading());
    }
}