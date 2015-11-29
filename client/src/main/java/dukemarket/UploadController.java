package dukemarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import webfx.WebFXController;

/**
 */
public class UploadController extends WebFXController {

    @FXML
    Button upload;

    @Override
    public void onShow() {

    }

    public void upload() {
        System.out.println(new FileChooser().showOpenDialog(upload.getScene().getWindow()));
    }
}
