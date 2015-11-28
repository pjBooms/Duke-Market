package dukemarket.users;

import dukemarket.storage.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This file created by Maxim S. Ivanov
 */
@Controller
@RequestMapping("/bundle")
public class UploadController {
    @Autowired
    private FileStorage storage;

    @RequestMapping("/")
    public void handleRequest(){

    }
}
