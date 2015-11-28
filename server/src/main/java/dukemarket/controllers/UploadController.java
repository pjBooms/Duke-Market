package dukemarket.controllers;

import dukemarket.domain.DukeApplication;
import dukemarket.repositories.ApplicationRepository;
import dukemarket.storage.BundleParser;
import dukemarket.storage.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;

/**
 * This file created by Maxim S. Ivanov
 */
@RestController
public class UploadController {
    @Autowired
    private FileStorage storage;

    @Autowired
    private BundleParser bundleParser;

    @Autowired
    private ApplicationRepository applicationRepository;

    @RequestMapping(value = "/bundle", method = RequestMethod.POST)
    public void handleRequest(@RequestParam("bundle") MultipartFile file) throws IOException, ServletException {
        try (InputStream inputStream = file.getInputStream()) {
            String appName = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.'));
            String applicationPath = storage.register("user", appName, inputStream);
            DukeApplication application = bundleParser.parseBundle(applicationPath);
            applicationRepository.save(application);
        }
    }
}
