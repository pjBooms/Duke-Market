package dukemarket;

import dukemarket.models.ApplicationModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import webfx.WebFXController;

public class TileController extends WebFXController {

    @FXML
    ImageView image;

    @FXML
    Hyperlink appLink;

    @FXML
    Button startButton;

    public void showApp() {
        navigationContext.goToWithContext("appdescription.fxml", context);
    };

    public void fillTile(Image appIcon, String appDesc) {
        image.setImage(appIcon);
        appLink.setText(appDesc);
    }

    @Override
    public void onShow() {

    }

    public void start() {
        ApplicationModel app = (ApplicationModel) context;
        navigationContext.goTo(app.getStartUrl());
    }
}
