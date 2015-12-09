package dukemarket;

import javafx.event.ActionEvent;
import webfx.WebFXController;

/**
 * Created by lipskynikita on 29/11/15.
 */
public class LogoutController extends WebFXController {


    @Override
    public void onShow() {

    }

    public void logout() {
        RestProvider.logout();
        navigationContext.goToWithContext("dukemarket.fxml", null);
    }
}
