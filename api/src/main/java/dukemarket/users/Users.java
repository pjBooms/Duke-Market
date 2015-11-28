package dukemarket.users;

import dukemarket.models.CustomerModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public interface Users {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    CustomerModel register(@RequestBody CustomerModel customer);

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    void update(@PathVariable String id, @RequestBody CustomerModel customer);

}
