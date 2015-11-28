package dukemarket.controllers;

import dukemarket.domain.DukeApplication;
import dukemarket.models.ApplicationModel;
import dukemarket.models.CustomerModel;
import dukemarket.repositories.ApplicationRepository;
import dukemarket.users.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This file created by Maxim S. Ivanov
 */
@Component
public class ApplicationsController implements Applications {

    @Autowired
    private ApplicationRepository applicationRepository;

//    @Override
//    public ApplicationModel register(ApplicationModel applicationModel) {
//        DukeApplication application = new DukeApplication();
//        application.setDateCreated(new Date());
//        application.setDateCreated(new Date());
//        return null;
//    }

    @Override
    public void update(@PathVariable String id, @RequestBody ApplicationModel application) {

    }

    @Override
    public List<ApplicationModel> list() {
        List<DukeApplication> applications = applicationRepository.findAll();
        return applications.stream().map(toModel()).collect(Collectors.toList());
//        ArrayList<ApplicationModel> result = new ArrayList<>();
//
//        for (int i = 0; i < 20; i++) {
//            ApplicationModel model = buildFakeAppModel(i);
//            result.add(model);
//        }
//        return result;
    }

    private Function<? super DukeApplication, ApplicationModel> toModel() {
        return dukeApplication -> {
            ApplicationModel model = new ApplicationModel();
            model.setKey(dukeApplication.getKey());
            model.setDateCreated(dukeApplication.getDateCreated());
            model.setName(dukeApplication.getName());
            model.setDescription(dukeApplication.getDescription());

            model.setIconUrl(buildIconUrl(dukeApplication));
            model.setScreenshotsUrls(buildScreenshotsUrl(dukeApplication));
            model.setDescription(dukeApplication.getDescription());
            return model;
        };
    }

    private static List<String> buildScreenshotsUrl(DukeApplication application) {
        ArrayList<String> result = new ArrayList<>();
        for (String image : application.getImages()) {
            result.add("http://localhost:8080/" + application.getCustomer().getKey() + "/" + application.getKey() + "/screenshot/" + image);
        }
        return result;
    }

    private static String buildIconUrl(DukeApplication application) {
        return "http://localhost:8080/" + application.getCustomer().getKey() + "/" + application.getKey() + "/icon/icon.png";
    }

    private ApplicationModel buildFakeAppModel(int i) {
        ApplicationModel model = new ApplicationModel();

        model.setKey("app" + i);
        model.setDateCreated(new Date());
        model.setIconUrl("");
        model.setDescription("tram param " + i);
        model.setName("application name " + i);
        CustomerModel customer = buildFakeCustomer();
        model.setCustomer(customer);
        return model;
    }

    private CustomerModel buildFakeCustomer() {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setKey(UUID.randomUUID().toString());
        customerModel.setDateCreated(new Date());
        customerModel.setEmail("test@customer.com");
        customerModel.setFirstName("First Name");
        customerModel.setLastName("Last Name");
        customerModel.setPhone("+1 111 111 11 11");
        return customerModel;
    }

    @Override
    public ApplicationModel get(String id) {
        return null;
    }

    @Override
    public List<ApplicationModel> listMy() {
        return null;
    }
}
