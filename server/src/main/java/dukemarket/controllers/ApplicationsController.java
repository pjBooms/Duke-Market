package dukemarket.controllers;

import dukemarket.models.ApplicationModel;
import dukemarket.models.CustomerModel;
import dukemarket.users.Applications;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * This file created by Maxim S. Ivanov
 */

public class ApplicationsController implements Applications {
    @Override
    public ApplicationModel register(ApplicationModel customer) {
        return null;
    }

    @Override
    public void update(@PathVariable String id, @RequestBody ApplicationModel customer) {

    }

    @Override
    public List<ApplicationModel> list() {
        ArrayList<ApplicationModel> result = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            ApplicationModel model = buildFakeAppModel(i);
            result.add(model);
        }
        return result;
    }

    private ApplicationModel buildFakeAppModel(int i) {
        ApplicationModel model = new ApplicationModel();

        model.setKey("app" + i);
        model.setDateCreated(new Date());
        model.setIconUrl("");
        model.setDescription("tram param " + i);
        model.setName("application name " + i);
        CustomerModel customer = buildFakeCustomer();
        model.setCustomer(customer);
        return model;
    }

    private CustomerModel buildFakeCustomer() {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setKey(UUID.randomUUID().toString());
        customerModel.setDateCreated(new Date());
        customerModel.setEmail("test@customer.com");
        customerModel.setFirstName("First Name");
        customerModel.setLastName("Last Name");
        customerModel.setPhone("+1 111 111 11 11");
        return customerModel;
    }

    @Override
    public ApplicationModel get() {
        return null;
    }

    @Override
    public List<ApplicationModel> listMy() {
        return null;
    }
}
