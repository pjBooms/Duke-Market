package dukemarket.converters;

import dukemarket.domain.Customer;
import dukemarket.models.CustomerModel;

import java.util.function.Function;

/**
 * This file created by Maxim S. Ivanov
 */
public class CustomerConverter {
    public static Function<? super Customer, CustomerModel> toModel() {
        return customer -> {
            CustomerModel model = new CustomerModel();
            model.setKey(customer.getKey());
            model.setDateCreated(customer.getDateCreated());
            model.setFirstName(customer.getFirstName());
            model.setLastName(customer.getLastName());
            model.setEmail(customer.getEmail());
            model.setPhone(customer.getPhone());
            model.setKey(customer.getKey());
            return model;
        };
    }

//    public static Function<? super CustomerModel, Customer> deModel() {
//        return customerModel -> {
//            CustomerModel model = new CustomerModel();
//            model.setKey(customer.getKey());
//            model.setDateCreated(customer.getDateCreated());
//            model.setFirstName(customer.getFirstName());
//            model.setLastName(customer.getLastName());
//            model.setEmail(customer.getEmail());
//            model.setPhone(customer.getPhone());
//            model.setKey(customer.getKey());
//            return model;
//        }
//    }
}
