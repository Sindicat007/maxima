package abstraction;

public abstract class WheeledTransport implements Transport{
    private int maxSpeed;
    private int amountWheels;

    public WheeledTransport(int maxSpeed, int amountWheels) {
        this.maxSpeed = maxSpeed;
        this.amountWheels = amountWheels;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getAmountWheels() {
        return amountWheels;
    }

    public void setAmountWheels(int amountWheels) {
        this.amountWheels = amountWheels;
    }

    public void service() {
        System.out.println("Обслужено колёс: " + amountWheels);
    }
}
