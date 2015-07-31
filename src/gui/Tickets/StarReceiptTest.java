/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tickets;

/**
 *
 * @author Switcher
 */
import java.util.ArrayList;
import java.util.Iterator;
import jpos.JposConst;
import jpos.JposException;
import jpos.POSPrinter;
import jpos.POSPrinterConst;
import jpos.events.ErrorEvent;
import jpos.events.ErrorListener;
import jpos.events.OutputCompleteEvent;
import jpos.events.OutputCompleteListener;
import jpos.events.StatusUpdateEvent;
import jpos.events.StatusUpdateListener;
import jpos.util.JposPropertiesConst;

public class StarReceiptTest implements OutputCompleteListener, StatusUpdateListener, ErrorListener {
    private static double total = 0;
    
    public static ArrayList<String> array = new ArrayList<>();
	public void outputCompleteOccurred(OutputCompleteEvent event) {
		System.out.println("OutputCompleteEvent received: time = "
				+ System.currentTimeMillis() + " output id = "
				+ event.getOutputID());
	}

	public void statusUpdateOccurred(StatusUpdateEvent event) {
		System.out.println("StatusUpdateEvent : status id = " + event.getStatus());
	}

	public void errorOccurred(ErrorEvent event) {
		System.out.println("ErrorEvent received: time = "
				+ System.currentTimeMillis() + " error code = "
				+ event.getErrorCode() + " error code extended = "
				+ event.getErrorCodeExtended());

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		event.setErrorResponse(JposConst.JPOS_ER_RETRY);
	}
       
        
        public void formatLine(int saleamount, int prizeamount, String serial, String name){
            setTotal(saleamount, prizeamount);
            String line = saleamount + "    " + prizeamount +"        " + serial + "    " + name;
            setLine(line);
        }
        //TODO: 
        //Get price method, customer number, date and time, user number, invoice number, barcode, gif, pickticket 
        public void setTotal(double saleamount, double prizeamount){
            
            total = total + saleamount - prizeamount;
           
        }
        public double getTotal(){
            return total;
        }
        public void setLine(String line){
            array.add(line);
            System.out.println("Line item recieved: " + array);
        }
        public void clearLines(){
            total = 0;
            array.clear();
            System.out.println("Line item array cleared.");
        }
        public static ArrayList getArray(){
            return array;
        }
	public void runTest() {
                array = getArray();
		System.setProperty(	JposPropertiesConst.JPOS_POPULATOR_FILE_PROP_NAME, "\\\\WIN-UI54OA8049S\\Treasurer\\dist\\jpos.xml");

		String ESC = ((char) 0x1b) + "";
		String LF = ((char) 0x0a) + "";
		String SPACES = "                                                                      ";

		POSPrinter printer = new POSPrinter();

		try {
			printer.addOutputCompleteListener(this);
			printer.addStatusUpdateListener(this);
			printer.addErrorListener(this);
			printer.open("TSP100_1");
			printer.claim(1);
			printer.setDeviceEnabled(true);
			printer.setAsyncMode(true);
			printer.setMapMode(POSPrinterConst.PTR_MM_METRIC); // unit = 1/100 mm - i.e. 1 cm = 10 mm = 10 * 100 units
			do {
				if (printer.getCoverOpen() == true) {
					System.out.println("printer.getCoverOpen() == true");
					break;
				}

				if (printer.getRecEmpty() == true) {
					System.out.println("printer.getRecEmpty() == true");
					break;
				}

				// being a transaction
				// transaction mode causes all output to be buffered
				// once transaction mode is terminated, the buffered data is
				// outputted to the printer in one shot - increased reliability
				printer.transactionPrint(POSPrinterConst.PTR_S_RECEIPT, POSPrinterConst.PTR_TP_TRANSACTION);
				if (printer.getCapRecBitmap() == true) {
					// print an image file
					try {
						printer.printBitmap(POSPrinterConst.PTR_S_RECEIPT, "\\\\WIN-UI54OA8049S\\Treasurer\\dist\\Fire Tickets\\src\\Tickets\\star.gif", POSPrinterConst.PTR_BM_ASIS, POSPrinterConst.PTR_BM_CENTER);
					} catch (JposException e) {
						if (e.getErrorCode() != JposConst.JPOS_E_NOEXIST) {
							// error other than file not exist - propogate it
							throw e;
						}
						// image file not found - ignore this error & proceed
					}
				}

				// call printNormal repeatedly to generate out receipt the following
				// JavaPOS-POSPrinter control code sequences are used here
				// ESC + "|cA" -> center alignment
				// ESC + "|4C" -> double high double wide character printing
				// ESC + "|bC" -> bold character printing
				// ESC + "|uC" -> underline character printing
				// ESC + "|rA" -> right alignment
                                Iterator<String> itr = array.iterator();
				printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|cA" + ESC + "|4C" + ESC + "|bC" + "Belpre Bingo" + LF);
                                printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|cA" + ESC + "|bC" + "www.belprebingo.com" + LF);
				printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|cA" + ESC + "|bC" + "133 Stone Road, Belpre OH" + LF);
				printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|cA" + ESC + "|bC" + "740-423-7234" + LF);
                                printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|cA" + ESC + "|bC" + "Bingo EVERY Friday 7pm" + LF);
                                printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|cA" + ESC + "|bC" + Transaction.getCurrentTimeStamp() + LF);

				printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|uC" + "Sale  Prize    Serial     Game Name" +
						SPACES.substring(0, printer.getRecLineChars() - "Sale    Prize      Serial     Game Name".length()) + LF);
                                while(itr.hasNext()){
                                   printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, itr.next() + LF); 
                                }
				printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, LF);
                                printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|rA" + ESC + "|bC" + "Total: $" + getTotal() + LF);
				printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, LF);
                                String invoicenum = Integer.toString(Transaction.invoiceNum);
				if (printer.getCapRecBarCode() == true) {
					// print a Code 3 of 9 barcode with the data "123456789012" encoded
					// the 10 * 100, 60 * 100 parameters below specify the barcode's
					// height and width in the metric map mode (1cm tall, 6cm wide)
					printer.printBarCode(POSPrinterConst.PTR_S_RECEIPT, invoicenum, POSPrinterConst.PTR_BCS_Code39,
							10 * 100, 60 * 100, POSPrinterConst.PTR_BC_CENTER, POSPrinterConst.PTR_BC_TEXT_BELOW);
				}

				printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|cA" + ESC + "|4C" + ESC + "|bC" + "Thank You" + LF);

				// the ESC + "|100fP" control code causes the printer to execute
				// a paper cut after feeding to the cutter position
				printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|100fP");

				// terminate the transaction causing all of the above buffered
				// data to be sent to the printer
				printer.transactionPrint(POSPrinterConst.PTR_S_RECEIPT, POSPrinterConst.PTR_TP_NORMAL);

				System.out.println("Async transaction print submited: time = "
						+ System.currentTimeMillis() + " output id = " + printer.getOutputID());

				// exit our printing loop
			} while (false);
		} catch (JposException e) {
			// display any errors that come up
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close the printer object
			if (printer.getState() != JposConst.JPOS_S_CLOSED) {
				try {
					while (printer.getState() != JposConst.JPOS_S_IDLE) {
						Thread.sleep(0);
					}

					printer.close();
				} catch (Exception e) {
				}
			}
		}

		System.out.println("StarReceiptTest finished.");
	}

	public static void main(String[] args) {
                
		new StarReceiptTest().runTest();
	}
}
