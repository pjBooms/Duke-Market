package dukemarket.auth;

import dukemarket.domain.Customer;
import dukemarket.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class StdUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(s);
        Stream<SimpleGrantedAuthority> roles = customer.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.name()));
        return new CustomersDetails(customer.getEmail(), customer.getPassword(), roles.collect(Collectors.toSet()), customer.getKey());
    }
}
