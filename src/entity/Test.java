/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import Util.timeThread;

/**
 *
 * @author Switcher
 */
public class Test {
    public static void main(String args[]){
        timeThread T1 = new timeThread( "Thread-1");
      T1.start();
      
      timeThread T2 = new timeThread( "Thread-2");
      T2.start();
    }
}
