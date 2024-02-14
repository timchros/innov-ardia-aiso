package serrano.newmap;

import java.util.ArrayList;
import java.util.List;

import serrano.io.ApplicationConstraint;

public class MapRule1 implements MRI {

	@Override
	public boolean canFire(ApplicationConstraint appCnstr) {
	
		// Check prerequisites
		
		if (appCnstr.getComponent_id() == null)
			return false;
		
		final String microservice1 = "position-service-classifier-training";
		final String microservice2 = "acceleration-service-classifier-training";
		final String microservice3 = "faaspositionclassifiertrainer";
		
		if ( (!appCnstr.getComponent_id().equalsIgnoreCase(microservice1)) && 
				(!appCnstr.getComponent_id().equalsIgnoreCase(microservice2)) && 
				(!appCnstr.getComponent_id().equalsIgnoreCase(microservice3)) )
			return false;
		
		if (appCnstr.getApplication_Performance_Total_Execution_Time() == null)
			return false;
		
		// constrains with specific value
		// constrain about a value
		return true;
	}
	
	@Override
	public List<List<Tuple2>> fire(ApplicationConstraint appCnstr) {

		final String execTime = appCnstr.getApplication_Performance_Total_Execution_Time();
		
		final List<List<Tuple2>> scenariosList = new ArrayList<List<Tuple2>>();
		
		if (execTime.equalsIgnoreCase("LOW")) {
			List<Tuple2> tupleList = new ArrayList<Tuple2>();
			//tupleList.add(new Tuple2("node_type", "HPC"));
			tupleList.add(new Tuple2("node_type", "CLOUD"));
			scenariosList.add(tupleList);
		} else {
			String[] tokens = execTime.split("\\s+");
			if (tokens.length == 3 && tokens[0].equals("</=") && tokens[2].equalsIgnoreCase("ms")) {
				// Case 1: HPC
				List<Tuple2> tupleList1 = new ArrayList<Tuple2>();
				// tupleList1.add(new Tuple2("node_type", "HPC"));
				tupleList1.add(new Tuple2("node_type", "CLOUD"));
				scenariosList.add(tupleList1);
				// Case 2: Edge Device & No. Data Batches 
				int n = Integer.parseInt(tokens[1]);
//				for (int i = 250; i>0; i-=50) {
//					// TODO: Use model for predicting expected execution time
//					// if acceptable break and return/add to list Tuple(no_data_batches, "< " + i)
//				}
				// Example
				if (n == 200) {
					List<Tuple2> tupleList2 = new ArrayList<Tuple2>();
					tupleList2.add(new Tuple2("node_type", "EDGE_DEVICE"));
					tupleList2.add(new Tuple2("uc_app_params", "no_data_batches < 150"));
					scenariosList.add(tupleList2);
				}
				
				
			}
		}
		
		// when execution time low return node_type = HPC
		// when  execution time below value return one or more options (i.e., HPC or Edge Device and UC constrain about batch size)
		return scenariosList;
	}
	
	
}
