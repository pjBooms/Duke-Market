package dukemarket;

import dukemarket.http.ErrorMapper;
import dukemarket.users.Applications;
import org.restler.Restler;
import org.restler.Service;
import org.restler.spring.mvc.SpringMvcSupport;

import java.io.File;
import java.net.URL;

/**
 */
public class RestProvider {

    private static Service service;

    static {
        Restler restler = new Restler("http://localhost:8088", new SpringMvcSupport());
        restler.addEnhancer(new ErrorMapper());
        service = restler.build();
    }

    public static Applications getApplicationsRest() {
        return service.produceClient(Applications.class);
    }

    public static void uploadBundle(URL url, File file) {


    }
}
