package dukemarket.controllers;

import dukemarket.SecurityUtils;
import dukemarket.domain.Customer;
import dukemarket.domain.DukeApplication;
import dukemarket.repositories.ApplicationRepository;
import dukemarket.repositories.CustomerRepository;
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
import java.util.Date;
import java.util.Optional;

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

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/bundle", method = RequestMethod.POST)
    public void handleRequest(@RequestParam("bundle") MultipartFile file) throws IOException, ServletException {
        String currentUser = SecurityUtils.currentUser();
        try (InputStream inputStream = file.getInputStream()) {
            String appName = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.'));
            String applicationPath = storage.register(currentUser, appName, inputStream);
            DukeApplication application = bundleParser.parseBundle(applicationPath);
            application.setKey(appName);
            application.setDateCreated(new Date());
            Optional<Customer> customer = customerRepository.findByKey(currentUser);
            application.setCustomer(customer.get());
            applicationRepository.save(application);
        }
    }
}
