package lk.ijse.lunuvilacarrental.model;

import lk.ijse.lunuvilacarrental.to.Driver;
import lk.ijse.lunuvilacarrental.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DriverModel {

    public static boolean save(Driver driver) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO driver VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, driver.getDriver_id(), driver.getEmployee_id(), driver.getDriver_name(), driver.getDriver_address());
    }

    public static ArrayList<String> loadDriverIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Driver_id FROM Driver";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }

    public static Driver search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM Driver WHERE Driver_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Driver(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );
        }


        return null;
    }
}
