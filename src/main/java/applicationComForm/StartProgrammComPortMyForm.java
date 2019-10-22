package applicationComForm;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class StartProgrammComPortMyForm extends Application {
    static ControllerComMyPort controllerComMyPort ;



    public static void main(String[] args) {
        Application.launch(StartProgrammComPortMyForm.class,args);
    }


    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage primaryStage) {

        try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("/formCom.fxml"));
            Parent root=loader.load();
             controllerComMyPort=(ControllerComMyPort) loader.getController();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
           primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

    }

}
