package IncNasPol;

public class Car extends MotorTransport{
    private String brandCar;
    private String modelCar;

    public Car(int maxSpeed, int amountWheels, String typeEngine, String brandCar, String modelCar) {
        super(maxSpeed, amountWheels, typeEngine);
        this.brandCar = brandCar;
        this.modelCar = modelCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }
    @Override
    public void service() {
        System.out.println("Обслужен автомобиль: " + brandCar + " " + modelCar);
        super.service();
    }
}
