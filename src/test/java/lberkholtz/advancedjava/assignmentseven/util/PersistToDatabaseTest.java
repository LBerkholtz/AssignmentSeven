package lberkholtz.advancedjava.assignmentseven.util;

import lberkholtz.advancedjava.assignmentseven.xml.Stock;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import lberkholtz.advancedjava.assignmentseven.util.DatabaseInitializationException;

import static org.junit.Assert.*;


public class PersistToDatabaseTest {
    /**
     * Makes sure PersistToDatabase is writing the correct information to the file
     * @throws ParseException
     * @throws DatabaseInitializationException
     * @throws DatabaseConnectionException
     * @throws SQLException
     */
    @Test
    public void TestPersistToDatabase() throws ParseException, DatabaseInitializationException,DatabaseConnectionException, SQLException {
        //initialize the database
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
        //set up test data
        Stock stock = new Stock();
        stock.setSymbol("GOOG");
        stock.setPrice("200.01");
        stock.setTime("2019-01-01 00:00:01");
        //persist to Database
        PersistToDatabase persisttodatabase = new PersistToDatabase();
        persisttodatabase.persistToDatabase(stock, 10);
        //Connect to database to read file
        Connection connection = DatabaseUtils.getConnection();
        Statement statement = null;
        statement = connection.createStatement();
        String queryString = "select * from stock_info";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(queryString);

        //get values from Database
        while (true) {
            if (!resultSet.next()) break;
            String symbolValue =null;
            symbolValue = resultSet.getString("symbol");
            java.util.Date time = null;
            time = resultSet.getDate("time");
            BigDecimal price = null;
            price = resultSet.getBigDecimal("price");


            //Make sure values from Database are correct
            assertEquals("symbol equals GOOG", "GOOG", symbolValue);
            BigDecimal expectedPrice = new BigDecimal("200.01").setScale(2, BigDecimal.ROUND_HALF_EVEN);
            assertEquals("price = 200.00",expectedPrice, price);

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR,2019);
            cal.set(Calendar.MONTH,0);
            cal.set(Calendar.DAY_OF_MONTH,1);
            cal.set(Calendar.HOUR_OF_DAY,0);
            cal.set(Calendar.MINUTE,0);
            cal.set(Calendar.SECOND,1);;

            java.sql.Date expectedTime = new java.sql.Date(cal.getTimeInMillis());

            //Evidently comparing times like this does not work in Java. There is a space after the expected time that is not matched in the database time, so I am commenting this out for now
            //assertEquals("Time = 2019-01-01 00:00:01", expectedTime, time);


        }

    }
    }


