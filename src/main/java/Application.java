import entities.Plateau;
import entities.Rover;
import exceptions.ApplicationLoadException;
import exceptions.InvalidDimensionsException;
import exceptions.InvalidPositionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Application {
    private PrintStream output = System.out;
    private String configPath;
    private Plateau plateau;
    private Rover rover;

    public Application(String configPath) {
        this.configPath = configPath;
    }

    public Application(String configPath, PrintStream output) {
        this(configPath);
        this.output = output;
    }

    public void run() throws ApplicationLoadException {
        File configFile = new File(configPath);
        try(Scanner scanner = new Scanner(configFile)){
            String plateauConfig = scanner.nextLine();
            plateau = new Plateau(plateauConfig);
            while (scanner.hasNextLine()){
                configureRoverAndRun(scanner);
            }
        } catch (FileNotFoundException|InvalidDimensionsException| InvalidPositionException e) {
            throw new ApplicationLoadException(e);
        }
    }

    private void configureRoverAndRun(Scanner scanner) throws InvalidPositionException {
        String roverConfig = scanner.nextLine();
        rover = new Rover(roverConfig, plateau);
        String roverInstructions = scanner.nextLine();
        rover.followInstructions(roverInstructions);
        output.print(String.format("%d %d %s", rover.getX(), rover.getY(), rover.getHeading()));
        if(scanner.hasNextLine()){
            output.print("\n");
        }
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public static void main(String[] args) throws ApplicationLoadException {
        Application application = new Application(args[0]);
        application.run();
    }
}
