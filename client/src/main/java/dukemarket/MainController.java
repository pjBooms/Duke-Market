package dukemarket;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.IOException;

/**
 */
public class MainController {

    private static final Image ICON_48 = new Image(MainController.class.getResourceAsStream("/icon-48x48.png"));

    @FXML
    private TilePane tiles;

    public void fillContent() throws IOException {
        for (int j = 0; j < 18; j++) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tile.fxml"));
            Node tile = fxmlLoader.load();
            TileController controller = fxmlLoader.getController();
            controller.fillTile(ICON_48, "app " + j);

            tiles.getChildren().add(tile);
        }

    }


}
