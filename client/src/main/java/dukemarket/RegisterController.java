package dukemarket;

import dukemarket.models.CustomerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import webfx.WebFXController;

/**
 * Created by lipskynikita on 29/11/15.
 */
public class RegisterController extends WebFXController {

    @FXML
    TextField name;

    @FXML
    TextField email;

    @FXML
    PasswordField password;

    @Override
    public void onShow() {

    }

    public void register() {
        CustomerModel user = RestProvider.register(name.getText(), email.getText(), password.getText());
        RestProvider.login(user.getEmail(), user.getPassword());

        navigationContext.goToWithContext("dukemarket.fxml", user);
    }
}
