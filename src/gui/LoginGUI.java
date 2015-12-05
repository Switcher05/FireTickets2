package gui;

import dao.UserDAO;
import entity.Users;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Created by Ryan on 10/13/2015.
 */
public class LoginGUI extends Application implements EventHandler<ActionEvent> {
    public static int userID;
    Button button;
    Button loginBtn, cancelBtn;
    Stage window;
    TextField user, pass;
    public static void main(String[] args){
        launch(args);

    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        window.setTitle("LOGIN");
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setHgap(10);
        gp.setVgap(8);

        Label nameLbl = new Label("Username: ");
        GridPane.setConstraints(nameLbl, 0, 0);

        //Name input
        user = new TextField("Ryan");
        GridPane.setConstraints(user, 1, 0);

        //Password label
        Label passLbl = new Label("Password: ");
        GridPane.setConstraints(passLbl, 0, 1);
        //Password field
        pass = new TextField("");
        GridPane.setConstraints(pass, 1, 1);

        button = new Button();
        button.setText("Clear");
        button.setPrefSize(65,65);
        GridPane.setConstraints(button, 1, 2);
        button.setOnAction(e -> System.out.println("test"));

        loginBtn = new Button();
        loginBtn.setText("Login");
        loginBtn.setPrefSize(65,65);
        GridPane.setConstraints(loginBtn, 1, 3);
        loginBtn.setOnAction(this);

        cancelBtn = new Button();
        cancelBtn.setText("Cancel");
        cancelBtn.setPrefSize(65,65);
        GridPane.setConstraints(cancelBtn, 2, 3);
        cancelBtn.setOnAction(this);

        gp.getChildren().addAll(nameLbl, user, pass, passLbl, button, loginBtn, cancelBtn);

        Scene scene = new Scene(gp, 300, 350);
        window.setScene(scene);
        window.show();

    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button){
            //Clear the boxes
            user.setText("");
            pass.setText("");
            System.out.println("Fields cleared");
        } else if (event.getSource() == loginBtn){

            //Check if the login is valid, if so close this screen and open selling screen.
            Users usr = new Users();
            UserDAO usrDAO = new UserDAO();
            usr.setName(user.getText());
            //TODO: Change from plain text to password field
            usr.setPassword(pass.getText());
            if (usrDAO.Login(usr) == true){
                //Close screen and open
                //userID = usr.getUserId();
                SellingMain sm = new SellingMain();
                sm.setVisible(true);
                this.window.close();

            }else{
                System.out.println("Invalid login");
                JOptionPane.showMessageDialog(null, "invalid login");
                pass.setText("");
                user.setText("");
            }
        } else if (event.getSource() == cancelBtn){
            //close the program
            System.exit(0);

        }

    }
}
