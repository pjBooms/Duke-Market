package dukemarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import webfx.WebFXController;

/**
 * Created by lipskynikita on 29/11/15.
 */
public class LoginController extends WebFXController {

    @FXML
    TextField email;

    @FXML
    PasswordField password;

    @Override
    public void onShow() {

    }

    public void login() {
        RestProvider.login(email.getText(), password.getText());
        navigationContext.goToWithContext("dukemarket.fxml", RestProvider.getCurrentUser());
    }
}
