package dukemarket.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This file created by Maxim S. Ivanov
 */

public class ApplicationModel {

    private String key; // short application name

    private String name; // full application name

    private String description;

    private String iconUrl;

    private String startUrl;

    private List<String> screenshotsUrls = new ArrayList<>();

    private Date dateCreated;

    private String version;

    private CustomerModel customer;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getScreenshotsUrls() {
        return screenshotsUrls;
    }

    public void setScreenshotsUrls(List<String> screenshotsUrls) {
        this.screenshotsUrls = screenshotsUrls;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public String getStartUrl() {
        return startUrl;
    }

    public void setStartUrl(String startUrl) {
        this.startUrl = startUrl;
    }
}
