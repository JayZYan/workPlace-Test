package OOD.ParkingLot;

public class ParkingLot {
    private final Level[] levels;

    public ParkingLot(int numOfLevel) {
        levels = new Level[numOfLevel];
        for (int i = 0; i < numOfLevel; i++) {
            levels[i] = new Level(i, 20,60,20);
        }
    }
    public boolean canPark(Vehicle car) {
        for (Level lev : levels) {
            if (lev.canPark(car)) {
                return true;
            }
        }
        return false;
    }
    public boolean goPark(Vehicle car) {
        if (!canPark(car)) {
            return false;
        }
        for (Level lev : levels) {
            if (lev.canPark(car)) {
                lev.goPark(car);
                return true;
            }
        }
        return false;
    }
}
