/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*TODO:
 Need to create game template first then add to tickets table.
 */
package Tickets.TicketEditor;

import dao.GameTemplateDAO;
import db.HibernateUtil;
import entity.GameTemplates;
import entity.Tickets;
import javax.swing.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Switcher
 */
public class TicketsEditor extends javax.swing.JFrame {
        
    public TicketsEditor() {
        initComponents();          
        Tickets tk = new Tickets();
        GameTemplates gt = new GameTemplates();
        GameTemplateDAO gtDAO = new GameTemplateDAO();
    }

  
    private void setFieldsGT(GameTemplates gt) {
        textGame.setText(gt.getGameName());
        textPartNum.setText(gt.getId().getPartNum());
        textGameCost.setText(gt.getGameCost().toString());
        textCostTicket.setText(gt.getTicketCost().toString());
        textNumTickets.setText(gt.getNumTickets().toString());
        textIdealGross.setText(gt.getIdeaGross().toString());
        textIdealPrizes.setText(gt.getIdeaPrizes().toString());
        textIdealNet.setText(gt.getIdeaNet().toString());
        textDistID.setText(Integer.toString(gt.getId().getDistsIdDistId()));
        textManID.setText(Integer.toString(gt.getId().getMfgIdMfgId()));
        textLastSale.setText(gt.getLastSale().toString());
        textAllLast.setText(gt.getLastSaleAllow().toString());
        textAmt1.setText(gt.getPrizeAmt1().toString());
        textAmt2.setText(gt.getPrizeAmt1().toString());
        textAmt3.setText(gt.getPrizeAmt1().toString());
        textAmt4.setText(gt.getPrizeAmt1().toString());
        textAmt5.setText(gt.getPrizeAmt1().toString());
        textAmt6.setText(gt.getPrizeAmt1().toString());
        textAmt7.setText(gt.getPrizeAmt1().toString());
        textAmt8.setText(gt.getPrizeAmt1().toString());
        textAmt9.setText(gt.getPrizeAmt1().toString());
        textAmt10.setText(gt.getPrizeAmt10().toString());
        textAmt11.setText(gt.getPrizeAmt11().toString());
        textAmt12.setText(gt.getPrizeAmt12().toString());
        textAmt13.setText(gt.getPrizeAmt13().toString());
        textAmt14.setText(gt.getPrizeAmt14().toString());
        textAmt15.setText(gt.getPrizeAmt15().toString());
        textAll1.setText(gt.getPrizeAll1().toString());
        textAll2.setText(gt.getPrizeAll2().toString());
        textAll3.setText(gt.getPrizeAll3().toString());
        textAll4.setText(gt.getPrizeAll4().toString());
        textAll5.setText(gt.getPrizeAll5().toString());
        textAll6.setText(gt.getPrizeAll6().toString());
        textAll7.setText(gt.getPrizeAll7().toString());
        textAll8.setText(gt.getPrizeAll8().toString());
        textAll9.setText(gt.getPrizeAll9().toString());
        textAll10.setText(gt.getPrizeAll10().toString());
        textAll11.setText(gt.getPrizeAll11().toString());
        textAll12.setText(gt.getPrizeAll12().toString());
        textAll13.setText(gt.getPrizeAll13().toString());
        textAll14.setText(gt.getPrizeAll14().toString());
        textAll15.setText(gt.getPrizeAll15().toString());
    }
    private void fillFieldsT(Tickets tk){
        textSerial.setText(tk.getId().getSerial());
        textBin.setText(tk.getBin().toString());
        textUnsoldValue.setText(tk.getUnsoldAmt().toString());
      textActualGross.setText(tk.getActualGross().toString());
        textActualPrizes.setText(tk.getActualPrizes().toString());
        textActualNet.setText(tk.getActualNet().toString());
        textUnsoldTickets.setText(tk.getUnsoldTickets().toString());
        textLastRem.setText(tk.getLastSaleRem().toString());
        textRem1.setText(tk.getPrizeRem1().toString());
        textRem2.setText(tk.getPrizeRem2().toString());
        textRem3.setText(tk.getPrizeRem3().toString());
        textRem4.setText(tk.getPrizeRem4().toString());
        textRem5.setText(tk.getPrizeRem5().toString());
        textRem6.setText(tk.getPrizeRem6().toString());
        textRem7.setText(tk.getPrizeRem7().toString());
       textRem8.setText(tk.getPrizeRem8().toString());
        textRem9.setText(tk.getPrizeRem9().toString());
        textRem10.setText(tk.getPrizeRem10().toString());
        textRem11.setText(tk.getPrizeRem11().toString());
        textRem12.setText(tk.getPrizeRem12().toString());
        textRem13.setText(tk.getPrizeRem13().toString());
        textRem14.setText(tk.getPrizeRem14().toString());
        textRem15.setText(tk.getPrizeRem15().toString());
    }
  


    private void clearFields() {

        textGame.setText("");
        textPartNum.setText("");
        textGameCost.setText("");
        textCostTicket.setText("");
        textCostTicket.setText("");
        textNumTickets.setText("");
        textIdealGross.setText("");
        textIdealPrizes.setText("");
        textIdealNet.setText("");
        textDistID.setText("");
        textManID.setText("");
        textLastSale.setText("");
        textLastRem.setText("");
        textAmt1.setText("");
        textAmt2.setText("");
        textAmt3.setText("");
        textAmt4.setText("");
        textAmt5.setText("");
        textAmt6.setText("");
        textAmt7.setText("");
        textAmt8.setText("");
        textAmt9.setText("");
        textAmt10.setText("");
        textAll1.setText("");
        textAll2.setText("");
        textAll3.setText("");
        textAll4.setText("");
        textAll5.setText("");
        textAll6.setText("");
        textAll7.setText("");
        textAll8.setText("");
        textAll9.setText("");
        textAll10.setText("");
        textSerial.setText("");
        textBin.setText("");
        textUnsoldValue.setText("");
        textActualGross.setText("");
        textActualPrizes.setText("");
        textActualNet.setText("");
        textUnsoldTickets.setText("");
        textLastRem.setText("");
        textRem1.setText("");
        textRem2.setText("");
        textRem3.setText("");
        textRem4.setText("");
        textRem5.setText("");
        textRem6.setText("");
        textRem7.setText("");
        textRem8.setText("");
        textRem9.setText("");
        textRem10.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        textGame = new javax.swing.JTextField();
        textSerial = new javax.swing.JTextField();
        textPartNum = new javax.swing.JTextField();
        textGameCost = new javax.swing.JTextField();
        textManID = new javax.swing.JTextField();
        textInvoiceNum = new javax.swing.JTextField();
        textInvoiceDate = new javax.swing.JTextField();
        textDistID = new javax.swing.JTextField();
        textGameType = new javax.swing.JTextField();
        textUnsoldTickets = new javax.swing.JTextField();
        textUnsoldValue = new javax.swing.JTextField();
        textActualGross = new javax.swing.JTextField();
        textActualPrizes = new javax.swing.JTextField();
        textIdealGross = new javax.swing.JTextField();
        textIdealPrizes = new javax.swing.JTextField();
        textIdealNet = new javax.swing.JTextField();
        textActualNet = new javax.swing.JTextField();
        textNumTickets = new javax.swing.JTextField();
        textCostTicket = new javax.swing.JTextField();
        textDatePlaced = new javax.swing.JTextField();
        textDateRem = new javax.swing.JTextField();
        textBin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        textAll9 = new javax.swing.JTextField();
        textAll10 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        textAll7 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        textAll8 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        textAll5 = new javax.swing.JTextField();
        textAll6 = new javax.swing.JTextField();
        textAll3 = new javax.swing.JTextField();
        textAll4 = new javax.swing.JTextField();
        textAll11 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        textAmt1 = new javax.swing.JTextField();
        textAmt2 = new javax.swing.JTextField();
        textRem3 = new javax.swing.JTextField();
        textRem4 = new javax.swing.JTextField();
        textRem1 = new javax.swing.JTextField();
        textRem2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        textRem8 = new javax.swing.JTextField();
        textRem9 = new javax.swing.JTextField();
        textRem6 = new javax.swing.JTextField();
        textRem7 = new javax.swing.JTextField();
        textRem10 = new javax.swing.JTextField();
        textRem11 = new javax.swing.JTextField();
        textAll2 = new javax.swing.JTextField();
        textAll1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        textRem5 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        textAmt11 = new javax.swing.JTextField();
        textAmt10 = new javax.swing.JTextField();
        textAmt9 = new javax.swing.JTextField();
        textAmt8 = new javax.swing.JTextField();
        textAmt7 = new javax.swing.JTextField();
        textAmt6 = new javax.swing.JTextField();
        textAmt5 = new javax.swing.JTextField();
        textAmt3 = new javax.swing.JTextField();
        textAmt4 = new javax.swing.JTextField();
        textAll12 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        textRem15 = new javax.swing.JTextField();
        textRem14 = new javax.swing.JTextField();
        textAll14 = new javax.swing.JTextField();
        textAll15 = new javax.swing.JTextField();
        textRem13 = new javax.swing.JTextField();
        textAll13 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        textLastSale = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        textAmt14 = new javax.swing.JTextField();
        textRem12 = new javax.swing.JTextField();
        textAmt15 = new javax.swing.JTextField();
        textAmt13 = new javax.swing.JTextField();
        textAmt12 = new javax.swing.JTextField();
        textAllLast = new javax.swing.JTextField();
        textLastRem = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        textInplay = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnInplay = new javax.swing.JButton();
        btnGT = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");
        jMenu1.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textGame.setBackground(java.awt.Color.orange);
        textGame.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        textSerial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        textPartNum.setBackground(java.awt.Color.orange);

        textGameCost.setBackground(java.awt.Color.orange);

        textManID.setBackground(java.awt.Color.orange);

        textInvoiceNum.setBackground(java.awt.Color.orange);

        textInvoiceDate.setBackground(java.awt.Color.orange);
        textInvoiceDate.setText("0000-00-00");

        textIdealGross.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIdealGrossActionPerformed(evt);
            }
        });

        textIdealNet.setEditable(false);
        textIdealNet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIdealNetActionPerformed(evt);
            }
        });

        textDatePlaced.setText("0000-00-00");

        textDateRem.setText("0000-00-00");

        textBin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel1.setText("Game:");

        jLabel2.setText("Part Number:");

        jLabel3.setText("Manuf. ID:");

        jLabel4.setText("Serial:");

        jLabel5.setText("Game cost:");

        jLabel6.setText("Invoice Number:");

        jLabel7.setText("Invoice Date:");

        jLabel8.setText("Dist. ID:");

        jLabel9.setText("Game Type:");

        jLabel10.setText("Date placed:");

        jLabel11.setText("Date removed:");

        jLabel12.setText("Unsold tickets:");

        jLabel13.setText("Unsold value:");

        jLabel14.setText("Actual gross:");

        jLabel15.setText("Actual Prizes:");

        jLabel16.setText("Actual net:");

        jLabel17.setText("Number of tickets:");

        jLabel18.setText("Cost per ticket:");

        jLabel19.setText("Ideal gross:");

        jLabel20.setText("Ideal prizes:");

        jLabel21.setText("Ideal net:");

        jLabel22.setText("Bin:");

        textID.setEnabled(false);

        jLabel23.setText("Game id:");

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel ");
        btnCancel.setEnabled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel24.setText("Ticket Editor");

        jButton1.setText("Move to in play");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel25.setText("Prize 11:");

        jLabel26.setText("Prize 10:");

        jLabel27.setText("Prize 9:");

        jLabel28.setText("Prize 1:");

        jLabel29.setText("Prize 2:");

        jLabel30.setText("Prize 3:");

        jLabel31.setText("Prize 4:");

        jLabel32.setText("Prize 5:");

        jLabel33.setText("Prize 6:");

        jLabel34.setText("Prize 7:");

        jLabel35.setText("Prize 8:");

        jLabel36.setText("Remaining:");

        jLabel37.setText("Allowed:");

        jLabel38.setText("Amount:");

        jLabel39.setText("Prize 13:");

        jLabel40.setText("Prize 14:");

        jLabel41.setText("Prize 12:");

        jLabel42.setText("Prize 15:");

        jLabel43.setText("Last Sale:");

        jLabel44.setText("Amount:");

        jLabel45.setText("Allowed:");

        jLabel46.setText("Remaining:");

        jButton2.setText("Move to closed");
        jButton2.setEnabled(false);

        jButton3.setText("Move to instock");
        jButton3.setEnabled(false);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setText("CLOSE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        textInplay.setText(" ");

        jLabel47.setText("Inplay:");

        searchText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnInplay.setText("In play");
        btnInplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInplayActionPerformed(evt);
            }
        });

        btnGT.setText("Game Templates");
        btnGT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGTActionPerformed(evt);
            }
        });

        jMenu2.setText("File");

        jMenu4.setText("Templates");

        jMenuItem1.setText("Crazy Joes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenu2.add(jMenu4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textDistID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textManID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textNumTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textPartNum, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textCostTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(4, 4, 4)
                                .addComponent(textGameCost, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(4, 4, 4)
                                .addComponent(textInvoiceNum, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textInvoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addGap(4, 4, 4)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(textIdealPrizes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textIdealNet, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(63, 63, 63)
                                            .addComponent(textIdealGross, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textActualGross, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textActualPrizes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textActualNet, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textDateRem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textInplay, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(151, 151, 151)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textUnsoldTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textUnsoldValue, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel23)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textDatePlaced, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textAmt1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAmt2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAmt3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAmt4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAmt5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAmt6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAmt7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAmt8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAmt9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAmt10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAmt11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel38)))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textAll1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)
                            .addComponent(textAll2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textRem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(btnInplay, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 83, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(51, 51, 51))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(192, 192, 192))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textGame, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textBin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textGameType, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnGT, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textLastSale, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)
                            .addComponent(textAmt14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAmt15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAmt13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAmt12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textAll14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45)
                            .addComponent(textAllLast, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textRem15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)
                            .addComponent(textRem12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textLastRem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textSerial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel22)
                                    .addComponent(textBin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(textGameType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel23)
                                            .addComponent(textPartNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel17)
                                            .addComponent(textNumTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel18)
                                            .addComponent(textCostTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(textManID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(textDistID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel5)
                                                    .addComponent(textGameCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel7)
                                                    .addComponent(textInvoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel6)
                                                    .addComponent(textInvoiceNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(textInplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel47)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel19)
                                                    .addComponent(textIdealGross, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(textIdealPrizes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel20))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel21)
                                                    .addComponent(textIdealNet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10)
                                                    .addComponent(textDatePlaced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel12)
                                                    .addComponent(textUnsoldTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel13)
                                                    .addComponent(textUnsoldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(textActualGross, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel11)
                                            .addComponent(textDateRem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(textActualPrizes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(textActualNet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel46))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel41)
                                    .addComponent(textAmt12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAll12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textRem12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(textAmt13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAll13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textRem13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel40)
                                    .addComponent(textAmt14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAll14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textRem14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel42)
                                    .addComponent(textAmt15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAll15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textRem15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel43)
                                    .addComponent(textLastSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAllLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textLastRem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchText, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(193, 193, 193))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37)
                            .addComponent(jLabel36))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(textAmt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(textAmt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(textAmt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(textAmt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(textAmt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(textAmt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(textAmt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(textAmt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(textAmt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(textAmt10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(textAmt11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAll11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRem11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
    
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
       /* if (rowId <= tlist.size()) {
            rowId++;
            loadValuesT(tlist, rowId);
        } else {
            JOptionPane.showMessageDialog(null, ("Last"));
        }*/


    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
       /* if (rowId > 0) {
            rowId--;
            loadValuesT(tlist, rowId);
        } else {
            JOptionPane.showMessageDialog(null, ("First"));
        }*/

    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
 /*       rowId = tlist.size() - 1;
        loadValuesT(tlist, rowId);*/
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        btnFirst.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        btnLast.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnNew.setEnabled(false);

        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
        clearFields();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        btnFirst.setEnabled(true);
        btnPrevious.setEnabled(true);
        btnNext.setEnabled(true);
        btnLast.setEnabled(true);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnNew.setEnabled(true);
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            GameTemplates gt = new GameTemplates();
            gt.setGameName(textGame.getText());
            gt.setGameCost(Double.valueOf(textGameCost.getText()));
            gt.setTicketCost(Double.parseDouble(textCostTicket.getText()));
            gt.setNumTickets(Integer.parseInt(textNumTickets.getText()));
            gt.setIdeaGross(Integer.parseInt(textIdealGross.getText()));
            gt.setIdeaPrizes(Integer.parseInt(textIdealPrizes.getText()));
            gt.setIdeaNet(Integer.parseInt(textIdealNet.getText()));
            gt.setLastSale(Integer.parseInt(textLastSale.getText()));
            gt.setLastSaleAllow(Integer.parseInt(textAllLast.getText()));
            gt.setPrizeAmt1(Integer.parseInt(textAmt1.getText()));
            gt.setPrizeAmt2(Integer.parseInt(textAmt2.getText()));
            gt.setPrizeAmt3(Integer.parseInt(textAmt3.getText()));
            gt.setPrizeAmt4(Integer.parseInt(textAmt4.getText()));
            gt.setPrizeAmt5(Integer.parseInt(textAmt5.getText()));
            gt.setPrizeAmt6(Integer.parseInt(textAmt6.getText()));
            gt.setPrizeAmt7(Integer.parseInt(textAmt7.getText()));
            gt.setPrizeAmt8(Integer.parseInt(textAmt8.getText()));
            gt.setPrizeAmt9(Integer.parseInt(textAmt9.getText()));
            gt.setPrizeAmt10(Integer.parseInt(textAmt10.getText()));
            gt.setPrizeAll1(Integer.parseInt(textAll1.getText()));
            gt.setPrizeAll2(Integer.parseInt(textAll2.getText()));
            gt.setPrizeAll3(Integer.parseInt(textAll3.getText()));
            gt.setPrizeAll4(Integer.parseInt(textAll4.getText()));
            gt.setPrizeAll5(Integer.parseInt(textAll5.getText()));
            gt.setPrizeAll6(Integer.parseInt(textAll6.getText()));
            gt.setPrizeAll7(Integer.parseInt(textAll7.getText()));
            gt.setPrizeAll8(Integer.parseInt(textAll8.getText()));
            gt.setPrizeAll9(Integer.parseInt(textAll9.getText()));
            gt.setPrizeAll10(Integer.parseInt(textAll10.getText()));

            session.getTransaction().commit();
            session.close();
        } catch (HibernateException he) {
            he.printStackTrace();
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void textIdealNetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIdealNetActionPerformed

    }//GEN-LAST:event_textIdealNetActionPerformed

    private void textIdealGrossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIdealGrossActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIdealGrossActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        GameTemplates gt = new GameTemplates();
        GameTemplateDAO gtDAO = new GameTemplateDAO();
        gt = gtDAO.getGTById(searchText.getText());
        System.out.println("Game name:" + gt.getGameName());
        setFieldsGT(gt);

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnInplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInplayActionPerformed

    }//GEN-LAST:event_btnInplayActionPerformed

    private void btnGTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGTActionPerformed
      
    }//GEN-LAST:event_btnGTActionPerformed

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
            java.util.logging.Logger.getLogger(TicketsEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketsEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketsEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketsEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketsEditor().setVisible(true);
            }
        });
    }

    public JTextField getSearchText() {
        return searchText;
    }

    public void setSearchText(JTextField searchText) {
        this.searchText = searchText;
    }

    public JTextField getTextActualGross() {
        return textActualGross;
    }

    public void setTextActualGross(JTextField textActualGross) {
        this.textActualGross = textActualGross;
    }

    public JTextField getTextActualNet() {
        return textActualNet;
    }

    public void setTextActualNet(JTextField textActualNet) {
        this.textActualNet = textActualNet;
    }

    public JTextField getTextActualPrizes() {
        return textActualPrizes;
    }

    public void setTextActualPrizes(JTextField textActualPrizes) {
        this.textActualPrizes = textActualPrizes;
    }

    public JTextField getTextAll1() {
        return textAll1;
    }

    public void setTextAll1(JTextField textAll1) {
        this.textAll1 = textAll1;
    }

    public JTextField getTextAll10() {
        return textAll10;
    }

    public void setTextAll10(JTextField textAll10) {
        this.textAll10 = textAll10;
    }

    public JTextField getTextAll11() {
        return textAll11;
    }

    public void setTextAll11(JTextField textAll11) {
        this.textAll11 = textAll11;
    }

    public JTextField getTextAll12() {
        return textAll12;
    }

    public void setTextAll12(JTextField textAll12) {
        this.textAll12 = textAll12;
    }

    public JTextField getTextAll13() {
        return textAll13;
    }

    public void setTextAll13(JTextField textAll13) {
        this.textAll13 = textAll13;
    }

    public JTextField getTextAll14() {
        return textAll14;
    }

    public void setTextAll14(JTextField textAll14) {
        this.textAll14 = textAll14;
    }

    public JTextField getTextAll15() {
        return textAll15;
    }

    public void setTextAll15(JTextField textAll15) {
        this.textAll15 = textAll15;
    }

    public JTextField getTextAll2() {
        return textAll2;
    }

    public void setTextAll2(JTextField textAll2) {
        this.textAll2 = textAll2;
    }

    public JTextField getTextAll3() {
        return textAll3;
    }

    public void setTextAll3(JTextField textAll3) {
        this.textAll3 = textAll3;
    }

    public JTextField getTextAll4() {
        return textAll4;
    }

    public void setTextAll4(JTextField textAll4) {
        this.textAll4 = textAll4;
    }

    public JTextField getTextAll5() {
        return textAll5;
    }

    public void setTextAll5(JTextField textAll5) {
        this.textAll5 = textAll5;
    }

    public JTextField getTextAll6() {
        return textAll6;
    }

    public void setTextAll6(JTextField textAll6) {
        this.textAll6 = textAll6;
    }

    public JTextField getTextAll7() {
        return textAll7;
    }

    public void setTextAll7(JTextField textAll7) {
        this.textAll7 = textAll7;
    }

    public JTextField getTextAll8() {
        return textAll8;
    }

    public void setTextAll8(JTextField textAll8) {
        this.textAll8 = textAll8;
    }

    public JTextField getTextAll9() {
        return textAll9;
    }

    public void setTextAll9(JTextField textAll9) {
        this.textAll9 = textAll9;
    }

    public JTextField getTextAllLast() {
        return textAllLast;
    }

    public void setTextAllLast(JTextField textAllLast) {
        this.textAllLast = textAllLast;
    }

    public JTextField getTextAmt1() {
        return textAmt1;
    }

    public void setTextAmt1(JTextField textAmt1) {
        this.textAmt1 = textAmt1;
    }

    public JTextField getTextAmt10() {
        return textAmt10;
    }

    public void setTextAmt10(JTextField textAmt10) {
        this.textAmt10 = textAmt10;
    }

    public JTextField getTextAmt11() {
        return textAmt11;
    }

    public void setTextAmt11(JTextField textAmt11) {
        this.textAmt11 = textAmt11;
    }

    public JTextField getTextAmt12() {
        return textAmt12;
    }

    public void setTextAmt12(JTextField textAmt12) {
        this.textAmt12 = textAmt12;
    }

    public JTextField getTextAmt13() {
        return textAmt13;
    }

    public void setTextAmt13(JTextField textAmt13) {
        this.textAmt13 = textAmt13;
    }

    public JTextField getTextAmt14() {
        return textAmt14;
    }

    public void setTextAmt14(JTextField textAmt14) {
        this.textAmt14 = textAmt14;
    }

    public JTextField getTextAmt15() {
        return textAmt15;
    }

    public void setTextAmt15(JTextField textAmt15) {
        this.textAmt15 = textAmt15;
    }

    public JTextField getTextAmt2() {
        return textAmt2;
    }

    public void setTextAmt2(JTextField textAmt2) {
        this.textAmt2 = textAmt2;
    }

    public JTextField getTextAmt3() {
        return textAmt3;
    }

    public void setTextAmt3(JTextField textAmt3) {
        this.textAmt3 = textAmt3;
    }

    public JTextField getTextAmt4() {
        return textAmt4;
    }

    public void setTextAmt4(JTextField textAmt4) {
        this.textAmt4 = textAmt4;
    }

    public JTextField getTextAmt5() {
        return textAmt5;
    }

    public void setTextAmt5(JTextField textAmt5) {
        this.textAmt5 = textAmt5;
    }

    public JTextField getTextAmt6() {
        return textAmt6;
    }

    public void setTextAmt6(JTextField textAmt6) {
        this.textAmt6 = textAmt6;
    }

    public JTextField getTextAmt7() {
        return textAmt7;
    }

    public void setTextAmt7(JTextField textAmt7) {
        this.textAmt7 = textAmt7;
    }

    public JTextField getTextAmt8() {
        return textAmt8;
    }

    public void setTextAmt8(JTextField textAmt8) {
        this.textAmt8 = textAmt8;
    }

    public JTextField getTextAmt9() {
        return textAmt9;
    }

    public void setTextAmt9(JTextField textAmt9) {
        this.textAmt9 = textAmt9;
    }

    public JTextField getTextBin() {
        return textBin;
    }

    public void setTextBin(JTextField textBin) {
        this.textBin = textBin;
    }

    public JTextField getTextCostTicket() {
        return textCostTicket;
    }

    public void setTextCostTicket(JTextField textCostTicket) {
        this.textCostTicket = textCostTicket;
    }

    public JTextField getTextDatePlaced() {
        return textDatePlaced;
    }

    public void setTextDatePlaced(JTextField textDatePlaced) {
        this.textDatePlaced = textDatePlaced;
    }

    public JTextField getTextDateRem() {
        return textDateRem;
    }

    public void setTextDateRem(JTextField textDateRem) {
        this.textDateRem = textDateRem;
    }

    public JTextField getTextDistID() {
        return textDistID;
    }

    public void setTextDistID(JTextField textDistID) {
        this.textDistID = textDistID;
    }

    public JTextField getTextGame() {
        return textGame;
    }

    public void setTextGame(JTextField textGame) {
        this.textGame = textGame;
    }

    public JTextField getTextGameCost() {
        return textGameCost;
    }

    public void setTextGameCost(JTextField textGameCost) {
        this.textGameCost = textGameCost;
    }

    public JTextField getTextGameType() {
        return textGameType;
    }

    public void setTextGameType(JTextField textGameType) {
        this.textGameType = textGameType;
    }

    public JTextField getTextID() {
        return textID;
    }

    public void setTextID(JTextField textID) {
        this.textID = textID;
    }

    public JTextField getTextIdealGross() {
        return textIdealGross;
    }

    public void setTextIdealGross(JTextField textIdealGross) {
        this.textIdealGross = textIdealGross;
    }

    public JTextField getTextIdealNet() {
        return textIdealNet;
    }

    public void setTextIdealNet(JTextField textIdealNet) {
        this.textIdealNet = textIdealNet;
    }

    public JTextField getTextIdealPrizes() {
        return textIdealPrizes;
    }

    public void setTextIdealPrizes(JTextField textIdealPrizes) {
        this.textIdealPrizes = textIdealPrizes;
    }

    public JTextField getTextInplay() {
        return textInplay;
    }

    public void setTextInplay(JTextField textInplay) {
        this.textInplay = textInplay;
    }

    public JTextField getTextInvoiceDate() {
        return textInvoiceDate;
    }

    public void setTextInvoiceDate(JTextField textInvoiceDate) {
        this.textInvoiceDate = textInvoiceDate;
    }

    public JTextField getTextInvoiceNum() {
        return textInvoiceNum;
    }

    public void setTextInvoiceNum(JTextField textInvoiceNum) {
        this.textInvoiceNum = textInvoiceNum;
    }

    public JTextField getTextLastRem() {
        return textLastRem;
    }

    public void setTextLastRem(JTextField textLastRem) {
        this.textLastRem = textLastRem;
    }

    public JTextField getTextLastSale() {
        return textLastSale;
    }

    public void setTextLastSale(JTextField textLastSale) {
        this.textLastSale = textLastSale;
    }

    public JTextField getTextManID() {
        return textManID;
    }

    public void setTextManID(JTextField textManID) {
        this.textManID = textManID;
    }

    public JTextField getTextNumTickets() {
        return textNumTickets;
    }

    public void setTextNumTickets(JTextField textNumTickets) {
        this.textNumTickets = textNumTickets;
    }

    public JTextField getTextPartNum() {
        return textPartNum;
    }

    public void setTextPartNum(JTextField textPartNum) {
        this.textPartNum = textPartNum;
    }

    public JTextField getTextRem1() {
        return textRem1;
    }

    public void setTextRem1(JTextField textRem1) {
        this.textRem1 = textRem1;
    }

    public JTextField getTextRem10() {
        return textRem10;
    }

    public void setTextRem10(JTextField textRem10) {
        this.textRem10 = textRem10;
    }

    public JTextField getTextRem11() {
        return textRem11;
    }

    public void setTextRem11(JTextField textRem11) {
        this.textRem11 = textRem11;
    }

    public JTextField getTextRem12() {
        return textRem12;
    }

    public void setTextRem12(JTextField textRem12) {
        this.textRem12 = textRem12;
    }

    public JTextField getTextRem13() {
        return textRem13;
    }

    public void setTextRem13(JTextField textRem13) {
        this.textRem13 = textRem13;
    }

    public JTextField getTextRem14() {
        return textRem14;
    }

    public void setTextRem14(JTextField textRem14) {
        this.textRem14 = textRem14;
    }

    public JTextField getTextRem15() {
        return textRem15;
    }

    public void setTextRem15(JTextField textRem15) {
        this.textRem15 = textRem15;
    }

    public JTextField getTextRem2() {
        return textRem2;
    }

    public void setTextRem2(JTextField textRem2) {
        this.textRem2 = textRem2;
    }

    public JTextField getTextRem3() {
        return textRem3;
    }

    public void setTextRem3(JTextField textRem3) {
        this.textRem3 = textRem3;
    }

    public JTextField getTextRem4() {
        return textRem4;
    }

    public void setTextRem4(JTextField textRem4) {
        this.textRem4 = textRem4;
    }

    public JTextField getTextRem5() {
        return textRem5;
    }

    public void setTextRem5(JTextField textRem5) {
        this.textRem5 = textRem5;
    }

    public JTextField getTextRem6() {
        return textRem6;
    }

    public void setTextRem6(JTextField textRem6) {
        this.textRem6 = textRem6;
    }

    public JTextField getTextRem7() {
        return textRem7;
    }

    public void setTextRem7(JTextField textRem7) {
        this.textRem7 = textRem7;
    }

    public JTextField getTextRem8() {
        return textRem8;
    }

    public void setTextRem8(JTextField textRem8) {
        this.textRem8 = textRem8;
    }

    public JTextField getTextRem9() {
        return textRem9;
    }

    public void setTextRem9(JTextField textRem9) {
        this.textRem9 = textRem9;
    }

    public JTextField getTextSerial() {
        return textSerial;
    }

    public void setTextSerial(JTextField textSerial) {
        this.textSerial = textSerial;
    }

    public JTextField getTextUnsoldTickets() {
        return textUnsoldTickets;
    }

    public void setTextUnsoldTickets(JTextField textUnsoldTickets) {
        this.textUnsoldTickets = textUnsoldTickets;
    }

    public JTextField getTextUnsoldValue() {
        return textUnsoldValue;
    }

    public void setTextUnsoldValue(JTextField textUnsoldValue) {
        this.textUnsoldValue = textUnsoldValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnGT;
    private javax.swing.JButton btnInplay;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextField searchText;
    private javax.swing.JTextField textActualGross;
    private javax.swing.JTextField textActualNet;
    private javax.swing.JTextField textActualPrizes;
    private javax.swing.JTextField textAll1;
    private javax.swing.JTextField textAll10;
    private javax.swing.JTextField textAll11;
    private javax.swing.JTextField textAll12;
    private javax.swing.JTextField textAll13;
    private javax.swing.JTextField textAll14;
    private javax.swing.JTextField textAll15;
    private javax.swing.JTextField textAll2;
    private javax.swing.JTextField textAll3;
    private javax.swing.JTextField textAll4;
    private javax.swing.JTextField textAll5;
    private javax.swing.JTextField textAll6;
    private javax.swing.JTextField textAll7;
    private javax.swing.JTextField textAll8;
    private javax.swing.JTextField textAll9;
    private javax.swing.JTextField textAllLast;
    private javax.swing.JTextField textAmt1;
    private javax.swing.JTextField textAmt10;
    private javax.swing.JTextField textAmt11;
    private javax.swing.JTextField textAmt12;
    private javax.swing.JTextField textAmt13;
    private javax.swing.JTextField textAmt14;
    private javax.swing.JTextField textAmt15;
    private javax.swing.JTextField textAmt2;
    private javax.swing.JTextField textAmt3;
    private javax.swing.JTextField textAmt4;
    private javax.swing.JTextField textAmt5;
    private javax.swing.JTextField textAmt6;
    private javax.swing.JTextField textAmt7;
    private javax.swing.JTextField textAmt8;
    private javax.swing.JTextField textAmt9;
    private javax.swing.JTextField textBin;
    private javax.swing.JTextField textCostTicket;
    private javax.swing.JTextField textDatePlaced;
    private javax.swing.JTextField textDateRem;
    private javax.swing.JTextField textDistID;
    private javax.swing.JTextField textGame;
    private javax.swing.JTextField textGameCost;
    private javax.swing.JTextField textGameType;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textIdealGross;
    private javax.swing.JTextField textIdealNet;
    private javax.swing.JTextField textIdealPrizes;
    private javax.swing.JTextField textInplay;
    private javax.swing.JTextField textInvoiceDate;
    private javax.swing.JTextField textInvoiceNum;
    private javax.swing.JTextField textLastRem;
    private javax.swing.JTextField textLastSale;
    private javax.swing.JTextField textManID;
    private javax.swing.JTextField textNumTickets;
    private javax.swing.JTextField textPartNum;
    private javax.swing.JTextField textRem1;
    private javax.swing.JTextField textRem10;
    private javax.swing.JTextField textRem11;
    private javax.swing.JTextField textRem12;
    private javax.swing.JTextField textRem13;
    private javax.swing.JTextField textRem14;
    private javax.swing.JTextField textRem15;
    private javax.swing.JTextField textRem2;
    private javax.swing.JTextField textRem3;
    private javax.swing.JTextField textRem4;
    private javax.swing.JTextField textRem5;
    private javax.swing.JTextField textRem6;
    private javax.swing.JTextField textRem7;
    private javax.swing.JTextField textRem8;
    private javax.swing.JTextField textRem9;
    private javax.swing.JTextField textSerial;
    private javax.swing.JTextField textUnsoldTickets;
    private javax.swing.JTextField textUnsoldValue;
    // End of variables declaration//GEN-END:variables
}
