package lk.ijse.lunuvilacarrental.model;


import lk.ijse.lunuvilacarrental.to.Rent;
import lk.ijse.lunuvilacarrental.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentModel {
    public static Rent search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM Rent WHERE Rent_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Rent(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            );
        }
        return null;
    }

    public static ArrayList<String> loadRentIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Rent_id FROM Rent";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }
}
