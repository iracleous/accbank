package gr.codehub.eshop.repository;

import gr.codehub.eshop.model.Customer;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;


@Repository
public class CustomerDbRepositoryImpl implements CustomerRepository {
    @Override
    public boolean create(Customer t) {

    String command = "INSERT INTO [dbo].[customer] "
      + "  ([name] ,[address] ,[date], [credit], status, [value]) "
      + "   VALUES  (?,?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection(
                "jdbc:sqlserver://localhost;databaseName=accBank;user=sa;password=passw0rd"))   {

            PreparedStatement preparedStatement = conn.prepareStatement(command);
            preparedStatement.setString(1, t.getName());
            preparedStatement.setString(2, t.getAddress());

            java.sql.Date d=new java.sql.Date(t.getDateOfBirth().getTime());

            preparedStatement.setDate(3, d);
            preparedStatement.setDouble(4, t.getCredit());
            preparedStatement.setInt(5, t.isStatus()?1:0);
            preparedStatement.setString(6, t.getValue());
            int affectedRows = preparedStatement.executeUpdate();

            System.out.println("The operations have been successfull. Affectedrows = "+ affectedRows);
            return true;
        }
        catch(SQLException e){
            System.out.println("The operations have NOT been successfull");
            System.out.println(e);
            return false;
        }


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
