package Util;

import dao.GameTemplateDAO;
import dao.LBCTicketsDAO;
import entity.GameTemplates;
import entity.LBCTicketTemplate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Ryan on 11/12/2015.
 */
public class ScanTextFile {
    public static GameTemplateDAO gtDAO;
    public static GameTemplates gt;
    public static LBCTicketsDAO LBCDAO;

    public static void main(String[] args) {
        //TODO: change file input path
        String file = "G://ASCII.txt";
        BufferedReader br = null;
        LBCDAO = new LBCTicketsDAO();
        String line ="";
        String splitBy = ",";

        try {

            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {

                // use comma as separator

                String[] ticket = line.split(splitBy);


                LBCTicketTemplate lbcImportObject = new LBCTicketTemplate(ticket[0],Integer.parseInt(ticket[1]),ticket[2],Integer.parseInt(ticket[3]), ticket[4],
                        ticket[5],ticket[6],ticket[7],Integer.parseInt(ticket[8]),Double.parseDouble(ticket[9]),Double.parseDouble(ticket[10]),Double.parseDouble(ticket[11]),
                        ticket[12],ticket[13],ticket[14],
                        Double.parseDouble(ticket[15]),Double.parseDouble(ticket[16]),Double.parseDouble(ticket[17]));
                //try to store the data to the database
                //add it to a list of object then batch insert using hibernate
                LBCDAO.recordTicket(lbcImportObject);

                System.out.println(lbcImportObject.toString());


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");
    }

}


