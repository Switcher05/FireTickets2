/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tickets;

import Tickets.TicketEditor.TicketsEditor;
import Tickets.Logging.LoggerExample;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.FileHandler;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 *
 * @author Switcher
 */

public class Selling extends javax.swing.JFrame implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());
    public static double total1 = 0.0;
    public double total2 = 0.0;
    public int subtotal;
    public String[] Sale;
    public int amount;
    public int bin;
    public String serial;
    public int ticketCost;
    public int generatedKey = 0;
    public String name;
    public String game_name;
    public static boolean saleClosed = true;
    public int unsold_amt, actual_gross, unsold_tickets, actual_prizes;
    public boolean selected = false;
    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pstmt;
    int curRow = 0;
    FileHandler fh;
    String soundName = "chaching.wav"; 

    PrizeSelling prize = new PrizeSelling();

    public Selling() {
        run();
        initComponents();
        //logtoFile();
        DoConnect();
        setUser();
        //invoice = trans.setInvoice();
        
        
        
    }
    public void run(){
        System.out.println("Thread started");
    }
    public void setUser(){
        Login login = new Login();
        String user1 = login.getUser();
        jTextField2.setText(user1);
        textLog.append("Logged in user is: " + user1);
        LOGGER.log(Level.INFO, "Logged in user is: {0}", user1);
        
    }

    public void DoConnect( ) {
        
        try{
        //need to create inner join
        Connection c = DbConnect.getConnection();
        stmt = c.createStatement();
        
        
        String sql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '1' and inplay = '1'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
        String bin_one = rs.getString("game_name");
        togbtn1.setText(bin_one);
        }
        String binTwoSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '2' and inplay = '1'";
        rs = stmt.executeQuery(binTwoSql);
        while(rs.next()){
        String bin_two = rs.getString("game_name");
        togbtn2.setText(bin_two);
        }
        String binThreeSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '3' and inplay = '1'";
        rs = stmt.executeQuery(binThreeSql);
        while(rs.next()){
        String bin_three = rs.getString("game_name");
        togbtn3.setText(bin_three);
        }
        String binFourSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '4' and inplay = '1'";
        rs = stmt.executeQuery(binFourSql);
        while(rs.next()){
        String bin_four = rs.getString("game_name");
        togbtn4.setText(bin_four);
        }
        String binFiveSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '5' and inplay = '1'";
        rs = stmt.executeQuery(binFiveSql);
        while(rs.next()){
        String bin_five = rs.getString("game_name");
        togbtn5.setText(bin_five);
        }
        String binSixSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '6' and inplay = '1'";
        rs = stmt.executeQuery(binSixSql);
        while(rs.next()){
        String bin_six = rs.getString("game_name");
        togbtn6.setText(bin_six);
        }
        String binSevenSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '7' and inplay = '1'";
        rs = stmt.executeQuery(binSevenSql);
        while(rs.next()){
        String bin_seven = rs.getString("game_name");
        togbtn7.setText(bin_seven);
        }
        String binEightSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '8' and inplay = '1'";
        rs = stmt.executeQuery(binEightSql);
        while(rs.next()){
        String bin_eight = rs.getString("game_name");
        togbtn8.setText(bin_eight);
        }
        String binNineSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '9' and inplay = '1'";
        rs = stmt.executeQuery(binNineSql);
        while(rs.next()){
        String bin_nine = rs.getString("game_name");
        togbtn9.setText(bin_nine);
        }
        String binTenSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '10' and inplay = '1'";
        rs = stmt.executeQuery(binTenSql);
        while(rs.next()){
        String bin_ten = rs.getString("game_name");
        togbtn10.setText(bin_ten);
        }
        String binElevenSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '11' and inplay = '1'";
        rs = stmt.executeQuery(binElevenSql);
        while(rs.next()){
        String bin_eleven = rs.getString("game_name");
        togbtn11.setText(bin_eleven);
        }
        String binTweleveSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '12' and inplay = '1'";
        rs = stmt.executeQuery(binTweleveSql);
        while(rs.next()){
        String bin_tweleve = rs.getString("game_name");
        togbtn12.setText(bin_tweleve);
        }
        String binThirteenSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '13' and inplay = '1'";
        rs = stmt.executeQuery(binThirteenSql);
        while(rs.next()){
        String bin_thirteen = rs.getString("game_name");
        togbtn13.setText(bin_thirteen);
        }
        String binFourteenSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '14' and inplay = '1'";
        rs = stmt.executeQuery(binFourteenSql);
        while(rs.next()){
        String bin_fourteen = rs.getString("game_name");
        togbtn14.setText(bin_fourteen);
        }
        String binFifteenSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '15' and inplay = '1'";
        rs = stmt.executeQuery(binFifteenSql);
        while(rs.next()){
        String bin_fifteen = rs.getString("game_name");
        togbtn15.setText(bin_fifteen);
        }
        String binSixteenSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '16' and inplay = '1'";
        rs = stmt.executeQuery(binSixteenSql);
        while(rs.next()){
        String bin_sixteen = rs.getString("game_name");
        togbtn16.setText(bin_sixteen);
        }
        String binSeventeenSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '17' and inplay = '1'";
        rs = stmt.executeQuery(binSeventeenSql);
        while(rs.next()){
        String bin_seventeen = rs.getString("game_name");
        togbtn17.setText(bin_seventeen);
        }
        String binEighteenSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '18' and inplay = '1'";
        rs = stmt.executeQuery(binEighteenSql);
        while(rs.next()){
        String bin_eighteen = rs.getString("game_name");
        togbtn18.setText(bin_eighteen);
        }
        String binNineteenSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '19' and inplay = '1'";
        rs = stmt.executeQuery(binNineteenSql);
        while(rs.next()){
        String bin_nineteen = rs.getString("game_name");
        togbtn19.setText(bin_nineteen);
        }
        String binTwentySql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '20' and inplay = '1'";
        rs = stmt.executeQuery(binTwentySql);
        while(rs.next()){
        String bin_twenty = rs.getString("game_name");
        togbtn20.setText(bin_twenty);
        }
        String binTwentyoneSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '21' and inplay = '1'";
        rs = stmt.executeQuery(binTwentyoneSql);
        while(rs.next()){
        String bin_twentyone = rs.getString("game_name");
        togbtn21.setText(bin_twentyone);
        }
        String binTwentytwoSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '22' and inplay = '1'";
        rs = stmt.executeQuery(binTwentytwoSql);
        while(rs.next()){
        String bin_twentytwo = rs.getString("game_name");
        togbtn22.setText(bin_twentytwo);
        }
        String binTwentythreeSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '23' and inplay = '1'";
        rs = stmt.executeQuery(binTwentythreeSql);
        while(rs.next()){
        String bin_twentythree = rs.getString("game_name");
        togbtn23.setText(bin_twentythree);
        }
        String binTwentyfourSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '24' and inplay = '1'";
        rs = stmt.executeQuery(binTwentyfourSql);
        while(rs.next()){
        String bin_twentyfour = rs.getString("game_name");
        togbtn24.setText(bin_twentyfour);
        }
        String binTwentyFiveSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '25' and inplay = '1'";
        rs = stmt.executeQuery(binTwentyFiveSql);
        while(rs.next()){
        String bin_twentyfive = rs.getString("game_name");
        togbtn25.setText(bin_twentyfive);
        }
        String binTwentySixSql = "Select game_name from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '26' and inplay = '1'";
        rs = stmt.executeQuery(binTwentySixSql);
        while(rs.next()){
        String bin_twentysix = rs.getString("game_name");
        togbtn26.setText(bin_twentysix);
        }
        String binTwentySevenSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '27' and inplay = '1'";
        rs = stmt.executeQuery(binTwentySevenSql);
        while(rs.next()){
        String bin_twentyseven = rs.getString("game_name");
        togbtn27.setText(bin_twentyseven);
        }
        String binTwentyEightSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '28' and inplay = '1'";
        rs = stmt.executeQuery(binTwentyEightSql);
        while(rs.next()){
        String bin_twentyeight = rs.getString("game_name");
        togbtn28.setText(bin_twentyeight);
        }
        String binTwentyNineSql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '29' and inplay = '1'";
        rs = stmt.executeQuery(binTwentyNineSql);
        while(rs.next()){
        String bin_twentynine = rs.getString("game_name");
        togbtn29.setText(bin_twentynine);
        }
        String binThirtySql = "Select * from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = '30' and inplay = '1'";
        rs = stmt.executeQuery(binThirtySql);
        while(rs.next()){
        String bin_thirty = rs.getString("game_name");
        togbtn30.setText(bin_thirty);
        }
        }
        catch (Exception e) { e.printStackTrace(); }

    }
    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        textLog = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        togbtn1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        togbtn2 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        togbtn3 = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        togbtn4 = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        togbtn5 = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        togbtn6 = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        togbtn7 = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        togbtn8 = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        togbtn9 = new javax.swing.JToggleButton();
        jLabel12 = new javax.swing.JLabel();
        togbtn10 = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        togbtn11 = new javax.swing.JToggleButton();
        jLabel14 = new javax.swing.JLabel();
        togbtn12 = new javax.swing.JToggleButton();
        jLabel15 = new javax.swing.JLabel();
        togbtn13 = new javax.swing.JToggleButton();
        jLabel16 = new javax.swing.JLabel();
        togbtn14 = new javax.swing.JToggleButton();
        jLabel17 = new javax.swing.JLabel();
        togbtn15 = new javax.swing.JToggleButton();
        togbtn16 = new javax.swing.JToggleButton();
        togbtn17 = new javax.swing.JToggleButton();
        togbtn18 = new javax.swing.JToggleButton();
        togbtn19 = new javax.swing.JToggleButton();
        togbtn20 = new javax.swing.JToggleButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        togbtn30 = new javax.swing.JToggleButton();
        togbtn29 = new javax.swing.JToggleButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        togbtn28 = new javax.swing.JToggleButton();
        togbtn27 = new javax.swing.JToggleButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        togbtn26 = new javax.swing.JToggleButton();
        togbtn25 = new javax.swing.JToggleButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        togbtn24 = new javax.swing.JToggleButton();
        togbtn23 = new javax.swing.JToggleButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        togbtn22 = new javax.swing.JToggleButton();
        togbtn21 = new javax.swing.JToggleButton();
        jLabel34 = new javax.swing.JLabel();
        pnlAmount = new javax.swing.JPanel();
        btnOne = new javax.swing.JButton();
        btnTwo = new javax.swing.JButton();
        btnThree = new javax.swing.JButton();
        btnFour = new javax.swing.JButton();
        btnFive = new javax.swing.JButton();
        btnSix = new javax.swing.JButton();
        btnSeven = new javax.swing.JButton();
        btnEight = new javax.swing.JButton();
        btnNine = new javax.swing.JButton();
        btnZero = new javax.swing.JButton();
        btnTen = new javax.swing.JButton();
        btnTwenty = new javax.swing.JButton();
        btnFifty = new javax.swing.JButton();
        btnHundred = new javax.swing.JButton();
        btnSale = new javax.swing.JButton();
        btnPrize = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        textDisplay = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        textTotal = new javax.swing.JTextField();
        btnEditTick = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        negativebtn = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        bankText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        btnPrintEvery = new javax.swing.JToggleButton();
        jButton10 = new javax.swing.JButton();
        closingfield = new javax.swing.JTextField();
        btnCloseCash = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jTFaddcash = new javax.swing.JTextField();
        btnAddRemCash = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        timeLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        currentTime = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Selling");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Transaction Log"));

        jScrollPane2.setToolTipText("");
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        textLog.setEditable(false);
        textLog.setColumns(20);
        textLog.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        textLog.setLineWrap(true);
        textLog.setRows(5);
        textLog.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textLog);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Games:"));

        togbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togbtn1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("1:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("2:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("3:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("4:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("5:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("6:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("7:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("8:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("9:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("10:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("11:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("12:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("13:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("14:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("15:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("20:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("19:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("18:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("17:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("16:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("30:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("29:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("28:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("27:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("26:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("25:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("24:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("23:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("22:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("21:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(togbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(togbtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(togbtn11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn13, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(togbtn14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(togbtn22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn21, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togbtn23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn30, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(togbtn11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(togbtn12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel14))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(togbtn13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel15))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(togbtn14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel16))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(togbtn15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel17))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(togbtn16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel23)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(togbtn17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel22)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(togbtn18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel21)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(togbtn19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel20)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(togbtn20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel19))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(togbtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(togbtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(togbtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(togbtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(togbtn10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel12))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel34)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel33)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel32)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel31)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel30)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel29)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel28)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togbtn30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel25)))))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pnlAmount.setBorder(javax.swing.BorderFactory.createTitledBorder("Amount:"));

        btnOne.setText("1");
        btnOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOneActionPerformed(evt);
            }
        });

        btnTwo.setText("2");
        btnTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoActionPerformed(evt);
            }
        });

        btnThree.setText("3");
        btnThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThreeActionPerformed(evt);
            }
        });

        btnFour.setText("4");
        btnFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFourActionPerformed(evt);
            }
        });

        btnFive.setText("5");
        btnFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiveActionPerformed(evt);
            }
        });

        btnSix.setText("6");
        btnSix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSixActionPerformed(evt);
            }
        });

        btnSeven.setText("7");
        btnSeven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSevenActionPerformed(evt);
            }
        });

        btnEight.setText("8");
        btnEight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEightActionPerformed(evt);
            }
        });

        btnNine.setText("9");
        btnNine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNineActionPerformed(evt);
            }
        });

        btnZero.setText("0");
        btnZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZeroActionPerformed(evt);
            }
        });

        btnTen.setText("10");
        btnTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTenActionPerformed(evt);
            }
        });

        btnTwenty.setText("20");
        btnTwenty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwentyActionPerformed(evt);
            }
        });

        btnFifty.setText("50");
        btnFifty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiftyActionPerformed(evt);
            }
        });

        btnHundred.setText("100");
        btnHundred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHundredActionPerformed(evt);
            }
        });

        btnSale.setText("Sale");
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleActionPerformed(evt);
            }
        });

        btnPrize.setText("Prize");
        btnPrize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrizeActionPerformed(evt);
            }
        });

        jButton18.setText("Tender change");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        textDisplay.setEditable(false);
        textDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDisplayActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Amount:");

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Total:");

        textTotal.setEditable(false);

        btnEditTick.setText("Edit Ticket");
        btnEditTick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTickActionPerformed(evt);
            }
        });

        jLabel18.setText("jLabel18");

        jButton2.setText("Add Customer");
        jButton2.setEnabled(false);

        jButton3.setText("Big Winner");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Reprint X invoice");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Reciept on/off");
        jButton5.setEnabled(false);

        jButton6.setText("Night close");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Lock/Logout");
        jButton7.setEnabled(false);

        jButton8.setText("Delete invoice #");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("jButton9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        negativebtn.setText("Negative");
        negativebtn.setEnabled(false);
        negativebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativebtnActionPerformed(evt);
            }
        });

        jButton12.setText("Start bank");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnUndo.setText("Undo");
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });

        btnPrintEvery.setText("Receipt Enabled/Disable");
        btnPrintEvery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintEveryActionPerformed(evt);
            }
        });

        jButton10.setText("Kick drawer 1");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        btnCloseCash.setText("Closing Cash");
        btnCloseCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseCashActionPerformed(evt);
            }
        });

        jButton13.setText("Kick drawer 2");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        btnAddRemCash.setText("Add/Rem Cash");
        btnAddRemCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRemCashActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout pnlAmountLayout = new javax.swing.GroupLayout(pnlAmount);
        pnlAmount.setLayout(pnlAmountLayout);
        pnlAmountLayout.setHorizontalGroup(
            pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAmountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton5)
                            .addComponent(btnEditTick)
                            .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton9)
                                    .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addGap(0, 119, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAmountLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton8))))
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7))
                            .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlAmountLayout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAmountLayout.createSequentialGroup()
                                    .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton10)
                                        .addComponent(jButton13))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTFaddcash)
                                        .addComponent(closingfield)
                                        .addComponent(bankText, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnCloseCash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAddRemCash))))))
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPrize, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addComponent(btnOne, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(negativebtn))
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAmountLayout.createSequentialGroup()
                                .addComponent(btnSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEight, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                                .addComponent(btnFour, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnFive, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                                .addComponent(btnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)))
                                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnThree, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnSix, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnNine, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFifty, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHundred, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTwenty, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton18))))
                        .addGap(18, 34, Short.MAX_VALUE)
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPrintEvery)
                            .addComponent(jLabel18)))
                    .addComponent(btnUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        pnlAmountLayout.setVerticalGroup(
            pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAmountLayout.createSequentialGroup()
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel35)
                                .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel18)))
                        .addGap(19, 19, 19)
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(negativebtn))
                                .addGap(1, 1, 1)
                                .addComponent(btnTwenty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFifty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHundred, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(btnPrintEvery, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnOne, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnThree, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnTen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnFour, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFive, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSix, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEight, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNine, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPrize, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                    .addComponent(jTextField1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12)
                            .addComponent(bankText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closingfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCloseCash))
                .addGap(1, 1, 1)
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFaddcash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddRemCash))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9)
                        .addComponent(jButton8))
                    .addComponent(btnEditTick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel3.setText("Seller:");

        jTextField2.setEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        timeLabel.setText("Time:");

        dateLabel.setText("Date:");

        currentTime.setText("jLabel24");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentTime)
                        .addGap(22, 22, 22)
                        .addComponent(dateLabel))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel)
                    .addComponent(dateLabel)
                    .addComponent(currentTime))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOneActionPerformed
       String btnOneText = textDisplay.getText() + btnOne.getText();
       textDisplay.setText(btnOneText);
    }//GEN-LAST:event_btnOneActionPerformed

    private void btnTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoActionPerformed
        String btnTwoText = textDisplay.getText() + btnTwo.getText();
       textDisplay.setText(btnTwoText);
    }//GEN-LAST:event_btnTwoActionPerformed

    private void btnThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThreeActionPerformed
        String btnThreeText = textDisplay.getText() + btnThree.getText();
       textDisplay.setText(btnThreeText);
    }//GEN-LAST:event_btnThreeActionPerformed

    private void btnFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFourActionPerformed
        String btnFourText = textDisplay.getText() + btnFour.getText();
       textDisplay.setText(btnFourText);
    }//GEN-LAST:event_btnFourActionPerformed

    private void btnFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiveActionPerformed
        String btnFiveText = textDisplay.getText() + btnFive.getText();
       textDisplay.setText(btnFiveText);
    }//GEN-LAST:event_btnFiveActionPerformed

    private void btnSixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSixActionPerformed
       String btnSixText = textDisplay.getText() + btnSix.getText();
       textDisplay.setText(btnSixText);
    }//GEN-LAST:event_btnSixActionPerformed

    private void btnSevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSevenActionPerformed
        String btnSevenText = textDisplay.getText() + btnSeven.getText();
       textDisplay.setText(btnSevenText);
    }//GEN-LAST:event_btnSevenActionPerformed

    private void btnEightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEightActionPerformed
        String btnEightText = textDisplay.getText() + btnEight.getText();
       textDisplay.setText(btnEightText);
    }//GEN-LAST:event_btnEightActionPerformed

    private void btnNineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNineActionPerformed
        String btnNineText = textDisplay.getText() + btnNine.getText();
       textDisplay.setText(btnNineText);
    }//GEN-LAST:event_btnNineActionPerformed

    private void btnZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZeroActionPerformed
        String btnZeroText = textDisplay.getText() + btnZero.getText();
       textDisplay.setText(btnZeroText);
    }//GEN-LAST:event_btnZeroActionPerformed

    private void btnTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTenActionPerformed
        String btnTenText = textDisplay.getText() + btnTen.getText();
       textDisplay.setText(btnTenText);
    }//GEN-LAST:event_btnTenActionPerformed

    private void btnTwentyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwentyActionPerformed
        String btnTwentyText = textDisplay.getText() + btnTwenty.getText();
       textDisplay.setText(btnTwentyText);
    }//GEN-LAST:event_btnTwentyActionPerformed

    private void btnFiftyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiftyActionPerformed
        String btnFiftyText = textDisplay.getText() + btnFifty.getText();
       textDisplay.setText(btnFiftyText);
    }//GEN-LAST:event_btnFiftyActionPerformed

    private void btnHundredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHundredActionPerformed
        String btnHundredText = textDisplay.getText() + btnHundred.getText();
        textDisplay.setText(btnHundredText);
    }//GEN-LAST:event_btnHundredActionPerformed

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed
        Transaction trans = new Transaction();
        int invoice = 0;
        String subText = textDisplay.getText();
        //check if the button selected is empty
        if (subText.isEmpty()){
            JOptionPane.showMessageDialog(this, "No game selected");
        }else{
            subtotal = Integer.parseInt(textDisplay.getText());
        
        total1 = total1 + subtotal;
        bin = getButton(); //gets what button is selected
        if (subtotal != 0){
        try{
            con = DbConnect.getConnection();
            pstmt = con.prepareStatement("Select game_name, serial, unsold_amt,actual_gross,unsold_tickets,ticket_cost from tickets inner join game_templates where game_templates.part_num = tickets.game_templates_part_num and bin = ? and inplay = 1");
            pstmt.setInt(1,bin);
            rs = pstmt.executeQuery();
            rs.next();
            ticketCost = rs.getInt("ticket_cost");
            game_name = rs.getString("game_name");
            serial = rs.getString("Serial");
            unsold_amt = rs.getInt("unsold_amt");
            actual_gross = rs.getInt("actual_gross");
            unsold_tickets = rs.getInt("unsold_tickets");
//            System.out.println("Serial = " + serial + " Unsold_amt: " + unsold_amt + " Actual gross " + actual_gross + " Unsold Tickets " + unsold_tickets);
            LOGGER.log(Level.INFO, "Serial = {0} Unsold_amt: {1} Actual gross {2} Unsold Tickets {3}", new Object[]{serial, unsold_amt, actual_gross, unsold_tickets});
//            if (saleClosed = true){
//                invoice = trans.setInvoice();
//                saleClosed = false;
//                }else{
//                    invoice = trans.getInvoice();
//            }
            trans.Transaction(bin, serial, subtotal, 0, game_name, invoice);
//            amount = ticketsObject.Sale(unsold_amt, actual_gross, unsold_tickets, subtotal, serial, ticketCost, game_name);
            textLog.append("\nSale: " + bin + ": " + game_name + " \nAmount: " + subtotal);
        }catch (Exception e) { e.printStackTrace(); }
        String str = Double.toString(total1);
        textDisplay.setText("");//sets amount to 0
        subtotal = 0;
        textTotal.setText(str);//sets total to total1 value
        togbtnSetEnabledFalse();
        }else{
            System.err.println("No game selected");
            JOptionPane.showMessageDialog(this, "No game select");
        }
        }
        
    }//GEN-LAST:event_btnSaleActionPerformed
    private void logtoFile(){
        try {  

        // This block configure the logger with handler and formatter  
        fh = new FileHandler("\\\\WIN-UI54OA8049S\\Treasurer\\dist\\Logs\\MyLogFile1.log");  
        LOGGER.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  

        // the following statement is used to log any messages  
        LOGGER.info("My first log");  

    } catch (SecurityException e) {  
        e.printStackTrace();  
    } catch (IOException e) {  
        e.printStackTrace();  
    }  

//    LOGGER.info("Hi How r u?");  

    }
    private void togbtnSetEnabledFalse(){
        //Sets all the toggle buttons to false
        togbtn1.setSelected(false);
        togbtn2.setSelected(false);
        togbtn3.setSelected(false);
        togbtn4.setSelected(false);
        togbtn5.setSelected(false);
        togbtn6.setSelected(false);
        togbtn7.setSelected(false);
        togbtn8.setSelected(false);
        togbtn9.setSelected(false);
        togbtn10.setSelected(false);
        togbtn11.setSelected(false);
        togbtn12.setSelected(false);
        togbtn13.setSelected(false);
        togbtn14.setSelected(false);
        togbtn15.setSelected(false);
        togbtn16.setSelected(false);
        togbtn17.setSelected(false);
        togbtn18.setSelected(false);
        togbtn19.setSelected(false);
        togbtn20.setSelected(false);
        togbtn21.setSelected(false);
        togbtn22.setSelected(false);
        togbtn23.setSelected(false);
        togbtn24.setSelected(false);
        togbtn25.setSelected(false);
        togbtn26.setSelected(false);
        togbtn27.setSelected(false);
        togbtn28.setSelected(false);
        togbtn29.setSelected(false);
        togbtn30.setSelected(false);
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        Transaction transObject = new Transaction();
        StarCashDrawerTest kick = new StarCashDrawerTest();
        String tTotal = textTotal.getText();
        if (tTotal.isEmpty()){
            JOptionPane.showMessageDialog(this, "Can't close when nothing sold");
        }else{
            total1 = Double.parseDouble(textTotal.getText()); 
        }
           
            try {
                setTotal(total1);
                transObject.TransClose();
                //ticketsObject.closeSale();
                //ticketsObject.getSale();
            } catch (Exception ex) {
                Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(total1 >= 0){
                JOptionPane.showMessageDialog(this, "Collect: $" + total1);
                textLog.append("\n----------");
                textLog.append("\nCollect: " + total1);
                textLog.append("\n==========");
            }else if(total1 >= 0){
                JOptionPane.showMessageDialog(this, "Payout: $" + total1);
                textLog.append("\n----------");
                textLog.append("\nPayout: " + total1);
                textLog.append("\n==========");
            }
            total1 = 0;
            textTotal.setText("");
//            saleClosed = true;
            prize.setPrizetotal(0);
            togbtnSetEnabledFalse();
            StarReceiptTest print = new StarReceiptTest();
             if (btnPrintEvery.isSelected()){
                print.runTest();
                print.clearLines();
             }else{
                 print.clearLines();
             }
             String soundName = "chaching.wav";    
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
             kick.run();
    }//GEN-LAST:event_btnCloseActionPerformed
    public void setTotal(double total){
        this.total1 = total;
        System.out.println("Stored total: " +total1);
        System.out.println("Recieved total:" +total);
    }
    public double getTotal()
    {
        return total1;
    }
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        subtotal = 0;
        LOGGER.info("User pressed the clear button, setting subtotal to 0");
        textDisplay.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnEditTickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTickActionPerformed
        //TODO:edit the selected ticket from toggle button, if more than one, deselect all and pop up error message
        TicketsEditor edittick = new TicketsEditor();
        edittick.setVisible(true);
    }//GEN-LAST:event_btnEditTickActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here: Delete invoice number
        // 
        // SQL find invoice number
        // look up serial number of games, minus from gross, add to unsold amt and unsold tickets
    }//GEN-LAST:event_jButton8ActionPerformed
    public static void addTextLog(String text){
        textLog.append(text);
    }
    public int getButton(){
        if(togbtn1.isSelected()){
            bin = 1;
            } else if (togbtn2.isSelected()){
            bin = 2;
            } else if(togbtn3.isSelected()){
            bin = 3;
            } else if(togbtn4.isSelected()){
            bin = 4;
            } else if(togbtn5.isSelected()){
            bin = 5;
            } else if(togbtn6.isSelected()){
            bin = 6;
            } else if(togbtn7.isSelected()){
            bin = 7;
            } else if(togbtn8.isSelected()){
            bin = 8;
            } else if(togbtn9.isSelected()){
            bin = 9;
            } else if(togbtn10.isSelected()){
            bin = 10;
            } else if(togbtn11.isSelected()){
            bin = 11;
            } else if(togbtn12.isSelected()){
            bin = 12;
            } else if(togbtn13.isSelected()){
            bin = 13;
            } else if(togbtn14.isSelected()){
            bin = 14;
            } else if(togbtn15.isSelected()){
            bin = 15;
            } else if(togbtn16.isSelected()){
            bin = 16;
            } else if(togbtn17.isSelected()){
            bin = 17;
            } else if(togbtn18.isSelected()){
            bin = 18;
            } else if(togbtn19.isSelected()){
            bin = 19;
            } else if(togbtn20.isSelected()){
            bin = 20;
            } else if(togbtn21.isSelected()){
            bin = 21;
            } else if(togbtn22.isSelected()){
            bin = 22;
            } else if(togbtn23.isSelected()){
            bin = 23;
            } else if(togbtn24.isSelected()){
            bin = 24;
            } else if(togbtn25.isSelected()){
            bin = 25;
            } else if(togbtn26.isSelected()){
            bin = 26;
            } else if(togbtn27.isSelected()){
            bin = 27;
            } else if(togbtn28.isSelected()){
            bin = 28;
            } else if(togbtn29.isSelected()){
            bin = 29;
            } else if(togbtn30.isSelected()){
            bin = 30;
        } else{
            System.err.println("No game selected");
        }
        return bin;
    }
    private boolean isSelected(){
        if(togbtn1.isSelected() || togbtn2.isSelected() || togbtn3.isSelected() || togbtn4.isSelected() || togbtn5.isSelected() || togbtn6.isSelected() || togbtn7.isSelected() || togbtn8.isSelected()){
            selected = true;
        } else{
            System.err.println("No game selected");
            JOptionPane.showMessageDialog(this, "No game select");
        }
        return selected;
    }
    private void btnPrizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrizeActionPerformed
        bin = 0;
        bin = getButton(); //gets what button is selected to load the correct prizes for correct game
        if(bin == 0){
            JOptionPane.showMessageDialog(this, "No game selected");
            System.err.println("No game selected");
        }else{
        prize.DBconnect(bin);//sends bin number to prize loading method
        prize.setVisible(true);//create prize selection window
        }
    }//GEN-LAST:event_btnPrizeActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String testing2 = "Test2";
        addTextLog(testing2);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void negativebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativebtnActionPerformed
        //TODO http://stackoverflow.com/questions/9648153/error-with-negative-numbers-in-textfield
        
    }//GEN-LAST:event_negativebtnActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
       //Select this button, gets the total from total2 variable and subtracts the change 
        new Tender().setVisible(true);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        //adjust start bank
         String bankStart = bankText.getText();
        PreparedStatement updateBankStart = null;
        String updateBank_Start = "INSERT INTO sale_sessions(start_bank) VALUES (?)";
        try{
            con = DbConnect.getConnection();
            updateBankStart = con.prepareStatement(updateBank_Start,Statement.RETURN_GENERATED_KEYS);
            updateBankStart.setString(1, bankStart);
            updateBankStart.executeUpdate();
            rs = updateBankStart.getGeneratedKeys();
            
            if(rs.next()){
                generatedKey = rs.getInt(1);
              
            }
            System.out.println("Inserted record's ID: " + generatedKey);
            LOGGER.log(Level.INFO, "Inserted into start cash: {0}", bankStart);
            textLog.append("\n**********");
            textLog.append("\nAdded starting cash: " + bankStart);
            textLog.append("\n**********");
        }catch (Exception e) { e.printStackTrace(); }
    }//GEN-LAST:event_jButton12ActionPerformed
    public void setDisplay(int amount){
        String str = Double.toString(amount);
        textDisplay.setText(str);
    }
    public void setTotal(int amount){
        System.out.println("Settotal method amount: " + amount );
        String str = Double.toString(amount);
        textTotal.setText(str);
    }
    private void togbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togbtn1ActionPerformed

    }//GEN-LAST:event_togbtn1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DoConnect();
        textLog.append("****REFRESHED****");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        int t_id, samount=0, pamount=0, closed=0,unsold1 =0, unsold2 =0,prizes=0, prizes2, utickets=0,utickets2=0, gross=0, gross2 = 0;
        double total = 0;
        PreparedStatement voidSale = null;
        PreparedStatement voidSale2 = null;
        PreparedStatement selectBad = null;
        PreparedStatement reverse = null;
        String voidSaleString = "SELECT serial, sale_amount, prize_amount, sale_closed, MAX(t_id) AS TID from till_tape WHERE t_id = (SELECT MAX(t_id) AS TID from till_tape)";
        String voidSaleString2 = "DELETE FROM till_tape WHERE t_id = ?";
        String selectBadTicket = "SELECT `Unsold_amt`,`Actual_gross`,`Actual_prizes`, `Unsold_tickets` FROM `tickets` WHERE `Serial` = ?";
        String reverseTickets = "UPDATE tickets set unsold_amt = ?, actual_gross = ?, actual_prizes = ?, unsold_tickets = ? WHERE 'serial' = ?";
        try{
        
        con = DbConnect.getConnection();
        voidSale = con.prepareStatement(voidSaleString);
        voidSale2 = con.prepareStatement(voidSaleString2);
        selectBad = con.prepareStatement(selectBadTicket);
        reverse = con.prepareStatement(reverseTickets);
//        c.setAutoCommit(false);
        rs = voidSale.executeQuery();
        rs.next();
        t_id = rs.getInt("TID");
        String serial2 = rs.getString("serial");
        samount = rs.getInt("sale_amount");
        pamount = rs.getInt("prize_amount");
        closed = rs.getInt("sale_closed");
        voidSale2.setInt(1, t_id);
        voidSale2.executeUpdate();
        total = getTotal();
        total = total - samount;
        setTotal(total);
        if(closed == 1){
        selectBad.setString(1,serial2);
        rs = selectBad.executeQuery();
        rs.next();
        unsold1 = rs.getInt("Unsold_amt");
        gross = rs.getInt("actual_gross");
        prizes = rs.getInt("actual_prizes");
        utickets = rs.getInt("unsold_tickets");
        unsold2 = unsold1 + samount;
        utickets2 = utickets + samount;
        gross2 = gross - samount;
        prizes2 = prizes - pamount;
        reverse.setInt(1, unsold2);
        reverse.setInt(2, gross2);
        reverse.setInt(3, prizes2);
        reverse.setInt(4, utickets2);
        reverse.setString(5, serial2);
        reverse.executeUpdate(); 
        }
        
        rs.close();
        
        LOGGER.log(Level.INFO, "Deleted from till tape: {0}", t_id);
        textLog.append("\n**********");
        textLog.append("\nDeleted t_id: " + t_id);
        textLog.append("\n Old unsold amount: " + unsold1 + " New amount: " + unsold2);
        textLog.append("\n Old actual gross: " + gross + " New gross: " + gross2);
        textLog.append("\n**********");
        setTotal(0);
        textTotal.setText("");
//        c.commit();
        }catch (Exception e) { e.printStackTrace(); }
                                           

    }//GEN-LAST:event_btnUndoActionPerformed

    private void btnPrintEveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintEveryActionPerformed
        
        if (btnPrintEvery.isSelected()){
            textLog.append("\n ***********");
        textLog.append("\n Printing enabled");
        textLog.append("\n ***********");
        } else{
            textLog.append("\n ***********");
        textLog.append("\n Printing disabled ");
        textLog.append("\n ***********");
        }
    }//GEN-LAST:event_btnPrintEveryActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        StarCashDrawerTest kick = new StarCashDrawerTest();
        kick.run();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void textDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDisplayActionPerformed

    private void btnCloseCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseCashActionPerformed
        //adjust start bank
        String bankclose = closingfield.getText();
        PreparedStatement updateBankclosing = null;
        PreparedStatement findHiPS = null;
        String updateBank_closing = "UPDATE sale_sessions SET endingbank =? WHERE id =?";
        String findHi = "SELECT MAX(id) as ID FROM sale_sessions WHERE endingbank = 0";
        try{
            con = DbConnect.getConnection();
            findHiPS = con.prepareStatement(findHi);
            rs = findHiPS.executeQuery();
            rs.next();
            int num = rs.getInt("ID");
            updateBankclosing = con.prepareStatement(updateBank_closing);
            
            updateBankclosing.setString(1, bankclose);
            updateBankclosing.setInt(2, num);
            updateBankclosing.executeUpdate();
            LOGGER.log(Level.INFO, "Inserted into closing cash: {0}", bankclose);
            textLog.append("\n**********");
            textLog.append("\nAdded closing cash: " + bankclose + " to id: " + num);
            textLog.append("\n**********");
            closingfield.setText("");
        }catch (Exception e) { e.printStackTrace(); }
     
    }//GEN-LAST:event_btnCloseCashActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here: Change to kick drawer 2
        StarCashDrawerTest kick = new StarCashDrawerTest();
        kick.run();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void btnAddRemCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRemCashActionPerformed
        // TODO add your handling code here:
        String amount = jTFaddcash.getText();
        int intadjamt = Integer.parseInt(amount);
        PreparedStatement updateBankamt = null;
        PreparedStatement findHiPS = null;
        PreparedStatement selectAmounts = null;
        String selectString = "SELECT * FROM sale_sessions where ID = ?";
        String updateBank_amt = "UPDATE sale_sessions SET start_bank =?, currentbank = ? WHERE id =?";
        String findHi = "SELECT MAX(id) as ID FROM sale_sessions";
        try{
            con = DbConnect.getConnection();
            findHiPS = con.prepareStatement(findHi);
            rs = findHiPS.executeQuery();
            rs.next();
            int num = rs.getInt("ID");
            selectAmounts = con.prepareStatement(selectString);
            selectAmounts.setInt(1, num);
            rs = selectAmounts.executeQuery();
            rs.next();
            int startbank = rs.getInt("start_bank");
            int currentbank = rs.getInt("currentbank");
            startbank = startbank + intadjamt;
            currentbank = currentbank + intadjamt;
            updateBankamt = con.prepareStatement(updateBank_amt);
            updateBankamt.setInt(1, startbank);
            updateBankamt.setInt(2, currentbank);
            updateBankamt.setInt(3, num);
            updateBankamt.executeUpdate();
            LOGGER.log(Level.INFO, "Updated cash amounts, starting: {0} and current: {1}", new Object[]{startbank, currentbank});
            textLog.append("\n**********");
            textLog.append("\nAdded/Removed cash: " + intadjamt + " to id: " + num);
            textLog.append("\n**********");
            jTFaddcash.setText("");
        }catch (Exception e) { e.printStackTrace(); }
    }//GEN-LAST:event_btnAddRemCashActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        (new Thread(new Selling())).start();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Selling().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bankText;
    private javax.swing.JButton btnAddRemCash;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCloseCash;
    private javax.swing.JButton btnEditTick;
    private javax.swing.JButton btnEight;
    private javax.swing.JButton btnFifty;
    private javax.swing.JButton btnFive;
    private javax.swing.JButton btnFour;
    private javax.swing.JButton btnHundred;
    private javax.swing.JButton btnNine;
    private javax.swing.JButton btnOne;
    private javax.swing.JToggleButton btnPrintEvery;
    private javax.swing.JButton btnPrize;
    private javax.swing.JButton btnSale;
    private javax.swing.JButton btnSeven;
    private javax.swing.JButton btnSix;
    private javax.swing.JButton btnTen;
    private javax.swing.JButton btnThree;
    private javax.swing.JButton btnTwenty;
    private javax.swing.JButton btnTwo;
    private javax.swing.JButton btnUndo;
    private javax.swing.JButton btnZero;
    private javax.swing.JTextField closingfield;
    private javax.swing.JLabel currentTime;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFaddcash;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton negativebtn;
    private javax.swing.JPanel pnlAmount;
    public static javax.swing.JTextField textDisplay;
    public static javax.swing.JTextArea textLog;
    public static javax.swing.JTextField textTotal;
    private javax.swing.JLabel timeLabel;
    public javax.swing.JToggleButton togbtn1;
    private javax.swing.JToggleButton togbtn10;
    private javax.swing.JToggleButton togbtn11;
    private javax.swing.JToggleButton togbtn12;
    private javax.swing.JToggleButton togbtn13;
    private javax.swing.JToggleButton togbtn14;
    private javax.swing.JToggleButton togbtn15;
    private javax.swing.JToggleButton togbtn16;
    private javax.swing.JToggleButton togbtn17;
    private javax.swing.JToggleButton togbtn18;
    private javax.swing.JToggleButton togbtn19;
    private javax.swing.JToggleButton togbtn2;
    private javax.swing.JToggleButton togbtn20;
    private javax.swing.JToggleButton togbtn21;
    private javax.swing.JToggleButton togbtn22;
    private javax.swing.JToggleButton togbtn23;
    private javax.swing.JToggleButton togbtn24;
    private javax.swing.JToggleButton togbtn25;
    private javax.swing.JToggleButton togbtn26;
    private javax.swing.JToggleButton togbtn27;
    private javax.swing.JToggleButton togbtn28;
    private javax.swing.JToggleButton togbtn29;
    private javax.swing.JToggleButton togbtn3;
    private javax.swing.JToggleButton togbtn30;
    private javax.swing.JToggleButton togbtn4;
    private javax.swing.JToggleButton togbtn5;
    private javax.swing.JToggleButton togbtn6;
    private javax.swing.JToggleButton togbtn7;
    private javax.swing.JToggleButton togbtn8;
    private javax.swing.JToggleButton togbtn9;
    // End of variables declaration//GEN-END:variables
}
