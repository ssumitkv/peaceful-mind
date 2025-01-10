package test.elevator;

import java.util.List;

public class ElevatorManager {
    
    Building building;

    ElevatorOperator elevatorOperator;



    boolean requestLiftFromOutSide(Floor floor) {

        List<ElevatorCar> lifts = building.elevators;
        List<ElevatorCar> elegibElevatorCars = new ArrayList<>();

        for (ElevatorCar lifElevatorCar : lifts) {
            // check free cars, check direction and than assign
            brak
        }

        
        // ask elevator operator fill the request in heap;
        if(floor.down.isPressed)
            elevatorOperator.addStop(elegibElevatorCars.get(0), floor, Direction.DOWN);
        if(floor.up.isPressed)
            elevatorOperator.addStop(elegibElevatorCars.get(0), floor, Direction.UP);

        return true;
    }


    boolean operateLiftFrominside(ElevatorCar elevatorCar) {

        // ask elevator operator fill the request in heap;

        return true;
    }

}
