package IncNasPol;

public class Main {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle(24, 2, "Горный");
        Car bmw = new Car(250,4, "Бензин" ,"BMW", "535i");
        Truck volvo = new Truck(140, 10, "Дизель", 13000);
        visitServiceStation(bicycle);
        visitServiceStation(bmw);
        visitServiceStation(volvo);
    }
    public static void visitServiceStation(WheeledTransport typeTransport) {
        System.out.println("Визит в сервис\n--------------");
        typeTransport.service();
        System.out.println("\n");
    }
}
