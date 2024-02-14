package serrano.newmap;

import java.util.List;

import serrano.io.ApplicationConstraint;

public interface MRI {
	
	public boolean canFire(ApplicationConstraint appCnstr);
	
	public List<List<Tuple2>> fire(ApplicationConstraint appCnstr);
	
}
