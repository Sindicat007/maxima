package abstraction;

public class Bicycle extends WheeledTransport {
    private final String typeBicycle;

    public Bicycle(int maxSpeed, int amountWheels, String typeBicycle) {
        super(maxSpeed, amountWheels);
        this.typeBicycle = typeBicycle;
    }

    public String getTypeBicycle() {
        return typeBicycle;
    }

    @Override
    public void service() {
        System.out.println("Обслужен велоспиед типа: " + typeBicycle);
        super.service();
        jump();
        System.out.println();
    }

    private void jump() {
        System.out.println("Прыжок");
    }
}
