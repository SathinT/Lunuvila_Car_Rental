package lk.ijse.lunuvilacarrental.to;

public class Payment {
    private String id;
    private String type;
    private String Amount;

    public Payment() {
    }

    public Payment(String id, String type, String amount, String date, String time) {
        this.id = id;
        this.type = type;
        Amount = amount;
        Date = date;
        Time = time;
    }

    private String Date;
    private String Time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
