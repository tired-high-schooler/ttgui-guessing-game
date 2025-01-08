import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Welcome extends VBox{
    public Welcome(){
        setAlignment(Pos.CENTER);
        Label label = new Label("Mode 1, 2, or 3");
        TextField TBox = new TextField();
        Button start = new Button("start");
        Button quit = new Button("quit");
        start.setOnAction(event -> System.out.println("start"));
        quit.setOnAction(event -> System.exit(0));
        
        getChildren().addAll(label, TBox, start, quit);
        
    }
}