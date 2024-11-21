package CastingDop;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {new Car(), new Truck(), new Truck(), new Car()};
        vehicleProceed(vehicles);
    }

    public static void vehicleProceed(Vehicle[] vehicles) {
        for (Vehicle vehicle : vehicles) {
            vehicle.drive();
            if (vehicle instanceof Car) {
                ((Car) vehicle).playMusic();
            } else if (vehicle instanceof Truck) {
                ((Truck) vehicle).loadCargo();
            }
        }
    }
}
