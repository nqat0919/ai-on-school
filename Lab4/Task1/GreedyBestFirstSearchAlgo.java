package Lab4.Task1;
import Lab4.*;
import java.util.*;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier =
                new PriorityQueue<Node>((node1, node2) -> {
                    int compare = Double.compare(node1.getH(), node2.getH());
                    return (compare == 0) ? node1.getLabel().compareTo(node2.getLabel()) : compare;
                });
        List<Node> explored = new ArrayList<>();
        //        starting
        frontier.offer(root);
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if (current.getLabel().equals(goal)) return current;
            explored.add(current);
            for (Edge edge : current.getChildren()) {
                Node child = edge.getEnd();
//                current path cost from root to this node
                if (explored.contains(child)) continue;
                else {
                    if (!frontier.contains(child)) {
                        child.setParent(current);
                        frontier.add(child);
                        continue;
                    }
                    else
                        child.setParent(current);
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        return null;
    }
}
