package dukemarket.domain;

import javax.persistence.*;
import java.util.*;

/**
 * This file created by Maxim S. Ivanov
 */
@Entity
@Table(name = "customer")
public class Customer {
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
    private ArrayList<DukeApplication> applications = new ArrayList<>();

    public enum Role {
        OWNER,
    }

    @PrePersist
    private void initialize(){
        if (key == null){
            key = UUID.randomUUID().toString();
        }
    }

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<DukeApplication> getApplications() {
        return applications;
    }

    public void setApplications(ArrayList<DukeApplication> applications) {
        this.applications = applications;
    }
}
