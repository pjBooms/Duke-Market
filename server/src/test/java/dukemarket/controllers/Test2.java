package dukemarket.controllers;

import dukemarket.BackendClient;
import dukemarket.models.ApplicationModel;
import dukemarket.models.CustomerModel;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This file created by Maxim S. Ivanov
 */
public class Test2 {
    public static void main(String[] args) throws MalformedURLException {
        BackendClient client = new BackendClient("http://localhost:8080");

        List<ApplicationModel> applications = client.listApplications();

        CustomerModel customerModel = client.register(buildFakeCustomer());

        customerModel.setFirstName(customerModel.getFirstName() + " !!!!!!");

        client.login(customerModel.getEmail(), customerModel.getPassword());

        customerModel = client.getCurrentUser();

        client.update(customerModel.getKey(), customerModel);

        client.upload("/Users/ivanenok/prj/github/Java-ReStart/apps/brickbreaker.zip");
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
