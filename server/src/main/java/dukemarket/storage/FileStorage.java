package dukemarket.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * This file created by Maxim S. Ivanov
 */
@Component
public class FileStorage {

    @Value("${bundles.dir}")
    private String root;

    public void register(String userId, String appName, InputStream stream) throws IOException {
        File bundleDir = new File(root, userId + File.separator + appName);
        if (!bundleDir.mkdirs()) {
            throw new RuntimeException("Could not create bundle dir at " + bundleDir.getAbsolutePath());
        }

        ZipInputStream zis = new ZipInputStream(stream);
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            File f = new File(bundleDir.getAbsoluteFile() + File.separator + entry.getName());
            if (entry.isDirectory()) {
                if (!f.mkdirs()) {
                    throw new RuntimeException("Could not create bundle dir at " + bundleDir.getAbsolutePath());
                }
            } else {
                byte[] buffer = new byte[1024];
                FileOutputStream fOutput = new FileOutputStream(f);
                int count = 0;
                while ((count = zis.read(buffer)) > 0) {
                    fOutput.write(buffer, 0, count);
                }
                fOutput.close();

            }
            zis.closeEntry();
        }
    }
}
