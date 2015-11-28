package dukemarket.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dukemarket.Application;
import dukemarket.models.CustomerModel;
import dukemarket.users.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.restler.Restler;
import org.restler.spring.mvc.SpringMvcSupport;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * This file created by Maxim S. Ivanov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UsersControllerTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    private final MockMvc mockMvc = standaloneSetup(new UsersController())
            .build();

    @Test
    public void testRegister() throws Exception {

        Restler restler = new Restler("http://localhost:8080", new SpringMvcSupport());
//        restler.addEnhancer(new ErrorMapper());
        org.restler.Service service = restler.build();
        Users users = service.produceClient(Users.class);

        users.register(buildFakeCustomer());

//        try {
//            users.register(null);
//        } catch (NotFoundException e) {
//            // handle not found exception
//        }

        mockMvc.perform(post("/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(buildFakeCustomer()))).
                andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {

    }

    private static CustomerModel buildFakeCustomer() {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setKey(UUID.randomUUID().toString());
        customerModel.setDateCreated(new Date());
        customerModel.setEmail("test@customer.com");
        customerModel.setFirstName("First Name");
        customerModel.setLastName("Last Name");
        customerModel.setPhone("+1 111 111 11 11");
        return customerModel;
    }

}