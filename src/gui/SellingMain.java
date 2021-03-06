package gui;

//import Util.CashDrawerKick;
import dao.*;
import entity.*;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*

package gui;

import Tickets.editor.TicketsEditor;

/**
 *
 * @author Switcher
 */

public class SellingMain extends javax.swing.JFrame  {


    private final Logger logger = Logger.getLogger(SellingMain.class);
    public static int invoice;
    public static boolean saleClosed = true;
    public static int sessionNum;
    private int bin = 0;
    private double total = 0;
    private int subtotal = 0;
    public static List<TxObject> lst;
    public static List<Tickets> tkList;
    public static TxObject txObject;

    public static GameTemplateDAO gtDAO;
    public static GameTemplates gt;
    public static Tickets tk;
    public static TicketDAO tkDAO;
    public static Customers cust;
    public static Transaction tx;
    public static Users usr;
    public static SaleSessions ss;
    public static SaleSessDAO ssDAO;
    public static Locations loc;
    public static CustomerDAO custDAO;
    public static TillTapeDAO ttDAO;

    public SellingMain() {
     //   StdOutErr console = new StdOutErr();
    //    console.setVisible(true);
     //   PropertyConfigurator.configure("log4j.properties");
        //BasicConfigurator.configure();
        lst = new ArrayList<>();
        logger.info("Start up");
        //get logged in user
        //get current sales session
        initComponents();
        //PrintOutErrStream poes = new PrintOutErrStream(this.textLog);
        //System.setErr(new PrintStream(poes, true));
        //System.setOut(new PrintStream(poes, true));

        //Setup timer to run tickTock() every half second.
        Timer timer = new Timer(500, e -> tickTock());
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();
        reloadGameButtons();




   }
    public void tickTock() {
        currentTime.setText(DateFormat.getDateTimeInstance().format(new Date()));
    }

    public static void addTextLog(String text) {
        //Update the text log on the side
        textLog.append(text);
    }
    public void reloadGameButtons(){
        //Load list of games in play in bins 1 to 30
        tk = new Tickets();
        tkDAO = new TicketDAO();
        gt = new GameTemplates();
        gtDAO = new GameTemplateDAO();
        tkList = tkDAO.get30Tickets();

        String[] bins;
        bins = new String[31];
        String[] names;
        names = new String[31];
        String[] partNum;
        partNum = new String[31];


        //Loop through to set the serial and game names
        for (Tickets aTkList : tkList) {
            tk = aTkList;
            int binNum = tk.getBin();
            bins[binNum] = tk.getId().getSerial();
            partNum[binNum] = tk.getId().getGameTemplatesPartNum();
            gt = gtDAO.getGTById(partNum[binNum]);
            names[binNum] = gt.getGameName();
            System.out.println("Bin num: " + binNum + " Serial: " + bins[binNum]);

        }
        //Set the buttons to game names and serials
        togbtn1.setText(formatString(names[1], bins[1]));
        togbtn2.setText(formatString(names[2], bins[2]));
        togbtn3.setText(formatString(names[3], bins[3]));
        togbtn4.setText(formatString(names[4], bins[4]));
        togbtn5.setText(formatString(names[5], bins[5]));
        togbtn6.setText(formatString(names[6], bins[6]));
        togbtn7.setText(formatString(names[7], bins[7]));
        togbtn8.setText(formatString(names[8], bins[8]));
        togbtn9.setText(formatString(names[9], bins[9]));
        togbtn10.setText(formatString(names[10], bins[10]));
        togbtn11.setText(formatString(names[11], bins[11]));
        togbtn12.setText(formatString(names[12], bins[12]));
        togbtn13.setText(formatString(names[13], bins[13]));
        togbtn14.setText(formatString(names[14], bins[14]));
        togbtn15.setText(formatString(names[15], bins[15]));
        togbtn16.setText(formatString(names[16], bins[16]));
        togbtn17.setText(formatString(names[17], bins[17]));
        togbtn18.setText(formatString(names[18], bins[18]));
        togbtn19.setText(formatString(names[19], bins[19]));
        togbtn20.setText(formatString(names[20], bins[20]));
        togbtn21.setText(formatString(names[21], bins[21]));
        togbtn22.setText(formatString(names[22], bins[22]));
        togbtn23.setText(formatString(names[23], bins[23]));
        togbtn24.setText(formatString(names[24], bins[24]));
        togbtn25.setText(formatString(names[25], bins[25]));
        togbtn26.setText(formatString(names[26], bins[26]));
        togbtn27.setText(formatString(names[27], bins[27]));
        togbtn28.setText(formatString(names[28], bins[28]));
        togbtn29.setText(formatString(names[29], bins[29]));
        togbtn30.setText(formatString(names[30], bins[30]));
        logger.info("Games Loaded to buttons");
    }


    private void btnPrizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrizeActionPerformed
        //TODO: if the @ is in the text box, loop the value that many times.
        tx = new Transaction();
        tk = new Tickets();
        usr = new Users();
        cust = new Customers();
        loc = new Locations();
        ssDAO = new SaleSessDAO();
        ss = new SaleSessions();
        custDAO = new CustomerDAO();
        bin = getButton();


        getSubTotal();
        //Check if prize is in game
        tk = tx.getTicketBin(bin);
        //Is the prize entered a prize from the game template? if not, override?
        boolean templatePrize = tx.findPrizeAmt(tk, subtotal);
        logger.warn("Found prize amount? " + templatePrize);
        //TODO:if subtotal is negative then we need a reverse prize
        if (!templatePrize) {
            int response = JOptionPane.showConfirmDialog(null, "No prize found. Do you want to continue?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                System.out.println("No button clicked");
                return;
            } else if (response == JOptionPane.YES_OPTION) {
                System.out.println("Yes button clicked");
            } else if (response == JOptionPane.CLOSED_OPTION) {
                System.out.println("JOptionPane closed");
            }
        }
        checkForInvoice();
        total = total - subtotal;
        textDisplay.setText("");
        textTotal.setText(Double.toString(total));
        if (cust.getCustId() == null) {
            cust.setCustId(3);
        }
        //Update the customers
        updateCustomersPrizes();

        //check if there is already an invoice, if not create
        if (saleClosed) {
            invoice = tx.getInvoice();
            saleClosed = false;
        }
        //Set default location and user for now...
        usr.setUserId(3);
        loc.setLocId(1);

        addTextLog("\nPRIZE: " + bin + " : " + tk.getId().getSerial() + "\n Amount: " + subtotal);

        logger.info("Added prize to array: Bin: " + bin + "Amount : " + subtotal);
        txObject = new TxObject(bin, subtotal, 2);
        lst.add(txObject);

        togbtnSetEnabledFalse();
        subtotal = 0;
        tk = null;
        ss = null;
        bin = 0;

    }//GEN-LAST:event_btnPrizeActionPerformed

    private void updateCustomersPrizes() {
        Collection<JToggleButton> custButtons = Arrays.asList(cust1,cust2,cust3,cust4,cust5,cust6,cust7,cust8);
        for (JToggleButton button : custButtons) {
            if (button.isSelected()) {
                String cusID = button.getText();
                cust = custDAO.getCustById(cusID);
                int prizes = cust.getTotalPrizes();
                cust.setTotalPrizes(prizes + subtotal);
                custDAO.updateCustomer(cust);
                logger.info("Updated customer prize amount cust id: " + cusID);
            }
        }
    }

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed

        //TODO: if no button selected dont do anything
        //TODO: if sale session = 0 get current open sale session
        //Set up objects
        usr = new Users();
        cust = new Customers();
        loc = new Locations();
        tk = new Tickets();
        ssDAO = new SaleSessDAO();
        ss = new SaleSessions();
        custDAO = new CustomerDAO();


        //If sale session has not been started by start bank button then fetch a possible open session.
        //TODO:Doesn't work?
        if (sessionNum == 0) {
            ss = ssDAO.fetchOpenSS();
            System.out.println("sale session feteched: " + ss.getId());
        }
        //Check if buttons have a game assigned to them
        Collection<JToggleButton> gameBtns = Arrays.asList(togbtn1, togbtn2, togbtn3, togbtn4,togbtn5,togbtn6,togbtn7,togbtn8,togbtn9,togbtn10,togbtn11,togbtn12,togbtn13,togbtn14,togbtn15,togbtn16,togbtn17,togbtn18,togbtn19,togbtn20,togbtn21,togbtn22,
                togbtn23,togbtn24,togbtn25,togbtn26, togbtn27, togbtn28,togbtn29,togbtn30);
        for (JToggleButton gameButton : gameBtns){
            if (gameButton.isSelected()) {
                if (gameButton.getText().contains("*")) {
                    System.out.println("Empty game selected");
                    JOptionPane.showMessageDialog(null, "Empty game selected");
                    logger.warn("Empty game selected");
                    return;
                }
            }

        }
        //TODO: If more then one button selected cycle through them all


        //If collection of buttons from getText is equal to * then error.
        //Get the button selected, will show message dialog if no game is selected.
        if (bin == 0) {
            bin = getButton();
        }
        getSubTotal();


        //TODO:needs to be sale * the cost of the tickets
        //double valueOfTicket = gt.getTicketCost();// wont work because need better method to get a complete "Game"
        total = total + subtotal;
        textDisplay.setText("");
        textTotal.setText(Double.toString(total) + "0");

        //Update the customers
        Collection<JToggleButton> custButtons = Arrays.asList(cust1,cust2,cust3,cust4,cust5,cust6,cust7,cust8);
        for (JToggleButton button : custButtons) {
            if (button.isSelected()) {
                String cusID = button.getText();
                cust = custDAO.getCustById(cusID);
                int sales = cust.getTotalSales();
                cust.setTotalSales(sales + subtotal);
                custDAO.updateCustomer(cust);
                logger.info("Updated  sale customer id:" + cust.getCustId() + "value: " + subtotal);
            }
        }
        usr.setUserId(3);
        loc.setLocId(1);
        //Use text box instead of toggle buttons
//        if (custIDtxt.getText() == ""){
//            cust.setCustId(Integer.valueOf(custIDtxt.getText()));
//        }
        //if the cust is not set and the text box is empty use the default customer.
        if (cust.getCustId() == null) {
            cust.setCustId(3);
        }
        tx = new Transaction();
        tk = tx.getTicketBin(bin);
        checkForInvoice();
        addTextLog("\nSALE: " + bin + " : " + tk.getId().getSerial() + "\n Amount: " + subtotal);
        //check if there is already an invoice, if not create


        //Add the sale to list of Transaction
        txObject = new TxObject(bin, subtotal, 1);
        lst.add(txObject);
        logger.info("Added to array:Bin:  " + bin + " Amount: " + subtotal);

        togbtnSetEnabledFalse();
        //Set values to 0 to prepare for next sale
        subtotal = 0;
        tk = null;
        ss = null;
        bin = 0;

    }//GEN-LAST:event_btnSaleActionPerformed

    private void getSubTotal() {
        try{
            String subText = textDisplay.getText();
            subtotal = Integer.valueOf(subText);
        }catch (NumberFormatException nfe){
            logger.warn("No Value");
            logger.error(nfe);
            JOptionPane.showMessageDialog(null, "Bad value entered");
        }catch (NullPointerException npe){
            JOptionPane.showMessageDialog(null, "Null value entered");
            logger.warn("Null Value");
            logger.error(npe);
        }
    }

    private void checkForInvoice() {
        if (saleClosed) {
            invoice = tx.getInvoice();
            saleClosed = false;
            invoiceLbl.setText(String.valueOf(invoice));
            addTextLog("\n===================");
            addTextLog("\nInvoice number: " + invoice);
            addTextLog("\n===================");
        }
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO:Get the total, close the invoice number, calculate payout or payin, update the log, print the reciept, kick the register.
        ttDAO = new TillTapeDAO();
        tx = new Transaction();

        boolean closed = tx.closeTransaction(lst);
        System.out.println("closed: " + closed);

        //close the till tape where invoice number  equal to:
        List<TillTape> ttlst = new ArrayList<>();
        ttlst = ttDAO.getAllTillTapeByInvoice(invoice);
        for (TillTape till : ttlst) {
            till.setSaleClosed(true);
            ttDAO.updateTillTape(till);

        }
        //Kick the cash drawer
//        CashDrawerKick cd = new CashDrawerKick();
//        cd.run();

        //Display message to collect or payout
        if (total <= 0) {
            JOptionPane.showMessageDialog(null, "Payout: " + total);
            addTextLog("\n===================");
            addTextLog("\n Payout: " + total);
            addTextLog("\n===================");
        } else {
            JOptionPane.showMessageDialog(null, "Collect: " + total);
            addTextLog("\n===================");
            addTextLog("\n Collect: " + total);
            addTextLog("\n===================");

        }
        logger.info("Closed invoice num: " + invoice + " Amount " + total);

        //Set values to 0 and clear forms
        invoice = 0;
        subtotal = 0;
        total = 0;
        saleClosed = true;
        textTotal.setText("");
        textDisplay.setText("");
        clearButtons();
        lst.clear();

    }
    public void clearButtons(){
        cust1.setSelected(false);
        cust2.setSelected(false);
        cust3.setSelected(false);
        cust4.setSelected(false);
        cust5.setSelected(false);
        cust6.setSelected(false);
        cust7.setSelected(false);
        cust8.setSelected(false);
    }

    private String formatString(String name, String serial){
        if (name == null) {
            name = "*";
        }
        if (serial == null) {
            serial = "*";
        }
        String label = "<html>" + name + "<br>" + serial + "</html>";
        return label;
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cust1 = new javax.swing.JToggleButton();
        cust2 = new javax.swing.JToggleButton();
        cust3 = new javax.swing.JToggleButton();
        cust4 = new javax.swing.JToggleButton();
        cust5 = new javax.swing.JToggleButton();
        cust6 = new javax.swing.JToggleButton();
        cust7 = new javax.swing.JToggleButton();
        cust8 = new javax.swing.JToggleButton();
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
        tenderBtn = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        textDisplay = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        textTotal = new javax.swing.JTextField();
        btnEditTick = new javax.swing.JButton();
        invoiceLbl = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        negativebtn = new javax.swing.JButton();
        startBankBtn = new javax.swing.JButton();
        bankText = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        btnPrintEvery = new javax.swing.JToggleButton();
        kickDrawer1 = new javax.swing.JButton();
        closingfield = new javax.swing.JTextField();
        closingCashBtn = new javax.swing.JButton();
        kickDrawer2 = new javax.swing.JButton();
        jTFaddcash = new javax.swing.JTextField();
        addCashBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        custIDtxt = new javax.swing.JTextField();
        setCustBtn = new javax.swing.JButton();
        setSSIDBtn = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        atButton = new javax.swing.JButton();
        moveButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        timeLabel = new javax.swing.JLabel();
        currentTime = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Selling");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Transaction Log"));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        jPanel3.setToolTipText("Customers");
        jPanel3.setName("Customers"); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Customers:"));
        jPanel4.setName("Customers"); // NOI18N

        cust1.setText("4");

        cust2.setText("jToggleButton2");

        cust3.setText("jToggleButton3");

        cust4.setText("jToggleButton4");

        cust5.setText("jToggleButton5");

        cust6.setText("jToggleButton6");

        cust7.setText("jToggleButton7");

        cust8.setText("jToggleButton8");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cust1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cust5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cust6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cust7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cust8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cust2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cust3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cust4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cust2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cust3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cust4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cust1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cust5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cust6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cust7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cust8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 103, Short.MAX_VALUE))
        );

        jPanel4.getAccessibleContext().setAccessibleName("Customers");
        jPanel4.getAccessibleContext().setAccessibleDescription("");
        jPanel4.getAccessibleContext().setAccessibleParent(this);

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
                    .addComponent(togbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(togbtn13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(togbtn30, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(togbtn28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(togbtn29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        tenderBtn.setText("Tender change");
        tenderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenderBtnActionPerformed(evt);
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

        invoiceLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        invoiceLbl.setText("invoice#");

        jButton2.setText("Add Customer");
        jButton2.setEnabled(false);

        jButton4.setText("Reprint X invoice");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Reciept on/off");
        jButton5.setEnabled(false);

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
        negativebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativebtnActionPerformed(evt);
            }
        });

        startBankBtn.setText("Start bank");
        startBankBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBankBtnActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
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

        kickDrawer1.setText("Kick drawer 1");
        kickDrawer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kickDrawer1ActionPerformed(evt);
            }
        });

        closingCashBtn.setText("Closing Cash");
        closingCashBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closingCashBtnActionPerformed(evt);
            }
        });

        kickDrawer2.setText("Kick drawer 2");
        kickDrawer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kickDrawer2ActionPerformed(evt);
            }
        });

        addCashBtn.setText("Add/Rem Cash");
        addCashBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCashBtnActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel24.setText("Invoice:");

        jLabel40.setText("Set cusomter number to button:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", " " }));

        jLabel41.setText("Set by ID number:");

        setCustBtn.setText("Set");
        setCustBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setCustBtnActionPerformed(evt);
            }
        });

        setSSIDBtn.setText("Set SS id");
        setSSIDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setSSIDBtnActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel42.setText("Select an ID:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        atButton.setText("@");

        moveButton.setText("Move");

        javax.swing.GroupLayout pnlAmountLayout = new javax.swing.GroupLayout(pnlAmount);
        pnlAmount.setLayout(pnlAmountLayout);
        pnlAmountLayout.setHorizontalGroup(
            pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAmountLayout.createSequentialGroup()
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAmountLayout.createSequentialGroup()
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
                                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(negativebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnPrintEvery))))
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel24)
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addComponent(invoiceLbl))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAmountLayout.createSequentialGroup()
                                .addComponent(btnSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEight, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tenderBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAmountLayout.createSequentialGroup()
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addComponent(btnFour, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnFive, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addComponent(atButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAmountLayout.createSequentialGroup()
                                        .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnThree, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnSix, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnNine, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnFifty, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnHundred, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnTen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnTwenty, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(moveButton))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bankText, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(kickDrawer1)
                                                .addComponent(kickDrawer2, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jTFaddcash, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(closingfield, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(startBankBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(closingCashBtn)
                                    .addComponent(addCashBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(setSSIDBtn))
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnPrize, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnEditTick)
                                            .addComponent(jButton2)
                                            .addComponent(jButton5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton9)
                                        .addGap(4, 4, 4)
                                        .addComponent(jButton8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addGroup(pnlAmountLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton7)))
                                .addGap(33, 33, 33))))
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(custIDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(setCustBtn)))))
                .addContainerGap())
        );
        pnlAmountLayout.setVerticalGroup(
            pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAmountLayout.createSequentialGroup()
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel35)
                    .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceLbl)
                    .addComponent(jLabel24))
                .addGap(19, 19, 19)
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(atButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrize, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPrintEvery, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addComponent(btnTwenty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFifty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(negativebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHundred, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAmountLayout.createSequentialGroup()
                                .addComponent(kickDrawer1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kickDrawer2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bankText, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(startBankBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(moveButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(closingfield, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(closingCashBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTFaddcash, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCashBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnEditTick, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton4)
                            .addComponent(jButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addGroup(pnlAmountLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)))
                .addGap(18, 18, 18)
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(custIDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setCustBtn)
                    .addComponent(setSSIDBtn)))
        );

        jLabel3.setText("Seller:");

        jTextField2.setEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        timeLabel.setText("Time:");

        currentTime.setText("jLabel24");

        jLabel36.setText("jLabel36");

        jLabel37.setText("jLabel37");

        jLabel38.setText("jLabel38");

        jLabel39.setText("jLabel39");

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
                .addGap(18, 18, 18)
                .addComponent(pnlAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel38))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel37)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(timeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentTime)
                        .addGap(49, 49, 49))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeLabel)
                            .addComponent(currentTime))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {
        //Clears the display of any numbers
        textDisplay.setText(null);
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    public int getButton(){
        //Return the bin number based on the button
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
            logger.warn("No game button selected");
            JOptionPane.showMessageDialog(null, "No game button selected!");
        }
        return bin;
    }

    private void togbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togbtn1ActionPerformed

    }//GEN-LAST:event_togbtn1ActionPerformed

    private void addCashBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCashBtnActionPerformed
        // TODO: add/rem button
        ssDAO = new SaleSessDAO();
        ss = new SaleSessions();
        ss = ssDAO.getSSById(String.valueOf(sessionNum));
        ss.setCurrentbank(Double.valueOf(ss.getCurrentbank() + jTFaddcash.getText()));
        ssDAO.addSession(ss);
        jTFaddcash.setText("");
        addTextLog("Added/Removed cash: " + ss.getCurrentbank());
    }//GEN-LAST:event_addCashBtnActionPerformed

    private void kickDrawer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kickDrawer2ActionPerformed

    }//GEN-LAST:event_kickDrawer2ActionPerformed

    private void closingCashBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closingCashBtnActionPerformed
        //TODO: Closing cash button
        ssDAO = new SaleSessDAO();
        ss = new SaleSessions();
        ss = ssDAO.getSSById(String.valueOf(sessionNum));
        ss.setEndingbank(Double.valueOf(closingfield.getText()));
        ssDAO.addSession(ss);
        closingfield.setText("");
        addTextLog("Added closing cash: " + ss.getEndingbank());
    }//GEN-LAST:event_closingCashBtnActionPerformed

    private void kickDrawer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kickDrawer1ActionPerformed

    }//GEN-LAST:event_kickDrawer1ActionPerformed

    private void btnPrintEveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintEveryActionPerformed

    }//GEN-LAST:event_btnPrintEveryActionPerformed

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed

    }//GEN-LAST:event_btnUndoActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        addTextLog("\n===================");
        addTextLog("Buttons refreshed");
        addTextLog("\n===================");
        reloadGameButtons();

    }                                          

    private void startBankBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBankBtnActionPerformed

        //Add starting bank into sale sessions
        ssDAO = new SaleSessDAO();
        ss = new SaleSessions();
        ss.setStartBank(Double.valueOf(bankText.getText()));
        ss.setCurrentbank(Double.valueOf(bankText.getText()));
        ss.setGrossSales(0.0);
        ss.setGrossPrizes(0.0);
        ss.setGrossNet(0.0);
        ss.setDate(Transaction.getCurrentTimeStamp());
        ssDAO.addSession(ss);
        sessionNum = ss.getId();
        bankText.setText("");
        addTextLog("\n===================");
        addTextLog("\n Added start bank: " + ss.getCurrentbank());
        addTextLog("\n===================");
    }//GEN-LAST:event_startBankBtnActionPerformed

    private void negativebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativebtnActionPerformed
        //Sets the text box to a negative value
        String subText = textDisplay.getText();
        String newText = "-"+ subText;
        textDisplay.setText(newText);
    }//GEN-LAST:event_negativebtnActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        lst = new ArrayList<>();
        String subText = textDisplay.getText();
        subtotal = Integer.valueOf(subText);
        txObject = new TxObject(bin, subtotal, 2);
        lst.add(txObject);
        System.out.println(lst.get(0).getBin());
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here: Delete invoice number
        //
        // SQL find invoice number
        // look up serial number of games, minus from gross, add to unsold amt and unsold tickets
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnEditTickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTickActionPerformed
        //TODO:edit the selected ticket from toggle button, if more than one, deselect all and pop up error message
        //        TicketsEditor TE = new TicketsEditor();
        //        TE.setVisible(true);
    }//GEN-LAST:event_btnEditTickActionPerformed

    private void textDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDisplayActionPerformed

    }//GEN-LAST:event_textDisplayActionPerformed

    private void tenderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenderBtnActionPerformed

    }//GEN-LAST:event_tenderBtnActionPerformed

    private void btnHundredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHundredActionPerformed
        String btnHundredText = textDisplay.getText() + btnHundred.getText();
        textDisplay.setText(btnHundredText);
    }//GEN-LAST:event_btnHundredActionPerformed

    private void btnFiftyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiftyActionPerformed
        String btnFiftyText = textDisplay.getText() + btnFifty.getText();
        textDisplay.setText(btnFiftyText);
    }//GEN-LAST:event_btnFiftyActionPerformed

    private void btnTwentyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwentyActionPerformed
        String btnTwentyText = textDisplay.getText() + btnTwenty.getText();
        textDisplay.setText(btnTwentyText);
    }//GEN-LAST:event_btnTwentyActionPerformed

    private void btnTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTenActionPerformed
        String btnTenText = textDisplay.getText() + btnTen.getText();
        textDisplay.setText(btnTenText);
    }//GEN-LAST:event_btnTenActionPerformed

    private void btnZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZeroActionPerformed
        String btnZeroText = textDisplay.getText() + btnZero.getText();
        textDisplay.setText(btnZeroText);
    }//GEN-LAST:event_btnZeroActionPerformed

    private void btnNineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNineActionPerformed
        String btnNineText = textDisplay.getText() + btnNine.getText();
        textDisplay.setText(btnNineText);
    }//GEN-LAST:event_btnNineActionPerformed

    private void btnEightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEightActionPerformed
        String btnEightText = textDisplay.getText() + btnEight.getText();
        textDisplay.setText(btnEightText);
    }//GEN-LAST:event_btnEightActionPerformed

    private void btnSevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSevenActionPerformed
        String btnSevenText = textDisplay.getText() + btnSeven.getText();
        textDisplay.setText(btnSevenText);
    }//GEN-LAST:event_btnSevenActionPerformed

    private void btnSixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSixActionPerformed
        String btnSixText = textDisplay.getText() + btnSix.getText();
        textDisplay.setText(btnSixText);
    }//GEN-LAST:event_btnSixActionPerformed

    private void btnFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiveActionPerformed
        String btnFiveText = textDisplay.getText() + btnFive.getText();
        textDisplay.setText(btnFiveText);
    }//GEN-LAST:event_btnFiveActionPerformed

    private void btnFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFourActionPerformed
        String btnFourText = textDisplay.getText() + btnFour.getText();
        textDisplay.setText(btnFourText);
    }//GEN-LAST:event_btnFourActionPerformed

    private void btnThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThreeActionPerformed
        String btnThreeText = textDisplay.getText() + btnThree.getText();
        textDisplay.setText(btnThreeText);
    }//GEN-LAST:event_btnThreeActionPerformed

    private void btnTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoActionPerformed
        String btnTwoText = textDisplay.getText() + btnTwo.getText();
        textDisplay.setText(btnTwoText);
    }//GEN-LAST:event_btnTwoActionPerformed

    private void btnOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOneActionPerformed
        String btnOneText = textDisplay.getText() + btnOne.getText();
        textDisplay.setText(btnOneText);
    }//GEN-LAST:event_btnOneActionPerformed

    private void setCustBtnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_setCustBtnActionPerformed
        // TODO add your handling code here:
        String id = custIDtxt.getText();
        Collection<JToggleButton> custButtons = Arrays.asList(cust1,cust2,cust3,cust4,cust5,cust6,cust7,cust8);
        for (JToggleButton button : custButtons) {
            if (button.isSelected()) {
                button.setText(id);
                custIDtxt.setText("");

            }
        }
    }//GEN-LAST:event_setCustBtnActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void setSSIDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setSSIDBtnActionPerformed
        // TODO add your handling code here:
        sessionNum = Integer.parseInt(jTextField4.getText());
    }//GEN-LAST:event_setSSIDBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SellingMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellingMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellingMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellingMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellingMain().setVisible(true);

            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCashBtn;
    private javax.swing.JButton atButton;
    private javax.swing.JTextField bankText;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
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
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSale;
    private javax.swing.JButton btnSeven;
    private javax.swing.JButton btnSix;
    private javax.swing.JButton btnTen;
    private javax.swing.JButton btnThree;
    private javax.swing.JButton btnTwenty;
    private javax.swing.JButton btnTwo;
    private javax.swing.JButton btnUndo;
    private javax.swing.JButton btnZero;
    private javax.swing.JButton closingCashBtn;
    private javax.swing.JTextField closingfield;
    private javax.swing.JLabel currentTime;
    public javax.swing.JToggleButton cust1;
    public javax.swing.JToggleButton cust2;
    public javax.swing.JToggleButton cust3;
    public javax.swing.JToggleButton cust4;
    public javax.swing.JToggleButton cust5;
    public javax.swing.JToggleButton cust6;
    public javax.swing.JToggleButton cust7;
    public javax.swing.JToggleButton cust8;
    private javax.swing.JTextField custIDtxt;
    private javax.swing.JLabel invoiceLbl;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFaddcash;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton kickDrawer1;
    private javax.swing.JButton kickDrawer2;
    private javax.swing.JButton moveButton;
    private javax.swing.JButton negativebtn;
    private javax.swing.JPanel pnlAmount;
    private javax.swing.JButton setCustBtn;
    private javax.swing.JButton setSSIDBtn;
    private javax.swing.JButton startBankBtn;
    private javax.swing.JButton tenderBtn;
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
