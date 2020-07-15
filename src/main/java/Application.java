import entities.Plateau;
import entities.Rover;
import exceptions.ApplicationLoadException;
import exceptions.InvalidDimensionsException;
import exceptions.InvalidPositionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {
    private String configPath;
    private Plateau plateau;
    private Rover rover;

    public Application(String configPath) {
        this.configPath = configPath;
    }

    public void load() throws ApplicationLoadException {
        File configFile = new File(configPath);
        try(Scanner scanner = new Scanner(configFile)){
            String plateauConfig = scanner.nextLine();
            plateau = new Plateau(plateauConfig);
            String roverConfig = scanner.nextLine();
            rover = new Rover(roverConfig, plateau);
        } catch (FileNotFoundException|InvalidDimensionsException| InvalidPositionException e) {
            throw new ApplicationLoadException(e);
        }
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public static void main(String[] args) {
    }

    public Rover getRover() {
        return rover;
    }
}
