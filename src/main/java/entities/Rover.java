package entities;

import enums.Directions;
import enums.Instruction;
import exceptions.InvalidPositionException;

import java.util.Objects;

public class Rover {
    private Plateau plateau;
    private int x;
    private int y;
    private Directions heading;

    public Rover(String roverConfig, Plateau plateau) throws InvalidPositionException {
        this.plateau = plateau;
        String[] roverSplit = roverConfig.split(" ");
        loadX(roverSplit[0]);
        loadY(roverSplit[1]);
        loadHeading(roverSplit[2]);
    }

    public Rover(int x, int y, Directions heading, Plateau plateau) {
        this.x = x;
        this.y = y;
        this.heading = heading;
        this.plateau = plateau;
    }

    private void loadHeading(String headingString) throws InvalidPositionException {
        try {
            heading = Directions.valueOf(headingString);
        } catch (IllegalArgumentException e) {
            throw new InvalidPositionException("Heading must be N,S,E,W", e);
        }
    }

    private void loadY(String yString) throws InvalidPositionException {
        try {
            y = Integer.parseInt(yString);
        } catch (NumberFormatException e) {
            throw new InvalidPositionException("y position must be an integer", e);
        }
        if(y > plateau.getLength()){
            throw new InvalidPositionException("y cannot be outside of plateau");
        }
    }

    private void loadX(String xString) throws InvalidPositionException {
        try {
            x = Integer.parseInt(xString);
        } catch (NumberFormatException e){
            throw new InvalidPositionException("x position must be an integer", e);
        }
        if(x > plateau.getWidth()){
            throw new InvalidPositionException("x cannot be outside of plateau");
        }
    }

    public Rover() {

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeading(Directions heading) {
        this.heading = heading;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Directions getHeading() {
        return heading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return x == rover.x &&
                y == rover.y &&
                Objects.equals(plateau, rover.plateau) &&
                heading == rover.heading;
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateau, x, y, heading);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "plateau=" + plateau +
                ", x=" + x +
                ", y=" + y +
                ", heading=" + heading +
                '}';
    }

    public void move() {
        switch (heading) {
            case N:
                moveNorth();
                break;
            case E:
                moveEast();
                break;
            case W:
                moveWest();
                break;
            case S:
                moveSouth();
        }
    }

    private void moveSouth() {
        if(y > 0){
            y--;
        }
    }

    private void moveWest() {
        if(x > 0) {
            x--;
        }
    }

    private void moveNorth() {
        if(y < plateau.getLength()){
            y++;
        }
    }

    private void moveEast() {
        if(x < plateau.getWidth()) {
            x++;
        }
    }

    private void turnRight() {
        switch (heading) {
            case N:
                heading = Directions.E;
                break;
            case E:
                heading = Directions.S;
                break;
            case S:
                heading = Directions.W;
                break;
            case W:
                heading = Directions.N;
                break;
        }
    }

    private void turnLeft() {
        switch (heading) {
            case N:
                heading = Directions.W;
                break;
            case W:
                heading = Directions.S;
                break;
            case S:
                heading = Directions.E;
                break;
            case E:
                heading = Directions.N;
                break;
        }
    }

    public void followInstructions(String instructions) {
        Instruction instruction = Instruction.valueOf(instructions);
        switch (instruction) {
            case L:
                turnLeft();
                break;
            case R:
                turnRight();
                break;
            case M:
                move();
                break;
        }
    }
}
