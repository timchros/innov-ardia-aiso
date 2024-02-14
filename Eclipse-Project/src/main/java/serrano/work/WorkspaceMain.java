package serrano.work;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import serrano.TestingPlace;
import serrano.io.Service_Input;

public class WorkspaceMain {

	public static void main(String[] args) throws Exception {

		System.out.println("Start Testing ... ");
		
		// Unmarshal JSON to Java Object
		
//		final String inputJsonFilePath = 
//			"C:/Users/Efthymis/Desktop/AISO-Notebook/JSON/json-for-testing-purposes.json";
//		
//		final File inputJsonFile = new File(inputJsonFilePath);
//		
//		JAXBContext  jaxbContext = JAXBContext.newInstance(Service_Input.class);
		
//		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//		jaxbUnmarshaller.setProperty("MEDIA_TYPE", "application/json");
//		jaxbUnmarshaller.setProperty("JSON_INCLUDE_ROOT", true);
//
//		Service_Input employee = (Service_Input) jaxbUnmarshaller.unmarshal(inputJsonFile);
//		System.out.println(employee);
		
//		Service_Input input = TestingPlace.createTestServiceInput();
//		System.out.println(input);
		
//		Marshaller marshaller = jaxbContext.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.setProperty("MEDIA_TYPE", "application/json");
//        marshaller.setProperty("JSON_INCLUDE_ROOT", false);
//        marshaller.marshal(input, System.out);
		
		// Implement part of the algorithm in paper
		
		// Search in the input JSON about parameters regarding some key elements (i.e., the ones matchining  with the output of a mapping rule)
		// Examine different source combinations and select the one that the output matches with the restriction specified 

//		new MappingRule("No_Data_Batches", "Execution_Time") {
//			@Override public Object processSourceData(Object... objs) {
//				if (objs == null || objs.length != 1 || (objs[0] instanceof Double))
//					throw new RuntimeException("Inappropriate values: " + objs);
//				//TODO: ensure x is in range [0, 300]
//				final Double x = (Double) objs[0];
//				final Double y = 0.9490254545453354 + 0.6203083216783223 * x + 0.0024189429800968265 * Math.pow(x, 2);
//				return y;
//			}
//		};
//		
		
		// Cases: Execution_Time LOW , Execution Time HIGH, Execution Time < 100 , Execution_Time > 100
		
		System.out.println("End Testing ...");
		
	}

}
