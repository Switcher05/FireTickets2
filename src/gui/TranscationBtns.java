package gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Switcher on 11/6/2015.
 */
public class TranscationBtns extends Application{
    Stage window;
    final Button[] button = new Button[10];
    final HBox hbs[] = new HBox[10];

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene sc = new Scene(root,500,500);
        stage.setScene(sc);
        stage.setTitle("Transaction Buttons");
        final Button btn = new Button("Test");
//        for (int i = 0; i < 10; i++){
//            final Button btn = button[i] = new Button("C"+i);
//            final HBox hb = hbs[i] = new HBox();
//            hb.setSpacing(5);
//            hb.setAlignment(Pos.CENTER);
//            hb.getChildren().addAll(btn);
//        }
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(btn);

        sc.setRoot(root);


        stage.show();
    }
    public static void main(String[] args) {

        launch(args);
    }
}
