package lk.ijse.lunuvilacarrental.model;

import lk.ijse.lunuvilacarrental.to.CarManage;
import lk.ijse.lunuvilacarrental.to.Employee;
import lk.ijse.lunuvilacarrental.to.PackSelect;
import lk.ijse.lunuvilacarrental.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PackSelectModel {
    public static boolean save(PackSelect packSelect) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO rent VALUES (?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql,packSelect.getPackId() , packSelect.getCarId() , packSelect.getDriverId() , packSelect.getCusId(), packSelect.getDate());
    }
    public static boolean StatusUpdate(String carId, int status) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Car SET Status=? where Car_id=?";
        return CrudUtil.execute(sql, status, carId);
    }

    public static ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Cus_id FROM Customer";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }
}
