package IncNasPol;

public class Bicycle extends WheeledTransport {
    private String typeBicycle;

    public Bicycle(int maxSpeed, int amountWheels, String typeBicycle) {
        super(maxSpeed, amountWheels);
        this.typeBicycle = typeBicycle;
    }

    public String getTypeBicycle() {
        return typeBicycle;
    }

    public void setTypeBicycle(String typeBicycle) {
        this.typeBicycle = typeBicycle;
    }

    public final void jump() {
        System.out.println("Прыжок");
    }

    @Override
    public void service() {
        System.out.println("Обслужен велоспиед типа: " + typeBicycle);
        super.service();
    }
}
