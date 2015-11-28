package dukemarket.controllers;

import dukemarket.models.CustomerModel;
import dukemarket.users.Users;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class UsersController implements Users {

    @Override
    public CustomerModel register(CustomerModel customer) {
        return null;
    }

    @Override
    public void update(@PathVariable String id, @RequestBody CustomerModel customer) {

    }
}
