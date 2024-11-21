package IncNasPol;

import java.text.Format;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Выберите тип транспортного средства: \n");
        System.out.println("Велосипед: введите 1 или 'bicycle'");
        System.out.println("Автомобиль: введите 2 или 'car'");
        System.out.println("Трак: введите 3 или 'truck'");

        String varTransport = scan.nextLine().toLowerCase();

        if (varTransport.equals("1") || varTransport.equals("bicycle")) {
            Bicycle bicycleClient = new Bicycle(24, 2, "Горный");
            visitServiceStation(bicycleClient);
        } else if (varTransport.equals("2") || varTransport.equals("car")) {
            Car carClient = new Car(250, 4, "Бензин", "Toyota", "Supra");
            visitServiceStation(carClient);
        } else if (varTransport.equals("3") || varTransport.equals("truck")) {
            Truck truckClient = new Truck(150, 8, "Дизель", 11000);
            visitServiceStation(truckClient);
        } else {
            System.out.println("Такого вида пока не существует, попробуйте снова");
        }

    }

    public static void visitServiceStation(WheeledTransport typeTransport) {
        System.out.println("Визит в сервис\n--------------");
        if (typeTransport instanceof Bicycle) {
            Bicycle bicycle = (Bicycle) typeTransport;
            bicycle.service();
            bicycle.jump();
        } else if (typeTransport instanceof Car) {
            Car car = (Car) typeTransport;
            car.service();
            car.driftCar();
        } else {
            Truck truck = (Truck) typeTransport;
            truck.service();
            truck.unloading();
        }
    }
}
