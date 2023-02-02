package lk.ijse.lunuvilacarrental.to;

public class Driver {
   private String Driver_id;
   private String Employee_id;
   private String Driver_name;
   private String Driver_address;

    public Driver() {
    }

    public Driver(String driver_id, String employee_id, String driver_name, String driver_address) {
        Driver_id = driver_id;
        Employee_id = employee_id;
        Driver_name = driver_name;
        Driver_address = driver_address;

    }

    public String getDriver_id() {
        return Driver_id;
    }

    public void setDriver_id(String driver_id) {
        Driver_id = driver_id;
    }

    public String getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(String employee_id) {
        Employee_id = employee_id;
    }

    public String getDriver_name() {
        return Driver_name;
    }

    public void setDriver_name(String driver_name) {
        Driver_name = driver_name;
    }

    public String getDriver_address() {
        return Driver_address;
    }

    public void setDriver_address(String driver_address) {
        Driver_address = driver_address;
    }
}
