package serrano.iccs.io;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InventoryElement {

	private String type; 
	private String uuid;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Override
	public String toString() {
		return "InventoryElement [type=" + type + ", uuid=" + uuid + "]";
	}
	
}
