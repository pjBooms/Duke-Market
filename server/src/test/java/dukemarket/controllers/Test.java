package dukemarket.controllers;

import dukemarket.models.CustomerModel;
import dukemarket.users.Applications;
import dukemarket.users.Users;
import org.restler.Restler;
import org.restler.http.security.authorization.FormAuthorizationStrategy;
import org.restler.spring.mvc.SpringMvcRequestExecutor;
import org.restler.spring.mvc.SpringMvcSupport;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This file created by Maxim S. Ivanov
 */
public class Test {
    public static void main(String[] args) {
        String baseHost = "http://localhost:8080";
        Restler restler = new Restler(baseHost, new SpringMvcSupport());

        String login = "12345";
        String password = "password";

//        restler.addEnhancer(new ErrorMapper());
        org.restler.Service service = restler.build();

        Users users = service.produceClient(Users.class);

        Applications applications = service.produceClient(Applications.class);

        CustomerModel model = users.register(buildFakeCustomer());

        model.setFirstName(model.getFirstName() + " !!!!");

        restler.authorizationStrategy(new FormAuthorizationStrategy(
                new SpringMvcRequestExecutor(new RestTemplate()),
                URI.create(baseHost + "/login"),
                model.getEmail(),
                "username",
                model.getPassword(),
                "password"));
        restler.cookieBasedAuthentication();

        org.restler.Service authenticatedService = restler.build();

        authenticatedService.produceClient(Users.class).update(model.getKey(), buildFakeCustomer());

//        List<ApplicationModel> models = applications.list();

    }

    private static CustomerModel buildFakeCustomer() {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setKey(UUID.randomUUID().toString());
        customerModel.setDateCreated(new Date());
        customerModel.setEmail(ThreadLocalRandom.current().nextDouble() + "test@customer.com");
        customerModel.setFirstName("First Name");
        customerModel.setLastName("Last Name");
        customerModel.setPhone("+1 111 111 11 11");
        customerModel.setPassword("12345");
        return customerModel;
    }

}
