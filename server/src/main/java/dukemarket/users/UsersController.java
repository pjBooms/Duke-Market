package dukemarket.users;

import dukemarket.models.CustomerModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class UsersController implements Users {

    @Override
    public CustomerModel register(CustomerModel customer) {
        return null;
    }

    @Override
    public void update(@PathVariable String id, @RequestBody CustomerModel customer) {

    }
}
