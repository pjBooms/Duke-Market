package dukemarket.controllers;

import dukemarket.models.ApplicationModel;
import dukemarket.models.CustomerModel;
import dukemarket.users.Applications;
import dukemarket.users.Users;
import org.restler.Restler;
import org.restler.spring.mvc.SpringMvcSupport;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * This file created by Maxim S. Ivanov
 */
public class Test {
    public static void main(String[] args) {
        String baseHost = "http://localhost:8080";
        Restler restler = new Restler(baseHost, new SpringMvcSupport());

        String login;
        String password;

//        restler.authorizationStrategy(new FormAuthorizationStrategy(new SpringMvcRequestExecutor(new RestTemplate()), URI.create(baseHost + "/login"), login, password));

//        restler.addEnhancer(new ErrorMapper());
        org.restler.Service service = restler.build();

        Users users = service.produceClient(Users.class);

        Applications applications = service.produceClient(Applications.class);

        CustomerModel model = users.register(buildFakeCustomer());

        List<ApplicationModel> models = applications.list();

    }

    private static CustomerModel buildFakeCustomer() {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setKey(UUID.randomUUID().toString());
        customerModel.setDateCreated(new Date());
        customerModel.setEmail("test@customer.com");
        customerModel.setFirstName("First Name");
        customerModel.setLastName("Last Name");
        customerModel.setPhone("+1 111 111 11 11");
        customerModel.setPassword("12345");
        return customerModel;
    }

}
