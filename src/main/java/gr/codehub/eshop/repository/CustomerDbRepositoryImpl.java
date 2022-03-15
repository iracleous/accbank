package gr.codehub.eshop.repository;

import gr.codehub.eshop.model.Customer;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CustomerDbRepositoryImpl implements CustomerRepository {


    private final static String CONN_STRING = "jdbc:sqlserver://localhost;databaseName=accBank;user=sa;password=passw0rd";


    @Override
    public boolean create(Customer t) {

    String command = "INSERT INTO [dbo].[customer] "
      + "  ([name] ,[address] ,[date], [credit], status, [value]) "
      + "   VALUES  (?,?,?,?,?,?); SELECT SCOPE_IDENTITY(); ";
        try(Connection conn = DriverManager.getConnection( CONN_STRING   ))   {

            PreparedStatement preparedStatement = conn.prepareStatement(command);
            preparedStatement.setString(1, t.getName());
            preparedStatement.setString(2, t.getAddress());

            java.sql.Date d=new java.sql.Date(t.getDateOfBirth().getTime());

            preparedStatement.setDate(3, d);
            preparedStatement.setDouble(4, t.getCredit());
            preparedStatement.setInt(5, t.isStatus()?1:0);
            preparedStatement.setString(6, t.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())   {
                int code = resultSet.getInt(1);
                t.setId(code);
            }

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
        String command = "Select * from Customer where id = ?";
        try(Connection conn = DriverManager.getConnection(CONN_STRING)) {
            PreparedStatement preparedStatement = conn.prepareStatement(command);
            preparedStatement.setInt(1, id);
            ResultSet customerResult = preparedStatement.executeQuery();
            while(customerResult.next())   {
                Customer customer = new Customer();
                customer.setId(customerResult.getInt("id") );
                customer.setName(customerResult.getString("name"));

                customer.setAddress(customerResult.getString("address"));
                customer.setStatus(customerResult.getBoolean("status"));
                return customer;
            }
        }
        catch(Exception e){
        }
        return null;
    }

    @Override
    public List<Customer> read() {

        String command = "Select * from Customer  ";
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(CONN_STRING)) {
            PreparedStatement preparedStatement = conn.prepareStatement(command);
             ResultSet customerResult = preparedStatement.executeQuery();
            while(customerResult.next())   {
                Customer customer = new Customer();
                customer.setId(customerResult.getInt("id") );
                customer.setName(customerResult.getString("name"));

                customer.setAddress(customerResult.getString("address"));
                customer.setStatus(customerResult.getBoolean("status"));
                customers.add(customer) ;
            }
        }
        catch(Exception e){
        }
          return customers;
    }

    @Override
    public Customer update(int id, String newValue) {
        Customer customer = read(id);

        String command = "update [dbo].[customer] set  [address] = ?  where id = ? ";
        try(Connection conn = DriverManager.getConnection( CONN_STRING   )) {

            PreparedStatement preparedStatement = conn.prepareStatement(command);
            preparedStatement.setString(1, newValue);
            preparedStatement.setInt(2, id);

            int numberRows = preparedStatement.executeUpdate();
            customer.setAddress(newValue);
            return customer;
        }
        catch(Exception e){
            return null;
        }
     }

    @Override
    public boolean delete(int id) throws Exception {


        String command = "delete from  [dbo].[customer]    where id = ? ";
        try(Connection conn = DriverManager.getConnection( CONN_STRING   )) {

            PreparedStatement preparedStatement = conn.prepareStatement(command);

            preparedStatement.setInt(1, id);

            int numberRows = preparedStatement.executeUpdate();

            return numberRows > 0;
        }
        catch(Exception e){
            return false;
        }
    }
}
