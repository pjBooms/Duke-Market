package dukemarket;

import dukemarket.models.ApplicationModel;
import dukemarket.models.CustomerModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.util.List;

/**
 * This file created by Maxim S. Ivanov
 */
public class BackendClient {

    private String host = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    private RestTemplate authenticatedRestTemplate;

    public BackendClient(String host) {
        this.host = host;
    }

    public void login(String username, String password) {
        authenticatedRestTemplate = new BasicAuthRestTemplate(username, password);
    }

    public List<ApplicationModel> listApplications() {
        ResponseEntity<List<ApplicationModel>> entity = restTemplate.exchange(buildUrl("/apps/"), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ApplicationModel>>() {
                });
        return entity.getBody();
    }

    public CustomerModel getCurrentUser() {
        return authenticatedRestTemplate.getForObject(buildUrl("/users/current"), CustomerModel.class);
    }

    public List<ApplicationModel> listMyApplications() {
        ResponseEntity<List<ApplicationModel>> entity = restTemplate.exchange(buildUrl("/apps/my"), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ApplicationModel>>() {
                });
        return entity.getBody();
    }

//    public ApplicationModel getApplication(String user, String app) {
//        ResponseEntity<List<ApplicationModel>> entity = restTemplate.exchange(buildUrl("/apps/my"), HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<ApplicationModel>>() {
//                });
//        return entity.getBody();
//    }


    private String buildUrl(String context) {
        return host + context;
    }

    public CustomerModel register(CustomerModel customerModel) {
        return restTemplate.postForObject(buildUrl("/users/"), customerModel, CustomerModel.class);
    }

    public void update(String key, CustomerModel customerModel) {
        getAuthenticatedTemplated().put(buildUrl("/users/" + key), customerModel, CustomerModel.class);
    }


    public void upload(String filePath) throws MalformedURLException {
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("bundle", new UrlResource("file:" + filePath));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(
                map, headers);
        ResponseEntity<String> result = getAuthenticatedTemplated().exchange(
                buildUrl("/bundle"), HttpMethod.POST, requestEntity,
                String.class);
    }

    private RestTemplate getAuthenticatedTemplated() {
        if (authenticatedRestTemplate != null){
            return authenticatedRestTemplate;
        } else {
            throw new RuntimeException("You are not logged in!");
        }
    }
}