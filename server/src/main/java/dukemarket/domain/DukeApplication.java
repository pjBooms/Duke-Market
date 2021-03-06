package dukemarket.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This file created by Maxim S. Ivanov
 */
@Entity
@Table(name = "duke_application")
public class DukeApplication {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "key")
    private String key;

    @Column(name = "app_name")
    private String name;

    @Column(name = "description")
    @Lob
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> screenshotImages = new ArrayList<>();

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "version")
    private String version;

    @OneToOne
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<String> getScreenshotImages() {
        return screenshotImages;
    }

    public void setScreenshotImages(List<String> screenshotImages) {
        this.screenshotImages = screenshotImages;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
