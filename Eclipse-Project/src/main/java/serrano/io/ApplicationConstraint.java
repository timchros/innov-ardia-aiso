package serrano.io;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationConstraint {
	private String component_id;
	@XmlAttribute(name="Usage_Demand_Total_Number_of_Users") 
	private String usage_Demand_Total_Number_of_Users;
	@XmlAttribute(name="Usage_Demand_Number_of_Concurrent_Users") 
	private String usage_Demand_Number_of_Concurrent_Users;
	@XmlAttribute(name="Usage_Demand_Total_Number_of_Requests")
	private String usage_Demand_Total_Number_of_Requests;      
	@XmlAttribute(name="Usage_Demand_Number_of_Concurrent_Requests")
	private String usage_Demand_Number_of_Concurrent_Requests;    
	@XmlAttribute(name="Usage_Demand_Number_of_Instances")
	private String usage_Demand_Number_of_Instances;
	@XmlAttribute(name="Service_Level_UpTime")
	private String service_Level_UpTime;
	@XmlAttribute(name="Service_Level_MeanTime_to_Recovery")
	private String service_Level_MeanTime_to_Recovery;
	@XmlAttribute(name="Service_Level_Reliability_Overall")
	private String service_Level_Reliability_Overall;
	@XmlAttribute(name="Service_Level_Failure_Rate")
	private String service_Level_Failure_Rate;
	@XmlAttribute(name="Service_Level_Error_Margin")
	private String service_Level_Error_Margin;
	@XmlAttribute(name="Service_Level_Confidence_Level")
	private String service_Level_Confidence_Level;
	@XmlAttribute(name="Application_Performance_Total_Execution_Time")
	private String application_Performance_Total_Execution_Time;      
	@XmlAttribute(name="Application_Performance_Response_Latency")
	private String application_Performance_Response_Latency;      
	@XmlAttribute(name="Application_Performance_GPU")
	private String application_Performance_GPU;      
	@XmlAttribute(name="Application_Performance_FPGA")
	private String application_Performance_FPGA;      
	@XmlAttribute(name="Application_Performance_Parallelization")
	private String application_Performance_Parallelization;      
	@XmlAttribute(name="Data_Storage_Data_Type")
	private String data_Storage_Data_Type;
	@XmlAttribute(name="Data_Storage_Volume")
	private String data_Storage_Volume;
	@XmlAttribute(name="Data_Storage_Latency")
	private String data_Storage_Latency;
	@XmlAttribute(name="Data_Retrieval_Latency")
	private String data_Retrieval_Latency;
	@XmlAttribute(name="Data_Storage_Duration")
	private String data_Storage_Duration;
	@XmlAttribute(name="Data_Storage_Period_of_Time")
	private String data_Storage_Period_of_Time;
	@XmlAttribute(name="Data_Storage_Proximity_to_User")
	private String data_Storage_Proximity_to_User;
	@XmlAttribute(name="Data_Storage_Geographical_Location")
	private String data_Storage_Geographical_Location;
	@XmlAttribute(name="Network_Upload_Bandwidth")
	private String network_Upload_Bandwidth;
	@XmlAttribute(name="Network_Download_Bandwidth")
	private String network_Download_Bandwidth;
	@XmlAttribute(name="Network_Latency")
	private String network_Latency;
	@XmlAttribute(name="Data_Transfer_Input_Data_Type")
	private String data_Transfer_Input_Data_Type;
	@XmlAttribute(name="Data_Transfer_Input_Data_Volume")
	private String data_Transfer_Input_Data_Volume;
	@XmlAttribute(name="Data_Transfer_Output_Data_Type")
	private String data_Transfer_Output_Data_Type;
	@XmlAttribute(name="Data_Transfer_Output_Data_Volume")
	private String data_Transfer_Output_Data_Volume;
	@XmlAttribute(name="Security_Data_Encryption_Parameters")
	private String security_Data_Encryption_Parameters;
	@XmlAttribute(name="Security_Data_Data_Encryption_Algorithm")
	private String security_Data_Data_Encryption_Algorithm;
	@XmlAttribute(name="Security_Erasure_Coding_Scheme")
	private String security_Erasure_Coding_Scheme;
	@XmlAttribute(name="Security_Erasure_Coding_Stripe_Size")
	private String security_Erasure_Coding_Stripe_Size;
	@XmlAttribute(name="Security_Erasure_Coding_Level_of_Redundancy")
	private String security_Erasure_Coding_Level_of_Redundancy;
	@XmlAttribute(name="Privacy_Data_Nature")
	private String privacy_Data_Nature;
	@XmlAttribute(name="Legal_Framework")
	private String legal_Framework;  
	@XmlAttribute(name="Energy_Consumption")
	private String energy_Consumption;
	@XmlAttribute(name="Overall_Cost")
	private String overall_Cost;
	@XmlAttribute(name="Data_Storage_Cost")
	private String data_Storage_Cost;
	@XmlAttribute(name="Data_Access_Cost")
	private String data_Access_Cost;
	@XmlAttribute(name="Deployment_Duration_Overall")
	private String deployment_Duration_Overall;
	@XmlAttribute(name="Deployment_Duration_Scheduling")
	private String deployment_Duration_Scheduling;
	@XmlAttribute(name="Technical_Details_Programming_Language")
	private String technical_Details_Programming_Language;
	@XmlAttribute(name="Technical_Details_Operating_System")
	private String technical_Details_Operating_System;
	@XmlAttribute(name="Technical_Details_Software_Environment")
	private String technical_Details_Software_Environment;
	@XmlAttribute(name="Technical_Details_Software_Dependencies")
	private List<String> technical_Details_Software_Dependencies;
	
	private String app_metadata;
	private String runtime_isolation;
	private String runtime_encryption;
	private String runtime_spawn_time;
	
	public String getComponent_id() {
		return component_id;
	}
	public void setComponent_id(String component_id) {
		this.component_id = component_id;
	}
	
	public String getApp_metadata() {
		return app_metadata;
	}
	public void setApp_metadata(String app_metadata) {
		this.app_metadata = app_metadata;
	}
	
	public String getUsage_Demand_Total_Number_of_Users() {
		return usage_Demand_Total_Number_of_Users;
	}
	public void setUsage_Demand_Total_Number_of_Users(String usage_Demand_Total_Number_of_Users) {
		this.usage_Demand_Total_Number_of_Users = usage_Demand_Total_Number_of_Users;
	}
	public String getUsage_Demand_Number_of_Concurrent_Users() {
		return usage_Demand_Number_of_Concurrent_Users;
	}
	public void setUsage_Demand_Number_of_Concurrent_Users(String usage_Demand_Number_of_Concurrent_Users) {
		this.usage_Demand_Number_of_Concurrent_Users = usage_Demand_Number_of_Concurrent_Users;
	}
	public String getUsage_Demand_Total_Number_of_Requests() {
		return usage_Demand_Total_Number_of_Requests;
	}
	public void setUsage_Demand_Total_Number_of_Requests(String usage_Demand_Total_Number_of_Requests) {
		this.usage_Demand_Total_Number_of_Requests = usage_Demand_Total_Number_of_Requests;
	}
	public String getUsage_Demand_Number_of_Concurrent_Requests() {
		return usage_Demand_Number_of_Concurrent_Requests;
	}
	public void setUsage_Demand_Number_of_Concurrent_Requests(String usage_Demand_Number_of_Concurrent_Requests) {
		this.usage_Demand_Number_of_Concurrent_Requests = usage_Demand_Number_of_Concurrent_Requests;
	}
	public String getUsage_Demand_Number_of_Instances() {
		return usage_Demand_Number_of_Instances;
	}
	public void setUsage_Demand_Number_of_Instances(String usage_Demand_Number_of_Instances) {
		this.usage_Demand_Number_of_Instances = usage_Demand_Number_of_Instances;
	}
	public String getService_Level_UpTime() {
		return service_Level_UpTime;
	}
	public void setService_Level_UpTime(String service_Level_UpTime) {
		this.service_Level_UpTime = service_Level_UpTime;
	}
	public String getService_Level_MeanTime_to_Recovery() {
		return service_Level_MeanTime_to_Recovery;
	}
	public void setService_Level_MeanTime_to_Recovery(String service_Level_MeanTime_to_Recovery) {
		this.service_Level_MeanTime_to_Recovery = service_Level_MeanTime_to_Recovery;
	}
	public String getService_Level_Reliability_Overall() {
		return service_Level_Reliability_Overall;
	}
	public void setService_Level_Reliability_Overall(String service_Level_Reliability_Overall) {
		this.service_Level_Reliability_Overall = service_Level_Reliability_Overall;
	}
	public String getService_Level_Failure_Rate() {
		return service_Level_Failure_Rate;
	}
	public void setService_Level_Failure_Rate(String service_Level_Failure_Rate) {
		this.service_Level_Failure_Rate = service_Level_Failure_Rate;
	}
	public String getService_Level_Error_Margin() {
		return service_Level_Error_Margin;
	}
	public void setService_Level_Error_Margin(String service_Level_Error_Margin) {
		this.service_Level_Error_Margin = service_Level_Error_Margin;
	}
	public String getService_Level_Confidence_Level() {
		return service_Level_Confidence_Level;
	}
	public void setService_Level_Confidence_Level(String service_Level_Confidence_Level) {
		this.service_Level_Confidence_Level = service_Level_Confidence_Level;
	}
	public String getApplication_Performance_Total_Execution_Time() {
		return application_Performance_Total_Execution_Time;
	}
	public void setApplication_Performance_Total_Execution_Time(String application_Performance_Total_Execution_Time) {
		this.application_Performance_Total_Execution_Time = application_Performance_Total_Execution_Time;
	}
	public String getApplication_Performance_Response_Latency() {
		return application_Performance_Response_Latency;
	}
	public void setApplication_Performance_Response_Latency(String application_Performance_Response_Latency) {
		this.application_Performance_Response_Latency = application_Performance_Response_Latency;
	}
	public String getApplication_Performance_GPU() {
		return application_Performance_GPU;
	}
	public void setApplication_Performance_GPU(String application_Performance_GPU) {
		this.application_Performance_GPU = application_Performance_GPU;
	}
	public String getApplication_Performance_FPGA() {
		return application_Performance_FPGA;
	}
	public void setApplication_Performance_FPGA(String application_Performance_FPGA) {
		this.application_Performance_FPGA = application_Performance_FPGA;
	}
	public String getApplication_Performance_Parallelization() {
		return application_Performance_Parallelization;
	}
	public void setApplication_Performance_Parallelization(String application_Performance_Parallelization) {
		this.application_Performance_Parallelization = application_Performance_Parallelization;
	}
	public String getData_Storage_Data_Type() {
		return data_Storage_Data_Type;
	}
	public void setData_Storage_Data_Type(String data_Storage_Data_Type) {
		this.data_Storage_Data_Type = data_Storage_Data_Type;
	}
	public String getData_Storage_Volume() {
		return data_Storage_Volume;
	}
	public void setData_Storage_Volume(String data_Storage_Volume) {
		this.data_Storage_Volume = data_Storage_Volume;
	}
	public String getData_Storage_Latency() {
		return data_Storage_Latency;
	}
	public void setData_Storage_Latency(String data_Storage_Latency) {
		this.data_Storage_Latency = data_Storage_Latency;
	}
	public String getData_Retrieval_Latency() {
		return data_Retrieval_Latency;
	}
	public void setData_Retrieval_Latency(String data_Retrieval_Latency) {
		this.data_Retrieval_Latency = data_Retrieval_Latency;
	}
	public String getData_Storage_Duration() {
		return data_Storage_Duration;
	}
	public void setData_Storage_Duration(String data_Storage_Duration) {
		this.data_Storage_Duration = data_Storage_Duration;
	}
	public String getData_Storage_Period_of_Time() {
		return data_Storage_Period_of_Time;
	}
	public void setData_Storage_Period_of_Time(String data_Storage_Period_of_Time) {
		this.data_Storage_Period_of_Time = data_Storage_Period_of_Time;
	}
	public String getData_Storage_Proximity_to_User() {
		return data_Storage_Proximity_to_User;
	}
	public void setData_Storage_Proximity_to_User(String data_Storage_Proximity_to_User) {
		this.data_Storage_Proximity_to_User = data_Storage_Proximity_to_User;
	}
	public String getData_Storage_Geographical_Location() {
		return data_Storage_Geographical_Location;
	}
	public void setData_Storage_Geographical_Location(String data_Storage_Geographical_Location) {
		this.data_Storage_Geographical_Location = data_Storage_Geographical_Location;
	}
	public String getNetwork_Upload_Bandwidth() {
		return network_Upload_Bandwidth;
	}
	public void setNetwork_Upload_Bandwidth(String network_Upload_Bandwidth) {
		this.network_Upload_Bandwidth = network_Upload_Bandwidth;
	}
	public String getNetwork_Download_Bandwidth() {
		return network_Download_Bandwidth;
	}
	public void setNetwork_Download_Bandwidth(String network_Download_Bandwidth) {
		this.network_Download_Bandwidth = network_Download_Bandwidth;
	}
	public String getNetwork_Latency() {
		return network_Latency;
	}
	public void setNetwork_Latency(String network_Latency) {
		this.network_Latency = network_Latency;
	}
	public String getData_Transfer_Input_Data_Type() {
		return data_Transfer_Input_Data_Type;
	}
	public void setData_Transfer_Input_Data_Type(String data_Transfer_Input_Data_Type) {
		this.data_Transfer_Input_Data_Type = data_Transfer_Input_Data_Type;
	}
	public String getData_Transfer_Input_Data_Volume() {
		return data_Transfer_Input_Data_Volume;
	}
	public void setData_Transfer_Input_Data_Volume(String data_Transfer_Input_Data_Volume) {
		this.data_Transfer_Input_Data_Volume = data_Transfer_Input_Data_Volume;
	}
	public String getData_Transfer_Output_Data_Type() {
		return data_Transfer_Output_Data_Type;
	}
	public void setData_Transfer_Output_Data_Type(String data_Transfer_Output_Data_Type) {
		this.data_Transfer_Output_Data_Type = data_Transfer_Output_Data_Type;
	}
	public String getData_Transfer_Output_Data_Volume() {
		return data_Transfer_Output_Data_Volume;
	}
	public void setData_Transfer_Output_Data_Volume(String data_Transfer_Output_Data_Volume) {
		this.data_Transfer_Output_Data_Volume = data_Transfer_Output_Data_Volume;
	}
	public String getSecurity_Data_Encryption_Parameters() {
		return security_Data_Encryption_Parameters;
	}
	public void setSecurity_Data_Encryption_Parameters(String security_Data_Encryption_Parameters) {
		this.security_Data_Encryption_Parameters = security_Data_Encryption_Parameters;
	}
	public String getSecurity_Data_Data_Encryption_Algorithm() {
		return security_Data_Data_Encryption_Algorithm;
	}
	public void setSecurity_Data_Data_Encryption_Algorithm(String security_Data_Data_Encryption_Algorithm) {
		this.security_Data_Data_Encryption_Algorithm = security_Data_Data_Encryption_Algorithm;
	}
	public String getSecurity_Erasure_Coding_Scheme() {
		return security_Erasure_Coding_Scheme;
	}
	public void setSecurity_Erasure_Coding_Scheme(String security_Erasure_Coding_Scheme) {
		this.security_Erasure_Coding_Scheme = security_Erasure_Coding_Scheme;
	}
	public String getSecurity_Erasure_Coding_Stripe_Size() {
		return security_Erasure_Coding_Stripe_Size;
	}
	public void setSecurity_Erasure_Coding_Stripe_Size(String security_Erasure_Coding_Stripe_Size) {
		this.security_Erasure_Coding_Stripe_Size = security_Erasure_Coding_Stripe_Size;
	}
	public String getSecurity_Erasure_Coding_Level_of_Redundancy() {
		return security_Erasure_Coding_Level_of_Redundancy;
	}
	public void setSecurity_Erasure_Coding_Level_of_Redundancy(String security_Erasure_Coding_Level_of_Redundancy) {
		this.security_Erasure_Coding_Level_of_Redundancy = security_Erasure_Coding_Level_of_Redundancy;
	}
	public String getPrivacy_Data_Nature() {
		return privacy_Data_Nature;
	}
	public void setPrivacy_Data_Nature(String privacy_Data_Nature) {
		this.privacy_Data_Nature = privacy_Data_Nature;
	}
	public String getLegal_Framework() {
		return legal_Framework;
	}
	public void setLegal_Framework(String legal_Framework) {
		this.legal_Framework = legal_Framework;
	}
	public String getEnergy_Consumption() {
		return energy_Consumption;
	}
	public void setEnergy_Consumption(String energy_Consumption) {
		this.energy_Consumption = energy_Consumption;
	}
	public String getOverall_Cost() {
		return overall_Cost;
	}
	public void setOverall_Cost(String overall_Cost) {
		this.overall_Cost = overall_Cost;
	}
	public String getData_Storage_Cost() {
		return data_Storage_Cost;
	}
	public void setData_Storage_Cost(String data_Storage_Cost) {
		this.data_Storage_Cost = data_Storage_Cost;
	}
	public String getData_Access_Cost() {
		return data_Access_Cost;
	}
	public void setData_Access_Cost(String data_Access_Cost) {
		this.data_Access_Cost = data_Access_Cost;
	}
	public String getDeployment_Duration_Overall() {
		return deployment_Duration_Overall;
	}
	public void setDeployment_Duration_Overall(String deployment_Duration_Overall) {
		this.deployment_Duration_Overall = deployment_Duration_Overall;
	}
	public String getDeployment_Duration_Scheduling() {
		return deployment_Duration_Scheduling;
	}
	public void setDeployment_Duration_Scheduling(String deployment_Duration_Scheduling) {
		this.deployment_Duration_Scheduling = deployment_Duration_Scheduling;
	}
	public String getTechnical_Details_Programming_Language() {
		return technical_Details_Programming_Language;
	}
	public void setTechnical_Details_Programming_Language(String technical_Details_Programming_Language) {
		this.technical_Details_Programming_Language = technical_Details_Programming_Language;
	}
	public String getTechnical_Details_Operating_System() {
		return technical_Details_Operating_System;
	}
	public void setTechnical_Details_Operating_System(String technical_Details_Operating_System) {
		this.technical_Details_Operating_System = technical_Details_Operating_System;
	}
	public String getTechnical_Details_Software_Environment() {
		return technical_Details_Software_Environment;
	}
	public void setTechnical_Details_Software_Environment(String technical_Details_Software_Environment) {
		this.technical_Details_Software_Environment = technical_Details_Software_Environment;
	}
	public List<String> getTechnical_Details_Software_Dependencies() {
		return technical_Details_Software_Dependencies;
	}
	public void setTechnical_Details_Software_Dependencies(List<String> technical_Details_Software_Dependencies) {
		this.technical_Details_Software_Dependencies = technical_Details_Software_Dependencies;
	}
	public String getRuntime_isolation() {
		return runtime_isolation;
	}
	public void setRuntime_isolation(String runtime_isolation) {
		this.runtime_isolation = runtime_isolation;
	}
	public String getRuntime_encryption() {
		return runtime_encryption;
	}
	public void setRuntime_encryption(String runtime_encryption) {
		this.runtime_encryption = runtime_encryption;
	}
	public String getRuntime_spawn_time() {
		return runtime_spawn_time;
	}
	public void setRuntime_spawn_time(String runtime_spawn_time) {
		this.runtime_spawn_time = runtime_spawn_time;
	}
	
//	@Override
//	public String toString() {
//		return "ApplicationConstraint [component_id=" + component_id + ", usage_Demand_Total_Number_of_Users="
//				+ usage_Demand_Total_Number_of_Users + ", usage_Demand_Number_of_Concurrent_Users="
//				+ usage_Demand_Number_of_Concurrent_Users + ", usage_Demand_Total_Number_of_Requests="
//				+ usage_Demand_Total_Number_of_Requests + ", usage_Demand_Number_of_Concurrent_Requests="
//				+ usage_Demand_Number_of_Concurrent_Requests + ", usage_Demand_Number_of_Instances="
//				+ usage_Demand_Number_of_Instances + ", service_Level_UpTime=" + service_Level_UpTime
//				+ ", service_Level_MeanTime_to_Recovery=" + service_Level_MeanTime_to_Recovery
//				+ ", service_Level_Reliability_Overall=" + service_Level_Reliability_Overall
//				+ ", service_Level_Failure_Rate=" + service_Level_Failure_Rate + ", service_Level_Error_Margin="
//				+ service_Level_Error_Margin + ", service_Level_Confidence_Level=" + service_Level_Confidence_Level
//				+ ", application_Performance_Total_Execution_Time=" + application_Performance_Total_Execution_Time
//				+ ", application_Performance_Response_Latency=" + application_Performance_Response_Latency
//				+ ", application_Performance_GPU=" + application_Performance_GPU + ", application_Performance_FPGA="
//				+ application_Performance_FPGA + ", application_Performance_Parallelization="
//				+ application_Performance_Parallelization + ", data_Storage_Data_Type=" + data_Storage_Data_Type
//				+ ", data_Storage_Volume=" + data_Storage_Volume + ", data_Storage_Latency=" + data_Storage_Latency
//				+ ", data_Retrieval_Latency=" + data_Retrieval_Latency + ", data_Storage_Duration="
//				+ data_Storage_Duration + ", data_Storage_Period_of_Time=" + data_Storage_Period_of_Time
//				+ ", data_Storage_Proximity_to_User=" + data_Storage_Proximity_to_User
//				+ ", data_Storage_Geographical_Location=" + data_Storage_Geographical_Location
//				+ ", network_Upload_Bandwidth=" + network_Upload_Bandwidth + ", network_Download_Bandwidth="
//				+ network_Download_Bandwidth + ", network_Latency=" + network_Latency
//				+ ", data_Transfer_Input_Data_Type=" + data_Transfer_Input_Data_Type
//				+ ", data_Transfer_Input_Data_Volume=" + data_Transfer_Input_Data_Volume
//				+ ", data_Transfer_Output_Data_Type=" + data_Transfer_Output_Data_Type
//				+ ", data_Transfer_Output_Data_Volume=" + data_Transfer_Output_Data_Volume
//				+ ", security_Data_Encryption_Parameters=" + security_Data_Encryption_Parameters
//				+ ", security_Data_Data_Encryption_Algorithm=" + security_Data_Data_Encryption_Algorithm
//				+ ", security_Erasure_Coding_Scheme=" + security_Erasure_Coding_Scheme
//				+ ", security_Erasure_Coding_Stripe_Size=" + security_Erasure_Coding_Stripe_Size
//				+ ", security_Erasure_Coding_Level_of_Redundancy=" + security_Erasure_Coding_Level_of_Redundancy
//				+ ", privacy_Data_Nature=" + privacy_Data_Nature + ", legal_Framework=" + legal_Framework
//				+ ", energy_Consumption=" + energy_Consumption + ", overall_Cost=" + overall_Cost
//				+ ", data_Storage_Cost=" + data_Storage_Cost + ", data_Access_Cost=" + data_Access_Cost
//				+ ", deployment_Duration_Overall=" + deployment_Duration_Overall + ", deployment_Duration_Scheduling="
//				+ deployment_Duration_Scheduling + ", technical_Details_Programming_Language="
//				+ technical_Details_Programming_Language + ", technical_Details_Operating_System="
//				+ technical_Details_Operating_System + ", technical_Details_Software_Environment="
//				+ technical_Details_Software_Environment + ", technical_Details_Software_Dependencies="
//				+ technical_Details_Software_Dependencies + ", runtime_isolation=" + runtime_isolation
//				+ ", runtime_encryption=" + runtime_encryption + ", runtime_spawn_time=" + runtime_spawn_time + "]";
//	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("component_id=" + component_id);
		if (usage_Demand_Total_Number_of_Users != null) sb.append(" , usage_Demand_Total_Number_of_Users=" + usage_Demand_Total_Number_of_Users);
		if (usage_Demand_Number_of_Concurrent_Users != null) sb.append(" , usage_Demand_Number_of_Concurrent_Users=" + usage_Demand_Number_of_Concurrent_Users);
		if (usage_Demand_Total_Number_of_Requests != null) sb.append(" , usage_Demand_Total_Number_of_Requests=" + usage_Demand_Total_Number_of_Requests);
		if (usage_Demand_Number_of_Concurrent_Requests != null) sb.append(" , usage_Demand_Number_of_Concurrent_Requests=" + usage_Demand_Number_of_Concurrent_Requests);
		if (usage_Demand_Number_of_Instances != null) sb.append(" , usage_Demand_Number_of_Instances=" + usage_Demand_Number_of_Instances);
		if (service_Level_UpTime != null) sb.append(" , service_Level_UpTime=" + service_Level_UpTime);
		if (service_Level_MeanTime_to_Recovery != null) sb.append(" , service_Level_MeanTime_to_Recovery=" + service_Level_MeanTime_to_Recovery);
		if (service_Level_Reliability_Overall != null) sb.append(" , service_Level_Reliability_Overall=" + service_Level_Reliability_Overall);
		if (service_Level_Failure_Rate != null) sb.append(" , service_Level_Failure_Rate=" + service_Level_Failure_Rate);
		if (service_Level_Error_Margin != null) sb.append(" , service_Level_Error_Margin=" + service_Level_Error_Margin);
		if (service_Level_Confidence_Level != null) sb.append(" , service_Level_Confidence_Level=" + service_Level_Confidence_Level);
		if (application_Performance_Total_Execution_Time != null) sb.append(" , application_Performance_Total_Execution_Time=" + application_Performance_Total_Execution_Time);
		if (application_Performance_Response_Latency != null) sb.append(" , application_Performance_Response_Latency=" + application_Performance_Response_Latency);
		if (application_Performance_GPU != null) sb.append(" , application_Performance_GPU=" + application_Performance_GPU);
		if (application_Performance_FPGA != null) sb.append(" , application_Performance_FPGA=" + application_Performance_FPGA);
		if (application_Performance_Parallelization != null) sb.append(" , application_Performance_Parallelization=" + application_Performance_Parallelization);
		if (data_Storage_Data_Type != null) sb.append(" , data_Storage_Data_Type=" + data_Storage_Data_Type);
		if (data_Storage_Volume != null) sb.append(" , data_Storage_Volume=" + data_Storage_Volume);
		if (data_Storage_Latency != null) sb.append(" , data_Storage_Latency=" + data_Storage_Latency);
		if (data_Retrieval_Latency != null) sb.append(" , data_Retrieval_Latency=" + data_Retrieval_Latency);
		if (data_Storage_Duration != null) sb.append(" , data_Storage_Duration=" + data_Storage_Duration);
		if (data_Storage_Period_of_Time != null) sb.append(" , data_Storage_Period_of_Time=" + data_Storage_Period_of_Time);
		if (data_Storage_Proximity_to_User != null) sb.append(" , data_Storage_Proximity_to_User=" + data_Storage_Proximity_to_User);
		if (data_Storage_Geographical_Location != null) sb.append(" , data_Storage_Geographical_Location=" + data_Storage_Geographical_Location);
		if (network_Download_Bandwidth != null) sb.append(" , network_Download_Bandwidth=" + network_Download_Bandwidth);
		if (network_Latency != null) sb.append(" , network_Latency=" + network_Latency);
		if (data_Transfer_Input_Data_Type != null) sb.append(" , data_Transfer_Input_Data_Type=" + data_Transfer_Input_Data_Type);
		if (data_Transfer_Input_Data_Volume != null) sb.append(" , data_Transfer_Input_Data_Volume=" + data_Transfer_Input_Data_Volume);
		if (data_Transfer_Output_Data_Type != null) sb.append(" , data_Transfer_Output_Data_Type=" + data_Transfer_Output_Data_Type);
		if (data_Transfer_Output_Data_Volume != null) sb.append(" , data_Transfer_Output_Data_Volume=" + data_Transfer_Output_Data_Volume);
		if (security_Data_Encryption_Parameters != null) sb.append(" , security_Data_Encryption_Parameters=" + security_Data_Encryption_Parameters);
		if (security_Data_Data_Encryption_Algorithm != null) sb.append(" , security_Data_Data_Encryption_Algorithm=" + security_Data_Data_Encryption_Algorithm);
		if (security_Erasure_Coding_Scheme != null) sb.append(" , security_Erasure_Coding_Scheme=" + security_Erasure_Coding_Scheme);
		if (security_Erasure_Coding_Stripe_Size != null) sb.append(" , security_Erasure_Coding_Stripe_Size=" + security_Erasure_Coding_Stripe_Size);
		if (security_Erasure_Coding_Level_of_Redundancy != null) sb.append(" , security_Erasure_Coding_Level_of_Redundancy=" + security_Erasure_Coding_Level_of_Redundancy);
		if (privacy_Data_Nature != null) sb.append(" , privacy_Data_Nature=" + privacy_Data_Nature);
		if (legal_Framework != null) sb.append(" , legal_Framework=" + legal_Framework);
		if (energy_Consumption != null) sb.append(" , energy_Consumption=" + energy_Consumption);
		if (overall_Cost != null) sb.append(" , overall_Cost=" + overall_Cost);
		if (data_Storage_Cost != null) sb.append(" , data_Storage_Cost=" + data_Storage_Cost);
		if (data_Access_Cost != null) sb.append(" , data_Access_Cost=" + data_Access_Cost);
		if (deployment_Duration_Overall != null) sb.append(" , deployment_Duration_Overall=" + deployment_Duration_Overall);
		if (deployment_Duration_Scheduling != null) sb.append(" , deployment_Duration_Scheduling=" + deployment_Duration_Scheduling);
		if (technical_Details_Programming_Language != null) sb.append(" , technical_Details_Programming_Language=" + technical_Details_Programming_Language);
		if (technical_Details_Operating_System != null) sb.append(" , technical_Details_Operating_System=" + technical_Details_Operating_System);
		if (technical_Details_Software_Environment != null) sb.append(" , technical_Details_Software_Environment=" + technical_Details_Software_Environment);
		if (technical_Details_Software_Dependencies != null) sb.append(" , technical_Details_Software_Dependencies=" + technical_Details_Software_Dependencies);
		if (runtime_isolation != null) sb.append(" , runtime_isolation=" + runtime_isolation);
		if (runtime_encryption != null) sb.append(" , runtime_encryption=" + runtime_encryption);
		if (runtime_spawn_time != null) sb.append(" , runtime_spawn_time=" + runtime_spawn_time);
		
		return "{ " + sb.toString() + " }";
	}
	
}
