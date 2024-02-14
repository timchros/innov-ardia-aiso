package serrano.map;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import serrano.map.enums.*;


import static serrano.map.enums.Runtime_Param.*;
import static serrano.map.enums.Runtime_Param_Value.*;

public class Mappings {

	private static final 
		Map<Runtime_Param, Map<Tier, Runtime_Param_Value>> map = 
			new HashMap<Runtime_Param, Map<Tier,Runtime_Param_Value>>();
	
	
	private static Mappings instance = null;
	
	public static Mappings getInstance() {
		synchronized (Mappings.class) {
//			if (instance == null) {
				instance  = new Mappings();
//			}
			return instance;
		}
	}
	
	private Mappings() {
		final String log_date_pattern = "yyyy/MM/dd-HH:mm:ss.SSS";
		final DateFormat ldf = new SimpleDateFormat(log_date_pattern);
		System.out.println(ldf.format(new Date()) + " - AISO - Loading Mapping Rules");
		map.put(Isolation, createMap(MINIMAL, YES, YES, YES, MAXIMAL));
		map.put(Encryption, createMap(NO, NO, NO, COULD_HAVE, YES));
		map.put(Spawn_Time, createMap(FAST, FAIR, ULTRA_FAST, FAST, FAIR));
		try { Thread.sleep(300); } catch (InterruptedException e) { }
		//System.out.println("Loading Mapping Rules ... Successfully Completted !");
	}
	
	private static final Map<Tier, Runtime_Param_Value> createMap(Runtime_Param_Value... vals) {
		final Map<Tier, Runtime_Param_Value> map = new HashMap<Tier, Runtime_Param_Value>();
		
		for (int i = 0; i < vals.length; i++) {
			Tier tier = Tier.valueOf("Tier_" + i);
			Runtime_Param_Value val = vals[i];
			map.put(tier, val);
		}
		return map;
	}
	
	public List<Tier> getTiersForRuntimeIsolationValue(Runtime_Param_Value... vals) {
		return getTiersForRuntimeValue(Isolation, vals);
	}
	
	public List<Tier> getTiersForRuntimeEncryptionValue(Runtime_Param_Value... vals) {
		return getTiersForRuntimeValue(Encryption, vals);
	}
	
	public List<Tier> getTiersForRuntimeSpawnTimeValue(Runtime_Param_Value... vals) {
		return getTiersForRuntimeValue(Spawn_Time, vals);
	}
	
	private List<Tier> getTiersForRuntimeValue(Runtime_Param param, Runtime_Param_Value... vals) {
		
		final List<Runtime_Param_Value> valsList = new ArrayList<Runtime_Param_Value>();
		for (Runtime_Param_Value val : vals) {
			valsList.add(val);
		}
		
		if (param.equals(Runtime_Param.Isolation) && vals.length == 1 && vals[0] == Runtime_Param_Value.YES) {
			valsList.add(Runtime_Param_Value.MAXIMAL);
		}	
		
		final List<Tier> tierList = new ArrayList<Tier>();
		for (Entry<Tier, Runtime_Param_Value> entry : map.get(param).entrySet()) {
			if (valsList.contains(entry.getValue())) {
				tierList.add(entry.getKey());
			}
		}
		return tierList;
	}
	
	public static void main(String[] args) {

		System.out.println("Start");
		
		System.out.println(Mappings.getInstance().getTiersForRuntimeEncryptionValue(YES));
		System.out.println(Mappings.getInstance().getTiersForRuntimeEncryptionValue(NO));
		System.out.println(Mappings.getInstance().getTiersForRuntimeIsolationValue(YES, MAXIMAL));
		System.out.println(Mappings.getInstance().getTiersForRuntimeIsolationValue(YES));
		
		System.out.println("End");
	}

}
