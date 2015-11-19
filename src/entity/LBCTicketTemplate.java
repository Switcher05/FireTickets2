package entity;

/**
 * Created by Ryan on 11/12/2015.
 */
public class LBCTicketTemplate {
    String distro, location, serial, name, rep, formNo, firstPrize, secondPrize;
    int qty, gross, invoice;
    double costofTicket, costOfDeal, costOfDeal2,  noIdea1, noIdea2, totalPrizes;
    String invoiceDate;
    public LBCTicketTemplate(){

    }

    public LBCTicketTemplate(String distro, int qty, String location, int invoice, String invoiceDate, String formNo, String name, String serial,
                             int gross, double costofTicket, double costOfDeal, double costOfDeal2, String firstPrize, String secondPrize, String rep, double noIdea1, double noIdea2, double totalPrizes) {

        this.distro = distro;
        this.location = location;
        this.serial = serial;
        this.name = name;
        this.rep = rep;
        this.formNo = formNo;
        this.qty = qty;
        this.gross = gross;
        this.invoice = invoice;
        this.costofTicket = costofTicket;
        this.costOfDeal = costOfDeal;
        this.costOfDeal2 = costOfDeal2;
        this.firstPrize = firstPrize;
        this.secondPrize = secondPrize;
        this.noIdea1 = noIdea1;
        this.noIdea2 = noIdea2;
        this.totalPrizes = totalPrizes;
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String toString() {
        return "LBCTicketTemplate{" +
                "distro='" + distro + '\'' +
                ", location='" + location + '\'' +
                ", serial='" + serial + '\'' +
                ", name='" + name + '\'' +
                ", rep='" + rep + '\'' +
                ", formNo='" + formNo + '\'' +
                ", firstPrize='" + firstPrize + '\'' +
                ", secondPrize='" + secondPrize + '\'' +
                ", qty=" + qty +
                ", gross=" + gross +
                ", invoice=" + invoice +
                ", costofTicket=" + costofTicket +
                ", costOfDeal=" + costOfDeal +
                ", costOfDeal2=" + costOfDeal2 +
                ", noIdea1=" + noIdea1 +
                ", noIdea2=" + noIdea2 +
                ", totalPrizes=" + totalPrizes +
                ", invoiceDate='" + invoiceDate + '\'' +
                '}';
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getDistro() {
        return distro;
    }

    public void setDistro(String distro) {
        this.distro = distro;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getGross() {
        return gross;
    }

    public void setGross(int gross) {
        this.gross = gross;
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public double getCostofTicket() {
        return costofTicket;
    }

    public void setCostofTicket(double costofTicket) {
        this.costofTicket = costofTicket;
    }

    public double getCostOfDeal() {
        return costOfDeal;
    }

    public void setCostOfDeal(double costOfDeal) {
        this.costOfDeal = costOfDeal;
    }

    public double getCostOfDeal2() {
        return costOfDeal2;
    }

    public void setCostOfDeal2(double costOfDeal2) {
        this.costOfDeal2 = costOfDeal2;
    }

    public String getFirstPrize() {
        return firstPrize;
    }

    public void setFirstPrize(String firstPrize) {
        this.firstPrize = firstPrize;
    }

    public String getSecondPrize() {
        return secondPrize;
    }

    public void setSecondPrize(String secondPrize) {
        this.secondPrize = secondPrize;
    }

    public double getNoIdea1() {
        return noIdea1;
    }

    public void setNoIdea1(double noIdea1) {
        this.noIdea1 = noIdea1;
    }

    public double getNoIdea2() {
        return noIdea2;
    }

    public void setNoIdea2(double noIdea2) {
        this.noIdea2 = noIdea2;
    }

    public double getTotalPrizes() {
        return totalPrizes;
    }

    public void setTotalPrizes(double totalPrizes) {
        this.totalPrizes = totalPrizes;
    }
}
