package abstraction;

public class Main {
    public static void main(String[] args) {

        Bicycle mount = new Bicycle(20, 2, "Горный");
        Bicycle bmx = new Bicycle(13, 2, "BMX");

        Car bmw = new Car(290, 4, "Бензин", "BMW", "535iX");
        Car lada = new Car(180, 4, "Бензин", "Лада", "Веста");

        Truck volvo = new Truck(120, 6, "Дизель", 19000);
        Truck man = new Truck(130, 6, "Дизель", 14000);

        Transport[] serviceTransport = {mount, bmx, bmw, lada, volvo, man};

        ServiceStation sto = new ServiceStation();

        for (Transport transport : serviceTransport) {
            sto.visitServiceStation(transport);
        }
    }
}
