package serrano;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.core.Response;

import serrano.io.AppManagInput;
import serrano.io.ApplicationConstraint;
import serrano.io.Service_DeployScenarios_Output;
import serrano.io.Service_Input;

public class TestingPlace {

	/** For testing purposes ... */
	public static void main(String[] args) {

		System.out.println("TestingPlace - Process STARTED at " + new Date());
		System.out.println();
		
//		final String date_pattern = "yyyy/MM/dd-HH:mm:ss.SSS";
//		final DateFormat df = new SimpleDateFormat(date_pattern);
//		final String dtstr = df.format(new Date());
//		System.out.println(dtstr);
//		
//		// Available Services
//		final Response mainresp = new Service().main();
//		System.out.println(mainresp.getStatus() + " : " + mainresp.getEntity() + "\n");
//		
//		// Benchmarking DB init
//		final Response t0resp = new Service().T0();
//		System.out.println("\n" + t0resp.getStatus() + " : " + t0resp.getEntity() + "\n");
		
		// Create Possible Deployment Scenarios
		//final Service_Input testInput = createTest1ServiceInput(1); //createTest3ServiceInput(); //createTest1ServiceInput(1); //createTest2ServiceInput();
		
		final Service_Input testInput = createTest5ServiceInput();
		//System.out.println("INPUT:\n" + testInput.asString() + "\n");
		final Response t1resp = new Service().T1(testInput);
		System.out.println("\n" + t1resp.getStatus() + " : " + t1resp.getEntity() + "\n");
		final Service_DeployScenarios_Output testOutput = (Service_DeployScenarios_Output) t1resp.getEntity();
		//System.out.println("\nOUTPUT:\n" + testOutput.asString());
		
		
		
//		// Create Possible Deployment Scenarios and Deploy Application through Resource Orchestrator
//		final Response t2resp = new Service().T2(createTestServiceInput());
//		System.out.println("\n" + t2resp.getStatus() + " : " + t2resp.getEntity() + "\n");
//		
//		// Application Management
//		final Response t3resp = new Service().T3(createTestAppManagInput());
//		System.out.println("\n" + t3resp.getStatus() + " : " + t3resp.getEntity() + "\n");
//		
//		// Testing Central Telemetry Handler
//		final Response t4resp = new Service().T4();
//		System.out.println("\n" + t4resp.getStatus() + " : " + t4resp.getEntity() + "\n");
		
		
//		// Directly Invoke Resource Orchestrator for testing purposes
//		final Response tro = new Service().testResourceOrchestrator();
//		System.out.println("\n" + tro.getStatus() + " : " + tro.getEntity() + "\n");
		
		System.out.println();
		System.out.println("TestingPlace - Process FINISHED at " + new Date());
	}

	// TODO: Add UC specific parameters / constraints / indicators
	// e.g. UC3 Acceleration - Classifier Training 
	// No Data Batches vs Execution Time 
	// In case of UC3 / Acceleration / Classifier Training 
	// When Execution Time should be less than 200 (ms) ?
	// Then either use Edge Device with Number of Batches e.g. 150 or less
	// or use an HPC
	// so in the response we need 
	// a field about component name/id and another field about uc-component specific parameters
	
	public static Service_Input createTest1ServiceInput(int index) {
		final  Service_Input input = new Service_Input();
		input.setUser_id("u123");
		input.setDeployment_descriptor_yaml("given-YAML");
		input.setApplication_constraints(new ArrayList<ApplicationConstraint>());
		final ApplicationConstraint appcon = new ApplicationConstraint();
		appcon.setData_Storage_Volume("> 5 GB");
//		appcon.setRuntime_isolation("YES");
		
		appcon.setComponent_id("acceleration-service-classifier-training");
		if (index == 1) {
			appcon.setApplication_Performance_Total_Execution_Time("LOW");
		} else {
			appcon.setApplication_Performance_Total_Execution_Time("</= 200 ms");
		}
		input.getApplication_constraints().add(appcon);
		return input;
	}
	
	public static Service_Input createTest2ServiceInput() {
		final  Service_Input input = new Service_Input();
		input.setUser_id("u123");
		input.setDeployment_descriptor_yaml("given-YAML");
		input.setApplication_constraints(new ArrayList<ApplicationConstraint>());
		final ApplicationConstraint appcon = new ApplicationConstraint();
		appcon.setData_Storage_Volume("> 5 GB");
//		appcon.setRuntime_isolation("YES");
		
		appcon.setComponent_id("analyse_market");
		//appcon.setApplication_Performance_Total_Execution_Time("LOW");
		appcon.setApp_metadata("kalman");
		appcon.setEnergy_Consumption("LOW");
		
		input.getApplication_constraints().add(appcon);
		return input;
	}
	
	public static Service_Input createTest3ServiceInput() {
		final  Service_Input input = new Service_Input();
		input.setUser_id("u123");
		input.setDeployment_descriptor_yaml("given-YAML");
		input.setApplication_constraints(new ArrayList<ApplicationConstraint>());
		final ApplicationConstraint appcon = new ApplicationConstraint();
		appcon.setData_Storage_Volume("> 5 GB");
		appcon.setRuntime_isolation("YES");
		appcon.setRuntime_encryption("YES");
		input.getApplication_constraints().add(appcon);
		return input;
	}
	
	public static Service_Input createTest4ServiceInput() {
		final  Service_Input input = new Service_Input();
		input.setUser_id("SerranoOrchestratorPlugin");
		input.setDeployment_descriptor_yaml("given-YAML");
		input.setApplication_constraints(new ArrayList<ApplicationConstraint>());
		// 1
		final ApplicationConstraint appcon1 = new ApplicationConstraint();
		appcon1.setComponent_id("faaspositionclassifiertrainer");
		appcon1.setService_Level_UpTime(">/= 97 %");
		appcon1.setApplication_Performance_Total_Execution_Time("</= LOW ms");
		input.getApplication_constraints().add(appcon1);
		// 2
		final ApplicationConstraint appcon2 = new ApplicationConstraint();
		appcon2.setComponent_id("faaspositioninference");
		appcon2.setService_Level_Error_Margin("</= 3 %");
		appcon2.setService_Level_UpTime(">/= 97 %");
		appcon2.setEnergy_Consumption("MEDIUM");
		input.getApplication_constraints().add(appcon2);
		// 3
		final ApplicationConstraint appcon3 = new ApplicationConstraint();
		appcon3.setComponent_id("positiondatamanager");
		appcon3.setOverall_Cost("LOW");
		input.getApplication_constraints().add(appcon3);
		return input;
	}	
	
	public static Service_Input createTest5ServiceInput() {
		final  Service_Input input = new Service_Input();
		input.setUser_id("SerranoOrchestratorPlugin");
		input.setDeployment_descriptor_yaml("given-YAML");
		input.setApplication_constraints(new ArrayList<ApplicationConstraint>());
		// 1
		final ApplicationConstraint appcon1 = new ApplicationConstraint();
		appcon1.setComponent_id("faaspositionclassifiertrainer");
		appcon1.setApplication_Performance_Response_Latency("LOW");
		input.getApplication_constraints().add(appcon1);
		return input;
	}	
	
	
	public static AppManagInput createTestAppManagInput() {
		final AppManagInput input =  new AppManagInput();
		input.setAction("STATUS");
		input.setAppid("ap123");
		return input;
	}
	
}
