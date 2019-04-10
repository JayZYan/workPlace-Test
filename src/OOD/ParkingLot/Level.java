package OOD.ParkingLot;



public class Level {
    private final int floor;
    private final ParkingSpot[] spots;

    public Level (int floor, int BusCap, int CarCap, int MotorCap) {
        this.floor = floor;
        spots = new ParkingSpot[BusCap + CarCap + MotorCap];
        for (int i = 0; i < spots.length; i++) {
            if (i < BusCap) {
                spots[i] = new ParkingSpot(CarType.BUS, floor * 100 + i);
            }
            else if (i < BusCap + CarCap) {
                spots[i] = new ParkingSpot(CarType.CAR, floor * 100 + i);
            }
            else {
                spots[i] = new ParkingSpot(CarType.MOTOR, floor * 100 + i);
            }
        }
    }
    public boolean canPark(Vehicle car) {
        for (ParkingSpot spot : spots) {
            if (spot.canPark(car)) {
                return true;
            }
        }
        return false;
    }
    public boolean goPark(Vehicle car) {
        if (!canPark(car)) {
            return false;
        }
        for (ParkingSpot spot : spots) {
            if (spot.canPark(car)) {
                spot.parkTheCar(car);
                return true;
            }
        }
        return false;
    }
    public int numOfAvailableSpot(Vehicle car) {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (spot.canPark(car)) {
                count++;
            }
        }
        return count;
    }

}
