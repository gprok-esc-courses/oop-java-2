package bank;

public class Account {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String creditCard;
    private double balance;
    private boolean active;

    public Account(int id, String name, String address,
                   String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.creditCard = "N/A";
        this.balance = 0;
        this.active = true;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Phone: " + phone + "\n" +
                "Credit Card: " + creditCard + "\n" +
                "Balance: " + balance;
    }

    public int getId() {
        return id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
