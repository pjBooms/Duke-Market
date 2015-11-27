package dukemarket.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> images = new ArrayList<String>();

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "version")
    private String version;

    @Column(name = "root")
    private String root;

    @OneToOne
    private Customer customer;

    @PrePersist
    private void initialize() {
        if (key == null) {
            key = UUID.randomUUID().toString();
        }
    }
}
