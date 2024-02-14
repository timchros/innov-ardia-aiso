package serrano.iccs.io;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class K8sClusterData {

	private List<NodeData> inventory;
	
	private String name;
	private Long timestamp;
	private String type;
	private String uuid;
	
	@XmlRootElement
	public static class NodeData {
		
		private List<String> node_annotations;
		private NodeCapacity node_capacity;
		private NodeInfo node_info;
		private List<String> node_labels;
		private String node_name;
		private String node_role;
		
		@XmlRootElement
		public static class NodeCapacity {
			private Integer cpu;
			private String memory;
			private Integer  node_storage;
			private Integer pods;
			private Integer  total_fpga;
			private Integer  total_gpu;
			
			/*
                "ephemeral-storage": "203056560Ki",
                "hugepages-1Gi": "0",
                "hugepages-2Mi": "0",
			*/
			
			public Integer  getCpu() {
				return cpu;
			}
			public void setCpu(Integer  cpu) {
				this.cpu = cpu;
			}
			public String getMemory() {
				return memory;
			}
			public void setMemory(String memory) {
				this.memory = memory;
			}
			public Integer getNode_storage() {
				return node_storage;
			}
			public void setNode_storage(Integer node_storage) {
				this.node_storage = node_storage;
			}
			public Integer getPods() {
				return pods;
			}
			public void setPods(Integer pods) {
				this.pods = pods;
			}
			public Integer getTotal_fpga() {
				return total_fpga;
			}
			public void setTotal_fpga(Integer total_fpga) {
				this.total_fpga = total_fpga;
			}
			public Integer getTotal_gpu() {
				return total_gpu;
			}
			public void setTotal_gpu(Integer total_gpu) {
				this.total_gpu = total_gpu;
			}
			
			@Override
			public String toString() {
				return "NodeCapacity [cpu=" + cpu + ", memory=" + memory + ", node_storage=" + node_storage + ", pods="
						+ pods + ", total_fpga=" + total_fpga + ", total_gpu=" + total_gpu + "]";
			}
			
		}
		
		@XmlRootElement
		public static class NodeInfo {
			
			private String architecture;
			private String operating_system;
			private String os_image;
			private String system_uuid;
			
			/*
	            "boot_id": "4b25a5a6-e68c-434d-a18e-5c75b4f198ba",
	            "container_runtime_version": "containerd://1.6.6",
	            "kernel_version": "5.15.0-41-generic",
	            "kube_proxy_version": "v1.24.3",
	            "kubelet_version": "v1.24.3",
	            "machine_id": "170bcafcd1394c598b83310a5af71d06",
			 */		
				
			public String getArchitecture() {
				return architecture;
			}
			public void setArchitecture(String architecture) {
				this.architecture = architecture;
			}
			public String getOperating_system() {
				return operating_system;
			}
			public void setOperating_system(String operating_system) {
				this.operating_system = operating_system;
			}
			public String getOs_image() {
				return os_image;
			}
			public void setOs_image(String os_image) {
				this.os_image = os_image;
			}
			public String getSystem_uuid() {
				return system_uuid;
			}
			public void setSystem_uuid(String system_uuid) {
				this.system_uuid = system_uuid;
			}
			
			@Override
			public String toString() {
				return "NodeInfo [architecture=" + architecture + ", operating_system=" + operating_system
						+ ", os_image=" + os_image + ", system_uuid=" + system_uuid + "]";
			}
			
		}

		public List<String> getNode_annotations() {
			return node_annotations;
		}

		public void setNode_annotations(List<String> node_annotations) {
			this.node_annotations = node_annotations;
		}

		public NodeCapacity getNode_capacity() {
			return node_capacity;
		}

		public void setNode_capacity(NodeCapacity node_capacity) {
			this.node_capacity = node_capacity;
		}

		public NodeInfo getNode_info() {
			return node_info;
		}

		public void setNode_info(NodeInfo node_info) {
			this.node_info = node_info;
		}

		public List<String> getNode_labels() {
			return node_labels;
		}

		public void setNode_labels(List<String> node_labels) {
			this.node_labels = node_labels;
		}

		public String getNode_name() {
			return node_name;
		}

		public void setNode_name(String node_name) {
			this.node_name = node_name;
		}

		public String getNode_role() {
			return node_role;
		}

		public void setNode_role(String node_role) {
			this.node_role = node_role;
		}

		@Override
		public String toString() {
			return "NodeData [node_annotations=" + node_annotations + ", node_capacity=" + node_capacity
					+ ", node_info=" + node_info + ", node_labels=" + node_labels + ", node_name=" + node_name
					+ ", node_role=" + node_role + "]";
		}
		
	}

	public List<NodeData> getInventory() {
		return inventory;
	}

	public void setInventory(List<NodeData> inventory) {
		this.inventory = inventory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
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
		return "ClusterData [inventory=" + inventory + ", name=" + name + ", timestamp=" + timestamp + ", type=" + type + ", uuid=" + uuid + "]";
	}
	
}
