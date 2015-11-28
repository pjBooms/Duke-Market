package dukemarket.storage;

import dukemarket.domain.DukeApplication;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class BundleParserITest {

    @Test
    public void testHappyPath() throws Exception {
        File bundleDir = new File("/home/azhidkov/Activities/HackDay40/Java-ReStart/apps/BrickBreaker");
        BundleParser bundleParser = new BundleParser();
        DukeApplication dukeApplication = bundleParser.parseBundle(bundleDir);
        assertTrue("Description should be readed", dukeApplication.getDescription().length() > 0);
        assertEquals("Screenshots should be parsed", 1, dukeApplication.getImages().size());
        assertEquals("Name should be readed", "Brick Breaker", dukeApplication.getName());
    }
}