package abstraction;

public class Car extends MotorTransport {
    private String brandCar;
    private String modelCar;

    public Car(int maxSpeed, int amountWheels, String typeEngine, String brandCar, String modelCar) {
        super(maxSpeed, amountWheels, typeEngine);
        this.brandCar = brandCar;
        this.modelCar = modelCar;
    }

    @Override
    public void service() {
        System.out.println("Обслужен автомобиль: " + brandCar + " " + modelCar);
        super.service();
        driftCar();
        System.out.println();
    }

    private void driftCar() {
        System.out.println("Дать угла");
    }
}
