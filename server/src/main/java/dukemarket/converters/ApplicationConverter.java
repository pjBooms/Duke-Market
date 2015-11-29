package dukemarket.converters;

import dukemarket.domain.DukeApplication;
import dukemarket.models.ApplicationModel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * This file created by Maxim S. Ivanov
 */
public class ApplicationConverter {
    public static Function<? super DukeApplication, ApplicationModel> toModel() {
        return application -> {
            ApplicationModel model = new ApplicationModel();
            model.setKey(application.getKey());
            model.setDateCreated(application.getDateCreated());
            model.setName(application.getName());
            model.setDescription(application.getDescription());

            model.setIconUrl(buildIconUrl(application));
            model.setScreenshotsUrls(buildScreenshotsUrl(application));
            model.setDescription(application.getDescription());
            model.setCustomer(CustomerConverter.toModel().apply(application.getCustomer()));
            model.setStartUrl("java://localhost:8080/apps/" + application.getKey());
            return model;
        };
    }

    private static List<String> buildScreenshotsUrl(DukeApplication application) {
        ArrayList<String> result = new ArrayList<>();
        for (String image : application.getScreenshotImages()) {
            result.add("http://localhost:8080/" + application.getCustomer().getKey() + "/" + application.getKey() + "/screenshots/" + image);
        }
        return result;
    }

    private static String buildIconUrl(DukeApplication application) {
        return "http://localhost:8080/" + application.getCustomer().getKey() + "/" + application.getKey() + "/icons/icon.png";
    }
}
