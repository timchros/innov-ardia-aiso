package serrano.work;

import java.util.ArrayList;
import java.util.List;

public abstract class MappingRule implements I_Transform {

	final List<String> sourceParams;
	final String targetParam;

	public MappingRule(String sourceParam, String targetParam) {
		List<String> sourceParamsAL = new ArrayList<String>();
		sourceParamsAL.add(sourceParam);
		this.sourceParams = sourceParamsAL;
		this.targetParam = targetParam;
	}
	
	public MappingRule(List<String> sourceParams, String targetParam) {
		this.sourceParams = sourceParams;
		this.targetParam = targetParam;
	}

	public List<String> getSourceParams() {
		return sourceParams;
	}

	public String getTargetParam() {
		return targetParam;
	}

	@Override
	public String toString() {
		return "MappingRule [sourceParams=" + sourceParams + ", targetParam=" + targetParam + "]";
	}
	
}
