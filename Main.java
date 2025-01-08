import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Set up nodes.
        Welcome rootLayout = new Welcome();


        // Set up scene and window
        Scene scene = new Scene(rootLayout, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Welcome");
        stage.show();
    

    /**
     * Clears the text fields.
     */

    
    /**
     * Checks inputs and displays result.
     */
    }
}

