package serrano.iccs.io;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TelemetryCentralInventoryOutput {

	private List<InventoryElement> uuids;

	public List<InventoryElement> getUuids() {
		return uuids;
	}

	public void setUuids(List<InventoryElement> uuids) {
		this.uuids = uuids;
	}

	@Override
	public String toString() {
		return "TelemetryCentralInventoryOutput [uuids=" + uuids + "]";
	}
	
}
