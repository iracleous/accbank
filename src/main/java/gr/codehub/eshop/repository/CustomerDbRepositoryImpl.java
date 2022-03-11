package gr.codehub.eshop.repository;

import gr.codehub.eshop.model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ConcurrentModificationException;
import java.util.List;

public class CustomerDbRepositoryImpl implements Repository<Customer>{
    @Override
    public boolean create(Customer t) {

    String command = "  INSERT INTO [dbo].[customer] "
      + "  ([name] ,[address]     ,[credit]   , [value]) "
      + "   VALUES  ('"
            + t.getName() + "','"
            + t.getAddress() + "','"
            + t.getCredit() + "','"
            + t.getValue() + "');";
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=accBank;user=sa;password=passw0rd");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(command);
            conn.close();

            System.out.println("The operations has been successfull");
        }
        catch(SQLException e){
            System.out.println("The operations has NOT been successfull");
            System.out.println(e);

        }

        return false;
    }

    @Override
    public Customer read(int id) {
        return null;
    }

    @Override
    public List<Customer> read() {
        return null;
    }

    @Override
    public boolean update(int id, String newValue) {
        return false;
    }

    @Override
    public boolean delete(int id) throws Exception {
        return false;
    }
}
