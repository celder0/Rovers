package entities;

import exceptions.InvalidDimensionsException;

import java.util.Objects;

public class Plateau {
    private int width;
    private int length;

    public Plateau(String plateauConfig) throws InvalidDimensionsException {
        String[] plateauSplit = plateauConfig.split(" ");
        try {
            width = Integer.parseInt(plateauSplit[0]);
        } catch (NumberFormatException e){
            throw new InvalidDimensionsException("Width must be integer", e);
        }
        try {
            length = Integer.parseInt(plateauSplit[1]);
        } catch (NumberFormatException e){
            throw new InvalidDimensionsException("Length must be integer", e);
        }
    }

    public Plateau() {

    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plateau plateau = (Plateau) o;
        return width == plateau.width &&
                length == plateau.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length);
    }
}
