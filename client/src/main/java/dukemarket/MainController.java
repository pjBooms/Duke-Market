package dukemarket;

import dukemarket.models.ApplicationModel;
import dukemarket.users.Applications;
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
import java.util.List;

/**
 */
public class MainController {

    private static final Image ICON_48 = new Image(MainController.class.getResourceAsStream("/icon-48x48.png"));

    @FXML
    private TilePane tiles;

    public void fillContent() throws IOException {

        Applications appsRest = RestProvider.getApplicationsRest();

        List<ApplicationModel> apps = appsRest.list();

        for (ApplicationModel app: apps) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tile.fxml"));
            Node tile = fxmlLoader.load();
            TileController controller = fxmlLoader.getController();
            System.out.println(app.getName());
            controller.fillTile(ICON_48, app.getName());

            tiles.getChildren().add(tile);
        }

    }


}
