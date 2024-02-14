package serrano.newmap;

import java.util.ArrayList;
import java.util.List;

import serrano.io.ApplicationConstraint;

public class MapRule2 implements MRI {

	// TODO: Scan for app_metadata ... and especially for kalman filter or wavewlet
	// Depending on energy constrain
	
	@Override
	public boolean canFire(ApplicationConstraint appCnstr) {
		
		// TODO: Check and Update if being necessary
		if (appCnstr.getComponent_id() == null)
			return false;
		if (!appCnstr.getComponent_id().equalsIgnoreCase("analyse_market"))
			return false;
		
		if (appCnstr.getApp_metadata() == null)
			return false;
		final List<String> metadataList = new ArrayList<String>();
		for (String str : appCnstr.getApp_metadata().split("\\s+")) {
			metadataList.add(str.toLowerCase());
		}
		if (!metadataList.contains("kalman") && !metadataList.contains("wavelet"))
			return false;
		
		if (appCnstr.getEnergy_Consumption() == null)
			return false;
		
		return true;
	}

	@Override
	public List<List<Tuple2>> fire(ApplicationConstraint appCnstr) {
		final String energy = appCnstr.getEnergy_Consumption();
		
		final List<String> metadataList = new ArrayList<String>();
		for (String str : appCnstr.getApp_metadata().split("\\s+")) {
			metadataList.add(str.toLowerCase());
		}
		
		final List<List<Tuple2>> scenariosList = new ArrayList<List<Tuple2>>();
		if (energy.equalsIgnoreCase("LOW") && metadataList.contains("kalman")) {
			List<Tuple2> tupleList = new ArrayList<Tuple2>();
			tupleList.add(new Tuple2("accelerator_type", "U50"));
			scenariosList.add(tupleList);
		}
		return scenariosList;
	}

}
