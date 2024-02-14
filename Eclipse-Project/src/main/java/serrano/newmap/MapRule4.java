package serrano.newmap;

import java.util.ArrayList;
import java.util.List;

import serrano.io.ApplicationConstraint;


public class MapRule4 implements MRI {

	@Override
	public boolean canFire(ApplicationConstraint appCnstr) {
		
		final String microservice = "classifier-training";
		
		if (appCnstr.getComponent_id() == null)
			return false;
		if (!appCnstr.getComponent_id().equalsIgnoreCase(microservice))
			return false;
		
		if (appCnstr.getApplication_Performance_Total_Execution_Time() == null)
			return false;
		if (!appCnstr.getApplication_Performance_Total_Execution_Time().equalsIgnoreCase("LOW"))
			return false;
		
		if (appCnstr.getApplication_Performance_Response_Latency() == null)
			return false;
		if (!appCnstr.getApplication_Performance_Response_Latency().equalsIgnoreCase("LOW"))
			return false;
		
		return true;
	}

	@Override
	public List<List<Tuple2>> fire(ApplicationConstraint appCnstr) {
		final List<List<Tuple2>> scenariosList = new ArrayList<List<Tuple2>>();
		List<Tuple2> tupleList = new ArrayList<Tuple2>();
		tupleList.add(new Tuple2("node_type", "EDGE_DEVICE"));
		tupleList.add(new Tuple2("accelerator_type", "U50"));
		scenariosList.add(tupleList);
		return scenariosList;
	}

}
