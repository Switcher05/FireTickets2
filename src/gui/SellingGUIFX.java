package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Ryan on 11/4/2015.
 */
public class SellingGUIFX extends Application{
    Stage window;

    final HBox hbs[] = new HBox[30];
    final HBox[] firstTen = new HBox[10];
    final HBox[] secondTen = new HBox[10];
    final HBox[] thirdTen = new HBox[10];
    final public int numOfGames = 30;
    final Label[] labels = new Label[numOfGames];
    final ToggleButton[] togbtns = new ToggleButton[numOfGames];
    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 300,500);
        HBox main = new HBox();
        window = primaryStage;
        window.setTitle("Selling Screen");



        for (int i =0; i < numOfGames; i++){
            final Label label = labels[i] = new Label();
            label.setText(i+":");

            final ToggleButton tb = togbtns[i] = new ToggleButton();
            tb.setText("Game name " + i);
            tb.setPrefSize(60, 60);
            tb.setMinHeight(50);

            final HBox hb = hbs[i] = new HBox();
            hb.setSpacing(5);
            hb.setAlignment(Pos.CENTER);
            hb.getChildren().addAll(label, tb);
        }
        System.arraycopy(hbs, 0, firstTen, 0, firstTen.length);
        System.arraycopy(hbs, firstTen.length, secondTen, 0, secondTen.length);
        System.arraycopy(hbs, firstTen.length + secondTen.length, thirdTen, 0, thirdTen.length);

        final VBox column1 = new VBox();
        column1.setSpacing(5);
        column1.getChildren().addAll(firstTen);

        final VBox column2 = new VBox();
        column2.setSpacing(5);
        column2.getChildren().addAll(secondTen);

        final VBox column3 = new VBox();
        column3.setSpacing(5);
        column3.getChildren().addAll(thirdTen);

        main.getChildren().addAll(column1,column2,column3);

        scene.setRoot(main);

        window.setScene(scene);
        window.show();
    }
}
