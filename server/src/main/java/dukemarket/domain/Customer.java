package dukemarket.domain;

import javax.persistence.*;
import java.util.*;

/**
 * This file created by Maxim S. Ivanov
 */
@Entity
@Table(name = "customer")
public class Customer {

    public enum Role {
        OWNER,

    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "key")
    private String key;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles = EnumSet.of(Role.OWNER);

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password; // md5

    @OneToMany
    private Set<DukeApplication> applications = new HashSet<DukeApplication>();

    @PrePersist
    private void initialize(){
        if (key == null){
            key = UUID.randomUUID().toString();
        }
    }
}
