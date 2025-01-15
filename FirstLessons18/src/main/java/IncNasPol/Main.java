package IncNasPol;

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
            System.out.println("Данный тип транспорта пока не обслуживается, попробуйте выбрать из списка выше");
        }

    }

    public static void visitServiceStation(WheeledTransport typeTransport) {
        System.out.println("Визит в сервис\n--------------");
        if (typeTransport instanceof Bicycle bicycle) {
            bicycle.service();
            bicycle.jump();
        } else if (typeTransport instanceof Car car) {
            car.service();
            car.driftCar();
        } else if (typeTransport instanceof Truck truck) {
            truck.service();
            truck.unloading();
        } else {
            System.out.println("Данный тип транспорта веременно не обслуживается");
        }
    }
}
