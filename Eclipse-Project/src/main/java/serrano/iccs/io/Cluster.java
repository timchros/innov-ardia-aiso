package serrano.iccs.io;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cluster {
	
	private String name;
	private String type;
	private String uuid;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
		return "Cluster [name=" + name + ", type=" + type + ", uuid=" + uuid + "]";
	}
	
}
