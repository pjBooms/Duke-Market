package dukemarket;

import dukemarket.models.ApplicationModel;
import dukemarket.users.Applications;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.layout.TilePane;
import webfx.WebFXController;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 */
public class AccountController extends WebFXController {

    private static final Image ICON_48 = new Image(AccountController.class.getResourceAsStream("/icon-48x48.png"));

    @FXML
    private TilePane tiles;

    @FXML
    private Hyperlink apps;

    @FXML
    private Hyperlink info;

    @FXML
    private Hyperlink upload;

    public void fillContent() throws IOException {

        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
        tiles.getChildren().clear();

        //Applications appsRest = RestProvider.getApplicationsRest();

        List<ApplicationModel> apps = RestProvider.getApplicationsRest();
//                appsRest.list();

        for (ApplicationModel app : apps) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tile.fxml"));
            Node tile = fxmlLoader.load();
            TileController controller = fxmlLoader.getController();
            controller.setContexts(app, navigationContext);
            Image icon = new Image(new URL(app.getIconUrl()).openStream());
            controller.fillTile(icon, app.getName());

            tiles.getChildren().add(tile);
        }

    }


    @Override
    public void onShow() {
        try {
            fillContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void upload() {


        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
        tiles.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/upload.fxml"));
        Node node = null;
        try {
            node = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        UploadController controller = fxmlLoader.getController();
        controller.setContexts(context, navigationContext);
        tiles.getChildren().add(node);

    }

    public void getApps() {
        try {
            fillContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void info() {
    }
}
