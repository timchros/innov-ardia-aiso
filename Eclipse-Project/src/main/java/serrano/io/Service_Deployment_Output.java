package serrano.io;

public class Service_Deployment_Output {
	
	private String deployment_uuid;

	public String getDeployment_uuid() {
		return deployment_uuid;
	}

	public void setDeployment_uuid(String deployment_uuid) {
		this.deployment_uuid = deployment_uuid;
	}

	@Override
	public String toString() {
		return "Service_Deployment_Output [deployment_uuid=" + deployment_uuid + "]";
	}

}
