package IncNasPol;

public class Truck extends MotorTransport {
    private int loadCapacity;

    public Truck(int maxSpeed, int amountWheels, String typeEngine, int loadCapacity) {
        super(maxSpeed, amountWheels, typeEngine);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void service() {
        System.out.println("Грузоподьемность: " + loadCapacity);
        super.service();
    }
}
