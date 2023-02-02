package lk.ijse.lunuvilacarrental.to;

public class CarManage {
    private String CarId;
    private String Model;
    private String Fuel;
    private String Brand;

    private int Availability;

    public CarManage(String carId, String model,String brand, String fuel,int availability) {
        CarId = carId;
        Model = model;
        Fuel = fuel;
        Brand = brand;
        Availability = availability;
    }

    public String getCarId() {
        return CarId;
    }

    public void setCarId(String carId) {
        CarId = carId;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getFuel() {
        return Fuel;
    }

    public void setFuel(String fuel) {
        Fuel = fuel;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public int getAvailability() {
        return Availability;
    }

    public void setAvailability(int availability) {
        Availability = availability;
    }
}