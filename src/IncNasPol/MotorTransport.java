package IncNasPol;

public class MotorTransport extends WheeledTransport {
    private String typeEngine;

    public MotorTransport(int maxSpeed, int amountWheels, String typeEngine) {
        super(maxSpeed, amountWheels);
        this.typeEngine = typeEngine;
    }

    public String getTypeEngine() {
        return typeEngine;
    }

    public void setTypeEngine(String typeEngine) {
        this.typeEngine = typeEngine;
    }

    @Override
    public void service() {
        System.out.println("Обслужен двигатель типа: " + typeEngine);
        super.service();
    }
}
