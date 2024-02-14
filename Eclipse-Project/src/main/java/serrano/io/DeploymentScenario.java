package serrano.io;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeploymentScenario {

	private String deployment_scenario_id;
	private String component_id;
	private String node_type;
	private String node_cpu_cores;
	private String node_cpu_threads;
	private String node_cpu_architecture;
	private String node_memory_size;
	private String node_network_latency;
	private String node_storage_size;
	private String node_storage_encryption;
	private String node_exec_capability;
	private String hpc_numa_nodes;
	private String accelerator_type;
	private String accelerator_architecture;
	private String gpu_cores;
	private String gpu_capacity;
	private String uc_app_params;
	
	public String asString() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final StringBuilder sb = new StringBuilder();
		for (Method method : this.getClass().getMethods()) {
			if (!method.getName().startsWith("get"))
				continue;
			if (!method.getReturnType().getSimpleName().equals("String"))
				continue;
			final Object obj = method.invoke(this);
			if (obj != null) {
				if (sb.length() > 0) sb.append(" , ");
				sb.append(method.getName().substring(3) + ":" + obj);
			}
		}
		return "DeploymentScenario[ " + sb.toString() + " ]";
	}
	
	public String getNode_type() {
		return node_type;
	}
	public void setNode_type(String node_type) {
		this.node_type = node_type;
	}

	public String getUc_app_params() {
		return uc_app_params;
	}
	public void setUc_app_params(String uc_app_params) {
		this.uc_app_params = uc_app_params;
	}

	public String getDeployment_scenario_id() {
		return deployment_scenario_id;
	}
	public void setDeployment_scenario_id(String deployment_scenario_id) {
		this.deployment_scenario_id = deployment_scenario_id;
	}
	public String getComponent_id() {
		return component_id;
	}
	public void setComponent_id(String component_id) {
		this.component_id = component_id;
	}
	public String getNode_cpu_cores() {
		return node_cpu_cores;
	}
	public void setNode_cpu_cores(String node_cpu_cores) {
		this.node_cpu_cores = node_cpu_cores;
	}
	public String getNode_cpu_threads() {
		return node_cpu_threads;
	}
	public void setNode_cpu_threads(String node_cpu_threads) {
		this.node_cpu_threads = node_cpu_threads;
	}
	public String getNode_cpu_architecture() {
		return node_cpu_architecture;
	}
	public void setNode_cpu_architecture(String node_cpu_architecture) {
		this.node_cpu_architecture = node_cpu_architecture;
	}
	public String getNode_memory_size() {
		return node_memory_size;
	}
	public void setNode_memory_size(String node_memory_size) {
		this.node_memory_size = node_memory_size;
	}
	public String getNode_network_latency() {
		return node_network_latency;
	}
	public void setNode_network_latency(String node_network_latency) {
		this.node_network_latency = node_network_latency;
	}
	public String getNode_storage_size() {
		return node_storage_size;
	}
	public void setNode_storage_size(String node_storage_size) {
		this.node_storage_size = node_storage_size;
	}
	public String getNode_storage_encryption() {
		return node_storage_encryption;
	}
	public void setNode_storage_encryption(String node_storage_encryption) {
		this.node_storage_encryption = node_storage_encryption;
	}
	public String getNode_exec_capability() {
		return node_exec_capability;
	}
	public void setNode_exec_capability(String node_exec_capability) {
		this.node_exec_capability = node_exec_capability;
	}
	public String getHpc_numa_nodes() {
		return hpc_numa_nodes;
	}
	public void setHpc_numa_nodes(String hpc_numa_nodes) {
		this.hpc_numa_nodes = hpc_numa_nodes;
	}
	public String getAccelerator_type() {
		return accelerator_type;
	}
	public void setAccelerator_type(String accelerator_type) {
		this.accelerator_type = accelerator_type;
	}
	public String getAccelerator_architecture() {
		return accelerator_architecture;
	}
	public void setAccelerator_architecture(String accelerator_architecture) {
		this.accelerator_architecture = accelerator_architecture;
	}
	public String getGpu_cores() {
		return gpu_cores;
	}
	public void setGpu_cores(String gpu_cores) {
		this.gpu_cores = gpu_cores;
	}
	public String getGpu_capacity() {
		return gpu_capacity;
	}
	public void setGpu_capacity(String gpu_capacity) {
		this.gpu_capacity = gpu_capacity;
	}

//	@Override
//	public String toString() {
//		return "DeploymentScenario [deployment_scenario_id=" + deployment_scenario_id + ", component_id=" + component_id
//				+ ", node_type=" + node_type + ", node_cpu_cores=" + node_cpu_cores + ", node_cpu_threads="
//				+ node_cpu_threads + ", node_cpu_architecture=" + node_cpu_architecture + ", node_memory_size="
//				+ node_memory_size + ", node_network_latency=" + node_network_latency + ", node_storage_size="
//				+ node_storage_size + ", node_storage_encryption=" + node_storage_encryption + ", node_exec_capability="
//				+ node_exec_capability + ", hpc_numa_nodes=" + hpc_numa_nodes + ", accelerator_type=" + accelerator_type
//				+ ", accelerator_architecture=" + accelerator_architecture + ", gpu_cores=" + gpu_cores
//				+ ", gpu_capacity=" + gpu_capacity + ", uc_app_params=" + uc_app_params + "]";
//	}

	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("deployment_scenario_id=" + deployment_scenario_id);
		if (component_id != null) sb.append(" , component_id=" + component_id);
		if (node_type != null) sb.append(" , node_type=" + node_type);
		if (node_cpu_cores != null) sb.append(" , node_cpu_cores=" + node_cpu_cores);
		if (node_cpu_threads != null) sb.append(" , node_cpu_threads=" + node_cpu_threads);
		if (node_cpu_architecture != null) sb.append(" , node_cpu_architecture=" + node_cpu_architecture);
		if (node_memory_size != null) sb.append(" , node_memory_size=" + node_memory_size);
		if (node_network_latency != null) sb.append(" , node_network_latency=" + node_network_latency);
		if (node_storage_size != null) sb.append(" , node_storage_size=" + node_storage_size);
		if (node_storage_encryption != null) sb.append(" , node_storage_encryption=" + node_storage_encryption);
		if (node_exec_capability != null) sb.append(" , node_exec_capability=" + node_exec_capability);
		if (hpc_numa_nodes != null) sb.append(" , hpc_numa_nodes=" + hpc_numa_nodes);
		if (accelerator_type != null) sb.append(" , accelerator_type=" + accelerator_type);
		if (accelerator_architecture != null) sb.append(" , accelerator_architecture=" + accelerator_architecture);
		if (gpu_cores != null) sb.append(" , gpu_cores=" + gpu_cores);
		if (gpu_capacity != null) sb.append(" , gpu_capacity=" + gpu_capacity);
		if (uc_app_params != null) sb.append(" , uc_app_params=" + uc_app_params);
		
		return "{ " + sb.toString() + " }";
	}	
	
}
