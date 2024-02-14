package serrano.iccs.io;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RO_Deployment_Output {

	private String deployment_uuid;

	public String getDeployment_uuid() {
		return deployment_uuid;
	}

	public void setDeployment_uuid(String deployment_uuid) {
		this.deployment_uuid = deployment_uuid;
	}

	@Override
	public String toString() {
		return "RO_Deployment_Output [deployment_uuid=" + deployment_uuid + "]";
	}
	
//	private List<DetailElement> detail;
//
//	public List<DetailElement> getDetail() {
//		return detail;
//	}
//
//	public void setDetail(List<DetailElement> detail) {
//		this.detail = detail;
//	}
//
//	@Override
//	public String toString() {
//		return "RO_Deployment_Output [detail=" + detail + "]";
//	}
	
}
