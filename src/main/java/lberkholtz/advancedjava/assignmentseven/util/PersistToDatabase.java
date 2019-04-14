package lberkholtz.advancedjava.assignmentseven.util;

import lberkholtz.advancedjava.assignmentseven.model.StockData;
import lberkholtz.advancedjava.assignmentseven.model.database.Stock_infoDAO;
import lberkholtz.advancedjava.assignmentseven.xml.Stock;
import lberkholtz.advancedjava.assignmentseven.xml.Stocks;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SuppressWarnings("unchecked")
public class PersistToDatabase {
    /**
     * This method writes the stock information to the SQL file stock_info
     * @param stock
     * @param id
     * @throws ParseException
     */
    public void persistToDatabase(Stock stock, int id) throws ParseException {


        // Creating the config instance & passing the hibernate config file.
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        // Session object to start the db transaction.
        Session s = config.buildSessionFactory().openSession();

        // Transaction object to begin the db transaction.
        Transaction t = s.beginTransaction();

       Stock_infoDAO stock_infoDAO = new Stock_infoDAO();
        stock_infoDAO.setId(id);
        stock_infoDAO.setSymbol(stock.getSymbol());
       BigDecimal price = new BigDecimal(stock.getPrice());
        stock_infoDAO.setPrice(price);

        String inDate= stock.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Timestamp ts = new Timestamp(((java.util.Date)dateFormat.parse(inDate)).getTime());
        stock_infoDAO.setTime(ts);


        // Saving the stockinfo object to the db.
        s.persist(stock_infoDAO);

        // Committing the transaction in the db.
        t.commit();

        System.out.println("\n===================\n");


        // Closing the session object.
        s.close();
    }
}
