package lk.ijse.lunuvilacarrental.model;

import lk.ijse.lunuvilacarrental.to.CarManage;
import lk.ijse.lunuvilacarrental.to.Customer;
import lk.ijse.lunuvilacarrental.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarManageModel {
    public static boolean save(CarManage carManage) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Car VALUES (?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, carManage.getCarId(), carManage.getModel(), carManage.getBrand(),carManage.getFuel(),carManage.getAvailability());
    }

    public static CarManage search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM Car WHERE Car_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new CarManage(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    Integer.valueOf(result.getString(5))
            );
        }
        return null;
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM car WHERE Car_id = ?";

        Boolean bool = CrudUtil.execute(sql,id);
        return bool;

    }

    public static boolean update(CarManage carManage)throws SQLException,ClassNotFoundException{
        String sql = "UPDATE car SET Model=?,Brand=?,Fuel_type=? ,Status=? where Car_id=?";
        return CrudUtil.execute(sql,carManage.getModel(),carManage.getBrand(),carManage.getFuel(),carManage.getAvailability(), carManage.getCarId());
    }

    public static ArrayList<String> loadCarIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Car_id FROM Car";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }

}
