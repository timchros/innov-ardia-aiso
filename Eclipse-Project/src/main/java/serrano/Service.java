package serrano;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import serrano.iccs.ExtService;
import serrano.iccs.io.Cluster;
import serrano.iccs.io.RO_Deployment_Output;
import serrano.io.AppManagInput;
import serrano.io.ApplicationConstraint;
import serrano.io.DeploymentScenario;
import serrano.io.MsgResponse;
import serrano.io.Service_Deployment_Output;
import serrano.io.Service_Input;
import serrano.io.Service_Input.ComponentInteraction;
import serrano.io.Service_DeployScenarios_Output;
import serrano.map.Mappings;
import serrano.newmap.MRI;
import serrano.newmap.MapRule1;
import serrano.newmap.MapRule2;
import serrano.newmap.MapRule3;
import serrano.newmap.MapRule4;
import serrano.newmap.MapRule5;
import serrano.newmap.Tuple2;

@Path("/")
public class Service {

	@GET
	@Path("/")
    @Produces({ MediaType.TEXT_HTML })
	/** Welcome Page - Available Services */
	public Response main() {
		final StringBuilder sb = new StringBuilder();
		sb.append("<html><head>");
		sb.append("<title>SERRANO | AI-SO</title>");
		sb.append("</head><body>");
		sb.append("<h1>Welcome to SERRANO AI-enhanced Service Orchestrator</h1>");
		final Method[] methods = this.getClass().getMethods();
		sb.append("<h4>Available Services:</h4><ul>");
		
		final List<Method> methodList = new ArrayList<Method>();
		for (Method method : methods) methodList.add(method);
		Collections.sort(methodList, new Comparator<Method>() {
			@Override public int compare(Method m1, Method m2) {
				return m1.getName().compareToIgnoreCase(m2.getName());
			}
		});
		
		for (Method method : methodList) {
			Path path = method.getAnnotation(Path.class);
			if (path != null) {
				if (path.value().indexOf("newtest") >= 0) continue;
				sb.append("<li>" + path.value() + "</li>");
			}
		}
		sb.append("</ul>");
		sb.append("</body></html>");
		return Response.status(Response.Status.OK).entity(sb.toString()).build();
	}
	
//	@GET
//	@Path("/init")
//    @Produces({ MediaType.TEXT_HTML })
//	/** AISO Initialization */
//	public Response T0() {
//		final StringBuilder sb = new StringBuilder();
//		sb.append("<html><head>");
//		sb.append("<title>AI-SO | init</title>");
//		sb.append("</head><body>");
//		sb.append("<h2>AI-SO initialization process</h2>");
//		
//		// Store data ... so that we can use at a latter stage (if being necessary)
//		
//		sb.append("</body></html>\n");
//		return Response.status(Response.Status.OK).entity(sb.toString()).build();
//	}

	@GET
	@Path("/newtestro1")
    @Produces({ MediaType.TEXT_HTML })
	/** Invoke Resource Orchestrator - For Testing Purposes ... */
	public Response testResourceOrchestrator1() {
		System.out.println("System property: 'java.version' : " + System.getProperty("java.version"));;
		// An Empty Request ... 
		final Service_DeployScenarios_Output dummyds = new Service_DeployScenarios_Output();
		dummyds.setDeployment_description("n/a");
		final List<DeploymentScenario> dsList = new ArrayList<DeploymentScenario>();
		dummyds.setDeployment_objectives(dsList);
		// Invoke Resource Orchestrator
		final RO_Deployment_Output roOutput = ExtService.orchestrator_deployment(dummyds);
		System.out.println("RO Output: " + roOutput);
		// Return Response
		return Response.status(Response.Status.OK).entity("RO Response: " + roOutput).build();
	}

	@GET
	@Path("/newtestro2")
    @Produces({ MediaType.TEXT_HTML })
	/** Invoke Resource Orchestrator - For Testing Purposes ... */
	public Response testResourceOrchestrator2() {
		System.out.println("System property: 'java.version' : " + System.getProperty("java.version"));;
		// An Real Request ... 
		String YAML = "apiVersion: v1\\r\\nkind: PersistentVolume\\r\\nmetadata:\\r\\n  name: position-service-data-manager-data-pv-volume\\r\\n  labels:\\r\\n    type: local\\r\\n    group_id: s1\\r\\nspec:\\r\\n  storageClassName: local-storage\\r\\n  capacity:\\r\\n    storage: 10Gi\\r\\n  accessModes:\\r\\n    - ReadWriteOnce\\r\\n  hostPath:\\r\\n    path: \\\"\\/mnt\\/data\\\"\\r\\n---\\r\\napiVersion: v1\\r\\nkind: PersistentVolumeClaim\\r\\nmetadata:\\r\\n  name: position-service-data-manager-data-pv-claim\\r\\n  labels:\\r\\n    group_id: s1\\r\\nspec:\\r\\n  storageClassName: local-storage\\r\\n  accessModes:\\r\\n    - ReadWriteOnce\\r\\n  resources:\\r\\n    requests:\\r\\n      storage: 3Gi\\r\\n---\\r\\napiVersion: v1\\r\\nkind: ConfigMap\\r\\nmetadata:\\r\\n  name: position-service-data-manager-config\\r\\n  labels:\\r\\n    group_id: s1\\r\\ndata:\\r\\n  config.yaml: |\\r\\n    mode: prod\\r\\n    test:\\r\\n      mqtt:\\r\\n        host: localhost\\r\\n        port: 1883\\r\\n        keepalive: 60\\r\\n      credentials:\\r\\n        username: admin\\r\\n        password: RcsUmb%Ad&yd\\r\\n      stack:\\r\\n        buffer: 2\\r\\n      retrain:\\r\\n        anomalous: 80\\r\\n      storage:\\r\\n        type: local\\r\\n    prod:\\r\\n      mqtt:\\r\\n        host: 83.212.102.89\\r\\n        port: 1883\\r\\n        keepalive: 60\\r\\n      credentials:\\r\\n        username: serrano_ideko_dev\\r\\n        password: S3Rr@N0!\\r\\n      stack:\\r\\n        buffer: 22\\r\\n      retrain:\\r\\n        anomalous: 80\\r\\n      storage:\\r\\n        type: s3\\r\\n        bucket_name: ideko-uc3-anomaly-detection\\r\\n        credentials:\\r\\n          gateway_url: https:\\/\\/on-premise-storage-gateway.services.cloud.ict-serrano.eu\\r\\n          skyflok_token: 4NAfql6VeY5RPOlNOeAUpualC2x8rruMpvUeCkCv8OJkfOC2qKqaqoa28nCCQOGk\\r\\n  logging.yaml: |\\r\\n    version : 1\\r\\n    formatters:\\r\\n      simpleFormatter:\\r\\n        format : '%(asctime)s - %(name)s - %(levelname)s - %(message)s'\\r\\n    handlers:\\r\\n      fileHandler:\\r\\n        formatter: simpleFormatter\\r\\n        class : logging.handlers.RotatingFileHandler\\r\\n        filename : 'logs\\/app.log'\\r\\n        backupCount : 10\\r\\n        maxBytes : 10485760\\r\\n        level : INFO\\r\\n      consoleHandler:\\r\\n        formatter: simpleFormatter\\r\\n        class: logging.StreamHandler\\r\\n        stream  : ext:\\/\\/sys.stdout\\r\\n        level: INFO\\r\\n    root :\\r\\n      handlers: [fileHandler, consoleHandler]\\r\\n      level: DEBUG\\r\\n    disable_existing_loggers : false\\r\\n---\\r\\napiVersion: apps\\/v1\\r\\nkind: Deployment\\r\\nmetadata:\\r\\n  name: position-service-data-manager\\r\\n  labels:\\r\\n    group_id: s1\\r\\nspec:\\r\\n  selector:\\r\\n     matchLabels:\\r\\n       project: serrano\\r\\n  replicas: 1\\r\\n  strategy:\\r\\n    type: Recreate\\r\\n  template:  \\r\\n    metadata:\\r\\n      labels:\\r\\n        project: serrano\\r\\n        service: position\\r\\n        microservice: data-manager\\r\\n        uc: uc3\\r\\n    spec:\\r\\n      #nodeName: worker-instance01\\r\\n      containers:\\r\\n        - name: position-data-manager\\r\\n          image: serrano-harbor.rid-intrasoft.eu\\/serrano\\/position-data-manager:0.1\\r\\n          imagePullPolicy: Always \\r\\n          volumeMounts:\\r\\n          - name: position-service-data-manager-config\\r\\n            mountPath: \\/app\\/config\\r\\n          - name: position-service-data-manager-data-pv-storage\\r\\n            mountPath: \\/app\\/data\\r\\n      volumes:\\r\\n        - name: position-service-data-manager-config\\r\\n          configMap:\\r\\n            name: position-service-data-manager-config\\r\\n        - name: position-service-data-manager-data-pv-storage\\r\\n          persistentVolumeClaim:\\r\\n            claimName: position-service-data-manager-data-pv-claim \\r\\n      imagePullSecrets:\\r\\n        - name: regcred\\r\\n---\\r\\napiVersion: v1\\r\\nkind: ConfigMap\\r\\nmetadata:\\r\\n  name: position-service-model-inference-config\\r\\n  labels:\\r\\n    group_id: s2\\r\\ndata:\\r\\n  config.yaml: |\\r\\n    mode: prod\\r\\n    test:\\r\\n      mqtt:\\r\\n        host: localhost\\r\\n        port: 1883\\r\\n        keepalive: 60\\r\\n      credentials:\\r\\n        username: admin\\r\\n        password: RcsUmb%Ad&yd\\r\\n      storage:\\r\\n        type: local\\r\\n    prod:\\r\\n      mqtt:\\r\\n        host: 83.212.102.89\\r\\n        port: 1883\\r\\n        keepalive: 60\\r\\n      credentials:\\r\\n        username: serrano_ideko_dev\\r\\n        password: S3Rr@N0!\\r\\n      storage:\\r\\n        type: s3\\r\\n        bucket_name: ideko-uc3-anomaly-detection\\r\\n        credentials:\\r\\n          gateway_url: https:\\/\\/on-premise-storage-gateway.services.cloud.ict-serrano.eu\\r\\n          skyflok_token: 4NAfql6VeY5RPOlNOeAUpualC2x8rruMpvUeCkCv8OJkfOC2qKqaqoa28nCCQOGk\\r\\n  logging.yaml: |\\r\\n    version : 1\\r\\n    formatters:\\r\\n      simpleFormatter:\\r\\n        format : '%(asctime)s - %(name)s - %(levelname)s - %(message)s'\\r\\n    handlers:\\r\\n      fileHandler:\\r\\n        formatter: simpleFormatter\\r\\n        class : logging.handlers.RotatingFileHandler\\r\\n        filename : 'logs\\/app.log'\\r\\n        backupCount : 10\\r\\n        maxBytes : 10485760\\r\\n        level : INFO\\r\\n      consoleHandler:\\r\\n        formatter: simpleFormatter\\r\\n        class: logging.StreamHandler\\r\\n        stream  : ext:\\/\\/sys.stdout\\r\\n        level: INFO\\r\\n    root :\\r\\n      handlers: [fileHandler, consoleHandler]\\r\\n      level: DEBUG\\r\\n    disable_existing_loggers : false\\r\\n---\\r\\napiVersion: apps\\/v1\\r\\nkind: Deployment\\r\\nmetadata:\\r\\n  name: position-service-model-inference\\r\\n  labels:\\r\\n    group_id: s2\\r\\nspec:\\r\\n  selector:\\r\\n     matchLabels:\\r\\n       project: serrano\\r\\n  replicas: 1\\r\\n  strategy:\\r\\n    type: Recreate\\r\\n  template:  \\r\\n    metadata:\\r\\n      labels:\\r\\n        project: serrano\\r\\n        service: position\\r\\n        microservice: model-inference\\r\\n        uc: uc3\\r\\n    spec:\\r\\n      #nodeName: worker-instance01\\r\\n      containers:        \\r\\n        - name: position-model-inference\\r\\n          image: serrano-harbor.rid-intrasoft.eu\\/serrano\\/position-model-inference:0.1     \\r\\n          imagePullPolicy: Always \\r\\n          volumeMounts:\\r\\n          - name: position-service-model-inference-config\\r\\n            mountPath: \\/app\\/config          \\r\\n      volumes:\\r\\n        - name: position-service-model-inference-config\\r\\n          configMap:\\r\\n            name: position-service-model-inference-config        \\r\\n      imagePullSecrets:\\r\\n        - name: regcred\\r\\n---\\r\\napiVersion: v1\\r\\nkind: ConfigMap\\r\\nmetadata:\\r\\n  name: position-service-classifier-training-config\\r\\n  labels:\\r\\n    group_id: s3\\r\\ndata:\\r\\n  config.yaml: |\\r\\n    mode: prod\\r\\n    test:\\r\\n      mqtt:\\r\\n        host: localhost\\r\\n        port: 1883\\r\\n        keepalive: 60\\r\\n      credentials:\\r\\n        username: admin\\r\\n        password: RcsUmb%Ad&yd\\r\\n      cluster:\\r\\n        type: kmeans\\r\\n      classifier:\\r\\n        cv:\\r\\n          n_splits: 5\\r\\n        knn:\\r\\n          n_neighbors: 3\\r\\n          metric: dtw\\r\\n      storage:\\r\\n        type: local\\r\\n    prod:\\r\\n      mqtt:\\r\\n        host: 83.212.102.89\\r\\n        port: 1883\\r\\n        keepalive: 60\\r\\n      credentials:\\r\\n        username: serrano_ideko_dev\\r\\n        password: S3Rr@N0!\\r\\n      cluster:\\r\\n        type: kmeans\\r\\n      classifier:\\r\\n        cv:\\r\\n          n_splits: 5\\r\\n        knn:\\r\\n          n_neighbors: 3\\r\\n          metric: dtw\\r\\n      storage:\\r\\n        type: s3\\r\\n        bucket_name: ideko-uc3-anomaly-detection\\r\\n        credentials:\\r\\n          gateway_url: https:\\/\\/on-premise-storage-gateway.services.cloud.ict-serrano.eu\\r\\n          skyflok_token: 4NAfql6VeY5RPOlNOeAUpualC2x8rruMpvUeCkCv8OJkfOC2qKqaqoa28nCCQOGk\\r\\n  logging.yaml: |\\r\\n    version : 1\\r\\n    formatters:\\r\\n      simpleFormatter:\\r\\n        format : '%(asctime)s - %(name)s - %(levelname)s - %(message)s'\\r\\n    handlers:\\r\\n      fileHandler:\\r\\n        formatter: simpleFormatter\\r\\n        class : logging.handlers.RotatingFileHandler\\r\\n        filename : 'logs\\/app.log'\\r\\n        backupCount : 10\\r\\n        maxBytes : 10485760\\r\\n        level : INFO\\r\\n      consoleHandler:\\r\\n        formatter: simpleFormatter\\r\\n        class: logging.StreamHandler\\r\\n        stream  : ext:\\/\\/sys.stdout\\r\\n        level: INFO\\r\\n    root :\\r\\n      handlers: [fileHandler, consoleHandler]\\r\\n      level: DEBUG\\r\\n    disable_existing_loggers : false\\r\\n---\\r\\napiVersion: apps\\/v1\\r\\nkind: Deployment\\r\\nmetadata:\\r\\n  name: position-service-classifier-training\\r\\n  labels:\\r\\n    group_id: s3\\r\\nspec:\\r\\n  selector:\\r\\n     matchLabels:\\r\\n       project: serrano\\r\\n  replicas: 1\\r\\n  strategy:\\r\\n    type: Recreate\\r\\n  template:  \\r\\n    metadata:\\r\\n      labels:\\r\\n        project: serrano\\r\\n        service: position\\r\\n        microservice: classifier-training\\r\\n        uc: uc3\\r\\n    spec:\\r\\n      #nodeName: worker-instance01\\r\\n      containers:        \\r\\n        - name: position-classifier-training\\r\\n          image: serrano-harbor.rid-intrasoft.eu\\/serrano\\/position-classifier-training:0.1     \\r\\n          imagePullPolicy: Always\\r\\n          volumeMounts:\\r\\n          - name: position-service-classifier-training-config\\r\\n            mountPath: \\/app\\/config          \\r\\n      volumes:\\r\\n        - name: position-service-classifier-training-config\\r\\n          configMap:\\r\\n            name: position-service-classifier-training-config        \\r\\n      imagePullSecrets:\\r\\n        - name: regcred\\r\\n";
		final Service_DeployScenarios_Output dummyds = new Service_DeployScenarios_Output();
		dummyds.setDeployment_description(YAML);
		final List<DeploymentScenario> dsList = new ArrayList<DeploymentScenario>();
		dummyds.setDeployment_objectives(dsList);
		// Invoke Resource Orchestrator
		final RO_Deployment_Output roOutput = ExtService.orchestrator_deployment(dummyds);
		System.out.println("RO Output: " + roOutput);
		// Return Response
		return Response.status(Response.Status.OK).entity("RO Response: " + roOutput).build();
	}	
	
	// TODO: Update with component IDs or names (e.g., analyse_market, kalman)
	
	private static final String OP_STR = "> >/= < </= =";
	private static final String UNIT_STR = "TB GB MB KB MIN SEC MS MILLI %";
	private static final String TERM_STR = // + TEXT
		"YES NO LOW MEDIUM HIGH SHORT-TERM LONG-TERM AES GDPR-COMPLIANT SENSITIVE-DATA EUROPE XLSX CSV PYTHON JAVA LINUX";
	private static final String NUM_PATTERN = 
		"^(?:-(?:[1-9](?:\\d{0,2}(?:,\\d{3})+|\\d*))|(?:0|(?:[1-9](?:\\d{0,2}(?:,\\d{3})+|\\d*))))(?:.\\d+|)$";
	
	
	@POST
	@Path("/CreateDeploymentScenarios")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    /** Create possible Deployment Scenarios */
	public Response T1(Service_Input input) {
		
		final List<MRI> mrList = new ArrayList<MRI>();
		mrList.add(new MapRule1());
		mrList.add(new MapRule2());
		mrList.add(new MapRule3());
		mrList.add(new MapRule4());
		mrList.add(new MapRule5());
		
		final String log_date_pattern = "yyyy/MM/dd-HH:mm:ss.SSS";
		final DateFormat ldf = new SimpleDateFormat(log_date_pattern);
		
		System.out.println(ldf.format(new Date()) + " - AISO - CreateDeploymentScenarios");
		System.out.println(ldf.format(new Date()) + " - AISO - Inout:\n" + input.asString2());
		
		// Check Input Data
		final MsgResponse checkResp = checkData(input);
		if (checkResp != null) {
			final Status respStatus = Response.Status.BAD_REQUEST;
			return Response.status(respStatus).entity(checkResp).build();
		}
		
		final List<ApplicationConstraint> appConstraintsList = input.getApplication_constraints();
		
		// Check & Fix
		for (ApplicationConstraint appConst : appConstraintsList) {
			if ("</= LOW ms".equalsIgnoreCase(appConst.getApplication_Performance_Total_Execution_Time())) {
				appConst.setApplication_Performance_Total_Execution_Time("LOW");
			}
			if ("</= LOW ms".equalsIgnoreCase(appConst.getApplication_Performance_Response_Latency())) {
				appConst.setApplication_Performance_Response_Latency("LOW");
			}
		}
		
		/* Deal with a particular case */
		
		final List<String> ciList = new ArrayList<String>();
		if (input.getApplication_workflow() != null) {
			for (ComponentInteraction ci : input.getApplication_workflow()) {
				ciList.add(ci.getComponent_id());
			}
		}
		if (ciList.size() == 3 && ciList.contains("data-manager")
				&& ciList.contains("classifier-training") && ciList.contains("model-inference")
				&& appConstraintsList.size() == 1 && 
				appConstraintsList.get(0).getEnergy_Consumption() != null &&
				appConstraintsList.get(0).getEnergy_Consumption().equalsIgnoreCase("LOW")) {
						
			final List<DeploymentScenario> dsList = new ArrayList<DeploymentScenario>();
			
			final DateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
			final String str = df.format(new Date());
			int i = 1;
			for (ComponentInteraction ci : input.getApplication_workflow()) {
				final DeploymentScenario ds = new DeploymentScenario();
				ds.setDeployment_scenario_id(str + "-" + i);
				ds.setComponent_id(ci.getComponent_id());
				ds.setNode_type("EDGE_DEVICE");
				ds.setAccelerator_type("U50");
				dsList.add(ds);
				i += 1;
			}
			
			// Prepare Response
			final Status respStatus = Response.Status.OK;
			final Service_DeployScenarios_Output output = new Service_DeployScenarios_Output();
			output.setName("AISO");
			output.setDeployment_description(input.getDeployment_descriptor_yaml());
			output.setDeployment_objectives(dsList);
			return Response.status(respStatus).entity(output).build();
			
		}
		
		// Prepare Deployment Scenarios
		final List<DeploymentScenario> theDepScenList = new ArrayList<DeploymentScenario>();
				
		try {
			
			// TODO: Consume Benchmarking Data recorded so far  
			// Search in a DB about appropriate data based on the information recorded about similar applications
			// DB Search using Application Profiles 
			// Detect Data about Applications with Similar Profiles 
			// Propose values based on what majority suggest
			// Need to specify both parameters being used for both searching and suggesting
			
			// Load manually-defined Mapping Rules
			Mappings.getInstance();
			
			// For each component ...
			for (int i = 0; i < appConstraintsList.size(); i++) {
				
				final ApplicationConstraint appConstr = appConstraintsList.get(i);
			
				// *** one-to-one mappings ***
				
				final DeploymentScenario ds0 = new DeploymentScenario();
							
				final DateFormat df0 = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
				final String str0 = df0.format(new Date());
				ds0.setDeployment_scenario_id(str0);
				
				// Component
				if (appConstr.getComponent_id() != null) {
					ds0.setComponent_id(appConstr.getComponent_id());
				}
				
				// Data Storage Volume - Node Storage Size
				if (appConstr.getData_Storage_Volume() != null) {
					System.out.println(ldf.format(new Date()) + " - AISO - MR: Data_Storage_Volume");
					ds0.setNode_storage_size(appConstr.getData_Storage_Volume());
				}
				// ??? Data Encryption Algorithm - Node or Storage Service Storage Encryption
				if (appConstr.getSecurity_Data_Data_Encryption_Algorithm() != null) {
					System.out.println(ldf.format(new Date()) + " - AISO - MR: Data_Data_Encryption_Algorithm");
					ds0.setNode_storage_encryption(appConstr.getSecurity_Data_Data_Encryption_Algorithm());
				}
				// Network Latency - Node Network Latency
				if (appConstr.getNetwork_Latency() != null && !appConstr.getNetwork_Latency().equalsIgnoreCase("LOW")) 
					System.out.println(ldf.format(new Date()) + " - AISO - MR: Network_Latency");{
					ds0.setNode_network_latency(appConstr.getNetwork_Latency());
				}
					
				if (appConstr.getApplication_Performance_Response_Latency() != null) {
					System.out.println(ldf.format(new Date()) + " - AISO - MR: Application_Performance_Response_Latency");
					if (appConstr.getApplication_Performance_Response_Latency().equalsIgnoreCase("LOW")) {
						ds0.setNode_type("EDGE_DEVICE");
					}  else {
						ds0.setNode_type("CLOUD");
					}
				}

				// FPGA / GPU accelerator
				if (appConstr.getApplication_Performance_FPGA() != null) {
					ds0.setAccelerator_type("FPGA");
				}
				if (appConstr.getApplication_Performance_GPU() != null) {
					ds0.setAccelerator_type("GPU");
				}
				
				// At this point we have one ds ... 
				// Instead we should have a list that initially has one ds
				
				boolean any_fired = false;
				
				for (MRI mr : mrList) {
					
					// TODO: Check & Fix - We have assumed that only one MR can be fired in each input
					
					if (mr.canFire(appConstr)) {
						final List<List<Tuple2>> scenList = mr.fire(appConstr);
						// System.out.println("--> Mapping Rule: " + mr.getClass().getName() + " --> Output-size(): " + scenList.size());
						// System.out.println(scenList);
						
						System.out.println(ldf.format(new Date()) + " - AISO - MR: " + mr.getClass());
						any_fired = true;
						
						if (scenList.size()==0) {
							// System.out.println("** WARNING: No way of satisfying the given constraints ! **");
//							if (ds0.getNode_type() != null) {
//								theDepScenList.add(ds0);
//								break;
//							}
						} else {
							if (scenList.size() == 1) {
								// Just update the JSON with the new/additional constraints
								for (Tuple2 t : scenList.get(0)) {
									if (t.getValue() == null) 
										continue;
									if (t.getKey().equals("node_type"))
										ds0.setNode_type(t.getValue()); 
									if (t.getKey().equals("uc_app_params"))
										ds0.setUc_app_params(t.getValue());
									if (t.getKey().equals("accelerator_type"))
										ds0.setAccelerator_type(t.getValue());
									if (t.getKey().equals("tiers"))
										ds0.setNode_exec_capability(t.getValue());
								}
								theDepScenList.add(ds0);
								break;
								
							} else {

								// Create Possible Scenarios
								List<DeploymentScenario> dsList = new ArrayList<DeploymentScenario>();
								
								final DateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
								final String str = df.format(new Date());
								int index = 1;
								for (List<Tuple2> tupList : scenList) {
									final DeploymentScenario ds = new DeploymentScenario();
									ds.setDeployment_scenario_id(str + "-" + index);
									for (Tuple2 t : tupList) {
										if (t.getValue() == null) 
											continue;
										if (t.getKey().equals("node_type"))
											ds.setNode_type(t.getValue());
										if (t.getKey().equals("uc_app_params"))
											ds.setUc_app_params(t.getValue());
										if (t.getKey().equals("accelerator_type"))
											ds.setAccelerator_type(t.getValue());
										if (t.getKey().equals("tiers"))
											ds.setNode_exec_capability(t.getValue());
									}
									dsList.add(ds);
									// Copy Rest Constraints (from 1-to-1 mappings)
									for (Method method : DeploymentScenario.class.getMethods()) {
										if (!method.getName().startsWith("get"))
											continue;
										if (method.getName().endsWith("getClass"))
											continue;
										// Set Value from an object to another one
										final Object obj = method.invoke(ds0);
										if (obj != null) {
											Method theMethod = DeploymentScenario.class.getMethod("set" + method.getName().substring(3), obj.getClass());
											theMethod.invoke(ds, obj);
										}
									}
									index++;
								}
								
								if (dsList.isEmpty()) dsList.add(ds0);
								
								// System.out.println("dsList.size(): " + dsList.size());
								for (DeploymentScenario ds : dsList) {
									System.out.println(" - " + ds.asString());
								}
							
								theDepScenList.addAll(dsList);
								break;
							}
							
						} // END OF ELSE about one or more options
						
					} // END OF if (mr.canFire(appConstr))
					
				} // END OF mrList 
				
				if (!any_fired) {
					if (ds0.getNode_type() != null) {
						theDepScenList.add(ds0);
						break;
					}
				}
				
				
//				// Runtime Isolation, Encryption and Spawn Time
//				final List<List<Tier>> tierList = new ArrayList<List<Tier>>();
//				if (appConstr.getRuntime_isolation() != null) {
//					final List<Tier> tmpList = Mappings.getInstance()
//						.getTiersForRuntimeIsolationValue(
//							Runtime_Param_Value.valueOf(
//									appConstr.getRuntime_isolation().toUpperCase()));
//					tierList.add(tmpList);
//				}
//				if (appConstr.getRuntime_encryption() != null) {
//					final List<Tier> tmpList = Mappings.getInstance()
//						.getTiersForRuntimeEncryptionValue(
//							Runtime_Param_Value.valueOf(
//									appConstr.getRuntime_encryption().toUpperCase()));
//					tierList.add(tmpList);
//				}
//				if (appConstr.getRuntime_spawn_time() != null) {
//					final List<Tier> tmpList = Mappings.getInstance()
//						.getTiersForRuntimeSpawnTimeValue(
//							Runtime_Param_Value.valueOf(
//									appConstr.getRuntime_spawn_time().toUpperCase()));
//					tierList.add(tmpList);			
//				}
//				// Keep only commons
//				final Set<Tier> tierSet = new HashSet<Tier>();
//				for (List<Tier> list : tierList) {
//					tierSet.addAll(list);
//				} 
//				final Set<Tier> commonTierSet = new HashSet<Tier>();
//				for (Tier tier : tierSet) {
//					boolean existsInALL = true;
//					for (List<Tier> list : tierList) {
//						if (!list.contains(tier)) {
//							existsInALL = false; break;
//						}
//					}
//					if (existsInALL) {
//						commonTierSet.add(tier);
//					}
//				}
//				
//				System.out.println("Creating Possible Scenarios ...");
				
//				// Create Possible Scenarios
//				List<DeploymentScenario> dsList = new ArrayList<DeploymentScenario>();
//				
//				final DateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
//				final String str = df.format(new Date());
//				int index = 1;
//				for (Tier tier : commonTierSet) {
//					final DeploymentScenario ds = new DeploymentScenario();
//					ds.setDeployment_scenario_id(str + "-" + index);
//					// ds.setPlatform_type(PlatformType.CLOUD_PROVIDEER.name());
//					ds.setNode_exec_capability(tier.name());
//					dsList.add(ds);
//					
//					// Copy Rest Constraints (from 1-to-1 mappings)
//					for (Method method : DeploymentScenario.class.getMethods()) {
//						if (!method.getName().startsWith("get"))
//							continue;
//						if (method.getName().endsWith("getClass"))
//							continue;
//						// Set Value from an object to another one
//						final Object obj = method.invoke(ds0);
//						if (obj != null) {
//							Method theMethod = DeploymentScenario.class.getMethod("set" + method.getName().substring(3), obj.getClass());
//							theMethod.invoke(ds, obj);
//						}
//					}
//					
//					index++;
//				}
//				
//				if (dsList.isEmpty()) dsList.add(ds0);
//				
//				// System.out.println("dsList.size(): " + dsList.size());
//				for (DeploymentScenario ds : dsList) {
//					System.out.println(" - " + ds.asString());
//				}
//			
//				theDepScenList.addAll(dsList);
				
			} // End of For Loop ...
			
			// Prepare Response
			final Status respStatus = Response.Status.OK;
			final Service_DeployScenarios_Output output = new Service_DeployScenarios_Output();
			output.setName("AISO");
			output.setDeployment_description(input.getDeployment_descriptor_yaml());
			output.setDeployment_objectives(theDepScenList);
			
			System.out.println(ldf.format(new Date()) + " - AISO - Output:\n" + output.asString2());
			
			return Response.status(respStatus).entity(output).build();
    	} catch (Throwable t) {
    		t.printStackTrace();
    		final Status respStatus = Response.Status.INTERNAL_SERVER_ERROR;
    		final String errorMsg = "Error: " + t.getClass().getName() + " , Message: " + t.getMessage();
    		final MsgResponse respMessage = new MsgResponse(errorMsg);
    		return Response.status(respStatus).entity(respMessage).build();
		}
	}
	
	/** 
	 * Ensure that the values of the properties follow the predefined format 
	 * @return a {@link MsgResponse} with the problem detected, otherwise <code>null</code>
	 * */
	private MsgResponse checkData(final Service_Input input) {
		
		final boolean debug = false; // true;
		
		final List<ApplicationConstraint> appConstraintsList = input.getApplication_constraints();
		
//		// Check Input Data
//		if (appConstraintsList == null) {
//			final String errorMsg = "Application Constraints not specified !";
//			final MsgResponse errorResp = new MsgResponse(errorMsg);
//			return errorResp;
//		}
		
		// Ensure that the values of the properties follow the predefined format
		for (int i = 0; i < appConstraintsList.size(); i++) {
			final ApplicationConstraint appConstr = appConstraintsList.get(i);
			
			final Method[] methodArray = ApplicationConstraint.class.getMethods();
			for (Method method : methodArray) {
				if (!method.getName().startsWith("get")) 
					continue;
				if (!method.getReturnType().getSimpleName().equals("String"))
					continue;
				try {
					final String value = (String) method.invoke(appConstr);
					if (value != null && !value.trim().equals("")) {
						final String valueTrim = value.trim();
						final String[] tokens = valueTrim.split("\\s+");
						if (tokens.length == 1) {
							final String term = tokens[0];
							final Set<String> termSet = new HashSet<String>();
							for (String str : TERM_STR.split("\\s+")) termSet.add(str);
							
							// TODO: Ensure that it comes from one or more predefined list of terms or being a number
							final Pattern pattern = Pattern.compile(NUM_PATTERN);
							if (!pattern.matcher(term).matches() && !termSet.contains(term.toUpperCase()))
								if (debug) 
									System.out.println("Probably inappropriate term: " + term);
						} else if (tokens.length == 2) {
							final String op = tokens[0];
							final String val = tokens[1];
							// Ensure that the first token is a comparison symbol
							final Set<String> opSet = new HashSet<String>();
							for (String str : OP_STR.split("\\s+")) opSet.add(str);
							if (!opSet.contains(op)) 
								throw new RuntimeException("Invalid Operator in the Value '" + valueTrim + "' of the Field '" + method.getName().substring(3) + "'" );
							// TODO: Ensure that the second token is a number 
							final Pattern pattern = Pattern.compile(NUM_PATTERN);
							if (!pattern.matcher(val).matches())
								if (debug) 
									System.out.println("Probably the following string is not a valid number: " + val);
							
						} else if (tokens.length == 3) {
							final String op = tokens[0];
							final String val = tokens[1];
							final String uni = tokens[2];
							// Ensure that the first token is a comparison symbol
							final Set<String> opSet = new HashSet<String>();
							for (String str : OP_STR.split("\\s+")) opSet.add(str);
							if (!opSet.contains(op)) 
								throw new RuntimeException("Invalid Operator in the Value '" + valueTrim + "' of the Field '" + method.getName().substring(3) + "'" );
							
							// TODO: Ensure that  (b) the second token is a number and (c) the third token is a valid unit expression
							final Pattern pattern = Pattern.compile(NUM_PATTERN);
							if (!pattern.matcher(val).matches())
								if (debug) 
									System.out.println("Probably the string is not a valid number: " + val);
							final Set<String> unitSet = new HashSet<String>();
							for (String str : UNIT_STR.split("\\s+")) unitSet.add(str);
							if (!unitSet.contains(uni.toUpperCase()))
								if (debug) 
									System.out.println("Probably inappropriate unit: " + uni);
							
						} else {
							final String errorMsg = "Inappropriate Input Data... Field: '" + method.getName().substring(3) + "' , Value: '" + valueTrim + "'";
							final MsgResponse errorResp = new MsgResponse(errorMsg);
							return errorResp;
						}
					}
				} catch (Throwable t) {
		    		final String errorMsg = "Error: " + t.getClass().getName() + " , Message: " + t.getMessage();
		    		final MsgResponse respMessage = new MsgResponse(errorMsg);
		    		return respMessage;
				}
			}
		}
		
		// Indicates that no problem detected
		return null;
	}
	
	
	@POST
	@Path("/ApplicationDeploymentThroughRO")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    /** Application Deployment through Resource Orchestrator */
	public Response T2(Service_Input input) {
		
		// Check Input Data
		if (input.getDeployment_descriptor_yaml() == null || input.getDeployment_descriptor_yaml().trim().equals("")) {
			final String errorMsg = "Deployment Descriptor Content is missing !";
			System.out.println(errorMsg);
			final Status respStatus = Response.Status.BAD_REQUEST;
			final MsgResponse errorResp = new MsgResponse(errorMsg);
			return Response.status(respStatus).entity(errorResp).build();
		}
		
		final String log_date_pattern = "yyyy/MM/dd-HH:mm:ss.SSS";
		final DateFormat ldf = new SimpleDateFormat(log_date_pattern);
		System.out.println(ldf.format(new Date()) + " - AISO - ApplicationDeploymentThroughRO");
		
		// Detect Possible Deployment Scenarios (using the previous method)
		final Response depScenResp = this.T1(input);
		
		// Send Data to Resource Orchestrator
		if (depScenResp.getStatus() == Response.Status.OK.getStatusCode()) {
			try {
				// Data Structure with Deployment Scenarios and Application YAML
				final Service_DeployScenarios_Output deploy_scenarios_data = 
					(Service_DeployScenarios_Output) depScenResp.getEntity();
				
				// Call Resource Orchestrator 
				System.out.println(ldf.format(new Date()) + " - AISO - Invoke RO");
				final RO_Deployment_Output roOutput = ExtService.orchestrator_deployment(deploy_scenarios_data);
				System.out.println(ldf.format(new Date()) + " - AISO - Output:\n - uuid: " + roOutput.getDeployment_uuid());
				
				// Prepare Response
				final Status respStatus = Response.Status.OK;
				final Service_Deployment_Output output = new Service_Deployment_Output();
				output.setDeployment_uuid(roOutput.getDeployment_uuid());
				return Response.status(respStatus).entity(output).build();
			} catch (Throwable t) {
	    		t.printStackTrace();
	    		final Status respStatus = Response.Status.INTERNAL_SERVER_ERROR;
	    		final MsgResponse respMessage = new MsgResponse(t.getMessage());
	    		return Response.status(respStatus).entity(respMessage).build();
			}
		} else {
			return Response.status(depScenResp.getStatus()).entity(depScenResp.getEntity()).build();
		}
	}
	
	@POST
	@Path("/ApplicationManagement")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    /** Application Management */
	public Response T3(AppManagInput input) {
		// Check Input Data
		if (!input.isActionValid()) {
			final Status respStatus = Response.Status.BAD_REQUEST;
			final MsgResponse errorResp = new MsgResponse("Inappropriate Action Name !");
			return Response.status(respStatus).entity(errorResp).build();
		}
		
		final String log_date_pattern = "yyyy/MM/dd-HH:mm:ss.SSS";
		final DateFormat ldf = new SimpleDateFormat(log_date_pattern);
		System.out.println(ldf.format(new Date()) + " - AISO - ApplicationManagement");
		System.out.println(ldf.format(new Date()) + " - AISO - Input:\n" + input.asString());
		
		// Further Process Input Data
		try {
			String respMsg = "App: " + input.getAppid() + "Action: " + input.getAction() + " with Parameters: '" + input.getParams() + "' is under process !";
			
			// Call the appropriate Resource Orchestrator (RO) Services 
			
			if (input.getAction().equalsIgnoreCase("STATUS")) {
				respMsg = "" + ExtService.getDeploymentStatus(input.getAppid());
			}
			
			if (input.getAction().equalsIgnoreCase("UNDEPLOY")) {
				respMsg = "" + ExtService.deleteDeployment(input.getAppid());
			}

			System.out.println(ldf.format(new Date()) + " - AISO - Output:\n" + respMsg);
			
			// Prepare Response
			final Status respStatus = Response.Status.OK; 
			final MsgResponse output = new MsgResponse(respMsg);
			return Response.status(respStatus).entity(output).build();	
		} catch (Throwable t) {
			t.printStackTrace();
			final Status respStatus = Response.Status.INTERNAL_SERVER_ERROR;
			final String respMsg = "Error: " + t.getClass().getName() + " , Message: " + t.getMessage();
			final MsgResponse errorResp = new MsgResponse(respMsg);
			return Response.status(respStatus).entity(errorResp).build();
		}
	}
	
	@GET
	@Path("/GetDataFromCentralTelemetryHanlder")
    @Produces({ MediaType.APPLICATION_JSON })
	/** Testing Central Telemetry Handler */
	public Response T4() {
		try {
			
			// Use Central Telemetry Handler Method
			final List<Cluster> clusters = ExtService.getClusters();
			for (Cluster cluster : clusters) {
				if (cluster.getName() == null || cluster.getName().trim().equals(""))
					continue;
				// Focus on k8s clusters
				if (!cluster.getType().equals("k8s")) 
					continue;
				System.out.println(cluster);
				// System.out.println(ExtService.getClusterData(cluster.getUuid()));
			}
			
			//TODO: Revise and Update so that we can collect data about a particular application
			
			// Prepare Response
			final Status respStatus = Response.Status.OK; 
			final MsgResponse errorResp = new MsgResponse("Success !");
			return Response.status(respStatus).entity(errorResp).build();	
		} catch (Throwable t) {
			t.printStackTrace();
			final Status respStatus = Response.Status.INTERNAL_SERVER_ERROR;
			final String respMsg = "Error: " + t.getClass().getName() + " , Message: " + t.getMessage();
			final MsgResponse errorResp = new MsgResponse(respMsg);
			return Response.status(respStatus).entity(errorResp).build();
		}
	}
	
}
