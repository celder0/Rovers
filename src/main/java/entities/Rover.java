package entities;

import enums.Directions;

public class Rover {
    private int x;
    private int y;
    private Directions heading;

    public Rover(String roverConfig) {
        String[] roverSplit = roverConfig.split(" ");
        x = Integer.parseInt(roverSplit[0]);
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
