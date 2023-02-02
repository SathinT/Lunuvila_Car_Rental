package lk.ijse.lunuvilacarrental.to;

public class Customer {



    private String id;
    private String name;
    private String address;
    private String nic;

    public Customer(String id, String name, String address, String nic) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.nic = nic;
    }


    public Customer(String string, String allRentString, String rentString, String s, String string1, String allRentString1){

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
