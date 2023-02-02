package lk.ijse.lunuvilacarrental.to;

public class Rent {
    private String RentId;

    private String PackId;
    private String CusId;
    private String DriverId;
    private String CarId;

    private String Date;

    public Rent() {
    }



    public Rent(String rentId, String packId, String cusId, String driverId, String carId, String date) {
        this.RentId = rentId;
        this.PackId = packId;
        this.CusId = cusId;
        this.DriverId = driverId;
        this.CarId = carId;
        this.Date = date;
    }


    public String getPackId() {
        return PackId;
    }

    public void setPackId(String packId) {
        PackId = packId;
    }

    public String getRentId() {
        return RentId;
    }

    public void setRentId(String rentId) {
        RentId = rentId;
    }

    public String getCusId() {
        return CusId;
    }

    public void setCusId(String cusId) {
        CusId = cusId;
    }

    public String getDriverId() {
        return DriverId;
    }

    public void setDriverId(String driverId) {
        DriverId = driverId;
    }

    public String getCarId() {
        return CarId;
    }

    public void setCarId(String carId) {
        CarId = carId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
