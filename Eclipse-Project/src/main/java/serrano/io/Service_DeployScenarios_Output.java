package serrano.io;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Service_DeployScenarios_Output {

	private String name;

	private String deployment_description;
	
	private List<DeploymentScenario> deployment_objectives;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeployment_description() {
		return deployment_description;
	}

	public void setDeployment_description(String deployment_description) {
		this.deployment_description = deployment_description;
	}

	public List<DeploymentScenario> getDeployment_objectives() {
		return deployment_objectives;
	}

	public void setDeployment_objectives(List<DeploymentScenario> deployment_objectives) {
		this.deployment_objectives = deployment_objectives;
	}
	
	public String asString() {
		return 
			"** name: " + name + " " +
			"** deployment_description:\n" + deployment_description + "\n" +
			"** deployment_objectives:\n" + deployment_objectives;
	}

	public String asString2() {
		return 
			" - name: " + name + " " + "\n" +
			" - deployment_description: " + deployment_description + "\n" +
			" - deployment_objectives: " + deployment_objectives;
	}

	@Override
	public String toString() {
		return 
			"Service_DeployScenarios_Output [" +
				"name=" + name + ", " +
				"deployment_description.length()=" + 
					((deployment_description != null) ? deployment_description.length() : "NULL") + ", " + 
				"deployment_objectives.size()=" + 
					((deployment_objectives != null) ? deployment_objectives.size() : "NULL") + 
			"]";
	}
	
	

}
