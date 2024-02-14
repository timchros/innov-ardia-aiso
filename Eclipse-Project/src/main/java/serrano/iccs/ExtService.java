package serrano.iccs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import serrano.iccs.io.Cluster;
import serrano.iccs.io.K8sClusterData;
import serrano.iccs.io.ClusterList;
import serrano.iccs.io.ClusterMetrics;
import serrano.iccs.io.InventoryElement;
import serrano.iccs.io.RO_Deployment_Output;
import serrano.iccs.io.TelemetryCentralInventoryOutput;
import serrano.io.Service_DeployScenarios_Output;

public class ExtService {

	public static final String RESOURCE_ORCHESTRATOR = 
		// "https://resource-orchestrator.services.cloud.ict-serrano.eu";
		"http://85.120.206.26:30100";
	public static final String orchestrator_deployment_url = 
			RESOURCE_ORCHESTRATOR + "/api/v1/orchestrator/deployments";
	
	public static synchronized RO_Deployment_Output orchestrator_deployment(Service_DeployScenarios_Output trans_input) {
		try {
			final Client client = Client.create();
			final WebResource webResource = client.resource(orchestrator_deployment_url);
			final RO_Deployment_Output deployOut = 
				webResource.accept("application/json").type("application/json").post(RO_Deployment_Output.class, trans_input);
			System.out.println("Resource Orchestrator: " + deployOut);
			return deployOut;
		} catch (Throwable t) {
			throw new RuntimeException("RO service call problem !REQUEST: POST " + orchestrator_deployment_url, t);
		}
	}
	
	public static synchronized Object getDeploymentStatus(String uuid) {
		if ((uuid == null) || uuid.trim().equals("")) return null;
		final String theOrchDeployURL = orchestrator_deployment_url + "/" + uuid;
		try {
			final Client client = Client.create();
			final WebResource webResource = client.resource(theOrchDeployURL);
			final ClientResponse deploStatObj = 
					webResource.accept("application/json").type("application/json")
					.get(ClientResponse.class);			
			final InputStream inputStream = deploStatObj.getEntityInputStream();
			final String result = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
			return result;
		} catch (Throwable t) {
			throw new RuntimeException("RO service call problem ! REQUEST: GET " + theOrchDeployURL, t);
		}	
	}
	
	public static synchronized Object deleteDeployment(String uuid) {
		if ((uuid == null) || uuid.trim().equals("")) return null;
		final String theOrchDeployURL = orchestrator_deployment_url + "/" + uuid;
		try {
			final Client client = Client.create();
			final WebResource webResource = client.resource(theOrchDeployURL);
			//final Object deployOut = webResource.accept("application/json").get(Object.class);
			final Object deleRespObj = 
					webResource.accept("application/json").type("application/json")
					.delete(Object.class);
			//deployOut.getEntity(String.class);
			
			System.out.println("Delete-Deployment: " + deleRespObj);
			//System.out.println("Deployment-Status: " + deployOut);
			return deleRespObj;
		} catch (Throwable t) {
			throw new RuntimeException("RO service call problem ! REQUEST: DELETE " + theOrchDeployURL, t);
		}	
	}
	
	public static final String CENTRAL_TELEMETRY_HANDLER = 
		"http://central-telemetry.services.cloud.ict-serrano.eu/api/v1/telemetry/central";
	public static final String telemetry_central_inventory_url = 
		CENTRAL_TELEMETRY_HANDLER + "/inventory";
	public static final String telemetry_clusters_url = 
		CENTRAL_TELEMETRY_HANDLER + "/clusters";
	public static final String telemetry_clusters_metrics_url = 
		CENTRAL_TELEMETRY_HANDLER + "/clusters/metrics";	
	
	public static synchronized List<InventoryElement> getTelemetryCentralInventoryElements() {
		// Access Central Telemetry when ready
		// if (true) return new ArrayList<InventoryElement>();
		try {
			final Client client = Client.create();
			final WebResource webResource = client.resource(telemetry_central_inventory_url);
			final TelemetryCentralInventoryOutput out = webResource.accept("application/json").get(TelemetryCentralInventoryOutput.class);
			return out.getUuids();
		} catch (Throwable t) {
			throw new RuntimeException("getTelemetryCentralInventoryElements service call problem !", t);
		}
	}
	
	public static synchronized List<Cluster> getClusters() {
		// Access Central Telemetry when ready
		// if (true) return new ArrayList<Cluster>();
		try {
			final Client client = Client.create();
			final WebResource webResource = client.resource(telemetry_clusters_url);
			final ClusterList out = webResource.accept("application/json").get(ClusterList.class);
			return (out != null) ? out.getClusters() : null;
		} catch (Throwable t) {
			throw new RuntimeException("getClusters service call problem !", t);
		}
	}
	
	public static synchronized K8sClusterData getClusterData(final String uuid) {
		if (uuid == null || uuid.trim().equals("")) return null;
		// TODO: initially get cluster, then find the type of the given one and finally
		// use the appropriate class for avoiding serialization problems
		// TODO: HpcClusterData 
		try {
			final Client client = Client.create();
			final WebResource webResource = client.resource(telemetry_clusters_url + "/" + uuid.trim());
			final K8sClusterData out = webResource.accept("application/json").get(K8sClusterData.class);
			return out;
		} catch (Throwable t) {
			throw new RuntimeException("getClusters service call problem !", t);
		}
	}
	
	
	public static synchronized ClusterMetrics getClusterMetrics(final String uuid) {
		return getClusterMetrics(uuid, null);
	}
	
	public static synchronized ClusterMetrics getClusterMetrics(final String uuid, final String target) {
		if (uuid == null || uuid.trim().equals("")) return null;
		try {
			final String targetStr = (target != null) ? "?target=" + target : "";
			final Client client = Client.create();
			final WebResource webResource = client.resource(telemetry_clusters_metrics_url + "/" + uuid.trim() + targetStr);
			final ClusterMetrics out = webResource.accept("application/json").get(ClusterMetrics.class);
			return out;
		} catch (Throwable t) {
			throw new RuntimeException("getClusters service call problem !", t);
		}
	}
	
	// http://central-telemetry.services.cloud.ict-serrano.eu/api/v1/telemetry/central/clusters/metrics/CLUSTERUID	
	// http://central-telemetry.services.cloud.ict-serrano.eu/api/v1/telemetry/central/clusters/metrics/CLUSTERUID?target=TARGET
	
	// TODO: GET HTTP REQUESTs
	// http://central-telemetry.services.cloud.ict-serrano.eu/api/v1/telemetry/central/clusters/inventory/CLUSTERUID
	// http://central-telemetry.services.cloud.ict-serrano.eu/api/v1/telemetry/central/clusters/metrics/CLUSTERUID	
	// http://central-telemetry.services.cloud.ict-serrano.eu/api/v1/telemetry/central/clusters/metrics/CLUSTERUID?target=TARGET	
	// http://central-telemetry.services.cloud.ict-serrano.eu/api/v1/telemetry/central/clusters/monitor/CLUSTERUID
	// http://central-telemetry.services.cloud.ict-serrano.eu/api/v1/telemetry/central/clusters/monitor/CLUSTERUID?target=TARGET
	
	/*** For Testing purposes ... */
	public static void main(String[] args) {

		System.out.println("START");
		
//		final List<InventoryElement> list = getTelemetryCentralInventoryElements();
//		System.out.println("list.size(): " + list.size());
//		for (InventoryElement inventoryElement : list) {
//			System.out.println(inventoryElement);
//		}
		
//		final Service_DeployScenarios_Output ds = new Service_DeployScenarios_Output();
//		ds.setName("testing");
//		ds.setDeployment_description("n/a");
//		final List<DeploymentScenario> dsList = new ArrayList<DeploymentScenario>();
//		ds.setDeployment_objectives(dsList);
//		System.out.println("RO Input: " + ds);
//		System.out.println(ds.asString());
//		final RO_Deployment_Output roOutput = orchestrator_deployment(ds);
//		System.out.println("RO Output: " + roOutput);

		
		List<Cluster> cList = getClusters();
		for (Cluster c : cList) {
			System.out.println(c);
		}
		
//		final String duid = "87606a0f-2214-413b-9532-5e01e25b47fe";
//		final Object deplStatRespObj = getDeploymentStatus(duid);
//		System.out.println("Response: " + deplStatRespObj);
		
		
//		final String duid = "46bc6a39-637e-4375-96f7-9e378a6e4473";
//		final Object deleRespObj = deleteDeployment(duid);
//		System.out.println("Response: " + deleRespObj);
		
		
		//System.out.println("list2.size(): " + list2.size());
		/*
		final List<Cluster> clusters = getClusters();
		for (Cluster cluster : clusters) {
			if (cluster.getName() == null || cluster.getName().trim().equals(""))
				continue;
			System.out.println(cluster);
			System.out.println(getClusterData(cluster.getUuid()));
			System.out.println(getClusterMetrics(cluster.getUuid()));
			break;
		}
		*/
		
		
		System.out.println("END");
	}
	
}
