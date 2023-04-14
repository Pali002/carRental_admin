import controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.MainTab;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        MainController mainController = new MainController();
        MainTab mainTab = mainController.getMainTab();

        Scene scene = new Scene(mainTab, 1000, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
