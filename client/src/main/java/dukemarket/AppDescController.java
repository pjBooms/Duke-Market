package dukemarket;

import dukemarket.models.ApplicationModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import webfx.WebFXController;

import java.io.IOException;
import java.net.URL;

/**
 */
public class AppDescController extends WebFXController {

    private static final Image ICON_48 = new Image(MainController.class.getResourceAsStream("/icon-48x48.png"));

    @FXML
    Label appName;

    @FXML
    TextArea description;

    @FXML
    ImageView icon;

    @FXML
    HBox screenshots;

    @Override
    public void onShow() {
        ApplicationModel app = (ApplicationModel) context;
        appName.setText(app.getName());
        description.setText(app.getDescription());
        try {
            Image iconIm = new Image(new URL(app.getIconUrl()).openStream());
            icon.setImage(iconIm);
            for (String screenshot : app.getScreenshotsUrls()) {
                screenshots.getChildren().add(new ImageView(new Image(new URL(screenshot).openStream())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        ApplicationModel app = (ApplicationModel) context;
        navigationContext.goTo(app.getStartUrl());
    }
}
