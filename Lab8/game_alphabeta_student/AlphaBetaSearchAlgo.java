package Lab8.game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) return node.getValue();
		int v = Integer.MIN_VALUE;
		var children = node.getChildren();
		children.sort(Node.LabelComparator);
		for (int i = 0; i < children.size(); i++) {
			v = Math.max(v, minValue(children.get(i), alpha, beta));
			if (v >= beta) {
				for (int j = i; j < children.size(); j++) System.out.println("Cắt nhánh: "+children.get(j).getLabel());
				return v;
			}
			alpha = Math.max(alpha, v);
		}
		node.setValue(v);
		return v;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		return Integer.MAX_VALUE;
	}
}
