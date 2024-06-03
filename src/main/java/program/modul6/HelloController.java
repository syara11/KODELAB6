package program.modul6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloController {

    @FXML
    private Text actiontarget;
    @FXML
    private TextField userTextField;
    @FXML
    private PasswordField pwBox;

    private final Map<String, String> userCredentials = new HashMap<>();

    public HelloController() {
        userCredentials.put("user", "pass");
        userCredentials.put("admin", "admin123");
        userCredentials.put("anno", "password");
    }

    @FXML
    protected void handleButtonAction(ActionEvent event) throws IOException {
        String username = userTextField.getText();
        String password = pwBox.getText();

        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            actiontarget.setFill(Color.GREEN);
            actiontarget.setText("Login successful!");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/home.fxml"));
            Parent homePage = loader.load();

            HomeController homeController = loader.getController();
            homeController.setWelcomeMessage("Hallo " + username);

            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(new Scene(homePage, 300, 275));
            appStage.setTitle("Form 2");
            appStage.show();
        } else {
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Password atau Username Salah");
        }
    }
}