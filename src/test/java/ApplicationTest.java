import entities.Plateau;
import exceptions.ApplicationLoadException;
import org.junit.jupiter.api.Test;

import java.io.File;
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
}