package dao;

import entity.*;

/**
 * Created by Ryan on 11/12/2015.
 */
public class LBCTicketsDAO {
    public static GameTemplates gt;
    public static GameTemplateDAO gtDAO;
    public static DistsId did;
    public static MfgId mid;
    public static TicketDAO tDAO;
    public static Tickets tk;
    public static TicketsId tid;
    public static GameTemplatesId gtid;

    public void recordTicket(LBCTicketTemplate lbcTicket){
        //saveLBC ticket into new database for type 2 tickets
        //create game template
        gt = new GameTemplates();
        gtDAO = new GameTemplateDAO();
        gtid = new GameTemplatesId();
        did = new DistsId();
        mid = new MfgId();
        tk = new Tickets();
        tDAO = new TicketDAO();
        tid = new TicketsId();
//        if (lbcTicket.getDistro().equals("LBC")){
//            did.setDistId(3);
//        }else{
//            System.out.println("File is not from LBC!");
//         return;
//        }
//
//        gt.setDistsId(did);
//
//        mid.setMfgId(16);
//        gt.setMfgId(mid);
        gtid.setMfgIdMfgId(16);
        gtid.setDistsIdDistId(3);
        gtid.setPartNum(lbcTicket.getFormNo());
        gt.setId(gtid);
        gt.setGameCost(lbcTicket.getCostOfDeal());
        gt.setGameName(lbcTicket.getName());
        gt.setIdeaGross(lbcTicket.getGross());
        gt.setIdeaPrizes((int) lbcTicket.getTotalPrizes());
        gt.setIdeaNet((int) (lbcTicket.getGross() - lbcTicket.getTotalPrizes()));
        gt.setNumTickets(lbcTicket.getGross());
        gt.setTicketCost(lbcTicket.getCostofTicket());
        gtDAO.addGameTemplate(gt);
        System.out.println("Added game template successfully");
        tid.setSerial(lbcTicket.getSerial());
        tid.setGameTemplatesPartNum(gt.getId().getPartNum());
        tk.setId(tid);
        tk.setType(2);
        tk.setInvoiceNum(String.valueOf(lbcTicket.getInvoice()));
        tDAO.addTickets(tk);
        System.out.println("Ticket added");


    }


}
