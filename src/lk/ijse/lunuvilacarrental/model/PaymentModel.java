package lk.ijse.lunuvilacarrental.model;

import lk.ijse.lunuvilacarrental.to.Employee;
import lk.ijse.lunuvilacarrental.to.Payment;
import lk.ijse.lunuvilacarrental.util.CrudUtil;

import java.sql.SQLException;

public class PaymentModel {
    public static boolean save(Payment payment) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO income VALUES (?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, payment.getId() , payment.getType() , payment.getAmount() , payment.getDate(),payment.getTime());
    }
}
