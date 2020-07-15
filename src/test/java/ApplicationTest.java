import entities.Plateau;
import entities.Rover;
import enums.Directions;
import exceptions.ApplicationLoadException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {
    @Test
    void applicationLoadsPlateauFromConfigFile() throws Exception {
        URL configResource = this.getClass().getResource("testConfig.txt");
        File configFile = Paths.get(configResource.toURI()).toFile();
        Application application = new Application(configFile.getAbsolutePath());
        application.load();
        Plateau plateau = application.getPlateau();
        Plateau expectedPlateau = new Plateau();
        expectedPlateau.setWidth(5);
        expectedPlateau.setLength(4);
        assertEquals(expectedPlateau, plateau);
    }

    @Test
    void applicationLoadsRoverAndExecutesInstructionsFromConfigFileAndOutputsToSpecifiedOutput() throws Exception {
        URL configResource = this.getClass().getResource("testConfig.txt");
        File configFile = Paths.get(configResource.toURI()).toFile();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Application application = new Application(configFile.getAbsolutePath(), new PrintStream(outputStream));
        application.load();
        Rover rover = application.getRover();
        Rover expectedRover = new Rover();
        Plateau expectedPlateau = new Plateau();
        expectedPlateau.setWidth(5);
        expectedPlateau.setLength(4);
        expectedRover.setX(1);
        expectedRover.setY(3);
        expectedRover.setHeading(Directions.N);
        expectedRover.setPlateau(expectedPlateau);
        assertEquals(expectedRover, rover);
        assertEquals("1 3 N", outputStream.toString());
    }
}