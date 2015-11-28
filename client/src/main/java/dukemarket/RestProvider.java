package dukemarket;

import dukemarket.http.ErrorMapper;
import dukemarket.users.Applications;
import org.restler.Restler;
import org.restler.Service;
import org.restler.spring.mvc.SpringMvcSupport;

/**
 */
public class RestProvider {

    private static Service service;

    static {
        Restler restler = new Restler("http://localhost:8080", new SpringMvcSupport());
        restler.addEnhancer(new ErrorMapper());
        service = restler.build();
    }

    public static Applications getApplicationsRest() {
        return service.produceClient(Applications.class);
    }
}
