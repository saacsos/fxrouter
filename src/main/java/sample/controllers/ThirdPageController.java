package sample.controllers;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class ThirdPageController {
    @FXML private Label dataLabel;

    private String input;

    @FXML
    public void initialize() {
        input = (String) FXRouter.getData();
        dataLabel.setText(input);
    }

    @FXML
    public void handleGoToFirstPageButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("first");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
