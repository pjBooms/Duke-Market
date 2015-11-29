package dukemarket.controllers;

import dukemarket.SecurityUtils;
import dukemarket.converters.CustomerConverter;
import dukemarket.domain.Customer;
import dukemarket.models.CustomerModel;
import dukemarket.repositories.CustomerRepository;
import dukemarket.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.Optional;

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
        customer.setPassword(SecurityUtils.hash(customerModel.getPassword()));

        customerRepository.save(customer);

        customerModel.setKey(customer.getKey());

        return customerModel;
    }

    @Override
    public CustomerModel update(@PathVariable String id, @RequestBody CustomerModel customerModel) {
        String currentUser = SecurityUtils.currentUser();

        Optional<Customer> customerOpt = customerRepository.findByKey(id);
        if (customerOpt.isPresent()){
            Customer customer = customerOpt.get();
            customer.setFirstName(customerModel.getFirstName());
            customer.setLastName(customerModel.getLastName());
            customer.setPhone(customerModel.getPhone());
            customerRepository.save(customer);
            return CustomerConverter.toModel().apply(customer);
        } else {
            throw new RuntimeException("User found!!");
        }
    }
}
