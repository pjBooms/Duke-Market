package dukemarket.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * This file created by Maxim S. Ivanov
 */
public class CustomersDetails extends User {
    private String key;

    public CustomersDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String key) {
        super(username, password, authorities);
        this.key = key;
    }

    public CustomersDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String key) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.key = key;
    }

    public String getKey(){
        return key;
    }
}
