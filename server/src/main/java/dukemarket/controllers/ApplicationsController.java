package dukemarket.controllers;

import dukemarket.SecurityUtils;
import dukemarket.converters.ApplicationConverter;
import dukemarket.domain.Customer;
import dukemarket.domain.DukeApplication;
import dukemarket.models.ApplicationModel;
import dukemarket.models.CustomerModel;
import dukemarket.repositories.ApplicationRepository;
import dukemarket.repositories.CustomerRepository;
import dukemarket.users.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * This file created by Maxim S. Ivanov
 */
@Component
public class ApplicationsController implements Applications {

    @Autowired
    private ApplicationConverter converter;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void update(@PathVariable String id, @RequestBody ApplicationModel application) {
        // do nothing
    }

    @Override
    public List<ApplicationModel> list() {

//        for (int i = 0; i < 5; i++) {
//            applicationRepository.save(buildFakeApp(i));
//        }
//
        List<DukeApplication> applications = applicationRepository.findAll();
        return applications.stream().map(converter.toModel()).collect(Collectors.toList());
    }

    private ApplicationModel buildFakeAppModel(int i) {
        ApplicationModel model = new ApplicationModel();

        model.setKey("app" + i);
        model.setDateCreated(new Date());
        model.setIconUrl("");
        model.setDescription("tram param " + i);
        model.setName("application name " + i);
        CustomerModel customer = buildFakeCustomerModel();
        model.setCustomer(customer);
        return model;
    }

    private DukeApplication buildFakeApp(int i) {
        DukeApplication model = new DukeApplication();

        model.setKey("app" + i);
        model.setDateCreated(new Date());
//        model.setIconUrl("");
        model.setDescription("tram param " + i);
        model.setName("application name " + i);
        model.getScreenshotImages().add("screenshot.jpg");

        Customer customer = buildFakeCustomer();
        customerRepository.save(customer);
        model.setCustomer(customer);

        return model;
    }

    private CustomerModel buildFakeCustomerModel() {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setKey(UUID.randomUUID().toString());
        customerModel.setDateCreated(new Date());
        customerModel.setEmail("test@customer.com");
        customerModel.setFirstName("First Name");
        customerModel.setLastName("Last Name");
        customerModel.setPhone("+1 111 111 11 11");
        return customerModel;
    }

    private Customer buildFakeCustomer() {
        Customer customerModel = new Customer();
        customerModel.setKey(UUID.randomUUID().toString());
        customerModel.setDateCreated(new Date());
        customerModel.setEmail("test@customer.com");
        customerModel.setFirstName("First Name");
        customerModel.setLastName("Last Name");
        customerModel.setPhone("+1 111 111 11 11");
        return customerModel;
    }

    @Override
    public ApplicationModel get(String user, String id) {
        return converter.toModel().apply(applicationRepository.findByKey(id));
    }

    @Override
    public List<ApplicationModel> listMy() {
        String currentUser = SecurityUtils.currentUser();
        return applicationRepository.findByCustomer(currentUser).stream().map(converter.toModel()).collect(Collectors.toList());

    }
}