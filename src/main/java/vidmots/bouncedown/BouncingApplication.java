package vidmots.bouncedown;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BouncingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BouncingApplication.class.getResource("bouncing-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 950, 1000);
        stage.setTitle("RammusPitFall!");
        stage.setScene(scene);
        stage.show();
       BouncingController controller = fxmlLoader.getController();
       controller.orvatakkar();
    }

    public static void main(String[] args) {
        launch();
    }
}
