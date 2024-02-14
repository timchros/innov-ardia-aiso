package serrano.newmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import serrano.io.ApplicationConstraint;
import serrano.map.Mappings;
import serrano.map.enums.Runtime_Param_Value;
import serrano.map.enums.Tier;

public class MapRule3 implements MRI {

	@Override
	public boolean canFire(ApplicationConstraint appCnstr) {
		boolean flag1 = appCnstr.getRuntime_isolation() != null;
		boolean flag2 = appCnstr.getRuntime_encryption() != null;
		boolean flag3 = appCnstr.getRuntime_spawn_time() != null;
		return (flag1 || flag2 || flag3);
	}

	@Override
	public List<List<Tuple2>> fire(ApplicationConstraint appCnstr) {
		final List<List<Tier>> tierList = new ArrayList<List<Tier>>();
		if (appCnstr.getRuntime_isolation() != null) {
			final List<Tier> tmpList = Mappings.getInstance()
				.getTiersForRuntimeIsolationValue(
					Runtime_Param_Value.valueOf(
							appCnstr.getRuntime_isolation().toUpperCase()));
			tierList.add(tmpList);
		}
		if (appCnstr.getRuntime_encryption() != null) {
			final List<Tier> tmpList = Mappings.getInstance()
				.getTiersForRuntimeEncryptionValue(
					Runtime_Param_Value.valueOf(
							appCnstr.getRuntime_encryption().toUpperCase()));
			tierList.add(tmpList);
		}
		if (appCnstr.getRuntime_spawn_time() != null) {
			final List<Tier> tmpList = Mappings.getInstance()
				.getTiersForRuntimeSpawnTimeValue(
					Runtime_Param_Value.valueOf(
							appCnstr.getRuntime_spawn_time().toUpperCase()));
			tierList.add(tmpList);			
		}
		
		// Keep only commons
		final Set<Tier> tierSet = new HashSet<Tier>();
		for (List<Tier> list : tierList) {
			tierSet.addAll(list);
		} 
		final Set<Tier> commonTierSet = new HashSet<Tier>();
		for (Tier tier : tierSet) {
			boolean existsInALL = true;
			for (List<Tier> list : tierList) {
				if (!list.contains(tier)) {
					existsInALL = false; break;
				}
			}
			if (existsInALL) {
				commonTierSet.add(tier);
			}
		}
		
		final List<List<Tuple2>> scenariosList = new ArrayList<List<Tuple2>>();
		List<Tuple2> tupleList = new ArrayList<Tuple2>();
		if (!commonTierSet.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			final List<Tier> tmpList = new ArrayList<Tier>(commonTierSet);
			Collections.sort(tmpList, new Comparator<Tier>() {
				@Override public int compare(Tier t1, Tier t2) {
					return t1.name().compareTo(t2.name());
				}
			});
			for (Tier tier : tmpList) {
				sb.append(tier.name() + " ");
			}
			tupleList.add(new Tuple2("tiers", sb.toString().trim()));
			scenariosList.add(tupleList);
		}	
		return scenariosList;
	}

}
