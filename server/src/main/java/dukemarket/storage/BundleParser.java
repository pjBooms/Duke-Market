package dukemarket.storage;

import dukemarket.domain.DukeApplication;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Component
public class BundleParser {

    public DukeApplication parseBundle(String path) throws IOException {
        return parseBundle(new File(path));
    }

    public DukeApplication parseBundle(File bundleDir) throws IOException {
       DukeApplication app = new DukeApplication();
        app.setDescription(parseDescription(bundleDir));
        app.setName(parseName(bundleDir));
        app.setImages(parseImages(bundleDir));
        return app;
    }

    private List<String> parseImages(File bundleDir) {
        File screenShotsDir = new File(bundleDir, "screenshots");
        File[] screenshots = screenShotsDir.listFiles();
        if (screenshots == null) {
            throw new InvalidBundleException("Screenshots directory is not exists");
        }
        return Arrays.stream(screenshots).map(File::getName).collect(Collectors.toList());
    }

    private String parseName(File bundleDir) {
        File propsFile = new File(bundleDir, "app.properties");
        if (!propsFile.exists()) {
            throw new InvalidBundleException("Application properties file is not exists");
        }
        Properties props = new Properties();
        try (InputStream is = new FileInputStream(propsFile)) {
            props.load(is);
        } catch (IOException e) {
            throw new InvalidBundleException("Could not read application properties", e);
        }
        String name = props.getProperty("name");
        if (name == null) {
            throw new InvalidBundleException("Application properties file do not contain name");
        }
        return name;
    }

    private String parseDescription(File bundleDir) throws IOException {
        File descFile = new File(bundleDir, "description.txt");
        if (!descFile.exists()) {
            throw new InvalidBundleException("Description file is not exists");
        }
        return FileCopyUtils.copyToString(new FileReader(descFile));
    }

}
