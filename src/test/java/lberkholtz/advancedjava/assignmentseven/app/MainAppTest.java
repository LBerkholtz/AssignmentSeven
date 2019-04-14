package lberkholtz.advancedjava.assignmentseven.app;

import lberkholtz.advancedjava.assignmentseven.util.DatabaseConnectionException;
import lberkholtz.advancedjava.assignmentseven.util.DatabaseInitializationException;
import lberkholtz.advancedjava.assignmentseven.util.DatabaseUtils;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class MainAppTest {
    /**
     * Tests the MainApp to see if the correct number of rows are written to the file
     * @throws JAXBException
     * @throws DatabaseInitializationException
     * @throws DatabaseConnectionException
     * @throws SQLException
     */
   @Test
    public void TestMain() throws JAXBException, DatabaseInitializationException, DatabaseConnectionException, SQLException {
       MainApp mainApp = new MainApp();
       String[] stringA = null;
       mainApp.main(stringA);
       Connection connection = DatabaseUtils.getConnection();
       Statement statement = null;
       statement = connection.createStatement();
       String queryString = "select * from stock_info";
       ResultSet resultSet = null;
       resultSet = statement.executeQuery(queryString);
       resultSet.last();
       int count = resultSet.getRow();
       assertEquals("All the records are written to the file", 49, count);

   }
}
