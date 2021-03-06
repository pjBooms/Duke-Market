package dukemarket.controllers;

import dukemarket.storage.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * This file created by Maxim S. Ivanov
 */

@Controller
public class ImagesController {

    @Value("${bundles.dir}")
    private String root;

    @Autowired
    private FileStorage storage;

    @RequestMapping(value = "/{user}/{app}/icons/icon.png", method = RequestMethod.GET)
    public @ResponseBody FileSystemResource getIcon(@PathVariable String user, @PathVariable String app){
        File file = new File(storage.getBundleFile(user, app), File.separator + "icon.png");
        return new FileSystemResource(file);
    }

    @RequestMapping(value = "/{user}/{app}/screenshots/{file}", method = RequestMethod.GET)
    public
    @ResponseBody
    FileSystemResource getScreenshot(@PathVariable String user, @PathVariable String app, @PathVariable String file) {
        File image = new File(storage.getBundleFile(user, app), File.separator + "screenshots" + File.separator + file + ".jpg");
        return new FileSystemResource(image);
    }

    @RequestMapping(value = "*/{user}/{app}/*", method = RequestMethod.GET)
    public
    @ResponseBody
    FileSystemResource getFile(@PathVariable String user, @PathVariable String app, HttpServletRequest request) {
        String path = request.getRequestURI();
        int lastdelim = path.lastIndexOf(app + "/");
        String tail = path.substring(lastdelim + (app + "/").length(), path.length());
        File resource = new File(new File(root, user + File.separator + app), tail);
        return new FileSystemResource(resource);
    }

}
