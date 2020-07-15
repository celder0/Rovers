package entities;

import enums.Directions;
import exceptions.InvalidPositionException;

public class Rover {
    private int x;
    private int y;
    private Directions heading;

    public Rover(String roverConfig) throws InvalidPositionException {
        String[] roverSplit = roverConfig.split(" ");
        try {
            x = Integer.parseInt(roverSplit[0]);
        } catch (NumberFormatException e){
            throw new InvalidPositionException("x position must be an integer", e);
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

    public int getX() {
        return x;
    }
}
