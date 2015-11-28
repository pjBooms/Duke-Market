package dukemarket.users;

import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public interface Users {

    UserDto register(UserDto user);

}
