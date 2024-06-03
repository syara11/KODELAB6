package program.modul6;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeController {

    @FXML
    private Text welcomeText;

    public void setWelcomeMessage(String message) {
        welcomeText.setText(message);
    }

    @FXML
    protected void handleLogoutAction(ActionEvent event) throws IOException {
        Parent loginPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/program.modul6/login.fxml")));
        Scene loginScene = new Scene(loginPage, 300, 275);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(loginScene);
        appStage.setTitle("Form Login");
        appStage.show();
    }
}