package serrano.io;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Service_Input {

	private String user_id;
	private String deployment_descriptor_yaml;
	private List<ApplicationConstraint> application_constraints;
	private List<ComponentInteraction> application_workflow;
	
	@XmlRootElement
	public static class ComponentInteraction {
		private String component_id; 
		private String input; 
		private String output; 
		private List<String> previous_component_id;
		public String getComponent_id() {
			return component_id;
		}
		public void setComponent_id(String component_id) {
			this.component_id = component_id;
		}
		public String getInput() {
			return input;
		}
		public void setInput(String input) {
			this.input = input;
		}
		public String getOutput() {
			return output;
		}
		public void setOutput(String output) {
			this.output = output;
		}
		public List<String> getPrevious_component_id() {
			return previous_component_id;
		}
		public void setPrevious_component_id(List<String> previous_component_id) {
			this.previous_component_id = previous_component_id;
		}
		@Override
		public String toString() {
			return "ComponentInteraction [component_id=" + component_id + ", input=" + input + ", output=" + output
					+ ", previous_component_id=" + previous_component_id + "]";
		}
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDeployment_descriptor_yaml() {
		return deployment_descriptor_yaml;
	}

	public void setDeployment_descriptor_yaml(String deployment_descriptor_yaml) {
		this.deployment_descriptor_yaml = deployment_descriptor_yaml;
	}

	public List<ApplicationConstraint> getApplication_constraints() {
		return application_constraints;
	}

	public void setApplication_constraints(List<ApplicationConstraint> application_constraints) {
		this.application_constraints = application_constraints;
	}

	public List<ComponentInteraction> getApplication_workflow() {
		return application_workflow;
	}

	public void setApplication_workflow(List<ComponentInteraction> application_workflow) {
		this.application_workflow = application_workflow;
	}

	public String asString() {
		return 
			"** user_id: " + user_id + " " +
			"** deployment_descriptor_yaml:\n" + deployment_descriptor_yaml + "\n" +
			"** application_constraints:\n" + application_constraints + "\n" +
			"** application_workflow:\n" + application_workflow;

	}
	
	public String asString2() {
		return 
			" - user_id: " + user_id + "\n" +
			" - deployment_descriptor_yaml: " + deployment_descriptor_yaml + "\n" +
			" - application_constraints: " + application_constraints + "\n" +
			" - application_workflow: " + application_workflow;

	}
	
	@Override
	public String toString() {
		return "Service_Input [ user_id=" + user_id + ", " + "\n\t"
				+ "deployment_descriptor_yaml=" + deployment_descriptor_yaml + ", " + "\n\t"
				+ "application_constraints=" + application_constraints + ", " + "\n\t"
				+ "application_workflow=" + application_workflow  + "\n\t"
				+ "]";
	}
	
}
