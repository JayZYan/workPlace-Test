package OOD.ParkingLot;

public class ParkingSpot {
    private final CarType type;
    private Vehicle cur;
    private final int id;

    public ParkingSpot(CarType type, int id) {
        this.type = type;
        this.id = id;
        cur = null;
    }

    public boolean canPark(Vehicle car) {
        return cur == null && type == car.getType();
    }
    public synchronized boolean parkTheCar(Vehicle car) {
        if (canPark(car)) {
            cur = car;
            return true;
        }
        return false;
    }
    public Vehicle leavePark() {
        Vehicle temp = cur;
        cur = null;
        return temp;
    }
}
