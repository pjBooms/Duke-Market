package dukemarket;

import dukemarket.models.ApplicationModel;
import dukemarket.models.CustomerModel;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

/**
 */
public class RestProvider {

    private static BackendClient client;

    static {
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


    public static CustomerModel getCurrentUser() {
        return client.getCurrentUser();
    }

    public static List<ApplicationModel> getMyApplicationsRest() {
        return client.listMyApplications();
    }

    public static void logout() {
        client.logout();
    }
}
