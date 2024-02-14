package serrano.iccs.io;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClusterMetrics {

	private List<ClusterElement> metrics;

	@XmlRootElement
	public static class ClusterElement {

		private String cluster_uuid;
		private ClusterState state;
		private Integer timestamp;
		
		@XmlRootElement
		public static class ClusterState {
			
			@XmlAttribute(name="Deployments")
			private List<Deployment> deployments;
			@XmlAttribute(name="Nodes")
			private List<Node> nodes;
			@XmlAttribute(name="PersistentVolumes")
			private List<PersistentVolume> persistentVolumes;
			@XmlAttribute(name="Pods")
			private List<Pod> pods;
			
			@XmlRootElement
			public static class Deployment {
				
				private Integer available_replicas;
                private String creation_timestamp;
				private String name;
				private String namespace;
                private Integer ready_replicas;
                private Integer replicas;
                
				public Integer getAvailable_replicas() {
					return available_replicas;
				}
				public void setAvailable_replicas(Integer available_replicas) {
					this.available_replicas = available_replicas;
				}
				public String getCreation_timestamp() {
					return creation_timestamp;
				}
				public void setCreation_timestamp(String creation_timestamp) {
					this.creation_timestamp = creation_timestamp;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public String getNamespace() {
					return namespace;
				}
				public void setNamespace(String namespace) {
					this.namespace = namespace;
				}
				public Integer getReady_replicas() {
					return ready_replicas;
				}
				public void setReady_replicas(Integer ready_replicas) {
					this.ready_replicas = ready_replicas;
				}
				public Integer getReplicas() {
					return replicas;
				}
				public void setReplicas(Integer replicas) {
					this.replicas = replicas;
				}
				@Override
				public String toString() {
					return "Deployment [available_replicas=" + available_replicas + ", creation_timestamp="
							+ creation_timestamp + ", name=" + name + ", namespace=" + namespace + ", ready_replicas="
							+ ready_replicas + ", replicas=" + replicas + "]";
				}
			}
			
			@XmlRootElement
			public static class Node {
				
				private String node_name;
				private List<NodeCpu> node_cpus;
				private Integer node_total_running_pods;
				
				@XmlRootElement
				public static class NodeCpu {
					private String idle;
					private String label;
					private String used;
					public String getIdle() {
						return idle;
					}
					public void setIdle(String idle) {
						this.idle = idle;
					}
					public String getLabel() {
						return label;
					}
					public void setLabel(String label) {
						this.label = label;
					}
					public String getUsed() {
						return used;
					}
					public void setUsed(String used) {
						this.used = used;
					}
					@Override
					public String toString() {
						return "NodeCpu [idle=" + idle + ", label=" + label + ", used=" + used + "]";
					}
				}
				
				/*	
					"node_boot_time_seconds": 1659611767.0,
	                "node_filesystem_avail_bytes": 153070616576.0,
	                "node_filesystem_free_bytes": 153087393792.0,
	                "node_filesystem_size_bytes": 207929917440.0,
	                "node_filesystem_usage_percentage": 26.38,
	                "node_filesystem_used_bytes": 54842523648.0,
	                "node_memory_Buffers_bytes": 377978880.0,
	                "node_memory_Cached_bytes": 53994520576.0,
	                "node_memory_MemAvailable_bytes": 64850436096.0,
	                "node_memory_MemFree_bytes": 8056455168.0,
	                "node_memory_MemTotal_bytes": 67436380160.0,
	                "node_memory_MemUsed_bytes": 59379924992.0,
	                "node_memory_usage_percentage": 88.05,
	                "node_network_receive_bytes_total": 310996585368.0,
	                "node_network_receive_drop_total": 8.0,
	                "node_network_receive_errs_total": 0.0,
	                "node_network_receive_packets_total": 723515789.0,
	                "node_network_transmit_bytes_total": 243059711839.0,
	                "node_network_transmit_drop_total": 5.0,
	                "node_network_transmit_errs_total": 0.0,
	                "node_network_transmit_packets_total": 730843076.0,
	
			 	*/	

				public String getNode_name() {
					return node_name;
				}

				public void setNode_name(String node_name) {
					this.node_name = node_name;
				}

				public List<NodeCpu> getNode_cpus() {
					return node_cpus;
				}

				public void setNode_cpus(List<NodeCpu> node_cpus) {
					this.node_cpus = node_cpus;
				}

				public Integer getNode_total_running_pods() {
					return node_total_running_pods;
				}

				public void setNode_total_running_pods(Integer node_total_running_pods) {
					this.node_total_running_pods = node_total_running_pods;
				}

				@Override
				public String toString() {
					return "Node [node_name=" + node_name + ", node_cpus=" + node_cpus + ", node_total_running_pods="
							+ node_total_running_pods + "]";
				}
				
			}
			
			@XmlRootElement
			public static class PersistentVolume {
				private String creation_timestamp;
				private String name;
				private Capacity capacity;
				
				@XmlRootElement
				public static class Capacity {
					
					private String storage;

					public String getStorage() {
						return storage;
					}
					public void setStorage(String storage) {
						this.storage = storage;
					}
					@Override
					public String toString() {
						return "Capacity [storage=" + storage + "]";
					}
				}

				public String getCreation_timestamp() {
					return creation_timestamp;
				}

				public void setCreation_timestamp(String creation_timestamp) {
					this.creation_timestamp = creation_timestamp;
				}

				public String getName() {
					return name;
				}

				public void setName(String name) {
					this.name = name;
				}

				public Capacity getCapacity() {
					return capacity;
				}

				public void setCapacity(Capacity capacity) {
					this.capacity = capacity;
				}

				@Override
				public String toString() {
					return "PersistentVolume [creation_timestamp=" + creation_timestamp + ", name=" + name
							+ ", capacity=" + capacity + "]";
				}
			}
			
			@XmlRootElement
			public static class Pod {
				
				private String name; 
				private String node;
				private String phase;
				private PodUsage usage;
				
				/*
	                {
	                    "creation_timestamp": 1658767835.0,
	                    "host_ip": "10.251.251.191",
	                    "namespace": "cert-manager",
	                    "node": "serrano-k8s-worker-02",
	                    "pod_ip": "10.244.4.2",
	                    "restarts": 0,
	                    "start_time": 1658767835.0,
	                }
				*/
				
				@XmlRootElement
				public static class PodUsage {
					private String cpu;
					private String memory;
					public String getCpu() {
						return cpu;
					}
					public void setCpu(String cpu) {
						this.cpu = cpu;
					}
					public String getMemory() {
						return memory;
					}
					public void setMemory(String memory) {
						this.memory = memory;
					}
					@Override
					public String toString() {
						return "PodUsage [cpu=" + cpu + ", memory=" + memory + "]";
					}
				}

				public String getName() {
					return name;
				}

				public void setName(String name) {
					this.name = name;
				}

				public String getNode() {
					return node;
				}

				public void setNode(String node) {
					this.node = node;
				}

				public String getPhase() {
					return phase;
				}

				public void setPhase(String phase) {
					this.phase = phase;
				}

				public PodUsage getUsage() {
					return usage;
				}

				public void setUsage(PodUsage usage) {
					this.usage = usage;
				}

				@Override
				public String toString() {
					return "Pod [name=" + name + ", node=" + node + ", phase=" + phase + ", usage=" + usage + "]";
				}
				
			}

			public List<Deployment> getDeployments() {
				return deployments;
			}

			public void setDeployments(List<Deployment> deployments) {
				this.deployments = deployments;
			}

			public List<Node> getNodes() {
				return this.nodes;
			}

			public void setNodes(List<Node> nodes) {
				this.nodes = nodes;
			}

			public List<PersistentVolume> getPersistentVolumes() {
				return this.persistentVolumes;
			}

			public void setPersistentVolumes(List<PersistentVolume> persistentVolumes) {
				this.persistentVolumes = persistentVolumes;
			}

			public List<Pod> getPods() {
				return this.pods;
			}

			public void setPods(List<Pod> pods) {
				this.pods = pods;
			}

			@Override
			public String toString() {
				return "ClusterState [" + "\n\t"
						+ "deployments=" + deployments + ", " + "\n\t"
						+ "nodes=" + nodes + ", " + "\n\t"
						+ "persistentVolumes=" + persistentVolumes + ", " + "\n\t"
						+ "pods=" + pods + "\n" + 
					"]";
			}
			
		}

		public String getCluster_uuid() {
			return cluster_uuid;
		}

		public void setCluster_uuid(String cluster_uuid) {
			this.cluster_uuid = cluster_uuid;
		}

		public ClusterState getState() {
			return state;
		}

		public void setState(ClusterState state) {
			this.state = state;
		}

		public Integer getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Integer timestamp) {
			this.timestamp = timestamp;
		}

		@Override
		public String toString() {
			return "ClusterElement [cluster_uuid=" + cluster_uuid + ", state=" + state + ", timestamp=" + timestamp
					+ "]";
		}
		
	}
	
	public List<ClusterElement> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<ClusterElement> metrics) {
		this.metrics = metrics;
	}

	@Override
	public String toString() {
		return "ClusterMetrics [metrics=" + metrics + "]";
	}
	
}
