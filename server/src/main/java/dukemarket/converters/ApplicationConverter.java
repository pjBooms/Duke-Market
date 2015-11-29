package dukemarket.converters;

import dukemarket.domain.DukeApplication;
import dukemarket.models.ApplicationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * This file created by Maxim S. Ivanov
 */
@Component
public class ApplicationConverter {

    @Value("${server.port}")
    private String appPort;

    @Autowired
    private CustomerConverter customerConverter;

    public Function<? super DukeApplication, ApplicationModel> toModel() {
        return application -> {
            ApplicationModel model = new ApplicationModel();
            model.setKey(application.getKey());
            model.setDateCreated(application.getDateCreated());
            model.setName(application.getName());
            model.setDescription(application.getDescription());

            model.setIconUrl(buildIconUrl(application));
            model.setScreenshotsUrls(buildScreenshotsUrl(application));
            model.setDescription(application.getDescription());
            model.setCustomer(customerConverter.toModel().apply(application.getCustomer()));
            model.setStartUrl("java://" + getHostName() + ":8080/apps/" + application.getKey());
            return model;
        };
    }

    private String getHostName() {
        String hostName;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return hostName;
    }

    private static List<String> buildScreenshotsUrl(DukeApplication application) {
        ArrayList<String> result = new ArrayList<>();
        for (String image : application.getScreenshotImages()) {
            result.add("http://localhost:8088/" + application.getCustomer().getKey() + "/" + application.getKey() + "/screenshots/" + image);
        }
        return result;
    }

    private static String buildIconUrl(DukeApplication application) {
        return "http://localhost:8088/" + application.getCustomer().getKey() + "/" + application.getKey() + "/icons/icon.png";
    }
}
