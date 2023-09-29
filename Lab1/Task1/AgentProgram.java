package Lab1.Task1;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		if (p.getLocationState() == Environment.LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		}
		else if (p.getAgentLocation().equals(Environment.LOCATION_A))
			return Environment.MOVE_RIGHT;
		else if (p.getAgentLocation().equals(Environment.LOCATION_B))
			return Environment.MOVE_LEFT;
		return NoOpAction.NO_OP;
	}
}