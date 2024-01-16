package Lab6.Task3;

import Lab6.student.Node;

public class HillClimbingAlgorithm {

    public Node execute(Node initialState) {
//      Enter your code here.
        Node current = initialState;
        Node neighbour = null;
        while (true) {
            neighbour = current.getBestCandidate();
            if (neighbour.getH() > current.getH()) current = neighbour;
            else {
                return current;
            }
        }
    }
    public Node executeHillClimbingWithRandomRestart(Node initialState) {
//      Enter your code here.
        return null;
    }
}
