package dukemarket;

import dukemarket.users.Users;
import org.restler.Restler;
import org.restler.spring.mvc.SpringMvcSupport;


public class RestlerUsageExample {

    public static void main(String[] args) {
        Restler restler = new Restler("http://localhost:8080", new SpringMvcSupport());
        org.restler.Service service = restler.build();
        Users users = service.produceClient(Users.class);
    }

}
