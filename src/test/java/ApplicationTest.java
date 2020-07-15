import entities.Plateau;
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
        application.run();
        Plateau plateau = application.getPlateau();
        Plateau expectedPlateau = new Plateau();
        expectedPlateau.setWidth(5);
        expectedPlateau.setLength(4);
        assertEquals(expectedPlateau, plateau);
    }

    @Test
    void applicationLoadsRoversAndExecutesInstructionsFromConfigFileAndOutputsToSpecifiedOutput() throws Exception {
        URL configResource = this.getClass().getResource("testConfig.txt");
        File configFile = Paths.get(configResource.toURI()).toFile();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Application application = new Application(configFile.getAbsolutePath(), new PrintStream(outputStream));
        application.run();
        assertEquals("1 3 N\n5 1 E", outputStream.toString());
    }
}