package OOD.ParkingLot;

abstract class Vehicle {
    private CarType type;
    private final int carID;

    public Vehicle(CarType type, int carID) {
        this.type = type;
        this.carID = carID;
    }

    public CarType getType() {
        return type;
    }
    public int getCarID() {
        return carID;
    }
}
