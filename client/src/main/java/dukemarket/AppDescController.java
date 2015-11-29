package dukemarket;

import dukemarket.models.ApplicationModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import webfx.WebFXController;

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
        icon.setImage(ICON_48);
        System.out.println(ICON_48.getHeight());
        for (int i = 0; i < 3; i++) {
            screenshots.getChildren().add(new ImageView(ICON_48));
        }
    }
}
