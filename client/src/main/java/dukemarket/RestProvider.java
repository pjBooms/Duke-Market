package dukemarket;

import dukemarket.http.ErrorMapper;
import dukemarket.models.ApplicationModel;
import dukemarket.models.CustomerModel;
import org.restler.Restler;
import org.restler.Service;
import org.restler.spring.mvc.SpringMvcSupport;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 */
public class RestProvider {

    private static Service service;
    private static BackendClient client;

    static {
        Restler restler = new Restler("http://localhost:8088", new SpringMvcSupport());
        restler.addEnhancer(new ErrorMapper());
        service = restler.build();
        client = new BackendClient("http://localhost:8088");
    }

    public static List<ApplicationModel> getApplicationsRest() {
        return client.listApplications();
    }

    public static void uploadBundle(File file) {
        try {
            client.upload(file.getAbsolutePath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static CustomerModel register(String name, String email, String password) {
        CustomerModel user = new CustomerModel();
        user.setFirstName(name);
        user.setEmail(email);
        user.setPassword(password);
        client.register(user);
        return user;
    }

    public static void login(String email, String password) {
        client.login(email, password);
    }


}
