package test.elevator;

public class ElevatorOperator {

    

    void operateElevator(ElevatorCar car, Floor desitinationFloor){
        if(car.direction.equals(Direction.DOWN)) {
            // use max heap
        }

        if(car.direction.equals(Direction.UP)) {
            // use min heap
        }
    }

    public void addStop(ElevatorCar car, Floor floor, Direction direction) {
        if(direction.equals(Direction.DOWN)) {
            // use max heap
            car.downDirationFloorRequest.add(floor);
        }

        if(direction.equals(Direction.UP)) {
            // use min heap
            car.upDirationFloorRequest.add(floor);
        }
    }


}
