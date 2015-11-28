package dukemarket.users;

import dukemarket.models.ApplicationModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This file created by Maxim S. Ivanov
 */

@RestController
@RequestMapping("/apps")
public interface Applications {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    ApplicationModel register(ApplicationModel application);

    @RequestMapping(value = "/my/{id}", method = RequestMethod.PUT)
    void update(@PathVariable String id, @RequestBody ApplicationModel application);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<ApplicationModel> list();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ApplicationModel get();

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    List<ApplicationModel> listMy();
}
