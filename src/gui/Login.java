package gui;

import dao.UserDAO;
import entity.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ryan on 10/13/2015.
 */
public class Login {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton loginButton;
    private JButton clearButton;
    private JButton cancelButton;

    public Login() {
        loginButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loginButton){
                    //Check if the login is valid, if so close this screen and open seeling screen.
                    Users usr = new Users();
                    UserDAO usrDAO = new UserDAO();
                    usr.setName(String.valueOf(txtUser));
                    usr.setPassword(String.valueOf(txtPass));
                    if (usrDAO.Login(usr) == true){
                        //Close screen and open
                        SellingMain sm = new SellingMain();
                        sm.setVisible(true);


                    }else{
                        System.out.println("Invlaid login");
                        JOptionPane.showMessageDialog(null, "invalid login");
                    }

                }else if(e.getSource() == cancelButton){
                    //Close the screen
                    System.exit(0);

                }
            }
        });
    }
}
