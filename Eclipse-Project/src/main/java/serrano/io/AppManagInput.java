package serrano.io;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AppManagInput {

	private String appid;
	private String action;
	private String params;
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	
	public boolean isActionValid() {
		if ((appid == null) || appid.trim().equals("")) return false;
		// Valid Actions: START | STOP | STATUS
//		if ("START".equalsIgnoreCase(action)) return true;
//		if ("STOP".equalsIgnoreCase(action)) return true;
		if ("STATUS".equalsIgnoreCase(action)) return true;
//		if ("(RE)DEPLOY".equalsIgnoreCase(action)) return true;
		if ("UNDEPLOY".equalsIgnoreCase(action)) return true;
		return false;
	}
	
	public String asString() {
		return 
			" - appid: " + appid + "\n" + 
			" - action: " + action + "\n" + 
			" - params: " + params;
	}
	
	@Override
	public String toString() {
		return "AppManagInput [appid=" + appid + ", action=" + action + ", params=" + params + "]";
	}
	
}
