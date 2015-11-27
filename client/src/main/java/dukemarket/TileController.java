package dukemarket;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TileController {

    @FXML
    ImageView image;

    @FXML
    Hyperlink appLink;

    @FXML
    Button startButton;

    public void fillTile(Image appIcon, String appDesc) {
        image.setImage(appIcon);
        appLink.setText(appDesc);
    }

}
