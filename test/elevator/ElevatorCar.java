package test.elevator;

import java.util.List;

import datastructures.heap.MinHeap;

public class ElevatorCar {

    List<Button> innerButton;
    Floor currentFloor;
    Direction direction;

    MinHeap<Floor> upDirationFloorRequest;
    MaxHeap<Floor> downDirationFloorRequest;

    
}
