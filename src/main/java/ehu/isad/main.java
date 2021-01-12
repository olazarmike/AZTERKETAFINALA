package ehu.isad;
import ehu.isad.controller.ui.MainUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class main extends Application {

    private Stage stage;

    private Scene sceneMain;
    private Parent mainUI;
    private MainUI mainkud;

    @Override
    public void start (Stage primaryStage) throws Exception {
        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("URL-FX");
        stage.setScene(sceneMain);
        stage.show();
    }

    //ESZENA GUZTIAK
    public void hasieraErakutsi(){
        stage.setScene(sceneMain);
        stage.show();

    }

    //PANTAILA KARGATZEKO
    private void pantailakKargatu () throws IOException {

        FXMLLoader loaderHasiera = new FXMLLoader(getClass().getResource("/Main.fxml"));
        mainUI = (Parent) loaderHasiera.load();
        mainkud = loaderHasiera.getController();
        mainkud.setMainApp(this);
        sceneMain = new Scene(mainUI);

    }
    //pantaila aldatzeko botoia ikutzean get-era deituko da eta dagokion ui-ra doa
    public MainUI getMainUI(){
        return this.mainkud;
    }
    public static void main(String[] args) {
        launch(args);
    }

}