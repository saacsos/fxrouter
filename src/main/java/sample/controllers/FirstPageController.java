package sample.controllers;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FirstPageController {

    @FXML private TextField input;

    @FXML
    public void handleGoToSecondPageButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("second");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleGoToThirdPageButton(ActionEvent actionEvent) {
        String data = input.getText();
        try {
            FXRouter.goTo("third", data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
