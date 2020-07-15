package entities;

import enums.Directions;
import exceptions.InvalidPositionException;

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
    }

    private void loadY(String yString) throws InvalidPositionException {
        try {
            y = Integer.parseInt(yString);
        } catch (NumberFormatException e) {
            throw new InvalidPositionException("y position must be an integer", e);
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
