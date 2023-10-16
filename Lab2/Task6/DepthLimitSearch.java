package Lab2.Task6;

import Lab2.*;

import java.util.*;

public class DepthLimitSearch {
    public Node execute(Node root, String goal, int limitedDepth) {
        Stack<Node> frontier = new Stack<>();
        root.setDepth(0);
        frontier.add(root);
        List<Node> explored = new ArrayList<>();
        while(!frontier.isEmpty()){
            Node current  = frontier.pop();
            explored.add(current);
            if(current.getDepth() > limitedDepth) continue;
            if(current.getLabel().equals(goal)){
                return current;
            }
            List<Node> children = current.getChildrenNodes();
            for (Node child: children) {
                if(!frontier.contains(child) && !explored.contains(child)){
                    frontier.add(child);
                    child.setParent(current);
                    child.setDepth(current.getDepth()+1);
                }
            }
        }
        return null;
    }
}
