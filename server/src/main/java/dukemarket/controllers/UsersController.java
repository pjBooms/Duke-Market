package dukemarket.controllers;

import dukemarket.domain.Customer;
import dukemarket.models.CustomerModel;
import dukemarket.repositories.CustomerRepository;
import dukemarket.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.MessageDigest;
import java.util.Date;

@Controller
public class UsersController implements Users {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerModel register(@RequestBody CustomerModel customerModel) {
        Customer customer = new Customer();
        customer.setFirstName(customerModel.getFirstName());
        customer.setLastName(customerModel.getLastName());
        customer.setEmail(customerModel.getEmail());
        customer.setPhone(customerModel.getPhone());
        customer.setDateCreated(new Date());
        customer.setPassword(encodePassword(customerModel.getPassword()));

        customerRepository.save(customer);

        customerModel.setKey(customer.getKey());

        return customerModel;
    }

    private String encodePassword(String password) {
        if (!StringUtils.isEmpty(password)){
            try {
                byte[] passwordBytes = password.getBytes("UTF-8");
                byte[] bytes = MessageDigest.getInstance("MD5").digest(passwordBytes);
                return new String(bytes, "UTF-8");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("Unexpected password");
        }
    }

    @Override
    public void update(@PathVariable String id, @RequestBody CustomerModel customer) {

    }
}
