package dao;

import entity.Tickets;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ryan on 11/4/2015.
 */
public class TransactionTest {

    @Test
    public void testFindPrizeAmt() throws Exception {
        Tickets tk = new Tickets();


        Transaction tx = new Transaction();
        tk = tx.getTicketBin(2);
        assertEquals("24$ prize", false, tx.findPrizeAmt(tk,24));
        assertEquals("Prize is found", true, tx.findPrizeAmt(tk,100));

    }
}