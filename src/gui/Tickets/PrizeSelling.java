/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tickets;
import static Tickets.Selling.total1;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 *
 * @author Switcher
 */


public class PrizeSelling extends javax.swing.JFrame {
Connection con;
Statement stmt;
ResultSet rs;
int curRow = 0;
PreparedStatement pstmt;
int[] prizeRem;
int[] prizeAmt;
int[] prizeAll;
int prizetotal;
int bin2;
int lsrem = 0;
int lsamt = 0;
String gameName;
String serial;
String soundName = "chaching.wav"; 


    /**
     * Creates new form PrizeSelling
     */
    public PrizeSelling() {
        initComponents();
    }
    public void DBconnect(int bin){
        try{
            con = DbConnect.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM tickets WHERE bin = ? and inplay = 1");
            pstmt.setInt(1,bin);
            rs = pstmt.executeQuery();
            rs.next();
            prizeRem = new int[15];
            serial = rs.getString("serial");
            bin = bin2;
            prizeRem[0] = rs.getInt("prize_rem1");
            prizeRem[1] = rs.getInt("prize_rem2");
            prizeRem[2] = rs.getInt("prize_rem3");
            prizeRem[3] = rs.getInt("prize_rem4");
            prizeRem[4] = rs.getInt("prize_rem5");
            prizeRem[5] = rs.getInt("prize_rem6");
            prizeRem[6] = rs.getInt("prize_rem7");
            prizeRem[7] = rs.getInt("prize_rem8");
            prizeRem[8] = rs.getInt("prize_rem9");
            prizeRem[9] = rs.getInt("prize_rem10");
            prizeRem[10] = rs.getInt("prize_rem11");
            prizeRem[11] = rs.getInt("prize_rem12");
            prizeRem[12] = rs.getInt("prize_rem13");
            prizeRem[13] = rs.getInt("prize_rem14");
            prizeRem[14] = rs.getInt("prize_rem15");
            lsrem = rs.getInt("last_sale_rem");
            String part_num = rs.getString("game_templates_part_num");
            pstmt = con.prepareStatement("SELECT * FROM game_templates WHERE part_num = ? ");
            pstmt.setString(1,part_num);
            rs = pstmt.executeQuery();
            rs.next();
            prizeAmt = new int[15];
            gameName = rs.getString("game_name");
            prizeAmt[0] = rs.getInt("prize_amt1");
            prizeAmt[1] = rs.getInt("prize_amt2");
            prizeAmt[2] = rs.getInt("prize_amt3");
            prizeAmt[3] = rs.getInt("prize_amt4");
            prizeAmt[4] = rs.getInt("prize_amt5");
            prizeAmt[5] = rs.getInt("prize_amt6");
            prizeAmt[6] = rs.getInt("prize_amt7");
            prizeAmt[7] = rs.getInt("prize_amt8");
            prizeAmt[8] = rs.getInt("prize_amt9");
            prizeAmt[9] = rs.getInt("prize_amt10");
            prizeAmt[10] = rs.getInt("prize_amt11");
            prizeAmt[11] = rs.getInt("prize_amt12");
            prizeAmt[12] = rs.getInt("prize_amt13");
            prizeAmt[13] = rs.getInt("prize_amt14");
            prizeAmt[14] = rs.getInt("prize_amt15");
            prizeAll = new int[15];
            prizeAll[0] = rs.getInt("prize_all1");
            prizeAll[1] = rs.getInt("prize_all2");
            prizeAll[2] = rs.getInt("prize_all3");
            prizeAll[3] = rs.getInt("prize_all4");
            prizeAll[4] = rs.getInt("prize_all5");
            prizeAll[5] = rs.getInt("prize_all6");
            prizeAll[6] = rs.getInt("prize_all7");
            prizeAll[7] = rs.getInt("prize_all8");
            prizeAll[8] = rs.getInt("prize_all9");
            prizeAll[9] = rs.getInt("prize_all10");
            prizeAll[10] = rs.getInt("prize_all11");
            prizeAll[11] = rs.getInt("prize_all12");
            prizeAll[12] = rs.getInt("prize_all13");
            prizeAll[13] = rs.getInt("prize_all14");
            prizeAll[14] = rs.getInt("prize_all15");
            lsamt = rs.getInt("last_sale");
            System.out.println("Prize amount 1: " + prizeAmt[0] + " Prize allowed 1: "+ prizeAll[0]);
            loadButtons();
        }catch (Exception e) { e.printStackTrace(); }
    }
    public void loadButtons(){
         String amt1 = Integer.toString(prizeAmt[0]);
        prize1.setText(amt1);
        String amt2 = Integer.toString(prizeAmt[1]);
        prize2.setText(amt2);
        String amt3 = Integer.toString(prizeAmt[2]);
        prize3.setText(amt3);
        String amt4 = Integer.toString(prizeAmt[3]);
        prize4.setText(amt4);
        String amt5 = Integer.toString(prizeAmt[4]);
        prize5.setText(amt5);
        String amt6 = Integer.toString(prizeAmt[5]);
        prize6.setText(amt6);
        String amt7 = Integer.toString(prizeAmt[6]);
        prize7.setText(amt7);
        String amt8 = Integer.toString(prizeAmt[7]);
        prize8.setText(amt8);
        String amt9 = Integer.toString(prizeAmt[8]);
        prize9.setText(amt9);
        String amt10 = Integer.toString(prizeAmt[9]);
        prize10.setText(amt10);
        String amt11 = Integer.toString(prizeAmt[10]);
        prize11.setText(amt11);
        String amt12 = Integer.toString(prizeAmt[11]);
        prize12.setText(amt12);
        String amt13 = Integer.toString(prizeAmt[12]);
        prize13.setText(amt13);
        String amt14 = Integer.toString(prizeAmt[13]);
        prize14.setText(amt14);
        String amt15 = Integer.toString(prizeAmt[14]);
        prize15.setText(amt15);
        String Slsamt = Integer.toString(lsamt);
        btnLS.setText(Slsamt);
    }
    public void setPrizetotal(int amount){
        System.out.println("setPrizetotal received amount: " + amount);
        prizetotal = 0 + amount;
        System.out.println("Prizetotal: " + prizetotal);
    }
    public int getPrizetotal(){
        System.out.println("getPrizetotal: " + prizetotal);
        return prizetotal;
    }
    public void recordPrize(String serial, int amount)throws SQLException, Exception{
        //TODO: Add to actual prizes, remove prize from remaining prizes
        Transaction trans = new Transaction();
        int invoice = Transaction.invoiceNum;
        trans.Transaction(bin2, serial, 0, amount, gameName, invoice);
}
    private static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
      
}
    public void removePrize(int num){
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        prize1 = new javax.swing.JButton();
        prize2 = new javax.swing.JButton();
        prize3 = new javax.swing.JButton();
        prize4 = new javax.swing.JButton();
        prize5 = new javax.swing.JButton();
        prize6 = new javax.swing.JButton();
        prize7 = new javax.swing.JButton();
        prize8 = new javax.swing.JButton();
        prize9 = new javax.swing.JButton();
        prize10 = new javax.swing.JButton();
        prize11 = new javax.swing.JButton();
        prize12 = new javax.swing.JButton();
        prize13 = new javax.swing.JButton();
        prize14 = new javax.swing.JButton();
        prize15 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnLS = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Prizes for game:");

        prize1.setText("jButton1");
        prize1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prize1ActionPerformed(evt);
            }
        });

        prize2.setText("jButton2");
        prize2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prize2ActionPerformed(evt);
            }
        });

        prize3.setText("jButton3");
        prize3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prize3ActionPerformed(evt);
            }
        });

        prize4.setText("jButton4");
        prize4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prize4ActionPerformed(evt);
            }
        });

        prize5.setText("jButton5");
        prize5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prize5ActionPerformed(evt);
            }
        });

        prize6.setText("jButton6");
        prize6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prize6ActionPerformed(evt);
            }
        });

        prize7.setText("jButton7");
        prize7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prize7ActionPerformed(evt);
            }
        });

        prize8.setText("jButton8");

        prize9.setText("jButton9");

        prize10.setText("jButton10");

        prize11.setText("jButton11");
        prize11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prize11ActionPerformed(evt);
            }
        });

        prize12.setText("jButton12");

        prize13.setText("jButton13");

        prize14.setText("jButton14");

        prize15.setText("jButton15");
        prize15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prize15ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setText("Close window");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLS.setBackground(new java.awt.Color(204, 204, 255));
        btnLS.setText("Last Sale");
        btnLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLSActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("LAST SALE:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prize3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(prize13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prize10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(prize1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prize10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prize11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prize12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prize13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prize14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prize15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLS, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prize1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prize2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(prize3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(prize4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prize5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prize6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prize7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prize8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prize9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prize2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prize2ActionPerformed
        // TODO add your handling code here:
        if(prizeRem[1] > 0){
        String strPrize2 = prize2.getText();
        int intPrize2 = Integer.parseInt(strPrize2);
        setPrizetotal(intPrize2);
        try{
            
            recordPrize(serial, intPrize2);
            int prizetotal = getPrizetotal();//gets the total value of the prizes selected 
            total1 = total1 - prizetotal;//minus the total sales(if any) from the amount of the prizes
            System.out.println("Prize total imported: "+ prizetotal);//testing output
            String str = Double.toString(total1);//converts double to string to display total
            Selling.textDisplay.setText("");//sets amount to 0
            Selling.textTotal.setText(str);//sets total to total1 value
            Selling.addTextLog("\nPrize: " + gameName + "\nAmount: " + strPrize2);
            prizeRem[1] = prizeRem[1] - 1;
        }catch (Exception e) { e.printStackTrace(); }
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "There are not enough winners left.");//needs to trigger a ticket audit
        }
    }//GEN-LAST:event_prize2ActionPerformed

    private void prize1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prize1ActionPerformed
        // TODO add your handling code here:
        if(prizeRem[0] > 0){
        String strPrize1 = prize1.getText();
        int intPrize1 = Integer.parseInt(strPrize1);
        setPrizetotal(intPrize1);
        try{
            recordPrize(serial, intPrize1);
            int prizetotal = getPrizetotal();//gets the total value of the prizes selected 
            total1 = total1 - prizetotal;//minus the total sales(if any) from the amount of the prizes
            System.out.println("Prize total imported: "+ prizetotal);//testing output
            String str = Double.toString(total1);//converts double to string to display total
            Selling.textDisplay.setText("");//sets amount to 0
            Selling.textTotal.setText(str);//sets total to total1 value
            Selling.addTextLog("\nPrize: " + gameName + "\nAmount: " + strPrize1);
        }catch (Exception e) { e.printStackTrace(); }
           
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "There are not enough winners left.");//needs to trigger a ticket audit
        }
    }//GEN-LAST:event_prize1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void prize3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prize3ActionPerformed
        // TODO add your handling code here:
        if(prizeRem[2] > 0){
        String strPrize3 = prize3.getText();
        int intPrize3 = Integer.parseInt(strPrize3);
        setPrizetotal(intPrize3);
        try{
            recordPrize(serial, intPrize3);
            int prizetotal = getPrizetotal();//gets the total value of the prizes selected 
            total1 = total1 - prizetotal;//minus the total sales(if any) from the amount of the prizes
            System.out.println("Prize total imported: "+ prizetotal);//testing output
            String str = Double.toString(total1);//converts double to string to display total
            Selling.textDisplay.setText("");//sets amount to 0
            Selling.textTotal.setText(str);//sets total to total1 value
            Selling.addTextLog("\nPrize: " + gameName + "\nAmount: " + strPrize3);
        }catch (Exception e) { e.printStackTrace(); }
        try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "There are not enough winners left.");//needs to trigger a ticket audit
        }
    }//GEN-LAST:event_prize3ActionPerformed

    private void prize4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prize4ActionPerformed
        // TODO add your handling code here:
        if(prizeRem[3] > 0){
        String strPrize4 = prize4.getText();
        int intPrize4 = Integer.parseInt(strPrize4);
        setPrizetotal(intPrize4);
        try{
            recordPrize(serial, intPrize4);
            int prizetotal = getPrizetotal();//gets the total value of the prizes selected 
            total1 = total1 - prizetotal;//minus the total sales(if any) from the amount of the prizes
            System.out.println("Prize total imported: "+ prizetotal);//testing output
            String str = Double.toString(total1);//converts double to string to display total
            Selling.textDisplay.setText("");//sets amount to 0
            Selling.textTotal.setText(str);//sets total to total1 value
            Selling.addTextLog("\nPrize: " + gameName + "\nAmount: " + strPrize4);
        }catch (Exception e) { e.printStackTrace(); }
        try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "There are not enough winners left.");//needs to trigger a ticket audit
        }
    }//GEN-LAST:event_prize4ActionPerformed

    private void prize5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prize5ActionPerformed
        // TODO add your handling code here:
        if(prizeRem[4] > 0){
        String strPrize5 = prize5.getText();
        int intPrize5 = Integer.parseInt(strPrize5);
        setPrizetotal(intPrize5);
        try{
            recordPrize(serial, intPrize5);
            int prizetotal = getPrizetotal();//gets the total value of the prizes selected 
            total1 = total1 - prizetotal;//minus the total sales(if any) from the amount of the prizes
            System.out.println("Prize total imported: "+ prizetotal);//testing output
            String str = Double.toString(total1);//converts double to string to display total
            Selling.textDisplay.setText("");//sets amount to 0
            Selling.textTotal.setText(str);//sets total to total1 value
            Selling.addTextLog("\nPrize: " + gameName + "\nAmount: " + strPrize5);
        }catch (Exception e) { e.printStackTrace(); }
        try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "There are not enough winners left.");//needs to trigger a ticket audit
        }
    }//GEN-LAST:event_prize5ActionPerformed

    private void prize6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prize6ActionPerformed
        // TODO add your handling code here:
        if(prizeRem[5] > 0){
        String strPrize6 = prize6.getText();
        int intPrize6 = Integer.parseInt(strPrize6);
        setPrizetotal(intPrize6);
        try{
            recordPrize(serial, intPrize6);
            int prizetotal = getPrizetotal();//gets the total value of the prizes selected 
            total1 = total1 - prizetotal;//minus the total sales(if any) from the amount of the prizes
            System.out.println("Prize total imported: "+ prizetotal);//testing output
            String str = Double.toString(total1);//converts double to string to display total
            Selling.textDisplay.setText("");//sets amount to 0
            Selling.textTotal.setText(str);//sets total to total1 value
            Selling.addTextLog("\nPrize: " + gameName + "\nAmount: " + strPrize6);
        }catch (Exception e) { e.printStackTrace(); }
        try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "There are not enough winners left.");//needs to trigger a ticket audit
        }
    }//GEN-LAST:event_prize6ActionPerformed

    private void prize7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prize7ActionPerformed
        // TODO add your handling code here:
        if(prizeRem[6] > 0){
        String strPrize7 = prize7.getText();
        int intPrize7 = Integer.parseInt(strPrize7);
        setPrizetotal(intPrize7);
        try{
            recordPrize(serial, intPrize7);
            int prizetotal = getPrizetotal();//gets the total value of the prizes selected 
            total1 = total1 - prizetotal;//minus the total sales(if any) from the amount of the prizes
            System.out.println("Prize total imported: "+ prizetotal);//testing output
            String str = Double.toString(total1);//converts double to string to display total
            Selling.textDisplay.setText("");//sets amount to 0
            Selling.textTotal.setText(str);//sets total to total1 value
            Selling.addTextLog("\nPrize: " + gameName + "\nAmount: " + strPrize7);
        }catch (Exception e) { e.printStackTrace(); }
        }else{
            JOptionPane.showMessageDialog(this, "There are not enough winners left.");//needs to trigger a ticket audit
        }
    }//GEN-LAST:event_prize7ActionPerformed

    private void prize15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prize15ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_prize15ActionPerformed

    private void btnLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLSActionPerformed
        // TODO add your handling code here:
        if (lsrem > 0){
            String ls = btnLS.getText();
            int intls = Integer.parseInt(ls);
            setPrizetotal(intls);
            try{
                recordPrize(serial, intls);
                int prizetotal = getPrizetotal();
                total1 = total1 - prizetotal;
                System.out.println("Prize total imported: "+ prizetotal);//testing output
                String str = Double.toString(total1);//converts double to string to display total
                Selling.textDisplay.setText("");//sets amount to 0
                Selling.textTotal.setText(str);//sets total to total1 value
                Selling.addTextLog("\nLast Sale: " + gameName + "\nAmount: " + intls);
            }catch (Exception e) { e.printStackTrace(); }
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "There is no last sale");//needs to trigger a ticket audit
        }
    }//GEN-LAST:event_btnLSActionPerformed

    private void prize11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prize11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prize11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws InterruptedException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrizeSelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrizeSelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrizeSelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrizeSelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrizeSelling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLS;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton prize1;
    private javax.swing.JButton prize10;
    private javax.swing.JButton prize11;
    private javax.swing.JButton prize12;
    private javax.swing.JButton prize13;
    private javax.swing.JButton prize14;
    private javax.swing.JButton prize15;
    public javax.swing.JButton prize2;
    private javax.swing.JButton prize3;
    private javax.swing.JButton prize4;
    private javax.swing.JButton prize5;
    private javax.swing.JButton prize6;
    private javax.swing.JButton prize7;
    private javax.swing.JButton prize8;
    private javax.swing.JButton prize9;
    // End of variables declaration//GEN-END:variables
}
