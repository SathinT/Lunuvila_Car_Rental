package lk.ijse.lunuvilacarrental.model;

import lk.ijse.lunuvilacarrental.to.Customer;
import lk.ijse.lunuvilacarrental.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerModel {
    public static boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, customer.getId(), customer.getName(), customer.getAddress(), customer.getNic());
    }

    public static Customer search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM Customer WHERE cus_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );
        }
        return null;
    }

    public static boolean update(Customer customer)throws SQLException,ClassNotFoundException{
        String sql = "UPDATE Customer SET Cus_name=?,Cus_address=?,Cus_nic=? where Cus_id=?";
        return CrudUtil.execute(sql, customer.getName(),customer.getAddress(),customer.getNic(),customer.getId());
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Customer WHERE cus_id = ?";

        Boolean bool = CrudUtil.execute(sql,id);
        return bool;
    }

}
