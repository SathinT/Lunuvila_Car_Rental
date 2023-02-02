package lk.ijse.lunuvilacarrental.model;

import lk.ijse.lunuvilacarrental.to.Employee;
import lk.ijse.lunuvilacarrental.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeManageModel {
    public static boolean save(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, employee.getId() , employee.getName() , employee.getAddress() , employee.getNic());
    }

    public static boolean update(Employee employee)throws SQLException,ClassNotFoundException{
        String sql = "UPDATE Employee SET Employee_name=?,Employee_address=?,Employee_nic=? where Employee_id=?";
        return CrudUtil.execute(sql, employee.getName(), employee.getAddress(), employee.getNic(), employee.getId());
    }


    public static Employee search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM Employee WHERE Employee_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Employee(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );
        }
        return null;
    }

    public static ArrayList<String> loadEmployeeIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Employee_id FROM Employee";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Employee WHERE Employee_id = ?";

        Boolean bool = CrudUtil.execute(sql,id);
        return bool;
    }

}
