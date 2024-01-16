package Lab4.Task2;

import Lab4.Edge;
import Lab4.IInformedSearchAlgo;
import Lab4.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier =
                new PriorityQueue<Node>((node1, node2) -> {
                    int compare = Double.compare(node1.getH() + node1.getG(), node2.getH() + node2.getG());
                    return (compare == 0) ? node1.getLabel().compareTo(node2.getLabel()) : compare;
                });
        List<Node> explored = new ArrayList<>();
//                starting
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
                        child.setG(current.getG() + edge.getWeight());
                        child.setParent(current);
                        frontier.add(child);
                        continue;
                    }
                    else {
                        double minG = Math.min(child.getG(), current.getG() + edge.getWeight());
                        Node minParent = Double.compare(minG, child.getG()) == 0 ? child.getParent() : current;
                        frontier.remove(child);
                        child.setG(minG);
                        child.setParent(minParent);
                        frontier.add(child);
                    }
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
