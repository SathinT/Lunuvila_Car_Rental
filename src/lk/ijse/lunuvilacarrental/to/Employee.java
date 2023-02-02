package lk.ijse.lunuvilacarrental.to;

public class Employee {

    private String id;
    private String name;
    private String address;
    private String nic;

    public Employee(String rentId, String cusId, String date, String carId, String driverId) {
    }

    public Employee(String id, String name, String address, String nic) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.nic = nic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}
