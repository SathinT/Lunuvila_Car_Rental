package lk.ijse.lunuvilacarrental.to;

import java.time.LocalDate;

public class PackSelect {
    private String PackId;
    private String RentId;
    private String CusId;
    private LocalDate Date;

    private String CarId;
    private String DriverId;



    public PackSelect(String packId, String carId, String driverId, String cusId, LocalDate date) {
        this.PackId = packId;
        this.CarId = carId;
        this.DriverId = driverId;
        this.CusId = cusId;
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

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getCarId() {
        return CarId;
    }

    public void setCarId(String carId) {
        CarId = carId;
    }

    public String getDriverId() {
        return DriverId;
    }

    public void setDriverId(String driverId) {
        DriverId = driverId;
    }
}
