/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tickets;

import Common.TicketInterface;
import Server.Server;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Switcher
 */
public class Test {

    //RMI 
    private static int RMIPort = 12345;
    private static String hostname = "localhost";
    private static String registryURL = "rmi://" + hostname + ":" + RMIPort + "/pos";

    public static void main(String[] args) {
        Server.main(args);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            TicketInterface pos = (TicketInterface) Naming.lookup(registryURL);
            System.out.println("Lookup complete");
            String GN = pos.loadButtons(1);
            System.out.println(GN);

        } catch (NotBoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
