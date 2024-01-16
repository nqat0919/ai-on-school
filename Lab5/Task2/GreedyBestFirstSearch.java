package Lab5.Task2;

import Lab5.student.*;
import java.util.*;

public class GreedyBestFirstSearch implements IPuzzleAlgo {

    @Override
    public Node execute(Puzzle model) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
        List<Node> explored = new ArrayList<>();
        frontier.add(model.getInitialState());
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            explored.add(current);
            if (current.getH() == 0) return current;
            for (Node child : model.getSuccessors(current)) {
                if (explored.contains(child) || frontier.contains(child)) continue;
                frontier.add(child);
            }
        }
        return null;
    }
}
