package serrano.newmap;

import java.util.ArrayList;
import java.util.List;

import serrano.io.ApplicationConstraint;

public class MapRule5 implements MRI {

	@Override
	public boolean canFire(ApplicationConstraint appCnstr) {
		final String microservice = "faaspositioninference";
		
		if (appCnstr.getComponent_id() == null)
			return false;
		if (!appCnstr.getComponent_id().equalsIgnoreCase(microservice))
			return false;
		
		if (appCnstr.getEnergy_Consumption() == null)
			return false;
		if (!appCnstr.getEnergy_Consumption().equalsIgnoreCase("MEDIUM"))
			return false;
		
		return true;
	}

	@Override
	public List<List<Tuple2>> fire(ApplicationConstraint appCnstr) {
		final List<List<Tuple2>> scenariosList = new ArrayList<List<Tuple2>>();
		List<Tuple2> tupleList = new ArrayList<Tuple2>();
		tupleList.add(new Tuple2("node_type", "EDGE_DEVICE"));
		tupleList.add(new Tuple2("accelerator_type", "U200"));
		scenariosList.add(tupleList);
		return scenariosList;
	}

}
