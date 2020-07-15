import entities.Plateau;
import exceptions.ApplicationLoadException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {
    private String configPath;
    private Plateau plateau;

    public Application(String configPath) {
        this.configPath = configPath;
    }

    public void load() throws ApplicationLoadException {
        File configFile = new File(configPath);
        try(Scanner scanner = new Scanner(configFile)){
            String plateauConfig = scanner.nextLine();
            plateau = new Plateau(plateauConfig);
        } catch (FileNotFoundException e) {
            throw new ApplicationLoadException(e);
        }
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public static void main(String[] args) {
    }
}
