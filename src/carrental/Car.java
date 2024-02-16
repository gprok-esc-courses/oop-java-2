package carrental;

public class Car {
    private String plate;
    private double km;
    private boolean rented;

    public Car(String plate, double km) {
        setPlate(plate);
        setKm(km);
        setRented(false);
    }

    public void setKm(double km) {
        if(km > this.km) {
            this.km = km;
        }
    }

    public double getKm() {
        return km;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return this.plate + " km: " + this.km;
    }
}
