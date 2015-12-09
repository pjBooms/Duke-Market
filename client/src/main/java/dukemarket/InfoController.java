package dukemarket;

import dukemarket.models.CustomerModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import webfx.WebFXController;

import javax.xml.soap.Text;

/**
 * Created by lipskynikita on 29/11/15.
 */
public class InfoController extends WebFXController {

    @FXML
    TextField name;

    @FXML
    TextField email;

    @Override
    public void onShow() {
        CustomerModel user = (CustomerModel) context;
        name.setText(user.getFirstName());
        email.setText(user.getEmail());
    }
}
